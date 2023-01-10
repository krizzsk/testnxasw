package com.didi.component.comp_flex.drivercard;

import android.content.Context;
import android.view.View;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.comp_flex.drivercard.DriverItemView;
import com.didi.component.comp_flex.drivercard.FlexTemplateDriverModel;
import com.didi.component.core.event.BaseEventPublisher;
import com.didiglobal.enginecore.template.temp.IXEView;

public class FlexTemplateDriverView implements IXEView<FlexTemplateDriverModel> {

    /* renamed from: a */
    private Context f14017a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DriverItemView f14018b;

    public void initView(Context context) {
        this.f14017a = context;
        DriverItemView driverItemView = new DriverItemView(this.f14017a);
        this.f14018b = driverItemView;
        driverItemView.setListener(new DriverItemView.OnOperationDriverCardListener() {
            public void engineCommit(boolean z) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_FLEX_COMMIT, Boolean.valueOf(z));
            }

            public void removeItem(FlexTemplateDriverModel.TemplateDriverData templateDriverData) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_COMMON_LIST_REMOVE_CARD, FlexTemplateDriverView.this.f14018b);
            }
        });
    }

    public void bindData(FlexTemplateDriverModel flexTemplateDriverModel) {
        if (flexTemplateDriverModel == null || flexTemplateDriverModel.normal == null || flexTemplateDriverModel.normal.data == null) {
            this.f14018b.setVisibility(8);
            return;
        }
        this.f14018b.setVisibility(0);
        this.f14018b.setData(flexTemplateDriverModel.normal.data);
    }

    public View getView() {
        return this.f14018b;
    }
}
