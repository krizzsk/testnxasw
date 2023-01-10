package com.didichuxing.bigdata.p174dp.locsdk.biz;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.biz.BizManager */
public class BizManager implements BizStateListener {

    /* renamed from: a */
    private Handler f48402a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C15913a f48403b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<BizStateListener> f48404c;

    private BizManager() {
        this.f48402a = new Handler(Looper.getMainLooper());
        this.f48404c = new ArrayList();
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.biz.BizManager$SingleHolder */
    private static class SingleHolder {
        static BizManager INSTANCE = new BizManager();

        private SingleHolder() {
        }
    }

    public static BizManager getIntance() {
        return SingleHolder.INSTANCE;
    }

    public void init(final Context context) {
        m36244a((Runnable) new Runnable() {
            public void run() {
                BizClientType bizClientType = BizManager.this.getBizClientType(context);
                if (C159115.$SwitchMap$com$didichuxing$bigdata$dp$locsdk$biz$BizClientType[bizClientType.ordinal()] == 1) {
                    C15913a unused = BizManager.this.f48403b = new DriverCommonBizAdapter();
                }
                DLog.m36225d("BizManager.init bizClientCategory=" + bizClientType + " bizAdapterImpl=" + BizManager.this.f48403b);
                if (BizManager.this.f48403b != null) {
                    BizManager.this.f48403b.mo120988a(context);
                }
            }
        });
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.biz.BizManager$5 */
    static /* synthetic */ class C159115 {
        static final /* synthetic */ int[] $SwitchMap$com$didichuxing$bigdata$dp$locsdk$biz$BizClientType;

        static {
            int[] iArr = new int[BizClientType.values().length];
            $SwitchMap$com$didichuxing$bigdata$dp$locsdk$biz$BizClientType = iArr;
            try {
                iArr[BizClientType.DRIVER_COMMON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void registerBizStateListener(final BizStateListener bizStateListener) {
        m36244a((Runnable) new Runnable() {
            public void run() {
                DLog.m36225d("BizManager.registerBizStateListener bizAdapterImpl=" + BizManager.this.f48403b);
                if (BizManager.this.f48403b != null) {
                    if (BizManager.this.f48404c.size() == 0) {
                        BizManager.this.f48403b.mo120989a((BizStateListener) BizManager.this);
                    }
                    BizManager.this.f48404c.add(bizStateListener);
                }
            }
        });
    }

    public void unregisterBizStateListener(final BizStateListener bizStateListener) {
        m36244a((Runnable) new Runnable() {
            public void run() {
                DLog.m36225d("BizManager.unregisterBizStateListener bizAdapterImpl=" + BizManager.this.f48403b);
                if (BizManager.this.f48403b != null) {
                    BizManager.this.f48404c.remove(bizStateListener);
                    if (BizManager.this.f48404c.size() == 0) {
                        BizManager.this.f48403b.mo120989a((BizStateListener) null);
                    }
                }
            }
        });
    }

    public void onBizStateChanged(final BizState bizState, final String str, final String str2) {
        m36244a((Runnable) new Runnable() {
            public void run() {
                for (BizStateListener bizStateListener : BizManager.this.f48404c) {
                    if (bizStateListener != null) {
                        bizStateListener.onBizStateChanged(bizState, str, str2);
                    }
                }
            }
        });
    }

    public BizClientType getBizClientType(Context context) {
        String packageName = context.getPackageName();
        if ("com.sdu.didi.gsui".equals(packageName)) {
            return BizClientType.DRIVER_COMMON;
        }
        if (!m36245a(context) || !"com.didichuxing.bigdata.dp.locsdkdemo".equals(packageName)) {
            return BizClientType.UNKNOWN;
        }
        return BizClientType.DRIVER_COMMON;
    }

    /* renamed from: a */
    private boolean m36245a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? false : true;
    }

    /* renamed from: a */
    private void m36244a(Runnable runnable) {
        if (runnable != null) {
            this.f48402a.post(runnable);
        }
    }
}
