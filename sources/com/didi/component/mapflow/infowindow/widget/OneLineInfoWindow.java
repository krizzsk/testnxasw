package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.component.common.util.UIUtils;
import com.didi.component.mapflow.infowindow.model.OneLineTimeMessageModel;
import com.didi.component.mapflow.infowindow.model.OneLineTwoMessageModel;
import com.didi.component.mapflow.infowindow.model.OneMessageModel;
import com.didi.component.mapflow.util.InfoWindowUtils;
import com.didi.component.mapflow.util.TextBuilder;
import com.taxis99.R;

public class OneLineInfoWindow extends LinearLayout {

    /* renamed from: a */
    private TextView f16151a;

    /* renamed from: b */
    private ImageView f16152b;

    public OneLineInfoWindow(Context context) {
        super(context);
        m13344a();
    }

    /* renamed from: a */
    private void m13344a() {
        inflate(getContext(), R.layout.global_map_oneline_info_window, this);
        this.f16151a = (TextView) findViewById(R.id.message);
        this.f16152b = (ImageView) findViewById(R.id.arrow);
        this.f16151a.setMaxWidth((int) (((float) UIUtils.getScreenWidth(getContext())) * 0.74f));
    }

    public void setMessage(SpannableString spannableString) {
        this.f16151a.setText(spannableString);
    }

    public void setArrowVisibility(boolean z) {
        if (z) {
            this.f16152b.setVisibility(0);
        } else {
            this.f16152b.setVisibility(8);
        }
    }

    public void setData(OneMessageModel oneMessageModel) {
        if (oneMessageModel != null) {
            setArrowVisibility(oneMessageModel.isShowArrow());
            if (oneMessageModel.getCustomContent() != null) {
                setMessage(oneMessageModel.getCustomContent());
                return;
            }
            TextBuilder textBuilder = new TextBuilder(getContext());
            textBuilder.addText(oneMessageModel.getContent(), (int) R.dimen.oc_map_window_text_size_small, (int) R.color.mapflow_info_window_text_color);
            setMessage(textBuilder.build());
            textBuilder.clear();
        }
    }

    public void setData(OneLineTwoMessageModel oneLineTwoMessageModel) {
        if (oneLineTwoMessageModel != null) {
            setArrowVisibility(oneLineTwoMessageModel.isShowArrow());
            if (oneLineTwoMessageModel.getRightMessage() != null && TextUtils.isEmpty(oneLineTwoMessageModel.getRightMessage().getLeftText())) {
                oneLineTwoMessageModel.getRightMessage().setLeftText(" ");
            }
            TextBuilder oneLineMessage = InfoWindowUtils.getOneLineMessage(getContext(), oneLineTwoMessageModel.getLeftMessage());
            if (oneLineMessage == null) {
                oneLineMessage = new TextBuilder(getContext());
            }
            setMessage(InfoWindowUtils.getOneLineMessage(getContext(), oneLineTwoMessageModel.getRightMessage(), oneLineMessage).build());
        }
    }

    public void setData(OneLineTimeMessageModel oneLineTimeMessageModel) {
        if (oneLineTimeMessageModel != null) {
            setArrowVisibility(oneLineTimeMessageModel.isShowArrow());
            TextBuilder textBuilder = new TextBuilder(getContext());
            if (!TextUtils.isEmpty(oneLineTimeMessageModel.getDescribeText())) {
                textBuilder.addText(oneLineTimeMessageModel.getDescribeText(), (int) R.dimen.oc_map_window_text_size_small, (int) R.color.mapflow_info_window_text_color);
            }
            if (!TextUtils.isEmpty(oneLineTimeMessageModel.getTimeText())) {
                textBuilder.addTextWithColor(oneLineTimeMessageModel.getTimeText(), R.dimen.oc_map_window_text_size_small, DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.caution_color));
            }
            setMessage(textBuilder.build());
        }
    }
}
