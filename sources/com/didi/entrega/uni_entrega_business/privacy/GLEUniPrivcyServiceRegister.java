package com.didi.entrega.uni_entrega_business.privacy;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.privacy.GLEUniPrivcyService;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p218io.flutter.plugin.common.BasicMessageChannel;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniPrivcyServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, GLEUniPrivcyService gLEUniPrivcyService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniPrivcyService.isLocalPrivacyEnable", new StandardMessageCodec());
        if (gLEUniPrivcyService != null) {
            UniAPI.registerModule(gLEUniPrivcyService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniPrivcyServiceRegister.m18919c(GLEUniPrivcyService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniPrivcyService.isGpsPrivacyEnabled", new StandardMessageCodec());
        if (gLEUniPrivcyService != null) {
            UniAPI.registerModule(gLEUniPrivcyService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniPrivcyServiceRegister.m18917b(GLEUniPrivcyService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniPrivcyService.setPrivacy", new StandardMessageCodec());
        if (gLEUniPrivcyService != null) {
            UniAPI.registerModule(gLEUniPrivcyService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniPrivcyServiceRegister.m18915a(GLEUniPrivcyService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m18919c(GLEUniPrivcyService gLEUniPrivcyService, Object obj, BasicMessageChannel.Reply reply) {
        try {
            Map map = (Map) obj;
            gLEUniPrivcyService.isLocalPrivacyEnable(new GLEUniPrivcyService.Result(new HashMap(), reply) {
                public final /* synthetic */ Map f$0;
                public final /* synthetic */ BasicMessageChannel.Reply f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void success(Object obj) {
                    GLEUniPrivcyServiceRegister.m18920c(this.f$0, this.f$1, (Boolean) obj);
                }
            });
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.privacy.GLEUniPrivcyServiceRegister", 31);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m18920c(Map map, BasicMessageChannel.Reply reply, Boolean bool) {
        map.put("result", bool);
        reply.reply(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m18917b(GLEUniPrivcyService gLEUniPrivcyService, Object obj, BasicMessageChannel.Reply reply) {
        try {
            Map map = (Map) obj;
            gLEUniPrivcyService.isGpsPrivacyEnabled(new GLEUniPrivcyService.Result(new HashMap(), reply) {
                public final /* synthetic */ Map f$0;
                public final /* synthetic */ BasicMessageChannel.Reply f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void success(Object obj) {
                    GLEUniPrivcyServiceRegister.m18918b(this.f$0, this.f$1, (Boolean) obj);
                }
            });
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.privacy.GLEUniPrivcyServiceRegister", 50);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m18918b(Map map, BasicMessageChannel.Reply reply, Boolean bool) {
        map.put("result", bool);
        reply.reply(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m18915a(GLEUniPrivcyService gLEUniPrivcyService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            long j = 0;
            long longValue = map.containsKey("state") ? ((Number) map.get("state")).longValue() : 0;
            if (map.containsKey("type")) {
                j = ((Number) map.get("type")).longValue();
            }
            gLEUniPrivcyService.setPrivacy(longValue, j, new GLEUniPrivcyService.Result(hashMap, reply) {
                public final /* synthetic */ Map f$0;
                public final /* synthetic */ BasicMessageChannel.Reply f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void success(Object obj) {
                    GLEUniPrivcyServiceRegister.m18916a(this.f$0, this.f$1, (Boolean) obj);
                }
            });
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.privacy.GLEUniPrivcyServiceRegister", 71);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m18916a(Map map, BasicMessageChannel.Reply reply, Boolean bool) {
        map.put("result", bool);
        reply.reply(map);
    }

    /* renamed from: a */
    private static Map<String, Object> m18914a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
