package com.muatik;

import com.muatik.model.Person;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by muatik on 7/12/17.
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person p) throws Exception {
        p.setFirstName(p.getFirstName().toUpperCase());
        p.setLastName(p.getLastName().toUpperCase());
        System.out.println("Converting  " + p.getLastName());
        return p;
    }
}
