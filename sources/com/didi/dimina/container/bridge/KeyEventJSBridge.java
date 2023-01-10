package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.util.LogUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import org.json.JSONObject;

public class KeyEventJSBridge {

    /* renamed from: a */
    private AlertDialog f18489a;

    /* renamed from: b */
    private final Activity f18490b;

    public KeyEventJSBridge(FragmentActivity fragmentActivity) {
        this.f18490b = fragmentActivity;
        LogUtil.m16841i("KeyEventJSBridge init");
    }

    public void enableAlertBeforeUnload(JSONObject jSONObject, CallbackFunction callbackFunction, DMMina dMMina) {
        String optString = jSONObject.optString("message");
        if (!TextUtils.isEmpty(optString) && dMMina != null && dMMina.getCurNavigator() != null && dMMina.getCurNavigator().getCurrentPage() != null) {
            dMMina.getCurNavigator().getCurrentPage().enableAlertBeforeUnload(new IPageHost.OnPageHostBackListener(optString, dMMina) {
                public final /* synthetic */ String f$1;
                public final /* synthetic */ DMMina f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void OnBack() {
                    KeyEventJSBridge.this.m15652b(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59424a(JSONObject jSONObject, CallbackFunction callbackFunction, DMMina dMMina) {
        if (dMMina != null && dMMina.getCurNavigator() != null && dMMina.getCurNavigator().getCurrentPage() != null) {
            dMMina.getCurNavigator().getCurrentPage().disableAlertBeforeUnload();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15652b(String str, DMMina dMMina) {
        View inflate = LayoutInflater.from(this.f18490b).inflate(R.layout.dimina_dialog_unload_alert, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.message)).setText(str);
        ((TextView) inflate.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                KeyEventJSBridge.this.m15649a(view);
            }
        });
        ((TextView) inflate.findViewById(R.id.confirm)).setOnClickListener(new View.OnClickListener(dMMina) {
            public final /* synthetic */ DMMina f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                KeyEventJSBridge.this.m15650a(this.f$1, view);
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f18490b);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        this.f18489a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        this.f18489a.setCanceledOnTouchOutside(true);
        SystemUtils.showDialog(this.f18489a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15649a(View view) {
        this.f18489a.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15650a(DMMina dMMina, View view) {
        this.f18489a.dismiss();
        dMMina.getCurNavigator().getCurrentPage().onBackPressedInner();
    }
}
