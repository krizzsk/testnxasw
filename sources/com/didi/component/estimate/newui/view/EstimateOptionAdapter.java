package com.didi.component.estimate.newui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.core.IComponent;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.estimate.newui.view.viewholder.DispatchFeeViewHolder;
import com.didi.component.estimate.newui.view.viewholder.OptionsViewHolder;
import com.didi.component.estimate.newui.view.viewholder.TwoPriceViewHolder;
import com.didi.component.estimate.presenter.AbsEstimatePresenter;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.travel.psnger.model.response.estimate.CarOperationDataModel;
import com.didi.travel.psnger.model.response.estimate.CarOperationModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.SelectedValueParams;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class EstimateOptionAdapter extends RecyclerView.Adapter {
    public static final int VIEW_TYPE_COMPANY = 3;
    public static final int VIEW_TYPE_DISPATCH_FEE = 1;
    public static final int VIEW_TYPE_MEMBER_POINT = 4;
    public static final int VIEW_TYPE_OPTIONS = 2;
    public static final int VIEW_TYPE_PASS = 5;
    public static final int VIEW_TYPE_TWO_PRICE = 0;
    public static final int VIEW_TYPE_XML = 6;

    /* renamed from: a */
    private AbsEstimatePresenter f14935a;

    /* renamed from: b */
    private List<CarOperationModel> f14936b;

    /* renamed from: c */
    private int f14937c;

    /* renamed from: d */
    private final Context f14938d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public EstimateItemModel f14939e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final EstimateOptionsCallback f14940f;

    /* renamed from: g */
    private HashMap<Integer, IComponent> f14941g = FormStore.getInstance().getCarOprationComponet();

    interface EstimateOptionsCallback {
        void optionsListGone();

        void twoPriceItemClick(EstimateItemModel estimateItemModel, int i, boolean z);
    }

    public EstimateOptionAdapter(Context context, EstimateOptionsCallback estimateOptionsCallback) {
        this.f14938d = context;
        this.f14940f = estimateOptionsCallback;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                View inflate = LayoutInflater.from(this.f14938d).inflate(R.layout.new_estimate_two_price_layout, viewGroup, false);
                inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_selectshare_sw");
                return new TwoPriceViewHolder(inflate);
            case 1:
                IComponent inflateComponent = this.f14935a.inflateComponent(ComponentType.DISPATCH_FEE, viewGroup);
                View view = inflateComponent.getView().getView();
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.f14941g.put(Integer.valueOf(i), inflateComponent);
                return new DispatchFeeViewHolder(view);
            case 2:
                IComponent inflateComponent2 = this.f14935a.inflateComponent(ComponentType.RIDE_OPTION, viewGroup);
                View view2 = inflateComponent2.getView().getView();
                view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.f14941g.put(Integer.valueOf(i), inflateComponent2);
                return new OptionsViewHolder(view2);
            case 3:
                IComponent inflateComponent3 = this.f14935a.inflateComponent(ComponentType.COMPANY, viewGroup);
                inflateComponent3.getView().getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.f14941g.put(Integer.valueOf(i), inflateComponent3);
                return new OptionsViewHolder(inflateComponent3.getView().getView());
            case 4:
                IComponent inflateComponent4 = this.f14935a.inflateComponent(ComponentType.MEMBERPOINR, viewGroup);
                View view3 = inflateComponent4.getView().getView();
                view3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.f14941g.put(Integer.valueOf(i), inflateComponent4);
                return new OptionsViewHolder(view3);
            case 5:
                IComponent inflateComponent5 = this.f14935a.inflateComponent(ComponentType.ESTIMATE_PASS, viewGroup);
                View view4 = inflateComponent5.getView().getView();
                view4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.f14941g.put(Integer.valueOf(i), inflateComponent5);
                return new OptionsViewHolder(view4);
            case 6:
                FrameLayout frameLayout = new FrameLayout(this.f14938d);
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                frameLayout.setPadding(UiUtils.dip2px(this.f14938d, 20.0f), 0, 0, 0);
                return new OptionsViewHolder(frameLayout);
            default:
                return new RecyclerView.ViewHolder(new View(this.f14938d)) {
                };
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        CarOperationModel carOperationModel;
        CarOperationModel carOperationModel2;
        CarOperationDataModel carOperationDataModel;
        boolean z = viewHolder instanceof TwoPriceViewHolder;
        if (z) {
            final TwoPriceViewHolder twoPriceViewHolder = (TwoPriceViewHolder) viewHolder;
            CarOperationModel carOperationModel3 = this.f14936b.get(i);
            if (!(carOperationModel3 == null || (carOperationDataModel = carOperationModel3.operationData) == null)) {
                if (carOperationModel3.isShowCheckBox == 1) {
                    twoPriceViewHolder.choiceCheckBox.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) twoPriceViewHolder.choiceText.getLayoutParams();
                    layoutParams.leftMargin = UiUtils.dip2px(this.f14938d, 0.0f);
                    twoPriceViewHolder.choiceText.setLayoutParams(layoutParams);
                    if (this.f14939e.twoPriceChoice == null || this.f14939e.twoPriceChoice.selectedValue.isEmpty()) {
                        if (carOperationModel3.dupselectdefault) {
                            twoPriceViewHolder.choiceCheckBox.setSelected(true);
                            FormStore.getInstance().setTwoPriceBiz(true);
                            FormStore.getInstance().setCurrentComboType(4);
                        } else {
                            twoPriceViewHolder.choiceCheckBox.setSelected(false);
                            FormStore.getInstance().setTwoPriceBiz(false);
                            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                            if (newEstimateItem != null) {
                                newEstimateItem.setSelectedValueParams((SelectedValueParams) null, (JsonObject) null);
                            }
                            FormStore.getInstance().setCurrentComboType(0);
                            FormStore.getInstance().setCarpoolOrderScene(-1);
                        }
                    } else if (this.f14939e.twoPriceChoice.selectedValue.equals("1")) {
                        twoPriceViewHolder.choiceCheckBox.setSelected(true);
                        FormStore.getInstance().setTwoPriceBiz(true);
                        FormStore.getInstance().setCurrentComboType(4);
                    } else {
                        twoPriceViewHolder.choiceCheckBox.setSelected(false);
                        FormStore.getInstance().setTwoPriceBiz(false);
                        EstimateItemModel newEstimateItem2 = FormStore.getInstance().getNewEstimateItem();
                        if (newEstimateItem2 != null) {
                            newEstimateItem2.setSelectedValueParams((SelectedValueParams) null, (JsonObject) null);
                        }
                        FormStore.getInstance().setCurrentComboType(0);
                        FormStore.getInstance().setCarpoolOrderScene(-1);
                    }
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) twoPriceViewHolder.choiceText.getLayoutParams();
                    layoutParams2.leftMargin = UiUtils.dip2px(this.f14938d, 20.0f);
                    twoPriceViewHolder.choiceText.setLayoutParams(layoutParams2);
                    twoPriceViewHolder.choiceCheckBox.setVisibility(8);
                }
                if (carOperationDataModel.operationText != null) {
                    carOperationDataModel.operationText.bindTextView(twoPriceViewHolder.choiceText);
                }
                twoPriceViewHolder.blankView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (EstimateOptionAdapter.this.f14940f != null) {
                            EstimateOptionAdapter.this.f14940f.twoPriceItemClick(EstimateOptionAdapter.this.f14939e, i, twoPriceViewHolder.choiceCheckBox.getVisibility() == 0);
                        }
                    }
                });
                twoPriceViewHolder.choiceText.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (EstimateOptionAdapter.this.f14940f != null) {
                            EstimateOptionAdapter.this.f14940f.twoPriceItemClick(EstimateOptionAdapter.this.f14939e, i, twoPriceViewHolder.choiceCheckBox.getVisibility() == 0);
                        }
                    }
                });
                twoPriceViewHolder.choiceCheckBox.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (twoPriceViewHolder.choiceCheckBox.isSelected()) {
                            if (EstimateOptionAdapter.this.f14939e.twoPriceChoice != null) {
                                EstimateOptionAdapter.this.f14939e.twoPriceChoice.selectedValue = "0";
                            }
                            FormStore.getInstance().setTwoPriceBiz(false);
                            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                            if (newEstimateItem != null) {
                                newEstimateItem.setSelectedValueParams((SelectedValueParams) null, (JsonObject) null);
                            }
                            FormStore.getInstance().setCurrentComboType(0);
                            FormStore.getInstance().setCarpoolOrderScene(-1);
                            twoPriceViewHolder.choiceCheckBox.setSelected(false);
                            GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_selectshare_ck", "type", "1");
                            return;
                        }
                        if (EstimateOptionAdapter.this.f14939e.twoPriceChoice != null) {
                            EstimateOptionAdapter.this.f14939e.twoPriceChoice.selectedValue = "1";
                        }
                        twoPriceViewHolder.choiceCheckBox.setSelected(true);
                        FormStore.getInstance().setTwoPriceBiz(true);
                        FormStore.getInstance().setCurrentComboType(4);
                        GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_selectshare_ck", "type", "0");
                    }
                });
            }
        }
        if (getItemViewType(i) == 5 && (carOperationModel2 = this.f14936b.get(i)) != null) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_SHOW_PASS_VIEW_OPTION, carOperationModel2);
        }
        if (!(getItemViewType(i) != 6 || (carOperationModel = this.f14936b.get(i)) == null || carOperationModel.xmlData == null)) {
            try {
                final GGKData gGKData = new GGKData();
                final View view = viewHolder.itemView;
                gGKData.parse(new JSONObject(carOperationModel.xmlData.toString()));
                gGKData.setCDNCallback(new GGKData.CDNCallback() {
                    public void onCDNCached() {
                        EstimateOptionAdapter.this.m12293a(gGKData, view);
                    }
                });
                m12293a(gGKData, view);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!z && !(viewHolder instanceof DispatchFeeViewHolder) && !(viewHolder instanceof OptionsViewHolder)) {
            this.f14940f.optionsListGone();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12293a(GGKData gGKData, View view) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(this.f14938d, gGKData);
        if ((view instanceof ViewGroup) && createTemplateView != null && createTemplateView.getView() != null) {
            ((ViewGroup) view).addView(createTemplateView.getView());
        }
    }

    public int getItemViewType(int i) {
        try {
            this.f14937c = Integer.parseInt(this.f14936b.get(i).operationType);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.f14937c;
    }

    public int getItemCount() {
        List<CarOperationModel> list = this.f14936b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setPresenter(AbsEstimatePresenter absEstimatePresenter) {
        this.f14935a = absEstimatePresenter;
    }

    public void onDestroy() {
        if (this.f14935a != null) {
            for (IComponent next : this.f14941g.values()) {
                this.f14935a.removeComponent(next);
                this.f14941g.remove(next);
            }
        }
    }

    public void setData(List<CarOperationModel> list, EstimateItemModel estimateItemModel) {
        this.f14936b = list;
        this.f14939e = estimateItemModel;
    }
}
