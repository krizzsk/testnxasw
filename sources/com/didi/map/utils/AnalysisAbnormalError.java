package com.didi.map.utils;

public class AnalysisAbnormalError {

    /* renamed from: a */
    private int f31478a;

    /* renamed from: b */
    private int f31479b;

    /* renamed from: c */
    private AbnormalErrorCallBack f31480c;

    public interface AbnormalErrorCallBack {
        void errorInfo(int i);
    }

    public void setAnalysisAbnormalCallBack(AbnormalErrorCallBack abnormalErrorCallBack) {
        this.f31480c = abnormalErrorCallBack;
    }

    public void handle(CarAnimData carAnimData) {
        if (carAnimData != null) {
            m24032c(carAnimData);
            m24033d(carAnimData);
            m24030a(carAnimData);
            m24031b(carAnimData);
        }
    }

    /* renamed from: a */
    private void m24030a(CarAnimData carAnimData) {
        AbnormalErrorCallBack abnormalErrorCallBack;
        if (carAnimData.animDistance >= 100.0d && carAnimData.animDistance < 200.0d && (abnormalErrorCallBack = this.f31480c) != null) {
            abnormalErrorCallBack.errorInfo(2);
        }
    }

    /* renamed from: b */
    private void m24031b(CarAnimData carAnimData) {
        AbnormalErrorCallBack abnormalErrorCallBack;
        if (carAnimData.animDistance >= 200.0d && (abnormalErrorCallBack = this.f31480c) != null) {
            abnormalErrorCallBack.errorInfo(1);
        }
    }

    /* renamed from: c */
    private void m24032c(CarAnimData carAnimData) {
        if (carAnimData.ntpTimestamp - carAnimData.gpsTime > 10) {
            this.f31478a++;
        } else {
            this.f31478a = 0;
        }
        if (this.f31478a >= 3) {
            AbnormalErrorCallBack abnormalErrorCallBack = this.f31480c;
            if (abnormalErrorCallBack != null) {
                abnormalErrorCallBack.errorInfo(4);
            }
            this.f31478a = 0;
        }
    }

    /* renamed from: d */
    private void m24033d(CarAnimData carAnimData) {
        if ((carAnimData.type == 1 || carAnimData.type == 2) && carAnimData.animDistance == 0.0d) {
            this.f31479b++;
        } else {
            this.f31479b = 0;
        }
        if (this.f31479b >= 30) {
            AbnormalErrorCallBack abnormalErrorCallBack = this.f31480c;
            if (abnormalErrorCallBack != null) {
                abnormalErrorCallBack.errorInfo(3);
            }
            this.f31479b = 0;
        }
    }

    public static class CarAnimData {
        public double animDistance = -1.0d;
        public long gpsTime;
        public long ntpTimestamp;
        public int type;

        public CarAnimData(int i, long j, long j2, double d) {
            this.type = i;
            this.gpsTime = j;
            this.ntpTimestamp = j2;
            this.animDistance = d;
        }
    }
}
