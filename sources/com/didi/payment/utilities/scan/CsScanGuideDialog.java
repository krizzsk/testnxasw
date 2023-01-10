package com.didi.payment.utilities.scan;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;

public class CsScanGuideDialog extends SimplePopupBase {

    /* renamed from: a */
    private static final int f34204a = 6291456;

    /* renamed from: b */
    private ViewGroup f34205b;

    /* renamed from: c */
    private ImageView f34206c;

    /* renamed from: d */
    private TextView f34207d;

    /* renamed from: e */
    private TextView f34208e;

    /* renamed from: f */
    private Listener f34209f;

    /* renamed from: g */
    private Bitmap f34210g;

    /* renamed from: h */
    private Bitmap f34211h;

    /* renamed from: i */
    private boolean f34212i;

    /* renamed from: j */
    private int f34213j = R.string.cs_utilities_entrance_scan_guide_explain_2;

    /* renamed from: k */
    private int f34214k = R.string.cs_utilities_entrance_scan_guide_get;

    public interface Listener {
        void onScanGuideShownOver(CsScanGuideDialog csScanGuideDialog);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.cs_dialog_utilities_scan_guide_layout;
    }

    public static CsScanGuideDialog show(FragmentActivity fragmentActivity, Boolean bool, Listener listener) {
        CsScanGuideDialog csScanGuideDialog = new CsScanGuideDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isMexico", bool.booleanValue());
        csScanGuideDialog.setArguments(bundle);
        csScanGuideDialog.f34209f = listener;
        csScanGuideDialog.show(fragmentActivity.getSupportFragmentManager(), "scan_guide_dialog");
        return csScanGuideDialog;
    }

    public void onStart() {
        super.onStart();
        try {
            Window window = getDialog().getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.dimAmount = 0.0f;
            attributes.flags |= 2;
            attributes.flags |= 1024;
            attributes.gravity = 80;
            window.setAttributes(attributes);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f34205b = (ViewGroup) this.mRootView.findViewById(R.id.fl_utilities_scan_guide_image_layout);
        this.f34206c = (ImageView) this.mRootView.findViewById(R.id.iv_utilities_scan_guide_image);
        this.f34207d = (TextView) this.mRootView.findViewById(R.id.tv_utilities_scan_explain);
        this.f34208e = (TextView) this.mRootView.findViewById(R.id.tv_utilities_scan_next);
        View findViewById = this.mRootView.findViewById(R.id.cs_title_bar_left_btn);
        m26145d();
        this.f34208e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsScanGuideDialog.this.m26143b();
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FragmentActivity activity = CsScanGuideDialog.this.getActivity();
                CsScanGuideDialog.this.dismiss();
                if (activity != null && !activity.isDestroyed()) {
                    activity.onBackPressed();
                }
            }
        });
        m26141a();
        PayTracker.trackEvent("ibt_didipay_pay_boleto_guide_first_sw");
    }

    /* renamed from: a */
    private void m26141a() {
        this.f34210g = decodeBitmapFromResource(R.drawable.cs_utilities_scan_guide_image_1);
        this.f34211h = decodeBitmapFromResource(R.drawable.cs_utilities_scan_guide_image_2);
        this.f34206c.setImageBitmap(this.f34210g);
    }

    public Bitmap decodeBitmapFromResource(int i) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            BitmapFactory.decodeResource(getResources(), i, options);
            options.inSampleSize = calculateInSampleSize(options);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeResource(getResources(), i, options);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int calculateInSampleSize(BitmapFactory.Options options) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        int i3 = i * i2 * 2;
        int i4 = 2;
        while (i3 > f34204a) {
            i4 *= 2;
            i3 = (i / i4) * (i2 / i4) * 2;
        }
        return i4;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26143b() {
        if (this.f34212i) {
            PayTracker.trackEvent("ibt_didipay_pay_boleto_guide_second_ck");
            Listener listener = this.f34209f;
            if (listener != null) {
                listener.onScanGuideShownOver(this);
            }
            dismiss();
            return;
        }
        PayTracker.trackEvent("ibt_didipay_pay_boleto_guide_first_ck");
        this.f34212i = true;
        m26144c();
    }

    /* renamed from: c */
    private void m26144c() {
        PayTracker.trackEvent("ibt_didipay_pay_boleto_guide_second_sw");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f34205b.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.addRule(13);
        this.f34205b.setLayoutParams(layoutParams);
        this.f34205b.setBackground((Drawable) null);
        this.f34207d.setText(this.f34213j);
        this.f34208e.setText(this.f34214k);
        this.f34210g = null;
        Bitmap bitmap = this.f34211h;
        if (bitmap == null) {
            this.f34206c.setImageBitmap(decodeBitmapFromResource(R.drawable.cs_utilities_scan_guide_image_2));
        } else {
            this.f34206c.setImageBitmap(bitmap);
        }
        this.f34206c.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f34206c.setAdjustViewBounds(true);
        this.f34206c.setMaxWidth(UIUtils.getScreenWidth(getActivity()));
        this.f34206c.setMaxHeight(UIUtils.getScreenHeight(getActivity()));
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f34206c.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -2;
        layoutParams2.setMargins(0, 0, 0, 0);
        this.f34206c.setLayoutParams(layoutParams2);
    }

    /* renamed from: d */
    private void m26145d() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getBoolean("isMexico", false)) {
            this.f34207d.setText(R.string.Fintech_Payment_SKUs_Please_find_ArhM);
            this.f34208e.setText(R.string.Fintech_Payment_SKUs_Continue_oqFC);
            this.f34213j = R.string.Fintech_Payment_SKUs_Place_the_SmPf;
            this.f34214k = R.string.Fintech_Payment_SKUs_I_see_dOSB;
        }
    }
}
