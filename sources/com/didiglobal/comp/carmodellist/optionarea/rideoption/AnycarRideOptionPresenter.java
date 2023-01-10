package com.didiglobal.comp.carmodellist.optionarea.rideoption;

import android.text.TextUtils;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.CollectionUtils;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarChoiceModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.didi.travel.psnger.model.response.estimate.SelectedValueParams;
import com.didiglobal.comp.carmodellist.optionarea.rideoption.IAnycarRideOptionView;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnycarRideOptionPresenter extends AbsAnycarRideOptionPresenter implements PopupSelectView.OnPopupSelectListClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f52388a = -1;

    /* renamed from: b */
    private List<PopupSelectModel> f52389b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f52390c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public NewEstimateChoosedOpration f52391d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<CarChoiceModel> f52392e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IAnycarRideOptionView f52393f;

    public void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (FormStore.getInstance().isAccessibleCar()) {
            this.f52388a = 1;
            this.f52390c = 1;
        } else {
            this.f52388a = 0;
            this.f52390c = 0;
        }
        if (anyCarEstimateItemModel != null) {
            NewEstimateChoosedOpration newEstimateChoosedOpration = anyCarEstimateItemModel.extraChoice;
            this.f52391d = newEstimateChoosedOpration;
            if (!(newEstimateChoosedOpration == null || newEstimateChoosedOpration.operationData == null)) {
                List<CarChoiceModel> list = this.f52391d.operationData.operationChoices;
                this.f52392e = list;
                if (!CollectionUtils.isEmpty((Collection) list) && this.f52392e.size() > 1) {
                    List<PopupSelectModel> asList = Arrays.asList(new PopupSelectModel[]{new PopupSelectModel("1", this.f52392e.get(0).choiceText), new PopupSelectModel("2", this.f52392e.get(1).choiceText)});
                    this.f52389b = asList;
                    this.f52393f.setSelectListData(asList);
                }
                if (this.f52391d.selectedText != null && !TextUtils.isEmpty(this.f52391d.selectedText.getContent())) {
                    this.f52393f.setNewContent(this.f52391d.selectedText);
                } else if (this.f52391d.operationData.operationText != null) {
                    this.f52393f.setNewContent(this.f52391d.operationData.operationText);
                }
                if (!TextUtils.isEmpty(this.f52391d.operationData.operationIcon)) {
                    this.f52393f.setOptionIcon(this.f52391d.operationData.operationIcon);
                }
                if (!TextUtils.isEmpty(this.f52391d.operationData.operationTitle)) {
                    this.f52393f.setDialogTitle(this.f52391d.operationData.operationTitle);
                }
                this.f52393f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (!Utils.isFastDoubleClick()) {
                            AnycarRideOptionPresenter.this.onClickable(view);
                            GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_noextras_ck", (Map<String, Object>) new HashMap());
                        }
                    }
                });
                this.f52393f.setOnConfirmListener(new IAnycarRideOptionView.OnConfirmListener() {
                    public void onConfirm(View view) {
                        AnycarRideOptionPresenter anycarRideOptionPresenter = AnycarRideOptionPresenter.this;
                        int unused = anycarRideOptionPresenter.f52388a = anycarRideOptionPresenter.f52390c;
                        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                        if (newEstimateItem != null) {
                            newEstimateItem.addSelectedValueJsonObject(ComponentType.RIDE_OPTION, (JsonObject) null);
                        }
                        if (AnycarRideOptionPresenter.this.f52388a == 1) {
                            FormStore.getInstance().setAccessibleCar(true);
                            if (AnycarRideOptionPresenter.this.f52391d.operationData.operationChoices.size() > AnycarRideOptionPresenter.this.f52388a) {
                                CarChoiceModel carChoiceModel = AnycarRideOptionPresenter.this.f52391d.operationData.operationChoices.get(AnycarRideOptionPresenter.this.f52388a);
                                SelectedValueParams selectedValueParams = carChoiceModel.getselectValue();
                                if (selectedValueParams != null && !TextUtils.isEmpty(selectedValueParams.customFeature)) {
                                    AnycarRideOptionPresenter.this.f52391d.selectedValue = selectedValueParams.customFeature;
                                }
                                if (newEstimateItem != null) {
                                    newEstimateItem.addSelectedValueJsonObject(ComponentType.RIDE_OPTION, carChoiceModel.selectValueObject);
                                }
                            }
                        } else {
                            FormStore.getInstance().setAccessibleCar(false);
                            AnycarRideOptionPresenter.this.f52391d.selectedValue = "0";
                        }
                        AnycarRideOptionPresenter.this.f52391d.selectedText = ((CarChoiceModel) AnycarRideOptionPresenter.this.f52392e.get(AnycarRideOptionPresenter.this.f52388a)).selectedText;
                        if (AnycarRideOptionPresenter.this.f52393f != null) {
                            AnycarRideOptionPresenter.this.f52393f.setNewContent(AnycarRideOptionPresenter.this.f52391d.selectedText);
                            AnycarRideOptionPresenter.this.f52393f.closeSelectMore();
                        }
                    }
                });
            }
        }
        this.f52393f.setOnPopupSelectListClickListener(this);
    }

    public AnycarRideOptionPresenter(IAnycarRideOptionView iAnycarRideOptionView) {
        this.f52393f = iAnycarRideOptionView;
    }

    public void onClickable(View view) {
        this.f52393f.showSelectMore(this.f52388a);
    }

    public void onItemClick(int i) {
        this.f52390c = i;
        List<CarChoiceModel> list = this.f52392e;
        if (list != null && i < list.size() && this.f52393f != null && this.f52392e.get(i).selectedText != null) {
            this.f52393f.setSelectedPosition(i);
        }
    }

    public void onCloseButtonClick() {
        IAnycarRideOptionView iAnycarRideOptionView = this.f52393f;
        if (iAnycarRideOptionView != null) {
            iAnycarRideOptionView.closeSelectMore();
        }
    }
}
