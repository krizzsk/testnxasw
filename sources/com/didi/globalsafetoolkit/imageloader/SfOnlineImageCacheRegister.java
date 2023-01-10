package com.didi.globalsafetoolkit.imageloader;

import android.content.Context;
import com.didi.sdk.resource.warehouse.image.ICacheProvider;
import com.didi.sdk.resource.warehouse.image.OnlineImageCacheManager;
import com.didi.sdk.resource.warehouse.image.PriorityType;

public class SfOnlineImageCacheRegister {
    public static final String URL_BLUE_SHIELD_IN = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917171550.webp";
    public static final String URL_BLUE_SHIELD_OUT = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917171444.webp";
    public static final String URL_RECORD_OFF_IN = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180355.webp";
    public static final String URL_RECORD_OFF_OUT = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180348.webp";
    public static final String URL_RECORD_ON_IN = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180044.webp";
    public static final String URL_RECORD_ON_OUT = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180034.webp";
    public static final String URL_RED_CALL_IN = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175338.webp";
    public static final String URL_RED_CALL_OUT = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175305.webp";
    public static final String URL_WHITE_SHIELD_IN = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917174330.webp";
    public static final String URL_WHITE_SHIELD_OUT = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917174324.webp";
    public static final String URL_YELLOW_WARNING_IN = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175738.webp";
    public static final String URL_YELLOW_WARNING_OUT = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175729.webp";

    public static void register(Context context) {
        OnlineImageCacheManager instance = OnlineImageCacheManager.getInstance(context);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917171550.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917171444.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175338.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175305.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917174330.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917174324.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175738.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175729.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180355.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180348.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180044.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
        instance.register("https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180034.webp", PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_FRESCO);
    }

    public static String getUrl(String str, boolean z) {
        String str2;
        String str3 = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917171550.webp";
        String str4 = z ? str3 : "https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917171444.webp";
        char c = 65535;
        switch (str.hashCode()) {
            case -1955878649:
                if (str.equals("Normal")) {
                    c = 0;
                    break;
                }
                break;
            case -224957234:
                if (str.equals("Low_Medium_Risk")) {
                    c = 2;
                    break;
                }
                break;
            case 17323036:
                if (str.equals("Other_Recording_On")) {
                    c = 4;
                    break;
                }
                break;
            case 537013970:
                if (str.equals("Other_Recording_Off")) {
                    c = 5;
                    break;
                }
                break;
            case 1310068556:
                if (str.equals("High_Risk")) {
                    c = 3;
                    break;
                }
                break;
            case 1795442690:
                if (str.equals("Important")) {
                    c = 1;
                    break;
                }
                break;
        }
        if (c != 0) {
            if (c == 1) {
                str2 = z ? "https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917174330.webp" : "https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917174324.webp";
            } else if (c == 2) {
                str2 = z ? "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175738.webp" : "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175729.webp";
            } else if (c == 3) {
                str2 = z ? "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175338.webp" : "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027175305.webp";
            } else if (c == 4) {
                str2 = z ? "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180044.webp" : "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180034.webp";
            } else if (c != 5) {
                return str4;
            } else {
                str2 = z ? "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180355.webp" : "https://img0.didiglobal.com/static/quickbolt/anim_webp_20211027180348.webp";
            }
            return str2;
        }
        if (!z) {
            str3 = "https://img0.didiglobal.com/static/quickbolt/anim_webp_20210917171444.webp";
        }
        return str3;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getPlaceHolderRes(java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1955878649: goto L_0x003f;
                case -224957234: goto L_0x0035;
                case 17323036: goto L_0x002b;
                case 537013970: goto L_0x0021;
                case 1310068556: goto L_0x0017;
                case 1795442690: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0049
        L_0x000d:
            java.lang.String r0 = "Important"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x0017:
            java.lang.String r0 = "High_Risk"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 3
            goto L_0x004a
        L_0x0021:
            java.lang.String r0 = "Other_Recording_Off"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 5
            goto L_0x004a
        L_0x002b:
            java.lang.String r0 = "Other_Recording_On"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 4
            goto L_0x004a
        L_0x0035:
            java.lang.String r0 = "Low_Medium_Risk"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 2
            goto L_0x004a
        L_0x003f:
            java.lang.String r0 = "Normal"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 0
            goto L_0x004a
        L_0x0049:
            r6 = -1
        L_0x004a:
            r0 = 2131235499(0x7f0812ab, float:1.8087194E38)
            if (r6 == 0) goto L_0x006d
            if (r6 == r5) goto L_0x006a
            if (r6 == r4) goto L_0x0066
            if (r6 == r3) goto L_0x0062
            if (r6 == r2) goto L_0x005e
            if (r6 == r1) goto L_0x005a
            goto L_0x006d
        L_0x005a:
            r0 = 2131235612(0x7f08131c, float:1.8087423E38)
            goto L_0x006d
        L_0x005e:
            r0 = 2131235574(0x7f0812f6, float:1.8087346E38)
            goto L_0x006d
        L_0x0062:
            r0 = 2131235575(0x7f0812f7, float:1.8087348E38)
            goto L_0x006d
        L_0x0066:
            r0 = 2131235614(0x7f08131e, float:1.8087427E38)
            goto L_0x006d
        L_0x006a:
            r0 = 2131235613(0x7f08131d, float:1.8087425E38)
        L_0x006d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.globalsafetoolkit.imageloader.SfOnlineImageCacheRegister.getPlaceHolderRes(java.lang.String):int");
    }
}
