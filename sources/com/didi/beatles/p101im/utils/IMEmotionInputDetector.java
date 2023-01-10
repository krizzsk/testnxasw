package com.didi.beatles.p101im.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.views.bottombar.IMBottomSkinManager;
import com.didi.beatles.p101im.views.bottombar.IMConversationBottomBar;
import com.didi.beatles.p101im.views.bottombar.IMSkinTextView;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.utils.IMEmotionInputDetector */
public class IMEmotionInputDetector {

    /* renamed from: b */
    private static final String f11590b = IMEmotionInputDetector.class.getSimpleName();

    /* renamed from: c */
    private static final String f11591c = "com.dss886.emotioninputdetector";

    /* renamed from: d */
    private static final String f11592d = "soft_input_height";
    public static int keyboardHeight = 0;

    /* renamed from: a */
    IMConversationBottomBar f11593a;

    /* renamed from: e */
    private Activity f11594e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public InputMethodManager f11595f;

    /* renamed from: g */
    private SharedPreferences f11596g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f11597h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public EditText f11598i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f11599j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IMSkinTextView f11600k;

    /* renamed from: l */
    private List<OnHideSoftInputListener> f11601l = new ArrayList();

    /* renamed from: com.didi.beatles.im.utils.IMEmotionInputDetector$OnHideSoftInputListener */
    public interface OnHideSoftInputListener {
        void onHideSoft(IMEmotionInputDetector iMEmotionInputDetector);
    }

    private IMEmotionInputDetector() {
    }

    public static IMEmotionInputDetector with(Activity activity) {
        IMEmotionInputDetector iMEmotionInputDetector = new IMEmotionInputDetector();
        iMEmotionInputDetector.f11594e = activity;
        iMEmotionInputDetector.f11595f = (InputMethodManager) activity.getSystemService("input_method");
        iMEmotionInputDetector.f11596g = SystemUtils.getSharedPreferences(activity, f11591c, 0);
        keyboardHeight = iMEmotionInputDetector.getKeyboardHeight();
        return iMEmotionInputDetector;
    }

    public void addListener(OnHideSoftInputListener onHideSoftInputListener) {
        this.f11601l.add(onHideSoftInputListener);
    }

    public void removeListener(OnHideSoftInputListener onHideSoftInputListener) {
        this.f11601l.remove(onHideSoftInputListener);
    }

    public IMEmotionInputDetector bindToContent(View view) {
        this.f11599j = view;
        return this;
    }

    public IMEmotionInputDetector bindToEditText(EditText editText) {
        this.f11598i = editText;
        editText.requestFocus();
        this.f11598i.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    IMEmotionInputDetector.this.f11600k.showCommonSkin();
                }
                if (motionEvent.getAction() != 1 || !IMEmotionInputDetector.this.f11597h.isShown()) {
                    return false;
                }
                IMEmotionInputDetector.this.m9997b();
                IMEmotionInputDetector.this.m9993a(true);
                IMEmotionInputDetector.this.f11598i.postDelayed(new Runnable() {
                    public void run() {
                        IMEmotionInputDetector.this.m10000d();
                    }
                }, 200);
                return false;
            }
        });
        return this;
    }

    public IMEmotionInputDetector bindToCommonButton(View view) {
        this.f11600k = (IMSkinTextView) view;
        return this;
    }

    public boolean isTagExpandShow(String str) {
        return this.f11597h.isShown() && str.equals(this.f11597h.getTag());
    }

    public void changeExpandView(String str, boolean z) {
        if (str.equals(this.f11597h.getTag()) || !this.f11597h.isShown()) {
            m9991a((View) this.f11600k);
        }
        this.f11597h.setTag(str);
        IMSkinTextView iMSkinTextView = this.f11600k;
        if (iMSkinTextView == null) {
            return;
        }
        if (!z) {
            iMSkinTextView.showCommonSkin();
        } else if (this.f11597h.isShown()) {
            this.f11600k.showCustomSkin(IMBottomSkinManager.KEY_BOARD);
        } else {
            this.f11600k.showCommonSkin();
        }
    }

    /* renamed from: a */
    private void m9991a(View view) {
        if (this.f11597h.isShown()) {
            m9997b();
            m9993a(true);
            m10000d();
        } else {
            if (isSoftInputShown()) {
                m9997b();
                m9990a();
                m10000d();
            } else {
                m9990a();
            }
            IMConversationBottomBar iMConversationBottomBar = this.f11593a;
            if (!(iMConversationBottomBar == null || iMConversationBottomBar.getBottomBarListener() == null)) {
                this.f11593a.getBottomBarListener().onEditFocus();
            }
        }
        view.postDelayed(new Runnable() {
            public void run() {
                IMEmotionInputDetector.this.f11593a.setModeKeyboard(true);
            }
        }, 10);
    }

    public IMEmotionInputDetector setEmotionView(View view) {
        this.f11597h = view;
        if (getKeyboardHeight() != 0) {
            ViewGroup.LayoutParams layoutParams = this.f11597h.getLayoutParams();
            layoutParams.height = getKeyboardHeight();
            this.f11597h.setLayoutParams(layoutParams);
        }
        return this;
    }

    public IMEmotionInputDetector bindToBottom(IMConversationBottomBar iMConversationBottomBar) {
        this.f11593a = iMConversationBottomBar;
        return this;
    }

    public IMEmotionInputDetector build() {
        this.f11594e.getWindow().setSoftInputMode(19);
        hideSoftInput();
        return this;
    }

    public boolean interceptBackPress() {
        m9998c();
        if (!this.f11597h.isShown()) {
            return false;
        }
        m9993a(false);
        return true;
    }

    /* renamed from: a */
    private void m9990a() {
        int i = this.f11596g.getInt(f11592d, IMViewUtil.dp2px(this.f11594e, (float) IMViewUtil.getDefaultKeyBoardHeight()));
        hideSoftInput();
        this.f11597h.getLayoutParams().height = i;
        this.f11597h.setVisibility(0);
        IMSkinTextView iMSkinTextView = this.f11600k;
        if (iMSkinTextView != null) {
            iMSkinTextView.showCustomSkin(IMBottomSkinManager.KEY_BOARD);
        }
    }

    public int getKeyboardHeight() {
        SharedPreferences sharedPreferences = this.f11596g;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(f11592d, IMViewUtil.dp2px(this.f11594e, (float) IMViewUtil.getDefaultKeyBoardHeight()));
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9993a(boolean z) {
        if (this.f11597h.isShown()) {
            IMSkinTextView iMSkinTextView = this.f11600k;
            if (iMSkinTextView != null) {
                iMSkinTextView.showCommonSkin();
            }
            this.f11597h.setVisibility(8);
            if (z) {
                showSoftInput();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9997b() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f11599j.getLayoutParams();
        layoutParams.height = this.f11599j.getHeight();
        layoutParams.weight = 0.0f;
    }

    /* renamed from: c */
    private void m9998c() {
        ((LinearLayout.LayoutParams) this.f11599j.getLayoutParams()).weight = 1.0f;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10000d() {
        this.f11598i.postDelayed(new Runnable() {
            public void run() {
                ((LinearLayout.LayoutParams) IMEmotionInputDetector.this.f11599j.getLayoutParams()).weight = 1.0f;
            }
        }, 200);
    }

    public void showSoftInput() {
        this.f11598i.requestFocus();
        this.f11598i.postDelayed(new Runnable() {
            public void run() {
                IMEmotionInputDetector.this.f11595f.showSoftInput(IMEmotionInputDetector.this.f11598i, 0);
            }
        }, 50);
        this.f11598i.postDelayed(new Runnable() {
            public void run() {
                int unused = IMEmotionInputDetector.this.m9995b(true);
            }
        }, 500);
    }

    public void hideSoftInput() {
        try {
            this.f11595f.hideSoftInputFromWindow(this.f11598i.getWindowToken(), 0);
        } catch (RuntimeException e) {
            IMTraceError.trackError("IMEmotionInputDetector#InputManager", e);
        }
        for (OnHideSoftInputListener onHideSoft : new ArrayList(this.f11601l)) {
            onHideSoft.onHideSoft(this);
        }
    }

    public boolean isSoftInputShown() {
        return m9995b(true) > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m9995b(boolean z) {
        Rect rect = new Rect();
        try {
            this.f11594e.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int a = (m9988a(this.f11594e) - rect.bottom) - IMNavigationBarUtil.getNavigationBarHeight(this.f11594e);
            if (a < 0) {
                IMLog.m10026w("IMEmotionInputDetector", "Warning: value of softInputHeight is below zero!");
            }
            if (a <= IMViewUtil.dp2px(this.f11594e, 100.0f)) {
                return 0;
            }
            if (z) {
                this.f11596g.edit().putInt(f11592d, a).apply();
                keyboardHeight = a;
            }
            return a;
        } catch (NullPointerException unused) {
            IMLog.m10021e("im_sdk", "getSupportSoftInputHeight failed because nullPointer!");
            return 0;
        }
    }

    /* renamed from: a */
    private int m9988a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            try {
                activity.getWindowManager().getDefaultDisplay().getRealSize(point);
                return point.y;
            } catch (NoSuchMethodError unused) {
                return 0;
            }
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
    }
}
