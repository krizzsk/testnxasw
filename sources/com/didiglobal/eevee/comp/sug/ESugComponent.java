package com.didiglobal.eevee.comp.sug;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.common.common.never.component.EeveeComponent;

@ComponentName(type = "eevee_sug")
public class ESugComponent extends EeveeComponent<ESugView, C17583a> {
    /* access modifiers changed from: protected */
    public ESugView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new ESugView();
    }

    /* access modifiers changed from: protected */
    public C17583a onCreatePresenter(ComponentParams componentParams) {
        return new C17583a(componentParams);
    }
}
