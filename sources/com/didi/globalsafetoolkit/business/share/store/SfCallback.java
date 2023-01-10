package com.didi.globalsafetoolkit.business.share.store;

import com.didi.globalsafetoolkit.model.SfContactsModel;
import java.util.List;

public interface SfCallback {
    void onFailed(String str);

    void onSucceed(List<SfContactsModel> list);
}
