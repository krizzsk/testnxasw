package com.threatmetrix.TrustDefender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class qqyyyy {
    private static final Lock b006600660066f0066f = new ReentrantLock();
    private static final qqyyyy bf00660066f0066f = new qqyyyy();
    public static final List<tqqqqt> bfff00660066f = new ArrayList();
    public String b0066ff00660066f;

    private qqyyyy() {
    }

    private void b00790079y007900790079(Map<String, String> map) {
        if (yqqyqq.b0069ii0069i0069(this.b0066ff00660066f)) {
            map.put(yyyyyq.CRASH_LOG_STRING.b00780078x00780078x(), yqqyqq.biii006900690069(this.b0066ff00660066f, 1024));
        }
    }

    public static qqyyyy b0079y0079007900790079() {
        return bf00660066f0066f;
    }

    private void byy0079007900790079(tqqqqt tqqqqt) {
        String b0079yyyyy = tqqqqt.b0079yyyyy();
        if (yqqyqq.b0069ii0069i0069(b0079yyyyy)) {
            this.b0066ff00660066f += b0079yyyyy;
        }
    }

    public void b0071qqqqq() {
        try {
            b006600660066f0066f.lock();
            bfff00660066f.clear();
            bfff00660066f.add(new qyqqyy(0));
            bfff00660066f.add(new kjjjkj(8));
            bfff00660066f.add(new ttqtqt(0));
            bfff00660066f.add(new qqyyqq(qqqqqy.b0061a00610061aa));
            bfff00660066f.add(new qtttqt(16));
            bfff00660066f.add(new qtqtqt(0));
            bfff00660066f.add(new qqyqyq(2048));
            bfff00660066f.add(new ttqqtt(0));
            bfff00660066f.add(new tqttqt(0));
            bfff00660066f.add(new qyyqqy(32768));
            bfff00660066f.add(new qqyqqq(qqqqqy.b00610061a0061aa));
            bfff00660066f.add(new yqyqyq(262144));
            bfff00660066f.add(new qyyyqq(qqqqqy.b0065eee00650065, false, false));
            bfff00660066f.add(new qqtqqt(536870912));
            bfff00660066f.add(new tqtqqq(4294967296L));
            bfff00660066f.add(new yyqqqq(1125899906842624L));
            bfff00660066f.add(new tttqqt(0));
            bfff00660066f.add(new qqtttt(0));
            bfff00660066f.add(new qtqtqq(qqqqqy.ba006100610061aa));
            bfff00660066f.add(new tqqtqt(0, false, false));
            yqyyqy yqyyqy = new yqyyqy(qqqqqy.bee0065e00650065, false, false);
            yqyyqy.bvv0076007600760076(new qqtqqq(131072));
            yqyyqy.bvv0076007600760076(new qttqqt(0));
            bfff00660066f.add(yqyyqy);
            bfff00660066f.add(new qyyyyq(qqqqqy.b00650065ee00650065, false, false));
            bfff00660066f.add(new jkkkjj(0, true, false));
            bfff00660066f.add(new qqqqtt(4194304, true, false));
            bfff00660066f.add(new yqqqyy(0, true, false));
            bfff00660066f.add(new yqqyyq(16384, true, false));
            yqyqqq yqyqqq = new yqyqqq(qqqqqy.b0065e0065e00650065, true, true);
            yqyqqq.bvv0076007600760076(new yyqyyq(0, true, true));
            yqyqqq.bvv0076007600760076(new tqqqtt(2097152, true, true));
            bfff00660066f.add(yqyqqq);
        } finally {
            b006600660066f0066f.unlock();
        }
    }

    public void bq0071qqqq(long j, ttqqqt ttqqqt, boolean z, boolean z2) throws InterruptedException {
        try {
            b006600660066f0066f.lock();
            this.b0066ff00660066f = "";
            for (tqqqqt next : bfff00660066f) {
                if (next != null) {
                    next.bv00760076007600760076(j, ttqqqt, z, z2);
                    byy0079007900790079(next);
                }
            }
        } finally {
            b006600660066f0066f.unlock();
        }
    }

    public Map<String, String> by00790079007900790079(long j, boolean z) {
        try {
            b006600660066f0066f.lock();
            HashMap hashMap = new HashMap();
            for (tqqqqt next : bfff00660066f) {
                if (next != null) {
                    next.by0079yyyy(j, hashMap, z);
                }
            }
            b00790079y007900790079(hashMap);
            return hashMap;
        } finally {
            b006600660066f0066f.unlock();
        }
    }
}
