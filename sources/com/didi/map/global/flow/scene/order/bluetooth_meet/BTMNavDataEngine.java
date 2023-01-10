package com.didi.map.global.flow.scene.order.bluetooth_meet;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.common.map.Map;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.component.bluetooth.BleBluetoothFactory;
import com.didi.map.global.component.bluetooth.client.BleBluetoothClientParam;
import com.didi.map.global.component.bluetooth.client.IBleBluetoothClientInterface;
import com.didi.map.global.sdk.movement.ble.BleNavGuide;
import com.didi.map.global.sdk.movement.ble.BlueToothEngine;
import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.component.IDataComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u001c\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\b\u0010%\u001a\u00020\u001aH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/BTMNavDataEngine;", "Lcom/didi/map/sdk/component/IBaseComponent;", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/BTMNavDataEngindParam;", "Lcom/didi/map/sdk/component/IDataComponent;", "()V", "bleClient", "Lcom/didi/map/global/component/bluetooth/client/IBleBluetoothClientInterface;", "bluetoothEngine", "Lcom/didi/map/global/sdk/movement/ble/BlueToothEngine;", "context", "Landroid/content/Context;", "driverAngle", "", "eda", "", "handler", "Landroid/os/Handler;", "orientationAngle", "orientationListener", "Lcom/didi/common/sensor/OrientationListener;", "orientationManager", "Lcom/didi/common/sensor/OrientationManager;", "param", "calculateIncludeAngle", "driverOrientation", "create", "", "c", "map", "Lcom/didi/common/map/Map;", "destroy", "handleNavInfo", "onMapVisible", "visible", "", "setConfigParam", "start", "stop", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BTMNavDataEngine.kt */
public final class BTMNavDataEngine implements IBaseComponent<BTMNavDataEngindParam>, IDataComponent {

    /* renamed from: a */
    private BTMNavDataEngindParam f28941a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f28942b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BlueToothEngine f28943c;

    /* renamed from: d */
    private IBleBluetoothClientInterface f28944d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OrientationManager f28945e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OrientationListener f28946f;

    /* renamed from: g */
    private float f28947g = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f28948h = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public double f28949i = -1.0d;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Handler f28950j = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private final float m22555a(float f, float f2) {
        return f2 >= f ? f2 - f : ((float) 360) - (f - f2);
    }

    public void onMapVisible(boolean z) {
    }

    public void stop() {
    }

    public void create(Context context, Map map) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "c.applicationContext");
            this.f28942b = applicationContext;
            IBleBluetoothClientInterface client = BleBluetoothFactory.getClient();
            this.f28944d = client;
            if (client != null) {
                client.create(context, (Map) null);
            }
            Context context2 = this.f28942b;
            if (context2 != null) {
                this.f28945e = OrientationManager.getInstance(context2);
                this.f28946f = new OrientationListener() {
                    public final void onOrientationChanged(float f, float f2, float f3) {
                        BTMNavDataEngine.m22557a(BTMNavDataEngine.this, f, f2, f3);
                    }
                };
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("context");
            throw null;
        }
        throw new IllegalArgumentException("BTMNavDataEngine: Context Can't be null");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22557a(BTMNavDataEngine bTMNavDataEngine, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(bTMNavDataEngine, "this$0");
        bTMNavDataEngine.f28947g = f;
        bTMNavDataEngine.m22556a();
    }

    public void setConfigParam(BTMNavDataEngindParam bTMNavDataEngindParam) {
        String orderId;
        Context context = this.f28942b;
        String str = null;
        if (context != null) {
            String str2 = "";
            if (!(bTMNavDataEngindParam == null || (orderId = bTMNavDataEngindParam.getOrderId()) == null)) {
                str2 = orderId;
            }
            BlueToothEngine blueToothEngine = new BlueToothEngine(context, str2);
            this.f28943c = blueToothEngine;
            this.f28941a = bTMNavDataEngindParam;
            if (blueToothEngine != null) {
                blueToothEngine.setOnBleNavListener(new BTMNavDataEngine$setConfigParam$1(this, bTMNavDataEngindParam));
            }
            BleBluetoothClientParam bleBluetoothClientParam = new BleBluetoothClientParam();
            if (bTMNavDataEngindParam != null) {
                str = bTMNavDataEngindParam.getOrderId();
            }
            bleBluetoothClientParam.orderId = str;
            bleBluetoothClientParam.mCallback = new BTMNavDataEngine$setConfigParam$2(this, bTMNavDataEngindParam);
            IBleBluetoothClientInterface iBleBluetoothClientInterface = this.f28944d;
            if (iBleBluetoothClientInterface != null) {
                iBleBluetoothClientInterface.setConfigParam(bleBluetoothClientParam);
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        throw null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m22556a() {
        float f = this.f28947g;
        if (f > 0.0f) {
            float f2 = this.f28948h;
            if (f2 > 0.0f && this.f28949i > 0.0d) {
                float a = m22555a(f, f2);
                BleNavGuide bleNavGuide = new BleNavGuide();
                bleNavGuide.eda = this.f28949i;
                bleNavGuide.direct_pax_toDriver = a;
                this.f28950j.post(new Runnable(bleNavGuide) {
                    public final /* synthetic */ BleNavGuide f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        BTMNavDataEngine.m22558a(BTMNavDataEngine.this, this.f$1);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22558a(BTMNavDataEngine bTMNavDataEngine, BleNavGuide bleNavGuide) {
        IBTMBluetoothStateCallback bluetoothStateCallback;
        Intrinsics.checkNotNullParameter(bTMNavDataEngine, "this$0");
        Intrinsics.checkNotNullParameter(bleNavGuide, "$bleNavGuide");
        BTMNavDataEngindParam bTMNavDataEngindParam = bTMNavDataEngine.f28941a;
        if (bTMNavDataEngindParam != null && (bluetoothStateCallback = bTMNavDataEngindParam.getBluetoothStateCallback()) != null) {
            bluetoothStateCallback.onBleNavListener(bleNavGuide);
        }
    }

    public void start() {
        IBleBluetoothClientInterface iBleBluetoothClientInterface = this.f28944d;
        if (iBleBluetoothClientInterface != null) {
            iBleBluetoothClientInterface.start();
        }
    }

    public void destroy() {
        BlueToothEngine blueToothEngine = this.f28943c;
        if (blueToothEngine != null) {
            blueToothEngine.onDestroy();
        }
        IBleBluetoothClientInterface iBleBluetoothClientInterface = this.f28944d;
        if (iBleBluetoothClientInterface != null) {
            iBleBluetoothClientInterface.destroy();
        }
        OrientationManager orientationManager = this.f28945e;
        if (orientationManager != null) {
            orientationManager.removeOrientationListener(this.f28946f);
        }
    }
}
