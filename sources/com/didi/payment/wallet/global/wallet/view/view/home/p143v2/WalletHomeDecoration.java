package com.didi.payment.wallet.global.wallet.view.view.home.p143v2;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.IData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010$\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR*\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006*"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "list", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "left", "", "right", "gap", "(Ljava/util/List;III)V", "getGap", "()I", "setGap", "(I)V", "getLeft", "setLeft", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getRight", "setRight", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "onDrawOver", "setItemOffsets", "index", "rowCount", "setOneColumnOffsets", "setTwoColumnOffsets", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeDecoration */
/* compiled from: WalletHomeDecoration.kt */
public final class WalletHomeDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private List<WalletHomeHolderData<? extends IData>> f35172a;

    /* renamed from: b */
    private int f35173b;

    /* renamed from: c */
    private int f35174c;

    /* renamed from: d */
    private int f35175d;

    public WalletHomeDecoration(List<WalletHomeHolderData<? extends IData>> list, int i, int i2, int i3) {
        this.f35172a = list;
        this.f35173b = i;
        this.f35174c = i2;
        this.f35175d = i3;
    }

    public final int getGap() {
        return this.f35175d;
    }

    public final int getLeft() {
        return this.f35173b;
    }

    public final List<WalletHomeHolderData<? extends IData>> getList() {
        return this.f35172a;
    }

    public final int getRight() {
        return this.f35174c;
    }

    public final void setGap(int i) {
        this.f35175d = i;
    }

    public final void setLeft(int i) {
        this.f35173b = i;
    }

    public final void setList(List<WalletHomeHolderData<? extends IData>> list) {
        this.f35172a = list;
    }

    public final void setRight(int i) {
        this.f35174c = i;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(canvas, recyclerView, state);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, recyclerView, state);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Integer localIndex;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        List<WalletHomeHolderData<? extends IData>> list = this.f35172a;
        if (childAdapterPosition < (list == null ? 0 : list.size())) {
            List<WalletHomeHolderData<? extends IData>> list2 = this.f35172a;
            Integer num = null;
            WalletHomeHolderData walletHomeHolderData = list2 == null ? null : list2.get(childAdapterPosition);
            if (walletHomeHolderData != null) {
                num = walletHomeHolderData.getViewType();
            }
            if (num != null && num.intValue() == 2) {
                Integer localIndex2 = walletHomeHolderData.getLocalIndex();
                if (localIndex2 != null) {
                    m26760a(localIndex2.intValue(), 3, rect);
                }
            } else if (num != null && num.intValue() == 3) {
                Integer localIndex3 = walletHomeHolderData.getLocalIndex();
                if (localIndex3 != null) {
                    m26761a(localIndex3.intValue(), rect);
                }
            } else if (num != null && num.intValue() == 4 && (localIndex = walletHomeHolderData.getLocalIndex()) != null) {
                localIndex.intValue();
                m26762a(rect);
            }
        }
    }

    /* renamed from: a */
    private final void m26760a(int i, int i2, Rect rect) {
        int i3 = i % i2;
        if (i3 == 0) {
            rect.left = this.f35173b;
            rect.right = 0;
        } else if (i3 == i2 - 1) {
            rect.left = 0;
            rect.right = this.f35174c;
        } else {
            rect.left = this.f35175d;
            rect.right = this.f35175d;
        }
    }

    /* renamed from: a */
    private final void m26761a(int i, Rect rect) {
        int i2 = i % 2;
        if (i2 == 0) {
            rect.left = this.f35173b;
            rect.right = this.f35175d / 2;
        } else if (i2 == 1) {
            rect.left = this.f35175d / 2;
            rect.right = this.f35174c;
        }
    }

    /* renamed from: a */
    private final void m26762a(Rect rect) {
        rect.left = this.f35173b;
        rect.right = this.f35174c;
    }
}
