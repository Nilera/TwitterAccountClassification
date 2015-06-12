package com.samborskiy.attributes.length;

import com.samborskiy.attributes.AttributeFunction;
import com.samborskiy.entity.Account;
import com.samborskiy.entity.Attribute;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Whiplash on 27.04.2015.
 */
public abstract class LengthFunction extends AttributeFunction {

    @Override
    public List<Attribute> apply(Account account) {
        return count(account.getTweets().stream()
                .map(tweetParser::parse)
                .collect(Collectors.toList()));
    }

    @Override
    protected void apply(List<Attribute> attributes, List<String> tweets) {
        // empty...
    }

    protected abstract List<Attribute> count(List<List<String>> tweets);
}
