package com.didi.dimina.starbox.module.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p065ui.dialog.BaseModal;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class InputModalSubJSBridge {
    public static final String MODAL_PARAM_CANCEL_COLOR = "cancelColor";
    public static final String MODAL_PARAM_CANCEL_TEXT = "cancelText";
    public static final String MODAL_PARAM_CONFIRM_COLOR = "confirmColor";
    public static final String MODAL_PARAM_CONFIRM_TEXT = "confirmText";
    public static final String MODAL_PARAM_CONTENT = "content";
    public static final String MODAL_PARAM_EDITABLE = "editable";
    public static final String MODAL_PARAM_PLACEHOLDER_TEXT = "placeholderText";
    public static final String MODAL_PARAM_SHOW_CANCEL = "showCancel";
    public static final String MODAL_PARAM_TITLE = "title";

    /* renamed from: a */
    private final Activity f19878a;

    /* renamed from: b */
    private BaseModal f19879b;

    InputModalSubJSBridge(Activity activity) {
        this.f19878a = activity;
    }

    public void showInputModal(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                InputModalSubJSBridge.this.m16896a(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m16896a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.f19879b == null) {
            BaseModal baseModal = new BaseModal(this.f19878a, R.style.DiminaDialogNoBg);
            this.f19879b = baseModal;
            baseModal.setCancelable(false);
            this.f19879b.setCanceledOnTouchOutside(false);
        }
        m16895a(jSONObject);
        this.f19879b.setPositiveButtonListener(new View.OnClickListener(callbackFunction) {
            public final /* synthetic */ CallbackFunction f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                InputModalSubJSBridge.this.m16898b(this.f$1, view);
            }
        });
        if (this.f19879b.isShowCancel()) {
            this.f19879b.setNegativeButtonListener(new View.OnClickListener(callbackFunction) {
                public final /* synthetic */ CallbackFunction f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    InputModalSubJSBridge.this.m16893a(this.f$1, view);
                }
            });
        }
        SystemUtils.showDialog(this.f19879b);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m16898b(CallbackFunction callbackFunction, View view) {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, XPanelScene.SCENE_CONFIRM, true);
        JSONUtil.put(jSONObject, "content", (Object) this.f19879b.getContent());
        CallBackUtil.onSuccess(jSONObject, callbackFunction);
        this.f19879b.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m16893a(CallbackFunction callbackFunction, View view) {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "cancel", true);
        CallBackUtil.onSuccess(jSONObject, callbackFunction);
        this.f19879b.dismiss();
    }

    /* renamed from: a */
    private void m16895a(JSONObject jSONObject) {
        m16892a();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            char c = 65535;
            try {
                switch (next.hashCode()) {
                    case -1597633271:
                        if (next.equals("cancelColor")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 110371416:
                        if (next.equals("title")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 307364823:
                        if (next.equals("showCancel")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 344408077:
                        if (next.equals("confirmText")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 951530617:
                        if (next.equals("content")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1602416228:
                        if (next.equals(MODAL_PARAM_EDITABLE)) {
                            c = 8;
                            break;
                        }
                        break;
                    case 1750748480:
                        if (next.equals(MODAL_PARAM_PLACEHOLDER_TEXT)) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1888623303:
                        if (next.equals("cancelText")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 2071302275:
                        if (next.equals("confirmColor")) {
                            c = 6;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        m16894a(jSONObject.getString(next));
                        break;
                    case 1:
                        m16899b(jSONObject.getString(next));
                        break;
                    case 2:
                        m16897a(jSONObject.getBoolean(next));
                        break;
                    case 3:
                        m16901c(jSONObject.getString(next));
                        break;
                    case 4:
                        m16902d(jSONObject.getString(next));
                        break;
                    case 5:
                        m16903e(jSONObject.getString(next));
                        break;
                    case 6:
                        m16904f(jSONObject.getString(next));
                        break;
                    case 7:
                        m16905g(jSONObject.getString(next));
                        break;
                    case 8:
                        m16900b(jSONObject.getBoolean(next));
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m16892a() {
        this.f19879b.reset();
    }

    /* renamed from: a */
    private void m16897a(boolean z) {
        this.f19879b.setShowCancel(z);
    }

    /* renamed from: a */
    private void m16894a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f19879b.setDialogTitle(str);
        }
    }

    /* renamed from: b */
    private void m16899b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f19879b.setContent(str);
        }
    }

    /* renamed from: c */
    private void m16901c(String str) {
        this.f19879b.setNegativeButton(str);
    }

    /* renamed from: d */
    private void m16902d(String str) {
        this.f19879b.setNegativeButtonTextColor(str);
    }

    /* renamed from: e */
    private void m16903e(String str) {
        this.f19879b.setPositiveButtonText(str);
    }

    /* renamed from: f */
    private void m16904f(String str) {
        this.f19879b.setPositiveButtonTextColor(str);
    }

    /* renamed from: g */
    private void m16905g(String str) {
        this.f19879b.setPlaceholderText(str);
    }

    /* renamed from: b */
    private void m16900b(boolean z) {
        this.f19879b.setModalEditable(z);
    }
}
