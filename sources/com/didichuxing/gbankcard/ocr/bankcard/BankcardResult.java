package com.didichuxing.gbankcard.ocr.bankcard;

import android.text.TextUtils;
import com.didi.aoe.features.bankcard.global.domain.DetectCardInfo;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.gbankcard.ocr.utils.LuhnAlgo;
import com.didichuxing.gbankcard.ocr.utils.OcrTypeUtils;
import java.util.Arrays;

public class BankcardResult {
    public static final int STATE_CENTER_CHECK_FAIL = 3;
    public static final int STATE_HAS_RESULT = 5;
    public static final int STATE_HBORDER_CHECK_FAIL = 2;
    public static final int STATE_LUHN_CHECK_FAIL = 4;
    public static final int STATE_NO_RESULT = 0;
    public static final int STATE_SIZE_CHECK_FAIL = 1;

    /* renamed from: a */
    private final int f50266a;
    public final DetectCardInfo alphaCardInfo = new DetectCardInfo();

    /* renamed from: b */
    private final float f50267b;

    /* renamed from: c */
    private final float f50268c;

    public static class CardNumInfo {
        public String cardNum;
        public float score;
        public int state = 0;

        CardNumInfo() {
        }
    }

    public BankcardResult(int i, float f, float f2) {
        this.f50266a = i;
        this.f50267b = f;
        this.f50268c = f2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CardNumInfo mo124260a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        CardNumInfo cardNumInfo = new CardNumInfo();
        String cardNum = this.alphaCardInfo.getCardNum();
        cardNumInfo.cardNum = cardNum;
        cardNumInfo.score = this.alphaCardInfo.prob;
        float[] fArr = this.alphaCardInfo.cardRect;
        LogUtils.m37051d("rawCardNum===" + cardNumInfo.cardNum + ", score=" + cardNumInfo.score);
        StringBuilder sb = new StringBuilder();
        sb.append("cardRect===");
        sb.append(Arrays.toString(fArr));
        LogUtils.m37051d(sb.toString());
        if (fArr != null && fArr.length >= 6) {
            float f = fArr[2];
            float f2 = fArr[3];
            float f3 = fArr[4];
            float f4 = fArr[5];
            float f5 = f3 - f;
            float f6 = f4 - f2;
            if (f5 <= 0.0f || f6 <= 0.0f) {
                cardNumInfo.state = 0;
            } else if (TextUtils.isEmpty(cardNum)) {
                cardNumInfo.state = 0;
                return cardNumInfo;
            } else {
                LogUtils.m37051d("imgW===" + i3 + ", imgH=" + i4 + ", cardW=" + f5 + ", cardH=" + f6);
                if (f5 <= f6 || ((f5 * f6) / ((float) i3)) / ((float) i4) >= 0.4f) {
                    float[] fArr2 = this.alphaCardInfo.cardNumRect;
                    LogUtils.m37051d("cardNumRect===" + Arrays.toString(fArr2));
                    float f7 = (float) i3;
                    float min = Math.min(fArr2[2], f7 - fArr2[4]);
                    LogUtils.m37051d("xborder===" + min);
                    if (min / f5 < this.f50267b) {
                        LogUtils.m37051d("left-right border pos invalid!!!");
                        cardNumInfo.state = 2;
                        return cardNumInfo;
                    }
                    float abs = Math.abs((f7 / 2.0f) - ((f + f3) / 2.0f));
                    float abs2 = Math.abs((((float) i4) / 2.0f) - ((f2 + f4) / 2.0f));
                    LogUtils.m37051d("centerXOffset===" + abs + ", centerYOffset=" + abs2);
                    float f8 = this.f50268c;
                    if (abs / f5 > f8 || abs2 / f6 > f8) {
                        LogUtils.m37051d("center pos invalid!!!");
                        cardNumInfo.state = 3;
                        return cardNumInfo;
                    } else if (LuhnAlgo.checkLuhn(cardNum)) {
                        cardNumInfo.state = 5;
                    } else {
                        LogUtils.m37051d("luhn check failed!!!");
                        cardNumInfo.state = 4;
                    }
                } else {
                    LogUtils.m37051d("size ratio invalid!!!");
                    cardNumInfo.state = 1;
                    return cardNumInfo;
                }
            }
        }
        return cardNumInfo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float[] mo124261a() {
        if (OcrTypeUtils.isUsingDidiCardIO(this.f50266a)) {
            return null;
        }
        return this.alphaCardInfo.cardRect;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float[] mo124262b() {
        if (OcrTypeUtils.isUsingDidiCardIO(this.f50266a)) {
            return null;
        }
        return this.alphaCardInfo.cardNumRect;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo124263c() {
        this.alphaCardInfo.reset();
    }
}
