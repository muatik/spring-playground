package com.muatik;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mustafaatik on 17/01/17.
 */
public class main {

    public static void main(String[] args) throws IOException {
        String filePath = "shakespeare.txt";
        Stream<String> stream = Files.lines(Paths.get(filePath));

        Stream<Map.Entry<String, Long>> commonWords = findMostFrequentWords(stream);

        Files.write(
                Paths.get("commonWords.txt"),
                commonWords.collect(Collectors.toList()).toString().getBytes(),
                StandardOpenOption.CREATE);
        stream.close();
    }

    public static Stream<Map.Entry<String, Long>> findMostFrequentWords(Stream<String> stream) {
        return stream
                .map(l -> l.toLowerCase().split("[ ,.?]"))   // split lines into words stream
                .flatMap(Arrays::stream)  // flatten words streams into a single stream
                .filter(s -> !s.equals("")) // filter out empty elements
                .collect(Collectors.groupingBy(w->w, Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> Long.compare(o2.getValue(), o1.getValue())) // reverse sorting by count value
                .skip(0) // limit 0, 50
                .limit(50);
    }

    public static Stream<Path> getFileStreams(String path) throws IOException {
        return Files.walk(Paths.get(path)).filter(Files::isRegularFile);
    }
}
