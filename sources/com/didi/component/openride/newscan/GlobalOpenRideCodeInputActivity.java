package com.didi.component.openride.newscan;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, mo148868d2 = {"Lcom/didi/component/openride/newscan/GlobalOpenRideCodeInputActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "initFragment", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "comp-openride_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalOpenRideCodeInputActivity.kt */
public final class GlobalOpenRideCodeInputActivity extends FragmentActivity {
    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_layout_global_openride_codeinput_container);
        m13925a();
    }

    /* renamed from: a */
    private final void m13925a() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new GlobalOpenRideCodeInputFragment()).commitAllowingStateLoss();
    }
}
