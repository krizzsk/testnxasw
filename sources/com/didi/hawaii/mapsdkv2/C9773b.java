package com.didi.hawaii.mapsdkv2;

import android.content.Context;
import com.didi.hawaii.log.HWThreadPool;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didi.hawaii.mapsdkv2.core.BaseMapData;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.GLHttpClient;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.MapContext;
import com.didi.hawaii.mapsdkv2.core.MapDataUpdateHandler;
import com.didi.hawaii.utils.StringUtil;
import com.didi.map.alpha.adapt.MapUtil;
import com.didi.map.common.utils.MapSerializeUtil;
import com.didi.map.constant.HWNavUrls;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.didi.hawaii.mapsdkv2.b */
/* compiled from: HWMapDataHandler */
class C9773b implements MapDataUpdateHandler {

    /* renamed from: a */
    private static final String f26027a = "HWMapDataHandler";

    /* renamed from: b */
    private static final String f26028b = ".opb";

    /* renamed from: c */
    private static final String f26029c = HWMapConstant.HTTP.getTileHost();

    /* renamed from: d */
    private static final String f26030d = HWMapConstant.HTTP.getTrafficHost();

    /* renamed from: e */
    private static final String f26031e = (f26029c + HWMapConstant.PATH.MAP_TILE_PATH);

    /* renamed from: f */
    private static final String f26032f = ("userid=DIDI-MAPSDK&pf=Android&sdkv=5766&imei=" + MapUtil.getIMei());

    /* renamed from: g */
    private static final String f26033g = (f26031e + f26032f + ParamKeys.SIGN_AND);

    /* renamed from: h */
    private static final DateFormat f26034h = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINA);

    /* renamed from: i */
    private boolean f26035i = true;

    /* renamed from: j */
    private final StringBuilder f26036j = new StringBuilder(128);

    /* renamed from: k */
    private final StringBuilder f26037k = new StringBuilder(128);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final GLHttpClient f26038l;

    /* renamed from: m */
    private final Context f26039m;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m20580a() {
        return HWNavUrls.DidiRoadCloseUrl;
    }

    C9773b(GLViewManager gLViewManager) {
        this.f26038l = gLViewManager.getMapContext().getHttpClient();
        this.f26039m = gLViewManager.getMapContext().getAndroidContext();
    }

    public int onUpdateTrafficData(GLBaseMapView gLBaseMapView, BaseMapData baseMapData) {
        int round = Math.round(gLBaseMapView.getScaleLevel()) - 1;
        int width = gLBaseMapView.getWidth();
        int height = gLBaseMapView.getHeight();
        if (width == 0 || height == 0) {
            return 500;
        }
        byte[] bArr = new byte[15616];
        int fetchTrafficBlockData = baseMapData.fetchTrafficBlockData(bArr, round, 0, 0, width, height);
        if (fetchTrafficBlockData == 0) {
            return 3000;
        }
        try {
            GLHttpClient.Res doGet = this.f26038l.doGet(m20583a(gLBaseMapView.getMapContext(), m20584a(bArr, fetchTrafficBlockData), this.f26037k, baseMapData.getTrafficUpdateUrl()));
            if (doGet == null || doGet.bytes == null) {
                return 3000;
            }
            return m20578a(baseMapData.refreshTrafficData(doGet.bytes, bArr, fetchTrafficBlockData));
        } catch (Exception e) {
            e.printStackTrace();
            return 3000;
        }
    }

    /* renamed from: a */
    private int m20578a(int i) {
        if (this.f26035i) {
            this.f26035i = false;
            return 500;
        }
        if (i < 3) {
            i = 3;
        } else if (i > 180) {
            i = 180;
        }
        return i * 1000;
    }

    public void onUpdateBaseMapData(GLBaseMapView gLBaseMapView, BaseMapData baseMapData, String str) {
        HWThreadPool.execute(new HWMapDataHandler$1(this, gLBaseMapView.getLanguage(), str, baseMapData));
    }

    /* renamed from: a */
    private static String m20583a(MapContext mapContext, String str, StringBuilder sb, String str2) {
        sb.setLength(0);
        if (str2 == null || str2.length() <= 0) {
            sb.append(f26030d);
            sb.append(HWMapConstant.PATH.TRAFFIC_RENDER_PATH);
        } else {
            sb.append(str2);
            sb.append("?");
        }
        sb.append("&userid=DIDI-MAPSDK&pf=Android&sdkv=");
        sb.append("5766");
        sb.append("&imei=");
        sb.append(MapUtil.getIMei(mapContext.getAndroidContext()));
        sb.append("&attime=");
        sb.append(f26034h.format(new Date()));
        sb.append(str);
        return sb.toString();
    }

    public void onDownloadDynamicLayer(GLBaseMapView gLBaseMapView, BaseMapData baseMapData, boolean z, String str, byte[] bArr) {
        HWThreadPool.execute(new HWMapDataHandler$2(this, str, z, bArr, gLBaseMapView, baseMapData));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized String m20581a(int i, String str) {
        if (!str.startsWith("https")) {
            if (!str.startsWith("http")) {
                this.f26036j.setLength(0);
                if (str.endsWith(f26028b)) {
                    StringBuilder sb = this.f26036j;
                    sb.append(f26029c);
                    sb.append("/");
                    sb.append(str);
                } else {
                    StringBuilder sb2 = this.f26036j;
                    sb2.append(f26033g);
                    sb2.append(str);
                    sb2.append("&lug=");
                    sb2.append(i);
                }
                return this.f26036j.toString();
            }
        }
        return str + "&userid=DIDI-MAPSDK&pf=Android&sdkv=5766&ddfp=" + MapUtil.getIMei();
    }

    /* renamed from: a */
    private static String m20584a(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int bytesToInt = MapSerializeUtil.bytesToInt(bArr, i2);
            int i4 = i2 + 4;
            int bytesToInt2 = MapSerializeUtil.bytesToInt(bArr, i4);
            int i5 = i4 + 4;
            int bytesToInt3 = MapSerializeUtil.bytesToInt(bArr, i5);
            int i6 = i5 + 4 + 16;
            String bytesToString_urf8 = MapSerializeUtil.bytesToString_urf8(bArr, i6, 33);
            i2 = i6 + 33 + 3;
            if (StringUtil.isEmpty(bytesToString_urf8)) {
                bytesToString_urf8 = "0";
            }
            if (i3 == 0) {
                sb.append("&op=mult_vevtor_tile&tiles=");
                sb.append(bytesToInt);
                sb.append(",");
                sb.append(bytesToInt2);
                sb.append(",");
                sb.append(bytesToInt3);
                sb.append(",");
                sb.append(bytesToString_urf8);
                sb.append(";");
            } else {
                sb.append(bytesToInt);
                sb.append(",");
                sb.append(bytesToInt2);
                sb.append(",");
                sb.append(bytesToInt3);
                sb.append(",");
                sb.append(bytesToString_urf8);
                sb.append(";");
            }
        }
        return sb.toString();
    }
}
