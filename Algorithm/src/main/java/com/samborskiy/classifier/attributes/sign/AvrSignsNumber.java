package com.samborskiy.classifier.attributes.sign;

import com.samborskiy.classifier.entities.sequences.SignSequence;
import com.samborskiy.entity.Attribute;
import com.samborskiy.entity.analyzers.frequency.FrequencyAnalyzer;
import com.samborskiy.entity.analyzers.grammar.GrammarAnalyzer;
import com.samborskiy.entity.analyzers.morphological.MorphologicalAnalyzer;
import com.samborskiy.entity.analyzers.sentence.TweetParser;

import java.util.List;

/**
 * The average number of different signs in a tweets.
 */
public class AvrSignsNumber extends SignFunction {

    @Override
    public String getName() {
        return "average_signs_number";
    }

    @Override
    protected void apply(List<Attribute> attributes, List<String> tweets) {
        double count = 0.;
        for (String tweet : tweets) {
            for (SignSequence sequence : SIGNS) {
                count += sequence.contains(tweet) ? 1 : 0;
            }
        }
        attributes.add(new Attribute(count / tweets.size(), getName()));
    }
}
