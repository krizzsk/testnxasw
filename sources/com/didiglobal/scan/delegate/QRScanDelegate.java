package com.didiglobal.scan.delegate;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, mo148868d2 = {"Lcom/didiglobal/scan/delegate/QRScanDelegate;", "", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "titleBar", "Landroid/view/View;", "getTitleBar", "()Landroid/view/View;", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: QRScanDelegate.kt */
public interface QRScanDelegate {
    Activity getActivity();

    Fragment getFragment();

    View getTitleBar();
}
