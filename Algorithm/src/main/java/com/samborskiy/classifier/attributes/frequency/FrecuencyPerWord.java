package com.samborskiy.classifier.attributes.frequency;

import com.samborskiy.classifier.attributes.AttributeFunction;
import com.samborskiy.entity.Attribute;

import java.util.List;

public class FrecuencyPerWord extends AttributeFunction {

    @Override
    public String getName() {
        return "frequency_per_word";
    }

    @Override
    protected void apply(List<Attribute> attributes, List<String> tweets) {
        double frequency = 0.;
        double wordCount = 0.;
        for (String tweet : tweets) {
            List<String> words = tweetParser.parse(tweet);
            for (String word : words) {
                frequency += frequencyAnalyzer.getFrequency(word);
            }
            wordCount += words.size();
        }
        attributes.add(new Attribute(frequency / wordCount, getName()));
    }
}
