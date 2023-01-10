package com.didi.component.confirmbroadingpoint.impl;

import android.graphics.Color;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;

public class UpdatePickUpBroadingPointNewPresenter extends UpdatePickUpBroadingPointPresenter {

    /* renamed from: k */
    BaseEventPublisher.OnEventListener<Boolean> f14496k = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (!bool.booleanValue()) {
                UpdatePickUpBroadingPointNewPresenter updatePickUpBroadingPointNewPresenter = UpdatePickUpBroadingPointNewPresenter.this;
                updatePickUpBroadingPointNewPresenter.setContent(ResourcesHelper.getString(updatePickUpBroadingPointNewPresenter.mContext, R.string.global_confirm_broading_title_error_in_onservice));
                int parseColor = Color.parseColor("#F33F60");
                UpdatePickUpBroadingPointNewPresenter.this.setSubTitle("");
                UpdatePickUpBroadingPointNewPresenter.this.setContentColor(parseColor);
                UpdatePickUpBroadingPointNewPresenter.this.setSubTitleColor(parseColor);
                UpdatePickUpBroadingPointNewPresenter.this.enableConfirm(false);
            }
        }
    };

    /* renamed from: l */
    BaseEventPublisher.OnEventListener<DepartureAddress> f14497l = new BaseEventPublisher.OnEventListener<DepartureAddress>() {
        public void onEvent(String str, DepartureAddress departureAddress) {
            Address unused = UpdatePickUpBroadingPointNewPresenter.this.f14499p = departureAddress.getAddress();
        }
    };

    /* renamed from: m */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14498m = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            UpdatePickUpBroadingPointNewPresenter.this.enableConfirm(false);
            UpdatePickUpBroadingPointNewPresenter updatePickUpBroadingPointNewPresenter = UpdatePickUpBroadingPointNewPresenter.this;
            updatePickUpBroadingPointNewPresenter.setContent(ResourcesHelper.getString(updatePickUpBroadingPointNewPresenter.mContext, R.string.GRider_Sug_2020_map_searchingAddress));
            int parseColor = Color.parseColor("#919599");
            UpdatePickUpBroadingPointNewPresenter.this.setContentColor(parseColor);
            UpdatePickUpBroadingPointNewPresenter.this.setSubTitle("");
            UpdatePickUpBroadingPointNewPresenter.this.setSubTitleColor(parseColor);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Address f14499p;

    public UpdatePickUpBroadingPointNewPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_NO_PARKING, this.f14496k);
        subscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_ADDRESS, this.f14497l);
        subscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_ADDRESS_LOADING, this.f14498m);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_NO_PARKING, this.f14496k);
        unsubscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_ADDRESS, this.f14497l);
        unsubscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT_ADDRESS_LOADING, this.f14498m);
    }

    public void onConfirmClicked() {
        Address address = this.f14499p;
        if (address != null) {
            doPublish(BaseEventKeys.OnService.EVENT_UPDATE_PICK_UP_BUTTON_CLICK_V2, address);
        }
    }
}
