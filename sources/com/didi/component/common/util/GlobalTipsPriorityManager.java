package com.didi.component.common.util;

import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GlobalTipsPriorityManager {

    /* renamed from: a */
    private static GlobalTipsPriorityManager f13600a = new GlobalTipsPriorityManager();

    /* renamed from: b */
    private LinkedList<ITipsHandler> f13601b = new LinkedList<>();

    /* renamed from: c */
    private LinkedList<ITipsHandler> f13602c = new LinkedList<>();

    /* renamed from: d */
    private Runnable f13603d = new Runnable() {
        public void run() {
            GlobalTipsPriorityManager.this.m11372b();
        }
    };

    /* renamed from: com.didi.component.common.util.GlobalTipsPriorityManager$ID */
    public static class C5384ID {
        public static final int DIALOG_ID_BIND_CARD_GUIDE = 10;
        public static final int DIALOG_ID_FREEPICKUP_COMP_ADVICE = 11;
        public static final int TIPS_ID_BOOKING_COUPON = 3;
        public static final int TIPS_ID_BOOKING_GUIDE = 1;
        public static final int TIPS_ID_NO_QUOTA = 5;
        public static final int TIPS_ID_PAY_WAY_CHANGED_TO_ONLINE = 9;
        public static final int TIPS_ID_PAY_WAY_COUPON = 2;
        public static final int TIPS_ID_PAY_WAY_COUPON_NEW = 7;
        public static final int TIPS_ID_PAY_WAY_QUOTA = 6;
        public static final int TIPS_ID_QUOTA_DETAIL = 4;
    }

    public interface ITipsHandler {
        void dismiss();

        /* renamed from: id */
        int mo51951id();

        int level();

        boolean show();
    }

    public static class Level {
        public static final int DIALOG_LEVEL_BIND_CARD_GUIDE = 700;
        public static final int TIPS_LEVEL_BOOKING_COUPON = 400;
        public static final int TIPS_LEVEL_BOOKING_GUIDE = 300;
        public static final int TIPS_LEVEL_NO_QUOTA = 200;
        public static final int TIPS_LEVEL_PAY_WAY_CHANGED_TO_ONLINE = 500;
        public static final int TIPS_LEVEL_PAY_WAY_COUPON = 600;
        public static final int TIPS_LEVEL_PAY_WAY_COUPON_NEW = 600;
        public static final int TIPS_LEVEL_PAY_WAY_QUOtA = 700;
        public static final int TIPS_LEVEL_QUOTA_DETAIL = 100;
        public static final int TIPS_LEVEL_SELECT_FREEPICKUP_COMPANY = 255;
    }

    private class TipsHandlerProxy implements ITipsHandler {
        ITipsHandler mHandlerRef;

        public TipsHandlerProxy(ITipsHandler iTipsHandler) {
            this.mHandlerRef = iTipsHandler;
        }

        /* renamed from: id */
        public int mo51951id() {
            ITipsHandler iTipsHandler = this.mHandlerRef;
            if (iTipsHandler != null) {
                return iTipsHandler.mo51951id();
            }
            return 0;
        }

        public int level() {
            ITipsHandler iTipsHandler = this.mHandlerRef;
            if (iTipsHandler != null) {
                return iTipsHandler.level();
            }
            return 0;
        }

        public boolean show() {
            ITipsHandler iTipsHandler = this.mHandlerRef;
            if (iTipsHandler != null) {
                return iTipsHandler.show();
            }
            return false;
        }

        public void dismiss() {
            ITipsHandler iTipsHandler = this.mHandlerRef;
            if (iTipsHandler != null) {
                iTipsHandler.dismiss();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                TipsHandlerProxy tipsHandlerProxy = (TipsHandlerProxy) obj;
                ITipsHandler iTipsHandler = this.mHandlerRef;
                if (iTipsHandler == null || tipsHandlerProxy.mHandlerRef == null || iTipsHandler.mo51951id() != tipsHandlerProxy.mHandlerRef.mo51951id()) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            ITipsHandler iTipsHandler = this.mHandlerRef;
            return iTipsHandler != null ? iTipsHandler.hashCode() : hashCode();
        }

        public String toString() {
            if (this.mHandlerRef == null) {
                return super.toString();
            }
            return "[id: " + this.mHandlerRef.mo51951id() + ", level: " + this.mHandlerRef.level() + Const.jaRight;
        }
    }

    public static GlobalTipsPriorityManager getInstance() {
        return f13600a;
    }

    private GlobalTipsPriorityManager() {
    }

    public void consume(ITipsHandler iTipsHandler) {
        if (iTipsHandler != null) {
            TipsHandlerProxy tipsHandlerProxy = new TipsHandlerProxy(iTipsHandler);
            if (!this.f13601b.contains(tipsHandlerProxy) && !this.f13602c.contains(tipsHandlerProxy)) {
                this.f13601b.add(tipsHandlerProxy);
                m11369a();
            }
        }
    }

    public void remove(ITipsHandler iTipsHandler) {
        if (iTipsHandler != null && this.f13602c.contains(iTipsHandler)) {
            this.f13602c.remove(iTipsHandler);
        }
    }

    public void remove(int i) {
        m11371a(this.f13602c, i);
        m11371a(this.f13601b, i);
    }

    /* renamed from: a */
    private void m11371a(List<ITipsHandler> list, int i) {
        ArrayList<ITipsHandler> arrayList = null;
        for (ITipsHandler next : list) {
            if (next.mo51951id() == i) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
            }
        }
        if (arrayList != null) {
            for (ITipsHandler remove : arrayList) {
                list.remove(remove);
            }
        }
    }

    public boolean isShowing(int i) {
        Iterator it = this.f13602c.iterator();
        while (it.hasNext()) {
            if (((ITipsHandler) it.next()).mo51951id() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean isWaiting(int i) {
        Iterator it = this.f13601b.iterator();
        while (it.hasNext()) {
            if (((ITipsHandler) it.next()).mo51951id() == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m11369a() {
        UiThreadHandler.removeCallbacks(this.f13603d);
        UiThreadHandler.post(this.f13603d);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11372b() {
        Collections.sort(this.f13601b, new Comparator<ITipsHandler>() {
            public int compare(ITipsHandler iTipsHandler, ITipsHandler iTipsHandler2) {
                return iTipsHandler2.level() - iTipsHandler.level();
            }
        });
        List<ITipsHandler> c = m11373c();
        if (c.size() != 0) {
            int i = 0;
            int level = c.get(0).level();
            if (this.f13602c.size() != 0) {
                i = this.f13602c.get(0).level();
            }
            if (i <= level) {
                if (i < level) {
                    for (ITipsHandler dismiss : new ArrayList(this.f13602c)) {
                        dismiss.dismiss();
                    }
                    this.f13602c.clear();
                }
                for (ITipsHandler next : c) {
                    if (next.show()) {
                        this.f13602c.add(next);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private List<ITipsHandler> m11373c() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= 0 && this.f13601b.size() > 0) {
            ITipsHandler removeFirst = this.f13601b.removeFirst();
            if (removeFirst != null && (i = removeFirst.level()) > 0) {
                arrayList.add(removeFirst);
            }
        }
        while (i > 0 && this.f13601b.size() > 0) {
            ITipsHandler removeFirst2 = this.f13601b.removeFirst();
            if (removeFirst2 != null && removeFirst2.level() == i) {
                arrayList.add(removeFirst2);
            }
        }
        this.f13601b.clear();
        return arrayList;
    }
}
