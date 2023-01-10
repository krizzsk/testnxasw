package com.didi.beatles.p101im.module.impl;

import android.text.TextUtils;
import com.didi.beatles.p101im.api.entity.IMConfig;
import com.didi.beatles.p101im.api.entity.IMConfigResponse;
import com.didi.beatles.p101im.api.entity.IMGetConfigRequest;
import com.didi.beatles.p101im.module.IIMGlobalModule;
import com.didi.beatles.p101im.module.IMBaseModule;
import com.didi.beatles.p101im.net.IMHttpManager;
import com.didi.beatles.p101im.net.IMNetCallback;
import com.didi.beatles.p101im.protocol.model.IMBottomGuideConfig;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.beatles.im.module.impl.IMGlobalModule */
public final class IMGlobalModule extends IMBaseModule implements IIMGlobalModule {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11137a = IMGlobalModule.class.getSimpleName();

    /* renamed from: b */
    private static final int f11138b = 3;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AtomicBoolean f11139c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicBoolean f11140d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AtomicInteger f11141e = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IMConfigResponse.Config f11142f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IMConfig f11143g;
    public Map<Integer, IMConfig> mBizConfigMap;

    public void onStop() {
    }

    protected IMGlobalModule(IMModelProvider iMModelProvider) {
        super(iMModelProvider);
    }

    public void onStart() {
        loadGlobalConfig(true);
    }

    public void loadGlobalConfig(boolean z) {
        if (this.f11139c.get()) {
            IMLog.m10021e(f11137a, "[loadGlobalConfig] is loading");
        } else if (!z && this.f11140d.get()) {
            IMLog.m10021e(f11137a, "[loadGlobalConfig] already loaded.");
        } else if (z || this.f11141e.get() <= 3) {
            this.f11139c.set(true);
            this.f11141e.getAndIncrement();
            IMHttpManager.getInstance().performCommonPost(new IMGetConfigRequest(), new IMNetCallback<IMConfigResponse>() {
                public void success(IMConfigResponse iMConfigResponse) {
                    if (iMConfigResponse != null && iMConfigResponse.isSuccess()) {
                        IMGlobalModule.this.f11141e.set(4);
                        IMGlobalModule.this.f11140d.set(true);
                        if (iMConfigResponse.body != null) {
                            IMConfig unused = IMGlobalModule.this.f11143g = iMConfigResponse.body.globalConfig;
                            IMConfigResponse.Config unused2 = IMGlobalModule.this.f11142f = iMConfigResponse.body.config;
                            IMGlobalModule.this.mBizConfigMap = new HashMap();
                            if (iMConfigResponse.body.bizConfigList != null) {
                                for (IMConfig next : iMConfigResponse.body.bizConfigList) {
                                    IMGlobalModule.this.mBizConfigMap.put(Integer.valueOf(next.businessId), next);
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    IMGlobalModule.this.f11139c.set(false);
                }

                public void failure(IOException iOException) {
                    IMLog.m10021e(IMGlobalModule.f11137a, "[failure]", iOException);
                    IMGlobalModule.this.f11139c.set(false);
                }
            });
        } else {
            IMLog.m10021e(f11137a, C4786I.m9980t("[loadGlobalConfig] reach max retry count -> ", Integer.valueOf(this.f11141e.get())));
        }
    }

    public IMConfig.EggsInfo getBusinessEggsInfo(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        IMLog.m10020d(f11137a, C4786I.m9980t("[getBusinessEggInfo] businessId=", Integer.valueOf(i), " |eid=", Integer.valueOf(i2)));
        IMConfig.EggsInfo eggsInfo = null;
        if (i <= 0 || i2 <= 0) {
            IMLog.m10021e(f11137a, C4786I.m9980t("[getBusinessEggInfo] invalid param: businessId=", Integer.valueOf(i), " |eid=", Integer.valueOf(i2)));
            return null;
        }
        Map<Integer, IMConfig> map = this.mBizConfigMap;
        if (map != null) {
            eggsInfo = m9646a(map.get(Integer.valueOf(i)), i2);
        }
        if (eggsInfo == null) {
            eggsInfo = m9646a(this.f11143g, i2);
        }
        IMLog.m10020d(f11137a, C4786I.m9980t("[getBusinessEggsInfo]  cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), " ====>", eggsInfo));
        return eggsInfo;
    }

    /* renamed from: a */
    private IMConfig.EggsInfo m9646a(IMConfig iMConfig, int i) {
        if (!(iMConfig == null || iMConfig.eggsConfig == null || iMConfig.eggsConfig.eggsInfoList == null)) {
            for (IMConfig.EggsInfo next : iMConfig.eggsConfig.eggsInfoList) {
                if (i == next.f10962id) {
                    return next;
                }
            }
        }
        return null;
    }

    public IMConfig.EggsInfo matchBusinessEggsInfo(int i, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        IMLog.m10020d(f11137a, C4786I.m9980t("[matchBusinessEggsInfo] businessId=", Integer.valueOf(i), " |content=", str));
        IMConfig.EggsInfo eggsInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<Integer, IMConfig> map = this.mBizConfigMap;
        if (map != null) {
            eggsInfo = m9647a(map.get(Integer.valueOf(i)), str);
        }
        if (eggsInfo == null) {
            eggsInfo = m9647a(this.f11143g, str);
        }
        IMLog.m10020d(f11137a, C4786I.m9980t("[matchBusinessEggInfo]  cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), " ====>", eggsInfo));
        return eggsInfo;
    }

    public List<IMBottomGuideConfig> getBtmGuideConfigList(int i) {
        IMConfig iMConfig = this.f11143g;
        if (iMConfig != null) {
            return iMConfig.btmGuideConfigList;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.get(java.lang.Integer.valueOf(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.didi.beatles.p101im.module.IMEmojiModule> getEmojiConfigList(int r2, java.lang.String r3) {
        /*
            r1 = this;
            java.util.Map<java.lang.Integer, com.didi.beatles.im.api.entity.IMConfig> r0 = r1.mBizConfigMap
            if (r0 == 0) goto L_0x001d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r2 = r0.get(r2)
            com.didi.beatles.im.api.entity.IMConfig r2 = (com.didi.beatles.p101im.api.entity.IMConfig) r2
            if (r2 == 0) goto L_0x001d
            java.util.Map<java.lang.String, java.util.List<com.didi.beatles.im.module.IMEmojiModule>> r0 = r2.emojiList
            if (r0 == 0) goto L_0x001d
            java.util.Map<java.lang.String, java.util.List<com.didi.beatles.im.module.IMEmojiModule>> r2 = r2.emojiList
            java.lang.Object r2 = r2.get(r3)
            java.util.List r2 = (java.util.List) r2
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            if (r2 != 0) goto L_0x0032
            com.didi.beatles.im.api.entity.IMConfig r0 = r1.f11143g
            if (r0 == 0) goto L_0x0032
            java.util.Map<java.lang.String, java.util.List<com.didi.beatles.im.module.IMEmojiModule>> r0 = r0.emojiList
            if (r0 == 0) goto L_0x0032
            com.didi.beatles.im.api.entity.IMConfig r2 = r1.f11143g
            java.util.Map<java.lang.String, java.util.List<com.didi.beatles.im.module.IMEmojiModule>> r2 = r2.emojiList
            java.lang.Object r2 = r2.get(r3)
            java.util.List r2 = (java.util.List) r2
        L_0x0032:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.module.impl.IMGlobalModule.getEmojiConfigList(int, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    private IMConfig.EggsInfo m9647a(IMConfig iMConfig, String str) {
        if (iMConfig == null || TextUtils.isEmpty(str) || iMConfig.eggsConfig == null || iMConfig.eggsConfig.enable != 1 || iMConfig.eggsConfig.eggsInfoList == null) {
            return null;
        }
        for (IMConfig.EggsInfo next : iMConfig.eggsConfig.eggsInfoList) {
            if (!TextUtils.isEmpty(next.patternMsg)) {
                boolean contains = str.contains(next.patternMsg);
                IMLog.m10020d(f11137a, C4786I.m9980t("[matchEggsInfo] input=", str, " |patternMsg=", next.patternMsg, " |matches=", Boolean.valueOf(contains)));
                if (contains) {
                    return next;
                }
            }
        }
        return null;
    }

    public IMConfigResponse.Config getCommonConfig() {
        return this.f11142f;
    }
}
