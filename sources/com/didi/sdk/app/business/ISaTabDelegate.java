package com.didi.sdk.app.business;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/sdk/app/business/ISaTabDelegate;", "", "canSwitch", "", "getFragment", "Landroidx/fragment/app/Fragment;", "publicservice_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ISaTabDelegate.kt */
public interface ISaTabDelegate {

    @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 16})
    /* compiled from: ISaTabDelegate.kt */
    public static final class DefaultImpls {
        public static boolean canSwitch(ISaTabDelegate iSaTabDelegate) {
            return true;
        }
    }

    boolean canSwitch();

    Fragment getFragment();
}
