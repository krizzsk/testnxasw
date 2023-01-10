package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.common.view.GlobalTipsView;
import com.didi.component.mapflow.infowindow.model.EditWithTipsModel;
import com.taxis99.R;

public class EditInfoWindow extends LinearLayout {

    /* renamed from: a */
    private GlobalTipsView f16127a;

    /* renamed from: b */
    private TextView f16128b;

    public EditInfoWindow(Context context) {
        super(context);
        m13329a();
    }

    /* renamed from: a */
    private void m13329a() {
        inflate(getContext(), R.layout.global_map_edit_info_window, this);
        this.f16128b = (TextView) findViewById(R.id.message);
        GlobalTipsView globalTipsView = (GlobalTipsView) findViewById(R.id.global_tips_view);
        this.f16127a = globalTipsView;
        globalTipsView.setPos(1, 0);
    }

    public void setMessage(String str) {
        this.f16128b.setText(str);
    }

    public void setTips(String str) {
        this.f16127a.setTips(str);
    }

    public void setData(EditWithTipsModel editWithTipsModel) {
        if (editWithTipsModel != null) {
            if (!TextUtils.isEmpty(editWithTipsModel.getContent())) {
                setMessage(editWithTipsModel.getContent());
            }
            if (!TextUtils.isEmpty(editWithTipsModel.getTips())) {
                setTips(editWithTipsModel.getTips());
                this.f16127a.setVisibility(0);
                return;
            }
            this.f16127a.setVisibility(8);
        }
    }
}
