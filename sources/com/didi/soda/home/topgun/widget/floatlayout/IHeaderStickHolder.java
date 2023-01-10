package com.didi.soda.home.topgun.widget.floatlayout;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/floatlayout/IHeaderStickHolder;", "", "getFloatScrollOffset", "", "getIntoFloatValue", "getStickParentView", "Landroid/view/ViewGroup;", "getStickView", "Landroid/view/View;", "onFloatScroll", "", "progress", "", "updateWhenFloating", "positionStart", "itemCount", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: IStickHolder.kt */
public interface IHeaderStickHolder {
    int getFloatScrollOffset();

    int getIntoFloatValue();

    ViewGroup getStickParentView();

    View getStickView();

    void onFloatScroll(float f);

    void updateWhenFloating(int i, int i2);
}
