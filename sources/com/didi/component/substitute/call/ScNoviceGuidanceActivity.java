package com.didi.component.substitute.call;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.common.util.UIUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/component/substitute/call/ScNoviceGuidanceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mAnycarAvatar", "Landroid/widget/ImageView;", "mAnycarRelativeLayout", "Landroid/widget/RelativeLayout;", "mAnycarScText", "Landroid/widget/TextView;", "mAnycarSelectContainer", "Landroid/widget/FrameLayout;", "mAvatar", "mBannerContainer", "Landroid/widget/LinearLayout;", "mGet", "mRelativeLayout", "mScText", "mSelectContainer", "mTriangle", "Landroid/view/View;", "init", "", "initHollowedOutData", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "comp-substitute-call_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ScNoviceGuidanceActivity.kt */
public final class ScNoviceGuidanceActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ImageView f17904a;

    /* renamed from: b */
    private TextView f17905b;

    /* renamed from: c */
    private TextView f17906c;

    /* renamed from: d */
    private RelativeLayout f17907d;

    /* renamed from: e */
    private FrameLayout f17908e;

    /* renamed from: f */
    private ImageView f17909f;

    /* renamed from: g */
    private TextView f17910g;

    /* renamed from: h */
    private RelativeLayout f17911h;

    /* renamed from: i */
    private FrameLayout f17912i;

    /* renamed from: j */
    private LinearLayout f17913j;

    /* renamed from: k */
    private View f17914k;

    public void _$_clearFindViewByIdCache() {
    }

    public void onBackPressed() {
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/component/substitute/call/ScNoviceGuidanceActivity$Companion;", "", "()V", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "comp-substitute-call_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: ScNoviceGuidanceActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, ScNoviceGuidanceActivity.class);
            intent.setFlags(268435456);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
        }
        setContentView((int) R.layout.sc_novice_guidance);
        m15211a();
        m15212b();
        m15213c();
    }

    /* renamed from: a */
    private final void m15211a() {
        WindowManager.LayoutParams layoutParams;
        Window window = getWindow();
        if (window == null) {
            layoutParams = null;
        } else {
            layoutParams = window.getAttributes();
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (layoutParams != null) {
            layoutParams.width = displayMetrics.widthPixels;
        }
        window.setAttributes(layoutParams);
        window.setGravity(80);
    }

    /* renamed from: b */
    private final void m15212b() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        this.f17904a = (ImageView) findViewById(R.id.iv_sp_avatar);
        this.f17905b = (TextView) findViewById(R.id.tv_sp_text);
        this.f17914k = findViewById(R.id.v_triangle);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_hollowed_out);
        this.f17907d = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(R.drawable.select_passager_bg);
        }
        this.f17908e = (FrameLayout) findViewById(R.id.select_container);
        this.f17909f = (ImageView) findViewById(R.id.anycar_iv_sp_avatar);
        this.f17910g = (TextView) findViewById(R.id.anycar_tv_sp_text);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.anycar_rl_hollowed_out);
        this.f17911h = relativeLayout2;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundResource(R.drawable.anycar_select_passager_bg);
        }
        this.f17912i = (FrameLayout) findViewById(R.id.anycar_select_container);
        this.f17913j = (LinearLayout) findViewById(R.id.banner_container);
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        boolean z = true;
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            z = false;
        }
        if (z) {
            FrameLayout frameLayout = this.f17912i;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            FrameLayout frameLayout2 = this.f17908e;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            LinearLayout linearLayout = this.f17913j;
            if (!(linearLayout == null || (layoutParams2 = linearLayout.getLayoutParams()) == null || !(layoutParams2 instanceof LinearLayout.LayoutParams))) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                Context context = this;
                layoutParams3.setMarginStart(UIUtils.dip2pxInt(context, 5.0f));
                layoutParams3.setMarginEnd(UIUtils.dip2pxInt(context, 5.0f));
            }
            View view = this.f17914k;
            if (!(view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof LinearLayout.LayoutParams))) {
                ((LinearLayout.LayoutParams) layoutParams).setMarginStart(UIUtils.dip2pxInt(this, 36.0f));
            }
        } else {
            FrameLayout frameLayout3 = this.f17912i;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            FrameLayout frameLayout4 = this.f17908e;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(0);
            }
        }
        TextView textView = (TextView) findViewById(R.id.tv_get);
        this.f17906c = textView;
        if (textView != null) {
            textView.setOnClickListener(new ScNoviceGuidanceActivity$initView$3(this));
        }
    }

    /* renamed from: c */
    private final void m15213c() {
        TextView textView;
        TextView textView2;
        FormStore instance = FormStore.getInstance();
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        boolean z = false;
        if (confirmListener != null && confirmListener.getIsAnyCar()) {
            z = true;
        }
        if (z) {
            String substituteCallIcon = instance.getSubstituteCallIcon();
            if (substituteCallIcon != null) {
                ImageView imageView = this.f17909f;
                Intrinsics.checkNotNull(imageView);
                ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(substituteCallIcon).placeholder((int) R.drawable.icon_sc_for_me)).error((int) R.drawable.icon_sc_for_me)).into(imageView);
            }
            String substituteCallText = instance.getSubstituteCallText();
            if (substituteCallText != null && (textView2 = this.f17910g) != null) {
                textView2.setText(substituteCallText);
                return;
            }
            return;
        }
        String substituteCallIcon2 = instance.getSubstituteCallIcon();
        if (substituteCallIcon2 != null) {
            ImageView imageView2 = this.f17904a;
            Intrinsics.checkNotNull(imageView2);
            ((RequestBuilder) ((RequestBuilder) Glide.with((FragmentActivity) this).load(substituteCallIcon2).placeholder((int) R.drawable.icon_sc_for_me)).error((int) R.drawable.icon_sc_for_me)).into(imageView2);
        }
        String substituteCallText2 = instance.getSubstituteCallText();
        if (substituteCallText2 != null && (textView = this.f17905b) != null) {
            textView.setText(substituteCallText2);
        }
    }
}
