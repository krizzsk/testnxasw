package com.didi.payment.wallet.global.wallet.view.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.view.RoundedImageView;
import com.didi.payment.wallet.global.wallet.contract.WalletOrderSharePicContract;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;

public class WalletOrderSharePicView implements WalletOrderSharePicContract.View {

    /* renamed from: a */
    private static final int f34994a = 3145728;

    /* renamed from: b */
    private View f34995b;

    /* renamed from: c */
    private Activity f34996c;

    /* renamed from: d */
    private ImageView f34997d;

    /* renamed from: e */
    private TextView f34998e;

    /* renamed from: f */
    private TextView f34999f;

    /* renamed from: g */
    private LinearLayout f35000g;

    /* renamed from: h */
    private TextView f35001h;

    /* renamed from: i */
    private TextView f35002i;

    /* renamed from: j */
    private TextView f35003j;

    /* renamed from: k */
    private RoundedImageView f35004k;

    /* renamed from: l */
    private ImageView f35005l;

    /* renamed from: m */
    private WalletOrderSharePicContract.WalletOrderSharePicAdapter f35006m;

    public WalletOrderSharePicView(Activity activity) {
        this.f34996c = activity;
        m26703a();
    }

    /* renamed from: a */
    private void m26703a() {
        View inflate = LayoutInflater.from(this.f34996c).inflate(R.layout.wallet_order_detail_share_pic_view, (ViewGroup) null);
        this.f34995b = inflate;
        this.f35003j = (TextView) inflate.findViewById(R.id.tv_order_detail_guide);
        RoundedImageView roundedImageView = (RoundedImageView) this.f34995b.findViewById(R.id.riv_order_detail_guide_icon);
        this.f35004k = roundedImageView;
        roundedImageView.setRectAdius((float) UIUtil.dip2px(this.f34996c, 20.0f));
        this.f35004k.setCornerType(3);
        this.f35005l = (ImageView) this.f34995b.findViewById(R.id.share_order_status_img);
        this.f34998e = (TextView) this.f34995b.findViewById(R.id.share_order_title);
        this.f34999f = (TextView) this.f34995b.findViewById(R.id.share_order_subtitle);
        this.f35000g = (LinearLayout) this.f34995b.findViewById(R.id.share_order_item_content);
        this.f35001h = (TextView) this.f34995b.findViewById(R.id.share_order_symbol);
        this.f35002i = (TextView) this.f34995b.findViewById(R.id.share_order_price);
    }

    public void setAdapter(WalletOrderSharePicContract.WalletOrderSharePicAdapter walletOrderSharePicAdapter) {
        this.f35006m = walletOrderSharePicAdapter;
    }

    public Bitmap createSharePic() {
        Bitmap bitmap = null;
        if (this.f35006m == null) {
            return null;
        }
        m26704b();
        this.f34995b.measure(View.MeasureSpec.makeMeasureSpec(UIUtils.getScreenWidth(this.f34996c), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        View view = this.f34995b;
        view.layout(0, 0, view.getMeasuredWidth(), this.f34995b.getMeasuredHeight());
        try {
            if (this.f34995b.getWidth() * this.f34995b.getHeight() * 4 < 3145728) {
                bitmap = Bitmap.createBitmap(this.f34995b.getWidth(), this.f34995b.getHeight(), Bitmap.Config.ARGB_8888);
            }
        } catch (Throwable unused) {
        }
        if (bitmap == null) {
            float f = 0.8f;
            while (((float) this.f34995b.getWidth()) * f * ((float) this.f34995b.getHeight()) * f * 2.0f > 3145728.0f) {
                try {
                    f /= 2.0f;
                } catch (Throwable unused2) {
                }
            }
            bitmap = Bitmap.createBitmap((int) (((float) this.f34995b.getWidth()) * f), (int) (((float) this.f34995b.getHeight()) * f), Bitmap.Config.RGB_565);
            if (bitmap != null) {
                Canvas canvas = new Canvas(bitmap);
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                canvas.setMatrix(matrix);
                this.f34995b.draw(canvas);
            }
        } else {
            this.f34995b.draw(new Canvas(bitmap));
        }
        return bitmap;
    }

    /* renamed from: b */
    private void m26704b() {
        WalletOrderSharePicContract.WalletOrderSharePicAdapter walletOrderSharePicAdapter = this.f35006m;
        if (walletOrderSharePicAdapter != null) {
            String title = walletOrderSharePicAdapter.getTitle();
            if (TextUtils.isEmpty(title)) {
                this.f34998e.setVisibility(8);
            } else {
                this.f34998e.setVisibility(0);
                this.f34998e.setText(title);
                int titleColorId = this.f35006m.getTitleColorId();
                if (titleColorId != 0) {
                    this.f34998e.setTextColor(ResourcesHelper.getColor(this.f34996c, titleColorId));
                }
            }
            String subTitle = this.f35006m.getSubTitle();
            if (TextUtils.isEmpty(subTitle)) {
                this.f34999f.setVisibility(8);
            } else {
                this.f34999f.setVisibility(0);
                this.f34999f.setText(subTitle);
                int subTitleColorId = this.f35006m.getSubTitleColorId();
                if (subTitleColorId != 0) {
                    this.f34999f.setTextColor(subTitleColorId);
                }
                int subTitleBgColorId = this.f35006m.getSubTitleBgColorId();
                if (subTitleBgColorId != 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(subTitleBgColorId);
                    gradientDrawable.setCornerRadius((float) UIUtil.dip2px(this.f34996c, 16.0f));
                    this.f34999f.setBackground(gradientDrawable);
                }
            }
            int statusImg = this.f35006m.getStatusImg();
            if (statusImg == 0) {
                this.f35005l.setVisibility(8);
            } else {
                this.f35005l.setVisibility(0);
                this.f35005l.setImageResource(statusImg);
            }
            this.f35001h.setText(this.f35006m.getSymbol());
            this.f35002i.setText(this.f35006m.getPrice());
            this.f35003j.setText(this.f35006m.getBannerText());
            this.f35000g.removeAllViews();
            View inflate = LayoutInflater.from(this.f34996c).inflate(R.layout.wallet_boleto_detail_title_view, this.f35000g, false);
            ((TextView) inflate.findViewById(R.id.pay_result_item_content)).setText(this.f35006m.getRechargementTitle());
            this.f35000g.addView(inflate);
            int rechargementItemCount = this.f35006m.getRechargementItemCount();
            for (int i = 0; i < rechargementItemCount; i++) {
                View rechargeItemView = this.f35006m.getRechargeItemView(this.f35000g, i);
                if (rechargeItemView != null) {
                    this.f35000g.addView(rechargeItemView);
                }
            }
            this.f35000g.addView(LayoutInflater.from(this.f34996c).inflate(R.layout.wallet_boleto_history_dash_line_view, this.f35000g, false));
            View inflate2 = LayoutInflater.from(this.f34996c).inflate(R.layout.wallet_boleto_detail_title_view, this.f35000g, false);
            ((TextView) inflate2.findViewById(R.id.pay_result_item_content)).setText(this.f35006m.getPayeementTitle());
            this.f35000g.addView(inflate2);
            int payeementItemCount = this.f35006m.getPayeementItemCount();
            for (int i2 = 0; i2 < payeementItemCount; i2++) {
                View payeeItemView = this.f35006m.getPayeeItemView(this.f35000g, i2);
                if (payeeItemView != null) {
                    this.f35000g.addView(payeeItemView);
                }
            }
        }
    }
}
