package com.didi.component.cancelbar.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.cancelbar.AbsCancelPresenter;
import com.didi.component.cancelbar.CancelTextModel;
import com.didi.component.cancelbar.ICancelView;
import com.taxis99.R;

public class CancelView implements ICancelView {

    /* renamed from: a */
    private View f13263a;

    /* renamed from: b */
    private TextView f13264b;
    protected AbsCancelPresenter mPresenter;

    public CancelView(Context context, ViewGroup viewGroup) {
        View onCreateView = onCreateView(context, viewGroup);
        this.f13263a = onCreateView;
        TextView textView = (TextView) onCreateView.findViewById(R.id.cancel_text);
        this.f13264b = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CancelView.this.mPresenter.onClickCancel();
            }
        });
    }

    /* access modifiers changed from: protected */
    public View onCreateView(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.global_cancel_layout, viewGroup, false);
    }

    public View getView() {
        return this.f13263a;
    }

    public void setPresenter(AbsCancelPresenter absCancelPresenter) {
        this.mPresenter = absCancelPresenter;
    }

    public void setButtonText(String str) {
        this.f13264b.setText(str);
    }

    public void setButtonInfo(CancelTextModel cancelTextModel) {
        if (cancelTextModel != null && cancelTextModel.btnInfo != null) {
            cancelTextModel.btnInfo.bindTextView(this.f13264b);
        }
    }
}
