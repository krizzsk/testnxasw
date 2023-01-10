package com.didi.soda.business.component.image;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.business.component.image.Contract;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.repo.RepoFactory;
import java.io.Serializable;

public class BusinessPreviewImagePresenter extends Contract.AbsBusinessImagePresenter {

    /* renamed from: a */
    private OnPreviewImageListener f42246a;

    /* renamed from: b */
    private BusinessOmegaHelper f42247b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f42248c;

    /* renamed from: d */
    private String f42249d;

    /* renamed from: e */
    private PreviewImageModel f42250e;

    /* renamed from: f */
    private boolean f42251f;

    public BusinessPreviewImagePresenter(OnPreviewImageListener onPreviewImageListener) {
        this.f42246a = onPreviewImageListener;
    }

    public void finish(int i) {
        PreviewImageModel previewImageModel = this.f42250e;
        m31754a().onPreviewImageCloseCk(previewImageModel != null ? previewImageModel.mGoodId : "0", i);
        getScopeContext().getNavigator().finish();
    }

    public void clickAddBtn(PreviewImageModel previewImageModel) {
        OnPreviewImageListener onPreviewImageListener = this.f42246a;
        if (onPreviewImageListener != null) {
            onPreviewImageListener.onClickAddEvent(previewImageModel);
            ((PreviewImageRepo) RepoFactory.getRepo(PreviewImageRepo.class)).clickAdd(previewImageModel);
        }
    }

    public void onBigImageSw(PreviewImageModel previewImageModel) {
        if (!this.f42251f) {
            m31754a().onPreviewImageSw(previewImageModel);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        Serializable serializable = getScopeContext().getBundle().getSerializable(Const.PageParams.PREVIEW_IMAGE);
        if (serializable instanceof PreviewImageModel) {
            PreviewImageModel previewImageModel = (PreviewImageModel) serializable;
            this.f42250e = previewImageModel;
            ((Contract.AbsBusinessImageView) getLogicView()).updateView(previewImageModel);
            this.f42249d = previewImageModel.mShopId;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(previewImageModel.mShopId, getScopeContext(), new Action1<BusinessState>() {
                public void call(BusinessState businessState) {
                    int unused = BusinessPreviewImagePresenter.this.f42248c = businessState.shopStatus;
                    BusinessPreviewImagePresenter.this.m31754a().updateBusinessStatus(BusinessPreviewImagePresenter.this.f42248c);
                }
            });
            return;
        }
        LogUtil.m32586e("TAG", "传入的数据不正确");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f42251f = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public BusinessOmegaHelper m31754a() {
        if (this.f42247b == null) {
            this.f42247b = new BusinessOmegaHelper(getScopeContext(), this.f42249d, this.f42248c);
        }
        return this.f42247b;
    }
}
