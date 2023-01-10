package com.didi.dimina.container.p065ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.util.ColorUtil;
import com.didi.dimina.container.util.LogUtil;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.dialog.BaseModal */
public class BaseModal extends Dialog {

    /* renamed from: a */
    private View f19428a;

    /* renamed from: b */
    private TextView f19429b;

    /* renamed from: c */
    private RelativeLayout f19430c;

    /* renamed from: d */
    private EditText f19431d;

    /* renamed from: e */
    private ImageView f19432e;

    /* renamed from: f */
    private LinearLayout f19433f;

    /* renamed from: g */
    private FrameLayout f19434g;

    /* renamed from: h */
    private View f19435h;

    /* renamed from: i */
    private ImageView f19436i;

    /* renamed from: j */
    private boolean f19437j;

    /* renamed from: k */
    private boolean f19438k;

    /* renamed from: l */
    private boolean f19439l;
    protected Button mBtnCancel;
    protected Button mBtnSubmit;
    protected View mDivideLine;
    protected View mImgIcon;

    public BaseModal(Context context) {
        this(context, 0);
    }

    public BaseModal(Context context, int i) {
        super(context, i);
        this.f19437j = false;
        m16499a();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = getWindowWidth();
        getWindow().setAttributes(attributes);
    }

    public int getWindowWidth() {
        DisplayMetrics displayMetrics;
        if (getContext() == null || (displayMetrics = getContext().getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    /* renamed from: a */
    private void m16499a() {
        super.setContentView(R.layout.dimina_common_modal);
        View findViewById = findViewById(R.id.layout_title);
        this.f19428a = findViewById;
        findViewById.setVisibility(8);
        this.f19429b = (TextView) findViewById(R.id.title_tv);
        View findViewById2 = findViewById(R.id.ivIcon);
        this.mImgIcon = findViewById2;
        findViewById2.setVisibility(8);
        this.f19432e = (ImageView) findViewById(R.id.ivIconTitle);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.iconTitleLayout);
        this.f19434g = frameLayout;
        frameLayout.setVisibility(8);
        this.f19435h = findViewById(R.id.iconTitlebg);
        this.f19433f = (LinearLayout) findViewById(R.id.msg_layout);
        this.f19430c = (RelativeLayout) findViewById(R.id.layout_content);
        this.f19431d = (EditText) findViewById(R.id.content_et);
        this.mDivideLine = findViewById(R.id.item_btn_sep);
        this.f19436i = (ImageView) findViewById(R.id.imgTitleBg);
        this.mBtnSubmit = (Button) findViewById(R.id.submit_btn);
        this.mBtnCancel = (Button) findViewById(R.id.cancel_btn);
        reset();
    }

    public void reset() {
        this.f19429b.setText("");
        this.f19428a.setVisibility(8);
        this.mBtnSubmit.setText(R.string.dimina_base_modal_confirm);
        this.mBtnCancel.setText(R.string.dimina_base_modal_cancel);
        this.mBtnCancel.setVisibility(8);
        this.mDivideLine.setVisibility(8);
        this.f19431d.setVisibility(8);
        this.f19431d.setHint("");
        this.f19431d.setText("");
        this.f19438k = false;
        this.f19439l = false;
        this.f19431d.setFocusableInTouchMode(true);
        this.f19431d.setFocusable(true);
        this.f19431d.setBackground(getContext().getResources().getDrawable(R.drawable.dimina_common_modal_edit_background));
        this.f19430c.removeAllViews();
    }

    public void setDialogTitle(int i) {
        setDialogTitle(getContext().getString(i));
    }

    public void setDialogTitle(String str) {
        this.f19428a.setVisibility(0);
        this.f19429b.setText(str);
    }

    public void setTitleSize(int i, float f) {
        this.f19429b.setTextSize(i, f);
    }

    public void setPositiveButtonText(String str) {
        this.mBtnSubmit.setText(str);
        this.mBtnSubmit.setVisibility(0);
    }

    public void setPositiveButtonTextColor(String str) {
        this.mBtnSubmit.setTextColor(ColorUtil.parseColor(ColorUtil.convert3To6(str), "#87CEEB"));
    }

    public void setPositiveButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mBtnSubmit.setOnClickListener(onClickListener);
        } else {
            this.mBtnSubmit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BaseModal.this.dismiss();
                }
            });
        }
    }

    public void setNegativeButton(String str) {
        this.mBtnCancel.setText(str);
        if (this.f19437j) {
            this.mBtnCancel.setVisibility(0);
            this.mDivideLine.setVisibility(0);
        }
    }

    public void setNegativeButtonTextColor(String str) {
        this.mBtnCancel.setTextColor(ColorUtil.parseColor(ColorUtil.convert3To6(str), "#333333"));
    }

    public void setNegativeButtonListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mBtnCancel.setOnClickListener(onClickListener);
        } else {
            this.mBtnCancel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BaseModal.this.dismiss();
                }
            });
        }
    }

    public void setView(View view) {
        if (!(view == null || view.getParent() == null)) {
            ((ViewGroup) view.getParent()).removeAllViews();
        }
        this.f19430c.addView(view, new RelativeLayout.LayoutParams(-1, -2));
    }

    public void setView(int i) {
        setView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    public void setContent(String str) {
        this.f19438k = true;
        this.f19431d.setVisibility(0);
        this.f19431d.setText(str);
    }

    public void setPlaceholderText(String str) {
        this.f19431d.setHint(str);
    }

    public void setModalEditable(boolean z) {
        this.f19439l = z;
    }

    public void show() {
        Context context = getContext();
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) {
                LogUtil.m16839e("show dialog bug activity int wrong , activity is finishing ");
                return;
            } else if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                LogUtil.m16839e("show dialog bug activity int wrong , activity is isDestroyed ");
                return;
            }
        } else if (context instanceof ContextThemeWrapper) {
            Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                Activity activity2 = (Activity) baseContext;
                if (activity2.isFinishing()) {
                    LogUtil.m16839e("show dialog bug activity int wrong , baseActivity is finishing ");
                    return;
                } else if (Build.VERSION.SDK_INT >= 17 && activity2.isDestroyed()) {
                    LogUtil.m16839e("show dialog bug activity int wrong , baseActivity is isDestroyed ");
                    return;
                }
            }
        } else {
            LogUtil.m16839e("context is not a Activity or a ContextThemeWrapper");
            return;
        }
        m16500b();
        super.show();
    }

    /* renamed from: b */
    private void m16500b() {
        if (this.f19438k && !this.f19439l) {
            this.f19431d.setBackground((Drawable) null);
            this.f19431d.setFocusableInTouchMode(false);
            this.f19431d.setFocusable(false);
            this.f19431d.setGravity(17);
        } else if (!this.f19439l) {
            this.f19431d.setVisibility(8);
        } else if (!this.f19438k) {
            this.f19431d.setVisibility(0);
        }
    }

    public String getContent() {
        return this.f19439l ? this.f19431d.getText().toString() : "";
    }

    public void setTitleTVMarginTop(int i) {
        if (this.f19430c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f19430c.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, i, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            this.f19430c.requestLayout();
        }
    }

    public void showDialog(boolean z) {
        try {
            setCancelable(z);
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FrameLayout getmIconTitleLayout() {
        return this.f19434g;
    }

    public LinearLayout getmMsgLayout() {
        return this.f19433f;
    }

    public ImageView getmImgTitleBg() {
        return this.f19436i;
    }

    public void setShowCancel(boolean z) {
        this.f19437j = z;
        int i = 0;
        this.mBtnCancel.setVisibility(z ? 0 : 8);
        View view = this.mDivideLine;
        if (!this.f19437j) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public boolean isShowCancel() {
        return this.f19437j;
    }
}
