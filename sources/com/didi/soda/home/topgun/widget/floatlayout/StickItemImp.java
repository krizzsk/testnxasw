package com.didi.soda.home.topgun.widget.floatlayout;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Space;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ViewSafeHelper;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(mo148867d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0017H\u0002J\u0006\u0010)\u001a\u00020\u0015J(\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006."}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/floatlayout/StickItemImp;", "", "()V", "TAG", "", "currentStickInfo", "Lcom/didi/soda/home/topgun/widget/floatlayout/StickInfo;", "getStickLayoutHeight", "Lkotlin/Function0;", "", "getGetStickLayoutHeight", "()Lkotlin/jvm/functions/Function0;", "setGetStickLayoutHeight", "(Lkotlin/jvm/functions/Function0;)V", "listener", "Lcom/didi/soda/home/topgun/widget/floatlayout/OnStickListener;", "getListener", "()Lcom/didi/soda/home/topgun/widget/floatlayout/OnStickListener;", "setListener", "(Lcom/didi/soda/home/topgun/widget/floatlayout/OnStickListener;)V", "addPlaceView", "", "stickView", "Landroid/view/View;", "stickViewParent", "Landroid/view/ViewGroup;", "checkIsInList", "", "stickInfo", "exitStick", "getIntoStickDistance", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getStickViewParent", "intoStick", "onItemRangeChanged", "positionStart", "itemCount", "onRecycleScrolled", "removeFromParent", "child", "requestLayout", "setupStickInfo", "holder", "Lcom/didi/soda/home/topgun/widget/floatlayout/IStickHolder;", "pos", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StickItemImp.kt */
public final class StickItemImp {

    /* renamed from: a */
    private final String f45809a = "StickItemImp";

    /* renamed from: b */
    private Function0<Integer> f45810b;

    /* renamed from: c */
    private OnStickListener f45811c;

    /* renamed from: d */
    private C14847a f45812d;

    public final Function0<Integer> getGetStickLayoutHeight() {
        return this.f45810b;
    }

    public final void setGetStickLayoutHeight(Function0<Integer> function0) {
        this.f45810b = function0;
    }

    public final OnStickListener getListener() {
        return this.f45811c;
    }

    public final void setListener(OnStickListener onStickListener) {
        this.f45811c = onStickListener;
    }

    /* renamed from: a */
    private final void m33959a(IStickHolder iStickHolder, int i, View view, ViewGroup viewGroup) {
        C14847a aVar = this.f45812d;
        if (aVar == null) {
            this.f45812d = new C14847a(iStickHolder, view, viewGroup, i);
        } else {
            Intrinsics.checkNotNull(aVar);
            if (!Intrinsics.areEqual((Object) view, (Object) aVar.mo114625b())) {
                C14847a aVar2 = this.f45812d;
                Intrinsics.checkNotNull(aVar2);
                m33957a(aVar2.mo114625b());
                C14847a aVar3 = this.f45812d;
                Intrinsics.checkNotNull(aVar3);
                aVar3.mo114622a(view);
                C14847a aVar4 = this.f45812d;
                Intrinsics.checkNotNull(aVar4);
                aVar4.mo114623a(viewGroup);
                C14847a aVar5 = this.f45812d;
                Intrinsics.checkNotNull(aVar5);
                aVar5.mo114621a(i);
                C14847a aVar6 = this.f45812d;
                Intrinsics.checkNotNull(aVar6);
                aVar6.mo114624a(iStickHolder);
            }
        }
        m33958a(view, viewGroup);
    }

    /* renamed from: a */
    private final void m33957a(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    /* renamed from: a */
    private final void m33958a(View view, ViewGroup viewGroup) {
        if (viewGroup.findViewWithTag("filter_place") == null) {
            Space space = new Space(viewGroup.getContext());
            int height = view.getHeight();
            if (height == 0) {
                viewGroup.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                height = view.getHeight();
            }
            if (height > 0) {
                space.setLayoutParams(new ViewGroup.LayoutParams(1, height));
                space.setTag("filter_place");
                viewGroup.addView(space, 0);
            }
        }
    }

    /* renamed from: b */
    private final ViewGroup m33961b(View view) {
        C14847a aVar = this.f45812d;
        if (aVar == null) {
            return null;
        }
        return aVar.mo114626c();
    }

    public final void onItemRangeChanged(int i, int i2) {
        C14847a aVar = this.f45812d;
        if (aVar != null) {
            aVar.mo114620a().updateWhenFloating(i, i2);
        }
    }

    public final void requestLayout() {
        C14847a aVar = this.f45812d;
        if (aVar != null) {
            aVar.mo114625b().requestLayout();
        }
    }

    public final void onRecycleScrolled(RecyclerView recyclerView) {
        int i;
        RecyclerView.ViewHolder viewHolder;
        View view;
        int i2;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager != null) {
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            LogUtil.m32584d(this.f45809a, ">>>> firstVisiblePos = " + findFirstVisibleItemPosition + " lastVisiblePos = " + findLastVisibleItemPosition);
            Iterator it = new IntRange(findFirstVisibleItemPosition, findLastVisibleItemPosition).iterator();
            while (true) {
                i = 0;
                viewHolder = null;
                if (!it.hasNext()) {
                    view = null;
                    i2 = 0;
                    break;
                }
                i2 = ((IntIterator) it).nextInt();
                viewHolder = recyclerView.findViewHolderForAdapterPosition(i2);
                if (viewHolder instanceof IStickHolder) {
                    view = viewHolder.itemView;
                    break;
                }
            }
            if (viewHolder == null || view == null) {
                LogUtil.m32584d("TAG", " >>>>> 没有找到 对于的target");
                C14847a aVar = this.f45812d;
                if (aVar != null && m33960a(aVar)) {
                    m33962c(aVar.mo114625b());
                    return;
                }
                return;
            }
            IStickHolder iStickHolder = (IStickHolder) viewHolder;
            if (iStickHolder.openStick()) {
                View stickView = iStickHolder.getStickView();
                m33959a(iStickHolder, i2, stickView, iStickHolder.getStickParent());
                int top = view.getTop();
                Function0<Integer> function0 = this.f45810b;
                if (function0 != null) {
                    i = function0.invoke().intValue();
                }
                if (top <= i) {
                    LogUtil.m32584d("TAG", " >>>>> intoStick");
                    m33962c(stickView);
                } else {
                    LogUtil.m32584d("TAG", " >>>>> exitStick");
                    m33963d(stickView);
                }
                LogUtil.m32584d("TAG", Intrinsics.stringPlus(" >>>>> top = ", Integer.valueOf(top)));
            }
        }
    }

    /* renamed from: a */
    private final boolean m33960a(C14847a aVar) {
        if (!(aVar.mo114620a() instanceof RecyclerView.ViewHolder) || ((RecyclerView.ViewHolder) aVar.mo114620a()).itemView.getParent() == null) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private final void m33962c(View view) {
        OnStickListener onStickListener = this.f45811c;
        if (onStickListener != null) {
            onStickListener.onStickEvent(view, true);
        }
    }

    /* renamed from: d */
    private final void m33963d(View view) {
        OnStickListener onStickListener = this.f45811c;
        if (onStickListener != null) {
            onStickListener.onStickEvent(view, false);
        }
        ViewGroup b = m33961b(view);
        if (b != null) {
            ViewSafeHelper.safeAddView(b, view);
        }
    }

    public final int getIntoStickDistance(RecyclerView recyclerView) {
        Integer invoke;
        int i;
        View view;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) (recyclerView == null ? null : recyclerView.getLayoutManager());
        if (linearLayoutManager == null || this.f45812d == null || recyclerView == null) {
            return -1;
        }
        Iterator it = new IntRange(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()).iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(((IntIterator) it).nextInt());
            if (findViewHolderForAdapterPosition instanceof IStickHolder) {
                break;
            }
            if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
                i = 0;
            } else {
                i = view.getHeight();
            }
            i3 += i;
        }
        Function0<Integer> function0 = this.f45810b;
        if (!(function0 == null || (invoke = function0.invoke()) == null)) {
            i2 = invoke.intValue();
        }
        return i3 - i2;
    }
}
