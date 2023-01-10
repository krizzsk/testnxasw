package com.didi.dimina.container.bridge;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p065ui.dialog.BaseActionSheet;
import com.didi.dimina.container.p065ui.dialog.ImageCloseView;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class PopupSubJSBridge {

    /* renamed from: a */
    private static final String f18531a = "PopupSubJSBridge";
    public static BackupPopupWindowManager sBackupPopupWindowManager;

    /* renamed from: b */
    private DialogManager f18532b;

    /* renamed from: c */
    private final Context f18533c;

    public interface BackupPopupWindowManager {
        void hidePopup(Context context, JSONObject jSONObject, CallbackFunction callbackFunction);

        void showPopup(Context context, JSONObject jSONObject, CallbackFunction callbackFunction);
    }

    public PopupSubJSBridge(Context context) {
        this.f18533c = context;
        LogUtil.m16841i("PopupSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59488a(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        LogUtil.m16841i("PopupSubJSBridge showPopup: " + jSONObject);
        BackupPopupWindowManager backupPopupWindowManager = sBackupPopupWindowManager;
        if (backupPopupWindowManager != null) {
            backupPopupWindowManager.showPopup(this.f18533c, jSONObject, callbackFunction);
        } else if (jSONObject.has("imageUrl")) {
            String optString = jSONObject.optString("imageUrl");
            if (!TextUtils.isEmpty(optString)) {
                DialogManager dialogManager = this.f18532b;
                if (dialogManager != null) {
                    dialogManager.dismiss();
                    this.f18532b = null;
                }
                DialogManager dialogManager2 = new DialogManager(this.f18533c, optString);
                this.f18532b = dialogManager2;
                dialogManager2.show(new ImageCloseView.OnImageCloseClickListener() {
                    public void onClick() {
                        JSONObject jSONObject = new JSONObject();
                        JSONUtil.put(jSONObject, "type", (Object) "click");
                        callbackFunction.onCallBack(jSONObject);
                    }

                    public void onClose() {
                        JSONObject jSONObject = new JSONObject();
                        JSONUtil.put(jSONObject, "type", (Object) "close");
                        callbackFunction.onCallBack(jSONObject);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59489b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("PopupSubJSBridge hidePopup: " + jSONObject);
        BackupPopupWindowManager backupPopupWindowManager = sBackupPopupWindowManager;
        if (backupPopupWindowManager != null) {
            backupPopupWindowManager.hidePopup(this.f18533c, jSONObject, callbackFunction);
            return;
        }
        DialogManager dialogManager = this.f18532b;
        if (dialogManager != null) {
            dialogManager.dismiss();
            this.f18532b = null;
        }
        callbackFunction.onCallBack(new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo59490c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.iRelease(f18531a, "showActionSheet: " + jSONObject);
        String optString = jSONObject.optString("alertText", "");
        String optString2 = jSONObject.optString("itemColor", "#000000");
        JSONArray optJSONArray = jSONObject.optJSONArray("itemList");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            LogUtil.eRelease(f18531a, "showActionSheet fail: itemList is empty");
            CallBackUtil.onFail("itemList is empty", callbackFunction);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        BaseActionSheet baseActionSheet = new BaseActionSheet(this.f18533c, new BaseActionSheet.OnDismissListener() {
            public final void onDismiss(int i) {
                PopupSubJSBridge.m15714a(CallbackFunction.this, i);
            }
        });
        baseActionSheet.setItemColor(optString2);
        baseActionSheet.setTitle(optString);
        baseActionSheet.refresh(arrayList);
        SystemUtils.showDialog(baseActionSheet);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15714a(CallbackFunction callbackFunction, int i) {
        if (i < 0) {
            CallBackUtil.onFail("fail cancel", callbackFunction);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "tapIndex", i);
        CallBackUtil.onSuccess(jSONObject, callbackFunction);
    }

    static class DialogManager {
        private final Context mContext;
        private AlertDialog mDialog;
        private final String mImageUrl;

        DialogManager(Context context, String str) {
            this.mImageUrl = str;
            this.mContext = context;
        }

        /* access modifiers changed from: package-private */
        public void show(ImageCloseView.OnImageCloseClickListener onImageCloseClickListener) {
            if (this.mContext != null) {
                AlertDialog alertDialog = this.mDialog;
                if (alertDialog == null || !alertDialog.isShowing()) {
                    ImageCloseView imageCloseView = new ImageCloseView(this.mContext);
                    imageCloseView.setImageUrl(this.mImageUrl);
                    imageCloseView.setClickListener(onImageCloseClickListener);
                    AlertDialog show = new AlertDialog.Builder(this.mContext, R.style.DiminaDialogNoBg).setCancelable(false).setView(imageCloseView).show();
                    this.mDialog = show;
                    if (show != null && show.getWindow() != null) {
                        this.mDialog.getWindow().setBackgroundDrawable((Drawable) null);
                        Window window = this.mDialog.getWindow();
                        window.getDecorView().setPadding(0, 0, 0, 0);
                        WindowManager.LayoutParams attributes = window.getAttributes();
                        attributes.height = -2;
                        attributes.width = -1;
                        attributes.gravity = 17;
                        window.setAttributes(attributes);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void dismiss() {
            AlertDialog alertDialog;
            if (this.mContext != null && (alertDialog = this.mDialog) != null) {
                alertDialog.dismiss();
                this.mDialog = null;
            }
        }
    }
}
