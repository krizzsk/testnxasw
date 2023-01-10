package com.didi.soda.datasource.parser.impl;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParserMeta;
import com.didi.soda.home.topgun.binder.model.SceneComponentModel;
import com.google.gson.JsonObject;

@ParserMeta(type = {"901"})
public class FeedSceneCompParser extends FeedParser {
    public RecyclerModel parse(Context context, JsonObject jsonObject, FeedPayload feedPayload) {
        return SceneComponentModel.Companion.convert(jsonObject, feedPayload);
    }
}
