package com.didi.rfusion.widget.dialog;

import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.rfusion.widget.dialog.RFDialogModel;
import com.didi.rfusion.widget.dialog.RFDialogModelBuilder;

public abstract class RFDialogModelBuilder<B extends RFDialogModelBuilder, M extends RFDialogModel> {

    /* renamed from: a */
    private final RFDialogModel f36284a = new RFDialogModel();

    /* access modifiers changed from: protected */
    public abstract M createModel();

    public B setTitle(String str) {
        this.f36284a.setTitle(str);
        return this;
    }

    public B setBanner(String str) {
        this.f36284a.setBannerUrl(str);
        return this;
    }

    public B setBanner(int i) {
        this.f36284a.setBannerRes(i);
        return this;
    }

    public B setMainAction(String str, RFDialogInterface.OnClickListener onClickListener) {
        this.f36284a.setMainAction(new RFDialog.ActionModel(str, onClickListener));
        return this;
    }

    public B setSubAction1(String str, RFDialogInterface.OnClickListener onClickListener) {
        this.f36284a.setSubAction1(new RFDialog.ActionModel(str, onClickListener));
        return this;
    }

    public B setSubAction2(String str, RFDialogInterface.OnClickListener onClickListener) {
        this.f36284a.setSubAction2(new RFDialog.ActionModel(str, onClickListener));
        return this;
    }

    public B setCancelable(boolean z) {
        this.f36284a.setCancelable(z);
        return this;
    }

    public B setCloseable(boolean z) {
        this.f36284a.setCloseable(z);
        return this;
    }

    public B setCloseable(boolean z, RFDialogInterface.OnClickListener onClickListener) {
        this.f36284a.setCloseable(new RFDialog.CloseModel(z, onClickListener));
        return this;
    }

    public B setAutoDismiss(boolean z) {
        this.f36284a.setAutoDismiss(z);
        return this;
    }

    public M build() {
        M createModel = createModel();
        createModel.apply(this.f36284a);
        return createModel;
    }
}
