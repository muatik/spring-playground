package com.muatik;

import com.muatik.model.Person;
import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by muatik on 7/12/17.
 */
@Configuration
@EnableBatchProcessing
public class Step1 {


    private final StepBuilderFactory stepBuilderFactory;
    private DataSource dataSource;

    public Step1(StepBuilderFactory stepBuilderFactory, DataSource dataSource) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
    }


    @Bean
    public FlatFileItemReader<Person> reader() {
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("sample-data.csv"));
        reader.setLineMapper(new DefaultLineMapper<Person>(){{
            setLineTokenizer(new DelimitedLineTokenizer(){{
                setNames(new String[]{"firstName", "lastName"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>(){{
                setTargetType(Person.class);
            }});
        }});
        return reader;
    }

    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Person> writer() {
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
        writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Step step(){
        return stepBuilderFactory.get("step1")
                .<Person, Person> chunk(3)
                .reader(new MyCustomReader())
                .processor(processor())
                .writer(new MyConsoleWriter())
                .build();
    }
}
