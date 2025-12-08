package org.example;

import java.util.Arrays;
import java.util.List;

public class WordCounter {
    public static long countWords(List<String> sentences) {
        return sentences.stream()
                .filter(s -> !s.contains("Java"))
                .map(s -> Arrays.stream(s.split(" "))
                        .distinct()
                        .toArray(String[]::new)
                )
                .flatMap(Arrays::stream)
                .distinct()
                .count();
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Python is a programming language.",
                "JavaScript is used for web development.",
                "Ruby is known for its simplicity."
        );

        long wordCount = WordCounter.countWords(sentences);
        System.out.println(wordCount);
    }
}