package com.didi.dimina.container.p065ui.statusbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* renamed from: com.didi.dimina.container.ui.statusbar.SupportRequestManagerFragment */
public final class SupportRequestManagerFragment extends Fragment {

    /* renamed from: a */
    private C8273e f19622a;

    public ImmersionBar get(Object obj) {
        if (this.f19622a == null) {
            this.f19622a = new C8273e(obj);
        }
        return this.f19622a.mo61645a();
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        if (this.f19622a == null) {
            this.f19622a = new C8273e(activity, dialog);
        }
        return this.f19622a.mo61645a();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C8273e eVar = this.f19622a;
        if (eVar != null) {
            eVar.mo61646a(getResources().getConfiguration());
        }
    }

    public void onResume() {
        super.onResume();
        C8273e eVar = this.f19622a;
        if (eVar != null) {
            eVar.mo61647b();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        C8273e eVar = this.f19622a;
        if (eVar != null) {
            eVar.mo61649c();
            this.f19622a = null;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C8273e eVar = this.f19622a;
        if (eVar != null) {
            eVar.mo61648b(configuration);
        }
    }
}
