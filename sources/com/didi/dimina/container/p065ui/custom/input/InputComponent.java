package com.didi.dimina.container.p065ui.custom.input;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.dimina.container.p065ui.custom.CustomComponent;
import com.didi.dimina.container.p065ui.custom.SameLayerRenderingUtil;
import com.didi.dimina.container.p065ui.webview.DMWebViewContainer;
import com.didi.dimina.container.util.KeyboardUtils;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.custom.input.InputComponent */
public class InputComponent extends CustomComponent implements WebViewEngine.OnScrollChangedCallback {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C8221a f19400a = new C8221a();

    /* renamed from: b */
    private int f19401b = -1;
    protected EditText editText;
    protected InputUtil inputUtil = new InputUtil();

    /* renamed from: a */
    private boolean m16459a(View view, MotionEvent motionEvent) {
        if (!(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int height = view.getHeight() + i2;
        int width = view.getWidth() + i;
        if (motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) height)) {
            return true;
        }
        return false;
    }

    public View onMounted(Context context, JSONObject jSONObject) {
        C8222b.m16472a(this.f19400a, jSONObject);
        this.mWebView.addScrollChangedCallback(this);
        Activity activity = this.mWebView.getActivity();
        if (!activity.isDestroyed() && !activity.isFinishing()) {
            Window window = activity.getWindow();
            if (this.f19401b == -1) {
                this.f19401b = window.getAttributes().softInputMode;
            }
            window.setSoftInputMode(48);
        }
        AppCompatEditText appCompatEditText = new AppCompatEditText(this.mWebView.getActivity());
        this.editText = appCompatEditText;
        appCompatEditText.setSingleLine();
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setBackgroundColor(0);
        this.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                InputComponent.this.m16458a(view, z);
            }
        });
        this.editText.addTextChangedListener(new C8223c() {
            public void afterTextChanged(Editable editable) {
                if ((InputComponent.this.editText.hasFocus() || !TextUtils.isEmpty(editable)) && !TextUtils.equals(InputComponent.this.f19400a.f19411d, editable)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("value", editable.toString());
                    hashMap.put("cursor", Integer.valueOf(InputComponent.this.editText.getSelectionStart()));
                    hashMap.put("height", Integer.valueOf(InputComponent.this.inputUtil.f19402a));
                    InputComponent.this.emitEvent2WebView("bindinput", hashMap);
                }
            }
        });
        return this.editText;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m16458a(View view, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", this.editText.getText().toString());
        hashMap.put("cursor", Integer.valueOf(this.editText.getSelectionStart()));
        hashMap.put("height", Integer.valueOf(this.inputUtil.f19402a));
        if (z) {
            int[] iArr = new int[2];
            this.editText.getLocationInWindow(iArr);
            KeyboardUtils.focusedComponentY = ((this.editText.getHeight() + iArr[1]) - this.mDMPage.getWebTitleBar().getHeight()) - KeyboardUtils.getStatusBarHeight();
        }
        emitEvent2WebView(z ? "bindfocus" : "bindblur", hashMap);
    }

    /* renamed from: a */
    private void m16457a() {
        DMWebViewContainer container;
        this.editText.setBackgroundColor(C8222b.m16469a(this.f19400a));
        this.editText.setText(this.f19400a.f19411d);
        this.editText.setHint(this.f19400a.f19413f);
        this.editText.setHintTextColor(C8222b.m16476e(this.f19400a));
        this.editText.setTextSize(C8222b.m16475d(this.f19400a));
        this.editText.setInputType(C8222b.m16477f(this.f19400a));
        this.editText.setTextColor(C8222b.m16474c(this.f19400a));
        this.editText.setGravity(C8222b.m16473b(this.f19400a));
        if (this.f19400a.f19414g) {
            this.editText.setEnabled(false);
        }
        if (this.f19400a.f19415h > 0) {
            this.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f19400a.f19415h)});
        }
        if (this.f19400a.f19416i) {
            this.editText.setEnabled(true);
            this.editText.setFocusable(true);
            this.editText.setFocusableInTouchMode(true);
            this.editText.requestFocus();
            InputUtil.m16465b((View) this.editText);
        }
        if (this.f19400a.f19417j > 0) {
            this.editText.setSelection(Math.min(this.f19400a.f19417j, this.editText.getText().length()));
        }
        this.editText.setImeOptions(C8222b.m16478g(this.f19400a));
        if (!this.f19400a.confirmHold) {
            this.editText.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i != 66) {
                        return false;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("value", InputComponent.this.editText.getText().toString());
                    InputComponent.this.emitEvent2WebView("bindconfirm", hashMap);
                    InputUtil.m16466c(InputComponent.this.editText);
                    return false;
                }
            });
        }
        if (this.f19400a.selectionEnd > 0 && this.f19400a.selectionStart > 0) {
            this.editText.setTextIsSelectable(true);
            this.editText.setSelection(this.f19400a.selectionStart, this.f19400a.selectionEnd);
        }
        if (!this.f19400a.holdKeyboard && (container = this.mWebView.getContainer()) != null) {
            container.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return InputComponent.this.m16460b(view, motionEvent);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ boolean m16460b(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !m16459a((View) this.editText, motionEvent)) {
            return false;
        }
        InputUtil.m16466c(this.editText);
        return false;
    }

    public void onPropertiesUpdate(JSONObject jSONObject) {
        if (this.editText != null && !jSONObject.optBoolean(SameLayerRenderingUtil.KEY_CALL_FROM_D6, false)) {
            C8222b.m16472a(this.f19400a, jSONObject);
            m16457a();
        }
    }

    public void onDestroyed() {
        if (this.mWebView != null) {
            this.mWebView.removeScrollChangedCallback(this);
            Activity activity = this.mWebView.getActivity();
            if (activity != null && !activity.isDestroyed()) {
                Window window = activity.getWindow();
                int i = this.f19401b;
                if (i != -1) {
                    window.setSoftInputMode(i);
                }
            }
        }
        EditText editText2 = this.editText;
        if (editText2 != null) {
            this.inputUtil.mo61201a((View) editText2);
            try {
                InputUtil.m16466c(this.editText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.editText != null && ((!SameLayerRenderingUtil.isSameLayerRenderingReady(this.mWebView)) && (!TextUtils.equals(this.f19400a.f19418k, "fixed")))) {
            this.editText.setTranslationY((float) (-i2));
        }
    }
}
