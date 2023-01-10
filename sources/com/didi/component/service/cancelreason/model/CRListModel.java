package com.didi.component.service.cancelreason.model;

import com.didi.travel.psnger.model.response.CancelReasonInfo;
import java.io.Serializable;

public class CRListModel implements Serializable {
    public String icon;

    /* renamed from: id */
    public String f17645id;
    public CancelReasonInfo.CancelReasonOperation operations;
    public int reason_type;
    public int show_alert;
    public String text;
}
