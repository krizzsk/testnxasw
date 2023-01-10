package com.didi.sdk.login.view;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.log.Logger;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.taxis99.R;

@Deprecated
public class CommonDialog extends Dialog {

    /* renamed from: a */
    private static ProgressDialog f39445a = null;

    /* renamed from: b */
    private static boolean f39446b = false;

    /* renamed from: A */
    private String f39447A;

    /* renamed from: B */
    private String f39448B;

    /* renamed from: C */
    private String f39449C;

    /* renamed from: D */
    private View f39450D;

    /* renamed from: E */
    private boolean f39451E = false;

    /* renamed from: F */
    private boolean f39452F = false;

    /* renamed from: G */
    private boolean f39453G = true;

    /* renamed from: H */
    private boolean f39454H = false;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public CheckedTextView f39455I;

    /* renamed from: J */
    private CharSequence f39456J;

    /* renamed from: K */
    private CharSequence f39457K;

    /* renamed from: L */
    private CharSequence f39458L;

    /* renamed from: M */
    private BitmapDrawable f39459M = null;

    /* renamed from: N */
    private Bitmap f39460N = null;

    /* renamed from: O */
    private View.OnClickListener f39461O = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CommonDialog.this.f39455I.toggle();
            Logger.m29536d("checkbox state :" + CommonDialog.this.f39455I.isChecked(), new Object[0]);
        }
    };

    /* renamed from: P */
    private View.OnClickListener f39462P = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CommonDialog.this.dismiss();
            if (CommonDialog.this.f39469i != null) {
                if (view.getId() == R.id.btnOnlySubmit) {
                    CommonDialog.this.f39469i.submitOnly();
                } else if (view.getId() == R.id.btnSubmit) {
                    CommonDialog.this.f39469i.submit();
                } else if (view.getId() == R.id.btnCancel) {
                    CommonDialog.this.f39469i.cancel();
                } else if (view.getId() == R.id.btnFirst) {
                    CommonDialog.this.f39469i.firstClick();
                } else if (view.getId() == R.id.btnSecond) {
                    CommonDialog.this.f39469i.secondClick();
                } else if (view.getId() == R.id.btnThird) {
                    CommonDialog.this.f39469i.thirdClick();
                }
            }
        }
    };

    /* renamed from: c */
    private String f39463c;

    /* renamed from: d */
    private String f39464d;

    /* renamed from: e */
    private String f39465e;

    /* renamed from: f */
    private String[] f39466f;

    /* renamed from: g */
    private IconType f39467g;

    /* renamed from: h */
    private ButtonType f39468h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CommonDialogListener f39469i;

    /* renamed from: j */
    private TextView f39470j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public TextView f39471k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TextView f39472l;

    /* renamed from: m */
    private ImageView f39473m;

    /* renamed from: n */
    private Button f39474n;

    /* renamed from: o */
    private Button f39475o;

    /* renamed from: p */
    private Button f39476p;

    /* renamed from: q */
    private Button f39477q;

    /* renamed from: r */
    private Button f39478r;

    /* renamed from: s */
    private Button f39479s;

    /* renamed from: t */
    private LinearLayout f39480t;

    /* renamed from: u */
    private LinearLayout f39481u;

    /* renamed from: v */
    private LinearLayout f39482v;

    /* renamed from: w */
    private LinearLayout f39483w;

    /* renamed from: x */
    private String f39484x;

    /* renamed from: y */
    private String f39485y;

    /* renamed from: z */
    private String f39486z;

    public enum ButtonType {
        ONE,
        TWO,
        THREE
    }

    public interface CommonDialogListener {
        void cancel();

        void firstClick();

        void secondClick();

        void submit();

        void submitOnly();

        void thirdClick();
    }

    public enum IconType {
        INFO,
        HEART,
        ADDRESS,
        MICRO,
        GPS,
        RIGHT,
        FACE,
        RED,
        PAY,
        GUIDE,
        TIME,
        COUPON,
        CRASH,
        PINK,
        DYNAPRIC,
        HUAWEI,
        CHANNEL,
        COOLPAD,
        WIFI,
        HUAWEI_RONGYAO,
        BAIDU,
        YINGYONGBAO,
        JINLI_YIYONGHUI,
        MEIZU,
        ANZHI,
        SAMSUNG,
        SAMSUNG_S6,
        TIANYU,
        TUXING,
        WANDOUJIA,
        TXSHOUJIGUANJIA,
        SMARTISAN,
        LENOVO,
        HONGBAO
    }

    public void updatePinkIconShow(String str) {
    }

    public CommonDialog(Context context) {
        super(context, R.style.CommonDialog);
    }

    public static void loadingDialog(Context context, String str, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        if (context != null) {
            m29712a(context);
            f39445a.setMessage(str);
            f39445a.setCancelable(z);
            f39445a.setOnCancelListener(onCancelListener);
            SystemUtils.showDialog(f39445a);
            f39446b = true;
        }
    }

    public static void removeLoadingDialog() {
        ProgressDialog progressDialog = f39445a;
        if (progressDialog != null) {
            Context context = progressDialog.getContext();
            if (context != null) {
                if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                    f39445a.dismiss();
                    f39445a = null;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        f39446b = false;
    }

    public static boolean isLoading() {
        return f39446b;
    }

    /* renamed from: a */
    private static ProgressDialog m29712a(Context context) {
        if (f39445a == null) {
            f39445a = new ProgressDialog(context);
        }
        return f39445a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.v_common_dialog);
        m29719b(getContext());
    }

    /* renamed from: b */
    private void m29719b(Context context) {
        View findViewById = findViewById(R.id.commonDialogRoot);
        if (ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonDialogBg() != 0) {
            findViewById.setBackgroundResource(ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonDialogBg());
        }
        this.f39480t = (LinearLayout) findViewById(R.id.layoutOnlySubmitBtn);
        this.f39481u = (LinearLayout) findViewById(R.id.layoutSubmitCancelBtn);
        this.f39482v = (LinearLayout) findViewById(R.id.layoutThreeBtn);
        ImageView imageView = (ImageView) findViewById(R.id.imgViewIcon);
        this.f39473m = imageView;
        imageView.setVisibility(8);
        this.f39450D = findViewById(R.id.imgViewCloseDialog);
        TextView textView = (TextView) findViewById(R.id.txtViewTitle);
        this.f39470j = textView;
        textView.setText(this.f39463c);
        TextView textView2 = (TextView) findViewById(R.id.txtViewContent);
        this.f39471k = textView2;
        textView2.setText(this.f39464d);
        TextView textView3 = (TextView) findViewById(R.id.txtViewOnlyContent);
        this.f39472l = textView3;
        textView3.setText(this.f39465e);
        this.f39483w = (LinearLayout) findViewById(R.id.dialog_common_area);
        m29721c();
        Button button = (Button) findViewById(R.id.btnOnlySubmit);
        this.f39474n = button;
        button.setOnClickListener(this.f39462P);
        if (TextUtils.isEmpty(this.f39484x)) {
            this.f39484x = context.getString(R.string.confirm);
        }
        this.f39474n.setText(this.f39484x);
        Button button2 = (Button) findViewById(R.id.btnSubmit);
        this.f39475o = button2;
        button2.setOnClickListener(this.f39462P);
        if (TextUtils.isEmpty(this.f39485y)) {
            this.f39485y = context.getString(R.string.confirm);
        }
        this.f39475o.setText(this.f39485y);
        Button button3 = (Button) findViewById(R.id.btnCancel);
        this.f39476p = button3;
        button3.setOnClickListener(this.f39462P);
        if (TextUtils.isEmpty(this.f39486z)) {
            this.f39486z = context.getString(R.string.cancel);
        }
        this.f39476p.setText(this.f39486z);
        this.f39477q = (Button) findViewById(R.id.btnFirst);
        int commonButtonBackground = ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonButtonBackground();
        if (commonButtonBackground != 0) {
            this.f39474n.setBackgroundResource(commonButtonBackground);
            this.f39475o.setBackgroundResource(commonButtonBackground);
        }
        this.f39477q.setOnClickListener(this.f39462P);
        this.f39477q.setText(this.f39447A);
        Button button4 = (Button) findViewById(R.id.btnSecond);
        this.f39478r = button4;
        button4.setOnClickListener(this.f39462P);
        this.f39478r.setText(this.f39448B);
        Button button5 = (Button) findViewById(R.id.btnThird);
        this.f39479s = button5;
        button5.setOnClickListener(this.f39462P);
        this.f39479s.setText(this.f39449C);
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.checkbox);
        this.f39455I = checkedTextView;
        checkedTextView.setOnClickListener(this.f39461O);
        this.f39450D.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CommonDialog.this.dismiss();
            }
        });
        m29724d();
    }

    public void setCheckboxVisibility(boolean z) {
        this.f39452F = z;
    }

    public boolean isChecked() {
        CheckedTextView checkedTextView = this.f39455I;
        if (checkedTextView == null) {
            return false;
        }
        return checkedTextView.isChecked();
    }

    public void setCloseDialogVisiblity(boolean z) {
        this.f39454H = z;
    }

    /* renamed from: c */
    private void m29722c(Context context) {
        Drawable drawable;
        this.f39473m.setVisibility(0);
        if (this.f39467g == null) {
            m29715a((int) R.drawable.common_dialog_icon_info);
            return;
        }
        switch (C132616.$SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType[this.f39467g.ordinal()]) {
            case 1:
                drawable = m29716b((int) R.drawable.common_dialog_icon_info);
                break;
            case 2:
                drawable = m29716b((int) R.drawable.common_dialog_icon_heart);
                break;
            case 3:
                drawable = m29716b((int) R.drawable.common_dialog_icon_address);
                break;
            case 4:
                drawable = m29716b((int) R.drawable.common_dialog_icon_micro_error);
                break;
            case 5:
                drawable = m29716b((int) R.drawable.common_dialog_icon_gps_error);
                break;
            case 6:
                drawable = m29716b((int) R.drawable.common_dialog_icon_pay);
                break;
            case 7:
                drawable = m29716b((int) R.drawable.common_dialog_cancel_guide_icon);
                break;
            case 8:
                drawable = m29716b((int) R.drawable.dialog_icn_time);
                break;
            case 9:
                drawable = m29716b((int) R.drawable.dialog_ad_pic_ticket);
                break;
            case 10:
                drawable = m29716b((int) R.drawable.common_dialog_icon_crash);
                break;
            case 11:
                drawable = m29716b((int) R.drawable.common_dialog_icon_channel);
                break;
            case 12:
                drawable = m29716b((int) R.drawable.common_dialog_icon_channel);
                break;
            case 13:
                drawable = m29716b((int) R.drawable.common_dialog_icon_wifi);
                break;
            case 14:
                drawable = this.f39459M;
                if (drawable == null) {
                    drawable = m29716b((int) R.drawable.dialog_ad_pic_ticket);
                    break;
                }
                break;
            case 15:
                drawable = m29716b((int) R.drawable.common_dialog_icon_huawei);
                break;
            case 16:
                drawable = m29716b((int) R.drawable.common_dialog_icon_rongyao);
                break;
            case 17:
                drawable = m29716b((int) R.drawable.common_dialog_icon_baidu);
                break;
            case 18:
                drawable = m29716b((int) R.drawable.dialog_icon_correct);
                break;
            case 19:
                drawable = m29716b((int) R.drawable.common_dialog_icon_yingyongbao);
                break;
            case 20:
                drawable = m29716b((int) R.drawable.common_dialog_icon_jinli);
                break;
            case 21:
                drawable = m29716b((int) R.drawable.common_dialog_icon_meizu);
                break;
            case 22:
                drawable = m29716b((int) R.drawable.common_dialog_icon_anzhi);
                break;
            case 23:
                drawable = m29716b((int) R.drawable.common_dialog_icon_samsung);
                break;
            case 24:
                drawable = m29716b((int) R.drawable.common_dialog_icon_tianyu);
                break;
            case 25:
                drawable = m29716b((int) R.drawable.common_dialog_icon_tuxing);
                break;
            case 26:
                drawable = m29716b((int) R.drawable.common_dialog_icon_wandoujia);
                break;
            case 27:
                drawable = m29716b((int) R.drawable.common_dialog_icon_txshoujiguanjia);
                break;
            case 28:
                drawable = m29716b((int) R.drawable.common_dialog_icon_smartisan);
                break;
            case 29:
                drawable = m29716b((int) R.drawable.common_dialog_icon_lenovo);
                break;
            case 30:
                drawable = m29716b((int) R.drawable.common_dialog_icon_hongbao);
                break;
            case 31:
                drawable = m29716b((int) R.drawable.common_dialog_icon_samsung_s6);
                break;
            case 32:
                if (this.f39460N == null) {
                    drawable = m29716b((int) R.drawable.common_dialog_icon_price_rising);
                    break;
                } else {
                    drawable = new BitmapDrawable(this.f39460N);
                    break;
                }
            default:
                drawable = m29716b((int) R.drawable.common_dialog_icon_info);
                break;
        }
        this.f39473m.setBackgroundDrawable(drawable);
        if (!this.f39453G) {
            this.f39473m.setVisibility(8);
        }
    }

    /* renamed from: com.didi.sdk.login.view.CommonDialog$6 */
    static /* synthetic */ class C132616 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType;

        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|(3:63|64|66)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|66) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0150 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x015c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0168 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0174 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.sdk.login.view.CommonDialog$IconType[] r0 = com.didi.sdk.login.view.CommonDialog.IconType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType = r0
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.INFO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.HEART     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.ADDRESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.MICRO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.GPS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.PAY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.GUIDE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.TIME     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.COUPON     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.CRASH     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.CHANNEL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.COOLPAD     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.WIFI     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.PINK     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.HUAWEI     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.HUAWEI_RONGYAO     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.BAIDU     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.RIGHT     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.YINGYONGBAO     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.JINLI_YIYONGHUI     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.MEIZU     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.ANZHI     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.SAMSUNG     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.TIANYU     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x012c }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.TUXING     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.WANDOUJIA     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0144 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.TXSHOUJIGUANJIA     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0150 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.SMARTISAN     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x015c }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.LENOVO     // Catch:{ NoSuchFieldError -> 0x015c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015c }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015c }
            L_0x015c:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0168 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.HONGBAO     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0174 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.SAMSUNG_S6     // Catch:{ NoSuchFieldError -> 0x0174 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0174 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0174 }
            L_0x0174:
                int[] r0 = $SwitchMap$com$didi$sdk$login$view$CommonDialog$IconType     // Catch:{ NoSuchFieldError -> 0x0180 }
                com.didi.sdk.login.view.CommonDialog$IconType r1 = com.didi.sdk.login.view.CommonDialog.IconType.DYNAPRIC     // Catch:{ NoSuchFieldError -> 0x0180 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0180 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0180 }
            L_0x0180:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.login.view.CommonDialog.C132616.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m29715a(int i) {
        this.f39473m.setBackgroundDrawable(getContext().getResources().getDrawable(i));
    }

    /* renamed from: b */
    private Drawable m29716b(int i) {
        return getContext().getResources().getDrawable(i);
    }

    /* renamed from: a */
    private void m29714a() {
        if (TextUtils.isEmpty(this.f39463c)) {
            this.f39470j.setVisibility(8);
            this.f39471k.setVisibility(8);
            this.f39472l.setVisibility(0);
            return;
        }
        this.f39470j.setVisibility(0);
        this.f39471k.setVisibility(0);
        this.f39472l.setVisibility(8);
    }

    /* renamed from: b */
    private void m29718b() {
        if (this.f39468h == null) {
            this.f39480t.setVisibility(0);
            this.f39481u.setVisibility(8);
            return;
        }
        if (ButtonType.ONE.toString().equals(this.f39468h.name())) {
            this.f39480t.setVisibility(0);
        } else if (ButtonType.TWO.toString().equals(this.f39468h.name())) {
            this.f39481u.setVisibility(0);
            this.f39480t.setVisibility(8);
        } else if (ButtonType.THREE.toString().equals(this.f39468h.name())) {
            this.f39482v.setVisibility(0);
            this.f39480t.setVisibility(8);
            this.f39481u.setVisibility(8);
        }
        if (this.f39454H) {
            this.f39450D.setVisibility(0);
        } else {
            this.f39450D.setVisibility(8);
        }
    }

    /* renamed from: c */
    private void m29721c() {
        String[] strArr = this.f39466f;
        if (strArr != null && strArr.length != 0) {
            if (strArr.length < 2) {
                this.f39464d = strArr[0];
            } else {
                this.f39483w.removeAllViews();
            }
        }
    }

    public void setTitleContent(String str, String str2) {
        this.f39463c = str;
        this.f39464d = str2;
        this.f39465e = str2;
    }

    public void setTitleContent(String str, String[] strArr) {
        this.f39463c = str;
        if (strArr != null && strArr.length != 0) {
            if (strArr.length < 2) {
                this.f39464d = strArr[0];
                this.f39465e = strArr[0];
                return;
            }
            this.f39466f = strArr;
        }
    }

    public void setIconType(IconType iconType) {
        this.f39467g = iconType;
    }

    public void setButtonType(ButtonType buttonType) {
        this.f39468h = buttonType;
    }

    public void setListener(CommonDialogListener commonDialogListener) {
        this.f39469i = commonDialogListener;
    }

    public void setSubmitBtnText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f39484x = str;
            this.f39485y = str;
        }
    }

    public void setCancelBtnText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f39486z = str;
        }
    }

    /* renamed from: d */
    private void m29724d() {
        CharSequence charSequence = this.f39456J;
        if (charSequence != null && this.f39457K != null && this.f39458L != null) {
            this.f39477q.setText(charSequence);
            this.f39478r.setText(this.f39457K);
            this.f39479s.setText(this.f39458L);
            this.f39456J = null;
            this.f39457K = null;
            this.f39458L = null;
        }
    }

    public void setThreeBtnText(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f39456J = charSequence;
        this.f39457K = charSequence2;
        this.f39458L = charSequence3;
    }

    public void setThreeBtnText(String str, String str2, String str3) {
        this.f39447A = str;
        this.f39448B = str2;
        this.f39449C = str3;
    }

    public void setIconVisible(boolean z) {
        this.f39453G = z;
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
    }

    public void show() {
        super.show();
        m29722c(getContext());
        m29718b();
        m29714a();
        this.f39451E = true;
        Logger.m29536d("showCheckBox :" + this.f39452F, new Object[0]);
        if (this.f39452F) {
            this.f39455I.setVisibility(0);
        } else {
            this.f39455I.setVisibility(8);
        }
        try {
            m29725e();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private void m29725e() {
        TextView textView = this.f39471k;
        if (textView != null) {
            textView.post(new Runnable() {
                public void run() {
                    if (CommonDialog.this.f39471k.getLineCount() > 1) {
                        CommonDialog.this.f39471k.setGravity(GravityCompat.START);
                    } else {
                        CommonDialog.this.f39471k.setGravity(1);
                    }
                }
            });
        }
        TextView textView2 = this.f39472l;
        if (textView2 != null) {
            textView2.post(new Runnable() {
                public void run() {
                    if (CommonDialog.this.f39472l.getLineCount() > 1) {
                        CommonDialog.this.f39472l.setGravity(GravityCompat.START);
                    } else {
                        CommonDialog.this.f39472l.setGravity(1);
                    }
                }
            });
        }
    }

    public void dismiss() {
        super.dismiss();
        this.f39451E = false;
    }

    public boolean isShowing() {
        return this.f39451E;
    }
}
