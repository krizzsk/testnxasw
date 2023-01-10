package com.didi.soda.search.repo;

import android.graphics.Color;
import com.didi.soda.customer.foundation.rpc.entity.SearchHotWordsEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006("}, mo148868d2 = {"Lcom/didi/soda/search/repo/SearchHotWordsModel;", "", "()V", "activityCate", "", "getActivityCate", "()Ljava/lang/String;", "setActivityCate", "(Ljava/lang/String;)V", "activityId", "getActivityId", "setActivityId", "bgColor", "", "getBgColor", "()Ljava/util/List;", "setBgColor", "(Ljava/util/List;)V", "img", "getImg", "setImg", "resourceId", "getResourceId", "setResourceId", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "url", "getUrl", "setUrl", "word", "getWord", "setWord", "getMBgColorIntArray", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SearchHotWordsModel.kt */
public final class SearchHotWordsModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f46340a;

    /* renamed from: b */
    private List<String> f46341b;

    /* renamed from: c */
    private String f46342c;

    /* renamed from: d */
    private Integer f46343d;

    /* renamed from: e */
    private String f46344e;

    /* renamed from: f */
    private String f46345f;

    /* renamed from: g */
    private String f46346g;

    /* renamed from: h */
    private String f46347h;

    @JvmStatic
    public static final SearchHotWordsModel convert2Model(SearchHotWordsEntity searchHotWordsEntity) {
        return Companion.convert2Model(searchHotWordsEntity);
    }

    public final String getWord() {
        return this.f46340a;
    }

    public final void setWord(String str) {
        this.f46340a = str;
    }

    public final List<String> getBgColor() {
        return this.f46341b;
    }

    public final void setBgColor(List<String> list) {
        this.f46341b = list;
    }

    public final int[] getMBgColorIntArray() {
        List<String> list = this.f46341b;
        if (list == null) {
            SearchHotWordsModel searchHotWordsModel = this;
            return new int[0];
        }
        int[] iArr = new int[list.size()];
        try {
            int size = list.size();
            if (size <= 0) {
                return iArr;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                iArr[i] = Color.parseColor(list.get(i));
                if (i2 >= size) {
                    return iArr;
                }
                i = i2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new int[0];
        }
    }

    public final String getImg() {
        return this.f46342c;
    }

    public final void setImg(String str) {
        this.f46342c = str;
    }

    public final Integer getType() {
        return this.f46343d;
    }

    public final void setType(Integer num) {
        this.f46343d = num;
    }

    public final String getActivityId() {
        return this.f46344e;
    }

    public final void setActivityId(String str) {
        this.f46344e = str;
    }

    public final String getActivityCate() {
        return this.f46345f;
    }

    public final void setActivityCate(String str) {
        this.f46345f = str;
    }

    public final String getUrl() {
        return this.f46346g;
    }

    public final void setUrl(String str) {
        this.f46346g = str;
    }

    public final String getResourceId() {
        return this.f46347h;
    }

    public final void setResourceId(String str) {
        this.f46347h = str;
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/search/repo/SearchHotWordsModel$Companion;", "", "()V", "convert2Model", "Lcom/didi/soda/search/repo/SearchHotWordsModel;", "searchHotWordsEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/SearchHotWordsEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SearchHotWordsModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SearchHotWordsModel convert2Model(SearchHotWordsEntity searchHotWordsEntity) {
            Intrinsics.checkNotNullParameter(searchHotWordsEntity, "searchHotWordsEntity");
            SearchHotWordsModel searchHotWordsModel = new SearchHotWordsModel();
            searchHotWordsModel.setWord(searchHotWordsEntity.word);
            searchHotWordsModel.setBgColor(searchHotWordsEntity.bgColor);
            searchHotWordsModel.setImg(searchHotWordsEntity.img);
            searchHotWordsModel.setType(searchHotWordsEntity.type);
            searchHotWordsModel.setActivityId(searchHotWordsEntity.activityId);
            searchHotWordsModel.setActivityCate(searchHotWordsEntity.activityCate);
            searchHotWordsModel.setUrl(searchHotWordsEntity.url);
            searchHotWordsModel.setResourceId(searchHotWordsEntity.resourceId);
            return searchHotWordsModel;
        }
    }
}
