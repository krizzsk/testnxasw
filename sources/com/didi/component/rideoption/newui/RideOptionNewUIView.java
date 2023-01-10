package com.didi.component.rideoption.newui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.rideoption.AbsRideOptionPresenter;
import com.didi.component.rideoption.IRideOptionView;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.taxis99.R;
import java.util.List;

public class RideOptionNewUIView implements IRideOptionView {

    /* renamed from: a */
    private Context f17161a;

    /* renamed from: b */
    private BusinessContext f17162b;

    /* renamed from: c */
    private View f17163c;

    /* renamed from: d */
    private TextView f17164d;

    /* renamed from: e */
    private ImageView f17165e = ((ImageView) this.f17163c.findViewById(R.id.iv_ride_option));
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f17166f;

    /* renamed from: g */
    private View f17167g;

    /* renamed from: h */
    private RideOptionSelectView f17168h;

    /* renamed from: i */
    private LEGOBaseDrawerModel f17169i;

    /* renamed from: j */
    private LEGODrawer f17170j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IRideOptionView.OnConfirmListener f17171k;

    public void setPresenter(AbsRideOptionPresenter absRideOptionPresenter) {
    }

    public RideOptionNewUIView(ComponentParams componentParams, ViewGroup viewGroup) {
        BusinessContext businessContext = componentParams.bizCtx;
        this.f17162b = businessContext;
        Context context = businessContext.getContext();
        this.f17161a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_ride_option_new_ui_layout, viewGroup, false);
        this.f17163c = inflate;
        this.f17164d = (TextView) inflate.findViewById(R.id.message);
        this.f17163c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (RideOptionNewUIView.this.f17166f != null) {
                    RideOptionNewUIView.this.f17166f.onClick(view);
                }
            }
        });
        View inflate2 = LayoutInflater.from(this.f17161a).inflate(R.layout.global_ride_option_new_ui_dialog_layout, (ViewGroup) null);
        this.f17167g = inflate2;
        this.f17168h = (RideOptionSelectView) inflate2.findViewById(R.id.popup_select_recycler_view);
        this.f17169i = new LEGODrawerModel1("", new LEGOBtnTextAndCallback(ResourcesHelper.getString(this.f17161a, R.string.car_me_known), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (RideOptionNewUIView.this.f17171k != null) {
                    RideOptionNewUIView.this.f17171k.onConfirm(view);
                }
            }
        })).setIsShowCloseImg(true).setExtendedView(this.f17167g).setClickOutsideCanCancel(false);
    }

    public void setSelectListData(List<PopupSelectModel> list) {
        if (list != null && list.size() != 0) {
            this.f17168h.setItems(list);
        }
    }

    public void setContentLable(String str) {
        this.f17164d.setText(str);
        this.f17168h.setTitle(str);
    }

    public void showSelectMore(int i) {
        if (this.f17169i != null && this.f17161a != null) {
            if (this.f17167g.getParent() != null) {
                ((ViewGroup) this.f17167g.getParent()).removeView(this.f17167g);
            }
            this.f17170j = LEGOUICreator.showDrawerTemplate(this.f17161a, this.f17169i);
            if (i >= 0) {
                this.f17168h.setSelectedPosition(i);
            }
        }
    }

    public void closeSelectMore() {
        LEGODrawer lEGODrawer = this.f17170j;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            this.f17170j.dismiss();
        }
    }

    public void setClickable(boolean z) {
        getView().setClickable(z);
        if (z) {
            this.f17164d.setTextColor(this.f17161a.getResources().getColor(R.color.g_color_000));
        } else {
            this.f17164d.setTextColor(this.f17161a.getResources().getColor(R.color.g_color_D9D9D9));
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f17166f = onClickListener;
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f17168h.setOnPopupSelectListClickListener(onPopupSelectListClickListener);
    }

    public View getView() {
        return this.f17163c;
    }

    public void setOnConfirmListener(IRideOptionView.OnConfirmListener onConfirmListener) {
        this.f17171k = onConfirmListener;
    }

    public void setSelectedPosition(int i) {
        if (i >= 0) {
            this.f17168h.setSelectedPosition(i);
        }
    }

    public void setDialogTitle(String str) {
        this.f17168h.setTitle(str);
    }

    public void setNewContent(GlobalRichInfo globalRichInfo) {
        globalRichInfo.bindTextView(this.f17164d);
    }

    public void setOptionIcon(String str) {
        ((RequestBuilder) Glide.with(this.f17161a).load(str).placeholder((int) R.drawable.global_rideoption_service_icon_accessible_car)).into(this.f17165e);
    }
}
