package com.didichuxing.dfbasesdk.sensor;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;

public class SensorDelegate {

    /* renamed from: a */
    private static volatile Context f49323a;

    /* renamed from: b */
    private static int f49324b;

    @Deprecated
    public static String getError() {
        return "{}";
    }

    @Deprecated
    public static boolean hasCollected() {
        return false;
    }

    @Deprecated
    public static boolean isCollectingData() {
        return false;
    }

    public static void init(Context context) {
        if (f49323a == null && context != null) {
            f49323a = context.getApplicationContext();
            addSensorConfig(getAllSensors());
        }
    }

    public static void addSensorConfig(List<SensorConfig> list) {
        if (f49323a == null) {
        }
    }

    public static void onSdklaunch() {
        if (f49323a == null) {
        }
    }

    public static void onSdkPageStart() {
        f49324b = Math.max(f49324b + 1, 1);
        if (f49323a == null) {
        }
    }

    public static void onSdkPageStop() {
        f49324b = Math.max(f49324b - 1, 0);
        if (f49323a == null) {
        }
    }

    public static void onSdkFinish() {
        if (f49323a == null) {
        }
    }

    public static String getData() {
        if (f49323a == null) {
            return null;
        }
        return C16123b.m37004a(f49323a).mo122345c();
    }

    public static List<SensorConfig> getAllSensors() {
        LinkedList linkedList = new LinkedList();
        for (int i : SensorData.types) {
            SensorConfig sensorConfig = new SensorConfig();
            sensorConfig.type = i;
            linkedList.add(sensorConfig);
        }
        return linkedList;
    }
}
