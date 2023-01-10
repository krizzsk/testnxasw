package com.didi.entrega.billmap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.LiveHandler;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.common.map.BestViewer;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.entrega.billmap.Contract;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.map.marker.ReceiverMarker;
import com.didi.entrega.customer.map.marker.SenderMarker;
import com.didi.entrega.customer.map.model.BestViewModel;
import com.didi.entrega.customer.widget.map.SodaMapView;
import com.didi.foundation.sdk.map.MapViewImpl;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0006\u0010\u0016\u001a\u00020\fJ\b\u0010\u0017\u001a\u00020\fH\u0014J\b\u0010\u0018\u001a\u00020\fH\u0014J\b\u0010\u0019\u001a\u00020\fH\u0014J\b\u0010\u001a\u001a\u00020\fH\u0014J\u0006\u0010\u001b\u001a\u00020\fJ\b\u0010\u001c\u001a\u00020\fH\u0002J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\"H\u0002J0\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006*"}, mo148868d2 = {"Lcom/didi/entrega/billmap/BillMapView;", "Lcom/didi/entrega/billmap/Contract$AbsBillMapView;", "()V", "mDefaultPadding", "", "mReceiverMarker", "Lcom/didi/entrega/customer/map/marker/ReceiverMarker;", "mSenderMarker", "Lcom/didi/entrega/customer/map/marker/SenderMarker;", "sodaMapView", "Lcom/didi/entrega/customer/widget/map/SodaMapView;", "cleanSendAndRecMarker", "", "destroyMarker", "getReceiverMark", "getSenderMark", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initView", "onCreate", "onDestroy", "onPause", "onResume", "removerMarker", "resetMapSetting", "setMapPadding", "startLatLng", "Lcom/didi/common/map/model/LatLng;", "endLatLng", "callback", "Lkotlin/Function0;", "showSendAndRecMarkInfo", "senderLatLng", "receiverLatLng", "sendTip", "", "receiveTip", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillMapView.kt */
public final class BillMapView extends Contract.AbsBillMapView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final String f21469e = "BillMapView";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final float f21470f = 230.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final float f21471g = 290.0f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static float f21472h = 230.0f;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static int f21473i;

    /* renamed from: a */
    private SodaMapView f21474a;

    /* renamed from: b */
    private SenderMarker f21475b;

    /* renamed from: c */
    private ReceiverMarker f21476c;

    /* renamed from: d */
    private final int f21477d = DisplayUtils.dip2px(GlobalContext.getContext(), 20.0f);

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_component_bill_map, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…nent_bill_map, container)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        initView();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SodaMapView sodaMapView = this.f21474a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SodaMapView sodaMapView = this.f21474a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m18062a();
        removerMarker();
    }

    public void showSendAndRecMarkInfo(LatLng latLng, LatLng latLng2, String str, String str2) {
        if (latLng != null) {
            m18063a(latLng, latLng2, new BillMapView$showSendAndRecMarkInfo$1(this, latLng, latLng2, str, str2));
        } else if (latLng2 != null) {
            m18063a(latLng2, latLng, new BillMapView$showSendAndRecMarkInfo$2(this, latLng2, str2));
        }
    }

    public void cleanSendAndRecMarker() {
        ReceiverMarker receiverMarker = this.f21476c;
        if (receiverMarker != null) {
            receiverMarker.remove();
        }
        SenderMarker senderMarker = this.f21475b;
        if (senderMarker != null) {
            senderMarker.remove();
        }
    }

    public final void initView() {
        View findViewById = getView().findViewById(R.id.customer_custom_map_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.customer_custom_map_view)");
        SodaMapView sodaMapView = (SodaMapView) findViewById;
        this.f21474a = sodaMapView;
        SodaMapView sodaMapView2 = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.setLogoVisibility(false);
        SodaMapView sodaMapView3 = this.f21474a;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
        } else {
            sodaMapView2 = sodaMapView3;
        }
        sodaMapView2.removeAllElement();
    }

    public final void removerMarker() {
        m18067d();
        SodaMapView sodaMapView = this.f21474a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onDestroy();
    }

    /* renamed from: a */
    private final void m18063a(LatLng latLng, LatLng latLng2, Function0<Unit> function0) {
        BestViewModel bestViewModel = new BestViewModel();
        int i = this.f21477d;
        bestViewModel.mPadding = new Padding(i * 2, (i * 2) + CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()) + DisplayUtils.dip2px(getContext(), (float) f21473i), this.f21477d * 2, CustomerSystemUtil.getRealScreenHeight(getContext()) - DisplayUtils.dip2px(getContext(), f21472h));
        bestViewModel.mIncludes.add(latLng);
        if (latLng2 != null) {
            bestViewModel.mIncludes.add(latLng2);
        }
        SodaMapView sodaMapView = this.f21474a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.centerBestView(bestViewModel, new BestViewer.IBestViewListener(function0) {
            public final /* synthetic */ Function0 f$1;

            {
                this.f$1 = r2;
            }

            public final void onFinished() {
                BillMapView.m18064a(BillMapView.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18064a(BillMapView billMapView, Function0 function0) {
        LiveHandler liveHandler;
        Intrinsics.checkNotNullParameter(billMapView, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$callback");
        ScopeContext scopeContext = billMapView.getScopeContext();
        boolean z = true;
        if (scopeContext == null || (liveHandler = scopeContext.getLiveHandler()) == null || !liveHandler.isActive()) {
            z = false;
        }
        if (z) {
            function0.invoke();
        }
    }

    /* renamed from: a */
    private final void m18062a() {
        SodaMapView sodaMapView = this.f21474a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.setLogoVisibility(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final ReceiverMarker m18065b() {
        SodaMapView sodaMapView = this.f21474a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        MapViewImpl mapImpl = sodaMapView.getMapImpl();
        Intrinsics.checkNotNullExpressionValue(mapImpl, "sodaMapView.mapImpl");
        if (this.f21476c == null) {
            this.f21476c = new ReceiverMarker(getContext(), mapImpl, 1);
        }
        ReceiverMarker receiverMarker = this.f21476c;
        if (receiverMarker != null) {
            return receiverMarker;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.customer.map.marker.ReceiverMarker");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final SenderMarker m18066c() {
        SodaMapView sodaMapView = this.f21474a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        MapViewImpl mapImpl = sodaMapView.getMapImpl();
        Intrinsics.checkNotNullExpressionValue(mapImpl, "sodaMapView.mapImpl");
        if (this.f21475b == null) {
            this.f21475b = new SenderMarker(getContext(), mapImpl, 1);
        }
        SenderMarker senderMarker = this.f21475b;
        if (senderMarker != null) {
            return senderMarker;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.customer.map.marker.SenderMarker");
    }

    /* renamed from: d */
    private final void m18067d() {
        LogUtil.m18185i(f21469e, "destroyMarker===start");
        if (this.f21475b != null) {
            LogUtil.m18185i(f21469e, "destroyMarker===mSenderMarker remove");
            SenderMarker senderMarker = this.f21475b;
            if (senderMarker != null) {
                senderMarker.onDestroy();
            }
            this.f21475b = null;
        }
        if (this.f21476c != null) {
            LogUtil.m18185i(f21469e, "destroyMarker===mReceiverMarker remove");
            ReceiverMarker receiverMarker = this.f21476c;
            if (receiverMarker != null) {
                receiverMarker.onDestroy();
            }
            this.f21476c = null;
        }
        LogUtil.m18185i(f21469e, "destroyMarker===end");
    }

    @Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/entrega/billmap/BillMapView$Companion;", "", "()V", "BILL_GRA_TOP_MARGIN", "", "getBILL_GRA_TOP_MARGIN", "()F", "BILL_MAP_TOP_MARGIN", "getBILL_MAP_TOP_MARGIN", "TAG", "", "mMapMarginBottom", "getMMapMarginBottom", "setMMapMarginBottom", "(F)V", "mMapMarginTop", "", "getMMapMarginTop", "()I", "setMMapMarginTop", "(I)V", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BillMapView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final float getBILL_MAP_TOP_MARGIN() {
            return BillMapView.f21470f;
        }

        public final float getBILL_GRA_TOP_MARGIN() {
            return BillMapView.f21471g;
        }

        public final float getMMapMarginBottom() {
            return BillMapView.f21472h;
        }

        public final void setMMapMarginBottom(float f) {
            BillMapView.f21472h = f;
        }

        public final int getMMapMarginTop() {
            return BillMapView.f21473i;
        }

        public final void setMMapMarginTop(int i) {
            BillMapView.f21473i = i;
        }
    }
}
