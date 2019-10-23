package com.test;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordsMaker {

    private Logger log = Logger.getLogger(getClass().getName());

    private Graph characterGraph;

    public WordsMaker(Graph graph) {
        this.characterGraph = graph;
    }

    public List<String> wordsFromVocabulary() {
        List<String> wordsFromVocabulary = getAllPossibleWordsForGraph().parallelStream().filter(word -> {
            log.debug(String.format("Is word %s in vocabulary - %b", word, Vocabulary.isWord(word)));
            return Vocabulary.getKnownWords().contains(word);
        }).collect(Collectors.toList());
        log.info(String.format("All possible words to compile according to vocabulary are - %s", wordsFromVocabulary, toString()));
        return wordsFromVocabulary;
    }

    public Set<String> getAllPossibleWordsForGraph() {
        log.debug("Compiling all possible combinations for character graph");
        Set<String> combinedWords = new HashSet<>();
        characterGraph.getGraph().keySet().forEach(vert -> {
            combinedWords.addAll(getAllPossibleWordsForVertex(vert));
        });
        return combinedWords;
    }

    public Set<String> getAllPossibleWordsForVertex(Vertex vert) {
        log.debug(String.format("Compiling all possible character combinations from - %s", vert.toString()));
        return combineWordsForVertex(vert, "", new ArrayList<>());
    }

    private Set<String> combineWordsForVertex(Vertex vert, String prevWord, List<Vertex> visited) {
        Set<String> words = new HashSet<>();

        visited.add(vert);

        List<Vertex> auxVisitedVert = new ArrayList<>(visited);

        if (prevWord.isEmpty()) {
            prevWord = String.valueOf(vert.getCharacter());
        }

        for (Vertex relatedVert : characterGraph.getRelatedVertex(vert)) {
            if (!visited.contains(relatedVert)) {
                log.trace(String.format("Scanning related - %s", relatedVert.toString()));
                String newWord = prevWord + relatedVert.getCharacter();
                auxVisitedVert.add(vert);
                words.add(newWord);
                notifyAboutWordFromVocabulary(newWord);
                words.addAll(combineWordsForVertex(relatedVert, newWord, auxVisitedVert));
            }
        }

        return words;
    }

    private void notifyAboutWordFromVocabulary(String word) {
        if (Vocabulary.isWord(word)) {
            log.debug(String.format("Found word %s from vocabulary.", word));
        }
    }

}
