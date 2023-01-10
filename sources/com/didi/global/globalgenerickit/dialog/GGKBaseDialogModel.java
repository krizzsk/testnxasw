package com.didi.global.globalgenerickit.dialog;

import android.text.TextUtils;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKImgModel;
import java.util.ArrayList;
import java.util.List;

public abstract class GGKBaseDialogModel {

    /* renamed from: a */
    private List<GGKBtnTextAndCallback> f23977a = new ArrayList();

    /* renamed from: b */
    private String f23978b;

    /* renamed from: c */
    private int f23979c;

    /* renamed from: d */
    private int f23980d;

    /* access modifiers changed from: protected */
    public abstract void convertOthers(GGKRealUsedModel gGKRealUsedModel);

    public GGKBaseDialogModel(GGKBtnTextAndCallback... gGKBtnTextAndCallbackArr) {
        if (gGKBtnTextAndCallbackArr != null) {
            for (GGKBtnTextAndCallback add : gGKBtnTextAndCallbackArr) {
                this.f23977a.add(add);
            }
        }
    }

    public GGKBaseDialogModel(List<GGKBtnTextAndCallback> list) {
        if (list != null) {
            for (GGKBtnTextAndCallback add : list) {
                this.f23977a.add(add);
            }
        }
    }

    public GGKBaseDialogModel addMinorBtn(GGKBtnTextAndCallback gGKBtnTextAndCallback) {
        this.f23977a.add(gGKBtnTextAndCallback);
        return this;
    }

    public List<GGKBtnTextAndCallback> getBtns() {
        return this.f23977a;
    }

    public String getImageUrl() {
        return this.f23978b;
    }

    public GGKBaseDialogModel setImageUrl(String str) {
        this.f23978b = str;
        return this;
    }

    public int getImageResId() {
        return this.f23979c;
    }

    public GGKBaseDialogModel setImageResId(int i) {
        this.f23979c = i;
        return this;
    }

    public int getImgPlaceHolder() {
        return this.f23980d;
    }

    public GGKBaseDialogModel setImgPlaceHolder(int i) {
        this.f23980d = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public GGKRealUsedModel mo71738a() {
        GGKRealUsedModel gGKRealUsedModel = new GGKRealUsedModel();
        gGKRealUsedModel.f24009g = this.f23977a;
        mo71739a(gGKRealUsedModel);
        convertOthers(gGKRealUsedModel);
        return gGKRealUsedModel;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71739a(GGKRealUsedModel gGKRealUsedModel) {
        if (!TextUtils.isEmpty(getImageUrl()) || getImageResId() != 0) {
            gGKRealUsedModel.f24012j = new GGKImgModel();
            if (getImageUrl() != null) {
                gGKRealUsedModel.f24012j.setImgUrl(getImageUrl());
            } else if (getImageResId() != 0) {
                gGKRealUsedModel.f24012j.setImgResId(getImageResId());
            }
            if (getImgPlaceHolder() != 0) {
                gGKRealUsedModel.f24012j.setImgPlaceHolder(getImgPlaceHolder());
            }
        }
    }
}
