package com.didi.payment.wallet_ui;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.didi.drouter.api.DRouter;
import com.didi.payment.wallet_ui.IWalletUI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/UiUtils;", "", "()V", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: UiUtils.kt */
public final class UiUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int f35423a = Math.min(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int f35424b = Math.max(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels);

    @Metadata(mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\rJ\t\u0010\"\u001a\u00020\rH\u0001J\t\u0010#\u001a\u00020\rH\u0001J\t\u0010$\u001a\u00020\rH\u0001J\t\u0010%\u001a\u00020\rH\u0001J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\bJ\u000e\u0010,\u001a\u00020\r2\u0006\u0010!\u001a\u00020\rJ\u000e\u0010-\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\r2\u0006\u0010!\u001a\u00020\rR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\u00048VX\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048VX\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8VX\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/UiUtils$Companion;", "Lcom/didi/payment/wallet_ui/IWalletUI;", "()V", "bigBtnCornerFraction", "", "getBigBtnCornerFraction", "()F", "isWhiteInThemeBg", "", "()Z", "midBtnCornerFraction", "getMidBtnCornerFraction", "screenHeight", "", "getScreenHeight", "()I", "screenWidth", "getScreenWidth", "smallBtnCornerFraction", "getSmallBtnCornerFraction", "walletFirstLevelButtonBgColorOrientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "getWalletFirstLevelButtonBgColorOrientation", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "walletSecondButtonConfig", "Lcom/didi/payment/wallet_ui/IWalletSecondButtonConfig;", "getWalletSecondButtonConfig", "()Lcom/didi/payment/wallet_ui/IWalletSecondButtonConfig;", "walletToastConfig", "Lcom/didi/payment/wallet_ui/IWalletToastConfig;", "getWalletToastConfig", "()Lcom/didi/payment/wallet_ui/IWalletToastConfig;", "floatSize", "size", "getEditTextLayoutWithCursorDrawable", "getThemeBgColor", "getWalletFirstLevelButtonBgEndColor", "getWalletFirstLevelButtonBgStartColor", "inflateCursorDrawableEdittext", "Landroid/widget/EditText;", "flSearchContainer", "Landroid/widget/FrameLayout;", "textSizeDp", "isBold", "intSize", "verticalFloatSize", "verticalIntSize", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: UiUtils.kt */
    public static final class Companion implements IWalletUI {
        private final /* synthetic */ IWalletUI $$delegate_0;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public float getBigBtnCornerFraction() {
            return this.$$delegate_0.getBigBtnCornerFraction();
        }

        public int getEditTextLayoutWithCursorDrawable() {
            return this.$$delegate_0.getEditTextLayoutWithCursorDrawable();
        }

        public float getMidBtnCornerFraction() {
            return this.$$delegate_0.getMidBtnCornerFraction();
        }

        public float getSmallBtnCornerFraction() {
            return this.$$delegate_0.getSmallBtnCornerFraction();
        }

        public int getThemeBgColor() {
            return this.$$delegate_0.getThemeBgColor();
        }

        public GradientDrawable.Orientation getWalletFirstLevelButtonBgColorOrientation() {
            return this.$$delegate_0.getWalletFirstLevelButtonBgColorOrientation();
        }

        public int getWalletFirstLevelButtonBgEndColor() {
            return this.$$delegate_0.getWalletFirstLevelButtonBgEndColor();
        }

        public int getWalletFirstLevelButtonBgStartColor() {
            return this.$$delegate_0.getWalletFirstLevelButtonBgStartColor();
        }

        public IWalletSecondButtonConfig getWalletSecondButtonConfig() {
            return this.$$delegate_0.getWalletSecondButtonConfig();
        }

        public IWalletToastConfig getWalletToastConfig() {
            return this.$$delegate_0.getWalletToastConfig();
        }

        public boolean isWhiteInThemeBg() {
            return this.$$delegate_0.isWhiteInThemeBg();
        }

        private Companion() {
            IWalletUI iWalletUI;
            if (UiUtilsKt.getSwitchWalletUIImpl()) {
                iWalletUI = UiUtilsKt.getWalletUIImpl();
                if (iWalletUI == null) {
                    iWalletUI = new IWalletUI() {
                        public float getBigBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getBigBtnCornerFraction(this);
                        }

                        public int getEditTextLayoutWithCursorDrawable() {
                            return IWalletUI.DefaultImpls.getEditTextLayoutWithCursorDrawable(this);
                        }

                        public float getMidBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getMidBtnCornerFraction(this);
                        }

                        public float getSmallBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getSmallBtnCornerFraction(this);
                        }

                        public int getThemeBgColor() {
                            return IWalletUI.DefaultImpls.getThemeBgColor(this);
                        }

                        public GradientDrawable.Orientation getWalletFirstLevelButtonBgColorOrientation() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgColorOrientation(this);
                        }

                        public int getWalletFirstLevelButtonBgEndColor() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgEndColor(this);
                        }

                        public int getWalletFirstLevelButtonBgStartColor() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgStartColor(this);
                        }

                        public IWalletSecondButtonConfig getWalletSecondButtonConfig() {
                            return IWalletUI.DefaultImpls.getWalletSecondButtonConfig(this);
                        }

                        public IWalletToastConfig getWalletToastConfig() {
                            return IWalletUI.DefaultImpls.getWalletToastConfig(this);
                        }

                        public boolean isWhiteInThemeBg() {
                            return IWalletUI.DefaultImpls.isWhiteInThemeBg(this);
                        }
                    };
                }
            } else {
                iWalletUI = DRouter.build(IWalletUI.class).getService(new Object[0]);
                if (iWalletUI == null) {
                    iWalletUI = new IWalletUI() {
                        public float getBigBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getBigBtnCornerFraction(this);
                        }

                        public int getEditTextLayoutWithCursorDrawable() {
                            return IWalletUI.DefaultImpls.getEditTextLayoutWithCursorDrawable(this);
                        }

                        public float getMidBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getMidBtnCornerFraction(this);
                        }

                        public float getSmallBtnCornerFraction() {
                            return IWalletUI.DefaultImpls.getSmallBtnCornerFraction(this);
                        }

                        public int getThemeBgColor() {
                            return IWalletUI.DefaultImpls.getThemeBgColor(this);
                        }

                        public GradientDrawable.Orientation getWalletFirstLevelButtonBgColorOrientation() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgColorOrientation(this);
                        }

                        public int getWalletFirstLevelButtonBgEndColor() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgEndColor(this);
                        }

                        public int getWalletFirstLevelButtonBgStartColor() {
                            return IWalletUI.DefaultImpls.getWalletFirstLevelButtonBgStartColor(this);
                        }

                        public IWalletSecondButtonConfig getWalletSecondButtonConfig() {
                            return IWalletUI.DefaultImpls.getWalletSecondButtonConfig(this);
                        }

                        public IWalletToastConfig getWalletToastConfig() {
                            return IWalletUI.DefaultImpls.getWalletToastConfig(this);
                        }

                        public boolean isWhiteInThemeBg() {
                            return IWalletUI.DefaultImpls.isWhiteInThemeBg(this);
                        }
                    };
                }
            }
            this.$$delegate_0 = iWalletUI;
        }

        public final int getScreenWidth() {
            return UiUtils.f35423a;
        }

        public final int getScreenHeight() {
            return UiUtils.f35424b;
        }

        public final int intSize(int i) {
            return (i * getScreenWidth()) / 750;
        }

        public final float floatSize(int i) {
            return ((float) (i * getScreenWidth())) / 750.0f;
        }

        public final int verticalIntSize(int i) {
            return (i * getScreenHeight()) / 750;
        }

        public final float verticalFloatSize(int i) {
            return ((float) (i * getScreenHeight())) / 750.0f;
        }

        public static /* synthetic */ EditText inflateCursorDrawableEdittext$default(Companion companion, FrameLayout frameLayout, float f, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.inflateCursorDrawableEdittext(frameLayout, f, z);
        }

        public final EditText inflateCursorDrawableEdittext(FrameLayout frameLayout, float f, boolean z) {
            EditText editText;
            Intrinsics.checkNotNullParameter(frameLayout, "flSearchContainer");
            try {
                View inflate = View.inflate(frameLayout.getContext(), getEditTextLayoutWithCursorDrawable(), (ViewGroup) null);
                if (inflate != null) {
                    editText = (EditText) inflate;
                    if (editText == null) {
                        editText = new EditText(frameLayout.getContext());
                    }
                    editText.setBackground((Drawable) null);
                    editText.setTextColor(-16777216);
                    editText.setTextSize(1, f);
                    if (z) {
                        editText.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                    editText.setIncludeFontPadding(false);
                    editText.setHintTextColor(Color.parseColor("#D4D7D9"));
                    frameLayout.addView(editText, -1, -1);
                    return editText;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
            } catch (Exception unused) {
                editText = null;
            }
        }
    }
}
