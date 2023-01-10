package com.didi.payment.creditcard.global.ocr;

import android.app.Activity;
import android.content.Context;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didichuxing.cardscan.CardScanCallback;
import com.didichuxing.cardscan.CardScanResult;
import com.didichuxing.cardscan.DidiCardScanner;
import com.taxis99.R;

public class ScanHelper {

    /* renamed from: a */
    private static long f32861a;

    public static void scan(final Activity activity, int i, final CardScanCallback cardScanCallback) {
        f32861a = System.currentTimeMillis();
        m24957d(activity);
        DidiCardScanner instance = DidiCardScanner.getInstance();
        instance.setScanCallback(new CardScanCallback() {
            public void onScanResult(CardScanResult cardScanResult) {
                ScanHelper.m24958e(activity);
                CardScanCallback cardScanCallback = cardScanCallback;
                if (cardScanCallback != null) {
                    cardScanCallback.onScanResult(cardScanResult);
                }
            }

            public void onBottomBackBtnClick() {
                ScanHelper.m24958e(activity);
                ScanHelper.m24960g(activity);
            }

            public void onLeftTopBackBtnClick() {
                ScanHelper.m24958e(activity);
                ScanHelper.m24959f(activity);
            }

            public void onKeyBackBtnClick() {
                ScanHelper.m24958e(activity);
                ScanHelper.m24959f(activity);
            }
        });
        instance.setTexts(activity.getResources().getString(R.string.one_payment_creditcard_global_ocr_scan_center_text), activity.getResources().getString(R.string.one_payment_creditcard_global_ocr_scan_small_text), activity.getResources().getString(R.string.one_payment_creditcard_global_ocr_scan_button_text), activity.getResources().getString(R.string.one_payment_creditcard_global_ocr_scan_title_text));
        instance.scan(activity, i);
    }

    public static boolean isSupport(Context context) {
        return DidiCardScanner.getInstance().supportScan(context);
    }

    /* renamed from: d */
    private static void m24957d(Context context) {
        GlobalOmegaUtils.trackOcrPageOcrCk(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m24958e(Context context) {
        GlobalOmegaUtils.trackOcrPageOcrTimeCk(context, System.currentTimeMillis() - f32861a);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m24959f(Context context) {
        GlobalOmegaUtils.trackOcrPageOcrBackCk(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static void m24960g(Context context) {
        GlobalOmegaUtils.trackOcrPageOcrMnlCk(context);
    }
}
