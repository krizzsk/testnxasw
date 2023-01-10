package com.didi.dimina.container.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p065ui.dialog.BaseModal;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ModalSubJSBridge {
    public static final String MODAL_PARAM_CANCEL_COLOR = "cancelColor";
    public static final String MODAL_PARAM_CANCEL_TEXT = "cancelText";
    public static final String MODAL_PARAM_CONFIRM_COLOR = "confirmColor";
    public static final String MODAL_PARAM_CONFIRM_TEXT = "confirmText";
    public static final String MODAL_PARAM_CONTENT = "content";
    public static final String MODAL_PARAM_SHOW_CANCEL = "showCancel";
    public static final String MODAL_PARAM_TITLE = "title";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public BaseModal f18499a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f18500b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CopyOnWriteArrayList<CallbackFunction> f18501c = new CopyOnWriteArrayList<>();

    public ModalSubJSBridge(Context context) {
        this.f18500b = context;
        LogUtil.m16841i("ModalSubJSBridge init");
    }

    public void showModal(final JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.f18501c.add(callbackFunction);
        UIHandlerUtil.post(new Runnable() {
            public void run() {
                if (ModalSubJSBridge.this.f18499a == null) {
                    BaseModal unused = ModalSubJSBridge.this.f18499a = new BaseModal(ModalSubJSBridge.this.f18500b, R.style.DiminaDialogNoBg);
                    ModalSubJSBridge.this.f18499a.setCancelable(false);
                    ModalSubJSBridge.this.f18499a.setCanceledOnTouchOutside(false);
                }
                ModalSubJSBridge.this.m15667a(jSONObject);
                ModalSubJSBridge.this.f18499a.setPositiveButtonListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        JSONObject jSONObject = new JSONObject();
                        JSONUtil.put(jSONObject, "success", true);
                        JSONObject jSONObject2 = new JSONObject();
                        JSONUtil.put(jSONObject2, XPanelScene.SCENE_CONFIRM, true);
                        JSONUtil.put(jSONObject, "data", (Object) jSONObject2);
                        Iterator it = ModalSubJSBridge.this.f18501c.iterator();
                        while (it.hasNext()) {
                            ((CallbackFunction) it.next()).onCallBack(jSONObject);
                        }
                        ModalSubJSBridge.this.f18501c.clear();
                        ModalSubJSBridge.this.f18499a.dismiss();
                    }
                });
                if (ModalSubJSBridge.this.f18499a.isShowCancel()) {
                    ModalSubJSBridge.this.f18499a.setNegativeButtonListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            JSONObject jSONObject = new JSONObject();
                            JSONUtil.put(jSONObject, "success", true);
                            JSONObject jSONObject2 = new JSONObject();
                            JSONUtil.put(jSONObject2, "cancel", true);
                            JSONUtil.put(jSONObject, "data", (Object) jSONObject2);
                            Iterator it = ModalSubJSBridge.this.f18501c.iterator();
                            while (it.hasNext()) {
                                ((CallbackFunction) it.next()).onCallBack(jSONObject);
                            }
                            ModalSubJSBridge.this.f18501c.clear();
                            ModalSubJSBridge.this.f18499a.dismiss();
                        }
                    });
                }
                SystemUtils.showDialog(ModalSubJSBridge.this.f18499a);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15667a(JSONObject jSONObject) {
        m15664a();
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
                        m15666a(jSONObject.getString(next));
                        break;
                    case 1:
                        m15670b(jSONObject.getString(next));
                        break;
                    case 2:
                        m15668a(jSONObject.getBoolean(next));
                        break;
                    case 3:
                        m15672c(jSONObject.getString(next));
                        break;
                    case 4:
                        m15673d(jSONObject.getString(next));
                        break;
                    case 5:
                        m15674e(jSONObject.getString(next));
                        break;
                    case 6:
                        m15675f(jSONObject.getString(next));
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m15664a() {
        this.f18499a.reset();
    }

    /* renamed from: a */
    private void m15668a(boolean z) {
        this.f18499a.setShowCancel(z);
    }

    /* renamed from: a */
    private void m15666a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f18499a.setDialogTitle(str);
        }
    }

    /* renamed from: b */
    private void m15670b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f18499a.setContent(str);
        }
    }

    /* renamed from: c */
    private void m15672c(String str) {
        this.f18499a.setNegativeButton(str);
    }

    /* renamed from: d */
    private void m15673d(String str) {
        this.f18499a.setNegativeButtonTextColor(str);
    }

    /* renamed from: e */
    private void m15674e(String str) {
        this.f18499a.setPositiveButtonText(str);
    }

    /* renamed from: f */
    private void m15675f(String str) {
        this.f18499a.setPositiveButtonTextColor(str);
    }
}
