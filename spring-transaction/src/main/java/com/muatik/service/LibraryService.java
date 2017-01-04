package com.muatik.service;

import com.muatik.model.Author;
import com.muatik.model.Book;
import com.muatik.model.PollOption;
import com.muatik.repository.AuthorRepository;
import com.muatik.repository.BookRepository;
import com.muatik.repository.PollRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by mustafaatik on 03/01/17.
 */
@Service
public class LibraryService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PollRepository pollRepository;

    @Transactional
    public Author add() {
        Book book1 = new Book();
        book1.setTitle("book1");
        bookRepository.save(book1);

        Author author1 = new Author();
        author1.setName("author1");
        author1.getBooks().add(book1);
        authorRepository.save(author1);

        // due to this exception, the operations above will not be persistent.
        throw new RuntimeException("nothing has been saved.");
    }

    public Author add_anyway() {
        Book book1 = new Book();
        book1.setTitle("book1");
        bookRepository.save(book1);

        Author author1 = new Author();
        author1.setName("author1");
        author1.getBooks().add(book1);
        authorRepository.save(author1);
        throw new RuntimeException("this error is thrown intentionally to test transaction. " +
                "however book and author have been saved.");
    }

    private void do_voting(String tag, long sleep) {
        logger.info(tag + " - starts voting. Thread id: " + Thread.currentThread().getId() + ", " + Thread.activeCount());
        PollOption option = pollRepository.findOne(1l);
        logger.info(tag + " - poll vote value: " + option.getVotes());

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        option.increase();
        pollRepository.save(option);
        logger.info(tag + " - final poll vote value: " + option.getVotes());
    }

    /**
     * the following implementation does not guarantee race-condition prevention.
     * if there are two invocations for this method, read-modify-write process might
     * be interleaved from another thread/invocation. So, it is possible to end up with
     * the same value after all. As you can see, @Transactional does not have any
     * intention or ability to prevent this kind of race-condition.
     * <p>
     * Example: vote("1.voter", 3000); vote("2.voter", 1000);
     * Output:
     * 2017-01-04 12:06:51.138 : 1.voter - starts voting. Thread id: 34, 18
     * 2017-01-04 12:06:51.144 : 1.voter - poll vote value: 38
     * 2017-01-04 12:06:51.654 : 2.voter - starts voting. Thread id: 35, 19
     * 2017-01-04 12:06:51.658 : 2.voter - poll vote value: 38
     * 2017-01-04 12:06:52.663 : 2.voter - final poll vote value: 39
     * 2017-01-04 12:06:54.149 : 1.voter - final poll vote value: 39
     *
     * @param tag
     * @param sleep
     */
    @Transactional
    public void vote(String tag, long sleep) {
        do_voting(tag, sleep);
    }


    /**
     * the following implementation does not guarantee race-condition prevention.
     * if there are two invocations for this method, read-modify-write process might
     * be interleaved from another thread/invocation. So, it is possible to end up with
     * the same value after all. As you can see, @Transactional does not have any
     * intention or ability to prevent this kind of race-condition.
     * <p>
     * Example: vote2("1.voter", 3000); vote2("2.voter", 1000);
     * Output:
     * 2017-01-04 12:13:25.450 : 1.voter - starts voting. Thread id: 27, 13
     * Hibernate: select polloption0_.id as id1_3_0_, polloption0_.votes as votes2_3_0_ from poll_option polloption0_ where polloption0_.id=?
     * 2017-01-04 12:13:25.540 : 1.voter - poll vote value: 39
     * 2017-01-04 12:13:28.559 : 1.voter - final poll vote value: 40
     * 2017-01-04 12:13:28.560 : 2.voter - starts voting. Thread id: 28, 12
     * Hibernate: select polloption0_.id as id1_3_0_, polloption0_.votes as votes2_3_0_ from poll_option polloption0_ where polloption0_.id=?
     * 2017-01-04 12:13:28.567 : 2.voter - poll vote value: 39
     * Hibernate: update poll_option set votes=? where id=?
     * 2017-01-04 12:13:29.572 : 2.voter - final poll vote value: 40
     * Hibernate: update poll_option set votes=? where id=?
     *
     * @param tag
     * @param sleep
     */
    @Transactional
    synchronized public void vote2(String tag, long sleep) {
        do_voting(tag, sleep);
    }

    /**
     * the following implementation does not guarantee race-condition prevention.
     * if there are two invocations for this method, read-modify-write process might
     * be interleaved from another thread/invocation. So, it is possible to end up with
     * the same value after all. As you can see, @Transactional does not have any
     * intention or ability to prevent this kind of race-condition.
     * <p>
     * Example: vote3("1.voter", 3000); vote3("2.voter", 1000);
     * Output:
     * 2017-01-04 12:16:08.085 : 1.voter - starts voting. Thread id: 27, 13
     * Hibernate: select polloption0_.id as id1_3_0_, polloption0_.votes as votes2_3_0_ from poll_option polloption0_ where polloption0_.id=?
     * 2017-01-04 12:16:08.234 : 1.voter - poll vote value: 40
     * Hibernate: update poll_option set votes=? where id=?
     * 2017-01-04 12:16:11.306 : 1.voter - final poll vote value: 41
     * 2017-01-04 12:16:11.307 : 2.voter - starts voting. Thread id: 28, 12
     * Hibernate: select polloption0_.id as id1_3_0_, polloption0_.votes as votes2_3_0_ from poll_option polloption0_ where polloption0_.id=?
     * 2017-01-04 12:16:11.324 : 2.voter - poll vote value: 41
     * Hibernate: update poll_option set votes=? where id=?
     * 2017-01-04 12:16:12.360 : 2.voter - final poll vote value: 42
     *
     * @param tag
     * @param sleep
     */
    synchronized public void vote3(String tag, long sleep) {
        do_voting(tag, sleep);
    }

}
