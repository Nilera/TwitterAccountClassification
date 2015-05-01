package com.samborskiy.feature.selection;

import weka.attributeSelection.ASEvaluation;
import weka.attributeSelection.ASSearch;
import weka.attributeSelection.Ranker;
import weka.attributeSelection.SignificanceAttributeEval;

/**
 * Created by Whiplash on 30.04.2015.
 */
public class Signific extends FeatureSelection {

    @Override
    protected ASSearch getSearcher() {
        return new Ranker();
    }

    @Override
    protected String[] getOptions() {
        return new String[]{"-T", "0.01"};
    }

    @Override
    protected ASEvaluation getEvaluator() {
        return new SignificanceAttributeEval();
    }
}