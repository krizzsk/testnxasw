package com.didi.sdk.fastframe.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fastframe.presenter.IPresenter;
import com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment;
import com.didi.sdk.login.view.CommonDialog;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.lang.reflect.InvocationTargetException;

public abstract class BaseActivity extends InstanceStateActivity implements IView {
    protected static final int COMMON_REQUEST_CODE = 1;

    /* renamed from: a */
    static final int f38657a = 20;

    /* renamed from: b */
    private ProgressDialogFragment f38658b = null;

    /* renamed from: c */
    private boolean f38659c = false;

    /* renamed from: d */
    private Toast f38660d = null;

    /* renamed from: e */
    private CommonDialog f38661e = null;

    /* renamed from: f */
    private Toolbar f38662f = null;

    /* renamed from: g */
    private ImageView f38663g = null;

    /* renamed from: h */
    private TextView f38664h = null;

    /* renamed from: i */
    private ViewGroup f38665i = null;

    /* renamed from: j */
    private ViewGroup f38666j = null;

    /* renamed from: k */
    private ViewStub f38667k = null;

    /* renamed from: l */
    private ViewGroup f38668l = null;

    /* renamed from: m */
    private TextView f38669m = null;
    @SavedInstance

    /* renamed from: n */
    private boolean f38670n = false;

    public abstract void loadContentView(Bundle bundle);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ProgressDialogFragment progressDialogFragment;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        super.setContentView((int) R.layout.one_fastframe_activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        this.f38662f = toolbar;
        setSupportActionBar(toolbar);
        this.f38662f.setNavigationIcon((int) R.drawable.one_fastframe_titlebar_selector);
        this.f38662f.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BaseActivity.this.finish();
            }
        });
        super.setTitle("");
        if (!(bundle == null || getSupportFragmentManager() == null || (progressDialogFragment = (ProgressDialogFragment) getSupportFragmentManager().findFragmentByTag(ProgressDialogFragment.class.getSimpleName())) == null)) {
            progressDialogFragment.dismiss();
        }
        if (this.f38658b == null) {
            this.f38658b = new ProgressDialogFragment();
        }
        this.f38663g = (ImageView) findViewById(R.id.image_title_default);
        this.f38664h = (TextView) findViewById(R.id.txt_title);
        this.f38665i = (ViewGroup) findViewById(R.id.layout_title);
        this.f38666j = (ViewGroup) findViewById(R.id.layout_content);
        this.f38669m = (TextView) findViewById(R.id.txt_menu);
    }

    public void setContentView(int i) {
        if (this.f38666j != null) {
            LayoutInflater.from(this).inflate(i, this.f38666j);
        }
    }

    public void setTitle(String str) {
        super.setTitle("");
        TextView textView = this.f38664h;
        if (textView != null) {
            textView.setText(str);
            this.f38664h.setVisibility(0);
        }
        ViewGroup viewGroup = this.f38665i;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str)) {
            setTitleTextVisible(true);
        }
    }

    /* access modifiers changed from: protected */
    public void setNavigationBack(boolean z) {
        if (z) {
            this.f38662f.setNavigationIcon((int) R.drawable.one_fastframe_titlebar_selector);
        } else {
            this.f38662f.setNavigationIcon((Drawable) null);
        }
    }

    public void setToolbarVisibility(int i) {
        Toolbar toolbar = this.f38662f;
        if (toolbar != null) {
            toolbar.setVisibility(i);
        }
    }

    public void setTitle(View view) {
        super.setTitle("");
        TextView textView = this.f38664h;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ViewGroup viewGroup = this.f38665i;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            this.f38665i.removeAllViews();
            this.f38665i.addView(view);
        }
    }

    public void setTitleTextVisible(boolean z) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        TextView textView = this.f38664h;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        if (z && (viewGroup2 = this.f38665i) != null) {
            viewGroup2.setVisibility(8);
        }
        if (z || ((viewGroup = this.f38665i) != null && viewGroup.getVisibility() == 0)) {
            this.f38663g.setVisibility(8);
        } else {
            this.f38663g.setVisibility(0);
        }
    }

    public void setTitleViewVisible(boolean z) {
        TextView textView;
        TextView textView2;
        ViewGroup viewGroup = this.f38665i;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
        if (z && (textView2 = this.f38664h) != null) {
            textView2.setVisibility(8);
        }
        if (z || ((textView = this.f38664h) != null && textView.getVisibility() == 0)) {
            this.f38663g.setVisibility(8);
        } else {
            this.f38663g.setVisibility(0);
        }
    }

    public void setSingleMenu(String str, View.OnClickListener onClickListener) {
        if (this.f38669m == null) {
            return;
        }
        if (TextUtils.isEmpty(str) || onClickListener == null) {
            this.f38669m.setVisibility(8);
            this.f38669m.setText((CharSequence) null);
            this.f38669m.setOnClickListener((View.OnClickListener) null);
            return;
        }
        this.f38669m.setVisibility(0);
        this.f38669m.setText(str);
        this.f38669m.setOnClickListener(onClickListener);
    }

    public ViewGroup getTitleLayout() {
        return this.f38665i;
    }

    public ViewGroup getContentLayout() {
        return this.f38666j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r1 = getSupportFragmentManager();
        r2 = java.lang.Class.forName("androidx.fragment.app.FragmentManagerImpl").getDeclaredField("mStateSaved");
        r2.setAccessible(true);
        r2.set(r1, false);
        r4.f38658b.setContent(r5, r6);
        r4.f38658b.show(r1, r4.f38658b.getClass().getSimpleName());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showProgressDialog(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            r0 = 1
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r1 = r4.f38658b     // Catch:{ Exception -> 0x002f }
            r1.setContent(r5, r6)     // Catch:{ Exception -> 0x002f }
            boolean r1 = r4.f38659c     // Catch:{ Exception -> 0x002f }
            if (r1 == 0) goto L_0x000b
            return
        L_0x000b:
            androidx.fragment.app.FragmentManager r1 = r4.getSupportFragmentManager()     // Catch:{ Exception -> 0x002f }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r2 = r4.f38658b     // Catch:{ Exception -> 0x002f }
            boolean r2 = r2.isAdded()     // Catch:{ Exception -> 0x002f }
            if (r2 != 0) goto L_0x005e
            r4.f38659c = r0     // Catch:{ Exception -> 0x002f }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r2 = r4.f38658b     // Catch:{ Exception -> 0x002f }
            java.lang.Class<com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment> r3 = com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment.class
            java.lang.String r3 = r3.getSimpleName()     // Catch:{ Exception -> 0x002f }
            r2.show((androidx.fragment.app.FragmentManager) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x002f }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r1 = r4.f38658b     // Catch:{ Exception -> 0x002f }
            com.didi.sdk.fastframe.view.BaseActivity$2 r2 = new com.didi.sdk.fastframe.view.BaseActivity$2     // Catch:{ Exception -> 0x002f }
            r2.<init>()     // Catch:{ Exception -> 0x002f }
            r1.setmCancelListener(r2)     // Catch:{ Exception -> 0x002f }
            goto L_0x005e
        L_0x002f:
            androidx.fragment.app.FragmentManager r1 = r4.getSupportFragmentManager()     // Catch:{ Exception -> 0x005e }
            java.lang.String r2 = "androidx.fragment.app.FragmentManagerImpl"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = "mStateSaved"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x005e }
            r2.setAccessible(r0)     // Catch:{ Exception -> 0x005e }
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x005e }
            r2.set(r1, r0)     // Catch:{ Exception -> 0x005e }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r0 = r4.f38658b     // Catch:{ Exception -> 0x005e }
            r0.setContent(r5, r6)     // Catch:{ Exception -> 0x005e }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r5 = r4.f38658b     // Catch:{ Exception -> 0x005e }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r6 = r4.f38658b     // Catch:{ Exception -> 0x005e }
            java.lang.Class r6 = r6.getClass()     // Catch:{ Exception -> 0x005e }
            java.lang.String r6 = r6.getSimpleName()     // Catch:{ Exception -> 0x005e }
            r5.show((androidx.fragment.app.FragmentManager) r1, (java.lang.String) r6)     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.fastframe.view.BaseActivity.showProgressDialog(java.lang.String, boolean):void");
    }

    public void showProgressDialog(boolean z) {
        showProgressDialog(getString(R.string.one_fastframe_waiting), z);
    }

    public void dismissProgressDialog() {
        try {
            this.f38659c = false;
            this.f38658b.dismiss();
        } catch (Exception unused) {
        }
    }

    public void showDialog(String str, String str2, String str3, String str4, CommonDialog.ButtonType buttonType, CommonDialog.CommonDialogListener commonDialogListener) {
        CommonDialog commonDialog = this.f38661e;
        if (commonDialog != null) {
            commonDialog.dismiss();
        }
        CommonDialog commonDialog2 = new CommonDialog(this);
        this.f38661e = commonDialog2;
        commonDialog2.setCheckboxVisibility(false);
        this.f38661e.setIconVisible(TextUtils.isEmpty(str));
        CommonDialog commonDialog3 = this.f38661e;
        if (TextUtils.isEmpty(str3)) {
            str3 = getString(R.string.one_fastframe_confirm);
        }
        commonDialog3.setSubmitBtnText(str3);
        CommonDialog commonDialog4 = this.f38661e;
        if (TextUtils.isEmpty(str4)) {
            str4 = getString(R.string.one_fastframe_cancel);
        }
        commonDialog4.setCancelBtnText(str4);
        this.f38661e.setButtonType(buttonType);
        this.f38661e.setTitleContent(str, str2);
        this.f38661e.setListener(commonDialogListener);
        SystemUtils.showDialog(this.f38661e);
    }

    public void showToastComplete(String str) {
        if (str != null) {
            showToastComplete(str, str.length() > 20);
        }
    }

    public void showToastComplete(String str, boolean z) {
        if (str != null) {
            if (z) {
                ToastHelper.showLongCompleteMessage((Context) this, str);
            } else {
                ToastHelper.showShortCompleted((Context) this, str);
            }
        }
    }

    public void showToastInfo(String str) {
        if (str != null) {
            showToastInfo(str, str.length() > 20);
        }
    }

    public void showToastInfo(String str, boolean z) {
        if (str != null) {
            if (z) {
                ToastHelper.showLongInfo((Context) this, str);
            } else {
                ToastHelper.showShortInfo((Context) this, str);
            }
        }
    }

    public void showToastError(String str) {
        if (str != null) {
            showToastError(str, str.length() > 20);
        }
    }

    public void showToastError(String str, boolean z) {
        if (str != null) {
            if (z) {
                ToastHelper.showLongError((Context) this, str);
            } else {
                ToastHelper.showShortError((Context) this, str);
            }
        }
    }

    @Deprecated
    public void showToast(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            if (str.length() > 20) {
                i = 1;
            }
            Toast toast = this.f38660d;
            if (toast != null) {
                toast.cancel();
            }
            Toast makeText = Toast.makeText(this, str, i);
            this.f38660d = makeText;
            SystemUtils.showToast(makeText);
        }
    }

    public void showContentView() {
        this.f38670n = false;
        ViewGroup viewGroup = this.f38666j;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.f38668l;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
    }

    public void showEmptyView() {
        this.f38670n = true;
        ViewGroup viewGroup = this.f38666j;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (this.f38667k == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.viewstub_empty);
            this.f38667k = viewStub;
            viewStub.inflate();
            this.f38668l = (ViewGroup) findViewById(R.id.layout_empty);
        }
        ViewGroup viewGroup2 = this.f38668l;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
            this.f38668l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BaseActivity.this.loadContentView((Bundle) null);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (this.f38670n) {
            showEmptyView();
        } else {
            showContentView();
        }
    }

    public boolean inContentView() {
        ViewGroup viewGroup = this.f38666j;
        if (viewGroup == null || viewGroup.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public <P extends IPresenter> P getPresenter(Class<P> cls) {
        if (cls == null) {
            return null;
        }
        try {
            return (IPresenter) cls.getConstructors()[0].newInstance(new Object[]{this, this});
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f38660d = null;
    }
}
