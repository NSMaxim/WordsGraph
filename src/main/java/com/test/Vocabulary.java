package com.test;

import java.util.Arrays;
import java.util.List;

public class Vocabulary {

    public static List<String> getKnownWords() {
        return knownWords;
    }

    private static List<String> knownWords = Arrays.asList(
            "flamingo",
            "porn",
            "pop",
            "cop",
            "corn",
            "corp"
    );

    public static boolean isWord(String wordToCheck) {
        return knownWords.contains(wordToCheck);
    }

}
