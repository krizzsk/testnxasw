package com.didiglobal.eevee.comp.sug;

import com.didi.address.model.SugParams;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didiglobal.common.common.event.BaseEventKeys;

class ESugPresenter$1 implements BaseEventPublisher.OnEventListener<SugParams> {
    final /* synthetic */ C17583a this$0;

    ESugPresenter$1(C17583a aVar) {
        this.this$0 = aVar;
    }

    public void onEvent(String str, SugParams sugParams) {
        if (str.equals(BaseEventKeys.Sub.EVENT_EEVEE_OPEN_SUB)) {
            this.this$0.mo128997a(sugParams);
        }
    }
}
