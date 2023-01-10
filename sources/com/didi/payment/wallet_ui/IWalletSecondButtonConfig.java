package com.didi.payment.wallet_ui;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\b\u0010\u0005\u001a\u00020\u0003H\u0017J\b\u0010\u0006\u001a\u00020\u0003H\u0017J\b\u0010\u0007\u001a\u00020\u0003H\u0017J\b\u0010\b\u001a\u00020\u0003H\u0017J\b\u0010\t\u001a\u00020\u0003H\u0017¨\u0006\n"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/IWalletSecondButtonConfig;", "", "getBorderWidth", "", "getEnableBgColor", "getEnableBorderColor", "getPressedBgColor", "getPressedBorderColor", "getUnableBgColor", "getUnableBorderColor", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IWalletSecondButtonConfig.kt */
public interface IWalletSecondButtonConfig {
    int getBorderWidth();

    int getEnableBgColor();

    int getEnableBorderColor();

    int getPressedBgColor();

    int getPressedBorderColor();

    int getUnableBgColor();

    int getUnableBorderColor();

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: IWalletSecondButtonConfig.kt */
    public static final class DefaultImpls {
        public static int getEnableBgColor(IWalletSecondButtonConfig iWalletSecondButtonConfig) {
            Intrinsics.checkNotNullParameter(iWalletSecondButtonConfig, "this");
            return -1;
        }

        public static int getUnableBgColor(IWalletSecondButtonConfig iWalletSecondButtonConfig) {
            Intrinsics.checkNotNullParameter(iWalletSecondButtonConfig, "this");
            return -1;
        }

        public static int getBorderWidth(IWalletSecondButtonConfig iWalletSecondButtonConfig) {
            Intrinsics.checkNotNullParameter(iWalletSecondButtonConfig, "this");
            return UiUtils.Companion.intSize(2);
        }

        public static int getEnableBorderColor(IWalletSecondButtonConfig iWalletSecondButtonConfig) {
            Intrinsics.checkNotNullParameter(iWalletSecondButtonConfig, "this");
            return Color.parseColor("#666666");
        }

        public static int getPressedBgColor(IWalletSecondButtonConfig iWalletSecondButtonConfig) {
            Intrinsics.checkNotNullParameter(iWalletSecondButtonConfig, "this");
            return Color.parseColor("#14000000");
        }

        public static int getPressedBorderColor(IWalletSecondButtonConfig iWalletSecondButtonConfig) {
            Intrinsics.checkNotNullParameter(iWalletSecondButtonConfig, "this");
            return Color.parseColor("#666666");
        }

        public static int getUnableBorderColor(IWalletSecondButtonConfig iWalletSecondButtonConfig) {
            Intrinsics.checkNotNullParameter(iWalletSecondButtonConfig, "this");
            return Color.parseColor("#D4D7D9");
        }
    }
}
