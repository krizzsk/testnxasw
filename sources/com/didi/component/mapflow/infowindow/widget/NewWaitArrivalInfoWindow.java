package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.mapflow.infowindow.model.NewWaitArrivalWithTipsModel;
import com.taxis99.R;

public class NewWaitArrivalInfoWindow extends LinearLayout {

    /* renamed from: a */
    private TextView f16146a;

    /* renamed from: b */
    private TextView f16147b;

    /* renamed from: c */
    private TextView f16148c;

    /* renamed from: d */
    private TextView f16149d;

    /* renamed from: e */
    private TextView f16150e;

    public NewWaitArrivalInfoWindow(Context context) {
        super(context);
        m13343a();
    }

    /* renamed from: a */
    private void m13343a() {
        inflate(getContext(), R.layout.global_map_new_wait_arrival_info_window, this);
        this.f16146a = (TextView) findViewById(R.id.message);
        this.f16147b = (TextView) findViewById(R.id.eta);
        this.f16148c = (TextView) findViewById(R.id.eda);
        this.f16149d = (TextView) findViewById(R.id.eda_count);
        this.f16150e = (TextView) findViewById(R.id.address);
    }

    public void setEta(String str) {
        this.f16147b.setText(str);
    }

    public void setEda(String str) {
        if ("0".equals(str)) {
            str = "0.1";
        }
        this.f16148c.setText(str);
    }

    public void setEdaCount(String str) {
        this.f16149d.setText(str);
    }

    public void setAddress(String str) {
        this.f16150e.setText(str);
    }

    public void setData(NewWaitArrivalWithTipsModel newWaitArrivalWithTipsModel) {
        if (newWaitArrivalWithTipsModel != null) {
            if (newWaitArrivalWithTipsModel.isShowEdit()) {
                this.f16146a.setVisibility(0);
            } else {
                this.f16146a.setVisibility(8);
            }
            if (!TextUtils.isEmpty(newWaitArrivalWithTipsModel.getEta())) {
                setEta(newWaitArrivalWithTipsModel.getEta());
            }
            if (!TextUtils.isEmpty(newWaitArrivalWithTipsModel.getEda())) {
                setEda(newWaitArrivalWithTipsModel.getEda());
            }
            if (!TextUtils.isEmpty(newWaitArrivalWithTipsModel.getEdaCount())) {
                setEdaCount(newWaitArrivalWithTipsModel.getEdaCount());
            }
            if (!TextUtils.isEmpty(newWaitArrivalWithTipsModel.getAddress())) {
                setAddress(newWaitArrivalWithTipsModel.getAddress());
            }
        }
    }
}
