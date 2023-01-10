package com.didi.map.global.component.bluetooth.client;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.map.global.component.bluetooth.apollo.BluetoothApolloUtil;
import com.didi.map.global.component.bluetooth.util.C10122Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class BleBluetoothClient implements IBleBluetoothClientInterface {

    /* renamed from: p */
    private static final long f27022p = BluetoothApolloUtil.getBleScanFailedInterval();

    /* renamed from: q */
    private static final long f27023q = BluetoothApolloUtil.getBleRssiFailedInterval();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public static final long f27024r = BluetoothApolloUtil.getBleReadDataInterval();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public static final long f27025s = BluetoothApolloUtil.getBleReadRssiInterval();

    /* renamed from: a */
    private ScanSettings f27026a = null;

    /* renamed from: b */
    private BluetoothGatt f27027b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IBleBluetoothClientCallback f27028c = null;

    /* renamed from: d */
    private String f27029d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public UUID f27030e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public UUID f27031f = null;

    /* renamed from: g */
    private Context f27032g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f27033h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f27034i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f27035j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f27036k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f27037l = false;

    /* renamed from: m */
    private Timer f27038m = null;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f27039n = 0;

    /* renamed from: o */
    private Handler f27040o = new Handler(Looper.myLooper());
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f27041t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f27042u = 0;

    /* renamed from: v */
    private final ScanCallback f27043v = new ScanCallback() {
        public void onScanResult(int i, ScanResult scanResult) {
            List<ParcelUuid> serviceUuids;
            if (scanResult != null && scanResult.getScanRecord() != null && (serviceUuids = scanResult.getScanRecord().getServiceUuids()) != null && serviceUuids.size() > 0) {
                for (ParcelUuid uuid : serviceUuids) {
                    if (uuid.getUuid().equals(BleBluetoothClient.this.f27030e)) {
                        if (!BleBluetoothClient.this.f27036k) {
                            boolean unused = BleBluetoothClient.this.f27036k = true;
                            BleBluetoothClient.this.m21298h();
                            BleBluetoothClient.this.m21276a(ClientState.ScanSuccess);
                        }
                        if (!BleBluetoothClient.this.f27035j && BleBluetoothClient.this.f27028c != null && BleBluetoothClient.this.f27033h) {
                            RssiInfoResult rssiInfoResult = new RssiInfoResult();
                            int rssi = scanResult.getRssi();
                            rssiInfoResult.setRssi(rssi);
                            rssiInfoResult.setDistance(C10122Util.getDistance(rssi));
                            BleBluetoothClient.this.m21300i();
                            BleBluetoothClient.this.f27028c.onRssiInfoResult(rssiInfoResult);
                        }
                        if (!BleBluetoothClient.this.f27035j && !BleBluetoothClient.this.f27034i) {
                            BleBluetoothClient.this.m21273a(scanResult.getDevice());
                            return;
                        }
                        return;
                    }
                }
            }
        }

        public void onScanFailed(int i) {
            C10122Util.logWrite("onScanFailed : errorCode = " + i);
        }
    };

    /* renamed from: w */
    private final Runnable f27044w = new Runnable() {
        public void run() {
            boolean unused = BleBluetoothClient.this.f27036k = false;
            BleBluetoothClient.this.m21304k();
            BleBluetoothClient.this.m21276a(ClientState.ScanFailure);
        }
    };

    /* renamed from: x */
    private final Runnable f27045x = new Runnable() {
        public void run() {
            BleBluetoothClient.this.m21308m();
            BleBluetoothClient.this.m21304k();
            BleBluetoothClient.this.m21276a(ClientState.ConnectFailure);
        }
    };

    /* renamed from: y */
    private final BluetoothGattCallback f27046y = new BluetoothGattCallback() {
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            C10122Util.logWrite("onConnectionStateChange : status = " + i + ", newState = " + i2);
            if (i == 0 && i2 == 2) {
                if (bluetoothGatt != null) {
                    try {
                        bluetoothGatt.discoverServices();
                    } catch (Exception e) {
                        C10122Util.logWrite("onConnectionStateChange crash " + e);
                    }
                }
                boolean unused = BleBluetoothClient.this.f27035j = true;
                if (!BleBluetoothClient.this.f27037l) {
                    boolean unused2 = BleBluetoothClient.this.f27037l = true;
                    BleBluetoothClient.this.m21276a(ClientState.ConnectSuccess);
                }
                BleBluetoothClient.this.m21284c();
                BleBluetoothClient.this.m21304k();
            } else {
                BleBluetoothClient.this.m21308m();
                BleBluetoothClient.this.m21294f();
            }
            boolean unused3 = BleBluetoothClient.this.f27034i = false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x00c3  */
        /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCharacteristicRead(android.bluetooth.BluetoothGatt r9, android.bluetooth.BluetoothGattCharacteristic r10, int r11) {
            /*
                r8 = this;
                super.onCharacteristicRead(r9, r10, r11)
                if (r11 != 0) goto L_0x00cd
                if (r10 == 0) goto L_0x00cd
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r9 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                r11 = 0
                int unused = r9.f27041t = r11
                java.util.UUID r9 = r10.getUuid()
                if (r9 == 0) goto L_0x00d2
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r0 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                java.util.UUID r0 = r0.f27031f
                boolean r9 = r9.equals(r0)
                if (r9 == 0) goto L_0x00d2
                r9 = 0
                byte[] r10 = r10.getValue()
                java.lang.String r0 = new java.lang.String
                byte[] r1 = com.didi.map.global.component.bluetooth.util.C10122Util.mDecompress(r10)
                r0.<init>(r1)
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L_0x00b3
                java.lang.String r1 = ","
                java.lang.String[] r0 = r0.split(r1)
                int r1 = r0.length
                r2 = 3
                if (r1 != r2) goto L_0x009a
                r1 = r0[r11]
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x009a
                r1 = 1
                r2 = r0[r1]
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x009a
                r2 = 2
                r3 = r0[r2]
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x009a
                com.didi.map.global.component.bluetooth.client.DriverInfoResult r10 = new com.didi.map.global.component.bluetooth.client.DriverInfoResult     // Catch:{ NumberFormatException -> 0x007c }
                r10.<init>()     // Catch:{ NumberFormatException -> 0x007c }
                r9 = r0[r11]     // Catch:{ NumberFormatException -> 0x007a }
                double r3 = java.lang.Double.parseDouble(r9)     // Catch:{ NumberFormatException -> 0x007a }
                r9 = r0[r1]     // Catch:{ NumberFormatException -> 0x007a }
                double r5 = java.lang.Double.parseDouble(r9)     // Catch:{ NumberFormatException -> 0x007a }
                com.didi.common.map.model.LatLng r9 = new com.didi.common.map.model.LatLng     // Catch:{ NumberFormatException -> 0x007a }
                r9.<init>((double) r3, (double) r5)     // Catch:{ NumberFormatException -> 0x007a }
                r10.setDriverPos(r9)     // Catch:{ NumberFormatException -> 0x007a }
                r9 = r0[r2]     // Catch:{ NumberFormatException -> 0x007a }
                float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x007a }
                r10.setDriverAcc(r9)     // Catch:{ NumberFormatException -> 0x007a }
                goto L_0x0098
            L_0x007a:
                r9 = move-exception
                goto L_0x0080
            L_0x007c:
                r10 = move-exception
                r7 = r10
                r10 = r9
                r9 = r7
            L_0x0080:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r0 = "format driver data failed, e = "
                r11.append(r0)
                java.lang.String r9 = r9.toString()
                r11.append(r9)
                java.lang.String r9 = r11.toString()
                com.didi.map.global.component.bluetooth.util.C10122Util.logWrite(r9)
            L_0x0098:
                r9 = r10
                goto L_0x00b3
            L_0x009a:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r0 = "format driver data failed, value = "
                r11.append(r0)
                java.lang.String r0 = new java.lang.String
                r0.<init>(r10)
                r11.append(r0)
                java.lang.String r10 = r11.toString()
                com.didi.map.global.component.bluetooth.util.C10122Util.logWrite(r10)
            L_0x00b3:
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r10 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                com.didi.map.global.component.bluetooth.client.IBleBluetoothClientCallback r10 = r10.f27028c
                if (r10 == 0) goto L_0x00d2
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r10 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                boolean r10 = r10.f27033h
                if (r10 == 0) goto L_0x00d2
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r10 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                com.didi.map.global.component.bluetooth.client.IBleBluetoothClientCallback r10 = r10.f27028c
                r10.onDriverInfoResult(r9)
                goto L_0x00d2
            L_0x00cd:
                com.didi.map.global.component.bluetooth.client.BleBluetoothClient r9 = com.didi.map.global.component.bluetooth.client.BleBluetoothClient.this
                r9.m21279b((int) r11)
            L_0x00d2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.bluetooth.client.BleBluetoothClient.C101194.onCharacteristicRead(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, int):void");
        }

        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
            if (i2 == 0) {
                int unused = BleBluetoothClient.this.f27042u = 0;
                RssiInfoResult rssiInfoResult = new RssiInfoResult();
                if (BleBluetoothClient.this.f27028c != null && BleBluetoothClient.this.f27033h) {
                    rssiInfoResult.setRssi(i);
                    rssiInfoResult.setDistance(C10122Util.getDistance(i));
                    BleBluetoothClient.this.m21300i();
                    BleBluetoothClient.this.f27028c.onRssiInfoResult(rssiInfoResult);
                    return;
                }
                return;
            }
            BleBluetoothClient.this.m21272a(i2);
        }
    };

    /* renamed from: o */
    static /* synthetic */ int m21312o(BleBluetoothClient bleBluetoothClient) {
        int i = bleBluetoothClient.f27039n;
        bleBluetoothClient.f27039n = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21272a(int i) {
        int i2 = this.f27042u + 1;
        this.f27042u = i2;
        if (i2 >= 25) {
            C10122Util.logWrite("readRssiFailed status = " + i);
            m21308m();
            m21294f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21279b(int i) {
        int i2 = this.f27041t + 1;
        this.f27041t = i2;
        if (i2 >= 5) {
            C10122Util.logWrite("readCharacterFailed status = " + i);
            m21308m();
            m21294f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m21284c() {
        m21287d();
        if (this.f27038m == null) {
            C10122Util.logWrite("startReadConnectData");
            Timer timer = new Timer();
            this.f27038m = timer;
            timer.schedule(new ConnectionTimerTask(), 0, f27025s);
        }
    }

    /* renamed from: d */
    private void m21287d() {
        if (this.f27038m != null) {
            C10122Util.logWrite("stopReadConnectData");
            this.f27038m.cancel();
            this.f27038m = null;
        }
    }

    public void create(Context context, Map map) {
        C10122Util.logWrite("BleBluetoothClient create");
        this.f27032g = context;
        m21306l();
    }

    public void start() {
        C10122Util.logWrite("BleBluetoothClient start");
        this.f27037l = false;
        this.f27036k = false;
        if (!C10122Util.bluetoothEnable() || !C10122Util.checkBlePermission(this.f27032g)) {
            C10122Util.logWrite("start Failed ：蓝牙不可用");
        } else {
            m21294f();
        }
    }

    public void stop() {
        m21308m();
        m21304k();
    }

    public void setConfigParam(BleBluetoothClientParam bleBluetoothClientParam) {
        if (bleBluetoothClientParam != null) {
            this.f27029d = bleBluetoothClientParam.orderId;
            this.f27028c = bleBluetoothClientParam.mCallback;
            if (TextUtils.isEmpty(this.f27029d)) {
                C10122Util.logWrite("setConfigParam ：mOrderId is null");
            } else {
                UUID OrderIdToUUID = C10122Util.OrderIdToUUID(this.f27029d);
                this.f27030e = OrderIdToUUID;
                if (OrderIdToUUID == null) {
                    C10122Util.logWrite("setConfigParam ：orderId转UUID出错");
                }
                UUID OrderIdToUUID2 = C10122Util.OrderIdToUUID(this.f27029d + "ReadCharacter");
                this.f27031f = OrderIdToUUID2;
                if (OrderIdToUUID2 == null) {
                    C10122Util.logWrite("setConfigParam ：orderId转mReadCharacterUUID出错");
                }
            }
            if (this.f27028c == null) {
                C10122Util.logWrite("setConfigParam ：mCallback is null");
            }
        }
    }

    public void onMapVisible(boolean z) {
        this.f27033h = z;
        if (!z) {
            m21287d();
            m21302j();
            return;
        }
        m21284c();
        m21300i();
    }

    public void destroy() {
        m21298h();
        m21308m();
        m21304k();
        this.f27026a = null;
        this.f27032g = null;
        this.f27029d = null;
        this.f27030e = null;
        this.f27031f = null;
        this.f27028c = null;
        this.f27040o = null;
        this.f27037l = false;
        this.f27036k = false;
    }

    /* renamed from: e */
    private List<ScanFilter> m21293e() {
        try {
            if (this.f27030e == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ScanFilter.Builder().setServiceUuid(new ParcelUuid(this.f27030e)).build());
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            C10122Util.logWrite("createFilters failed: " + e.toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m21294f() {
        BluetoothAdapter defaultAdapter;
        m21304k();
        C10122Util.logWrite("BleBluetoothClient startScanBle");
        m21296g();
        try {
            if (this.f27026a != null && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null) {
                BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
                List<ScanFilter> e = m21293e();
                if (e != null && bluetoothLeScanner != null) {
                    bluetoothLeScanner.startScan(e, this.f27026a, this.f27043v);
                    C10122Util.logWrite("BleBluetoothClient startScanBle ok");
                }
            }
        } catch (Exception e2) {
            C10122Util.logWrite("startScanBle failed: " + e2.toString());
            m21298h();
            m21276a(ClientState.ScanFailure);
        }
    }

    /* renamed from: g */
    private void m21296g() {
        Handler handler;
        if (!this.f27036k && (handler = this.f27040o) != null) {
            handler.removeCallbacks(this.f27044w);
            this.f27040o.postDelayed(this.f27044w, f27022p);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m21298h() {
        Handler handler = this.f27040o;
        if (handler != null) {
            handler.removeCallbacks(this.f27044w);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m21300i() {
        Handler handler = this.f27040o;
        if (handler != null) {
            handler.removeCallbacks(this.f27045x);
            this.f27040o.postDelayed(this.f27045x, f27023q);
        }
    }

    /* renamed from: j */
    private void m21302j() {
        Handler handler = this.f27040o;
        if (handler != null) {
            handler.removeCallbacks(this.f27045x);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m21304k() {
        C10122Util.logWrite("BleBluetoothClient stopScanBle");
        m21298h();
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.stopScan(this.f27043v);
                }
                C10122Util.logWrite("BleBluetoothClient stopScanBle ok");
            }
        } catch (Exception e) {
            C10122Util.logWrite("stopScanBle failed: " + e.toString());
        }
    }

    /* renamed from: l */
    private void m21306l() {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setLegacy(false);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            builder.setMatchMode(1);
            builder.setCallbackType(1);
        }
        builder.setScanMode(2);
        this.f27026a = builder.build();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21273a(BluetoothDevice bluetoothDevice) {
        m21308m();
        C10122Util.logWrite("startConnect");
        this.f27034i = true;
        if (bluetoothDevice != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f27027b = bluetoothDevice.connectGatt(this.f27032g, false, this.f27046y, 2, 2);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    this.f27027b = bluetoothDevice.connectGatt(this.f27032g, false, this.f27046y, 2);
                } else {
                    this.f27027b = bluetoothDevice.connectGatt(this.f27032g, false, this.f27046y);
                }
            } catch (Exception e) {
                C10122Util.logWrite("startConnect failed " + e.toString());
                this.f27034i = false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21276a(ClientState clientState) {
        IBleBluetoothClientCallback iBleBluetoothClientCallback = this.f27028c;
        if (iBleBluetoothClientCallback != null) {
            iBleBluetoothClientCallback.onStateChange(clientState);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m21308m() {
        C10122Util.logWrite("closeConnect");
        m21287d();
        this.f27035j = false;
        this.f27041t = 0;
        this.f27042u = 0;
        BluetoothGatt bluetoothGatt = this.f27027b;
        if (bluetoothGatt != null) {
            try {
                bluetoothGatt.disconnect();
                this.f27027b.close();
            } catch (Exception e) {
                C10122Util.logWrite("closeConnect failed " + e.toString());
            }
            this.f27027b = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m21311n() {
        BluetoothGatt bluetoothGatt = this.f27027b;
        if (bluetoothGatt != null) {
            boolean z = false;
            int i = 1000;
            BluetoothGattService service = bluetoothGatt.getService(this.f27030e);
            if (service != null) {
                i = 1001;
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.f27031f);
                if (characteristic != null) {
                    i = 1002;
                    try {
                        z = this.f27027b.readCharacteristic(characteristic);
                    } catch (Exception e) {
                        C10122Util.logWrite("readData failed " + e.toString());
                        i = 1003;
                    }
                }
            }
            if (!z) {
                m21279b(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m21313o() {
        BluetoothGatt bluetoothGatt = this.f27027b;
        if (bluetoothGatt != null) {
            boolean z = false;
            int i = 1000;
            try {
                z = bluetoothGatt.readRemoteRssi();
            } catch (Exception e) {
                C10122Util.logWrite("readRssi failed " + e.toString());
                i = 1001;
            }
            if (!z) {
                m21272a(i);
            }
        }
    }

    private class ConnectionTimerTask extends TimerTask {
        private ConnectionTimerTask() {
        }

        public void run() {
            if (BleBluetoothClient.this.f27035j) {
                BleBluetoothClient.m21312o(BleBluetoothClient.this);
                BleBluetoothClient.this.m21313o();
                if (((long) BleBluetoothClient.this.f27039n) == BleBluetoothClient.f27024r / BleBluetoothClient.f27025s) {
                    int unused = BleBluetoothClient.this.f27039n = 0;
                    BleBluetoothClient.this.m21311n();
                }
            }
        }
    }
}
