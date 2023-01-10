package com.didi.soda.customer.foundation.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/util/CustomerRvExposeUtilOnlyOnce;", "", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mExposureListener", "Lcom/didi/soda/customer/foundation/util/CustomerRvExposeUtilOnlyOnce$IOnExposureListener;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/didi/soda/customer/foundation/util/CustomerRvExposeUtilOnlyOnce$IOnExposureListener;)V", "TAG", "", "isEnableExposure", "", "()Z", "setEnableExposure", "(Z)V", "mCheckChildViewExposure", "mExposureList", "", "", "mScrollState", "mUploadList", "mViewVisible", "Landroid/graphics/Rect;", "checkChildExposeStatus", "", "checkExposure", "childView", "Landroid/view/View;", "uploadList", "IOnExposureListener", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerRvExposeUtilOnlyOnce.kt */
public final class CustomerRvExposeUtilOnlyOnce {

    /* renamed from: a */
    private final RecyclerView f43812a;

    /* renamed from: b */
    private final IOnExposureListener f43813b;

    /* renamed from: c */
    private final String f43814c = "CustomerRvExposeUtilOnlyOnce";

    /* renamed from: d */
    private final List<Integer> f43815d = new ArrayList();

    /* renamed from: e */
    private final List<Integer> f43816e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f43817f;

    /* renamed from: g */
    private boolean f43818g = true;

    /* renamed from: h */
    private boolean f43819h = true;

    /* renamed from: i */
    private final Rect f43820i = new Rect();

    @Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&¨\u0006\n"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/util/CustomerRvExposeUtilOnlyOnce$IOnExposureListener;", "", "onExposure", "", "position", "", "onUpload", "", "exposureList", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomerRvExposeUtilOnlyOnce.kt */
    public interface IOnExposureListener {
        void onExposure(int i);

        boolean onUpload(List<Integer> list);
    }

    public CustomerRvExposeUtilOnlyOnce(RecyclerView recyclerView, IOnExposureListener iOnExposureListener) {
        Intrinsics.checkNotNullParameter(recyclerView, "mRecyclerView");
        this.f43812a = recyclerView;
        this.f43813b = iOnExposureListener;
        this.f43812a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                CustomerRvExposeUtilOnlyOnce.m32684a(CustomerRvExposeUtilOnlyOnce.this);
            }
        });
        this.f43812a.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            final /* synthetic */ CustomerRvExposeUtilOnlyOnce this$0;

            {
                this.this$0 = r1;
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, i);
                this.this$0.f43817f = i;
                this.this$0.m32683a();
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
                if (this.this$0.isEnableExposure()) {
                    if (this.this$0.f43817f != 2 || Math.abs(i2) <= 50) {
                        this.this$0.checkChildExposeStatus();
                    }
                }
            }
        });
    }

    public final boolean isEnableExposure() {
        return this.f43818g;
    }

    public final void setEnableExposure(boolean z) {
        this.f43818g = z;
    }

    public final void checkChildExposeStatus() {
        int childCount;
        if (this.f43818g && (childCount = this.f43812a.getChildCount()) != 0) {
            int i = 0;
            if (childCount > 0) {
                while (true) {
                    int i2 = i + 1;
                    View childAt = this.f43812a.getChildAt(i);
                    if (childAt != null) {
                        childAt.getLocalVisibleRect(this.f43820i);
                        if (this.f43820i.height() > childAt.getHeight() / 2 && this.f43820i.top < this.f43812a.getBottom()) {
                            m32685a(childAt);
                        }
                    }
                    if (i2 < childCount) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private final boolean m32685a(View view) {
        int childAdapterPosition = this.f43812a.getChildAdapterPosition(view);
        if (childAdapterPosition < 0 || this.f43815d.contains(Integer.valueOf(childAdapterPosition))) {
            return false;
        }
        this.f43815d.add(Integer.valueOf(childAdapterPosition));
        this.f43816e.add(Integer.valueOf(childAdapterPosition));
        IOnExposureListener iOnExposureListener = this.f43813b;
        if (iOnExposureListener != null) {
            iOnExposureListener.onExposure(childAdapterPosition);
        }
        LogUtil.m32584d(this.f43814c, Intrinsics.stringPlus("曝光第几个:", Integer.valueOf(childAdapterPosition)));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32683a() {
        IOnExposureListener iOnExposureListener;
        if (this.f43817f == 0 && this.f43816e.size() > 0 && (iOnExposureListener = this.f43813b) != null && iOnExposureListener.onUpload(this.f43816e)) {
            this.f43816e.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32684a(CustomerRvExposeUtilOnlyOnce customerRvExposeUtilOnlyOnce) {
        Intrinsics.checkNotNullParameter(customerRvExposeUtilOnlyOnce, "this$0");
        if (customerRvExposeUtilOnlyOnce.f43812a.getChildCount() != 0 && customerRvExposeUtilOnlyOnce.f43819h) {
            customerRvExposeUtilOnlyOnce.checkChildExposeStatus();
            customerRvExposeUtilOnlyOnce.m32683a();
            customerRvExposeUtilOnlyOnce.f43819h = false;
        }
    }
}
