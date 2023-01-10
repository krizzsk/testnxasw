package com.didi.payment.wallet_ui.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.payment.wallet_ui.UiUtils;
import com.didi.payment.wallet_ui.tips.WalletTips;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/tips/WalletTips;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "show", "", "Companion", "ConfigBuilder", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletTips.kt */
public final class WalletTips extends LinearLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int f35723a = LinearLayout.generateViewId();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int f35724b = UiUtils.Companion.intSize(32);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final int f35725c = UiUtils.Companion.intSize(580);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final int f35726d = (UiUtils.Companion.intSize(580) - (f35724b * 2));
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final int f35727e = UiUtils.Companion.intSize(40);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final int f35728f = UiUtils.Companion.intSize(20);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final int f35729g = UiUtils.Companion.intSize(24);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final int f35730h = UiUtils.Companion.intSize(16);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final int f35731i = UiUtils.Companion.intSize(2);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final int f35732j = UiUtils.Companion.intSize(8);

    public /* synthetic */ WalletTips(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private WalletTips(Context context) {
        super(context, (AttributeSet) null, 0);
    }

    public final void show() {
        ViewParent parent = getParent();
        FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        setVisibility(0);
    }

    @Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/tips/WalletTips$Companion;", "", "()V", "maxContentWidth", "", "getMaxContentWidth", "()I", "maxTipsWidth", "getMaxTipsWidth", "safeCornerLength", "safeMargin", "tipArrowHeight", "tipArrowMargin", "tipArrowWidth", "tipCorner", "tipsLRMargin", "tipsParentViewID", "configBg", "", "tipsOffset", "topShow", "", "tipsView", "Lcom/didi/payment/wallet_ui/tips/WalletTips;", "parentView", "Landroid/view/View;", "handleTipsViewPosition", "tipsBuilder", "Lcom/didi/payment/wallet_ui/tips/WalletTips$ConfigBuilder;", "targetView", "rootView", "showTips", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletTips.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getMaxTipsWidth() {
            return WalletTips.f35725c;
        }

        public final int getMaxContentWidth() {
            return WalletTips.f35726d;
        }

        public final WalletTips showTips(View view, ConfigBuilder configBuilder) {
            if (view == null || configBuilder == null) {
                return null;
            }
            Context context = view.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null) {
                return null;
            }
            WalletTips walletTips = (WalletTips) activity.findViewById(configBuilder.getContentViewID());
            if (walletTips != null) {
                walletTips.show();
                return walletTips;
            }
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            if (viewGroup == null) {
                return null;
            }
            FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(WalletTips.f35723a);
            if (frameLayout == null) {
                frameLayout = new FrameLayout(view.getContext());
                frameLayout.setOnClickListener(new View.OnClickListener(frameLayout) {
                    public final /* synthetic */ FrameLayout f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onClick(View view) {
                        WalletTips.Companion.m47120showTips$lambda1$lambda0(this.f$0, view);
                    }
                });
                viewGroup.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            }
            WalletTips build = configBuilder.build(view);
            build.setId(configBuilder.getContentViewID());
            frameLayout.addView(build, new FrameLayout.LayoutParams(-2, -2));
            frameLayout.setVisibility(0);
            build.post(new Runnable(configBuilder, view, frameLayout) {
                public final /* synthetic */ WalletTips.ConfigBuilder f$1;
                public final /* synthetic */ View f$2;
                public final /* synthetic */ FrameLayout f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    WalletTips.Companion.m47121showTips$lambda3(WalletTips.this, this.f$1, this.f$2, this.f$3);
                }
            });
            return build;
        }

        /* access modifiers changed from: private */
        /* renamed from: showTips$lambda-1$lambda-0  reason: not valid java name */
        public static final void m47120showTips$lambda1$lambda0(FrameLayout frameLayout, View view) {
            Intrinsics.checkNotNullParameter(frameLayout, "$this_apply");
            frameLayout.setVisibility(8);
        }

        /* access modifiers changed from: private */
        /* renamed from: showTips$lambda-3  reason: not valid java name */
        public static final void m47121showTips$lambda3(WalletTips walletTips, ConfigBuilder configBuilder, View view, FrameLayout frameLayout) {
            Intrinsics.checkNotNullParameter(walletTips, "$tipsView");
            Intrinsics.checkNotNullParameter(frameLayout, "$tipsParentView");
            WalletTips.Companion.handleTipsViewPosition(walletTips, configBuilder, view, frameLayout);
        }

        private final void handleTipsViewPosition(WalletTips walletTips, ConfigBuilder configBuilder, View view, View view2) {
            int i;
            int i2;
            int access$getSafeMargin$cp;
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            boolean z = true;
            int i3 = iArr[1];
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int width = iArr2[0] + (view.getWidth() / 2);
            int width2 = (walletTips.getWidth() - WalletTips.f35727e) - (WalletTips.f35729g / 2);
            int access$getSafeCornerLength$cp = WalletTips.f35727e + (WalletTips.f35729g / 2);
            if (configBuilder.getArrowOffsetStart() < access$getSafeCornerLength$cp) {
                configBuilder.setArrowOffsetStart(access$getSafeCornerLength$cp);
            } else if (configBuilder.getArrowOffsetStart() > width2) {
                configBuilder.setArrowOffsetStart(width2);
            }
            int access$getSafeMargin$cp2 = WalletTips.f35728f;
            int screenWidth = UiUtils.Companion.getScreenWidth() - WalletTips.f35728f;
            if (configBuilder.getArrowLeft()) {
                i = width - configBuilder.getArrowOffsetStart();
                int width3 = walletTips.getWidth() + i;
                if (i < access$getSafeMargin$cp2 || width3 > screenWidth) {
                    if (i >= access$getSafeMargin$cp2 && width3 > screenWidth) {
                        int i4 = width3 - screenWidth;
                        configBuilder.setArrowOffsetStart(configBuilder.getArrowOffsetStart() + i4);
                        if (configBuilder.getArrowOffsetStart() <= width2) {
                            i -= i4;
                        } else {
                            configBuilder.setArrowOffsetStart(width2);
                            i = (UiUtils.Companion.getScreenWidth() - WalletTips.f35728f) - walletTips.getWidth();
                        }
                    } else if (i >= access$getSafeMargin$cp2 || width3 > screenWidth) {
                        i = 0;
                    } else {
                        int i5 = access$getSafeMargin$cp2 - i;
                        configBuilder.setArrowOffsetStart(configBuilder.getArrowOffsetStart() - i5);
                        if (configBuilder.getArrowOffsetStart() >= access$getSafeCornerLength$cp) {
                            i += i5;
                        } else {
                            configBuilder.setArrowOffsetStart(access$getSafeCornerLength$cp);
                            i = WalletTips.f35728f;
                        }
                    }
                }
            } else {
                int arrowOffsetStart = width + configBuilder.getArrowOffsetStart();
                int width4 = arrowOffsetStart - walletTips.getWidth();
                if (width4 < access$getSafeMargin$cp2 || arrowOffsetStart > screenWidth) {
                    if (width4 >= access$getSafeMargin$cp2 && arrowOffsetStart > screenWidth) {
                        int i6 = arrowOffsetStart - screenWidth;
                        configBuilder.setArrowOffsetStart(configBuilder.getArrowOffsetStart() - i6);
                        if (configBuilder.getArrowOffsetStart() >= access$getSafeCornerLength$cp) {
                            width4 -= i6;
                        } else {
                            configBuilder.setArrowOffsetStart(access$getSafeCornerLength$cp);
                            access$getSafeMargin$cp = (UiUtils.Companion.getScreenWidth() - WalletTips.f35728f) - walletTips.getWidth();
                        }
                    } else if (width4 >= access$getSafeMargin$cp2 || arrowOffsetStart > screenWidth) {
                        i = 0;
                        configBuilder.setArrowOffsetStart(walletTips.getWidth() - configBuilder.getArrowOffsetStart());
                    } else {
                        int i7 = access$getSafeMargin$cp2 - width4;
                        configBuilder.setArrowOffsetStart(configBuilder.getArrowOffsetStart() + i7);
                        if (configBuilder.getArrowOffsetStart() <= width2) {
                            width4 += i7;
                        } else {
                            configBuilder.setArrowOffsetStart(width2);
                            access$getSafeMargin$cp = WalletTips.f35728f;
                        }
                    }
                    i = access$getSafeMargin$cp;
                    configBuilder.setArrowOffsetStart(walletTips.getWidth() - configBuilder.getArrowOffsetStart());
                }
                i = width4;
                configBuilder.setArrowOffsetStart(walletTips.getWidth() - configBuilder.getArrowOffsetStart());
            }
            int i8 = iArr2[1] - i3;
            boolean topShow = configBuilder.getTopShow();
            if (topShow) {
                int access$getTipArrowMargin$cp = ((i8 - WalletTips.f35732j) - WalletTips.f35730h) - walletTips.getHeight();
                if (access$getTipArrowMargin$cp < WalletTips.f35728f) {
                    i2 = i8 + view.getHeight() + WalletTips.f35732j + WalletTips.f35730h;
                    z = false;
                    configBg(configBuilder.getArrowOffsetStart(), z, walletTips, view2);
                    walletTips.setX((float) i);
                    walletTips.setY((float) i2);
                }
                i2 = access$getTipArrowMargin$cp;
            } else {
                i2 = view.getHeight() + i8 + WalletTips.f35732j + WalletTips.f35730h;
                if (i2 > UiUtils.Companion.getScreenHeight() - WalletTips.f35728f) {
                    i2 = ((i8 - WalletTips.f35732j) - WalletTips.f35730h) - walletTips.getHeight();
                    configBg(configBuilder.getArrowOffsetStart(), z, walletTips, view2);
                    walletTips.setX((float) i);
                    walletTips.setY((float) i2);
                }
            }
            z = topShow;
            configBg(configBuilder.getArrowOffsetStart(), z, walletTips, view2);
            walletTips.setX((float) i);
            walletTips.setY((float) i2);
        }

        private final void configBg(int i, boolean z, WalletTips walletTips, View view) {
            ShapeAppearanceModel.Builder allCornerSizes = ShapeAppearanceModel.builder().setAllCornerSizes(UiUtils.Companion.floatSize(40));
            EdgeTreatment offsetEdgeTreatment = new OffsetEdgeTreatment(new TriangleCornerEdgeTreatment(WalletTips.f35729g, WalletTips.f35730h, WalletTips.f35731i), ((((float) walletTips.getWidth()) / 2.0f) - ((float) i)) * ((float) (z ? -1 : 1)));
            if (z) {
                allCornerSizes.setBottomEdge(offsetEdgeTreatment);
            } else {
                allCornerSizes.setTopEdge(offsetEdgeTreatment);
            }
            ShapeAppearanceModel build = allCornerSizes.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder()\n              …\n                .build()");
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
            materialShapeDrawable.setTint(Color.parseColor("#F25B6167"));
            materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup != null) {
                viewGroup.setClipChildren(false);
            }
            walletTips.setBackground(materialShapeDrawable);
        }
    }

    @Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\n¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/tips/WalletTips$ConfigBuilder;", "", "contentViewBuilder", "Lcom/didi/payment/wallet_ui/tips/IContentView;", "(Lcom/didi/payment/wallet_ui/tips/IContentView;)V", "arrowLeft", "", "getArrowLeft", "()Z", "setArrowLeft", "(Z)V", "arrowOffsetStart", "", "getArrowOffsetStart", "()I", "setArrowOffsetStart", "(I)V", "contentViewID", "getContentViewID", "topShow", "getTopShow", "setTopShow", "build", "Lcom/didi/payment/wallet_ui/tips/WalletTips;", "targetView", "Landroid/view/View;", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletTips.kt */
    public static final class ConfigBuilder {
        private boolean arrowLeft;
        private int arrowOffsetStart;
        private final IContentView contentViewBuilder;
        private final int contentViewID = LinearLayout.generateViewId();
        private boolean topShow;

        public ConfigBuilder(IContentView iContentView) {
            Intrinsics.checkNotNullParameter(iContentView, "contentViewBuilder");
            this.contentViewBuilder = iContentView;
        }

        public final boolean getTopShow() {
            return this.topShow;
        }

        public final void setTopShow(boolean z) {
            this.topShow = z;
        }

        public final boolean getArrowLeft() {
            return this.arrowLeft;
        }

        public final void setArrowLeft(boolean z) {
            this.arrowLeft = z;
        }

        public final int getArrowOffsetStart() {
            return this.arrowOffsetStart;
        }

        public final void setArrowOffsetStart(int i) {
            this.arrowOffsetStart = i;
        }

        public final int getContentViewID() {
            return this.contentViewID;
        }

        public final WalletTips build(View view) {
            Intrinsics.checkNotNullParameter(view, "targetView");
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "targetView.context");
            WalletTips walletTips = new WalletTips(context, (DefaultConstructorMarker) null);
            walletTips.setPadding(WalletTips.f35724b, 0, WalletTips.f35724b, 0);
            this.contentViewBuilder.build(walletTips);
            return walletTips;
        }
    }
}
