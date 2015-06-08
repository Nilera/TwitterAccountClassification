package com.samborskiy.classifier.attributes.vocabulary;

import com.samborskiy.classifier.attributes.AttributeFunction;
import com.samborskiy.entity.Attribute;
import com.samborskiy.entity.analyzers.frequency.FrequencyAnalyzer;
import com.samborskiy.entity.analyzers.grammar.GrammarAnalyzer;
import com.samborskiy.entity.analyzers.morphological.MorphologicalAnalyzer;
import com.samborskiy.entity.analyzers.sentence.TweetParser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Whiplash on 28.04.2015.
 */
public class RichnessOfVocabulary extends AttributeFunction {

    public RichnessOfVocabulary(FrequencyAnalyzer frequencyAnalyzer, GrammarAnalyzer grammarAnalyzer,
                                MorphologicalAnalyzer morphologicalAnalyzer, TweetParser tweetParser, String... args) {
        super(frequencyAnalyzer, grammarAnalyzer, morphologicalAnalyzer, tweetParser, args);
    }

    @Override
    public String getName() {
        return "richness_of_vocabulary";
    }

    @Override
    protected void apply(List<Attribute> attributes, List<String> tweets) {
        Set<String> words = new HashSet<>();
        for (String tweet : tweets) {
            words.addAll(tweetParser.parse(tweet));
        }
        attributes.add(new Attribute(((double) words.size()) / tweets.size(), getName()));
    }
}
