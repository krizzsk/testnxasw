package com.didi.map.global.flow.scene.order.bluetooth_meet.model;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.didi.common.map.Map;
import com.didi.common.map.util.DLog;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.dialog.LEGOBaseDialogModel;
import com.didi.global.globaluikit.dialog.LEGODialogFragment;
import com.didi.global.globaluikit.dialog.templatemodel.LEGODialogModel1;
import com.didi.global.globaluikit.dialog.templatemodel.LEGODialogModel3;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel2;
import com.didi.map.core.p122ui.callback.UnPeekLiveData;
import com.didi.map.global.component.bluetooth.client.ClientState;
import com.didi.map.global.flow.scene.order.bluetooth_meet.BTMNavDataEngindParam;
import com.didi.map.global.flow.scene.order.bluetooth_meet.BTMNavDataEngine;
import com.didi.map.global.flow.scene.order.bluetooth_meet.BTMOmegaHelper;
import com.didi.map.global.flow.scene.order.bluetooth_meet.BTMUtilsKt;
import com.didi.map.global.flow.scene.order.bluetooth_meet.BluetoothPermissionHelper;
import com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView;
import com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMViewKt;
import com.didi.map.global.sdk.movement.ble.BleNavGuide;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000Ç\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0/J$\u00100\u001a\u00020-2\u001c\u0010.\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b0/J\u0014\u00101\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020*0/J\b\u00102\u001a\u00020-H\u0002J$\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\"2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020-06H\u0002J*\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010<H\u0002J\u0010\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020@H\u0002J)\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u0002092\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020G¢\u0006\u0002\u0010HJ \u0010I\u001a\u00020-2\u0006\u0010B\u001a\u0002092\u0006\u0010J\u001a\u0002092\b\u0010K\u001a\u0004\u0018\u00010LJ\u0010\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020OH\u0002J\u0006\u0010P\u001a\u00020-J\u0006\u0010Q\u001a\u00020-J\b\u0010R\u001a\u00020-H\u0002J\b\u0010S\u001a\u00020-H\u0002J\u0006\u0010T\u001a\u00020-J\b\u0010U\u001a\u00020-H\u0002J\u0006\u0010V\u001a\u00020-J\b\u0010W\u001a\u00020-H\u0002J\b\u0010X\u001a\u00020-H\u0002J\u0006\u0010Y\u001a\u00020-J\u0006\u0010Z\u001a\u00020-J\b\u0010[\u001a\u00020-H\u0002J\u000e\u0010\\\u001a\u00020-2\u0006\u0010]\u001a\u00020\tJ\b\u0010^\u001a\u00020-H\u0002J\u000e\u0010_\u001a\u00020-2\u0006\u0010N\u001a\u00020*J\u000e\u0010`\u001a\u00020-2\u0006\u0010a\u001a\u00020\"J\b\u0010b\u001a\u00020-H\u0002J\b\u0010c\u001a\u00020-H\u0002R5\u0010\u0007\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019Rr\u0010\u001a\u001af\u0012,\u0012*\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c \n*\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001b0\u001b \n*2\u0012,\u0012*\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c \n*\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001b0\u001b\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R5\u0010)\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010*0* \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010*0*\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\f¨\u0006d"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMViewModel;", "", "context", "Landroidx/fragment/app/FragmentActivity;", "param", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMParam;", "(Landroidx/fragment/app/FragmentActivity;Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMParam;)V", "actionLiveData", "Lcom/didi/map/core/ui/callback/UnPeekLiveData;", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMAction;", "kotlin.jvm.PlatformType", "getActionLiveData", "()Lcom/didi/map/core/ui/callback/UnPeekLiveData;", "bluetoothHelper", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/BluetoothPermissionHelper;", "bluetoothIntentFilter", "Landroid/content/IntentFilter;", "broadcastReceiver", "com/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMViewModel$broadcastReceiver$1", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMViewModel$broadcastReceiver$1;", "btmNavEngine", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/BTMNavDataEngine;", "closeDrawer", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "getContext", "()Landroidx/fragment/app/FragmentActivity;", "driverNavInfoLivedata", "Lkotlin/Pair;", "", "failureDialog", "Lcom/didi/global/globaluikit/dialog/LEGODialogFragment;", "handler", "Landroid/os/Handler;", "hasFailed", "", "lifecycleEventObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "omegaHelper", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/BTMOmegaHelper;", "getParam", "()Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMParam;", "uiStateLiveData", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMState;", "getUiStateLiveData", "bindActionObserver", "", "observer", "Landroidx/lifecycle/Observer;", "bindDriverNavInfoObserver", "bindUIStateObserver", "doQuite", "ensureBluetoothEnable", "fromGrantedPermission", "callback", "Lkotlin/Function1;", "getFailureAlert", "titleId", "", "contentId", "mainBtn", "Lcom/didi/global/globaluikit/callback/LEGOBtnTextAndCallback;", "minorBtn", "handleBleNavInfo", "navInfo", "Lcom/didi/map/global/sdk/movement/ble/BleNavGuide;", "handleBluetoothPermissionRequestResult", "requestCode", "permissions", "", "", "grantedResult", "", "(I[Ljava/lang/String;[I)V", "handleBluetoothPermissionSettingBack", "resultCode", "data", "Landroid/content/Intent;", "handleBluetoothState", "state", "Lcom/didi/map/global/component/bluetooth/client/ClientState;", "handleCloseClick", "handleNoPermissionOrTurnedOff", "initBleClient", "onBluetoothTurnOff", "onClickBluetoothIcon", "onFailure", "onViewDetachedFromWindow", "registerBroadcastReceiver", "registerLifecycleObserver", "setPassengerOnboard", "start", "startPair", "toAction", "action", "toAppSetting", "toState", "tryAgain", "fromTryAgainBtn", "unRegisterBroadcastReceiver", "unRegisterLifecycleObserver", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BTMViewModel.kt */
public final class BTMViewModel {

    /* renamed from: a */
    private final FragmentActivity f29007a;

    /* renamed from: b */
    private final SctxBTMParam f29008b;

    /* renamed from: c */
    private final Handler f29009c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private final UnPeekLiveData<BTMState> f29010d = new UnPeekLiveData.Builder().setAllowNullValue(false).create();

    /* renamed from: e */
    private final UnPeekLiveData<BTMAction> f29011e = new UnPeekLiveData.Builder().setAllowNullValue(false).create();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final UnPeekLiveData<Pair<Double, Double>> f29012f = new UnPeekLiveData.Builder().setAllowNullValue(false).create();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final BluetoothPermissionHelper f29013g = new BluetoothPermissionHelper(this.f29007a);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public BTMNavDataEngine f29014h;

    /* renamed from: i */
    private boolean f29015i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LEGODialogFragment f29016j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public LEGODrawer f29017k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final BTMOmegaHelper f29018l = new BTMOmegaHelper(this.f29008b.getOrderId());

    /* renamed from: m */
    private final LifecycleEventObserver f29019m = $$Lambda$BTMViewModel$VgFmfYrLgc0qONW4FQfemWHGjVE.INSTANCE;

    /* renamed from: n */
    private final IntentFilter f29020n;

    /* renamed from: o */
    private final BTMViewModel$broadcastReceiver$1 f29021o;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BTMViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ClientState.values().length];
            iArr2[ClientState.ScanFailure.ordinal()] = 1;
            iArr2[ClientState.ConnectFailure.ordinal()] = 2;
            iArr2[ClientState.ConnectSuccess.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public BTMViewModel(FragmentActivity fragmentActivity, SctxBTMParam sctxBTMParam) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "context");
        Intrinsics.checkNotNullParameter(sctxBTMParam, "param");
        this.f29007a = fragmentActivity;
        this.f29008b = sctxBTMParam;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        Unit unit = Unit.INSTANCE;
        this.f29020n = intentFilter;
        this.f29021o = new BTMViewModel$broadcastReceiver$1(this);
        m22612i();
        m22607d();
        m22605b();
        this.f29018l.setBluetoothState(this.f29013g.checkBlueToothPermission(), this.f29013g.isEnable());
    }

    public final FragmentActivity getContext() {
        return this.f29007a;
    }

    public final SctxBTMParam getParam() {
        return this.f29008b;
    }

    public final UnPeekLiveData<BTMState> getUiStateLiveData() {
        return this.f29010d;
    }

    public final UnPeekLiveData<BTMAction> getActionLiveData() {
        return this.f29011e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22598a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m22597a() {
        BTMNavDataEngine bTMNavDataEngine = this.f29014h;
        if (bTMNavDataEngine != null) {
            bTMNavDataEngine.destroy();
        }
        BTMState value = this.f29010d.getValue();
        if (value != null) {
            if (value.getValue() < BTMState.PAIRED.getValue()) {
                m22607d();
                toState(BTMState.BLUETOOTH_TURNOFF);
                return;
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = m22596a((int) R.string.GRider_navigation__uyun, 0, new LEGOBtnTextAndCallback(this.f29007a.getResources().getString(R.string.GRider_navigation__JPYI), new BTMViewModel$onBluetoothTurnOff$1(objectRef, this)), (LEGOBtnTextAndCallback) null);
            this.f29018l.trackMapBtnaviLinkbroken_bt();
        }
    }

    /* renamed from: b */
    private final void m22605b() {
        this.f29007a.getLifecycle().addObserver(this.f29019m);
    }

    /* renamed from: c */
    private final void m22606c() {
        this.f29007a.getLifecycle().removeObserver(this.f29019m);
    }

    public final void onViewDetachedFromWindow() {
        DLog.m10773d(SctxBTMViewKt.BTM_TAG, "ViewModel onDestroy", new Object[0]);
        m22606c();
        m22613j();
        BTMNavDataEngine bTMNavDataEngine = this.f29014h;
        if (bTMNavDataEngine != null) {
            bTMNavDataEngine.destroy();
        }
        LEGODialogFragment lEGODialogFragment = this.f29016j;
        if (lEGODialogFragment != null) {
            lEGODialogFragment.dismiss();
        }
        this.f29016j = null;
        LEGODrawer lEGODrawer = this.f29017k;
        if (lEGODrawer != null) {
            lEGODrawer.dismiss();
        }
        this.f29017k = null;
        this.f29018l.onDestroy();
    }

    /* renamed from: d */
    private final void m22607d() {
        BTMNavDataEngine bTMNavDataEngine = new BTMNavDataEngine();
        this.f29014h = bTMNavDataEngine;
        if (bTMNavDataEngine != null) {
            bTMNavDataEngine.create(this.f29007a, (Map) null);
        }
        BTMNavDataEngindParam bTMNavDataEngindParam = new BTMNavDataEngindParam(this.f29008b.getOrderId(), new BTMViewModel$initBleClient$navDataParam$1(this));
        BTMNavDataEngine bTMNavDataEngine2 = this.f29014h;
        if (bTMNavDataEngine2 != null) {
            bTMNavDataEngine2.setConfigParam(bTMNavDataEngindParam);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m22599a(ClientState clientState) {
        int i = WhenMappings.$EnumSwitchMapping$1[clientState.ordinal()];
        if (i == 1 || i == 2) {
            m22610g();
            this.f29018l.onFailed();
        } else if (i == 3) {
            toState(BTMState.PAIRED);
            this.f29009c.postDelayed(new Runnable() {
                public final void run() {
                    BTMViewModel.m22600a(BTMViewModel.this);
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22600a(BTMViewModel bTMViewModel) {
        Intrinsics.checkNotNullParameter(bTMViewModel, "this$0");
        bTMViewModel.toState(BTMState.INIT_DIRECTION);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m22602a(BleNavGuide bleNavGuide) {
        if (this.f29010d.getValue() != BTMState.VERY_NEAR && this.f29010d.getValue() != BTMState.ON_BOARD) {
            int i = (int) bleNavGuide.eda;
            int i2 = (int) bleNavGuide.direct_pax_toDriver;
            if ((i2 >= 0 && i2 <= 60) || (i2 >= 300 && i2 <= 360)) {
                toState(BTMState.RIGHT_DIRECTION);
            } else if ((i2 > 60 && i2 <= 100) || (i2 >= 260 && i2 < 300)) {
                toState(BTMState.WRONG_DIRECTION);
            } else if (i2 > 100 && i2 < 260) {
                toState(BTMState.WRONG_DIRECTION_TOTALLY);
            }
            this.f29012f.setValue(new Pair(Double.valueOf((double) i), Double.valueOf((double) i2)));
        }
    }

    public final void handleBluetoothPermissionRequestResult(int i, String[] strArr, int[] iArr) {
        Integer num;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantedResult");
        if (i == SctxBTMView.Companion.getBLE_REQUEST_CODE()) {
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    num = null;
                    break;
                }
                int i3 = iArr[i2];
                if (i3 != 0) {
                    num = Integer.valueOf(i3);
                    break;
                }
                i2++;
            }
            if (num == null) {
                this.f29018l.setPermissionGrantedState(true, 0);
                if (this.f29013g.isEnable()) {
                    m22611h();
                } else {
                    m22604a(true, (Function1<? super Boolean, Unit>) new BTMViewModel$handleBluetoothPermissionRequestResult$2(this));
                }
            } else {
                this.f29018l.setPermissionGrantedState(false, 0);
                toState(BTMState.NO_PERMISSION);
            }
        }
    }

    public final void handleNoPermissionOrTurnedOff() {
        if (this.f29010d.getValue() == BTMState.NO_PERMISSION) {
            if (this.f29013g.checkBlueToothPermission()) {
                start();
            } else {
                m22609f();
            }
        }
        if (this.f29010d.getValue() == BTMState.BLUETOOTH_TURNOFF) {
            start();
        }
    }

    public final void handleCloseClick() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LEGODrawerModel2 lEGODrawerModel2 = new LEGODrawerModel2(this.f29007a.getResources().getString(R.string.GRider_navigation__tjfy), new LEGOBtnTextAndCallback(this.f29007a.getResources().getString(R.string.GRider_navigation__ifQy), new BTMViewModel$handleCloseClick$drawerModel$1(objectRef, this)), new LEGOBtnTextAndCallback(this.f29007a.getResources().getString(R.string.GRider_navigation__sgzA), new BTMViewModel$handleCloseClick$drawerModel$2(objectRef, this)));
        lEGODrawerModel2.setSubTitle(this.f29007a.getResources().getString(R.string.GRider_navigation__ByXI));
        lEGODrawerModel2.setIsShowCloseImg(true);
        lEGODrawerModel2.setShowCloseImgListener(new BTMViewModel$handleCloseClick$1(objectRef, this));
        LEGODialogFragment lEGODialogFragment = this.f29016j;
        if (lEGODialogFragment != null) {
            lEGODialogFragment.dismiss();
        }
        this.f29016j = null;
        objectRef.element = LEGOUICreator.showDrawerTemplate(this.f29007a, lEGODrawerModel2);
        this.f29017k = (LEGODrawer) objectRef.element;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m22608e() {
        toAction(BTMAction.ACTION_QUIT);
    }

    public final void handleBluetoothPermissionSettingBack(int i, int i2, Intent intent) {
        if (this.f29010d.getValue() != BTMState.NO_PERMISSION) {
            return;
        }
        if (this.f29013g.checkBlueToothPermission()) {
            this.f29018l.setPermissionGrantedState(true, 1);
            start();
            return;
        }
        this.f29018l.setPermissionGrantedState(false, 1);
    }

    /* renamed from: f */
    private final void m22609f() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse(Intrinsics.stringPlus("package:", this.f29007a.getPackageName())));
        IBTMHandler handler = this.f29008b.getHandler();
        if (handler != null) {
            handler.onStartActivityForResult(intent, SctxBTMView.Companion.getBTM_SETTING_REQUEST_CODE());
        }
    }

    public final void start() {
        PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog(this.f29007a, PrivacyTypeEnum.BLUETOOTH, BTMUtilsKt.getBluetoothPermissions(this.f29007a), new BTMViewModel$start$1(this));
    }

    public final void tryAgain(boolean z) {
        this.f29015i = true;
        start();
        this.f29018l.tryAgain(z);
    }

    /* renamed from: a */
    private final LEGODialogFragment m22596a(int i, int i2, LEGOBtnTextAndCallback lEGOBtnTextAndCallback, LEGOBtnTextAndCallback lEGOBtnTextAndCallback2) {
        LEGOBaseDialogModel lEGOBaseDialogModel;
        if (i2 != 0) {
            lEGOBaseDialogModel = new LEGODialogModel3(this.f29007a.getResources().getString(i), this.f29007a.getResources().getString(i2), lEGOBtnTextAndCallback);
        } else {
            lEGOBaseDialogModel = new LEGODialogModel1(this.f29007a.getResources().getString(i), lEGOBtnTextAndCallback);
        }
        if (lEGOBtnTextAndCallback2 != null) {
            lEGOBaseDialogModel.addMinorBtn(lEGOBtnTextAndCallback2);
        }
        LEGODrawer lEGODrawer = this.f29017k;
        if (lEGODrawer != null) {
            lEGODrawer.dismiss();
        }
        this.f29017k = null;
        LEGODialogFragment showDialogModel = LEGOUICreator.showDialogModel(this.f29007a.getSupportFragmentManager(), lEGOBaseDialogModel, "btm");
        this.f29016j = showDialogModel;
        Intrinsics.checkNotNullExpressionValue(showDialogModel, "dialog");
        return showDialogModel;
    }

    /* renamed from: g */
    private final void m22610g() {
        BTMState value = this.f29010d.getValue();
        if (value != null) {
            if (value.getValue() == BTMState.ON_BOARD.getValue()) {
                toAction(BTMAction.ACTION_PAUSE_AUTO_CLOSE_COUNTDOWN);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = m22596a((int) R.string.GRider_navigation__uyun, 0, new LEGOBtnTextAndCallback(this.f29007a.getResources().getString(R.string.GRider_navigation__JPYI), new BTMViewModel$onFailure$1(objectRef, this)), (LEGOBtnTextAndCallback) null);
            } else if (value.getValue() >= BTMState.PAIRED.getValue()) {
                BTMNavDataEngine bTMNavDataEngine = this.f29014h;
                if (bTMNavDataEngine != null) {
                    bTMNavDataEngine.destroy();
                }
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = m22596a((int) R.string.GRider_navigation__uyun, (int) R.string.GRider_navigation__ByXI, new LEGOBtnTextAndCallback(this.f29007a.getResources().getString(R.string.GRider_navigation__JPYI), new BTMViewModel$onFailure$2(objectRef2, this)), (LEGOBtnTextAndCallback) null);
                this.f29018l.trackMapBtnaviLinkbroken_bt();
            } else if (value.getValue() >= BTMState.PAIRED.getValue()) {
            } else {
                if (this.f29015i) {
                    toState(BTMState.PAIRING_FAILURE);
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    objectRef3.element = m22596a((int) R.string.GRider_navigation__Omnd, (int) R.string.GRider_navigation__wHkJ, new LEGOBtnTextAndCallback(this.f29007a.getResources().getString(R.string.GRider_navigation__pAcH), new BTMViewModel$onFailure$3(objectRef3, this)), new LEGOBtnTextAndCallback(this.f29007a.getResources().getString(R.string.GRider_navigation__ifQy), new BTMViewModel$onFailure$4(objectRef3, this)));
                    return;
                }
                this.f29015i = true;
                toState(BTMState.PAIRING_FAILURE);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m22604a(boolean z, Function1<? super Boolean, Unit> function1) {
        toState(BTMState.BLUETOOTH_TURNOFF);
        if (z) {
            function1.invoke(Boolean.valueOf(this.f29013g.enableBluetooth()));
        } else {
            new AlertDialog.Builder(this.f29007a).setTitle((int) R.string.GRider_navigation__woGC).setCancelable(false).setPositiveButton((int) R.string.GRider_navigation__RiEy, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(function1) {
                public final /* synthetic */ Function1 f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BTMViewModel.m22601a(BTMViewModel.this, this.f$1, dialogInterface, i);
                }
            }).setNegativeButton((int) R.string.GRider_navigation__OBdy, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    BTMViewModel.m22603a(Function1.this, dialogInterface, i);
                }
            }).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22601a(BTMViewModel bTMViewModel, Function1 function1, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(bTMViewModel, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$callback");
        dialogInterface.dismiss();
        function1.invoke(Boolean.valueOf(bTMViewModel.f29013g.enableBluetooth()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22603a(Function1 function1, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(function1, "$callback");
        dialogInterface.dismiss();
        function1.invoke(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final void m22611h() {
        toState(BTMState.PAIRING);
        this.f29018l.startPair();
        BTMNavDataEngine bTMNavDataEngine = this.f29014h;
        if (bTMNavDataEngine != null) {
            bTMNavDataEngine.start();
        }
    }

    public final void toState(BTMState bTMState) {
        Intrinsics.checkNotNullParameter(bTMState, "state");
        if (this.f29010d.getValue() != bTMState) {
            DLog.m10773d(SctxBTMViewKt.BTM_TAG, Intrinsics.stringPlus("UI to state ", bTMState), new Object[0]);
            this.f29018l.setUiState(bTMState);
            this.f29010d.setValue(bTMState);
        }
    }

    public final void bindUIStateObserver(Observer<BTMState> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.f29010d.observeInActivity(this.f29007a, observer);
    }

    public final void toAction(BTMAction bTMAction) {
        Intrinsics.checkNotNullParameter(bTMAction, "action");
        this.f29011e.setValue(bTMAction);
    }

    public final void bindActionObserver(Observer<BTMAction> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.f29011e.observeInActivity(this.f29007a, observer);
    }

    public final void bindDriverNavInfoObserver(Observer<Pair<Double, Double>> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.f29012f.observeInActivity(this.f29007a, observer);
    }

    public final void setPassengerOnboard() {
        LEGODialogFragment lEGODialogFragment = this.f29016j;
        if (lEGODialogFragment != null) {
            lEGODialogFragment.dismiss();
        }
        this.f29016j = null;
        LEGODrawer lEGODrawer = this.f29017k;
        if (lEGODrawer != null) {
            lEGODrawer.dismiss();
        }
        this.f29017k = null;
        BTMNavDataEngine bTMNavDataEngine = this.f29014h;
        if (bTMNavDataEngine != null) {
            bTMNavDataEngine.destroy();
        }
        toState(BTMState.ON_BOARD);
    }

    /* renamed from: i */
    private final void m22612i() {
        DLog.m10773d(SctxBTMViewKt.BTM_TAG, "register BroadcastReceiver", new Object[0]);
        try {
            this.f29007a.registerReceiver(this.f29021o, this.f29020n);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: j */
    private final void m22613j() {
        DLog.m10773d(SctxBTMViewKt.BTM_TAG, "unregister BroadcastReceiver", new Object[0]);
        try {
            this.f29007a.unregisterReceiver(this.f29021o);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    public final void onClickBluetoothIcon() {
        this.f29018l.onClickBluetoothIcon();
    }
}
