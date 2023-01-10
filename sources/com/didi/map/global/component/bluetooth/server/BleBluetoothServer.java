package com.didi.map.global.component.bluetooth.server;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.content.IntentFilter;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Log;
import com.didi.common.map.Map;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.bluetooth.BluetoothListenerReceiver;
import com.didi.map.global.component.bluetooth.apollo.BluetoothApolloUtil;
import com.didi.map.global.component.bluetooth.util.C10122Util;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.UUID;

public class BleBluetoothServer implements IBleBluetoothServerInterface {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final long f27051a = BluetoothApolloUtil.getEngineValidTimeInterval();

    /* renamed from: b */
    private BluetoothLeAdvertiser f27052b;

    /* renamed from: c */
    private BluetoothGattServer f27053c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IBleBluetoothServerCallBack f27054d = null;

    /* renamed from: e */
    private String f27055e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public UUID f27056f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public UUID f27057g;

    /* renamed from: h */
    private Context f27058h;

    /* renamed from: i */
    private boolean f27059i = true;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public byte[] f27060j = null;

    /* renamed from: k */
    private final AdvertiseCallback f27061k = new AdvertiseCallback() {
        public void onStartSuccess(AdvertiseSettings advertiseSettings) {
            if (BleBluetoothServer.this.f27054d != null) {
                BleBluetoothServer.this.f27054d.onStateChange(ServerState.OpenAdvertiserSuccess);
            }
            C10122Util.logWrite("AdvertiseCallback onStartSuccess Success");
        }

        public void onStartFailure(int i) {
            C10122Util.logWrite("AdvertiseCallback onStartFailure, errorCode = " + i);
            if (BleBluetoothServer.this.f27054d != null) {
                BleBluetoothServer.this.f27054d.onStateChange(ServerState.OpenAdvertiserFailure);
            }
        }
    };

    /* renamed from: l */
    private BluetoothListenerReceiver f27062l = null;

    /* renamed from: m */
    private final BluetoothGattServerCallback f27063m = new BluetoothGattServerCallback() {
        public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
            String str;
            if (bluetoothDevice != null) {
                C10122Util.logWrite(String.format("onConnectionStateChange:%s,%s,%s,%s", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            if (i == 0) {
                str = i2 == 2 ? "与[%s]连接成功" : "与[%s]连接断开";
            } else {
                str = "与[%s]连接出错,错误码:" + i;
            }
            C10122Util.logWrite(String.format(str, new Object[]{bluetoothDevice}));
        }

        public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BleServerData bleServerData;
            if (bluetoothGattCharacteristic.getUuid().equals(BleBluetoothServer.this.f27057g)) {
                String str = null;
                if (i2 == 0) {
                    if (BleBluetoothServer.this.f27054d != null) {
                        bleServerData = BleBluetoothServer.this.f27054d.getReadData();
                        if (bleServerData != null && LatLngUtils.locateCorrect(bleServerData.getDriverPos()) && Math.abs(System.currentTimeMillis() - bleServerData.getDriverTime()) < BleBluetoothServer.f27051a) {
                            str = BleBluetoothServer.m21324b(bleServerData.getDriverPos().latitude) + "," + BleBluetoothServer.m21324b(bleServerData.getDriverPos().longitude) + "," + ((int) bleServerData.getDriverAcc());
                        }
                    } else {
                        bleServerData = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        byte[] unused = BleBluetoothServer.this.f27060j = C10122Util.mCompression(str.getBytes());
                    } else {
                        byte[] unused2 = BleBluetoothServer.this.f27060j = "there is no data".getBytes();
                        if (bleServerData != null) {
                            if (!LatLngUtils.locateCorrect(bleServerData.getDriverPos())) {
                                C10122Util.logWrite("获取到的司机定位格式不正确");
                                byte[] unused3 = BleBluetoothServer.this.f27060j = "locate error".getBytes();
                            }
                            if (Math.abs(System.currentTimeMillis() - bleServerData.getDriverTime()) >= BleBluetoothServer.f27051a) {
                                long abs = Math.abs(System.currentTimeMillis() - bleServerData.getDriverTime());
                                C10122Util.logWrite("获取到的司机定位时间戳不符合要求, 时间差为:" + abs);
                                byte[] unused4 = BleBluetoothServer.this.f27060j = ("time error:" + abs).getBytes();
                            }
                        } else {
                            C10122Util.logWrite("获取不到司机定位");
                        }
                    }
                    BleBluetoothServer bleBluetoothServer = BleBluetoothServer.this;
                    bleBluetoothServer.m21321a(bluetoothDevice, i, i2, bleBluetoothServer.f27060j);
                } else if (BleBluetoothServer.this.f27060j == null || i2 >= BleBluetoothServer.this.f27060j.length) {
                    BleBluetoothServer.this.m21321a(bluetoothDevice, i, i2, (byte[]) null);
                } else {
                    int length = BleBluetoothServer.this.f27060j.length - i2;
                    byte[] bArr = new byte[length];
                    System.arraycopy(BleBluetoothServer.this.f27060j, i2, bArr, 0, length);
                    BleBluetoothServer.this.m21321a(bluetoothDevice, i, i2, bArr);
                }
            } else {
                BleBluetoothServer.this.m21321a(bluetoothDevice, i, i2, "there is no data".getBytes());
                C10122Util.logWrite("CharacterUUID 不正确");
            }
        }

        public void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
            if (BleBluetoothServer.this.f27054d == null) {
                return;
            }
            if (i != 0 || bluetoothGattService == null || bluetoothGattService.getUuid() == null || !bluetoothGattService.getUuid().equals(BleBluetoothServer.this.f27056f)) {
                BleBluetoothServer.this.f27054d.onStateChange(ServerState.AddServiceFailure);
                C10122Util.logWrite("onServiceAdded failed");
                return;
            }
            BleBluetoothServer.this.f27054d.onStateChange(ServerState.AddServiceSuccess);
            C10122Util.logWrite("onServiceAdded ok");
        }
    };

    /* renamed from: n */
    private final AdvertiseSettings f27064n = new AdvertiseSettings.Builder().setAdvertiseMode(2).setTxPowerLevel(3).setConnectable(true).build();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21321a(BluetoothDevice bluetoothDevice, int i, int i2, byte[] bArr) {
        BluetoothGattServer bluetoothGattServer = this.f27053c;
        if (bluetoothGattServer != null) {
            try {
                bluetoothGattServer.sendResponse(bluetoothDevice, i, 0, i2, bArr);
            } catch (Exception e) {
                C10122Util.logWrite("sendResponse failed " + e.toString());
            }
        }
    }

    public void create(Context context, Map map) {
        C10122Util.logWrite("BleBluetoothServer create");
        this.f27058h = context;
    }

    public void start() {
        if (!C10122Util.bluetoothEnable() || !C10122Util.checkBlePermission(this.f27058h)) {
            C10122Util.logWrite("startAdvertiser Failed ：蓝牙不可用");
        } else {
            m21327c();
        }
    }

    public void stop() {
        m21330d();
    }

    public void setConfigParam(BleBluetoothServerParam bleBluetoothServerParam) {
        if (bleBluetoothServerParam == null || TextUtils.isEmpty(bleBluetoothServerParam.orderId)) {
            C10122Util.logWrite("setConfigParam err ：入参错误");
            return;
        }
        this.f27054d = bleBluetoothServerParam.mCallback;
        this.f27055e = bleBluetoothServerParam.orderId;
        this.f27062l = bleBluetoothServerParam.receiver;
        m21332f();
        C10122Util.logWrite("BleBluetoothServer setConfigParam" + this.f27055e);
        UUID OrderIdToUUID = C10122Util.OrderIdToUUID(this.f27055e);
        this.f27056f = OrderIdToUUID;
        if (OrderIdToUUID == null) {
            C10122Util.logWrite("setConfigParam ：orderId转mServiceUUID出错");
        }
        UUID OrderIdToUUID2 = C10122Util.OrderIdToUUID(this.f27055e + "ReadCharacter");
        this.f27057g = OrderIdToUUID2;
        if (OrderIdToUUID2 == null) {
            C10122Util.logWrite("setDataCallBack ：orderId转mReadCharacterUUID出错");
        }
    }

    public void onMapVisible(boolean z) {
        this.f27059i = z;
        C10122Util.logWrite("BleBluetoothServer onMapVisible" + z);
    }

    public void destroy() {
        C10122Util.logWrite("BleBluetoothServer destroy");
        m21331e();
        m21330d();
        m21326b();
        this.f27052b = null;
        this.f27058h = null;
        this.f27055e = null;
        this.f27056f = null;
        this.f27057g = null;
        this.f27054d = null;
    }

    /* renamed from: b */
    private void m21326b() {
        BluetoothListenerReceiver bluetoothListenerReceiver;
        Context context = this.f27058h;
        if (context != null && (bluetoothListenerReceiver = this.f27062l) != null) {
            try {
                context.unregisterReceiver(bluetoothListenerReceiver);
            } catch (Exception e) {
                try {
                    Log.d("Context", "unregisterReceiver", e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    C10122Util.logWrite("unregisterReceiver crash " + e2.toString());
                }
            }
            this.f27062l = null;
        }
    }

    /* renamed from: a */
    private AdvertiseData m21318a(UUID uuid) {
        return new AdvertiseData.Builder().setIncludeDeviceName(false).setIncludeTxPowerLevel(false).addServiceUuid(new ParcelUuid(uuid)).build();
    }

    /* renamed from: c */
    private void m21327c() {
        m21330d();
        C10122Util.logWrite("startAdvertising");
        if (this.f27056f != null) {
            BluetoothLeAdvertiser bluetoothLeAdvertiser = BluetoothAdapter.getDefaultAdapter().getBluetoothLeAdvertiser();
            this.f27052b = bluetoothLeAdvertiser;
            if (bluetoothLeAdvertiser != null) {
                try {
                    bluetoothLeAdvertiser.startAdvertising(this.f27064n, m21318a(this.f27056f), this.f27061k);
                    m21334h();
                } catch (Exception e) {
                    C10122Util.logWrite("startAdvertising failed " + e.toString());
                }
            }
        }
    }

    /* renamed from: d */
    private void m21330d() {
        m21331e();
        C10122Util.logWrite("stopAdvertising");
        BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f27052b;
        if (bluetoothLeAdvertiser != null) {
            try {
                bluetoothLeAdvertiser.stopAdvertising(this.f27061k);
                this.f27052b = null;
            } catch (Exception e) {
                C10122Util.logWrite("stopAdvertiser failed ： " + e.toString());
            }
        }
    }

    /* renamed from: e */
    private void m21331e() {
        C10122Util.logWrite("closeConnect");
        this.f27060j = null;
        BluetoothGattServer bluetoothGattServer = this.f27053c;
        if (bluetoothGattServer != null) {
            try {
                bluetoothGattServer.close();
            } catch (Exception e) {
                C10122Util.logWrite("closeConnect failed " + e.toString());
            }
            this.f27053c = null;
        }
    }

    /* renamed from: f */
    private void m21332f() {
        BluetoothListenerReceiver bluetoothListenerReceiver;
        Context context = this.f27058h;
        if (context != null && (bluetoothListenerReceiver = this.f27062l) != null) {
            try {
                try {
                    context.registerReceiver(bluetoothListenerReceiver, m21333g());
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                C10122Util.logWrite("registerReceiver crash " + e2.toString());
            }
        }
    }

    /* renamed from: g */
    private IntentFilter m21333g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        return intentFilter;
    }

    /* renamed from: h */
    private void m21334h() {
        BluetoothManager bluetoothManager;
        C10122Util.logWrite("addConnectService");
        Context context = this.f27058h;
        if (context != null && (bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth")) != null && this.f27057g != null) {
            BluetoothGattService bluetoothGattService = new BluetoothGattService(this.f27056f, 0);
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(this.f27057g, 2, 1));
            try {
                BluetoothGattServer openGattServer = bluetoothManager.openGattServer(this.f27058h, this.f27063m);
                this.f27053c = openGattServer;
                if (openGattServer != null) {
                    openGattServer.addService(bluetoothGattService);
                }
            } catch (Exception e) {
                C10122Util.logWrite("addConnectService failed " + e.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m21324b(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("##0.000000");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat.format(d);
    }
}
