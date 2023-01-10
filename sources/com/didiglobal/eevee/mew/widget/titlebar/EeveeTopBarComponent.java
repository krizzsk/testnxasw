package com.didiglobal.eevee.mew.widget.titlebar;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.common.common.never.component.EeveeComponent;

@ComponentName(type = "eevee_top_bar")
public class EeveeTopBarComponent extends EeveeComponent<EeveeTopBarView, C17608a> {
    /* access modifiers changed from: protected */
    public EeveeTopBarView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new EeveeTopBarView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public C17608a onCreatePresenter(ComponentParams componentParams) {
        C17608a aVar = new C17608a(componentParams);
        aVar.mo129011a(this);
        return aVar;
    }
}
