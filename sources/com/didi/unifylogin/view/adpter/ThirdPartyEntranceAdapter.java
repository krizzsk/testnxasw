package com.didi.unifylogin.view.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.unifylogin.store.LoginStore;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;
import java.util.List;

public class ThirdPartyEntranceAdapter extends BaseAdapter {

    /* renamed from: a */
    Context f47746a;

    /* renamed from: b */
    LayoutInflater f47747b;

    /* renamed from: c */
    List<AbsThirdPartyLoginBase> f47748c;

    /* renamed from: d */
    ItemClickListener f47749d;

    /* renamed from: e */
    int f47750e = 0;

    public interface ItemClickListener {
        void OnItemClickListener(int i);
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public ThirdPartyEntranceAdapter(Context context, ItemClickListener itemClickListener, List<AbsThirdPartyLoginBase> list) {
        this.f47746a = context;
        this.f47748c = list;
        this.f47747b = LayoutInflater.from(context);
        this.f47749d = itemClickListener;
    }

    public void setVersion(int i) {
        this.f47750e = i;
    }

    public int getCount() {
        return this.f47748c.size();
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f47747b.inflate(this.f47750e == 2 ? R.layout.login_unify_view_third_way_v2 : R.layout.login_unify_view_third_way, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) view.findViewById(R.id.iv_icon);
            viewHolder.name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(viewHolder);
        }
        ViewHolder viewHolder2 = (ViewHolder) view.getTag();
        AbsThirdPartyLoginBase absThirdPartyLoginBase = this.f47748c.get(i);
        viewHolder2.name.setText(absThirdPartyLoginBase.getText());
        viewHolder2.icon.setBackgroundResource(absThirdPartyLoginBase.getIconResource());
        viewHolder2.icon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ThirdPartyEntranceAdapter.this.f47749d != null) {
                    ThirdPartyEntranceAdapter.this.f47749d.OnItemClickListener(i);
                }
            }
        });
        DIDIFontUtils.Companion.setTypeface(LoginStore.getContext(), viewHolder2.name);
        return view;
    }

    class ViewHolder {
        ImageView icon;
        TextView name;

        ViewHolder() {
        }
    }
}
