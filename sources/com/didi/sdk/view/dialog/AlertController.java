package com.didi.sdk.view.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class AlertController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AlertDialogFragment f40653a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f40654b;

    /* renamed from: c */
    private View f40655c;

    /* renamed from: d */
    private LinearLayout f40656d;

    /* renamed from: e */
    private ImageView f40657e;

    /* renamed from: f */
    private TextView f40658f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f40659g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f40660h;

    /* renamed from: i */
    private TextView f40661i;

    /* renamed from: j */
    private ImageView f40662j;

    /* renamed from: k */
    private View f40663k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CheckBox f40664l;

    /* renamed from: m */
    private TextView f40665m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View f40666n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public View f40667o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View f40668p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public View f40669q;

    /* renamed from: r */
    private Button f40670r;

    /* renamed from: s */
    private Button f40671s;

    /* renamed from: t */
    private Button f40672t;

    /* renamed from: u */
    private FrameLayout f40673u;

    /* renamed from: v */
    private LinearLayout f40674v;

    /* renamed from: w */
    private View f40675w;

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
        HONGBAO,
        WHITECORRECT
    }

    public AlertController(LayoutInflater layoutInflater, AlertDialogFragment alertDialogFragment) {
        this.f40654b = layoutInflater.inflate(R.layout.view_alert_dialog, (ViewGroup) null);
        if (ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonDialogBg() != 0) {
            this.f40654b.setBackgroundResource(ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonDialogBg());
        }
        this.f40675w = this.f40654b.findViewById(R.id.line_divider_content);
        this.f40653a = alertDialogFragment;
        m30524b();
    }

    public void hideDiverContentLine() {
        View view = this.f40675w;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void showDiverContentLine() {
        View view = this.f40675w;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public View getLayout() {
        return this.f40654b;
    }

    public void setIcon(Drawable drawable) {
        this.f40657e.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.f40657e.setBackground(drawable);
        } else {
            this.f40657e.setBackgroundDrawable(drawable);
        }
    }

    public void setIcon(int i) {
        this.f40657e.setVisibility(0);
        this.f40657e.setBackgroundResource(i);
    }

    public void setCheckBoxStatus(CharSequence charSequence, final AlertDialogFragment.RemindCheckboxListener remindCheckboxListener) {
        if (charSequence != null) {
            this.f40663k.setVisibility(0);
            this.f40665m.setText(charSequence);
            this.f40664l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    remindCheckboxListener.onStateChanged(z);
                }
            });
        }
    }

    /* renamed from: com.didi.sdk.view.dialog.AlertController$6 */
    static /* synthetic */ class C140436 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType;

        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|(3:65|66|68)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(68:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|68) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0180 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.sdk.view.dialog.AlertController$IconType[] r0 = com.didi.sdk.view.dialog.AlertController.IconType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType = r0
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.INFO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.HEART     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.ADDRESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.MICRO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.GPS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.PAY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.GUIDE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.TIME     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.COUPON     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.CRASH     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.CHANNEL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.COOLPAD     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.WIFI     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.PINK     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.HUAWEI     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.HUAWEI_RONGYAO     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.BAIDU     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.RIGHT     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.YINGYONGBAO     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.JINLI_YIYONGHUI     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.MEIZU     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.ANZHI     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.SAMSUNG     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.TIANYU     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x012c }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.TUXING     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.WANDOUJIA     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0144 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.TXSHOUJIGUANJIA     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0150 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.SMARTISAN     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x015c }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.LENOVO     // Catch:{ NoSuchFieldError -> 0x015c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015c }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015c }
            L_0x015c:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0168 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.HONGBAO     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0174 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.SAMSUNG_S6     // Catch:{ NoSuchFieldError -> 0x0174 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0174 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0174 }
            L_0x0174:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x0180 }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.DYNAPRIC     // Catch:{ NoSuchFieldError -> 0x0180 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0180 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0180 }
            L_0x0180:
                int[] r0 = $SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType     // Catch:{ NoSuchFieldError -> 0x018c }
                com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.WHITECORRECT     // Catch:{ NoSuchFieldError -> 0x018c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x018c }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x018c }
            L_0x018c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.view.dialog.AlertController.C140436.<clinit>():void");
        }
    }

    public void setIcon(IconType iconType) {
        int i = C140436.$SwitchMap$com$didi$sdk$view$dialog$AlertController$IconType[iconType.ordinal()];
        int i2 = R.drawable.common_dialog_icon_channel;
        switch (i) {
            case 2:
                i2 = R.drawable.common_dialog_icon_heart;
                break;
            case 3:
                i2 = R.drawable.common_dialog_icon_address;
                break;
            case 4:
                i2 = R.drawable.common_dialog_icon_micro_error;
                break;
            case 5:
                i2 = R.drawable.common_dialog_icon_gps_error;
                break;
            case 6:
                i2 = R.drawable.common_dialog_icon_pay;
                break;
            case 7:
                i2 = R.drawable.common_dialog_cancel_guide_icon;
                break;
            case 8:
                i2 = R.drawable.dialog_icn_time;
                break;
            case 9:
            case 14:
                i2 = R.drawable.dialog_ad_pic_ticket;
                break;
            case 10:
                i2 = R.drawable.common_dialog_icon_crash;
                break;
            case 11:
            case 12:
                break;
            case 13:
                i2 = R.drawable.common_dialog_icon_wifi;
                break;
            case 15:
                i2 = R.drawable.common_dialog_icon_huawei;
                break;
            case 16:
                i2 = R.drawable.common_dialog_icon_rongyao;
                break;
            case 17:
                i2 = R.drawable.common_dialog_icon_baidu;
                break;
            case 18:
                i2 = R.drawable.dialog_icon_correct;
                break;
            case 19:
                i2 = R.drawable.common_dialog_icon_yingyongbao;
                break;
            case 20:
                i2 = R.drawable.common_dialog_icon_jinli;
                break;
            case 21:
                i2 = R.drawable.common_dialog_icon_meizu;
                break;
            case 22:
                i2 = R.drawable.common_dialog_icon_anzhi;
                break;
            case 23:
                i2 = R.drawable.common_dialog_icon_samsung;
                break;
            case 24:
                i2 = R.drawable.common_dialog_icon_tianyu;
                break;
            case 25:
                i2 = R.drawable.common_dialog_icon_tuxing;
                break;
            case 26:
                i2 = R.drawable.common_dialog_icon_wandoujia;
                break;
            case 27:
                i2 = R.drawable.common_dialog_icon_txshoujiguanjia;
                break;
            case 28:
                i2 = R.drawable.common_dialog_icon_smartisan;
                break;
            case 29:
                i2 = R.drawable.common_dialog_icon_lenovo;
                break;
            case 30:
                i2 = R.drawable.common_dialog_icon_hongbao;
                break;
            case 31:
                i2 = R.drawable.common_dialog_icon_samsung_s6;
                break;
            case 32:
                i2 = R.drawable.common_dialog_icon_price_rising;
                break;
            case 33:
                i2 = R.drawable.common_dialog_icon_white_correct;
                break;
            default:
                i2 = R.drawable.common_dialog_icon_info;
                break;
        }
        setIcon(i2);
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f40658f.setVisibility(0);
            this.f40658f.setText(charSequence);
        }
    }

    public String getTitle() {
        TextView textView = this.f40658f;
        return textView != null ? textView.getText().toString() : "";
    }

    public void setSupprtMullineTitle(boolean z) {
        if (z) {
            this.f40658f.setSingleLine(false);
            this.f40658f.setMaxLines(3);
            return;
        }
        this.f40658f.setSingleLine(true);
        this.f40658f.setMaxLines(1);
    }

    public String getMessage() {
        TextView textView = this.f40659g;
        return textView != null ? textView.getText().toString() : "";
    }

    public void setMessage(CharSequence charSequence) {
        if (charSequence != null) {
            this.f40659g.setVisibility(0);
            this.f40659g.setText(charSequence);
            this.f40659g.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (AlertController.this.f40659g.getLineCount() > 0 && Build.VERSION.SDK_INT >= 16) {
                        AlertController.this.f40659g.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    if (AlertController.this.f40659g.getLineCount() > 1) {
                        AlertController.this.f40659g.setGravity(8388627);
                    } else if (AlertController.this.f40659g.getLineCount() == 1) {
                        AlertController.this.f40659g.setGravity(17);
                    }
                }
            });
        }
    }

    public TextView getTextMessage() {
        return this.f40659g;
    }

    public void setCloseVisible(boolean z) {
        this.f40655c.setVisibility(z ? 0 : 8);
    }

    public void setLink(CharSequence charSequence, final boolean z, boolean z2, AlertDialogFragment.ListenerAdapter listenerAdapter) {
        if (charSequence != null) {
            this.f40661i.setText(charSequence);
            this.f40660h.setVisibility(0);
            if (!z2) {
                this.f40662j.setVisibility(8);
            }
            if (listenerAdapter != null) {
                this.f40660h.setOnClickListener(listenerAdapter);
            }
            if (this.f40663k.getVisibility() == 0) {
                ((RelativeLayout.LayoutParams) this.f40660h.getLayoutParams()).addRule(21);
                this.f40660h.requestLayout();
                return;
            }
            this.f40659g.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    ((RelativeLayout.LayoutParams) AlertController.this.f40660h.getLayoutParams()).addRule((AlertController.this.f40659g.getLineCount() <= 1 || z) ? 13 : 20);
                    AlertController.this.f40660h.requestLayout();
                }
            });
        }
    }

    public void setContentView(View view) {
        this.f40673u.removeAllViews();
        this.f40673u.addView(view);
        this.f40673u.setVisibility(0);
    }

    public void setCheckboxLayout(View view) {
        this.f40674v.removeAllViews();
        this.f40674v.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.f40674v.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30522a() {
        boolean z = true;
        boolean z2 = this.f40655c.getVisibility() == 0;
        boolean z3 = this.f40657e.getVisibility() == 0;
        boolean z4 = this.f40658f.getVisibility() == 0;
        boolean z5 = this.f40659g.getVisibility() == 0;
        if (this.f40663k.getVisibility() != 0) {
            z = false;
        }
        if (z2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f40656d.getLayoutParams();
            layoutParams.setMargins(0, m30520a(10.0f), 0, 0);
            this.f40656d.setLayoutParams(layoutParams);
        }
        if (z3 && z4) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f40658f.getLayoutParams();
            layoutParams2.setMargins(layoutParams2.leftMargin, m30520a(14.0f), layoutParams2.rightMargin, layoutParams2.bottomMargin);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams2.setMarginStart(layoutParams2.leftMargin);
                layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            }
            this.f40658f.setLayoutParams(layoutParams2);
        }
        if ((z3 || z4) && z5) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f40659g.getLayoutParams();
            layoutParams3.setMargins(layoutParams3.leftMargin, m30520a(12.0f), layoutParams3.rightMargin, layoutParams3.bottomMargin);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams3.setMarginStart(layoutParams3.leftMargin);
                layoutParams3.setMarginEnd(layoutParams3.rightMargin);
            }
            this.f40659g.setLayoutParams(layoutParams3);
        }
        if (z3 && !z4 && z5) {
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f40657e.getLayoutParams();
            layoutParams4.setMargins(layoutParams4.leftMargin, layoutParams4.topMargin, layoutParams4.rightMargin, layoutParams4.bottomMargin + m30520a(3.0f));
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams4.setMarginStart(layoutParams4.leftMargin);
                layoutParams4.setMarginEnd(layoutParams4.rightMargin);
            }
            this.f40657e.setLayoutParams(layoutParams4);
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f40663k.getLayoutParams();
            layoutParams5.setMargins(layoutParams5.leftMargin, m30520a(3.0f), layoutParams5.rightMargin, layoutParams5.bottomMargin);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
            }
            this.f40663k.setLayoutParams(layoutParams5);
        }
    }

    /* renamed from: b */
    private void m30524b() {
        View findViewById = this.f40654b.findViewById(R.id.image_close);
        this.f40655c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AlertController.this.f40653a.dismiss();
            }
        });
        this.f40656d = (LinearLayout) this.f40654b.findViewById(R.id.ll_content_root);
        this.f40657e = (ImageView) this.f40654b.findViewById(R.id.image_icon);
        this.f40658f = (TextView) this.f40654b.findViewById(R.id.text_title);
        this.f40659g = (TextView) this.f40654b.findViewById(R.id.text_message);
        this.f40663k = this.f40654b.findViewById(R.id.checkbox_layout);
        this.f40664l = (CheckBox) this.f40654b.findViewById(R.id.checkbox);
        TextView textView = (TextView) this.f40654b.findViewById(R.id.text_checkbox_hint);
        this.f40665m = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AlertController.this.f40664l.setChecked(!AlertController.this.f40664l.isChecked());
            }
        });
        this.f40666n = this.f40654b.findViewById(R.id.ll_btn_area_horizontal);
        this.f40667o = this.f40654b.findViewById(R.id.ll_btn_area_horizontal_1);
        this.f40668p = this.f40654b.findViewById(R.id.ll_btn_area_horizontal_2);
        this.f40669q = this.f40654b.findViewById(R.id.ll_btn_area_vertical);
        this.f40673u = (FrameLayout) this.f40654b.findViewById(R.id.fl_custom_root);
        this.f40674v = (LinearLayout) this.f40654b.findViewById(R.id.checkbox_layout);
        this.f40660h = this.f40654b.findViewById(R.id.link_layout);
        this.f40661i = (TextView) this.f40654b.findViewById(R.id.text_link_hint);
        this.f40662j = (ImageView) this.f40654b.findViewById(R.id.image_link);
    }

    /* renamed from: a */
    private int m30520a(float f) {
        return (int) ((f * this.f40654b.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static class AlertParams {
        public int background = 0;
        public boolean isHideDiverContentLine = false;
        public boolean isSupportMullineTitle = false;
        public AlertDialogFragment.ListenerAdapter linkListener;
        public boolean mCancelable = true;
        public CharSequence mCheckboxHintText;
        public AlertDialogFragment.RemindCheckboxListener mCheckboxListener;
        public final Context mContext;
        public View mCustomCheckLayout;
        public View mCustomContentView;
        public int mDefaultButtonTextColorId = 0;
        public Drawable mIcon;
        public int mIconId = 0;
        public IconType mIconType;
        public final LayoutInflater mInflater;
        public boolean mIsCloseVisible = false;
        public boolean mIsNegativeDefault = false;
        public boolean mIsNeutralDefault = false;
        public boolean mIsPositiveDefault = false;
        public boolean mLinkForceCenter = false;
        public CharSequence mLinkHint;
        public boolean mLinkIconVisible = true;
        public CharSequence mMessage;
        public AlertDialogFragment.ListenerAdapter mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public AlertDialogFragment.ListenerAdapter mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public AlertDialogFragment.OnCancelListener mOnCancelListener;
        public AlertDialogFragment.OnDismissListener mOnDismissListener;
        public AlertDialogFragment.ListenerAdapter mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;

        public void setHideDiverContentLine(boolean z) {
            this.isHideDiverContentLine = z;
        }

        public void setBackground(int i) {
            this.background = i;
        }

        public AlertParams(Context context) {
            this.mContext = context;
            if (context != null) {
                this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
            } else {
                this.mInflater = null;
            }
        }

        public void apply(AlertDialogFragment alertDialogFragment, AlertController alertController) {
            View view = this.mCustomContentView;
            if (view == null) {
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.setIcon(drawable);
                }
                int i = this.mIconId;
                if (i > 0) {
                    alertController.setIcon(i);
                }
                IconType iconType = this.mIconType;
                if (iconType != null) {
                    alertController.setIcon(iconType);
                }
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.setTitle(charSequence);
                }
                CharSequence charSequence2 = this.mMessage;
                if (charSequence2 != null) {
                    alertController.setMessage(charSequence2);
                }
                alertController.setSupprtMullineTitle(this.isSupportMullineTitle);
                if (this.mCheckboxListener != null && !TextUtils.isEmpty(this.mCheckboxHintText)) {
                    alertController.setCheckBoxStatus(this.mCheckboxHintText, this.mCheckboxListener);
                }
                boolean z = this.mIsCloseVisible;
                if (z) {
                    alertController.setCloseVisible(z);
                }
                if (this.mLinkHint != null) {
                    this.linkListener.attachAlertDialogFragment(alertDialogFragment);
                    alertController.setLink(this.mLinkHint, this.mLinkForceCenter, this.mLinkIconVisible, this.linkListener);
                }
                alertController.m30522a();
            } else {
                alertController.setContentView(view);
            }
            if (this.isHideDiverContentLine) {
                alertController.hideDiverContentLine();
            } else {
                alertController.showDiverContentLine();
            }
            View view2 = this.mCustomCheckLayout;
            if (view2 != null) {
                alertController.setCheckboxLayout(view2);
            }
            int i2 = 0;
            if (this.mPositiveButtonListener != null && !TextUtils.isEmpty(this.mPositiveButtonText)) {
                i2 = 1;
            }
            if (this.mNegativeButtonListener != null && !TextUtils.isEmpty(this.mNegativeButtonText)) {
                i2++;
            }
            if (this.mNeutralButtonListener != null && !TextUtils.isEmpty(this.mNeutralButtonText)) {
                i2++;
            }
            if (3 == i2) {
                handleBtnCount3(alertDialogFragment, alertController);
            } else if (2 == i2) {
                handleBtnCount2(alertDialogFragment, alertController);
            } else if (1 == i2) {
                handleBtnCount1(alertDialogFragment, alertController);
            }
            if (this.background != 0) {
                alertController.getLayout().setBackgroundColor(this.background);
            }
        }

        private void handleBtnCount1(AlertDialogFragment alertDialogFragment, AlertController alertController) {
            AlertDialogFragment.ListenerAdapter listenerAdapter;
            CharSequence charSequence;
            CharSequence charSequence2;
            boolean z;
            boolean z2 = false;
            alertController.f40666n.setVisibility(0);
            alertController.f40667o.setVisibility(0);
            Button button = (Button) alertController.f40654b.findViewById(R.id.button_one);
            AlertDialogFragment.ListenerAdapter listenerAdapter2 = this.mPositiveButtonListener;
            if (listenerAdapter2 != null) {
                charSequence2 = this.mPositiveButtonText;
                z = this.mIsPositiveDefault;
            } else {
                listenerAdapter2 = this.mNegativeButtonListener;
                if (listenerAdapter2 != null) {
                    charSequence2 = this.mNegativeButtonText;
                    z = this.mIsNegativeDefault;
                } else {
                    listenerAdapter2 = this.mNeutralButtonListener;
                    if (listenerAdapter2 != null) {
                        charSequence2 = this.mNeutralButtonText;
                        z = this.mIsNeutralDefault;
                    } else {
                        charSequence = "";
                        listenerAdapter = null;
                        setupButton(alertDialogFragment, button, charSequence, listenerAdapter, z2);
                        setupBtnBgWithLRCorner(button, z2);
                    }
                }
            }
            listenerAdapter = listenerAdapter2;
            charSequence = charSequence2;
            z2 = z;
            setupButton(alertDialogFragment, button, charSequence, listenerAdapter, z2);
            setupBtnBgWithLRCorner(button, z2);
        }

        private void handleBtnCount2(AlertDialogFragment alertDialogFragment, AlertController alertController) {
            alertController.f40666n.setVisibility(0);
            alertController.f40668p.setVisibility(0);
            Button button = (Button) alertController.f40654b.findViewById(R.id.button_left);
            Button button2 = (Button) alertController.f40654b.findViewById(R.id.button_right);
            if (this.mPositiveButtonListener == null) {
                AlertDialogFragment alertDialogFragment2 = alertDialogFragment;
                setupButton(alertDialogFragment2, button, this.mNegativeButtonText, this.mNegativeButtonListener, this.mIsNegativeDefault);
                setupBtnBgWithLeftCorner(button, this.mIsNegativeDefault);
                setupButton(alertDialogFragment2, button2, this.mNeutralButtonText, this.mNeutralButtonListener, this.mIsNeutralDefault);
                setupBtnBgWithRightCorner(button2, this.mIsNeutralDefault);
                return;
            }
            AlertDialogFragment.ListenerAdapter listenerAdapter = this.mNegativeButtonListener;
            if (listenerAdapter == null) {
                AlertDialogFragment alertDialogFragment3 = alertDialogFragment;
                setupButton(alertDialogFragment3, button, this.mNeutralButtonText, this.mNeutralButtonListener, this.mIsNeutralDefault);
                setupBtnBgWithLeftCorner(button, this.mIsNeutralDefault);
                setupButton(alertDialogFragment3, button2, this.mPositiveButtonText, this.mPositiveButtonListener, this.mIsPositiveDefault);
                setupBtnBgWithRightCorner(button2, this.mIsPositiveDefault);
            } else if (this.mNeutralButtonListener == null) {
                AlertDialogFragment alertDialogFragment4 = alertDialogFragment;
                setupButton(alertDialogFragment4, button, this.mNegativeButtonText, listenerAdapter, this.mIsNegativeDefault);
                setupBtnBgWithLeftCorner(button, this.mIsNegativeDefault);
                setupButton(alertDialogFragment4, button2, this.mPositiveButtonText, this.mPositiveButtonListener, this.mIsPositiveDefault);
                setupBtnBgWithRightCorner(button2, this.mIsPositiveDefault);
            }
        }

        private void handleBtnCount3(AlertDialogFragment alertDialogFragment, AlertController alertController) {
            alertController.f40669q.setVisibility(0);
            Button button = (Button) alertController.f40669q.findViewById(R.id.button_top_bottom_1);
            Button button2 = (Button) alertController.f40669q.findViewById(R.id.button_top_bottom_2);
            Button button3 = (Button) alertController.f40669q.findViewById(R.id.button_top_bottom_3);
            setupButton(alertDialogFragment, button, this.mPositiveButtonText, this.mPositiveButtonListener, this.mIsPositiveDefault);
            setupBtnBgWithNoCorner(button, this.mIsPositiveDefault);
            setupButton(alertDialogFragment, button2, this.mNeutralButtonText, this.mNeutralButtonListener, this.mIsNeutralDefault);
            setupBtnBgWithNoCorner(button2, this.mIsNeutralDefault);
            setupButton(alertDialogFragment, button3, this.mNegativeButtonText, this.mNegativeButtonListener, this.mIsNegativeDefault);
            setupBtnBgWithLRCorner(button3, this.mIsNegativeDefault);
        }

        private void setupButton(AlertDialogFragment alertDialogFragment, Button button, CharSequence charSequence, AlertDialogFragment.ListenerAdapter listenerAdapter, boolean z) {
            if (alertDialogFragment != null && button != null && listenerAdapter != null && !TextUtils.isEmpty(charSequence)) {
                button.setText(charSequence);
                listenerAdapter.attachAlertDialogFragment(alertDialogFragment);
                button.setOnClickListener(listenerAdapter);
                if (z) {
                    int defaultButtonTextColor = ProductControllerStyleManager.getInstance().getProductThemeStyle().getDefaultButtonTextColor();
                    if (defaultButtonTextColor == 0) {
                        defaultButtonTextColor = this.mContext.getResources().getColor(R.color.common_dialog_recommend_option_txt_color);
                    }
                    button.setTextColor(defaultButtonTextColor);
                }
            }
        }

        private void setupBtnBgWithLRCorner(Button button, boolean z) {
            if (button != null && z) {
                if (ProductControllerStyleManager.getInstance().getProductThemeStyle() == null || ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonButtonBackground() == 0) {
                    button.setBackgroundResource(R.drawable.common_dialog_btn_bg_shape_lr_recommend_selector);
                } else {
                    button.setBackgroundResource(ProductControllerStyleManager.getInstance().getProductThemeStyle().getCommonButtonBackground());
                }
            }
        }

        private void setupBtnBgWithNoCorner(Button button, boolean z) {
            if (button != null && z) {
                button.setBackgroundResource(R.drawable.common_dialog_btn_bg_shape_n_recommend_selector);
            }
        }

        private void setupBtnBgWithLeftCorner(Button button, boolean z) {
            if (button != null && z) {
                button.setBackgroundResource(R.drawable.common_dialog_btn_bg_shape_l_recommend_selector);
            }
        }

        private void setupBtnBgWithRightCorner(Button button, boolean z) {
            if (button != null && z) {
                button.setBackgroundResource(R.drawable.common_dialog_btn_bg_shape_r_recommend_selector);
            }
        }
    }
}
