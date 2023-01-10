package com.didi.soda.home.topgun.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedPayload;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00064"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/model/LandingHeaderRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "ambientImg", "", "getAmbientImg", "()Ljava/lang/String;", "setAmbientImg", "(Ljava/lang/String;)V", "countDown", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;", "getCountDown", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;", "setCountDown", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;)V", "img", "getImg", "setImg", "localDeadline", "", "getLocalDeadline", "()J", "setLocalDeadline", "(J)V", "platLogo", "getPlatLogo", "setPlatLogo", "ruleLink", "Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;", "getRuleLink", "()Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;", "setRuleLink", "(Lcom/didi/soda/customer/foundation/rpc/entity/ActivityInfoEntity$RuleLink;)V", "subTitle", "getSubTitle", "setSubTitle", "tab", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "getTab", "()Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "setTab", "(Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;)V", "tabs", "", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "title", "getTitle", "setTitle", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LandingHeaderRvModel.kt */
public final class LandingHeaderRvModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f45283a;

    /* renamed from: b */
    private String f45284b;

    /* renamed from: c */
    private ActivityInfoEntity.RuleLink f45285c;

    /* renamed from: d */
    private String f45286d;

    /* renamed from: e */
    private CountDownEntity f45287e;

    /* renamed from: f */
    private String f45288f;

    /* renamed from: g */
    private String f45289g;

    /* renamed from: h */
    private TabInfoEntity f45290h;

    /* renamed from: i */
    private List<TabInfoEntity> f45291i;

    /* renamed from: j */
    private long f45292j;

    public final String getImg() {
        return this.f45283a;
    }

    public final void setImg(String str) {
        this.f45283a = str;
    }

    public final String getTitle() {
        return this.f45284b;
    }

    public final void setTitle(String str) {
        this.f45284b = str;
    }

    public final ActivityInfoEntity.RuleLink getRuleLink() {
        return this.f45285c;
    }

    public final void setRuleLink(ActivityInfoEntity.RuleLink ruleLink) {
        this.f45285c = ruleLink;
    }

    public final String getPlatLogo() {
        return this.f45286d;
    }

    public final void setPlatLogo(String str) {
        this.f45286d = str;
    }

    public final CountDownEntity getCountDown() {
        return this.f45287e;
    }

    public final void setCountDown(CountDownEntity countDownEntity) {
        this.f45287e = countDownEntity;
    }

    public final String getAmbientImg() {
        return this.f45288f;
    }

    public final void setAmbientImg(String str) {
        this.f45288f = str;
    }

    public final String getSubTitle() {
        return this.f45289g;
    }

    public final void setSubTitle(String str) {
        this.f45289g = str;
    }

    public final TabInfoEntity getTab() {
        return this.f45290h;
    }

    public final void setTab(TabInfoEntity tabInfoEntity) {
        this.f45290h = tabInfoEntity;
    }

    public final List<TabInfoEntity> getTabs() {
        return this.f45291i;
    }

    public final void setTabs(List<TabInfoEntity> list) {
        this.f45291i = list;
    }

    public final long getLocalDeadline() {
        return this.f45292j;
    }

    public final void setLocalDeadline(long j) {
        this.f45292j = j;
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/model/LandingHeaderRvModel$Companion;", "", "()V", "convertModel", "Lcom/didi/soda/home/topgun/binder/model/LandingHeaderRvModel;", "componentEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: LandingHeaderRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LandingHeaderRvModel convertModel(ComponentEntity componentEntity, FeedPayload feedPayload) {
            ActivityInfoEntity.HeaderInfo headerInfo;
            Intrinsics.checkNotNullParameter(componentEntity, "componentEntity");
            Intrinsics.checkNotNullParameter(feedPayload, "payload");
            ActivityInfoEntity.HeaderInfo headerInfo2 = componentEntity.header;
            if (headerInfo2 == null && componentEntity.data != null) {
                try {
                    headerInfo = (ActivityInfoEntity.HeaderInfo) GsonUtil.fromJson((JsonElement) componentEntity.data, (Type) ActivityInfoEntity.HeaderInfo.class);
                } catch (Exception unused) {
                    headerInfo = null;
                }
                headerInfo2 = headerInfo;
            }
            if (headerInfo2 == null) {
                Companion companion = this;
                return null;
            }
            LandingHeaderRvModel landingHeaderRvModel = new LandingHeaderRvModel();
            landingHeaderRvModel.setImg(headerInfo2.img);
            landingHeaderRvModel.setTitle(headerInfo2.title);
            landingHeaderRvModel.setRuleLink(headerInfo2.ruleLink);
            landingHeaderRvModel.setPlatLogo(headerInfo2.platLogo);
            landingHeaderRvModel.setCountDown(headerInfo2.countDown);
            landingHeaderRvModel.setAmbientImg(headerInfo2.ambientImg);
            landingHeaderRvModel.setSubTitle(headerInfo2.subTitle);
            landingHeaderRvModel.setTab(headerInfo2.tab);
            landingHeaderRvModel.setTabs(headerInfo2.tabs);
            return landingHeaderRvModel;
        }
    }
}
