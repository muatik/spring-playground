package com.muatik;

import com.muatik.model.Person;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * Created by muatik on 7/12/17.
 */
public class MyCustomReader implements ItemReader<Person> {

    @Override
    public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return new Person("a", "b");
    }
}
