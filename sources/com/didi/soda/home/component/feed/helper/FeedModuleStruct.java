package com.didi.soda.home.component.feed.helper;

import java.util.LinkedList;

public class FeedModuleStruct {

    /* renamed from: a */
    private LinkedList<FeedComponentStruct> f45074a = new LinkedList<>();
    public String mModuleId;
    public int mModuleIndex = -1;
    public String mModuleTitle;
    public String mType;

    public void addFeedComponent(FeedComponentStruct feedComponentStruct) {
        this.f45074a.add(feedComponentStruct);
    }

    public LinkedList<FeedComponentStruct> getComponentList() {
        return this.f45074a;
    }
}
