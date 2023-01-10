package com.didi.payment.commonsdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.utils.WalletExecutors;
import com.didi.sdk.apm.SystemUtils;
import com.pay99.diff_base.DiffConstants;
import com.pay99.diff_base.DiffUtil;
import com.pay99.diff_base.base.IDiff;
import com.pay99.diff_base.base.IToastDiff;
import com.taxis99.R;

public class WalletToastNew {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Toast f32726a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static TextView f32727b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static ImageView f32728c;

    /* renamed from: d */
    private static Context f32729d = ApplicationContextProvider.Companion.getContext();

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m24769e() {
        f32726a = new Toast(f32729d);
        IDiff diffValue = DiffUtil.INSTANCE.getDiffValue(DiffConstants.DIFF_WALLET_TOAST);
        if (diffValue instanceof IToastDiff) {
            f32726a = ((IToastDiff) diffValue).configToast(f32729d, f32726a);
        }
        Toast toast = f32726a;
        if (toast != null && toast.getView() != null) {
            f32727b = (TextView) f32726a.getView().findViewById(R.id.toast_msg_tv);
            f32728c = (ImageView) f32726a.getView().findViewById(R.id.toast_icon_iv);
        }
    }

    public static void showSuccessMsg(Context context, final String str) {
        m24765a(new Runnable() {
            public void run() {
                if (WalletToastNew.f32726a == null) {
                    WalletToastNew.m24769e();
                }
                if (WalletToastNew.f32728c != null && WalletToastNew.f32727b != null) {
                    WalletToastNew.f32727b.setText(str);
                    if (WalletToastNew.f32728c.getVisibility() != 0) {
                        WalletToastNew.f32728c.setVisibility(0);
                    }
                    WalletToastNew.f32728c.setImageResource(R.drawable.wallet_toast_icon_successful);
                    WalletToastNew.f32726a.setDuration(0);
                    SystemUtils.showToast(WalletToastNew.f32726a);
                }
            }
        });
    }

    public static void showFailedMsg(Context context, final String str) {
        m24765a(new Runnable() {
            public void run() {
                if (WalletToastNew.f32726a == null) {
                    WalletToastNew.m24769e();
                }
                if (WalletToastNew.f32728c != null && WalletToastNew.f32727b != null) {
                    WalletToastNew.f32727b.setText(str);
                    if (WalletToastNew.f32728c.getVisibility() != 0) {
                        WalletToastNew.f32728c.setVisibility(0);
                    }
                    WalletToastNew.f32728c.setImageResource(R.drawable.wallet_toast_icon_fail);
                    WalletToastNew.f32726a.setDuration(0);
                    SystemUtils.showToast(WalletToastNew.f32726a);
                }
            }
        });
    }

    public static void showMsg(Context context, final String str) {
        m24765a(new Runnable() {
            public void run() {
                if (WalletToastNew.f32726a == null) {
                    WalletToastNew.m24769e();
                }
                if (WalletToastNew.f32728c != null && WalletToastNew.f32727b != null) {
                    WalletToastNew.f32727b.setText(str);
                    WalletToastNew.f32728c.setImageBitmap((Bitmap) null);
                    WalletToastNew.f32728c.setVisibility(8);
                    WalletToastNew.f32726a.setDuration(0);
                    SystemUtils.showToast(WalletToastNew.f32726a);
                }
            }
        });
    }

    public static void cancel() {
        m24765a(new Runnable() {
            public void run() {
                if (WalletToastNew.f32726a != null) {
                    WalletToastNew.f32726a.cancel();
                }
            }
        });
    }

    /* renamed from: a */
    private static void m24765a(Runnable runnable) {
        WalletExecutors.postToMain(0, runnable);
    }
}
