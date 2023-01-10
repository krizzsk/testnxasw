package com.didi.dqr.oned;

import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.sdk.util.GlobalCountryCode;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.dqr.oned.a */
/* compiled from: EANManufacturerOrgSupport */
final class C8438a {

    /* renamed from: a */
    private final List<int[]> f20637a = new ArrayList();

    /* renamed from: b */
    private final List<String> f20638b = new ArrayList();

    C8438a() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        r4 = r7.f20637a.get(r2);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo63327a(java.lang.String r8) {
        /*
            r7 = this;
            r7.m17356a()
            r0 = 0
            r1 = 3
            java.lang.String r8 = r8.substring(r0, r1)
            int r8 = java.lang.Integer.parseInt(r8)
            java.util.List<int[]> r1 = r7.f20637a
            int r1 = r1.size()
            r2 = 0
        L_0x0014:
            r3 = 0
            if (r2 >= r1) goto L_0x0039
            java.util.List<int[]> r4 = r7.f20637a
            java.lang.Object r4 = r4.get(r2)
            int[] r4 = (int[]) r4
            r5 = r4[r0]
            if (r8 >= r5) goto L_0x0024
            return r3
        L_0x0024:
            int r3 = r4.length
            r6 = 1
            if (r3 != r6) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r5 = r4[r6]
        L_0x002b:
            if (r8 > r5) goto L_0x0036
            java.util.List<java.lang.String> r8 = r7.f20638b
            java.lang.Object r8 = r8.get(r2)
            java.lang.String r8 = (java.lang.String) r8
            return r8
        L_0x0036:
            int r2 = r2 + 1
            goto L_0x0014
        L_0x0039:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.oned.C8438a.mo63327a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private void m17357a(int[] iArr, String str) {
        this.f20637a.add(iArr);
        this.f20638b.add(str);
    }

    /* renamed from: a */
    private synchronized void m17356a() {
        if (this.f20637a.isEmpty()) {
            m17357a(new int[]{0, 19}, "US/CA");
            m17357a(new int[]{30, 39}, GlobalCountryCode.AMERICA);
            m17357a(new int[]{60, 139}, "US/CA");
            m17357a(new int[]{300, 379}, GlobalCountryCode.FRANCE);
            m17357a(new int[]{380}, GlobalCountryCode.BULGARIA);
            m17357a(new int[]{383}, GlobalCountryCode.SLOVENIA);
            m17357a(new int[]{385}, GlobalCountryCode.CROATIA);
            m17357a(new int[]{387}, "BA");
            m17357a(new int[]{400, 440}, GlobalCountryCode.GERMANY);
            m17357a(new int[]{450, 459}, "JP");
            m17357a(new int[]{460, 469}, MapSettingNavConstant.MAP_COUNTRY_CODE_RUSSIA);
            m17357a(new int[]{471}, "TW");
            m17357a(new int[]{474}, GlobalCountryCode.ESTONIA);
            m17357a(new int[]{475}, GlobalCountryCode.LATVIA);
            m17357a(new int[]{476}, "AZ");
            m17357a(new int[]{477}, GlobalCountryCode.LITHUANIA);
            m17357a(new int[]{478}, "UZ");
            m17357a(new int[]{479}, "LK");
            m17357a(new int[]{480}, "PH");
            m17357a(new int[]{481}, "BY");
            m17357a(new int[]{482}, "UA");
            m17357a(new int[]{484}, "MD");
            m17357a(new int[]{485}, "AM");
            m17357a(new int[]{486}, "GE");
            m17357a(new int[]{487}, MapSettingNavConstant.MAP_COUNTRY_CODE_KAZAKHSTAN);
            m17357a(new int[]{489}, "HK");
            m17357a(new int[]{490, 499}, "JP");
            m17357a(new int[]{500, 509}, GlobalCountryCode.ENGLAND);
            m17357a(new int[]{520}, GlobalCountryCode.GREECE);
            m17357a(new int[]{528}, ExpandedProductParsedResult.POUND);
            m17357a(new int[]{529}, GlobalCountryCode.CYPRUS);
            m17357a(new int[]{531}, "MK");
            m17357a(new int[]{535}, GlobalCountryCode.MALTA);
            m17357a(new int[]{539}, GlobalCountryCode.IRELAND);
            m17357a(new int[]{540, 549}, "BE/LU");
            m17357a(new int[]{560}, GlobalCountryCode.PORTUGAL);
            m17357a(new int[]{569}, "IS");
            m17357a(new int[]{570, 579}, GlobalCountryCode.DENMARK);
            m17357a(new int[]{590}, GlobalCountryCode.POLAND);
            m17357a(new int[]{594}, GlobalCountryCode.RUMANIA);
            m17357a(new int[]{599}, GlobalCountryCode.HUNGARY);
            m17357a(new int[]{600, 601}, HistoryRecordFragment.COUNTRY_CODE_ZA);
            m17357a(new int[]{603}, "GH");
            m17357a(new int[]{608}, "BH");
            m17357a(new int[]{609}, "MU");
            m17357a(new int[]{611}, RequestConfiguration.MAX_AD_CONTENT_RATING_MA);
            m17357a(new int[]{613}, "DZ");
            m17357a(new int[]{616}, "KE");
            m17357a(new int[]{618}, "CI");
            m17357a(new int[]{619}, "TN");
            m17357a(new int[]{621}, "SY");
            m17357a(new int[]{622}, "EG");
            m17357a(new int[]{624}, "LY");
            m17357a(new int[]{625}, "JO");
            m17357a(new int[]{626}, "IR");
            m17357a(new int[]{627}, "KW");
            m17357a(new int[]{628}, "SA");
            m17357a(new int[]{629}, "AE");
            m17357a(new int[]{640, 649}, GlobalCountryCode.FINLAND);
            m17357a(new int[]{690, 695}, GlobalCountryCode.CHINA);
            m17357a(new int[]{700, 709}, DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK);
            m17357a(new int[]{729}, "IL");
            m17357a(new int[]{730, 739}, GlobalCountryCode.SWEDEN);
            m17357a(new int[]{740}, "GT");
            m17357a(new int[]{741}, "SV");
            m17357a(new int[]{742}, "HN");
            m17357a(new int[]{743}, "NI");
            m17357a(new int[]{744}, HistoryRecordFragment.COUNTRY_CODE_CR);
            m17357a(new int[]{745}, HistoryRecordFragment.COUNTRY_CODE_PA);
            m17357a(new int[]{746}, HistoryRecordFragment.COUNTRY_CODE_DO);
            m17357a(new int[]{750}, "MX");
            m17357a(new int[]{754, 755}, GlobalCountryCode.CANADA);
            m17357a(new int[]{759}, "VE");
            m17357a(new int[]{760, 769}, "CH");
            m17357a(new int[]{770}, HistoryRecordFragment.COUNTRY_CODE_CO);
            m17357a(new int[]{773}, "UY");
            m17357a(new int[]{775}, HistoryRecordFragment.COUNTRY_CODE_PE);
            m17357a(new int[]{777}, "BO");
            m17357a(new int[]{779}, HistoryRecordFragment.COUNTRY_CODE_AR);
            m17357a(new int[]{780}, HistoryRecordFragment.COUNTRY_CODE_CL);
            m17357a(new int[]{784}, "PY");
            m17357a(new int[]{785}, HistoryRecordFragment.COUNTRY_CODE_PE);
            m17357a(new int[]{786}, "EC");
            m17357a(new int[]{789, 790}, "BR");
            m17357a(new int[]{800, 839}, GlobalCountryCode.ITALY);
            m17357a(new int[]{840, 849}, GlobalCountryCode.SPAIN);
            m17357a(new int[]{850}, "CU");
            m17357a(new int[]{858}, GlobalCountryCode.SLOVAKIA);
            m17357a(new int[]{859}, GlobalCountryCode.CZECH_REPUBLIC);
            m17357a(new int[]{860}, "YU");
            m17357a(new int[]{865}, "MN");
            m17357a(new int[]{867}, "KP");
            m17357a(new int[]{868, 869}, "TR");
            m17357a(new int[]{870, 879}, GlobalCountryCode.NETHERLANDS);
            m17357a(new int[]{880}, "KR");
            m17357a(new int[]{885}, "TH");
            m17357a(new int[]{888}, "SG");
            m17357a(new int[]{890}, "IN");
            m17357a(new int[]{893}, "VN");
            m17357a(new int[]{896}, "PK");
            m17357a(new int[]{899}, "ID");
            m17357a(new int[]{900, 919}, GlobalCountryCode.AUSTRIA);
            m17357a(new int[]{930, 939}, "AU");
            m17357a(new int[]{940, 949}, "AZ");
            m17357a(new int[]{955}, "MY");
            m17357a(new int[]{958}, "MO");
        }
    }
}
