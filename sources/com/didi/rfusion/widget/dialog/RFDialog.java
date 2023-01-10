package com.didi.rfusion.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.RFUtils;
import com.didi.rfusion.utils.tracker.RFTrackerHelper;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.rfusion.widget.layout.RFSuperFrameLayout;
import com.taxis99.R;

public abstract class RFDialog extends Dialog {

    /* renamed from: a */
    private static final String f36252a = "RFDialog";

    /* renamed from: b */
    private static final int f36253b = 3;

    /* renamed from: c */
    private static final int f36254c = 0;

    /* renamed from: d */
    private static final int f36255d = 1;

    /* renamed from: e */
    private static final int f36256e = 2;

    /* renamed from: f */
    private ViewGroup f36257f;

    /* renamed from: g */
    private View f36258g;

    /* renamed from: h */
    private RFSuperFrameLayout f36259h;

    /* renamed from: i */
    private ImageView f36260i;
    protected boolean isShowShadow;

    /* renamed from: j */
    private TextView f36261j;

    /* renamed from: k */
    private ViewGroup f36262k;

    /* renamed from: l */
    private LinearLayout f36263l;

    /* renamed from: m */
    private RFIconView f36264m;

    /* renamed from: n */
    private SparseArray<ActionModel> f36265n;

    /* renamed from: o */
    private RFDialogModel f36266o;

    /* renamed from: p */
    private DismissListenerWrapper f36267p;

    /* renamed from: q */
    private boolean f36268q;

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
    }

    /* access modifiers changed from: protected */
    public abstract View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public RFDialog() {
        this.isShowShadow = true;
        this.f36265n = new SparseArray<>(3);
        this.f36266o = new RFDialogModel();
    }

    public RFDialog(RFDialogModel rFDialogModel) {
        this.isShowShadow = true;
        this.f36265n = new SparseArray<>(3);
        this.f36266o = rFDialogModel;
    }

    public final View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        setCancelable(false);
        this.f36257f = (ViewGroup) layoutInflater.inflate(R.layout.rf_dialog, viewGroup, false);
        m27316e();
        onCreate();
        return this.f36257f;
    }

    /* renamed from: e */
    private void m27316e() {
        this.f36259h = (RFSuperFrameLayout) findViewById(R.id.rf_sfl_frame);
        this.f36260i = (ImageView) findViewById(R.id.rf_iv_banner);
        this.f36261j = (TextView) findViewById(R.id.rf_tv_title);
        this.f36262k = (ViewGroup) findViewById(R.id.rf_fl_content_container);
        this.f36263l = (LinearLayout) findViewById(R.id.rf_ll_actions);
        this.f36264m = (RFIconView) findViewById(R.id.rf_icon_close);
        View onInflateView = onInflateView(LayoutInflater.from(getContext()), this.f36262k);
        this.f36262k.addView(onInflateView);
        this.f36258g = onInflateView;
        this.f36268q = true;
        m27317f();
    }

    /* renamed from: f */
    private void m27317f() {
        setTitle(this.f36266o.getTitle());
        if (this.f36266o.getBannerRes() > 0) {
            setBanner(this.f36266o.getBannerRes());
        }
        if (!TextUtils.isEmpty(this.f36266o.getBannerUrl())) {
            setBanner(this.f36266o.getBannerUrl());
        }
        if (this.f36266o.getMainAction() != null) {
            m27311a(0, this.f36266o.getMainAction());
        }
        if (this.f36266o.getSubAction1() != null) {
            m27311a(1, this.f36266o.getSubAction1());
        }
        if (this.f36266o.getSubAction2() != null) {
            m27311a(2, this.f36266o.getSubAction2());
        }
        setOnDismissListener(this.f36266o.getOnDismissListener());
        setCancelable(this.f36266o.isCancelable());
        m27313a(this.f36266o.getCloseModel());
    }

    public void onShow() {
        RFTrackerHelper.trackDialogShow();
    }

    public void onDismiss() {
        DismissListenerWrapper dismissListenerWrapper = this.f36267p;
        if (dismissListenerWrapper != null) {
            dismissListenerWrapper.listener.onDismiss(this, this.f36267p.bundle);
        }
    }

    public void onDestroy() {
        this.f36268q = false;
    }

    /* access modifiers changed from: protected */
    public View getContentView() {
        return this.f36258g;
    }

    /* access modifiers changed from: protected */
    public <T> T findViewById(int i) {
        return this.f36257f.findViewById(i);
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.f36257f.getContext();
    }

    /* access modifiers changed from: protected */
    public boolean isPrepared() {
        return this.f36268q;
    }

    /* access modifiers changed from: protected */
    public boolean isShadowShow() {
        return this.isShowShadow;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94125a(boolean z) {
        this.isShowShadow = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94124a(RFDialogModel rFDialogModel) {
        this.f36266o = rFDialogModel;
    }

    public void setBanner(int i) {
        if (!this.f36268q) {
            this.f36266o.setBannerRes(i);
            return;
        }
        this.f36260i.setImageResource(i);
        this.f36260i.setVisibility(0);
        m27318g();
    }

    public void setBanner(String str) {
        if (!this.f36268q) {
            this.f36266o.setBannerUrl(str);
            return;
        }
        this.f36260i.setVisibility(0);
        ((RequestBuilder) Glide.with(getContext()).load(str).placeholder((int) R.drawable.rf_img_banner_default)).into(this.f36260i);
        m27318g();
    }

    /* renamed from: g */
    private void m27318g() {
        if (this.f36268q) {
            this.f36259h.setMaxHeight((int) RFResUtils.getDimens(getContext(), R.dimen.rf_dialog_max_height));
        }
    }

    public void setTitle(String str) {
        if (!this.f36268q) {
            this.f36266o.setTitle(str);
        } else if (!TextUtils.isEmpty(str)) {
            this.f36261j.setVisibility(0);
            this.f36261j.setText(str);
        } else {
            this.f36261j.setVisibility(8);
            this.f36261j.setText((CharSequence) null);
        }
    }

    public void setMainAction(CharSequence charSequence, RFDialogInterface.OnClickListener onClickListener) {
        if (!this.f36268q) {
            this.f36266o.setMainAction(new ActionModel(charSequence, onClickListener));
        } else {
            m27311a(0, new ActionModel(charSequence, onClickListener));
        }
    }

    public void setSubAction1(CharSequence charSequence, RFDialogInterface.OnClickListener onClickListener) {
        if (!this.f36268q) {
            this.f36266o.setSubAction1(new ActionModel(charSequence, onClickListener));
        } else {
            m27311a(1, new ActionModel(charSequence, onClickListener));
        }
    }

    public void setSubAction2(CharSequence charSequence, RFDialogInterface.OnClickListener onClickListener) {
        if (!this.f36268q) {
            this.f36266o.setSubAction2(new ActionModel(charSequence, onClickListener));
        } else {
            m27311a(2, new ActionModel(charSequence, onClickListener));
        }
    }

    public void setOnDismissListener(RFDialogInterface.OnDismissListener onDismissListener) {
        if (!this.f36268q) {
            this.f36266o.setOnDismissListener(onDismissListener);
        } else if (onDismissListener == null) {
            this.f36267p = null;
        } else {
            DismissListenerWrapper dismissListenerWrapper = new DismissListenerWrapper();
            this.f36267p = dismissListenerWrapper;
            dismissListenerWrapper.listener = onDismissListener;
        }
    }

    public void show(ScopeContext scopeContext, String str) {
        if (scopeContext != null) {
            scopeContext.getNavigator().showDialog(this, str);
        }
    }

    public void dismiss(Bundle bundle) {
        dismiss();
        DismissListenerWrapper dismissListenerWrapper = this.f36267p;
        if (dismissListenerWrapper != null) {
            dismissListenerWrapper.bundle = bundle;
        }
    }

    public String getTitle() {
        if (!this.f36268q) {
            return this.f36266o.getTitle();
        }
        return this.f36261j.getText().toString();
    }

    /* renamed from: a */
    private void m27311a(int i, ActionModel actionModel) {
        this.f36265n.put(i, actionModel);
        m27319h();
    }

    /* renamed from: h */
    private void m27319h() {
        this.f36263l.removeAllViews();
        boolean z = this.f36265n.size() >= 3 && !RFUtils.isPadFlavor();
        this.f36263l.setOrientation(z ? 1 : 0);
        int i = 0;
        while (i < 3) {
            ActionModel actionModel = this.f36265n.get(i);
            if (actionModel != null) {
                View a = m27310a(z, i == 0, actionModel);
                if (z) {
                    this.f36263l.addView(a);
                } else {
                    this.f36263l.addView(a, 0);
                }
                if (i < this.f36265n.size() - 1) {
                    if (z) {
                        this.f36263l.addView(m27315b(z));
                    } else {
                        this.f36263l.addView(m27315b(z), 0);
                    }
                }
            }
            i++;
        }
    }

    /* renamed from: a */
    private View m27310a(boolean z, boolean z2, ActionModel actionModel) {
        LinearLayout.LayoutParams layoutParams;
        RFTextView rFTextView = (RFTextView) LayoutInflater.from(getContext()).inflate(R.layout.rf_layout_dialog_action, this.f36263l, false);
        int dimens = (int) RFResUtils.getDimens(R.dimen.rf_dialog_action_height);
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, dimens);
        } else {
            layoutParams = new LinearLayout.LayoutParams(0, dimens);
            layoutParams.weight = 1.0f;
        }
        rFTextView.setLayoutParams(layoutParams);
        rFTextView.setTypeface(z2 ? 1 : 3);
        rFTextView.setTextColor(RFResUtils.getColor(z2 ? R.color.rf_color_brands_1_100 : R.color.rf_color_gery_2_40_666666));
        rFTextView.setText(actionModel.text);
        rFTextView.setOnClickListener(new View.OnClickListener(actionModel) {
            public final /* synthetic */ RFDialog.ActionModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                RFDialog.this.m27312a(this.f$1, view);
            }
        });
        return rFTextView;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27312a(ActionModel actionModel, View view) {
        if (actionModel.listener != null) {
            actionModel.listener.onClick(this);
        }
        if (this.f36266o.isAutoDismiss()) {
            dismiss();
        }
    }

    /* renamed from: b */
    private View m27315b(boolean z) {
        LinearLayout.LayoutParams layoutParams;
        View view = new View(getContext());
        int dimens = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_1);
        int dimens2 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_dialog_action_height);
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, dimens);
        } else {
            layoutParams = new LinearLayout.LayoutParams(dimens, dimens2);
        }
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_5_90_E5E5E5));
        return view;
    }

    /* renamed from: a */
    private void m27313a(CloseModel closeModel) {
        if (closeModel != null) {
            this.f36264m.setVisibility(closeModel.isCloseable ? 0 : 8);
            this.f36264m.setOnClickListener(new View.OnClickListener(closeModel) {
                public final /* synthetic */ RFDialog.CloseModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    RFDialog.this.m27314a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27314a(CloseModel closeModel, View view) {
        dismiss();
        if (closeModel.listener != null) {
            closeModel.listener.onClick(this);
        }
    }

    private static class DismissListenerWrapper {
        Bundle bundle;
        RFDialogInterface.OnDismissListener listener;

        private DismissListenerWrapper() {
        }
    }

    public static class ActionModel implements Cloneable {
        public RFDialogInterface.OnClickListener listener;
        public CharSequence text;

        public ActionModel(CharSequence charSequence, RFDialogInterface.OnClickListener onClickListener) {
            this.text = charSequence;
            this.listener = onClickListener;
        }
    }

    public static class CloseModel implements Cloneable {
        public boolean isCloseable;
        public RFDialogInterface.OnClickListener listener;

        public CloseModel(boolean z, RFDialogInterface.OnClickListener onClickListener) {
            this.isCloseable = z;
            this.listener = onClickListener;
        }
    }
}
