package com.samborskiy.entity.instances.attrs;

import com.samborskiy.entity.instances.attributes.Attribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Whiplash on 21.04.2015.
 */
public class Account extends Instance {

    protected static final String URL_REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    protected final List<String> tweets;

    public Account(int classId) {
        super(classId);
        tweets = new ArrayList<>();
    }

    @Override
    public void addAttr(Attribute attribute) {
        attrs.addAll(attribute.apply(tweets));
    }

    public void addTweet(String tweet) {
        tweets.add(tweet.replaceAll(URL_REGEX, " "));
    }

    public void addTweets(List<String> tweets) {
        tweets.forEach(this::addTweet);
    }
}