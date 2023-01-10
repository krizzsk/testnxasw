package com.didi.payment.wallet_ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\n"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/IWalletToastConfig;", "", "gravity", "", "getGravity", "()I", "offsetX", "getOffsetX", "offsetY", "getOffsetY", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IWalletToastConfig.kt */
public interface IWalletToastConfig {

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: IWalletToastConfig.kt */
    public static final class DefaultImpls {
        public static int getGravity(IWalletToastConfig iWalletToastConfig) {
            Intrinsics.checkNotNullParameter(iWalletToastConfig, "this");
            return 17;
        }

        public static int getOffsetX(IWalletToastConfig iWalletToastConfig) {
            Intrinsics.checkNotNullParameter(iWalletToastConfig, "this");
            return 0;
        }

        public static int getOffsetY(IWalletToastConfig iWalletToastConfig) {
            Intrinsics.checkNotNullParameter(iWalletToastConfig, "this");
            return 0;
        }
    }

    int getGravity();

    int getOffsetX();

    int getOffsetY();
}
