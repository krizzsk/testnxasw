package com.didiglobal.comp.carmodellist.optionarea.rideoption;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didiglobal.comp.carmodellist.BaseVH;
import com.didiglobal.comp.carmodellist.optionarea.rideoption.IAnycarRideOptionView;
import com.taxis99.R;
import java.util.List;

public class RideOptionVH extends BaseVH<AnyCarEstimateItemModel> implements IAnycarRideOptionView {

    /* renamed from: a */
    private Context f52405a;

    /* renamed from: b */
    private TextView f52406b;

    /* renamed from: c */
    private ImageView f52407c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View.OnClickListener f52408d;

    /* renamed from: e */
    private View f52409e;

    /* renamed from: f */
    private RideOptionSelectView f52410f;

    /* renamed from: g */
    private LEGOBaseDrawerModel f52411g;

    /* renamed from: h */
    private LEGODrawer f52412h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IAnycarRideOptionView.OnConfirmListener f52413i;

    /* renamed from: j */
    private AnycarRideOptionPresenter f52414j;

    public RideOptionVH(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.car_model_ride_option_layout, viewGroup, false));
        this.f52405a = viewGroup.getContext();
        m39378a();
    }

    /* renamed from: a */
    private void m39378a() {
        this.f52406b = (TextView) this.itemView.findViewById(R.id.message);
        this.f52407c = (ImageView) this.itemView.findViewById(R.id.iv_ride_option);
        this.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (RideOptionVH.this.f52408d != null) {
                    RideOptionVH.this.f52408d.onClick(view);
                }
            }
        });
        View inflate = LayoutInflater.from(this.f52405a).inflate(R.layout.car_model_ride_option_dialog_layout, (ViewGroup) null);
        this.f52409e = inflate;
        this.f52410f = (RideOptionSelectView) inflate.findViewById(R.id.popup_select_recycler_view);
        this.f52411g = new LEGODrawerModel1("", new LEGOBtnTextAndCallback(ResourcesHelper.getString(this.f52405a, R.string.car_me_known), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (RideOptionVH.this.f52413i != null) {
                    RideOptionVH.this.f52413i.onConfirm(view);
                }
            }
        })).setIsShowCloseImg(true).setExtendedView(this.f52409e).setClickOutsideCanCancel(false);
        this.f52414j = new AnycarRideOptionPresenter(this);
    }

    public void setSelectListData(List<PopupSelectModel> list) {
        if (list != null && list.size() != 0) {
            this.f52410f.setItems(list);
        }
    }

    public void showSelectMore(int i) {
        if (this.f52411g != null && this.f52405a != null) {
            if (this.f52409e.getParent() != null) {
                ((ViewGroup) this.f52409e.getParent()).removeView(this.f52409e);
            }
            this.f52412h = LEGOUICreator.showDrawerTemplate(this.f52405a, this.f52411g);
            if (i >= 0) {
                this.f52410f.setSelectedPosition(i);
            }
        }
    }

    public void closeSelectMore() {
        LEGODrawer lEGODrawer = this.f52412h;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            this.f52412h.dismiss();
        }
    }

    public void setClickable(boolean z) {
        this.itemView.setClickable(z);
        if (z) {
            this.f52406b.setTextColor(this.f52405a.getResources().getColor(R.color.g_color_000));
        } else {
            this.f52406b.setTextColor(Color.parseColor("#D9D9D9"));
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f52408d = onClickListener;
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f52410f.setOnPopupSelectListClickListener(onPopupSelectListClickListener);
    }

    public void setOnConfirmListener(IAnycarRideOptionView.OnConfirmListener onConfirmListener) {
        this.f52413i = onConfirmListener;
    }

    public void setSelectedPosition(int i) {
        if (i >= 0) {
            this.f52410f.setSelectedPosition(i);
        }
    }

    public void setDialogTitle(String str) {
        this.f52410f.setTitle(str);
    }

    public void setNewContent(GlobalRichInfo globalRichInfo) {
        globalRichInfo.bindTextView(this.f52406b);
    }

    public void setOptionIcon(String str) {
        ((RequestBuilder) Glide.with(this.f52405a).load(str).placeholder((int) R.drawable.global_rideoption_service_icon_accessible_car)).into(this.f52407c);
    }

    public void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f52414j.bindData(anyCarEstimateItemModel);
    }
}
