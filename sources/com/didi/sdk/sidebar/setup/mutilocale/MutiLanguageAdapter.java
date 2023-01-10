package com.didi.sdk.sidebar.setup.mutilocale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.didi.sdk.view.CommonCheckBox;
import com.taxis99.R;
import java.util.List;

public class MutiLanguageAdapter extends BaseAdapter {

    /* renamed from: a */
    private List<LocaleModel> f40157a;

    /* renamed from: b */
    private Context f40158b;

    public static class ViewHolder {
        View divider;
        CommonCheckBox icon;
        TextView languageTv;
    }

    public long getItemId(int i) {
        return 0;
    }

    public MutiLanguageAdapter(List<LocaleModel> list, Context context) {
        this.f40157a = list;
        this.f40158b = context;
    }

    public int getCount() {
        List<LocaleModel> list = this.f40157a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public LocaleModel getItem(int i) {
        List<LocaleModel> list = this.f40157a;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f40157a.get(i);
    }

    public List<LocaleModel> getData() {
        return this.f40157a;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f40158b).inflate(R.layout.v_lang_item, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.languageTv = (TextView) view.findViewById(R.id.setting_list_item_title);
            viewHolder.divider = view.findViewById(R.id.divider);
            viewHolder.icon = (CommonCheckBox) view.findViewById(R.id.setting_list_item_arrow);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.icon.setSelected(this.f40157a.get(i).isSelected);
        viewHolder.languageTv.setText(this.f40157a.get(i).name);
        return view;
    }
}
