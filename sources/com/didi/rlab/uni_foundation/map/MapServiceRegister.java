package com.didi.rlab.uni_foundation.map;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.HashMap;
import java.util.Map;
import p218io.flutter.plugin.common.BasicMessageChannel;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.common.StandardMessageCodec;

public class MapServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, MapService mapService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.setMapRecenter", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27835l(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.setMapOverView", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27834k(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.setMapBestView", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27833j(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.setMapPadding", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27832i(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.clearMapAllElement", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27831h(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.addMapAnnotations", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27830g(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.addMapSearchRoute", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27829f(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.makeCenterCoordinate", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27828e(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.updateUserLocation", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27827d(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.updateHeadingAngle", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27826c(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.getMapZoomLevel", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27825b(MapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapService.isDowngradeMap", new StandardMessageCodec());
        if (mapService != null) {
            UniAPI.registerModule(mapService);
            basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapServiceRegister.m27824a(MapService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel12.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static /* synthetic */ void m27835l(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapService.setMapRecenter();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 32);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static /* synthetic */ void m27834k(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapService.setMapOverView();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 53);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static /* synthetic */ void m27833j(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapService.setMapBestView();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 74);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static /* synthetic */ void m27832i(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            double d = 0.0d;
            double doubleValue = map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d;
            double doubleValue2 = map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d;
            double doubleValue3 = map.containsKey("bottom") ? ((Double) map.get("bottom")).doubleValue() : 0.0d;
            if (map.containsKey("right")) {
                d = ((Double) map.get("right")).doubleValue();
            }
            mapService.setMapPadding(doubleValue, doubleValue2, doubleValue3, d);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 99);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static /* synthetic */ void m27831h(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapService.clearMapAllElement();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 120);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static /* synthetic */ void m27830g(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapService.addMapAnnotations(map.containsKey("annotationsModel") ? MapServiceAnnotationDataModel.fromMap((Map) map.get("annotationsModel")) : null);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 142);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ void m27829f(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapService.addMapSearchRoute(map.containsKey("tripModel") ? MapServiceTripModel.fromMap((Map) map.get("tripModel")) : null);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 164);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m27828e(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapService.makeCenterCoordinate();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 185);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m27827d(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            double d = 0.0d;
            double doubleValue = map.containsKey("lat") ? ((Double) map.get("lat")).doubleValue() : 0.0d;
            if (map.containsKey("lng")) {
                d = ((Double) map.get("lng")).doubleValue();
            }
            mapService.updateUserLocation(doubleValue, d);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 208);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m27826c(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapService.updateHeadingAngle(map.containsKey(BlocksConst.WIDGET_PARAMS_ANGLE) ? ((Double) map.get(BlocksConst.WIDGET_PARAMS_ANGLE)).doubleValue() : 0.0d);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 230);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m27825b(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", Long.valueOf(mapService.getMapZoomLevel()));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 251);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m27824a(MapService mapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", Boolean.valueOf(mapService.isDowngradeMap()));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.map.MapServiceRegister", 272);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m27823a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
