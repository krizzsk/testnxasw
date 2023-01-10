package com.didi.soda.customer.foundation.util;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/util/CustomeRvExposeUtilOnlyNew;", "Lcom/didi/soda/customer/foundation/util/CustomeRvExposeUtil;", "()V", "TAG", "", "mViewQueue", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mViewQueueLen", "preFirstPosition", "handleCurrentVisibleItems", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomeRvExposeUtilOnlyNew.kt */
public final class CustomeRvExposeUtilOnlyNew extends CustomeRvExposeUtil {

    /* renamed from: a */
    private final String f43733a = "CustomeRvExposeUtilOnlyNew";

    /* renamed from: b */
    private int f43734b;

    /* renamed from: c */
    private final ArrayList<Integer> f43735c = new ArrayList<>();

    /* renamed from: d */
    private int f43736d;

    public void handleCurrentVisibleItems() {
        if (this.mRecyclerView != null && this.mRecyclerView.getVisibility() == 0) {
            try {
                int[] iArr = new int[2];
                RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
                if (layoutManager != null) {
                    if (layoutManager instanceof LinearLayoutManager) {
                        iArr = findRangeLinear((LinearLayoutManager) layoutManager);
                    }
                    if (iArr == null) {
                        return;
                    }
                    if (iArr.length >= 2) {
                        if (this.f43734b == 0) {
                            this.f43734b = (iArr[1] - iArr[0]) + 1;
                            this.f43736d = iArr[0];
                        }
                        int i = iArr[0];
                        int i2 = (iArr[0] + this.f43734b) - 1;
                        if (i <= i2) {
                            while (true) {
                                int i3 = i + 1;
                                View findViewByPosition = layoutManager.findViewByPosition(i);
                                if (!this.f43735c.contains(Integer.valueOf(i))) {
                                    if (this.f43735c.size() == this.f43734b && (!this.f43735c.isEmpty())) {
                                        LogUtil.m32584d(this.f43733a, Intrinsics.stringPlus(" mViewQueue.size(): ", Integer.valueOf(this.f43735c.size())));
                                        if (iArr[0] >= this.f43736d) {
                                            LogUtil.m32584d(this.f43733a, " 正向滑动 ");
                                            Integer remove = this.f43735c.remove(0);
                                            Intrinsics.checkNotNullExpressionValue(remove, "mViewQueue.removeAt(0)");
                                            LogUtil.m32584d(this.f43733a, Intrinsics.stringPlus(" 正向滑动 移除：", Integer.valueOf(remove.intValue())));
                                        } else {
                                            Integer remove2 = this.f43735c.remove(this.f43735c.size() - 1);
                                            Intrinsics.checkNotNullExpressionValue(remove2, "mViewQueue.removeAt(mViewQueue.size - 1)");
                                            LogUtil.m32584d(this.f43733a, Intrinsics.stringPlus(" 逆向滑动 移除：", Integer.valueOf(remove2.intValue())));
                                        }
                                    }
                                    if (iArr[0] >= this.f43736d) {
                                        LogUtil.m32584d(this.f43733a, Intrinsics.stringPlus(" 正向滑动 添加：", Integer.valueOf(i)));
                                        this.f43735c.add(Integer.valueOf(i));
                                        CollectionsKt.sort(this.f43735c);
                                    } else {
                                        LogUtil.m32584d(this.f43733a, Intrinsics.stringPlus(" 逆向滑动 添加：", Integer.valueOf(i)));
                                        this.f43735c.add(Integer.valueOf(i));
                                        CollectionsKt.sort(this.f43735c);
                                    }
                                    setCallbackForLogicVisibleView(findViewByPosition, i);
                                    LogUtil.m32584d(this.f43733a, Intrinsics.stringPlus("handleCurrentVisibleItems:for:", Integer.valueOf(i)));
                                }
                                if (i == i2) {
                                    break;
                                }
                                i = i3;
                            }
                        }
                        this.f43736d = iArr[0];
                        LogUtil.m32584d(this.f43733a, " ------------- \r\n");
                        LogUtil.m32584d(this.f43733a, Intrinsics.stringPlus("handleCurrentVisibleItems:", Integer.valueOf(this.f43734b)));
                        LogUtil.m32584d(this.f43733a, Intrinsics.stringPlus("handleCurrentVisibleItems:", Integer.valueOf(iArr[0])));
                        LogUtil.m32584d(this.f43733a, Intrinsics.stringPlus("handleCurrentVisibleItems:", Integer.valueOf(iArr[1])));
                        LogUtil.m32584d(this.f43733a, " ------------- \r\n");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
