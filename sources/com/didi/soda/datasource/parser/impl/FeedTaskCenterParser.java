package com.didi.soda.datasource.parser.impl;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParserMeta;
import com.didi.soda.home.topgun.binder.model.HomeTaskCenterRvModel;
import com.google.gson.JsonObject;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/soda/datasource/parser/impl/FeedTaskCenterParser;", "Lcom/didi/soda/datasource/parser/FeedParser;", "()V", "parse", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "context", "Landroid/content/Context;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@ParserMeta(type = {"800"})
/* compiled from: FeedTaskCenterParser.kt */
public final class FeedTaskCenterParser extends FeedParser {
    public RecyclerModel parse(Context context, JsonObject jsonObject, FeedPayload feedPayload) {
        try {
            return HomeTaskCenterRvModel.Companion.convertTaskCenterModel(jsonObject, feedPayload);
        } catch (Exception unused) {
            return null;
        }
    }
}
