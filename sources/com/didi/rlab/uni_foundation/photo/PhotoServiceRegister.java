package com.didi.rlab.uni_foundation.photo;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.photo.model.PhotoModel;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p218io.flutter.plugin.common.BasicMessageChannel;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.common.StandardMessageCodec;

public class PhotoServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, PhotoService photoService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.PhotoService.startCamera", new StandardMessageCodec());
        if (photoService != null) {
            UniAPI.registerModule(photoService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    PhotoServiceRegister.m27876a(PhotoService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m27876a(PhotoService photoService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            photoService.startCamera(map.containsKey("model") ? PhotoModel.fromMap((Map) map.get("model")) : null);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.photo.PhotoServiceRegister", 34);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m27875a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
