package com.didi.component.timepicker;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.timepicker.impl.util.TimeConfigData;
import com.didi.sdk.util.TextUtil;

public abstract class AbsTimePickerPresenter extends BaseExpressPresenter<ITimePickerView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TimeConfigData f17992a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TimePickerModel f17993b;

    /* renamed from: c */
    private TimePickerModel f17994c;

    /* renamed from: d */
    private long f17995d;

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17996e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AbsTimePickerPresenter.this.f17992a != null) {
                AbsTimePickerPresenter.this.f17992a.setCarType(AbsTimePickerPresenter.this.getCarType());
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17997f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsTimePickerPresenter.this.showTimePickerDialog();
        }
    };

    public abstract String getCarType();

    /* access modifiers changed from: protected */
    public abstract TimePickerModel getModel();

    public abstract int getProductId();

    public abstract String getScene();

    public boolean onInterceptModifyDepartTime() {
        return false;
    }

    public void onSimpleTimePickerSelected(int i) {
    }

    public AbsTimePickerPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f17995d = FormStore.getInstance().getTransportTime();
        m15248b();
        ((ITimePickerView) this.mView).getView().postDelayed(new Runnable() {
            public void run() {
                AbsTimePickerPresenter.this.updateConfig();
            }
        }, 600);
        m15250d();
    }

    /* renamed from: b */
    private void m15248b() {
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_BOOK_TIME_ERROR, this.f17997f);
    }

    /* renamed from: c */
    private void m15249c() {
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_BOOK_TIME_ERROR, this.f17997f);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m15249c();
    }

    /* renamed from: d */
    private void m15250d() {
        TimeConfigData timeConfigData = new TimeConfigData(new TimeConfigData.TimeConfigParams(getProductId(), getScene(), getCarType()));
        this.f17992a = timeConfigData;
        timeConfigData.setDelay(500);
        this.f17992a.initConfigData();
        this.f17992a.setConfigChangeListener(new TimeConfigData.ConfigChangeListener() {
            public void configChange(TimePickerModel timePickerModel) {
                TimePickerModel unused = AbsTimePickerPresenter.this.f17993b = timePickerModel;
                AbsTimePickerPresenter.this.updateConfig();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void updateConfig() {
        TimePickerModel model = getModel();
        if (model != null) {
            if (model.model == 0) {
                TimePickerModel timePickerModel = this.f17993b;
                if (timePickerModel != null) {
                    model.appointmentDay = timePickerModel.appointmentDay;
                    model.earliestDelta = this.f17993b.earliestDelta;
                    model.from = this.f17993b.from;
                    model.f17998to = this.f17993b.f17998to;
                }
                if (!m15247a(model.appointmentDay, model.earliestDelta, model.from, model.f17998to, model.isSupportnow)) {
                    model.textContent = "";
                    onTimePickerSelected(0);
                }
            }
            this.f17994c = model;
            m15251e();
        }
    }

    /* renamed from: e */
    private void m15251e() {
        TimePickerModel timePickerModel = this.f17994c;
        if (timePickerModel == null) {
            ((ITimePickerView) this.mView).setLabel("");
        } else if (!TextUtil.isEmpty(timePickerModel.textContent)) {
            ((ITimePickerView) this.mView).setLabel(this.f17994c.textContent);
        } else if (!TextUtil.isEmpty(this.f17994c.hint)) {
            ((ITimePickerView) this.mView).setLabel(this.f17994c.hint);
        }
    }

    /* renamed from: a */
    private boolean m15247a(int i, int i2, int i3, int i4, boolean z) {
        TimeConfigData.TimeConfigParams timeConfigParams = new TimeConfigData.TimeConfigParams();
        timeConfigParams.productId = getProductId();
        timeConfigParams.sceneType = getScene();
        timeConfigParams.carType = getCarType();
        return TimeConfigData.checkTimeValidate(this.f17995d, timeConfigParams, new TimeConfigData.TimeInfo(i, i2, i3, i4), z);
    }

    public void showTimePickerDialog() {
        if (this.f17994c != null) {
            ((ITimePickerView) this.mView).showTimepickerDialog(this.f17994c, this.f17995d);
        } else {
            ((ITimePickerView) this.mView).showTimepickerDialog(getModel(), this.f17995d);
        }
    }

    public void onTimePickerSelected(long j) {
        GlobalOmegaUtils.trackEvent("pas_orderconfirm_time_ck");
        this.f17995d = j;
        if (j > 0) {
            GlobalOmegaUtils.trackEvent("ReservationPage_Enter");
        }
        FormStore.getInstance().setTransportTime(this.f17995d);
        doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_TIME_CHANGED);
        updateConfig();
    }

    /* access modifiers changed from: protected */
    public long getCurrentSelected() {
        return this.f17995d;
    }

    /* access modifiers changed from: protected */
    public void restore() {
        this.f17995d = 0;
    }
}
