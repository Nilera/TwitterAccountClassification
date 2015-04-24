package com.samborskiy.test;

import com.samborskiy.entity.Configuration;
import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;

/**
 * Created by Whiplash on 24.04.2015.
 */
public class KNNTest extends Test {

    public KNNTest(Configuration configuration) {
        super(configuration);
    }

    @Override
    protected Classifier getClassifier() {
        return new IBk();
    }
}