package com.didi.beatles.p101im.views.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.views.dialog.IMAlertDialogFragment;
import com.didi.beatles.p101im.views.richtextview.IMRichTextView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.dialog.IMAlertController */
public class IMAlertController {

    /* renamed from: a */
    private View f12002a;

    /* renamed from: b */
    private ImageView f12003b;

    /* renamed from: c */
    private IMRichTextView f12004c;

    /* renamed from: d */
    private IMRichTextView f12005d;

    /* renamed from: e */
    private Button f12006e;

    /* renamed from: f */
    private Button f12007f;

    /* renamed from: g */
    private Button f12008g;

    /* renamed from: h */
    private FrameLayout f12009h;

    /* renamed from: i */
    private LinearLayout f12010i;

    /* renamed from: j */
    private CheckBox f12011j;

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertController$IconType */
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

    public IMAlertController(LayoutInflater layoutInflater) {
        this.f12002a = layoutInflater.inflate(R.layout.im_view_alert_dialog, (ViewGroup) null);
        m10317a();
    }

    public View getLayout() {
        return this.f12002a;
    }

    public void setTitle(CharSequence charSequence) {
        this.f12004c.setVisibility(0);
        if (charSequence.length() > 12) {
            this.f12004c.setText(charSequence.subSequence(0, 12));
            this.f12004c.append("...");
            return;
        }
        this.f12004c.setText(charSequence);
    }

    public void setMessage(CharSequence charSequence) {
        this.f12005d.setVisibility(0);
        this.f12005d.setText(charSequence);
    }

    public void setContentView(View view) {
        this.f12009h.removeAllViews();
        this.f12009h.addView(view);
        this.f12009h.setVisibility(0);
    }

    public void setIcon(Drawable drawable) {
        this.f12003b.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.f12003b.setImageResource(i);
    }

    public void setCheckBoxStatus(boolean z, final IMAlertDialogFragment.RemindCheckboxListener remindCheckboxListener) {
        this.f12010i.setVisibility(z ? 0 : 8);
        this.f12011j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                remindCheckboxListener.onStateChanged(z);
            }
        });
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertController$2 */
    static /* synthetic */ class C48802 {

        /* renamed from: $SwitchMap$com$didi$beatles$im$views$dialog$IMAlertController$IconType */
        static final /* synthetic */ int[] f12012x9da8ba80;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.beatles.im.views.dialog.IMAlertController$IconType[] r0 = com.didi.beatles.p101im.views.dialog.IMAlertController.IconType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12012x9da8ba80 = r0
                com.didi.beatles.im.views.dialog.IMAlertController$IconType r1 = com.didi.beatles.p101im.views.dialog.IMAlertController.IconType.INFO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12012x9da8ba80     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.beatles.im.views.dialog.IMAlertController$IconType r1 = com.didi.beatles.p101im.views.dialog.IMAlertController.IconType.ADDRESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.views.dialog.IMAlertController.C48802.<clinit>():void");
        }
    }

    public void setIcon(IconType iconType) {
        int i = C48802.f12012x9da8ba80[iconType.ordinal()];
        int i2 = R.drawable.im_common_dialog_icon_info;
        if (i != 1 && i == 2) {
            i2 = R.drawable.im_common_dialog_icon_address;
        }
        setIcon(i2);
    }

    public void setIconVisible(boolean z) {
        this.f12003b.setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    private void m10317a() {
        this.f12006e = (Button) this.f12002a.findViewById(R.id.button_positive);
        this.f12007f = (Button) this.f12002a.findViewById(R.id.button_negative);
        this.f12008g = (Button) this.f12002a.findViewById(R.id.button_neutral);
        this.f12003b = (ImageView) this.f12002a.findViewById(R.id.image_icon);
        this.f12004c = (IMRichTextView) this.f12002a.findViewById(R.id.text_title);
        this.f12005d = (IMRichTextView) this.f12002a.findViewById(R.id.text_message);
        this.f12009h = (FrameLayout) this.f12002a.findViewById(R.id.content_view);
        this.f12010i = (LinearLayout) this.f12002a.findViewById(R.id.checkbox_layout);
        this.f12011j = (CheckBox) this.f12002a.findViewById(R.id.checkbox);
        this.f12006e.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
    }

    public void setButton(int i, CharSequence charSequence, View.OnClickListener onClickListener) {
        if (i == -3) {
            this.f12008g.setVisibility(0);
            this.f12008g.setText(charSequence);
            this.f12008g.setOnClickListener(onClickListener);
        } else if (i == -2) {
            this.f12007f.setVisibility(0);
            this.f12007f.setText(charSequence);
            this.f12007f.setOnClickListener(onClickListener);
        } else if (i == -1) {
            this.f12006e.setVisibility(0);
            this.f12006e.setText(charSequence);
            this.f12006e.setOnClickListener(onClickListener);
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertController$AlertParams */
    public static class AlertParams {
        public boolean mCancelable;
        public boolean mCheckboxIsShow;
        public IMAlertDialogFragment.RemindCheckboxListener mCheckboxListener;
        public View mContentView;
        public final Context mContext;
        public Drawable mIcon;
        public int mIconId = 0;
        public IconType mIconType;
        public final LayoutInflater mInflater;
        public boolean mIsIconVisible = true;
        public CharSequence mMessage;
        public IMAlertDialogFragment.ListenerAdapter mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public IMAlertDialogFragment.ListenerAdapter mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public IMAlertDialogFragment.OnCancelListener mOnCancelListener;
        public IMAlertDialogFragment.OnDismissListener mOnDismissListener;
        public IMAlertDialogFragment.ListenerAdapter mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;

        public AlertParams(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void apply(IMAlertDialogFragment iMAlertDialogFragment, IMAlertController iMAlertController) {
            IMAlertDialogFragment.RemindCheckboxListener remindCheckboxListener;
            CharSequence charSequence = this.mTitle;
            if (charSequence != null) {
                iMAlertController.setTitle(charSequence);
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                iMAlertController.setMessage(charSequence2);
            }
            View view = this.mContentView;
            if (view != null) {
                iMAlertController.setContentView(view);
            }
            Drawable drawable = this.mIcon;
            if (drawable != null) {
                iMAlertController.setIcon(drawable);
            }
            int i = this.mIconId;
            if (i > 0) {
                iMAlertController.setIcon(i);
            }
            IconType iconType = this.mIconType;
            if (iconType != null) {
                iMAlertController.setIcon(iconType);
            }
            iMAlertController.setIconVisible(this.mIsIconVisible);
            boolean z = this.mCheckboxIsShow;
            if (z && (remindCheckboxListener = this.mCheckboxListener) != null) {
                iMAlertController.setCheckBoxStatus(z, remindCheckboxListener);
            }
            if (this.mPositiveButtonText != null) {
                IMAlertDialogFragment.ListenerAdapter listenerAdapter = this.mPositiveButtonListener;
                if (listenerAdapter != null) {
                    listenerAdapter.attachAlertDialogFragment(iMAlertDialogFragment);
                }
                iMAlertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener);
            }
            if (this.mNegativeButtonText != null) {
                IMAlertDialogFragment.ListenerAdapter listenerAdapter2 = this.mNegativeButtonListener;
                if (listenerAdapter2 != null) {
                    listenerAdapter2.attachAlertDialogFragment(iMAlertDialogFragment);
                }
                iMAlertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener);
            }
            if (this.mNeutralButtonText != null) {
                IMAlertDialogFragment.ListenerAdapter listenerAdapter3 = this.mNeutralButtonListener;
                if (listenerAdapter3 != null) {
                    listenerAdapter3.attachAlertDialogFragment(iMAlertDialogFragment);
                }
                iMAlertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener);
            }
        }
    }
}
