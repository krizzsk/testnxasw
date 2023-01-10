package com.didi.global.globaluikit.dialog;

import android.text.TextUtils;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOImgModel;
import java.util.ArrayList;
import java.util.List;

public abstract class LEGOBaseDialogModel {

    /* renamed from: a */
    private List<LEGOBtnTextAndCallback> f24397a = new ArrayList();

    /* renamed from: b */
    private String f24398b;

    /* renamed from: c */
    private int f24399c;

    /* renamed from: d */
    private int f24400d;

    /* access modifiers changed from: protected */
    public abstract void convertOthers(LEGORealUsedModel lEGORealUsedModel);

    public LEGOBaseDialogModel(LEGOBtnTextAndCallback... lEGOBtnTextAndCallbackArr) {
        if (lEGOBtnTextAndCallbackArr != null) {
            for (LEGOBtnTextAndCallback add : lEGOBtnTextAndCallbackArr) {
                this.f24397a.add(add);
            }
        }
    }

    public LEGOBaseDialogModel(List<LEGOBtnTextAndCallback> list) {
        if (list != null) {
            for (LEGOBtnTextAndCallback add : list) {
                this.f24397a.add(add);
            }
        }
    }

    public LEGOBaseDialogModel addMinorBtn(LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        this.f24397a.add(lEGOBtnTextAndCallback);
        return this;
    }

    public List<LEGOBtnTextAndCallback> getBtns() {
        return this.f24397a;
    }

    public String getImageUrl() {
        return this.f24398b;
    }

    public LEGOBaseDialogModel setImageUrl(String str) {
        this.f24398b = str;
        return this;
    }

    public int getImageResId() {
        return this.f24399c;
    }

    public LEGOBaseDialogModel setImageResId(int i) {
        this.f24399c = i;
        return this;
    }

    public int getImgPlaceHolder() {
        return this.f24400d;
    }

    public LEGOBaseDialogModel setImgPlaceHolder(int i) {
        this.f24400d = i;
        return this;
    }

    public LEGORealUsedModel convert() {
        LEGORealUsedModel lEGORealUsedModel = new LEGORealUsedModel();
        lEGORealUsedModel.mListOfBtns = this.f24397a;
        mo72120a(lEGORealUsedModel);
        convertOthers(lEGORealUsedModel);
        return lEGORealUsedModel;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72120a(LEGORealUsedModel lEGORealUsedModel) {
        if (!TextUtils.isEmpty(getImageUrl()) || getImageResId() != 0) {
            lEGORealUsedModel.mImageModel = new LEGOImgModel();
            if (getImageUrl() != null) {
                lEGORealUsedModel.mImageModel.setImgUrl(getImageUrl());
            } else if (getImageResId() != 0) {
                lEGORealUsedModel.mImageModel.setImgResId(getImageResId());
            }
            if (getImgPlaceHolder() != 0) {
                lEGORealUsedModel.mImageModel.setImgPlaceHolder(getImgPlaceHolder());
            }
        }
    }
}
