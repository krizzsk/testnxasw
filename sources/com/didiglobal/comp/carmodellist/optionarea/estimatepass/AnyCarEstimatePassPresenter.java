package com.didiglobal.comp.carmodellist.optionarea.estimatepass;

import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarOperationModel;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.didiglobal.comp.carmodellist.optionarea.estimatepass.IAnyCarEstimatePassView;
import java.util.Collection;
import java.util.Iterator;

public class AnyCarEstimatePassPresenter implements IAnyCarEstimatePassView.OnCheckChangeListener {

    /* renamed from: a */
    private NewEstimateChoosedOpration f52370a;

    /* renamed from: b */
    private String f52371b;

    /* renamed from: c */
    private IAnyCarEstimatePassView f52372c;

    public void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel == null || anyCarEstimateItemModel.estimatePass == null) {
            FormStore.getInstance().setIsHasEstimatePassData(false);
            this.f52372c.setVisibility(8);
        } else {
            NewEstimateChoosedOpration newEstimateChoosedOpration = anyCarEstimateItemModel.estimatePass;
            this.f52370a = newEstimateChoosedOpration;
            if (newEstimateChoosedOpration.operationData == null || this.f52370a.operationData.operationTextV2 == null || TextUtils.isEmpty(this.f52370a.operationData.operationTextV2.getContent())) {
                FormStore.getInstance().setIsHasEstimatePassData(false);
                this.f52372c.setVisibility(8);
            } else {
                FormStore.getInstance().setIsHasEstimatePassData(true);
                this.f52372c.setVisibility(0);
                this.f52372c.setPassRichInfo(this.f52370a.operationData.operationTextV2);
                if (!TextUtils.isEmpty(this.f52370a.operationData.link)) {
                    this.f52372c.setArrowVisibility(0);
                } else {
                    this.f52372c.setArrowVisibility(8);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_bubblepagepurchase_view_sw");
            }
            CarOperationModel carOperationModel = null;
            if (!CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation)) {
                Iterator<CarOperationModel> it = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation.iterator();
                while (true) {
                    if (it.hasNext()) {
                        CarOperationModel next = it.next();
                        if (next != null && "5".equals(next.operationType)) {
                            carOperationModel = next;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (carOperationModel != null) {
                this.f52371b = carOperationModel.toast;
                FormStore.getInstance().setPassPackageId(carOperationModel.passPackageId);
                if (carOperationModel.isShowCheckBox == 1) {
                    this.f52372c.setCheckBoxVisibility(0);
                    if (anyCarEstimateItemModel.estimatePass == null || anyCarEstimateItemModel.estimatePass.selectedValue.isEmpty()) {
                        this.f52372c.setCheck(carOperationModel.dupselectdefault);
                        FormStore.getInstance().setEstimatePassConfirm(carOperationModel.dupselectdefault);
                    } else if (anyCarEstimateItemModel.estimatePass.selectedValue.equals("1")) {
                        this.f52372c.setCheck(true);
                        FormStore.getInstance().setEstimatePassConfirm(true);
                    } else {
                        this.f52372c.setCheck(false);
                        FormStore.getInstance().setEstimatePassConfirm(false);
                    }
                } else {
                    this.f52372c.setCheckBoxVisibility(8);
                }
            }
        }
        this.f52372c.setOnCheckChangeListener(this);
    }

    public AnyCarEstimatePassPresenter(IAnyCarEstimatePassView iAnyCarEstimatePassView) {
        this.f52372c = iAnyCarEstimatePassView;
    }

    public void onCheckChange(boolean z) {
        if (z) {
            this.f52370a.selectedValue = "1";
            this.f52372c.showPassToast(this.f52371b);
            GlobalOmegaUtils.trackEvent("ibt_gp_anycar_cartype_bottom_banner_ck");
        } else {
            this.f52370a.selectedValue = "0";
        }
        FormStore.getInstance().setEstimatePassConfirm(z);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
    }
}
