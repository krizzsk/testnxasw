package com.didi.component.openride.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.CircleImageView;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.taxis99.R;

public class OpenRideDriverInfoPopWin implements View.OnClickListener {

    /* renamed from: a */
    private Context f16587a;

    /* renamed from: b */
    private View f16588b;

    /* renamed from: c */
    private PopupWindow f16589c;

    /* renamed from: d */
    private TextView f16590d;

    /* renamed from: e */
    private ImageView f16591e;

    /* renamed from: f */
    private CircleImageView f16592f;

    /* renamed from: g */
    private TextView f16593g;

    /* renamed from: h */
    private TextView f16594h;

    /* renamed from: i */
    private TextView f16595i;

    /* renamed from: j */
    private View.OnClickListener f16596j;

    public OpenRideDriverInfoPopWin(Context context, View view) {
        this.f16587a = context;
        this.f16588b = view;
        m13942a();
    }

    /* renamed from: a */
    private void m13942a() {
        GlobalOmegaUtils.trackEvent("Pas_99GO_drivermatch_sw");
        View inflate = LayoutInflater.from(this.f16587a).inflate(R.layout.global_open_ride_driver_info_pop_layout, (ViewGroup) null);
        this.f16590d = (TextView) inflate.findViewById(R.id.g_driver_info_pop_title);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.g_driver_info_pop_close);
        this.f16591e = imageView;
        imageView.setOnClickListener(this);
        this.f16592f = (CircleImageView) inflate.findViewById(R.id.g_driver_head_img);
        this.f16593g = (TextView) inflate.findViewById(R.id.g_driver_info_name);
        this.f16594h = (TextView) inflate.findViewById(R.id.g_driver_info_num);
        TextView textView = (TextView) inflate.findViewById(R.id.g_driver_info_pop_btn);
        this.f16595i = textView;
        textView.setOnClickListener(this);
        m13943b();
        this.f16589c = new PopupWindow(inflate, -1, -2);
    }

    /* renamed from: b */
    private void m13943b() {
        PinCodeInfoResult driverInfo = FormStore.getInstance().getDriverInfo();
        if (driverInfo != null) {
            this.f16592f.setBorderColor(-1447447);
            this.f16592f.setBorderWidth(UIUtils.dip2pxInt(this.f16587a, 0.5f));
            ((RequestBuilder) ((RequestBuilder) Glide.with(this.f16587a).load(driverInfo.avatar).placeholder((int) R.drawable.global_open_ride_driver_icon)).centerCrop()).into((ImageView) this.f16592f);
            this.f16593g.setText(driverInfo.driverName);
            TextView textView = this.f16594h;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(driverInfo.licenseNum);
            stringBuffer.append(" · ");
            stringBuffer.append(driverInfo.carTitle);
            textView.setText(stringBuffer);
        }
    }

    public void show() {
        this.f16589c.showAtLocation(this.f16588b, 80, 0, 0);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f16596j = onClickListener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.g_driver_info_pop_close) {
            this.f16589c.dismiss();
            this.f16596j.onClick(view);
        } else if (id == R.id.g_driver_info_pop_btn) {
            this.f16596j.onClick(view);
        }
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.f16589c;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    public void dismiss() {
        PopupWindow popupWindow = this.f16589c;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f16589c.dismiss();
        }
    }
}
