package com.didi.carpool.countrydiff.brz;

import android.content.Intent;
import android.os.Bundle;
import com.didi.carpool.onservice.CarPoolOnServicePresenter;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.constant.WebUrlConstants;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.service.activity.CancelTripConfirmWebActivity;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.NextCommonPushMsg;
import com.didi.travel.psnger.store.DDTravelConfigStore;

public class BrzCarPoolOnServicePresenter extends CarPoolOnServicePresenter {
    public BrzCarPoolOnServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void showNotPayNotification() {
        GLog.m11353d("=== showNotPayNotification=");
    }

    /* access modifiers changed from: protected */
    public void startCancelTrip(boolean z) {
        String buildUrl = GlobalWebUrl.buildUrl(m10675b(), createURLParams());
        if (!TextUtil.isEmpty(buildUrl)) {
            Intent intent = new Intent(this.mContext, CancelTripConfirmWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(buildUrl));
            intent.putExtra(CancelTripConfirmWebActivity.KEY_IS_FROM_DASH_CAM, z);
            startActivityForResult(intent, 100, (Bundle) null);
        }
    }

    /* renamed from: b */
    private String m10675b() {
        String cancelTripURL = DDTravelConfigStore.getInstance().getCancelTripURL();
        return TextUtil.isEmpty(cancelTripURL) ? WebUrlConstants.BRZ_CANCEL_TRIP : cancelTripURL;
    }

    /* access modifiers changed from: protected */
    public void forwardCancelServicePage(boolean z) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
            bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
            bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, true);
            if (BusinessDataUtil.isOrderHasCancelFee(order)) {
                bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 3);
            }
            forwardNew(1015, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void showFixedPriceExceedDialog(NextCommonPushMsg.FixedPriceExceedModel fixedPriceExceedModel) {
        super.showFixedPriceExceedDialog(fixedPriceExceedModel);
        if (fixedPriceExceedModel != null) {
            NormalDialogInfo normalDialogInfo = new NormalDialogInfo(101);
            normalDialogInfo.setIcon(AlertController.IconType.INFO);
            normalDialogInfo.setCancelable(false);
            normalDialogInfo.setTitle(fixedPriceExceedModel.title);
            normalDialogInfo.setMessage(fixedPriceExceedModel.content);
            normalDialogInfo.setPositiveText(fixedPriceExceedModel.button);
            showDialog(normalDialogInfo);
        }
    }
}
