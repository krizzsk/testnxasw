package com.didi.unifylogin.view.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.taxis99.R;
import java.util.List;

public class ThirdPartyListAdapter extends BaseAdapter {

    /* renamed from: a */
    List<ItemData> f47751a;

    /* renamed from: b */
    Context f47752b;

    /* renamed from: c */
    LayoutInflater f47753c;

    public long getItemId(int i) {
        return (long) i;
    }

    public ThirdPartyListAdapter(List<ItemData> list, Context context) {
        this.f47752b = context;
        this.f47751a = list;
        this.f47753c = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.f47751a.size();
    }

    public Object getItem(int i) {
        return this.f47751a.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        Context context;
        if (view == null) {
            view = this.f47753c.inflate(R.layout.login_unify_view_third_party_item, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.tagTv = (TextView) view.findViewById(R.id.tv_third_tag);
            viewHolder.stateTv = (TextView) view.findViewById(R.id.tv_third_state);
            viewHolder.icon = (ImageView) view.findViewById(R.id.iv_third_icon);
            view.setTag(viewHolder);
        }
        ViewHolder viewHolder2 = (ViewHolder) view.getTag();
        ItemData itemData = this.f47751a.get(i);
        viewHolder2.icon.setBackgroundResource(itemData.thirdPartyLogin.getIconResource());
        TextView textView = viewHolder2.stateTv;
        if (itemData.isBind) {
            context = this.f47752b;
            i2 = R.string.login_unify_third_party_bind;
        } else {
            context = this.f47752b;
            i2 = R.string.login_unify_third_party_unBind;
        }
        textView.setText(context.getString(i2));
        viewHolder2.tagTv.setText(itemData.thirdPartyLogin.getText());
        return view;
    }

    class ViewHolder {
        ImageView icon;
        TextView stateTv;
        TextView tagTv;

        ViewHolder() {
        }
    }

    public static class ItemData {
        public boolean isBind;
        public AbsThirdPartyLoginBase thirdPartyLogin;

        public ItemData(AbsThirdPartyLoginBase absThirdPartyLoginBase, boolean z) {
            this.thirdPartyLogin = absThirdPartyLoginBase;
            this.isBind = z;
        }
    }
}
