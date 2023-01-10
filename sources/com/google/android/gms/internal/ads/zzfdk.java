package com.google.android.gms.internal.ads;

import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfdk {
    public final String zzA;
    public final zzcdn zzB;
    public final String zzC;
    public final JSONObject zzD;
    public final JSONObject zzE;
    public final String zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final String zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final int zzR;
    public final int zzS;
    public final boolean zzT;
    public final boolean zzU;
    public final String zzV;
    public final zzfei zzW;
    public final boolean zzX;
    public final boolean zzY;
    public final int zzZ;
    public final List zza;
    public final String zzaa;
    public final int zzab;
    public final String zzac;
    public final boolean zzad;
    public final zzbzi zzae;
    public final boolean zzaf;
    public final zzs zzag;
    public final String zzah;
    public final boolean zzai;
    public final JSONObject zzaj;
    public final boolean zzak;
    public final JSONObject zzal;
    public final boolean zzam;
    public final String zzan;
    public final boolean zzao;
    public final String zzap;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final List zze;
    public final int zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final List zzj;
    public final String zzk;
    public final String zzl;
    public final zzcce zzm;
    public final List zzn;
    public final List zzo;
    public final List zzp;
    public final List zzq;
    public final int zzr;
    public final List zzs;
    public final zzfdp zzt;
    public final List zzu;
    public final List zzv;
    public final JSONObject zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzfdk(android.util.JsonReader r77) throws java.lang.IllegalStateException, java.io.IOException, org.json.JSONException, java.lang.NumberFormatException {
        /*
            r76 = this;
            r0 = r76
            r76.<init>()
            java.util.List r1 = java.util.Collections.emptyList()
            java.util.List r2 = java.util.Collections.emptyList()
            java.util.List r3 = java.util.Collections.emptyList()
            java.util.List r4 = java.util.Collections.emptyList()
            java.util.List r5 = java.util.Collections.emptyList()
            java.util.List r6 = java.util.Collections.emptyList()
            java.util.List r7 = java.util.Collections.emptyList()
            java.util.List r8 = java.util.Collections.emptyList()
            java.util.List r9 = java.util.Collections.emptyList()
            java.util.List r10 = java.util.Collections.emptyList()
            java.util.List r11 = java.util.Collections.emptyList()
            java.util.List r12 = java.util.Collections.emptyList()
            java.util.List r13 = java.util.Collections.emptyList()
            java.util.List r14 = java.util.Collections.emptyList()
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            org.json.JSONObject r16 = new org.json.JSONObject
            r16.<init>()
            org.json.JSONObject r17 = new org.json.JSONObject
            r17.<init>()
            org.json.JSONObject r18 = new org.json.JSONObject
            r18.<init>()
            org.json.JSONObject r19 = new org.json.JSONObject
            r19.<init>()
            org.json.JSONObject r20 = new org.json.JSONObject
            r20.<init>()
            com.google.android.gms.internal.ads.zzfvn r21 = com.google.android.gms.internal.ads.zzfvn.zzo()
            r77.beginObject()
            r22 = 1
            r23 = -1
            r24 = 0
            java.lang.String r25 = ""
            r26 = 0
            r27 = r16
            r28 = r17
            r29 = r18
            r30 = r19
            r31 = r20
            r32 = r21
            r19 = r24
            r33 = r19
            r34 = r33
            r35 = r34
            r36 = r35
            r38 = r25
            r39 = r38
            r40 = r39
            r41 = r40
            r42 = r41
            r53 = r42
            r57 = r53
            r59 = r57
            r62 = r59
            r64 = r62
            r65 = r64
            r66 = r65
            r67 = r66
            r68 = r67
            r73 = r68
            r37 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = -1
            r51 = 0
            r52 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r58 = -1
            r60 = 0
            r61 = 1
            r63 = 0
            r69 = 0
            r70 = 0
            r71 = 0
            r72 = 0
            r21 = r11
            r20 = r12
            r18 = r13
            r17 = r14
            r16 = r15
            r15 = r36
            r11 = r73
            r12 = r11
            r13 = 0
            r14 = 0
        L_0x00dd:
            boolean r24 = r77.hasNext()
            if (r24 == 0) goto L_0x081a
            java.lang.String r24 = r77.nextName()
            if (r24 != 0) goto L_0x00ec
            r74 = r25
            goto L_0x00ee
        L_0x00ec:
            r74 = r24
        L_0x00ee:
            int r24 = r74.hashCode()
            switch(r24) {
                case -2138196627: goto L_0x05a4;
                case -1980587809: goto L_0x0593;
                case -1965512151: goto L_0x0582;
                case -1812055556: goto L_0x0571;
                case -1776946669: goto L_0x0560;
                case -1662989631: goto L_0x054f;
                case -1620470467: goto L_0x053d;
                case -1550155393: goto L_0x052b;
                case -1440104884: goto L_0x0519;
                case -1439500848: goto L_0x0507;
                case -1428969291: goto L_0x04f5;
                case -1406227629: goto L_0x04e3;
                case -1403779768: goto L_0x04d1;
                case -1375413093: goto L_0x04bf;
                case -1360811658: goto L_0x04ad;
                case -1306015996: goto L_0x049b;
                case -1303332046: goto L_0x0489;
                case -1289032093: goto L_0x0477;
                case -1240082064: goto L_0x0465;
                case -1234181075: goto L_0x0453;
                case -1168140544: goto L_0x0441;
                case -1152230954: goto L_0x0430;
                case -1146534047: goto L_0x041e;
                case -1115838944: goto L_0x040c;
                case -1081936678: goto L_0x03fa;
                case -1078050970: goto L_0x03e8;
                case -1051269058: goto L_0x03d6;
                case -982608540: goto L_0x03c4;
                case -972056451: goto L_0x03b2;
                case -776859333: goto L_0x03a1;
                case -544216775: goto L_0x038f;
                case -437057161: goto L_0x037e;
                case -404433734: goto L_0x036c;
                case -404326515: goto L_0x035a;
                case -397704715: goto L_0x0348;
                case -388807511: goto L_0x0336;
                case -369773488: goto L_0x0324;
                case -213449460: goto L_0x0312;
                case -213424028: goto L_0x0300;
                case -180214626: goto L_0x02ee;
                case -154616268: goto L_0x02dc;
                case -29338502: goto L_0x02ca;
                case 3107: goto L_0x02b8;
                case 3355: goto L_0x02a6;
                case 3076010: goto L_0x0294;
                case 37109963: goto L_0x0282;
                case 63195984: goto L_0x0270;
                case 107433883: goto L_0x025e;
                case 230323073: goto L_0x024d;
                case 418392395: goto L_0x023b;
                case 549176928: goto L_0x0229;
                case 597473788: goto L_0x0217;
                case 754887508: goto L_0x0205;
                case 791122864: goto L_0x01f4;
                case 1010584092: goto L_0x01e2;
                case 1100650276: goto L_0x01d0;
                case 1186014765: goto L_0x01be;
                case 1321720943: goto L_0x01ac;
                case 1437255331: goto L_0x019a;
                case 1637553475: goto L_0x0188;
                case 1638957285: goto L_0x0177;
                case 1686319423: goto L_0x0165;
                case 1688341040: goto L_0x0154;
                case 1799285870: goto L_0x0142;
                case 1839650832: goto L_0x0131;
                case 1875425491: goto L_0x011f;
                case 2068142375: goto L_0x010d;
                case 2072888499: goto L_0x00fb;
                default: goto L_0x00f5;
            }
        L_0x00f5:
            r75 = r9
            r24 = r10
            goto L_0x05b5
        L_0x00fb:
            r24 = r10
            java.lang.String r10 = "manual_tracking_urls"
            r75 = r9
            r9 = r74
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 15
            goto L_0x05b6
        L_0x010d:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "rule_line_external_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 52
            goto L_0x05b6
        L_0x011f:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_analytics_logging_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 42
            goto L_0x05b6
        L_0x0131:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "renderers"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 0
            goto L_0x05b6
        L_0x0142:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "use_third_party_container_height"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 48
            goto L_0x05b6
        L_0x0154:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "video_reward_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 7
            goto L_0x05b6
        L_0x0165:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_network_class_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 55
            goto L_0x05b6
        L_0x0177:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "video_start_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 6
            goto L_0x05b6
        L_0x0188:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "bid_response"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 40
            goto L_0x05b6
        L_0x019a:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_source_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 57
            goto L_0x05b6
        L_0x01ac:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "allow_pub_owned_ad_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 31
            goto L_0x05b6
        L_0x01be:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "cache_hit_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 65
            goto L_0x05b6
        L_0x01d0:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "rewards"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 11
            goto L_0x05b6
        L_0x01e2:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "transaction_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 9
            goto L_0x05b6
        L_0x01f4:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 5
            goto L_0x05b6
        L_0x0205:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "container_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 17
            goto L_0x05b6
        L_0x0217:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "debug_dialog_string"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 27
            goto L_0x05b6
        L_0x0229:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "presentation_error_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 16
            goto L_0x05b6
        L_0x023b:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_closable_area_disabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 36
            goto L_0x05b6
        L_0x024d:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_load_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 4
            goto L_0x05b6
        L_0x025e:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "qdata"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 24
            goto L_0x05b6
        L_0x0270:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "render_test_label"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 33
            goto L_0x05b6
        L_0x0282:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "request_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 67
            goto L_0x05b6
        L_0x0294:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "data"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 22
            goto L_0x05b6
        L_0x02a6:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 23
            goto L_0x05b6
        L_0x02b8:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 18
            goto L_0x05b6
        L_0x02ca:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "allow_custom_click_gesture"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 32
            goto L_0x05b6
        L_0x02dc:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_offline_ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 60
            goto L_0x05b6
        L_0x02ee:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "native_required_asset_viewability"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 62
            goto L_0x05b6
        L_0x0300:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "watermark"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 46
            goto L_0x05b6
        L_0x0312:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "force_disable_hardware_acceleration"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 64
            goto L_0x05b6
        L_0x0324:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_close_button_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 50
            goto L_0x05b6
        L_0x0336:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "content_url"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 63
            goto L_0x05b6
        L_0x0348:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_close_time_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 45
            goto L_0x05b6
        L_0x035a:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "render_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 38
            goto L_0x05b6
        L_0x036c:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "rtb_native_required_assets"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 61
            goto L_0x05b6
        L_0x037e:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "imp_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 3
            goto L_0x05b6
        L_0x038f:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "safe_browsing"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 26
            goto L_0x05b6
        L_0x03a1:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "click_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 2
            goto L_0x05b6
        L_0x03b2:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_source_instance_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 59
            goto L_0x05b6
        L_0x03c4:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "valid_from_timestamp"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 10
            goto L_0x05b6
        L_0x03d6:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "active_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 25
            goto L_0x05b6
        L_0x03e8:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "video_complete_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 8
            goto L_0x05b6
        L_0x03fa:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "allocation_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 21
            goto L_0x05b6
        L_0x040c:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "fill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 12
            goto L_0x05b6
        L_0x041e:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_scroll_aware"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 43
            goto L_0x05b6
        L_0x0430:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 1
            goto L_0x05b6
        L_0x0441:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "presentation_error_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 14
            goto L_0x05b6
        L_0x0453:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "allow_pub_rendered_attribution"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 30
            goto L_0x05b6
        L_0x0465:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_event_value"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 51
            goto L_0x05b6
        L_0x0477:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "extras"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 29
            goto L_0x05b6
        L_0x0489:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "test_mode_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 34
            goto L_0x05b6
        L_0x049b:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "adapters"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 20
            goto L_0x05b6
        L_0x04ad:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 19
            goto L_0x05b6
        L_0x04bf:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_cover"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 54
            goto L_0x05b6
        L_0x04d1:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "showable_impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 44
            goto L_0x05b6
        L_0x04e3:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "buffer_click_url_as_ready_to_ping"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 66
            goto L_0x05b6
        L_0x04f5:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "enable_omid"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 39
            goto L_0x05b6
        L_0x0507:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "orientation"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 37
            goto L_0x05b6
        L_0x0519:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_custom_close_blocked"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 35
            goto L_0x05b6
        L_0x052b:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "nofill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 13
            goto L_0x05b6
        L_0x053d:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "backend_query_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 47
            goto L_0x05b6
        L_0x054f:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "is_interscroller"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 53
            goto L_0x05b6
        L_0x0560:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_source_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 56
            goto L_0x05b6
        L_0x0571:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "play_prewarm_options"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 49
            goto L_0x05b6
        L_0x0582:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "omid_settings"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 41
            goto L_0x05b6
        L_0x0593:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "debug_signals"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 28
            goto L_0x05b6
        L_0x05a4:
            r75 = r9
            r24 = r10
            r9 = r74
            java.lang.String r10 = "ad_source_instance_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x05b5
            r9 = 58
            goto L_0x05b6
        L_0x05b5:
            r9 = -1
        L_0x05b6:
            switch(r9) {
                case 0: goto L_0x080e;
                case 1: goto L_0x0803;
                case 2: goto L_0x07fc;
                case 3: goto L_0x07f5;
                case 4: goto L_0x07ee;
                case 5: goto L_0x07e3;
                case 6: goto L_0x07dc;
                case 7: goto L_0x07d5;
                case 8: goto L_0x07ce;
                case 9: goto L_0x07c7;
                case 10: goto L_0x07c0;
                case 11: goto L_0x07b4;
                case 12: goto L_0x07ac;
                case 13: goto L_0x07a4;
                case 14: goto L_0x079a;
                case 15: goto L_0x0790;
                case 16: goto L_0x0788;
                case 17: goto L_0x077e;
                case 18: goto L_0x0773;
                case 19: goto L_0x0769;
                case 20: goto L_0x075f;
                case 21: goto L_0x0757;
                case 22: goto L_0x074d;
                case 23: goto L_0x0748;
                case 24: goto L_0x0743;
                case 25: goto L_0x073a;
                case 26: goto L_0x072c;
                case 27: goto L_0x0727;
                case 28: goto L_0x071d;
                case 29: goto L_0x0713;
                case 30: goto L_0x070e;
                case 31: goto L_0x0709;
                case 32: goto L_0x0704;
                case 33: goto L_0x06ff;
                case 34: goto L_0x06fa;
                case 35: goto L_0x06f4;
                case 36: goto L_0x06ee;
                case 37: goto L_0x06e4;
                case 38: goto L_0x06de;
                case 39: goto L_0x06d8;
                case 40: goto L_0x06d2;
                case 41: goto L_0x06c8;
                case 42: goto L_0x06c2;
                case 43: goto L_0x06bc;
                case 44: goto L_0x06b6;
                case 45: goto L_0x06b0;
                case 46: goto L_0x06aa;
                case 47: goto L_0x06a4;
                case 48: goto L_0x069e;
                case 49: goto L_0x0690;
                case 50: goto L_0x068a;
                case 51: goto L_0x067c;
                case 52: goto L_0x0676;
                case 53: goto L_0x0670;
                case 54: goto L_0x0666;
                case 55: goto L_0x0660;
                case 56: goto L_0x0647;
                case 57: goto L_0x062e;
                case 58: goto L_0x0615;
                case 59: goto L_0x05fc;
                case 60: goto L_0x05f6;
                case 61: goto L_0x05ec;
                case 62: goto L_0x05e6;
                case 63: goto L_0x05dc;
                case 64: goto L_0x05d6;
                case 65: goto L_0x05cc;
                case 66: goto L_0x05c6;
                case 67: goto L_0x05c0;
                default: goto L_0x05b9;
            }
        L_0x05b9:
            r10 = r77
            r77.skipValue()
            goto L_0x0814
        L_0x05c0:
            java.lang.String r73 = r77.nextString()
            goto L_0x075b
        L_0x05c6:
            boolean r72 = r77.nextBoolean()
            goto L_0x075b
        L_0x05cc:
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            r10 = r77
            r32 = r9
            goto L_0x0814
        L_0x05d6:
            boolean r71 = r77.nextBoolean()
            goto L_0x075b
        L_0x05dc:
            java.lang.String r9 = r77.nextString()
            r10 = r77
            r36 = r9
            goto L_0x0814
        L_0x05e6:
            boolean r70 = r77.nextBoolean()
            goto L_0x075b
        L_0x05ec:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            r10 = r77
            r31 = r9
            goto L_0x0814
        L_0x05f6:
            boolean r69 = r77.nextBoolean()
            goto L_0x075b
        L_0x05fc:
            com.google.android.gms.internal.ads.zzbiu r9 = com.google.android.gms.internal.ads.zzbjc.zzfR
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0610
            java.lang.String r68 = r77.nextString()
            goto L_0x075b
        L_0x0610:
            r77.skipValue()
            goto L_0x075b
        L_0x0615:
            com.google.android.gms.internal.ads.zzbiu r9 = com.google.android.gms.internal.ads.zzbjc.zzfR
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0629
            java.lang.String r67 = r77.nextString()
            goto L_0x075b
        L_0x0629:
            r77.skipValue()
            goto L_0x075b
        L_0x062e:
            com.google.android.gms.internal.ads.zzbiu r9 = com.google.android.gms.internal.ads.zzbjc.zzfR
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0642
            java.lang.String r66 = r77.nextString()
            goto L_0x075b
        L_0x0642:
            r77.skipValue()
            goto L_0x075b
        L_0x0647:
            com.google.android.gms.internal.ads.zzbiu r9 = com.google.android.gms.internal.ads.zzbjc.zzfR
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x065b
            java.lang.String r65 = r77.nextString()
            goto L_0x075b
        L_0x065b:
            r77.skipValue()
            goto L_0x075b
        L_0x0660:
            java.lang.String r64 = r77.nextString()
            goto L_0x075b
        L_0x0666:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            r10 = r77
            r30 = r9
            goto L_0x0814
        L_0x0670:
            boolean r63 = r77.nextBoolean()
            goto L_0x075b
        L_0x0676:
            java.lang.String r62 = r77.nextString()
            goto L_0x075b
        L_0x067c:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            com.google.android.gms.ads.internal.client.zzs r9 = com.google.android.gms.ads.internal.client.zzs.zza(r9)
            r10 = r77
            r35 = r9
            goto L_0x0814
        L_0x068a:
            boolean r61 = r77.nextBoolean()
            goto L_0x075b
        L_0x0690:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            com.google.android.gms.internal.ads.zzbzi r9 = com.google.android.gms.internal.ads.zzbzi.zza(r9)
            r10 = r77
            r34 = r9
            goto L_0x0814
        L_0x069e:
            boolean r60 = r77.nextBoolean()
            goto L_0x075b
        L_0x06a4:
            java.lang.String r59 = r77.nextString()
            goto L_0x075b
        L_0x06aa:
            java.lang.String r57 = r77.nextString()
            goto L_0x075b
        L_0x06b0:
            int r58 = r77.nextInt()
            goto L_0x075b
        L_0x06b6:
            int r56 = r77.nextInt()
            goto L_0x075b
        L_0x06bc:
            boolean r55 = r77.nextBoolean()
            goto L_0x075b
        L_0x06c2:
            boolean r54 = r77.nextBoolean()
            goto L_0x075b
        L_0x06c8:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            r10 = r77
            r29 = r9
            goto L_0x0814
        L_0x06d2:
            java.lang.String r53 = r77.nextString()
            goto L_0x075b
        L_0x06d8:
            boolean r52 = r77.nextBoolean()
            goto L_0x075b
        L_0x06de:
            int r51 = r77.nextInt()
            goto L_0x075b
        L_0x06e4:
            java.lang.String r9 = r77.nextString()
            int r50 = zzd(r9)
            goto L_0x075b
        L_0x06ee:
            boolean r49 = r77.nextBoolean()
            goto L_0x075b
        L_0x06f4:
            boolean r48 = r77.nextBoolean()
            goto L_0x075b
        L_0x06fa:
            boolean r47 = r77.nextBoolean()
            goto L_0x075b
        L_0x06ff:
            boolean r46 = r77.nextBoolean()
            goto L_0x075b
        L_0x0704:
            boolean r45 = r77.nextBoolean()
            goto L_0x075b
        L_0x0709:
            boolean r44 = r77.nextBoolean()
            goto L_0x075b
        L_0x070e:
            boolean r43 = r77.nextBoolean()
            goto L_0x075b
        L_0x0713:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            r10 = r77
            r28 = r9
            goto L_0x0814
        L_0x071d:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            r10 = r77
            r27 = r9
            goto L_0x0814
        L_0x0727:
            java.lang.String r42 = r77.nextString()
            goto L_0x075b
        L_0x072c:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            com.google.android.gms.internal.ads.zzcdn r9 = com.google.android.gms.internal.ads.zzcdn.zza(r9)
            r10 = r77
            r33 = r9
            goto L_0x0814
        L_0x073a:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            java.lang.String r41 = r9.toString()
            goto L_0x075b
        L_0x0743:
            java.lang.String r40 = r77.nextString()
            goto L_0x075b
        L_0x0748:
            java.lang.String r39 = r77.nextString()
            goto L_0x075b
        L_0x074d:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbu.zzh(r77)
            r10 = r77
            r16 = r9
            goto L_0x0814
        L_0x0757:
            java.lang.String r38 = r77.nextString()
        L_0x075b:
            r10 = r77
            goto L_0x0814
        L_0x075f:
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            r10 = r77
            r18 = r9
            goto L_0x0814
        L_0x0769:
            java.util.List r9 = com.google.android.gms.internal.ads.zzfdl.zza(r77)
            r10 = r77
            r17 = r9
            goto L_0x0814
        L_0x0773:
            com.google.android.gms.internal.ads.zzfdp r9 = new com.google.android.gms.internal.ads.zzfdp
            r10 = r77
            r9.<init>(r10)
            r19 = r9
            goto L_0x0814
        L_0x077e:
            r10 = r77
            java.util.List r9 = com.google.android.gms.internal.ads.zzfdl.zza(r77)
            r20 = r9
            goto L_0x0814
        L_0x0788:
            r10 = r77
            int r37 = r77.nextInt()
            goto L_0x0814
        L_0x0790:
            r10 = r77
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            r21 = r9
            goto L_0x0814
        L_0x079a:
            r10 = r77
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            r24 = r9
            goto L_0x0814
        L_0x07a4:
            r10 = r77
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0816
        L_0x07ac:
            r10 = r77
            java.util.List r8 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0814
        L_0x07b4:
            r10 = r77
            org.json.JSONArray r9 = com.google.android.gms.ads.internal.util.zzbu.zze(r77)
            com.google.android.gms.internal.ads.zzcce r9 = com.google.android.gms.internal.ads.zzcce.zza(r9)
            r15 = r9
            goto L_0x0814
        L_0x07c0:
            r10 = r77
            java.lang.String r11 = r77.nextString()
            goto L_0x0814
        L_0x07c7:
            r10 = r77
            java.lang.String r12 = r77.nextString()
            goto L_0x0814
        L_0x07ce:
            r10 = r77
            java.util.List r7 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0814
        L_0x07d5:
            r10 = r77
            java.util.List r6 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0814
        L_0x07dc:
            r10 = r77
            java.util.List r5 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0814
        L_0x07e3:
            r10 = r77
            int r9 = r77.nextInt()
            int r14 = zzc(r9)
            goto L_0x0814
        L_0x07ee:
            r10 = r77
            java.util.List r4 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0814
        L_0x07f5:
            r10 = r77
            java.util.List r3 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0814
        L_0x07fc:
            r10 = r77
            java.util.List r2 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
            goto L_0x0814
        L_0x0803:
            r10 = r77
            java.lang.String r9 = r77.nextString()
            int r13 = zzb(r9)
            goto L_0x0814
        L_0x080e:
            r10 = r77
            java.util.List r1 = com.google.android.gms.ads.internal.util.zzbu.zzd(r77)
        L_0x0814:
            r9 = r75
        L_0x0816:
            r10 = r24
            goto L_0x00dd
        L_0x081a:
            r75 = r9
            r24 = r10
            r10 = r77
            r77.endObject()
            r0.zza = r1
            r0.zzb = r13
            r0.zzc = r2
            r0.zzd = r3
            r0.zzg = r4
            r0.zzf = r14
            r0.zzh = r5
            r0.zzi = r6
            r0.zzj = r7
            r0.zzk = r12
            r0.zzl = r11
            r0.zzm = r15
            r0.zzn = r8
            r0.zzo = r9
            r10 = r24
            r0.zzp = r10
            r11 = r21
            r0.zzq = r11
            r1 = r37
            r0.zzr = r1
            r12 = r20
            r0.zzs = r12
            r1 = r19
            r0.zzt = r1
            r13 = r18
            r0.zzu = r13
            r14 = r17
            r0.zzv = r14
            r1 = r38
            r0.zzx = r1
            r15 = r16
            r0.zzw = r15
            r1 = r39
            r0.zzy = r1
            r1 = r40
            r0.zzz = r1
            r1 = r41
            r0.zzA = r1
            r1 = r33
            r0.zzB = r1
            r1 = r42
            r0.zzC = r1
            r1 = r27
            r0.zzD = r1
            r1 = r28
            r0.zzE = r1
            r1 = r43
            r0.zzK = r1
            r1 = r44
            r0.zzL = r1
            r1 = r45
            r0.zzM = r1
            r1 = r46
            r0.zzN = r1
            r1 = r47
            r0.zzO = r1
            r1 = r48
            r0.zzP = r1
            r1 = r49
            r0.zzQ = r1
            r1 = r50
            r0.zzR = r1
            r1 = r51
            r0.zzS = r1
            r1 = r52
            r0.zzU = r1
            r1 = r53
            r0.zzV = r1
            com.google.android.gms.internal.ads.zzfei r1 = new com.google.android.gms.internal.ads.zzfei
            r2 = r29
            r1.<init>(r2)
            r0.zzW = r1
            r1 = r54
            r0.zzX = r1
            r1 = r55
            r0.zzY = r1
            r1 = r56
            r0.zzZ = r1
            r1 = r57
            r0.zzaa = r1
            r1 = r58
            r0.zzab = r1
            r1 = r59
            r0.zzac = r1
            r1 = r60
            r0.zzad = r1
            r1 = r34
            r0.zzae = r1
            r1 = r61
            r0.zzaf = r1
            r1 = r35
            r0.zzag = r1
            r1 = r62
            r0.zzah = r1
            r1 = r63
            r0.zzai = r1
            r1 = r30
            r0.zzaj = r1
            r1 = r64
            r0.zzF = r1
            r1 = r65
            r0.zzG = r1
            r1 = r66
            r0.zzH = r1
            r1 = r67
            r0.zzI = r1
            r1 = r68
            r0.zzJ = r1
            r1 = r69
            r0.zzak = r1
            r1 = r31
            r0.zzal = r1
            r1 = r70
            r0.zzam = r1
            r1 = r36
            r0.zzan = r1
            r1 = r71
            r0.zzao = r1
            r1 = r32
            r0.zze = r1
            r1 = r72
            r0.zzT = r1
            r1 = r73
            r0.zzap = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdk.<init>(android.util.JsonReader):void");
    }

    public static String zza(int i) {
        switch (i) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return ParamsHelper.NATIVE;
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzb(String str) {
        if (Const.ComponentType.BANNER.equals(str)) {
            return 1;
        }
        if ("interstitial".equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if ("native".equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str) || "app_open_ad_v2".equals(str)) {
            return 6;
        }
        return "rewarded_interstitial".equals(str) ? 7 : 0;
    }

    private static int zzc(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        return 0;
    }

    private static final int zzd(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        return "portrait".equalsIgnoreCase(str) ? 7 : -1;
    }
}
