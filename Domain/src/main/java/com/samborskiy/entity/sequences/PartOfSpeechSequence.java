package com.samborskiy.entity.sequences;

import com.samborskiy.entity.ClassifierProperty;
import com.samborskiy.entity.PartOfSpeech;
import com.samborskiy.entity.analyzers.morphological.MorphologicalAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by whiplash on 08.06.15.
 */
public class PartOfSpeechSequence extends Sequence<PartOfSpeech> {

    public PartOfSpeechSequence(String name, PartOfSpeech... sequence) {
        super(name, sequence);
    }

    @Override
    public int count(String tweet) {
        MorphologicalAnalyzer morphologicalAnalyzer = ClassifierProperty.getMorphologicalAnalyzer();
        List<String> parsedTweet = ClassifierProperty.getTweetParser().parse(tweet);
        List<PartOfSpeech> partsOfSpeech = new ArrayList<>();
        for (String word : parsedTweet) {
            PartOfSpeech partOfSpeech = morphologicalAnalyzer.get(word);
            if (partOfSpeech != null) {
                partsOfSpeech.add(partOfSpeech);
            }
        }
        int count = 0;
        for (int i = 0; i < partsOfSpeech.size() - sequence.size(); i++) {
            List<PartOfSpeech> subSequence = partsOfSpeech.subList(i, i + sequence.size());
            count += sequence.equals(subSequence) ? 1 : 0;
        }
        return count;
    }
}
