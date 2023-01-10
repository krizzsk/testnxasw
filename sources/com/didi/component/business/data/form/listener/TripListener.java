package com.didi.component.business.data.form.listener;

import com.didi.component.business.data.form.listener.observer.XpanelResponseListener;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import java.util.List;

public interface TripListener {
    void addXpanelResponseListener(XpanelResponseListener xpanelResponseListener);

    List<AnyCarGroup> getGroups();

    boolean getIsAnyCar();

    int getPreference();

    List<AnyCarEstimateItemModel> getSelectedAnyCarItems();

    AnyCarEstimateItemModel getSelectedSingleAnyCarItem();

    List<XpanelResponseListener> getXpanelResponseListener();

    void setGroups(List<AnyCarGroup> list);

    void setIsAnyCar(boolean z);

    void setPreference(int i);

    void setSelectedAnyCarItem(List<AnyCarEstimateItemModel> list);

    void setSelectedSingleAnyCarItem(AnyCarEstimateItemModel anyCarEstimateItemModel);
}
