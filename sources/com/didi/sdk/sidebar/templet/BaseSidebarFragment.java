package com.didi.sdk.sidebar.templet;

import android.content.Intent;
import android.os.Bundle;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didi.sdk.sidebar.ViewAssembler;

public abstract class BaseSidebarFragment extends AbsLoadingFragment {

    /* renamed from: a */
    private ViewAssembler f40163a;

    /* access modifiers changed from: protected */
    public abstract ViewAssembler createViewAssembler();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f40163a = createViewAssembler();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f40163a.notifyPermissionsResult(i, strArr, iArr);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        createViewAssembler().notifyOnResult(i, i2, intent);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f40163a.notifyOnDestroy();
    }

    public void onResume() {
        super.onResume();
        this.f40163a.notifyOnResume();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
