package com.didi.map.global.component.departure.canoe.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.didi.common.map.util.DisplayUtils;
import com.taxis99.R;

public abstract class AbsCanoeAddressView extends CardView {

    /* renamed from: a */
    private View f27258a;

    /* renamed from: b */
    private TextView f27259b;

    /* renamed from: c */
    private int f27260c;

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    public AbsCanoeAddressView(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(getLayoutId(), this);
        this.f27258a = inflate;
        this.f27259b = (TextView) inflate.findViewById(R.id.name);
        setRadius((float) DisplayUtils.dp2px(context, 20.0f));
        this.f27260c = DisplayUtils.dp2px(context, 20.0f);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        View view = this.f27258a;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setAddressName(String str) {
        TextView textView = this.f27259b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public int[] getWidthHeight() {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{getMeasuredWidth(), getMeasuredHeight()};
    }

    public int getAngle() {
        return this.f27260c;
    }
}
