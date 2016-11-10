package com.samborskiy.feature.selection;

import com.samborskiy.feature.Feature;
import weka.attributeSelection.ASEvaluation;
import weka.attributeSelection.ASSearch;
import weka.attributeSelection.BestFirst;
import weka.attributeSelection.ConsistencySubsetEval;

/**
 * Created by Whiplash on 30.04.2015.
 */
public class Cons_SBS extends Feature {

    @Override
    protected ASSearch getSearcher() {
        return new BestFirst();
    }

    @Override
    protected String[] getSearcherOptions() {
        return new String[]{"-D", "0"};
    }

    @Override
    protected ASEvaluation getEvaluator() {
        return new ConsistencySubsetEval();
    }
}