package com.didi.component.comp_anycar_append_list;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.comp_anycar_append_list.AnyCarAppendData;
import com.didi.component.core.IView;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.button.LEGOLoadingButton;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.didiglobal.comp.carmodellist.AnyCarModelList;
import com.didiglobal.comp.carmodellist.common.AnyCarSelectListener;
import com.taxis99.R;
import java.util.List;

public class AnyCarAppendListView implements IAnyCarAppendListView, IView<AnyCarAppendListPresenter>, IViewContainer {

    /* renamed from: a */
    private Context f13940a;

    /* renamed from: b */
    private View f13941b;

    /* renamed from: c */
    private TextView f13942c;

    /* renamed from: d */
    private ViewGroup f13943d;

    /* renamed from: e */
    private ViewGroup f13944e;

    /* renamed from: f */
    private ImageView f13945f;

    /* renamed from: g */
    private TextView f13946g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LEGOLoadingButton f13947h;

    /* renamed from: i */
    private AnyCarModelList f13948i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AnyCarAppendListPresenter f13949j;

    /* renamed from: k */
    private String f13950k = "";

    /* renamed from: l */
    private String f13951l = "";

    /* renamed from: m */
    private String f13952m = "{{category_num}}";

    /* renamed from: n */
    private AnyCarSelectListener f13953n = new AnyCarSelectListener() {
        public void openDetail(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        }

        public void setAllItems(List<AnyCarEstimateItemModel> list) {
        }

        public void singleSelected(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        }

        public void defaultSelectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
            if (AnyCarAppendListView.this.f13949j != null) {
                AnyCarAppendListView.this.f13949j.defaultSelectedItem(anyCarEstimateItemModel);
            }
        }

        public void selectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
            if (AnyCarAppendListView.this.f13949j != null) {
                AnyCarAppendListView.this.f13949j.selectedItem(anyCarEstimateItemModel);
            }
        }

        public void unSelectItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
            if (AnyCarAppendListView.this.f13949j != null) {
                AnyCarAppendListView.this.f13949j.unSelectItem(anyCarEstimateItemModel);
            }
        }

        public void carpoolSeatSelected(AnyCarEstimateItemModel anyCarEstimateItemModel) {
            if (AnyCarAppendListView.this.f13949j != null) {
                AnyCarAppendListView.this.f13949j.carpoolSeatSelected(anyCarEstimateItemModel);
                BaseEventPublisher.getPublisher().publish("event_show_loading_on_titlebar_in_home");
            }
        }
    };

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
    }

    public AnyCarAppendListView(Context context, ViewGroup viewGroup) {
        this.f13940a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.any_car_append_list_container_layout, viewGroup, false);
        this.f13941b = inflate;
        this.f13942c = (TextView) inflate.findViewById(R.id.any_car_append_list_title);
        this.f13943d = (ViewGroup) this.f13941b.findViewById(R.id.any_car_append_model_list);
        this.f13944e = (ViewGroup) this.f13941b.findViewById(R.id.any_car_append_message_layout);
        this.f13946g = (TextView) this.f13941b.findViewById(R.id.any_car_append_message_text);
        this.f13945f = (ImageView) this.f13941b.findViewById(R.id.any_car_append_message_icon);
        LEGOLoadingButton lEGOLoadingButton = (LEGOLoadingButton) this.f13941b.findViewById(R.id.any_car_append_submit_btn_view);
        this.f13947h = lEGOLoadingButton;
        lEGOLoadingButton.setButtonClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (AnyCarAppendListView.this.f13949j != null) {
                    BaseEventPublisher.getPublisher().publish("event_show_loading_on_titlebar_in_home");
                    AnyCarAppendListView.this.f13947h.setClickable(false);
                    AnyCarAppendListView.this.f13947h.setLoading(true);
                    AnyCarAppendListView.this.f13949j.submitCarModelAppend();
                }
            }
        });
        this.f13947h.setButtonEnable(false);
        this.f13947h.setButtonClickable(false);
        AnyCarModelList anyCarModelList = new AnyCarModelList(context, viewGroup, this.f13953n);
        this.f13948i = anyCarModelList;
        anyCarModelList.setNestedScrollingEnabled(false);
        this.f13943d.addView(this.f13948i.getRootView());
    }

    public View getView() {
        return this.f13941b;
    }

    public void setPresenter(AnyCarAppendListPresenter anyCarAppendListPresenter) {
        this.f13949j = anyCarAppendListPresenter;
    }

    public void setTitle(LEGORichInfo lEGORichInfo) {
        if (lEGORichInfo != null) {
            lEGORichInfo.bindTextView(this.f13942c);
        }
    }

    public void setData(List<AnyCarGroup> list) {
        this.f13948i.setData(list);
    }

    public void setSubmitBtn(AnyCarAppendData.BtnInfo btnInfo) {
        SpannableString parseRichInfo;
        if (btnInfo != null && btnInfo.stateEnable != null && btnInfo.stateDisable != null && (parseRichInfo = btnInfo.stateEnable.parseRichInfo(getView().getContext())) != null) {
            this.f13950k = parseRichInfo.toString();
            SpannableString parseRichInfo2 = btnInfo.stateDisable.parseRichInfo(getView().getContext());
            if (parseRichInfo2 != null) {
                this.f13951l = parseRichInfo2.toString();
                refreshBtnContent();
            }
        }
    }

    public void refreshBtnContent() {
        AnyCarAppendListPresenter anyCarAppendListPresenter = this.f13949j;
        if (anyCarAppendListPresenter == null || anyCarAppendListPresenter.getSelectedAnyCarItems().size() == 0) {
            this.f13947h.setButtonText(this.f13951l);
            this.f13947h.setButtonEnable(false);
            this.f13947h.setButtonClickable(false);
            return;
        }
        this.f13947h.setButtonText(this.f13950k.replace(this.f13952m, String.valueOf(this.f13949j.getSelectedAnyCarItems().size())));
        this.f13947h.setButtonEnable(true);
        this.f13947h.setButtonClickable(true);
    }

    public void updateMsgTips(CarMessageModel carMessageModel) {
        if (carMessageModel == null) {
            this.f13944e.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13947h.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.f13941b.getContext(), 15.0f);
            this.f13947h.setLayoutParams(layoutParams);
            return;
        }
        this.f13944e.setVisibility(0);
        if (!TextUtils.isEmpty(carMessageModel.messageIcon)) {
            this.f13945f.setVisibility(0);
            Context context = this.f13940a;
            if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
                Glide.with(this.f13940a).load(carMessageModel.messageIcon).into(this.f13945f);
            }
        } else {
            this.f13945f.setVisibility(8);
        }
        if (!(carMessageModel == null || carMessageModel.msg == null || TextUtils.isEmpty(carMessageModel.msg.getContent()))) {
            carMessageModel.msg.bindTextView(this.f13946g);
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f13947h.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.f13947h.setLayoutParams(layoutParams2);
    }

    public void updateBtnLoading(Boolean bool) {
        this.f13947h.setLoading(bool.booleanValue());
    }
}
