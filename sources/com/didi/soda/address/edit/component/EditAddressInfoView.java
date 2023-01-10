package com.didi.soda.address.edit.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.address.edit.binder.EditAddressModel;
import com.didi.soda.address.edit.component.Contract;
import com.didi.soda.address.manager.AddressKeyboardStatus;
import com.didi.soda.address.manager.AutoShowType;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.address.util.AddressAnimHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.map.model.BestViewModel;
import com.didi.soda.customer.widget.map.SodaMapView;
import com.didi.soda.order.view.AddressCardRecyclerView;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0002\u0011\u001b\b\u0007\u0018\u00002\u00020\u0001:\u0001sB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010B\u001a\u00020C2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010D\u001a\u00020\u0006H\u0016J\b\u0010E\u001a\u00020CH\u0002J\u0010\u0010F\u001a\u00020C2\u0006\u0010G\u001a\u00020\u0016H\u0002J\u0010\u0010H\u001a\u00020C2\u0006\u0010G\u001a\u00020\u0016H\u0002J\u0012\u0010I\u001a\u00020C2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\n\u0010L\u001a\u0004\u0018\u00010MH\u0014J\b\u0010N\u001a\u00020\u0016H\u0002J\u0010\u0010O\u001a\u00020C2\u0006\u0010G\u001a\u00020\u0016H\u0002J\b\u0010P\u001a\u00020CH\u0016J\u0018\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020K2\u0006\u0010S\u001a\u00020!H\u0016J\u0018\u0010T\u001a\u00020\f2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0014J\b\u0010Y\u001a\u00020CH\u0002J\b\u0010Z\u001a\u00020CH\u0014J\b\u0010[\u001a\u00020CH\u0002J\u0010\u0010\\\u001a\u00020C2\u0006\u0010]\u001a\u00020\fH\u0002J\b\u0010^\u001a\u00020CH\u0016J\b\u0010_\u001a\u00020CH\u0014J\b\u0010`\u001a\u00020CH\u0016J\b\u0010a\u001a\u00020CH\u0014J\u0010\u0010b\u001a\u00020C2\u0006\u0010c\u001a\u00020\u0019H\u0002J\u0012\u0010d\u001a\u00020C2\b\u0010e\u001a\u0004\u0018\u00010=H\u0002J\b\u0010f\u001a\u00020CH\u0016J\u0010\u0010g\u001a\u00020C2\u0006\u0010h\u001a\u00020\u0006H\u0002J\b\u0010i\u001a\u00020CH\u0002J\b\u0010j\u001a\u00020CH\u0002J\u0018\u0010k\u001a\u00020C2\u0006\u0010G\u001a\u00020\u00162\u0006\u0010l\u001a\u00020\u0006H\u0002J\b\u0010m\u001a\u00020CH\u0002J\b\u0010n\u001a\u00020CH\u0002J\u0010\u0010o\u001a\u00020C2\u0006\u0010p\u001a\u00020qH\u0002J\b\u0010r\u001a\u00020CH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0010\u0010,\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00190;X.¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006t"}, mo148868d2 = {"Lcom/didi/soda/address/edit/component/EditAddressInfoView;", "Lcom/didi/soda/address/edit/component/Contract$AbsEditAddressInfoView;", "()V", "addressAnimHelper", "Lcom/didi/soda/address/util/AddressAnimHelper;", "addressMoveDistance", "", "getAddressMoveDistance", "()I", "setAddressMoveDistance", "(I)V", "backView", "Landroid/view/View;", "barTextView", "Landroid/widget/TextView;", "barView", "cameraListener", "com/didi/soda/address/edit/component/EditAddressInfoView$cameraListener$1", "Lcom/didi/soda/address/edit/component/EditAddressInfoView$cameraListener$1;", "confirmBtn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "desLatLng", "Lcom/didi/common/map/model/LatLng;", "dragView", "editAddress", "Lcom/didi/soda/address/edit/binder/EditAddressModel;", "gesListener", "com/didi/soda/address/edit/component/EditAddressInfoView$gesListener$1", "Lcom/didi/soda/address/edit/component/EditAddressInfoView$gesListener$1;", "initHeight", "getInitHeight", "setInitHeight", "isHasTouchMap", "", "isMapExpend", "isMapStable", "ivPin", "Landroid/widget/ImageView;", "mSmoothScroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "getMSmoothScroller", "()Landroidx/recyclerview/widget/LinearSmoothScroller;", "mSmoothScroller$delegate", "Lkotlin/Lazy;", "pinView", "recyclerView", "Lcom/didi/soda/order/view/AddressCardRecyclerView;", "resetView", "rootContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rootFocusListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "rootPinView", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "saveAddressAction", "Lkotlin/Function0;", "saveContractAction", "Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;", "sodaMapView", "Lcom/didi/soda/customer/widget/map/SodaMapView;", "topAlphaMask", "topMask", "centerBestView", "", "topEmptyHeight", "desToryTopView", "downAddress", "centerLatLng", "dragDownAddress", "drawOrUpdateBarView", "txt", "", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "getMapCenterLatLng", "getReversePoi", "hideLoading", "hidePinLoading", "barStr", "isMapGesture", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initConfirmBtn", "initItemBinders", "initMapListener", "initView", "root", "onCreate", "onDestroy", "onPause", "onResume", "onSaveAddress", "editAddressModel", "onSaveContact", "contact", "pinLoading", "refreshRecyclerExpandHieght", "newHeight", "scrollItemToTop", "scrollToBottom", "setMapPadding", "bottomPadding", "upAddress", "updateExpend", "updateMaskAlpha", "progress", "", "updateScrollProgress", "LinearTopSmoothScroller", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EditAddressInfoView.kt */
public final class EditAddressInfoView extends Contract.AbsEditAddressInfoView {

    /* renamed from: A */
    private final EditAddressInfoView$cameraListener$1 f41458A = new EditAddressInfoView$cameraListener$1(this);

    /* renamed from: B */
    private final ViewTreeObserver.OnGlobalLayoutListener f41459B = new ViewTreeObserver.OnGlobalLayoutListener() {
        public final void onGlobalLayout() {
            EditAddressInfoView.m31131c(EditAddressInfoView.this);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SodaMapView f41460a;

    /* renamed from: b */
    private LatLng f41461b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AddressCardRecyclerView f41462c;

    /* renamed from: d */
    private ConstraintLayout f41463d;

    /* renamed from: e */
    private View f41464e;

    /* renamed from: f */
    private View f41465f;

    /* renamed from: g */
    private RFMainButton f41466g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f41467h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Function0<? extends ContactEntity> f41468i = EditAddressInfoView$saveContractAction$1.INSTANCE;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Function0<EditAddressModel> f41469j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AddressAnimHelper f41470k;

    /* renamed from: l */
    private final Lazy f41471l = LazyKt.lazy(new EditAddressInfoView$mSmoothScroller$2(this));
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f41472m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View f41473n;

    /* renamed from: o */
    private ImageView f41474o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View f41475p;

    /* renamed from: q */
    private View f41476q;

    /* renamed from: r */
    private TextView f41477r;
    public View rootView;

    /* renamed from: s */
    private TextView f41478s;

    /* renamed from: t */
    private View f41479t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f41480u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f41481v;

    /* renamed from: w */
    private EditAddressModel f41482w;

    /* renamed from: x */
    private int f41483x;

    /* renamed from: y */
    private int f41484y;

    /* renamed from: z */
    private final EditAddressInfoView$gesListener$1 f41485z = new EditAddressInfoView$gesListener$1(this);

    public final View getRootView() {
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public final void setRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.rootView = view;
    }

    /* renamed from: a */
    private final LinearSmoothScroller m31110a() {
        return (LinearSmoothScroller) this.f41471l.getValue();
    }

    public final int getAddressMoveDistance() {
        return this.f41483x;
    }

    public final void setAddressMoveDistance(int i) {
        this.f41483x = i;
    }

    public final int getInitHeight() {
        return this.f41484y;
    }

    public final void setInitHeight(int i) {
        this.f41484y = i;
    }

    public void hideLoading() {
        RFMainButton rFMainButton = this.f41466g;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            rFMainButton = null;
        }
        rFMainButton.setLoading(false);
    }

    public void centerBestView(EditAddressModel editAddressModel, int i) {
        this.f41482w = editAddressModel;
        if (editAddressModel != null) {
            this.f41461b = new LatLng(editAddressModel.getLat(), editAddressModel.getLng());
        }
        if (this.f41461b != null) {
            BestViewModel bestViewModel = new BestViewModel();
            int dip2px = DisplayUtils.dip2px(getContext(), 20.0f);
            bestViewModel.mPadding = new Padding(dip2px, dip2px, dip2px, dip2px);
            bestViewModel.mPadding.top = 0;
            bestViewModel.mPadding.bottom = getNovaRecyclerView().getHeight() + ResourceHelper.getDimensionPixelSize(R.dimen.customer_148px);
            bestViewModel.mIncludes.add(this.f41461b);
            bestViewModel.zoomCenter = this.f41461b;
            SodaMapView sodaMapView = this.f41460a;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
                sodaMapView = null;
            }
            sodaMapView.centerBestView(bestViewModel, new BestViewer.IBestViewListener(editAddressModel) {
                public final /* synthetic */ EditAddressModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onFinished() {
                    EditAddressInfoView.m31121a(EditAddressInfoView.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31121a(EditAddressInfoView editAddressInfoView, EditAddressModel editAddressModel) {
        String addressDisplayName;
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        String str = "";
        if (!(editAddressModel == null || (addressDisplayName = editAddressModel.getAddressDisplayName()) == null)) {
            str = addressDisplayName;
        }
        editAddressInfoView.m31124a(str);
        View view = editAddressInfoView.f41473n;
        View view2 = editAddressInfoView.f41475p;
        AddressCardRecyclerView addressCardRecyclerView = editAddressInfoView.f41462c;
        if (addressCardRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            addressCardRecyclerView = null;
        }
        editAddressInfoView.f41470k = new AddressAnimHelper(view, view2, addressCardRecyclerView);
    }

    /* renamed from: a */
    private final void m31124a(String str) {
        View view;
        SodaMapView sodaMapView = null;
        if (this.f41476q == null || this.f41475p == null || this.f41473n == null) {
            View inflate = View.inflate(getRootView().getContext(), R.layout.customer_view_address_pinview, (ViewGroup) null);
            this.f41476q = inflate;
            if (inflate == null) {
                view = null;
            } else {
                view = inflate.findViewById(R.id.ll_bar);
            }
            this.f41475p = view;
            View view2 = this.f41476q;
            this.f41477r = view2 == null ? null : (TextView) view2.findViewById(R.id.tv_address);
            View view3 = this.f41476q;
            this.f41473n = view3 == null ? null : view3.findViewById(R.id.iv_pin);
            View view4 = this.f41476q;
            ImageView imageView = view4 == null ? null : (ImageView) view4.findViewById(R.id.iv_sm_pin);
            this.f41474o = imageView;
            if (imageView != null) {
                imageView.setColorFilter(SkinUtil.getBrandPrimaryColor());
            }
            View view5 = this.f41475p;
            if (view5 != null) {
                view5.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        EditAddressInfoView.m31118a(EditAddressInfoView.this, view);
                    }
                });
            }
        }
        SodaMapView sodaMapView2 = this.f41460a;
        if (sodaMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView2 = null;
        }
        sodaMapView2.removeTopView();
        SodaMapView sodaMapView3 = this.f41460a;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
        } else {
            sodaMapView = sodaMapView3;
        }
        sodaMapView.setTopViewToCenter(this.f41476q);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            TextView textView = this.f41477r;
            if (textView != null) {
                textView.setText(ResourceHelper.getString(R.string.FoodC_toast_Unable_to_dwCf));
                return;
            }
            return;
        }
        TextView textView2 = this.f41477r;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31118a(EditAddressInfoView editAddressInfoView, View view) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        if (((Contract.AbsEditAddressInfoPresent) editAddressInfoView.getPresenter()).isAddressClickable() && !ClickUtils.isFastClick()) {
            Context context = editAddressInfoView.getContext();
            View view2 = editAddressInfoView.f41467h;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backView");
                view2 = null;
            }
            KeyboardUtils.hideSoftInput(context, view2);
            ((Contract.AbsEditAddressInfoPresent) editAddressInfoView.getPresenter()).onAddressClick();
        }
    }

    public void pinLoading() {
        SodaMapView sodaMapView = this.f41460a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.setEnabled(false);
        AddressAnimHelper addressAnimHelper = this.f41470k;
        if (addressAnimHelper != null) {
            addressAnimHelper.pinLoading();
        }
    }

    public void hidePinLoading(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "barStr");
        SodaMapView sodaMapView = this.f41460a;
        SodaMapView sodaMapView2 = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        boolean z2 = true;
        sodaMapView.setEnabled(true);
        SodaMapView sodaMapView3 = this.f41460a;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
        } else {
            sodaMapView2 = sodaMapView3;
        }
        sodaMapView2.setMapGestureEnable(z);
        if (str.length() <= 0) {
            z2 = false;
        }
        if (z2) {
            m31124a(str);
        }
        AddressAnimHelper addressAnimHelper = this.f41470k;
        if (addressAnimHelper != null) {
            addressAnimHelper.hideLoading();
        }
    }

    public void onCreate() {
        super.onCreate();
        Context context = getContext();
        if (context != null) {
            AndroidBug5497Workaround instance = AndroidBug5497Workaround.getInstance((Activity) context);
            ScopeContext scopeContext = getScopeContext();
            AddressCardRecyclerView addressCardRecyclerView = this.f41462c;
            ConstraintLayout constraintLayout = null;
            if (addressCardRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                addressCardRecyclerView = null;
            }
            instance.assistComponent(scopeContext, addressCardRecyclerView);
            instance.setOnSoftInputVisibilityListener(getScopeContext(), new AndroidBug5497Workaround.OnSoftInputVisibilityListener() {
                public final void onVisibility(boolean z) {
                    EditAddressInfoView.m31122a(EditAddressInfoView.this, z);
                }
            });
            SodaMapView sodaMapView = this.f41460a;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
                sodaMapView = null;
            }
            sodaMapView.removeAllElement();
            AddressCardRecyclerView addressCardRecyclerView2 = this.f41462c;
            if (addressCardRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                addressCardRecyclerView2 = null;
            }
            addressCardRecyclerView2.post(new Runnable() {
                public final void run() {
                    EditAddressInfoView.m31127b(EditAddressInfoView.this);
                }
            });
            m31129c();
            ConstraintLayout constraintLayout2 = this.f41463d;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            } else {
                constraintLayout = constraintLayout2;
            }
            constraintLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.f41459B);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31122a(EditAddressInfoView editAddressInfoView, boolean z) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        if (!z) {
            AddressCardRecyclerView addressCardRecyclerView = editAddressInfoView.f41462c;
            if (addressCardRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                addressCardRecyclerView = null;
            }
            addressCardRecyclerView.post(new Runnable() {
                public final void run() {
                    EditAddressInfoView.m31117a(EditAddressInfoView.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31117a(EditAddressInfoView editAddressInfoView) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        editAddressInfoView.m31141j();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31127b(EditAddressInfoView editAddressInfoView) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        AddressCardRecyclerView addressCardRecyclerView = editAddressInfoView.f41462c;
        if (addressCardRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            addressCardRecyclerView = null;
        }
        editAddressInfoView.setInitHeight(addressCardRecyclerView.getHeight());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m31131c(EditAddressInfoView editAddressInfoView) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        ConstraintLayout constraintLayout = editAddressInfoView.f41463d;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            constraintLayout = null;
        }
        if (!constraintLayout.isFocused()) {
            Context context = editAddressInfoView.getContext();
            if (context != null) {
                boolean isSoftInputVisible = KeyboardUtils.isSoftInputVisible((Activity) context, DisplayUtils.getScreenHeight(editAddressInfoView.getContext()) / 4);
                Object object = editAddressInfoView.getScopeContext().getObject(Const.PageParams.ADDRESS_KEYBOARD_ENTITY);
                AddressKeyboardStatus addressKeyboardStatus = object instanceof AddressKeyboardStatus ? (AddressKeyboardStatus) object : null;
                if (addressKeyboardStatus != null) {
                    if (!isSoftInputVisible) {
                        if (AutoShowType.Default == addressKeyboardStatus.getShowType()) {
                            ConstraintLayout constraintLayout3 = editAddressInfoView.f41463d;
                            if (constraintLayout3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
                            } else {
                                constraintLayout2 = constraintLayout3;
                            }
                            constraintLayout2.requestFocus();
                        } else if (addressKeyboardStatus.getAlreadyLoaded()) {
                            ConstraintLayout constraintLayout4 = editAddressInfoView.f41463d;
                            if (constraintLayout4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
                            } else {
                                constraintLayout2 = constraintLayout4;
                            }
                            constraintLayout2.requestFocus();
                        }
                    } else if (AutoShowType.Default != addressKeyboardStatus.getShowType() && !addressKeyboardStatus.getAlreadyLoaded()) {
                        addressKeyboardStatus.setAlreadyLoaded(true);
                    }
                    editAddressInfoView.getScopeContext().attach(Const.PageParams.ADDRESS_KEYBOARD_ENTITY, addressKeyboardStatus);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SodaMapView sodaMapView = this.f41460a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onResume();
    }

    public void onPause() {
        super.onPause();
        SodaMapView sodaMapView = this.f41460a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        SodaMapView sodaMapView = this.f41460a;
        ConstraintLayout constraintLayout = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onDestroy();
        SodaMapView sodaMapView2 = this.f41460a;
        if (sodaMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView2 = null;
        }
        sodaMapView2.removeTopView();
        SodaMapView sodaMapView3 = this.f41460a;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView3 = null;
        }
        if (sodaMapView3.getMapImpl() != null) {
            SodaMapView sodaMapView4 = this.f41460a;
            if (sodaMapView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
                sodaMapView4 = null;
            }
            sodaMapView4.getMapImpl().removeOnCameraChangeListener(this.f41458A);
            SodaMapView sodaMapView5 = this.f41460a;
            if (sodaMapView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
                sodaMapView5 = null;
            }
            sodaMapView5.getMapImpl().removeOnMapGestureListener(this.f41485z);
        }
        ConstraintLayout constraintLayout2 = this.f41463d;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        } else {
            constraintLayout = constraintLayout2;
        }
        constraintLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.f41459B);
    }

    /* renamed from: b */
    private final void m31125b() {
        this.f41476q = null;
        this.f41473n = null;
        this.f41475p = null;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new EditAddressInfoView$initItemBinders$1(this, getScopeContext()));
        registerBinder(new EditAddressInfoView$initItemBinders$2(this, getScopeContext()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31112a(int i) {
        int i2;
        if (this.f41472m && (i2 = this.f41483x) > 0 && i != i2) {
            AddressCardRecyclerView addressCardRecyclerView = this.f41462c;
            AddressCardRecyclerView addressCardRecyclerView2 = null;
            if (addressCardRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                addressCardRecyclerView = null;
            }
            ViewGroup.LayoutParams layoutParams = addressCardRecyclerView.getLayoutParams();
            layoutParams.height = i;
            AddressCardRecyclerView addressCardRecyclerView3 = this.f41462c;
            if (addressCardRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                addressCardRecyclerView2 = addressCardRecyclerView3;
            }
            addressCardRecyclerView2.post(new Runnable(layoutParams) {
                public final /* synthetic */ ViewGroup.LayoutParams f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    EditAddressInfoView.m31119a(EditAddressInfoView.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31119a(EditAddressInfoView editAddressInfoView, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        AddressCardRecyclerView addressCardRecyclerView = editAddressInfoView.f41462c;
        if (addressCardRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            addressCardRecyclerView = null;
        }
        addressCardRecyclerView.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        AddressCardRecyclerView addressCardRecyclerView = this.f41462c;
        AddressCardRecyclerView addressCardRecyclerView2 = null;
        if (addressCardRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            addressCardRecyclerView = null;
        }
        addressCardRecyclerView.addOnScrollListener(new EditAddressInfoView$generateNovaRecyclerView$1(this));
        AddressCardRecyclerView addressCardRecyclerView3 = this.f41462c;
        if (addressCardRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            addressCardRecyclerView2 = addressCardRecyclerView3;
        }
        return addressCardRecyclerView2;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_edit_address_container, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        setRootView(inflate);
        m31113a(inflate);
        m31139h();
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…   initConfirmBtn()\n    }");
        return inflate;
    }

    /* renamed from: a */
    private final void m31113a(View view) {
        View findViewById = view.findViewById(R.id.customer_address_edit_recyclerview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.c…ddress_edit_recyclerview)");
        this.f41462c = (AddressCardRecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.root_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.root_container)");
        this.f41463d = (ConstraintLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.customer_address_edit_top_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.c…er_address_edit_top_mask)");
        this.f41464e = findViewById3;
        View findViewById4 = view.findViewById(R.id.customer_address_edit_alpha_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.c…_address_edit_alpha_mask)");
        this.f41465f = findViewById4;
        View findViewById5 = view.findViewById(R.id.customer_soda_map_view);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.customer_soda_map_view)");
        this.f41460a = (SodaMapView) findViewById5;
        View findViewById6 = view.findViewById(R.id.customer_custom_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.customer_custom_confirm)");
        this.f41466g = (RFMainButton) findViewById6;
        View findViewById7 = view.findViewById(R.id.customer_iv_back);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.customer_iv_back)");
        this.f41467h = findViewById7;
        View findViewById8 = view.findViewById(R.id.tv_drag);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "root.findViewById(R.id.tv_drag)");
        this.f41478s = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.iv_reset);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "root.findViewById(R.id.iv_reset)");
        this.f41479t = findViewById9;
        TextView textView = this.f41478s;
        AddressCardRecyclerView addressCardRecyclerView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditAddressInfoView.m31128b(EditAddressInfoView.this, view);
            }
        });
        View view2 = this.f41479t;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetView");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditAddressInfoView.m31132c(EditAddressInfoView.this, view);
            }
        });
        View view3 = this.f41467h;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backView");
            view3 = null;
        }
        view3.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditAddressInfoView.m31134d(EditAddressInfoView.this, view);
            }
        });
        AddressCardRecyclerView addressCardRecyclerView2 = this.f41462c;
        if (addressCardRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            addressCardRecyclerView = addressCardRecyclerView2;
        }
        addressCardRecyclerView.setmExpendListener(new EditAddressInfoView$initView$4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31128b(EditAddressInfoView editAddressInfoView, View view) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        if (editAddressInfoView.f41472m) {
            editAddressInfoView.f41472m = false;
            editAddressInfoView.m31137f();
            return;
        }
        editAddressInfoView.f41472m = true;
        editAddressInfoView.m31126b(editAddressInfoView.m31133d());
        AddressOmegaHelper.traceLocationSw(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m31132c(EditAddressInfoView editAddressInfoView, View view) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        ((Contract.AbsEditAddressInfoPresent) editAddressInfoView.getPresenter()).resetModel();
        AddressOmegaHelper.traceLocationRefreshCk();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m31134d(EditAddressInfoView editAddressInfoView, View view) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        KeyboardUtils.hideSoftInput(editAddressInfoView.getContext(), view);
        ((Contract.AbsEditAddressInfoPresent) editAddressInfoView.getPresenter()).onFinish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31115a(LatLng latLng, int i) {
        BestViewModel bestViewModel = new BestViewModel();
        SodaMapView sodaMapView = this.f41460a;
        SodaMapView sodaMapView2 = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        Padding padding = sodaMapView.getMapImpl().getDidiCommonMap().getPadding();
        bestViewModel.mPadding = new Padding(padding.left, padding.top, padding.right, i + ResourceHelper.getDimensionPixelSize(R.dimen.customer_148px));
        bestViewModel.zoomCenter = latLng;
        bestViewModel.mIncludes.add(latLng);
        SodaMapView sodaMapView3 = this.f41460a;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
        } else {
            sodaMapView2 = sodaMapView3;
        }
        sodaMapView2.centerBestZoomViewNoAnimation(bestViewModel);
    }

    /* renamed from: c */
    private final void m31129c() {
        SodaMapView sodaMapView = this.f41460a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.getSodaMapAsync(new OnMapReadyCallBack() {
            public final void onMapReady(Map map) {
                EditAddressInfoView.m31120a(EditAddressInfoView.this, map);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31120a(EditAddressInfoView editAddressInfoView, Map map) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        SodaMapView sodaMapView = editAddressInfoView.f41460a;
        SodaMapView sodaMapView2 = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        if (sodaMapView.getMapImpl() != null) {
            SodaMapView sodaMapView3 = editAddressInfoView.f41460a;
            if (sodaMapView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
                sodaMapView3 = null;
            }
            sodaMapView3.getMapImpl().addOnCameraChangeListener(editAddressInfoView.f41458A);
            SodaMapView sodaMapView4 = editAddressInfoView.f41460a;
            if (sodaMapView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            } else {
                sodaMapView2 = sodaMapView4;
            }
            sodaMapView2.getMapImpl().addOnMapGestureListener(editAddressInfoView.f41485z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final LatLng m31133d() {
        SodaMapView sodaMapView = this.f41460a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        LatLng mapCenterLatLng = sodaMapView.getMapCenterLatLng();
        if (mapCenterLatLng == null) {
            EditAddressModel editAddressModel = this.f41482w;
            double d = 0.0d;
            double lat = editAddressModel == null ? 0.0d : editAddressModel.getLat();
            EditAddressModel editAddressModel2 = this.f41482w;
            if (editAddressModel2 != null) {
                d = editAddressModel2.getLng();
            }
            mapCenterLatLng = new LatLng(lat, d);
        }
        return mapCenterLatLng;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31114a(LatLng latLng) {
        AddressAnimHelper addressAnimHelper = this.f41470k;
        boolean z = true;
        if (addressAnimHelper == null || !addressAnimHelper.isLoading()) {
            z = false;
        }
        if (!z) {
            SodaMapView sodaMapView = this.f41460a;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
                sodaMapView = null;
            }
            sodaMapView.setMapGestureEnable(false);
            ((Contract.AbsEditAddressInfoPresent) getPresenter()).getReversePoi(latLng.latitude, latLng.longitude);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m31126b(LatLng latLng) {
        TextView textView = null;
        KeyboardUtils.hideSoftInput(getContext(), (View) null);
        AddressAnimHelper addressAnimHelper = this.f41470k;
        if (addressAnimHelper != null) {
            AddressCardRecyclerView addressCardRecyclerView = this.f41462c;
            if (addressCardRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                addressCardRecyclerView = null;
            }
            View view = addressCardRecyclerView;
            AddressCardRecyclerView addressCardRecyclerView2 = this.f41462c;
            if (addressCardRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                addressCardRecyclerView2 = null;
            }
            addressAnimHelper.addressUpORDown(view, (float) addressCardRecyclerView2.getHeight(), (float) this.f41483x, new EditAddressInfoView$downAddress$1(this, latLng), new EditAddressInfoView$downAddress$2(this));
        }
        View view2 = this.f41479t;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetView");
            view2 = null;
        }
        view2.setVisibility(0);
        TextView textView2 = this.f41478s;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragView");
        } else {
            textView = textView2;
        }
        textView.setText(ResourceHelper.getString(R.string.FoodC_location_Opposition_nxHT));
        m31138g();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m31135e() {
        LinearSmoothScroller a = m31110a();
        if (a != null) {
            AddressCardRecyclerView addressCardRecyclerView = this.f41462c;
            if (addressCardRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                addressCardRecyclerView = null;
            }
            RecyclerView.LayoutManager layoutManager = addressCardRecyclerView.getLayoutManager();
            if (layoutManager != null) {
                a.setTargetPosition(0);
                ((LinearLayoutManager) layoutManager).startSmoothScroll(a);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m31130c(LatLng latLng) {
        AddressAnimHelper addressAnimHelper = this.f41470k;
        TextView textView = null;
        if (addressAnimHelper != null) {
            AddressCardRecyclerView addressCardRecyclerView = this.f41462c;
            if (addressCardRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                addressCardRecyclerView = null;
            }
            View view = addressCardRecyclerView;
            AddressCardRecyclerView addressCardRecyclerView2 = this.f41462c;
            if (addressCardRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                addressCardRecyclerView2 = null;
            }
            addressAnimHelper.addressUpORDown(view, (float) addressCardRecyclerView2.getHeight(), (float) this.f41483x, new EditAddressInfoView$dragDownAddress$1(this, latLng), new EditAddressInfoView$dragDownAddress$2(this));
        }
        View view2 = this.f41479t;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resetView");
            view2 = null;
        }
        view2.setVisibility(0);
        TextView textView2 = this.f41478s;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragView");
        } else {
            textView = textView2;
        }
        textView.setText(ResourceHelper.getString(R.string.FoodC_location_Opposition_nxHT));
        m31138g();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m31137f() {
        SodaMapView sodaMapView = this.f41460a;
        TextView textView = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        LatLng mapCenterLatLng = sodaMapView.getMapCenterLatLng();
        if (mapCenterLatLng != null) {
            AddressAnimHelper addressAnimHelper = this.f41470k;
            if (addressAnimHelper != null) {
                AddressCardRecyclerView addressCardRecyclerView = this.f41462c;
                if (addressCardRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    addressCardRecyclerView = null;
                }
                View view = addressCardRecyclerView;
                AddressCardRecyclerView addressCardRecyclerView2 = this.f41462c;
                if (addressCardRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    addressCardRecyclerView2 = null;
                }
                addressAnimHelper.addressUpORDown(view, (float) addressCardRecyclerView2.getHeight(), (float) this.f41484y, new EditAddressInfoView$upAddress$1(this, mapCenterLatLng), new EditAddressInfoView$upAddress$2(this));
            }
            View view2 = this.f41479t;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetView");
                view2 = null;
            }
            view2.setVisibility(8);
            TextView textView2 = this.f41478s;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dragView");
            } else {
                textView = textView2;
            }
            textView.setText(ResourceHelper.getString(R.string.FoodC_location_Select_location_Zsea));
            m31138g();
        }
    }

    /* renamed from: g */
    private final void m31138g() {
        EditAddressModel editAddressModel;
        SodaMapView sodaMapView = this.f41460a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        LatLng mapCenterLatLng = sodaMapView.getMapCenterLatLng();
        if (mapCenterLatLng != null && (editAddressModel = this.f41482w) != null) {
            editAddressModel.setExpendMap(this.f41472m);
            editAddressModel.setLat(mapCenterLatLng.latitude);
            editAddressModel.setLng(mapCenterLatLng.longitude);
            editAddressModel.setAddressDisplayName(editAddressModel.getAddressDisplayName());
            ((Contract.AbsEditAddressInfoPresent) getPresenter()).updateByModel(editAddressModel);
        }
    }

    /* renamed from: h */
    private final void m31139h() {
        RFMainButton rFMainButton = this.f41466g;
        RFMainButton rFMainButton2 = null;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            rFMainButton = null;
        }
        rFMainButton.setText(getString(R.string.customer_dialog_confirm));
        RFMainButton rFMainButton3 = this.f41466g;
        if (rFMainButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        } else {
            rFMainButton2 = rFMainButton3;
        }
        rFMainButton2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditAddressInfoView.m31136e(EditAddressInfoView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final void m31136e(EditAddressInfoView editAddressInfoView, View view) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        EditAddressModel editAddressModel = editAddressInfoView.f41482w;
        boolean z = false;
        if (editAddressModel != null && !editAddressModel.isValid()) {
            z = true;
        }
        if (!z) {
            KeyboardUtils.hideSoftInput(editAddressInfoView.getContext(), view);
            ((Contract.AbsEditAddressInfoPresent) editAddressInfoView.getPresenter()).traceConfirmClick();
            if (((Contract.AbsEditAddressInfoPresent) editAddressInfoView.getPresenter()).isContactShow()) {
                ContactEntity contactEntity = (ContactEntity) editAddressInfoView.f41468i.invoke();
                if (contactEntity == null) {
                    editAddressInfoView.m31140i();
                    return;
                }
                editAddressInfoView.m31123a(contactEntity);
            }
            Function0<EditAddressModel> function0 = editAddressInfoView.f41469j;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saveAddressAction");
                function0 = null;
            }
            editAddressInfoView.m31116a(function0.invoke());
        }
    }

    /* renamed from: i */
    private final void m31140i() {
        AddressCardRecyclerView addressCardRecyclerView = this.f41462c;
        AddressCardRecyclerView addressCardRecyclerView2 = null;
        if (addressCardRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            addressCardRecyclerView = null;
        }
        RecyclerView.Adapter adapter = addressCardRecyclerView.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount() - 1;
            AddressCardRecyclerView addressCardRecyclerView3 = this.f41462c;
            if (addressCardRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                addressCardRecyclerView2 = addressCardRecyclerView3;
            }
            addressCardRecyclerView2.scrollToPosition(itemCount);
        }
    }

    /* renamed from: a */
    private final void m31123a(ContactEntity contactEntity) {
        ((Contract.AbsEditAddressInfoPresent) getPresenter()).saveContact(contactEntity);
    }

    /* renamed from: a */
    private final void m31116a(EditAddressModel editAddressModel) {
        RFMainButton rFMainButton = this.f41466g;
        RFMainButton rFMainButton2 = null;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            rFMainButton = null;
        }
        if (!rFMainButton.isLoading()) {
            RFMainButton rFMainButton3 = this.f41466g;
            if (rFMainButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            } else {
                rFMainButton2 = rFMainButton3;
            }
            rFMainButton2.setLoading(true);
            ((Contract.AbsEditAddressInfoPresent) getPresenter()).saveAddress(editAddressModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public final void m31141j() {
        if (!this.f41472m) {
            AddressCardRecyclerView addressCardRecyclerView = this.f41462c;
            AddressCardRecyclerView addressCardRecyclerView2 = null;
            if (addressCardRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                addressCardRecyclerView = null;
            }
            RecyclerView.LayoutManager layoutManager = addressCardRecyclerView.getLayoutManager();
            if (layoutManager != null) {
                int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition == 0) {
                    AddressCardRecyclerView addressCardRecyclerView3 = this.f41462c;
                    if (addressCardRecyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        addressCardRecyclerView2 = addressCardRecyclerView3;
                    }
                    View childAt = addressCardRecyclerView2.getChildAt(findFirstVisibleItemPosition);
                    Intrinsics.checkNotNullExpressionValue(childAt, "recyclerView.getChildAt(firstVisiblePos)");
                    Rect rect = new Rect();
                    childAt.getLocalVisibleRect(rect);
                    m31111a(((float) rect.height()) / ((float) childAt.getHeight()));
                    return;
                }
                m31111a(0.0f);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
        m31111a(1.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31111a(float f) {
        View view = this.f41464e;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topMask");
            view = null;
        }
        boolean z = true;
        float f2 = ((float) 1) - f;
        view.setAlpha(f2);
        View view3 = this.f41465f;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topAlphaMask");
            view3 = null;
        }
        view3.setAlpha(f2);
        View view4 = this.f41464e;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topMask");
            view4 = null;
        }
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        view4.setClickable(i == 0);
        View view5 = this.f41465f;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topAlphaMask");
        } else {
            view2 = view5;
        }
        if (i != 0) {
            z = false;
        }
        view2.setClickable(z);
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lcom/didi/soda/address/edit/component/EditAddressInfoView$LinearTopSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mCustomerSpeedRatio", "", "calculateSpeedPerPixel", "displayMetrics", "Landroid/util/DisplayMetrics;", "getVerticalSnapPreference", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: EditAddressInfoView.kt */
    private static final class LinearTopSmoothScroller extends LinearSmoothScroller {
        private final float mCustomerSpeedRatio = 0.5f;

        /* access modifiers changed from: protected */
        public int getVerticalSnapPreference() {
            return -1;
        }

        public LinearTopSmoothScroller(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return this.mCustomerSpeedRatio * super.calculateSpeedPerPixel(displayMetrics);
        }
    }
}
