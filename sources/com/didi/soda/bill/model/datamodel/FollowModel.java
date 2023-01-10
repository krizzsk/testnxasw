package com.didi.soda.bill.model.datamodel;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.FollowingInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00108\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u000209H\u0016J\u0010\u0010:\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u000209R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001c\u0010 \u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\u001c\u0010#\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001c\u0010&\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR\u001c\u0010)\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\u001c\u0010,\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000e¨\u0006;"}, mo148868d2 = {"Lcom/didi/soda/bill/model/datamodel/FollowModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "activityId", "", "getActivityId", "()I", "setActivityId", "(I)V", "benefitDesc", "", "getBenefitDesc", "()Ljava/lang/String;", "setBenefitDesc", "(Ljava/lang/String;)V", "benefitId", "getBenefitId", "setBenefitId", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;", "getEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;", "setEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;)V", "isSelected", "setSelected", "leftTitle", "getLeftTitle", "setLeftTitle", "oriPackPriceDisplay", "getOriPackPriceDisplay", "setOriPackPriceDisplay", "oriPriceDisplay", "getOriPriceDisplay", "setOriPriceDisplay", "packPriceDisplay", "getPackPriceDisplay", "setPackPriceDisplay", "priceDisplay", "getPriceDisplay", "setPriceDisplay", "productId", "getProductId", "setProductId", "rightTitle", "getRightTitle", "setRightTitle", "title", "", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "url", "getUrl", "setUrl", "convertModel", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "convertModelV2", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FollowModel.kt */
public final class FollowModel extends ComponentAbsModel {

    /* renamed from: a */
    private String f41817a;

    /* renamed from: b */
    private String f41818b;

    /* renamed from: c */
    private String f41819c;

    /* renamed from: d */
    private String f41820d;

    /* renamed from: e */
    private String f41821e;

    /* renamed from: f */
    private String f41822f;

    /* renamed from: g */
    private String f41823g;

    /* renamed from: h */
    private int f41824h;

    /* renamed from: i */
    private CharSequence f41825i;

    /* renamed from: j */
    private FollowingInfoEntity f41826j;

    /* renamed from: k */
    private String f41827k;

    /* renamed from: l */
    private String f41828l;

    /* renamed from: m */
    private int f41829m;

    /* renamed from: n */
    private int f41830n;

    public final String getProductId() {
        return this.f41817a;
    }

    public final void setProductId(String str) {
        this.f41817a = str;
    }

    public final String getUrl() {
        return this.f41818b;
    }

    public final void setUrl(String str) {
        this.f41818b = str;
    }

    public final String getBenefitDesc() {
        return this.f41819c;
    }

    public final void setBenefitDesc(String str) {
        this.f41819c = str;
    }

    public final String getPriceDisplay() {
        return this.f41820d;
    }

    public final void setPriceDisplay(String str) {
        this.f41820d = str;
    }

    public final String getPackPriceDisplay() {
        return this.f41821e;
    }

    public final void setPackPriceDisplay(String str) {
        this.f41821e = str;
    }

    public final String getOriPriceDisplay() {
        return this.f41822f;
    }

    public final void setOriPriceDisplay(String str) {
        this.f41822f = str;
    }

    public final String getOriPackPriceDisplay() {
        return this.f41823g;
    }

    public final void setOriPackPriceDisplay(String str) {
        this.f41823g = str;
    }

    public final int isSelected() {
        return this.f41824h;
    }

    public final void setSelected(int i) {
        this.f41824h = i;
    }

    public final CharSequence getTitle() {
        return this.f41825i;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f41825i = charSequence;
    }

    public final FollowingInfoEntity getEntity() {
        return this.f41826j;
    }

    public final void setEntity(FollowingInfoEntity followingInfoEntity) {
        this.f41826j = followingInfoEntity;
    }

    public final String getLeftTitle() {
        return this.f41827k;
    }

    public final void setLeftTitle(String str) {
        this.f41827k = str;
    }

    public final String getRightTitle() {
        return this.f41828l;
    }

    public final void setRightTitle(String str) {
        this.f41828l = str;
    }

    public final int getActivityId() {
        return this.f41829m;
    }

    public final void setActivityId(int i) {
        this.f41829m = i;
    }

    public final int getBenefitId() {
        return this.f41830n;
    }

    public final void setBenefitId(int i) {
        this.f41830n = i;
    }

    public FollowModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        FollowingInfoEntity followingInfo = billComponentDataEntity.getFollowingInfo();
        if (followingInfo == null) {
            return null;
        }
        String string = TextUtils.isEmpty(followingInfo.url) ? "" : ResourceHelper.getString(R.string.customer_common_icon_notes);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(followingInfo.valueDesc);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, string.length(), 33);
        spannableString.setSpan(new CustomerVerticalCenterSpan(12), 0, string.length(), 33);
        spannableStringBuilder.append(ResourceHelper.getString(R.string.customer_global_blank));
        spannableStringBuilder.append(spannableString);
        setEntity(followingInfo);
        setBenefitDesc(followingInfo.benefitDesc);
        setPriceDisplay(followingInfo.priceDisplay);
        setOriPriceDisplay(followingInfo.oriPriceDisplay);
        setSelected(followingInfo.isSelected);
        setUrl(followingInfo.url);
        setTitle(spannableStringBuilder);
        setProductId(followingInfo.productId);
        return this;
    }

    public final FollowModel convertModelV2(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        FollowingInfoEntity followingInfo = billComponentDataEntity.getFollowingInfo();
        if (followingInfo == null) {
            return null;
        }
        setEntity(followingInfo);
        setBenefitDesc(followingInfo.benefitDesc);
        setPriceDisplay(followingInfo.priceDisplay);
        setOriPriceDisplay(followingInfo.oriPriceDisplay);
        setSelected(followingInfo.isSelected);
        setUrl(followingInfo.url);
        setTitle(followingInfo.valueDesc);
        setProductId(followingInfo.productId);
        setLeftTitle(followingInfo.leftTitle);
        setRightTitle(followingInfo.rightTitle);
        setActivityId(followingInfo.activityId);
        setBenefitId(followingInfo.benefitId);
        setPackPriceDisplay(followingInfo.packPriceDisplay);
        setOriPackPriceDisplay(followingInfo.oriPackPriceDisplay);
        return this;
    }
}
