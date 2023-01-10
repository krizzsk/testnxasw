package com.didi.sdk.debug.language;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0014J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/sdk/debug/language/LanguageDebugSettingActivity;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/didi/sdk/debug/language/ILanguageViewProxy;", "()V", "back", "Landroid/view/View;", "languageDebugPresenter", "Lcom/didi/sdk/debug/language/LanguageDebugPresenter;", "reset", "Landroid/widget/TextView;", "title", "getContext", "Landroid/content/Context;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "replace", "fragment", "Landroidx/fragment/app/Fragment;", "updateFragment", "isLanguageSelect", "", "updateTitle", "titleStr", "", "TheOneSDKGlobal_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LanguageDebugSettingActivity.kt */
public final class LanguageDebugSettingActivity extends FragmentActivity implements ILanguageViewProxy {

    /* renamed from: a */
    private TextView f38564a;

    /* renamed from: b */
    private View f38565b;

    /* renamed from: c */
    private TextView f38566c;

    /* renamed from: d */
    private LanguageDebugPresenter f38567d = new LanguageDebugPresenter(this);

    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_language_debug_set);
        m29078a();
    }

    /* renamed from: a */
    private final void m29078a() {
        this.f38565b = findViewById(R.id.back);
        this.f38564a = (TextView) findViewById(R.id.reset);
        this.f38566c = (TextView) findViewById(R.id.title);
        TextView textView = this.f38564a;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    LanguageDebugSettingActivity.m29080a(LanguageDebugSettingActivity.this, view);
                }
            });
        }
        View view = this.f38565b;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    LanguageDebugSettingActivity.m29081b(LanguageDebugSettingActivity.this, view);
                }
            });
        }
        this.f38567d.init();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29080a(LanguageDebugSettingActivity languageDebugSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(languageDebugSettingActivity, "this$0");
        languageDebugSettingActivity.f38567d.reset();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m29081b(LanguageDebugSettingActivity languageDebugSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(languageDebugSettingActivity, "this$0");
        languageDebugSettingActivity.finish();
    }

    /* renamed from: a */
    private final void m29079a(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f38567d.onDestroy();
        super.onDestroy();
    }

    public void updateFragment(boolean z) {
        if (z) {
            m29079a(new LanguageSelectFragment());
        } else {
            m29079a(new AreaSelectFragment());
        }
    }

    public Context getContext() {
        return this;
    }

    public void updateTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "titleStr");
        TextView textView = this.f38566c;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
