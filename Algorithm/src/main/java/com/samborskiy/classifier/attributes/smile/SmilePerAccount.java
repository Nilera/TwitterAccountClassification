package com.samborskiy.classifier.attributes.smile;

import com.samborskiy.classifier.entities.sequences.SmileSequence;
import com.samborskiy.entity.Attribute;

import java.util.List;

/**
 * Created by Whiplash on 27.04.2015.
 */
public class SmilePerAccount extends SmileFunction {

    private final SmileSequence smile;

    public SmilePerAccount(SmileSequence smile) {
        this.smile = smile;
    }

    @Override
    public String getName() {
        return String.format("%s_per_tweet", smile.toString());
    }

    @Override
    protected void apply(List<Attribute> attributes, List<String> tweets) {
        double count = 0;
        for (String tweet : tweets) {
            count += smile.count(tweet);
        }
        attributes.add(new Attribute(count / tweets.size(), getName()));
    }
}
