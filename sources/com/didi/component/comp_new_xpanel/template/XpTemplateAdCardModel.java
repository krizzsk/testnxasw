package com.didi.component.comp_new_xpanel.template;

import com.didi.sdk.paxadsdk.model.AdModel;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import java.util.List;

public class XpTemplateAdCardModel extends IXEViewModel {
    public AdCardNormal normal;

    public class AdCardNormal {
        public AdCardData data;

        public AdCardNormal() {
        }
    }

    public class AdCardData {
        public List<AdModelWrapper> ads;

        public AdCardData() {
        }
    }

    public class AdModelWrapper {
        public AdModel data;

        public AdModelWrapper() {
        }
    }
}
