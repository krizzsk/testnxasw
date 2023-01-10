package com.didi.map.global.component.departure.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.departure.wheel.internal.BaseWheelAdapter;
import com.taxis99.R;

public class TerminalWheelAdapter extends BaseWheelAdapter<C10224a> {

    /* renamed from: a */
    private Context f27650a;

    public TerminalWheelAdapter(Context context) {
        this.f27650a = context;
    }

    /* access modifiers changed from: protected */
    public View bindView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(this.f27650a).inflate(R.layout.layout_map_departure_terminal_wheel_item, (ViewGroup) null);
            viewHolder.vTitle = (TextView) view2.findViewById(R.id.title);
            viewHolder.vNearest = (TextView) view2.findViewById(R.id.nearest);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        C10224a aVar = (C10224a) this.mList.get(i);
        viewHolder.vTitle.setText(aVar.f27651a);
        viewHolder.vTitle.setMaxLines(2);
        viewHolder.vNearest.setVisibility(aVar.f27652b ? 0 : 8);
        return view2;
    }

    static class ViewHolder {
        TextView vNearest;
        TextView vTitle;

        ViewHolder() {
        }
    }
}
