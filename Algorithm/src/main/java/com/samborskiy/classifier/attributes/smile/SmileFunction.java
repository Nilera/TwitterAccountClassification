package com.samborskiy.classifier.attributes.smile;

import com.samborskiy.classifier.attributes.AttributeFunction;
import com.samborskiy.classifier.entities.sequences.SmileSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Whiplash on 26.04.2015.
 */
public abstract class SmileFunction extends AttributeFunction {

    public static final List<SmileSequence> SMILES = new ArrayList<>();

    static {
        SMILES.add(new SmileSequence("happy_smiles", ":)", ":-)", "^_^", "=)"));
        SMILES.add(new SmileSequence("sad_smiles", ":(", ":-(", "=("));
        SMILES.add(new SmileSequence("winking_smiles", ";)", ";-)", "^_-"));
        SMILES.add(new SmileSequence("glasses_smiles", "8-)", "%)", "%-)", "8)"));
        SMILES.add(new SmileSequence("laugh_with_tears_smiles", ":')", ":'-)", ":,)", ":,-)", "=')", "=,)", ";)", ";-)"));
        SMILES.add(new SmileSequence("cry_smiles", ":'(", ":'-(", ":,(", ":,-(", ";(", ";-(", "='(", "=,("));
        SMILES.add(new SmileSequence("kiss_smiles", ":*", ":-*", "=*"));
        SMILES.add(new SmileSequence("surprised_smiles", "o_o", "o_0", "=o", "=0", "0_0"));
        SMILES.add(new SmileSequence("with_tongue_smiles", ":-b", ":-p", ":b", ":p", "=p", "=b", ";b", ";p"));
        SMILES.add(new SmileSequence("laugh_smiles", ":d", "xd", "=d", ";d"));
        SMILES.add(new SmileSequence("other_smiles", ":-[", "=[", ":3", ">_<", ":-/", ":-\\", "=/", "=\\"));
    }
}
