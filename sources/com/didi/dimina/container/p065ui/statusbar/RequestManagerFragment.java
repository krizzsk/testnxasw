package com.didi.dimina.container.p065ui.statusbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;

/* renamed from: com.didi.dimina.container.ui.statusbar.RequestManagerFragment */
public final class RequestManagerFragment extends Fragment {

    /* renamed from: a */
    private C8273e f19615a;

    public ImmersionBar get(Object obj) {
        if (this.f19615a == null) {
            this.f19615a = new C8273e(obj);
        }
        return this.f19615a.mo61645a();
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        if (this.f19615a == null) {
            this.f19615a = new C8273e(activity, dialog);
        }
        return this.f19615a.mo61645a();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C8273e eVar = this.f19615a;
        if (eVar != null) {
            eVar.mo61646a(getResources().getConfiguration());
        }
    }

    public void onResume() {
        super.onResume();
        C8273e eVar = this.f19615a;
        if (eVar != null) {
            eVar.mo61647b();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        C8273e eVar = this.f19615a;
        if (eVar != null) {
            eVar.mo61649c();
            this.f19615a = null;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C8273e eVar = this.f19615a;
        if (eVar != null) {
            eVar.mo61648b(configuration);
        }
    }
}
