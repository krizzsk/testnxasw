package com.didi.soda.customer.widget.goodsV2.add;

import com.didi.soda.customer.widget.goodsV2.add.C14638a;
import java.io.Serializable;

public interface IGoodsAddView<T extends C14638a> {

    public enum AddType implements Serializable {
        NORMAL,
        BUY_GIFT
    }

    AddType getAddType();

    void updateViewModel(T t);
}
