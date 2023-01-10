package com.didi.soda.business.component.image;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class BusinessImageComponent extends MvpComponent<BusinessPreviewImageView, BusinessPreviewImagePresenter> {

    /* renamed from: a */
    private OnPreviewImageListener f42245a;

    public BusinessImageComponent(ViewGroup viewGroup, OnPreviewImageListener onPreviewImageListener) {
        super(viewGroup);
        this.f42245a = onPreviewImageListener;
    }

    /* access modifiers changed from: protected */
    public BusinessPreviewImageView onCreateView() {
        return new BusinessPreviewImageView();
    }

    /* access modifiers changed from: protected */
    public BusinessPreviewImagePresenter onCreatePresenter() {
        return new BusinessPreviewImagePresenter(this.f42245a);
    }
}
