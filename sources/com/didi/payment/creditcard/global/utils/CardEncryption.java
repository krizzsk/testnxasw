package com.didi.payment.creditcard.global.utils;

import adyen.com.adyencse.pojo.Card;
import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.creditcard.global.model.GlobalBankCardInfo;
import com.didi.payment.creditcard.global.model.GlobalEncryptKeyInfo;
import com.didi.payment.creditcard.global.model.GlobalRiskInfo;
import com.didi.payment.creditcard.global.model.SignCardParam;
import java.util.Date;

public class CardEncryption {

    /* renamed from: a */
    private static CardEncryption f32895a;

    /* renamed from: b */
    private GlobalEncryptKeyInfo f32896b;

    /* renamed from: c */
    private String f32897c;

    /* renamed from: d */
    private String f32898d = this.f32896b.getRSAPublicKey();

    private CardEncryption() {
        GlobalEncryptKeyInfo globalEncryptKeyInfo = new GlobalEncryptKeyInfo();
        this.f32896b = globalEncryptKeyInfo;
        this.f32897c = globalEncryptKeyInfo.getAESKey();
    }

    public static CardEncryption getInstance() {
        if (f32895a == null) {
            f32895a = new CardEncryption();
        }
        return f32895a;
    }

    public String getEncryptedAesKey() {
        return this.f32896b.encryptWithRSA(this.f32897c, this.f32898d);
    }

    public String getAydenEncryptedCardInfoString(String str, String str2, String str3, String str4) {
        String a = m25014a(str3);
        String b = m25015b(str3);
        Card card = new Card();
        card.setCvc(str4);
        card.setExpiryMonth(b);
        card.setExpiryYear(a);
        card.setGenerationTime(new Date());
        card.setNumber(str2);
        card.setCardHolderName("didi");
        try {
            return card.serialize(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getOtherEncryptedCardInfoString(String str, String str2, String str3) {
        String a = m25014a(str2);
        String b = m25015b(str2);
        GlobalBankCardInfo globalBankCardInfo = new GlobalBankCardInfo();
        globalBankCardInfo.setCvc(str3);
        globalBankCardInfo.setExpiryMonth(b);
        globalBankCardInfo.setExpiryYear(a);
        globalBankCardInfo.setNumber(str);
        return globalBankCardInfo.encryptWithAES(this.f32897c);
    }

    public String getEncryptedRiskInfoString(Context context, String str, String str2, String str3, int i, boolean z, String str4, long j, String str5, SignCardParam signCardParam, String str6) {
        GlobalRiskInfo globalRiskInfo = new GlobalRiskInfo();
        globalRiskInfo.setBankCardNo(str);
        globalRiskInfo.setCardNoPrefixSuffix(str);
        globalRiskInfo.setBankAccountName("didi");
        String a = m25014a(str2);
        String b = m25015b(str2);
        globalRiskInfo.setValidDate(a + b);
        globalRiskInfo.setCvv2(str3);
        globalRiskInfo.setStayTime("" + j);
        globalRiskInfo.setBaseRiskParam(context);
        globalRiskInfo.setBankCardType("" + i);
        globalRiskInfo.setIsOcr(z);
        globalRiskInfo.setOcrContent(str4);
        globalRiskInfo.setOriginNumber(str5);
        if (signCardParam != null) {
            if (signCardParam.bindType > 0) {
                globalRiskInfo.setBindType("" + signCardParam.bindType);
            } else {
                globalRiskInfo.setBindType("5");
            }
            if (!TextUtils.isEmpty(signCardParam.orderId)) {
                globalRiskInfo.setOrderId(signCardParam.orderId);
            }
            if (!TextUtils.isEmpty(signCardParam.productLine)) {
                globalRiskInfo.setProductLine(signCardParam.productLine);
            }
            if (signCardParam.isSignAfterOrder) {
                globalRiskInfo.setSignAfterOrder(signCardParam.isSignAfterOrder);
            }
            globalRiskInfo.setResourceid(signCardParam.resourceId);
        }
        globalRiskInfo.setIsExistPaste(str6);
        return globalRiskInfo.encryptWithAES(this.f32897c);
    }

    /* renamed from: a */
    private String m25014a(String str) {
        String c = m25016c(str);
        if (c.length() != 4) {
            return "";
        }
        return "20" + c.substring(2, 4);
    }

    /* renamed from: b */
    private String m25015b(String str) {
        String c = m25016c(str);
        return c.length() == 4 ? c.substring(0, 2) : "";
    }

    /* renamed from: c */
    private String m25016c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return GlobalCreditCardFormatter.removeSymbols(str);
    }
}
