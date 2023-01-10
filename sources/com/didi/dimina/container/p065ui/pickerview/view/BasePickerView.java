package com.didi.dimina.container.p065ui.pickerview.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.p065ui.pickerview.configure.PickerOptions;
import com.didi.dimina.container.p065ui.pickerview.listener.OnDismissListener;
import com.didi.dimina.container.p065ui.pickerview.utils.PickerViewAnimateUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.pickerview.view.BasePickerView */
public class BasePickerView {

    /* renamed from: a */
    private final Context f19485a;
    protected int animGravity = 80;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f19486b;

    /* renamed from: c */
    private ViewGroup f19487c;
    protected View clickView;
    protected ViewGroup contentContainer;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnDismissListener f19488d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f19489e;

    /* renamed from: f */
    private Animation f19490f;

    /* renamed from: g */
    private Animation f19491g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f19492h;

    /* renamed from: i */
    private Dialog f19493i;

    /* renamed from: j */
    private boolean f19494j = true;

    /* renamed from: k */
    private final View.OnKeyListener f19495k = new View.OnKeyListener() {
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 0 || !BasePickerView.this.isShowing()) {
                return false;
            }
            BasePickerView.this.dismiss();
            return true;
        }
    };

    /* renamed from: l */
    private final View.OnTouchListener f19496l = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BasePickerView.this.dismiss();
            return false;
        }
    };
    protected PickerOptions mPickerOptions;

    /* access modifiers changed from: protected */
    public void initEvents() {
    }

    public boolean isDialog() {
        return false;
    }

    public BasePickerView(Context context) {
        this.f19485a = context;
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.f19485a);
        if (isDialog()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.dimina_layout_basepickerview, (ViewGroup) null, false);
            this.f19487c = viewGroup;
            viewGroup.setBackgroundColor(0);
            this.contentContainer = (ViewGroup) this.f19487c.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.contentContainer.setLayoutParams(layoutParams);
            createDialog();
            this.f19487c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BasePickerView.this.dismiss();
                }
            });
        } else {
            if (this.mPickerOptions.decorView == null) {
                this.mPickerOptions.decorView = (ViewGroup) ((Activity) this.f19485a).getWindow().getDecorView();
            }
            ViewGroup viewGroup2 = (ViewGroup) from.inflate(R.layout.dimina_layout_basepickerview, this.mPickerOptions.decorView, false);
            this.f19486b = viewGroup2;
            viewGroup2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.mPickerOptions.outSideColor != -1) {
                this.f19486b.setBackgroundColor(this.mPickerOptions.outSideColor);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f19486b.findViewById(R.id.content_container);
            this.contentContainer = viewGroup3;
            viewGroup3.setLayoutParams(layoutParams);
        }
        setKeyBackCancelable(true);
    }

    /* access modifiers changed from: protected */
    public void initAnim() {
        this.f19491g = m16537a();
        this.f19490f = m16540b();
    }

    public void show(View view, boolean z) {
        this.clickView = view;
        this.f19494j = z;
        show();
    }

    public void show(boolean z) {
        show((View) null, z);
    }

    public void show(View view) {
        this.clickView = view;
        show();
    }

    public void show() {
        if (isDialog()) {
            m16543c();
        } else if (!isShowing()) {
            this.f19492h = true;
            m16538a((View) this.f19486b);
            this.f19486b.requestFocus();
        }
    }

    /* renamed from: a */
    private void m16538a(View view) {
        this.mPickerOptions.decorView.addView(view);
        if (this.f19494j) {
            this.contentContainer.startAnimation(this.f19491g);
        }
    }

    public boolean isShowing() {
        if (isDialog()) {
            return false;
        }
        if (this.f19486b.getParent() != null || this.f19492h) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        if (isDialog()) {
            m16544d();
        } else if (!this.f19489e) {
            if (this.f19494j) {
                this.f19490f.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        BasePickerView.this.dismissImmediately();
                    }
                });
                this.contentContainer.startAnimation(this.f19490f);
            } else {
                dismissImmediately();
            }
            this.f19489e = true;
        }
    }

    public void dismissImmediately() {
        this.mPickerOptions.decorView.post(new Runnable() {
            public void run() {
                BasePickerView.this.mPickerOptions.decorView.removeView(BasePickerView.this.f19486b);
                boolean unused = BasePickerView.this.f19492h = false;
                boolean unused2 = BasePickerView.this.f19489e = false;
                if (BasePickerView.this.f19488d != null) {
                    BasePickerView.this.f19488d.onDismiss(BasePickerView.this);
                }
            }
        });
    }

    /* renamed from: a */
    private Animation m16537a() {
        return AnimationUtils.loadAnimation(this.f19485a, PickerViewAnimateUtil.getAnimationResource(this.animGravity, true));
    }

    /* renamed from: b */
    private Animation m16540b() {
        return AnimationUtils.loadAnimation(this.f19485a, PickerViewAnimateUtil.getAnimationResource(this.animGravity, false));
    }

    public BasePickerView setOnDismissListener(OnDismissListener onDismissListener) {
        this.f19488d = onDismissListener;
        return this;
    }

    public void setKeyBackCancelable(boolean z) {
        ViewGroup viewGroup;
        if (isDialog()) {
            viewGroup = this.f19487c;
        } else {
            viewGroup = this.f19486b;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.f19495k);
        } else {
            viewGroup.setOnKeyListener((View.OnKeyListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public BasePickerView setOutSideCancelable(boolean z) {
        ViewGroup viewGroup = this.f19486b;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.f19496l);
            } else {
                findViewById.setOnTouchListener((View.OnTouchListener) null);
            }
        }
        return this;
    }

    public void setDialogOutSideCancelable() {
        Dialog dialog = this.f19493i;
        if (dialog != null) {
            dialog.setCancelable(this.mPickerOptions.cancelable);
        }
    }

    public View findViewById(int i) {
        return this.contentContainer.findViewById(i);
    }

    public void createDialog() {
        if (this.f19487c != null) {
            Dialog dialog = new Dialog(this.f19485a, R.style.dimina_pickview_custom_dialog);
            this.f19493i = dialog;
            dialog.setCancelable(this.mPickerOptions.cancelable);
            this.f19493i.setContentView(this.f19487c);
            Window window = this.f19493i.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.dimina_picker_view_scale_anim);
                window.setGravity(17);
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
            }
            this.f19493i.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (BasePickerView.this.f19488d != null) {
                        BasePickerView.this.f19488d.onDismiss(BasePickerView.this);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    private void m16543c() {
        if (this.f19493i != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            getDialogContainerLayout().setLayoutParams(layoutParams);
            Window window = this.f19493i.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.dimina_picker_view_slide_anim);
                window.setGravity(80);
                window.setDimAmount(0.3f);
            }
            SystemUtils.showDialog(this.f19493i);
        }
    }

    /* renamed from: d */
    private void m16544d() {
        Dialog dialog = this.f19493i;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public ViewGroup getDialogContainerLayout() {
        return this.contentContainer;
    }

    public Dialog getDialog() {
        return this.f19493i;
    }
}
