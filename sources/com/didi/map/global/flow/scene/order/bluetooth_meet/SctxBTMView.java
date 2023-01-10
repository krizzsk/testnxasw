package com.didi.map.global.flow.scene.order.bluetooth_meet;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMAction;
import com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMState;
import com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel;
import com.didi.map.global.flow.scene.order.bluetooth_meet.model.IBTMHandler;
import com.didi.map.global.flow.scene.order.bluetooth_meet.model.ISctxBTMController;
import com.didi.map.global.flow.scene.order.bluetooth_meet.model.SctxBTMDriverParam;
import com.didi.map.global.flow.scene.order.bluetooth_meet.model.SctxBTMParam;
import com.didi.map.global.flow.scene.order.bluetooth_meet.view.BTMArrowView;
import com.didi.map.global.flow.scene.order.bluetooth_meet.view.BTMDriverCardView;
import com.didi.map.global.flow.scene.order.bluetooth_meet.view.BTMGradientTextView;
import com.didi.map.global.flow.scene.order.bluetooth_meet.view.BTMGradientView;
import com.didi.map.global.flow.scene.order.bluetooth_meet.view.BTMRippleView;
import com.didi.map.global.flow.scene.order.bluetooth_meet.view.BTMTripleRippleView;
import com.didiglobal.font.DiDiTypeface;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0001oB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u00105\u001a\u000206H\u0002J\u001e\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001082\u0006\u00109\u001a\u00020:H\u0002J \u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u000fH\u0002JN\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001082\u0006\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u000fH\u0002J\u0010\u0010G\u001a\u0002062\u0006\u0010H\u001a\u00020IH\u0002J+\u0010J\u001a\u0002062\u0006\u0010K\u001a\u00020\u000f2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020PH\u0016¢\u0006\u0002\u0010QJ\"\u0010R\u001a\u0002062\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\u000f2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u0018\u0010V\u001a\u0002062\u0006\u0010W\u001a\u00020X2\u0006\u00109\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u0002062\u0006\u0010Z\u001a\u00020[H\u0002J\b\u0010\\\u001a\u000206H\u0002J\b\u0010]\u001a\u000206H\u0002J\b\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u000206H\u0002J\b\u0010a\u001a\u000206H\u0014J\b\u0010b\u001a\u000206H\u0002J\b\u0010c\u001a\u000206H\u0002J\b\u0010d\u001a\u000206H\u0002J\b\u0010e\u001a\u000206H\u0002J\b\u0010f\u001a\u000206H\u0002J\b\u0010g\u001a\u000206H\u0002J\b\u0010h\u001a\u000206H\u0002J\b\u0010i\u001a\u000206H\u0002J\u0010\u0010j\u001a\u0002062\u0006\u0010k\u001a\u00020_H\u0002J\u0010\u0010l\u001a\u0002062\u0006\u0010m\u001a\u00020_H\u0016J\b\u0010n\u001a\u000206H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006p"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/SctxBTMView;", "Landroid/widget/FrameLayout;", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/ISctxBTMController;", "context", "Landroidx/fragment/app/FragmentActivity;", "param", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMParam;", "(Landroidx/fragment/app/FragmentActivity;Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMParam;)V", "arrowImg", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/view/BTMArrowView;", "autoCloseAnimator", "Landroid/animation/ValueAnimator;", "autoCloseTxt", "Landroid/widget/TextView;", "bgInitWrongDirectionFrom", "", "bgInitWrongDirectionTo", "bgRightDirectionFrom", "bgRightDirectionTo", "bgTotalWrongDirectionFrom", "bgTotalWrongDirectionTo", "bgView", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/view/BTMGradientView;", "bluetoothIcon", "Landroid/widget/ImageView;", "closeBtn", "directionTxt", "distanceContainer", "Landroid/view/View;", "distanceTxt", "driverCard", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/view/BTMDriverCardView;", "driverContainer", "driverLicensePlateNumber", "driverManufacture", "infoTxt", "msgBtn", "msgBtnDot", "getParam", "()Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMParam;", "permissionGuilde", "singleRippleView", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/view/BTMRippleView;", "statusTxt", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/view/BTMGradientTextView;", "telephoneBtn", "topTxt", "tripleRippleView", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/view/BTMTripleRippleView;", "tryAgainBtn", "viewModel", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMViewModel;", "wrongDirectionTxt", "bindView", "", "getBgGradientPair", "Lkotlin/Pair;", "angle", "", "getColorGradient", "fraction", "from", "to", "getGradientPairByAngle", "curAngle", "fromAngle", "toAngle", "topFrom", "bottomFrom", "topTo", "bottomTo", "handleAction", "action", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMAction;", "handleBluetoothPermissionRequestResult", "requestCode", "permissions", "", "", "grantedResult", "", "(I[Ljava/lang/String;[I)V", "handleBluetoothPermissionSettingBack", "resultCode", "data", "Landroid/content/Intent;", "handleDriverNavInfo", "distance", "", "handleUIStatus", "status", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMState;", "initAction", "initView", "onBackPress", "", "onBluetoothTurnOff", "onDetachedFromWindow", "onInitDirection", "onNoPermission", "onPairFailure", "onPaired", "onPairing", "onPassengerOnboard", "onRightDirection", "onVeryNear", "onWrongDirection", "total", "setNewIMMsgCome", "show", "setPassengerOnboard", "Companion", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SctxBTMView.kt */
public final class SctxBTMView extends FrameLayout implements ISctxBTMController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: G */
    public static final int f28972G = 171;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public static final int f28973H = 177;

    /* renamed from: A */
    private final int f28974A;

    /* renamed from: B */
    private final int f28975B;

    /* renamed from: C */
    private final int f28976C;

    /* renamed from: D */
    private final int f28977D;

    /* renamed from: E */
    private final int f28978E;

    /* renamed from: F */
    private final int f28979F;

    /* renamed from: a */
    private final SctxBTMParam f28980a;

    /* renamed from: b */
    private final BTMViewModel f28981b;

    /* renamed from: c */
    private TextView f28982c;

    /* renamed from: d */
    private ImageView f28983d;

    /* renamed from: e */
    private BTMGradientTextView f28984e;

    /* renamed from: f */
    private TextView f28985f;

    /* renamed from: g */
    private TextView f28986g;

    /* renamed from: h */
    private TextView f28987h;

    /* renamed from: i */
    private ImageView f28988i;

    /* renamed from: j */
    private ImageView f28989j;

    /* renamed from: k */
    private View f28990k;

    /* renamed from: l */
    private View f28991l;

    /* renamed from: m */
    private BTMArrowView f28992m;

    /* renamed from: n */
    private TextView f28993n;

    /* renamed from: o */
    private View f28994o;

    /* renamed from: p */
    private TextView f28995p;

    /* renamed from: q */
    private TextView f28996q;

    /* renamed from: r */
    private View f28997r;

    /* renamed from: s */
    private TextView f28998s;

    /* renamed from: t */
    private TextView f28999t;

    /* renamed from: u */
    private BTMGradientView f29000u;

    /* renamed from: v */
    private BTMDriverCardView f29001v;

    /* renamed from: w */
    private TextView f29002w;

    /* renamed from: x */
    private ValueAnimator f29003x;

    /* renamed from: y */
    private BTMRippleView f29004y;

    /* renamed from: z */
    private BTMTripleRippleView f29005z;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SctxBTMView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BTMAction.values().length];
            iArr[BTMAction.ACTION_QUIT.ordinal()] = 1;
            iArr[BTMAction.ACTION_PAUSE_AUTO_CLOSE_COUNTDOWN.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BTMState.values().length];
            iArr2[BTMState.PAIRING.ordinal()] = 1;
            iArr2[BTMState.PAIRED.ordinal()] = 2;
            iArr2[BTMState.NO_PERMISSION.ordinal()] = 3;
            iArr2[BTMState.BLUETOOTH_TURNOFF.ordinal()] = 4;
            iArr2[BTMState.PAIRING_FAILURE.ordinal()] = 5;
            iArr2[BTMState.INIT_DIRECTION.ordinal()] = 6;
            iArr2[BTMState.VERY_NEAR.ordinal()] = 7;
            iArr2[BTMState.ON_BOARD.ordinal()] = 8;
            iArr2[BTMState.RIGHT_DIRECTION.ordinal()] = 9;
            iArr2[BTMState.WRONG_DIRECTION.ordinal()] = 10;
            iArr2[BTMState.WRONG_DIRECTION_TOTALLY.ordinal()] = 11;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22570a(View view) {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SctxBTMView(androidx.fragment.app.FragmentActivity r3, com.didi.map.global.flow.scene.order.bluetooth_meet.model.SctxBTMParam r4) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "param"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = r3
            android.content.Context r0 = (android.content.Context) r0
            r2.<init>(r0)
            r2.f28980a = r4
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel r1 = new com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel
            r1.<init>(r3, r4)
            r2.f28981b = r1
            android.content.res.Resources r4 = r3.getResources()
            r1 = 2131099821(0x7f0600ad, float:1.7812006E38)
            int r4 = r4.getColor(r1)
            r2.f28974A = r4
            android.content.res.Resources r4 = r3.getResources()
            r1 = 2131099822(0x7f0600ae, float:1.7812008E38)
            int r4 = r4.getColor(r1)
            r2.f28975B = r4
            android.content.res.Resources r4 = r3.getResources()
            r1 = 2131099819(0x7f0600ab, float:1.7812002E38)
            int r4 = r4.getColor(r1)
            r2.f28976C = r4
            android.content.res.Resources r4 = r3.getResources()
            r1 = 2131099820(0x7f0600ac, float:1.7812004E38)
            int r4 = r4.getColor(r1)
            r2.f28977D = r4
            android.content.res.Resources r4 = r3.getResources()
            r1 = 2131099823(0x7f0600af, float:1.781201E38)
            int r4 = r4.getColor(r1)
            r2.f28978E = r4
            android.content.res.Resources r3 = r3.getResources()
            r4 = 2131099824(0x7f0600b0, float:1.7812012E38)
            int r3 = r3.getColor(r4)
            r2.f28979F = r3
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
            r4 = r2
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r0 = 2131626275(0x7f0e0923, float:1.8879782E38)
            r1 = 1
            r3.inflate(r0, r4, r1)
            r2.m22568a()
            r2.m22579b()
            r2.m22581c()
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel r3 = r2.f28981b
            com.didi.map.global.flow.scene.order.bluetooth_meet.-$$Lambda$SctxBTMView$cTlb9pxUcG3Z4qmNm9x_4w2Io_4 r4 = new com.didi.map.global.flow.scene.order.bluetooth_meet.-$$Lambda$SctxBTMView$cTlb9pxUcG3Z4qmNm9x_4w2Io_4
            r4.<init>()
            r3.bindUIStateObserver(r4)
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel r3 = r2.f28981b
            com.didi.map.global.flow.scene.order.bluetooth_meet.-$$Lambda$SctxBTMView$yYHOihghnWoXtiOr5cGHimUGBcQ r4 = new com.didi.map.global.flow.scene.order.bluetooth_meet.-$$Lambda$SctxBTMView$yYHOihghnWoXtiOr5cGHimUGBcQ
            r4.<init>()
            r3.bindActionObserver(r4)
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel r3 = r2.f28981b
            com.didi.map.global.flow.scene.order.bluetooth_meet.-$$Lambda$SctxBTMView$2Pwb2OryvVOFlIX6Hs_hU41rycA r4 = new com.didi.map.global.flow.scene.order.bluetooth_meet.-$$Lambda$SctxBTMView$2Pwb2OryvVOFlIX6Hs_hU41rycA
            r4.<init>()
            r3.bindDriverNavInfoObserver(r4)
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMViewModel r3 = r2.f28981b
            r3.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView.<init>(androidx.fragment.app.FragmentActivity, com.didi.map.global.flow.scene.order.bluetooth_meet.model.SctxBTMParam):void");
    }

    public final SctxBTMParam getParam() {
        return this.f28980a;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/SctxBTMView$Companion;", "", "()V", "BLE_REQUEST_CODE", "", "getBLE_REQUEST_CODE", "()I", "BTM_SETTING_REQUEST_CODE", "getBTM_SETTING_REQUEST_CODE", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SctxBTMView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getBLE_REQUEST_CODE() {
            return SctxBTMView.f28972G;
        }

        public final int getBTM_SETTING_REQUEST_CODE() {
            return SctxBTMView.f28973H;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22574a(SctxBTMView sctxBTMView, BTMState bTMState) {
        Intrinsics.checkNotNullParameter(sctxBTMView, "this$0");
        Intrinsics.checkNotNullExpressionValue(bTMState, "it");
        sctxBTMView.m22577a(bTMState);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22573a(SctxBTMView sctxBTMView, BTMAction bTMAction) {
        Intrinsics.checkNotNullParameter(sctxBTMView, "this$0");
        Intrinsics.checkNotNullExpressionValue(bTMAction, "it");
        sctxBTMView.m22576a(bTMAction);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22575a(SctxBTMView sctxBTMView, Pair pair) {
        Double d;
        Intrinsics.checkNotNullParameter(sctxBTMView, "this$0");
        if (ArraysKt.contains((T[]) new BTMState[]{BTMState.INIT_DIRECTION, BTMState.RIGHT_DIRECTION, BTMState.WRONG_DIRECTION, BTMState.WRONG_DIRECTION_TOTALLY}, sctxBTMView.f28981b.getUiStateLiveData().getValue()) && (d = (Double) pair.getFirst()) != null) {
            double doubleValue = d.doubleValue();
            Double d2 = (Double) pair.getSecond();
            if (d2 != null) {
                sctxBTMView.m22569a(doubleValue, d2.doubleValue());
            }
        }
    }

    /* renamed from: a */
    private final void m22568a() {
        TextView textView = (TextView) findViewById(R.id.top_txt);
        this.f28982c = textView;
        ViewExtKt.setDidiTypeFont(textView, DiDiTypeface.FONT_BOLD);
        this.f28983d = (ImageView) findViewById(R.id.bluetooth_icon);
        BTMGradientTextView bTMGradientTextView = (BTMGradientTextView) findViewById(R.id.status_txt);
        this.f28984e = bTMGradientTextView;
        ViewExtKt.setDidiTypeFont(bTMGradientTextView, DiDiTypeface.FONT_BOLD);
        TextView textView2 = (TextView) findViewById(R.id.try_again);
        this.f28985f = textView2;
        ViewExtKt.setDidiTypeFont(textView2, DiDiTypeface.FONT_BOLD);
        TextView textView3 = (TextView) findViewById(R.id.info_txt);
        this.f28986g = textView3;
        ViewExtKt.setDidiTypeFont(textView3, DiDiTypeface.FONT_REGULAR);
        this.f28987h = (TextView) findViewById(R.id.permission_guide);
        this.f28988i = (ImageView) findViewById(R.id.close_img);
        this.f28989j = (ImageView) findViewById(R.id.telephone_img);
        this.f28990k = findViewById(R.id.btm_msg_img);
        this.f28991l = findViewById(R.id.btm_msg_red_dot);
        this.f29000u = (BTMGradientView) findViewById(R.id.bg_view);
        this.f28992m = (BTMArrowView) findViewById(R.id.arrow_img);
        TextView textView4 = (TextView) findViewById(R.id.wrong_direction_txt);
        this.f28993n = textView4;
        ViewExtKt.setDidiTypeFont(textView4, DiDiTypeface.FONT_REGULAR);
        this.f28994o = findViewById(R.id.driver_container);
        TextView textView5 = (TextView) findViewById(R.id.driver_license_plate_number);
        this.f28995p = textView5;
        ViewExtKt.setDidiTypeFont(textView5, DiDiTypeface.FONT_BOLD);
        this.f28996q = (TextView) findViewById(R.id.driver_manufacture);
        this.f28997r = findViewById(R.id.distance_container);
        TextView textView6 = (TextView) findViewById(R.id.distance_txt);
        this.f28998s = textView6;
        ViewExtKt.setDidiTypeFont(textView6, DiDiTypeface.FONT_BOLD);
        TextView textView7 = (TextView) findViewById(R.id.direction_txt);
        this.f28999t = textView7;
        ViewExtKt.setDidiTypeFont(textView7, DiDiTypeface.FONT_BOLD);
        this.f29001v = (BTMDriverCardView) findViewById(R.id.driver_card);
        this.f29002w = (TextView) findViewById(R.id.auto_close_txt);
        this.f29004y = (BTMRippleView) findViewById(R.id.single_ripple_view);
        this.f29005z = (BTMTripleRippleView) findViewById(R.id.triple_ripple_view);
    }

    /* renamed from: b */
    private final void m22579b() {
        setOnClickListener($$Lambda$SctxBTMView$6VBS5TaeydEHiiHVRGINCk7ofE.INSTANCE);
        TextView textView = this.f28987h;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SctxBTMView.m22572a(SctxBTMView.this, view);
                }
            });
        }
        ImageView imageView = this.f28983d;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SctxBTMView.m22580b(SctxBTMView.this, view);
                }
            });
        }
        TextView textView2 = this.f28985f;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SctxBTMView.m22582c(SctxBTMView.this, view);
                }
            });
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int i = (int) (-ViewExtKt.dp2px(context, 11.0f));
        ViewExtKt.setViewTouchDelegate(this.f28988i, i);
        ImageView imageView2 = this.f28988i;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SctxBTMView.m22584d(SctxBTMView.this, view);
                }
            });
        }
        ViewExtKt.setViewTouchDelegate(this.f28990k, i);
        View view = this.f28990k;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SctxBTMView.m22586e(SctxBTMView.this, view);
                }
            });
        }
        ViewExtKt.setViewTouchDelegate(this.f28989j, i);
        ImageView imageView3 = this.f28989j;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SctxBTMView.m22588f(SctxBTMView.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22572a(SctxBTMView sctxBTMView, View view) {
        Intrinsics.checkNotNullParameter(sctxBTMView, "this$0");
        if (sctxBTMView.f28981b.getUiStateLiveData().getValue() == BTMState.NO_PERMISSION || sctxBTMView.f28981b.getUiStateLiveData().getValue() == BTMState.BLUETOOTH_TURNOFF) {
            sctxBTMView.f28981b.handleNoPermissionOrTurnedOff();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m22580b(SctxBTMView sctxBTMView, View view) {
        Intrinsics.checkNotNullParameter(sctxBTMView, "this$0");
        if (sctxBTMView.f28981b.getUiStateLiveData().getValue() == BTMState.NO_PERMISSION || sctxBTMView.f28981b.getUiStateLiveData().getValue() == BTMState.BLUETOOTH_TURNOFF) {
            sctxBTMView.f28981b.handleNoPermissionOrTurnedOff();
        }
        sctxBTMView.f28981b.onClickBluetoothIcon();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m22582c(SctxBTMView sctxBTMView, View view) {
        Intrinsics.checkNotNullParameter(sctxBTMView, "this$0");
        sctxBTMView.f28981b.tryAgain(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m22584d(SctxBTMView sctxBTMView, View view) {
        Intrinsics.checkNotNullParameter(sctxBTMView, "this$0");
        sctxBTMView.f28981b.handleCloseClick();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final void m22586e(SctxBTMView sctxBTMView, View view) {
        Intrinsics.checkNotNullParameter(sctxBTMView, "this$0");
        IBTMHandler handler = sctxBTMView.getParam().getHandler();
        if (handler != null) {
            handler.onMsgClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static final void m22588f(SctxBTMView sctxBTMView, View view) {
        Intrinsics.checkNotNullParameter(sctxBTMView, "this$0");
        IBTMHandler handler = sctxBTMView.getParam().getHandler();
        if (handler != null) {
            handler.onTelephoneClick();
        }
    }

    /* renamed from: c */
    private final void m22581c() {
        String driverName;
        BTMDriverCardView bTMDriverCardView;
        String carNumber;
        BTMDriverCardView bTMDriverCardView2;
        BTMDriverCardView bTMDriverCardView3;
        BTMDriverCardView bTMDriverCardView4;
        TextView textView = this.f28996q;
        String str = null;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            SctxBTMDriverParam driverInfo = this.f28980a.getDriverInfo();
            sb.append(driverInfo == null ? null : driverInfo.getCarManufacture());
            sb.append('.');
            SctxBTMDriverParam driverInfo2 = this.f28980a.getDriverInfo();
            sb.append(driverInfo2 == null ? null : driverInfo2.getCarColor());
            textView.setText(sb.toString());
        }
        TextView textView2 = this.f28995p;
        if (textView2 != null) {
            SctxBTMDriverParam driverInfo3 = this.f28980a.getDriverInfo();
            textView2.setText(driverInfo3 == null ? null : driverInfo3.getCarNumber());
        }
        SctxBTMDriverParam driverInfo4 = this.f28980a.getDriverInfo();
        String carAvatar = driverInfo4 == null ? null : driverInfo4.getCarAvatar();
        boolean z = true;
        if (carAvatar != null) {
            if (!(carAvatar.length() > 0)) {
                carAvatar = null;
            }
            if (!(carAvatar == null || (bTMDriverCardView4 = this.f29001v) == null)) {
                bTMDriverCardView4.bindCar(carAvatar);
            }
        }
        SctxBTMDriverParam driverInfo5 = this.f28980a.getDriverInfo();
        String driverAvatar = driverInfo5 == null ? null : driverInfo5.getDriverAvatar();
        if (driverAvatar != null) {
            if (driverAvatar.length() <= 0) {
                z = false;
            }
            if (!z) {
                driverAvatar = null;
            }
            if (!(driverAvatar == null || (bTMDriverCardView3 = this.f29001v) == null)) {
                bTMDriverCardView3.bindDirverAvatar(driverAvatar);
            }
        }
        SctxBTMDriverParam driverInfo6 = this.f28980a.getDriverInfo();
        if (!(driverInfo6 == null || (carNumber = driverInfo6.getCarNumber()) == null || (bTMDriverCardView2 = this.f29001v) == null)) {
            bTMDriverCardView2.setLicensePlateNumber(carNumber);
        }
        StringBuilder sb2 = new StringBuilder();
        SctxBTMDriverParam driverInfo7 = this.f28980a.getDriverInfo();
        sb2.append(driverInfo7 == null ? null : driverInfo7.getCarManufacture());
        sb2.append('.');
        SctxBTMDriverParam driverInfo8 = this.f28980a.getDriverInfo();
        if (driverInfo8 != null) {
            str = driverInfo8.getCarColor();
        }
        sb2.append(str);
        String sb3 = sb2.toString();
        BTMDriverCardView bTMDriverCardView5 = this.f29001v;
        if (bTMDriverCardView5 != null) {
            bTMDriverCardView5.setManufactor(sb3);
        }
        SctxBTMDriverParam driverInfo9 = this.f28980a.getDriverInfo();
        if (driverInfo9 != null && (driverName = driverInfo9.getDriverName()) != null && (bTMDriverCardView = this.f29001v) != null) {
            bTMDriverCardView.setDriverName(driverName);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c1, code lost:
        if ((300.0d <= r1 && r1 <= 360.0d) != false) goto L_0x00c3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m22569a(double r20, double r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r22
            android.view.View r3 = r0.f28997r
            if (r3 != 0) goto L_0x0009
            goto L_0x000c
        L_0x0009:
            com.didi.map.global.flow.scene.order.bluetooth_meet.ViewExtKt.show(r3)
        L_0x000c:
            android.widget.TextView r3 = r0.f28999t
            if (r3 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            android.view.View r3 = (android.view.View) r3
            com.didi.map.global.flow.scene.order.bluetooth_meet.ViewExtKt.show(r3)
        L_0x0016:
            android.widget.TextView r3 = r0.f28998s
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r3 != 0) goto L_0x001d
            goto L_0x002d
        L_0x001d:
            r6 = r20
            double r6 = java.lang.Math.max(r6, r4)
            int r6 = (int) r6
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
        L_0x002d:
            r6 = 4643985272004935680(0x4072c00000000000, double:300.0)
            r3 = 2131952861(0x7f1304dd, float:1.9542177E38)
            r8 = 2131952842(0x7f1304ca, float:1.9542138E38)
            r9 = 4645040803167600640(0x4076800000000000, double:360.0)
            r11 = 0
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
            r15 = 0
            int r16 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r16 < 0) goto L_0x004a
            int r16 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r16 < 0) goto L_0x0057
        L_0x004a:
            r16 = 4645023210981556224(0x4076700000000000, double:359.0)
            int r18 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r18 < 0) goto L_0x005b
            int r18 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r18 >= 0) goto L_0x005b
        L_0x0057:
            r3 = 2131952856(0x7f1304d8, float:1.9542167E38)
            goto L_0x009b
        L_0x005b:
            int r18 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r18 < 0) goto L_0x0067
            int r4 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r4 >= 0) goto L_0x0067
        L_0x0063:
            r3 = 2131952842(0x7f1304ca, float:1.9542138E38)
            goto L_0x009b
        L_0x0067:
            r4 = 4643967679818891264(0x4072b00000000000, double:299.0)
            int r18 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r18 < 0) goto L_0x0075
            int r4 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r4 >= 0) goto L_0x0075
            goto L_0x009b
        L_0x0075:
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            int r16 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r16 < 0) goto L_0x0080
            int r16 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r16 >= 0) goto L_0x0080
            goto L_0x0063
        L_0x0080:
            r16 = 4643281584563159040(0x4070400000000000, double:260.0)
            int r8 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r8 < 0) goto L_0x008e
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x008e
            goto L_0x009b
        L_0x008e:
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 < 0) goto L_0x009a
            int r3 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x009a
            r3 = 2131952839(0x7f1304c7, float:1.9542132E38)
            goto L_0x009b
        L_0x009a:
            r3 = 0
        L_0x009b:
            android.widget.TextView r4 = r0.f28999t
            if (r4 != 0) goto L_0x00a0
            goto L_0x00a3
        L_0x00a0:
            r4.setText(r3)
        L_0x00a3:
            com.didi.map.global.flow.scene.order.bluetooth_meet.view.BTMArrowView r3 = r0.f28992m
            if (r3 != 0) goto L_0x00a8
            goto L_0x00c7
        L_0x00a8:
            r4 = 1
            int r5 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x00b3
            int r5 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r5 > 0) goto L_0x00b3
            r5 = 1
            goto L_0x00b4
        L_0x00b3:
            r5 = 0
        L_0x00b4:
            if (r5 != 0) goto L_0x00c3
            int r5 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x00c0
            int r5 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x00c0
            r5 = 1
            goto L_0x00c1
        L_0x00c0:
            r5 = 0
        L_0x00c1:
            if (r5 == 0) goto L_0x00c4
        L_0x00c3:
            r15 = 1
        L_0x00c4:
            r3.showArch(r15)
        L_0x00c7:
            com.didi.map.global.flow.scene.order.bluetooth_meet.view.BTMArrowView r3 = r0.f28992m
            if (r3 != 0) goto L_0x00cc
            goto L_0x00d0
        L_0x00cc:
            float r4 = (float) r1
            r3.setAngle(r4)
        L_0x00d0:
            float r1 = (float) r1
            kotlin.Pair r1 = r0.m22566a((float) r1)
            if (r1 != 0) goto L_0x00d8
            goto L_0x00f4
        L_0x00d8:
            com.didi.map.global.flow.scene.order.bluetooth_meet.view.BTMGradientView r2 = r0.f29000u
            if (r2 != 0) goto L_0x00dd
            goto L_0x00f4
        L_0x00dd:
            java.lang.Object r3 = r1.getFirst()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object r1 = r1.getSecond()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r2.setBgAnimation(r3, r1)
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView.m22569a(double, double):void");
    }

    /* renamed from: a */
    private final void m22576a(BTMAction bTMAction) {
        ValueAnimator valueAnimator;
        int i = WhenMappings.$EnumSwitchMapping$0[bTMAction.ordinal()];
        if (i == 1) {
            ValueAnimator valueAnimator2 = this.f29003x;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            ValueAnimator valueAnimator3 = this.f29003x;
            if (valueAnimator3 != null) {
                valueAnimator3.removeAllUpdateListeners();
            }
            ValueAnimator valueAnimator4 = this.f29003x;
            if (valueAnimator4 != null) {
                valueAnimator4.removeAllListeners();
            }
            this.f29003x = null;
            IBTMHandler handler = this.f28980a.getHandler();
            if (handler != null) {
                handler.onCloseClick();
            }
        } else if (i == 2 && (valueAnimator = this.f29003x) != null) {
            valueAnimator.pause();
        }
    }

    /* renamed from: a */
    private final void m22577a(BTMState bTMState) {
        switch (WhenMappings.$EnumSwitchMapping$1[bTMState.ordinal()]) {
            case 1:
                m22593k();
                return;
            case 2:
                m22594l();
                return;
            case 3:
                m22592j();
                return;
            case 4:
                m22591i();
                return;
            case 5:
                m22590h();
                return;
            case 6:
                m22583d();
                return;
            case 7:
                m22585e();
                return;
            case 8:
                m22587f();
                return;
            case 9:
                m22589g();
                return;
            case 10:
                m22578a(false);
                return;
            case 11:
                m22578a(true);
                return;
            default:
                return;
        }
    }

    /* renamed from: d */
    private final void m22583d() {
        TextView textView = this.f28982c;
        if (textView != null) {
            textView.setText(R.string.GRider_navigation__iHMu);
        }
        ImageView imageView = this.f28983d;
        if (imageView != null) {
            ViewExtKt.gone(imageView);
        }
        BTMRippleView bTMRippleView = this.f29004y;
        if (bTMRippleView != null) {
            ViewExtKt.gone(bTMRippleView);
        }
        BTMTripleRippleView bTMTripleRippleView = this.f29005z;
        if (bTMTripleRippleView != null) {
            ViewExtKt.gone(bTMTripleRippleView);
        }
        TextView textView2 = this.f28985f;
        if (textView2 != null) {
            ViewExtKt.gone(textView2);
        }
        BTMGradientTextView bTMGradientTextView = this.f28984e;
        if (bTMGradientTextView != null) {
            ViewExtKt.gone(bTMGradientTextView);
        }
        TextView textView3 = this.f28986g;
        if (textView3 != null) {
            ViewExtKt.gone(textView3);
        }
        ImageView imageView2 = this.f28989j;
        if (imageView2 != null) {
            ViewExtKt.show(imageView2);
        }
        View view = this.f28990k;
        if (view != null) {
            ViewExtKt.show(view);
        }
        BTMArrowView bTMArrowView = this.f28992m;
        if (bTMArrowView != null) {
            ViewExtKt.show(bTMArrowView);
        }
        BTMDriverCardView bTMDriverCardView = this.f29001v;
        if (bTMDriverCardView != null) {
            ViewExtKt.gone(bTMDriverCardView);
        }
    }

    /* renamed from: e */
    private final void m22585e() {
        TextView textView = this.f28982c;
        if (textView != null) {
            textView.setText(R.string.GRider_navigation__azyv);
        }
        TextView textView2 = this.f28982c;
        if (textView2 != null) {
            ViewExtKt.show(textView2);
        }
        BTMArrowView bTMArrowView = this.f28992m;
        if (bTMArrowView != null) {
            ViewExtKt.gone(bTMArrowView);
        }
        View view = this.f28994o;
        if (view != null) {
            ViewExtKt.gone(view);
        }
        BTMTripleRippleView bTMTripleRippleView = this.f29005z;
        if (bTMTripleRippleView != null) {
            ViewExtKt.show(bTMTripleRippleView);
        }
        BTMGradientTextView bTMGradientTextView = this.f28984e;
        if (bTMGradientTextView != null) {
            ViewExtKt.gone(bTMGradientTextView);
        }
        TextView textView3 = this.f28986g;
        if (textView3 != null) {
            ViewExtKt.gone(textView3);
        }
        BTMTripleRippleView bTMTripleRippleView2 = this.f29005z;
        if (bTMTripleRippleView2 != null) {
            bTMTripleRippleView2.start();
        }
        TextView textView4 = this.f28993n;
        if (textView4 != null) {
            ViewExtKt.gone(textView4);
        }
        BTMDriverCardView bTMDriverCardView = this.f29001v;
        if (bTMDriverCardView != null) {
            ViewExtKt.show(bTMDriverCardView);
        }
        TextView textView5 = this.f28999t;
        if (textView5 != null) {
            textView5.setText(R.string.GRider_navigation__Vxpv);
        }
        ImageView imageView = this.f28989j;
        if (imageView != null) {
            ViewExtKt.show(imageView);
        }
        View view2 = this.f28990k;
        if (view2 != null) {
            ViewExtKt.show(view2);
        }
        BTMGradientView bTMGradientView = this.f29000u;
        if (bTMGradientView != null) {
            bTMGradientView.setBgAnimation(this.f28974A, this.f28975B);
        }
    }

    /* renamed from: f */
    private final void m22587f() {
        TextView textView = this.f28982c;
        if (textView != null) {
            ViewExtKt.show(textView);
        }
        TextView textView2 = this.f28982c;
        if (textView2 != null) {
            textView2.setText(R.string.GRider_navigation__udNP);
        }
        BTMArrowView bTMArrowView = this.f28992m;
        if (bTMArrowView != null) {
            ViewExtKt.gone(bTMArrowView);
        }
        TextView textView3 = this.f28985f;
        if (textView3 != null) {
            ViewExtKt.gone(textView3);
        }
        View view = this.f28997r;
        if (view != null) {
            ViewExtKt.gone(view);
        }
        TextView textView4 = this.f28999t;
        if (textView4 != null) {
            ViewExtKt.gone(textView4);
        }
        BTMRippleView bTMRippleView = this.f29004y;
        if (bTMRippleView != null) {
            ViewExtKt.gone(bTMRippleView);
        }
        View view2 = this.f28994o;
        if (view2 != null) {
            ViewExtKt.gone(view2);
        }
        BTMTripleRippleView bTMTripleRippleView = this.f29005z;
        if (bTMTripleRippleView != null) {
            ViewExtKt.gone(bTMTripleRippleView);
        }
        BTMGradientTextView bTMGradientTextView = this.f28984e;
        if (bTMGradientTextView != null) {
            ViewExtKt.gone(bTMGradientTextView);
        }
        TextView textView5 = this.f28986g;
        if (textView5 != null) {
            ViewExtKt.gone(textView5);
        }
        TextView textView6 = this.f28993n;
        if (textView6 != null) {
            ViewExtKt.gone(textView6);
        }
        BTMDriverCardView bTMDriverCardView = this.f29001v;
        if (bTMDriverCardView != null) {
            ViewExtKt.show(bTMDriverCardView);
        }
        TextView textView7 = this.f29002w;
        if (textView7 != null) {
            ViewExtKt.show(textView7);
        }
        BTMGradientView bTMGradientView = this.f29000u;
        if (bTMGradientView != null) {
            bTMGradientView.setBgAnimation(this.f28974A, this.f28975B);
        }
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{5, 0}).setDuration(5000);
        duration.setInterpolator((TimeInterpolator) null);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SctxBTMView.m22571a(SctxBTMView.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(duration, "");
        duration.addListener(new C10479x82ce6098(this));
        Unit unit = Unit.INSTANCE;
        this.f29003x = duration;
        if (duration != null) {
            duration.start();
        }
        View view3 = this.f28990k;
        if (view3 != null) {
            ViewExtKt.gone(view3);
        }
        ImageView imageView = this.f28989j;
        if (imageView != null) {
            ViewExtKt.gone(imageView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22571a(SctxBTMView sctxBTMView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(sctxBTMView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            int intValue = ((Integer) animatedValue).intValue();
            TextView textView = sctxBTMView.f29002w;
            if (textView != null) {
                textView.setText(sctxBTMView.getContext().getResources().getString(R.string.GRider_navigation__ROfO, new Object[]{String.valueOf(intValue)}));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: a */
    private final void m22578a(boolean z) {
        TextView textView = this.f28982c;
        if (textView != null) {
            ViewExtKt.gone(textView);
        }
        ImageView imageView = this.f28983d;
        if (imageView != null) {
            ViewExtKt.gone(imageView);
        }
        BTMRippleView bTMRippleView = this.f29004y;
        if (bTMRippleView != null) {
            ViewExtKt.gone(bTMRippleView);
        }
        BTMTripleRippleView bTMTripleRippleView = this.f29005z;
        if (bTMTripleRippleView != null) {
            ViewExtKt.gone(bTMTripleRippleView);
        }
        TextView textView2 = this.f28985f;
        if (textView2 != null) {
            ViewExtKt.gone(textView2);
        }
        BTMGradientTextView bTMGradientTextView = this.f28984e;
        if (bTMGradientTextView != null) {
            ViewExtKt.gone(bTMGradientTextView);
        }
        TextView textView3 = this.f28986g;
        if (textView3 != null) {
            ViewExtKt.gone(textView3);
        }
        ImageView imageView2 = this.f28989j;
        if (imageView2 != null) {
            ViewExtKt.show(imageView2);
        }
        View view = this.f28990k;
        if (view != null) {
            ViewExtKt.show(view);
        }
        BTMArrowView bTMArrowView = this.f28992m;
        if (bTMArrowView != null) {
            ViewExtKt.show(bTMArrowView);
        }
        if (z) {
            TextView textView4 = this.f28993n;
            if (textView4 != null) {
                ViewExtKt.show(textView4);
            }
        } else {
            TextView textView5 = this.f28993n;
            if (textView5 != null) {
                ViewExtKt.gone(textView5);
            }
        }
        View view2 = this.f28994o;
        if (view2 != null) {
            ViewExtKt.show(view2);
        }
        BTMDriverCardView bTMDriverCardView = this.f29001v;
        if (bTMDriverCardView != null) {
            ViewExtKt.gone(bTMDriverCardView);
        }
    }

    /* renamed from: g */
    private final void m22589g() {
        TextView textView = this.f28982c;
        if (textView != null) {
            ViewExtKt.gone(textView);
        }
        ImageView imageView = this.f28983d;
        if (imageView != null) {
            ViewExtKt.gone(imageView);
        }
        BTMRippleView bTMRippleView = this.f29004y;
        if (bTMRippleView != null) {
            ViewExtKt.gone(bTMRippleView);
        }
        BTMTripleRippleView bTMTripleRippleView = this.f29005z;
        if (bTMTripleRippleView != null) {
            ViewExtKt.gone(bTMTripleRippleView);
        }
        TextView textView2 = this.f28985f;
        if (textView2 != null) {
            ViewExtKt.gone(textView2);
        }
        BTMGradientTextView bTMGradientTextView = this.f28984e;
        if (bTMGradientTextView != null) {
            ViewExtKt.gone(bTMGradientTextView);
        }
        TextView textView3 = this.f28986g;
        if (textView3 != null) {
            ViewExtKt.gone(textView3);
        }
        ImageView imageView2 = this.f28989j;
        if (imageView2 != null) {
            ViewExtKt.show(imageView2);
        }
        View view = this.f28990k;
        if (view != null) {
            ViewExtKt.show(view);
        }
        BTMArrowView bTMArrowView = this.f28992m;
        if (bTMArrowView != null) {
            ViewExtKt.show(bTMArrowView);
        }
        TextView textView4 = this.f28993n;
        if (textView4 != null) {
            ViewExtKt.gone(textView4);
        }
        View view2 = this.f28994o;
        if (view2 != null) {
            ViewExtKt.show(view2);
        }
        BTMDriverCardView bTMDriverCardView = this.f29001v;
        if (bTMDriverCardView != null) {
            ViewExtKt.gone(bTMDriverCardView);
        }
    }

    /* renamed from: h */
    private final void m22590h() {
        TextView textView = this.f28982c;
        if (textView != null) {
            textView.setText(R.string.GRider_navigation__sHhV);
        }
        ImageView imageView = this.f28983d;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.btm_repair);
        }
        BTMRippleView bTMRippleView = this.f29004y;
        if (bTMRippleView != null) {
            bTMRippleView.reset();
        }
        BTMTripleRippleView bTMTripleRippleView = this.f29005z;
        if (bTMTripleRippleView != null) {
            ViewExtKt.gone(bTMTripleRippleView);
        }
        TextView textView2 = this.f28985f;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.f28985f;
        if (textView3 != null) {
            textView3.setEnabled(true);
        }
        BTMGradientTextView bTMGradientTextView = this.f28984e;
        if (bTMGradientTextView != null) {
            bTMGradientTextView.setText(R.string.GRider_navigation__gEQX);
        }
        BTMGradientTextView bTMGradientTextView2 = this.f28984e;
        if (bTMGradientTextView2 != null) {
            bTMGradientTextView2.showGradient(false);
        }
        TextView textView4 = this.f28986g;
        if (textView4 != null) {
            textView4.setText(R.string.GRider_navigation__wHkJ);
        }
    }

    /* renamed from: i */
    private final void m22591i() {
        TextView textView = this.f28982c;
        if (textView != null) {
            textView.setText(R.string.GRider_navigation__sHhV);
        }
        ImageView imageView = this.f28983d;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.btm_no_permission);
        }
        BTMRippleView bTMRippleView = this.f29004y;
        if (bTMRippleView != null) {
            bTMRippleView.reset();
        }
        BTMTripleRippleView bTMTripleRippleView = this.f29005z;
        if (bTMTripleRippleView != null) {
            ViewExtKt.gone(bTMTripleRippleView);
        }
        TextView textView2 = this.f28985f;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        BTMGradientTextView bTMGradientTextView = this.f28984e;
        if (bTMGradientTextView != null) {
            bTMGradientTextView.setText(R.string.GRider_navigation__uino);
        }
        BTMGradientTextView bTMGradientTextView2 = this.f28984e;
        if (bTMGradientTextView2 != null) {
            bTMGradientTextView2.showGradient(false);
        }
        TextView textView3 = this.f28986g;
        if (textView3 != null) {
            textView3.setText(R.string.GRider_navigation__HCkg);
        }
        TextView textView4 = this.f28987h;
        if (textView4 != null) {
            ViewExtKt.show(textView4);
        }
        TextView textView5 = this.f28987h;
        if (textView5 != null) {
            textView5.setText(R.string.GRider_navigation__InoI);
        }
    }

    /* renamed from: j */
    private final void m22592j() {
        TextView textView = this.f28982c;
        if (textView != null) {
            textView.setText(R.string.GRider_navigation__sHhV);
        }
        ImageView imageView = this.f28983d;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.btm_no_permission);
        }
        BTMRippleView bTMRippleView = this.f29004y;
        if (bTMRippleView != null) {
            bTMRippleView.reset();
        }
        BTMTripleRippleView bTMTripleRippleView = this.f29005z;
        if (bTMTripleRippleView != null) {
            ViewExtKt.gone(bTMTripleRippleView);
        }
        TextView textView2 = this.f28985f;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        BTMGradientTextView bTMGradientTextView = this.f28984e;
        if (bTMGradientTextView != null) {
            bTMGradientTextView.setText(R.string.GRider_navigation__uino);
        }
        BTMGradientTextView bTMGradientTextView2 = this.f28984e;
        if (bTMGradientTextView2 != null) {
            bTMGradientTextView2.showGradient(false);
        }
        TextView textView3 = this.f28986g;
        if (textView3 != null) {
            textView3.setText(R.string.GRider_navigation__HCkg);
        }
        TextView textView4 = this.f28987h;
        if (textView4 != null) {
            ViewExtKt.show(textView4);
        }
        TextView textView5 = this.f28987h;
        if (textView5 != null) {
            textView5.setText(R.string.GRider_navigation__YcJG);
        }
    }

    /* renamed from: k */
    private final void m22593k() {
        TextView textView = this.f28982c;
        if (textView != null) {
            textView.setText(R.string.GRider_navigation__sHhV);
        }
        ImageView imageView = this.f28983d;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.btm_bluetooth_pairing_paired);
        }
        BTMRippleView bTMRippleView = this.f29004y;
        if (bTMRippleView != null) {
            bTMRippleView.start();
        }
        BTMTripleRippleView bTMTripleRippleView = this.f29005z;
        if (bTMTripleRippleView != null) {
            ViewExtKt.gone(bTMTripleRippleView);
        }
        TextView textView2 = this.f28985f;
        if (textView2 != null) {
            textView2.setEnabled(false);
        }
        BTMGradientTextView bTMGradientTextView = this.f28984e;
        if (bTMGradientTextView != null) {
            bTMGradientTextView.setText(R.string.GRider_navigation__gcvw);
        }
        BTMGradientTextView bTMGradientTextView2 = this.f28984e;
        if (bTMGradientTextView2 != null) {
            bTMGradientTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        BTMGradientTextView bTMGradientTextView3 = this.f28984e;
        if (bTMGradientTextView3 != null) {
            bTMGradientTextView3.showGradient(true);
        }
        TextView textView3 = this.f28986g;
        if (textView3 != null) {
            textView3.setText(R.string.GRider_navigation__tHyF);
        }
        TextView textView4 = this.f28987h;
        if (textView4 != null) {
            ViewExtKt.gone(textView4);
        }
    }

    /* renamed from: l */
    private final void m22594l() {
        TextView textView = this.f28982c;
        if (textView != null) {
            textView.setText(R.string.GRider_navigation__sHhV);
        }
        ImageView imageView = this.f28983d;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.btm_bluetooth_pairing_paired);
        }
        BTMRippleView bTMRippleView = this.f29004y;
        if (bTMRippleView != null) {
            bTMRippleView.reset();
        }
        BTMTripleRippleView bTMTripleRippleView = this.f29005z;
        if (bTMTripleRippleView != null) {
            ViewExtKt.gone(bTMTripleRippleView);
        }
        TextView textView2 = this.f28985f;
        if (textView2 != null) {
            textView2.setEnabled(false);
        }
        BTMGradientTextView bTMGradientTextView = this.f28984e;
        if (bTMGradientTextView != null) {
            bTMGradientTextView.setText(R.string.GRider_navigation__dlRA);
        }
        BTMGradientTextView bTMGradientTextView2 = this.f28984e;
        if (bTMGradientTextView2 != null) {
            bTMGradientTextView2.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.btm_status_info_paired_icon, 0, 0, 0);
        }
        BTMGradientTextView bTMGradientTextView3 = this.f28984e;
        if (bTMGradientTextView3 != null) {
            bTMGradientTextView3.showGradient(true);
        }
        TextView textView3 = this.f28986g;
        if (textView3 != null) {
            textView3.setText(R.string.GRider_navigation__tHyF);
        }
    }

    public void setNewIMMsgCome(boolean z) {
        if (z) {
            View view = this.f28991l;
            if (view != null) {
                ViewExtKt.show(view);
                return;
            }
            return;
        }
        View view2 = this.f28991l;
        if (view2 != null) {
            ViewExtKt.gone(view2);
        }
    }

    public void handleBluetoothPermissionRequestResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantedResult");
        this.f28981b.handleBluetoothPermissionRequestResult(i, strArr, iArr);
    }

    public void handleBluetoothPermissionSettingBack(int i, int i2, Intent intent) {
        this.f28981b.handleBluetoothPermissionSettingBack(i, i2, intent);
    }

    public void setPassengerOnboard() {
        if (this.f28981b.getUiStateLiveData().getValue() != BTMState.ON_BOARD) {
            this.f28981b.setPassengerOnboard();
        }
    }

    public boolean onBackPress() {
        this.f28981b.handleCloseClick();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator;
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator2 = this.f29003x;
        if (Intrinsics.areEqual((Object) valueAnimator2 == null ? null : Boolean.valueOf(valueAnimator2.isRunning()), (Object) true) && (valueAnimator = this.f29003x) != null) {
            valueAnimator.cancel();
        }
        this.f29003x = null;
        this.f28981b.onViewDetachedFromWindow();
    }

    /* renamed from: a */
    private final Pair<Integer, Integer> m22566a(float f) {
        if (f <= 360.0f && f >= 0.0f) {
            if ((f >= 0.0f && f < 50.0f) || (f >= 330.0f && f <= 360.0f)) {
                return new Pair<>(Integer.valueOf(this.f28974A), Integer.valueOf(this.f28975B));
            }
            if (f >= 50.0f && f < 80.0f) {
                return m22567a(f, 50.0f, 80.0f, this.f28974A, this.f28975B, this.f28976C, this.f28977D);
            } else if ((f >= 80.0f && f < 100.0f) || (f >= 280.0f && f < 300.0f)) {
                return new Pair<>(Integer.valueOf(this.f28976C), Integer.valueOf(this.f28977D));
            } else {
                if (f >= 100.0f && f < 130.0f) {
                    return m22567a(f, 100.0f, 130.0f, this.f28976C, this.f28977D, this.f28978E, this.f28979F);
                } else if (f >= 130.0f && f < 250.0f) {
                    return new Pair<>(Integer.valueOf(this.f28978E), Integer.valueOf(this.f28979F));
                } else {
                    if (f >= 250.0f && f < 280.0f) {
                        return m22567a(f, 250.0f, 280.0f, this.f28978E, this.f28979F, this.f28976C, this.f28977D);
                    } else if (f > 300.0f && f <= 330.0f) {
                        return m22567a(f, 300.0f, 330.0f, this.f28976C, this.f28977D, this.f28974A, this.f28975B);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private final Pair<Integer, Integer> m22567a(float f, float f2, float f3, int i, int i2, int i3, int i4) {
        if (f < f2 || f > f3) {
            return null;
        }
        float f4 = (f - f2) / (f3 - f2);
        return new Pair<>(Integer.valueOf(m22565a(f4, i, i3)), Integer.valueOf(m22565a(f4, i2, i4)));
    }

    /* renamed from: a */
    private final int m22565a(float f, int i, int i2) {
        return Color.argb(255, (int) (((float) Color.red(i)) + (((float) (Color.red(i2) - Color.red(i))) * f)), (int) (((float) Color.green(i)) + (((float) (Color.green(i2) - Color.green(i))) * f)), (int) (((float) Color.blue(i)) + (((float) (Color.blue(i2) - Color.blue(i))) * f)));
    }
}
