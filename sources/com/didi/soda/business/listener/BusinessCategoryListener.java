package com.didi.soda.business.listener;

import com.didi.soda.business.model.BusinessCategoryMenuRvModel;
import java.util.List;

public interface BusinessCategoryListener {
    void showDyCategory(List<BusinessCategoryMenuRvModel> list, BusinessSelectedCallback businessSelectedCallback);
}
