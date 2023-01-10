package com.didi.globalsafetoolkit.business.share.model;

import com.didi.globalsafetoolkit.model.ISfBaseObject;
import java.io.Serializable;

public class NewContactsModelForShare implements ISfBaseObject, Serializable {
    public String name;
    public boolean need_areacode;
    public String phone;
}
