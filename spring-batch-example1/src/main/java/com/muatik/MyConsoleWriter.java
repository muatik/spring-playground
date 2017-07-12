package com.muatik;

import com.muatik.model.Person;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by muatik on 7/12/17.
 */
public class MyConsoleWriter implements ItemWriter<Person> {

    @Override
    public void write(List<? extends Person> list) throws Exception {
        System.out.println("printing the list");
        list.forEach(System.out::println);
    }
}
