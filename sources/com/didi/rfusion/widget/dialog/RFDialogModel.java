package com.didi.rfusion.widget.dialog;

import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;

public class RFDialogModel {

    /* renamed from: a */
    private String f36273a;

    /* renamed from: b */
    private int f36274b;

    /* renamed from: c */
    private String f36275c;

    /* renamed from: d */
    private RFDialog.ActionModel f36276d;

    /* renamed from: e */
    private RFDialog.ActionModel f36277e;

    /* renamed from: f */
    private RFDialog.ActionModel f36278f;

    /* renamed from: g */
    private RFDialogInterface.OnDismissListener f36279g;

    /* renamed from: h */
    private boolean f36280h;

    /* renamed from: i */
    private boolean f36281i;

    /* renamed from: j */
    private RFDialog.CloseModel f36282j;

    /* renamed from: k */
    private boolean f36283k = true;

    public String getTitle() {
        return this.f36273a;
    }

    public void setTitle(String str) {
        this.f36273a = str;
    }

    public int getBannerRes() {
        return this.f36274b;
    }

    public void setBannerRes(int i) {
        this.f36274b = i;
        this.f36275c = null;
    }

    public String getBannerUrl() {
        return this.f36275c;
    }

    public void setBannerUrl(String str) {
        this.f36275c = str;
        this.f36274b = 0;
    }

    public RFDialog.ActionModel getMainAction() {
        return this.f36276d;
    }

    public void setMainAction(RFDialog.ActionModel actionModel) {
        this.f36276d = actionModel;
    }

    public RFDialog.ActionModel getSubAction1() {
        return this.f36277e;
    }

    public void setSubAction1(RFDialog.ActionModel actionModel) {
        this.f36277e = actionModel;
    }

    public RFDialog.ActionModel getSubAction2() {
        return this.f36278f;
    }

    public void setSubAction2(RFDialog.ActionModel actionModel) {
        this.f36278f = actionModel;
    }

    public RFDialogInterface.OnDismissListener getOnDismissListener() {
        return this.f36279g;
    }

    public void setOnDismissListener(RFDialogInterface.OnDismissListener onDismissListener) {
        this.f36279g = onDismissListener;
    }

    public void setCancelable(boolean z) {
        this.f36280h = z;
    }

    public boolean isCancelable() {
        return this.f36280h;
    }

    public void setCloseable(boolean z) {
        setCloseable(new RFDialog.CloseModel(z, (RFDialogInterface.OnClickListener) null));
    }

    public void setCloseable(RFDialog.CloseModel closeModel) {
        this.f36281i = closeModel.isCloseable;
        this.f36282j = closeModel;
    }

    public boolean isCloseable() {
        return this.f36281i;
    }

    public RFDialog.CloseModel getCloseModel() {
        return this.f36282j;
    }

    public void setAutoDismiss(boolean z) {
        this.f36283k = z;
    }

    public boolean isAutoDismiss() {
        return this.f36283k;
    }

    public void apply(RFDialogModel rFDialogModel) {
        this.f36273a = rFDialogModel.f36273a;
        this.f36274b = rFDialogModel.f36274b;
        this.f36275c = rFDialogModel.f36275c;
        this.f36276d = rFDialogModel.f36276d;
        this.f36277e = rFDialogModel.f36277e;
        this.f36278f = rFDialogModel.f36278f;
        this.f36279g = rFDialogModel.f36279g;
        this.f36280h = rFDialogModel.f36280h;
        this.f36281i = rFDialogModel.f36281i;
        this.f36282j = rFDialogModel.f36282j;
    }
}
