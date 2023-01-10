package com.didi.map.global.sdk.movement.sensor;

import com.didi.common.map.util.DLog;

public class PdrPointBounds {
    public int count = 0;
    public int errCount = 0;

    /* renamed from: lt */
    public PdrPoint f30194lt;

    /* renamed from: rb */
    public PdrPoint f30195rb;

    public void append(PdrPoint pdrPoint) {
        if (this.count <= 0) {
            this.f30194lt = new PdrPoint(pdrPoint);
            this.f30195rb = new PdrPoint(pdrPoint);
            this.count = 1;
        } else if (PdrPoint.getDistanceBetweenPoints(pdrPoint, getCenter()) < 3.0f) {
            this.f30194lt.f30192x = Math.min(pdrPoint.f30192x, this.f30194lt.f30192x);
            this.f30194lt.f30193y = Math.max(pdrPoint.f30193y, this.f30194lt.f30193y);
            this.f30195rb.f30192x = Math.max(pdrPoint.f30192x, this.f30194lt.f30192x);
            this.f30195rb.f30193y = Math.min(pdrPoint.f30193y, this.f30194lt.f30193y);
            this.count++;
            int i = this.errCount;
            if (i > 0) {
                this.errCount = i - 1;
            }
        } else {
            int i2 = this.errCount + 1;
            this.errCount = i2;
            if (i2 >= 3) {
                DLog.m10773d("ccc", "累计失败3次了", new Object[0]);
                this.f30194lt = new PdrPoint(pdrPoint);
                this.f30195rb = new PdrPoint(pdrPoint);
                this.count = 1;
                this.errCount = 0;
            }
        }
    }

    public PdrPoint getCenter() {
        return new PdrPoint((this.f30194lt.f30192x + this.f30195rb.f30192x) / 2.0f, (this.f30194lt.f30193y + this.f30195rb.f30193y) / 2.0f);
    }
}
