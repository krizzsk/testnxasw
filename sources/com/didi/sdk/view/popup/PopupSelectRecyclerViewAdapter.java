package com.didi.sdk.view.popup;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class PopupSelectRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    private LayoutInflater f40871a;

    /* renamed from: b */
    private Context f40872b;

    /* renamed from: c */
    private List<PopupSelectModel> f40873c;

    /* renamed from: d */
    private String f40874d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PopupSelectView.OnPopupSelectListClickListener f40875e;

    public int getItemViewType(int i) {
        return 0;
    }

    public PopupSelectRecyclerViewAdapter(Context context) {
        this.f40871a = LayoutInflater.from(context);
        this.f40873c = new ArrayList();
        this.f40872b = context;
    }

    public void updateItems(List<PopupSelectModel> list) {
        this.f40873c = list;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(this.f40871a.inflate(R.layout.global_popup_select_view_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        String str = this.f40873c.get(i).name;
        if (!TextUtils.isEmpty(str)) {
            ((ItemViewHolder) viewHolder).name.setText(str);
        }
        if (this.f40874d.equals(this.f40873c.get(i).f40884id)) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            itemViewHolder.name.setTextColor(this.f40872b.getResources().getColor(R.color.global_popup_select_view_item_sel));
            itemViewHolder.img.setImageResource(DidiThemeManager.getIns().getResPicker(this.f40872b).getResIdByTheme(R.attr.checkbox_selected_icon));
        } else {
            ItemViewHolder itemViewHolder2 = (ItemViewHolder) viewHolder;
            itemViewHolder2.name.setTextColor(this.f40872b.getResources().getColor(R.color.global_popup_select_view_item_nor));
            itemViewHolder2.img.setImageResource(DidiThemeManager.getIns().getResPicker(this.f40872b).getResIdByTheme(R.attr.checkbox_unselected_icon));
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (PopupSelectRecyclerViewAdapter.this.f40875e != null) {
                    PopupSelectRecyclerViewAdapter.this.f40875e.onItemClick(i);
                }
            }
        });
    }

    public int getItemCount() {
        List<PopupSelectModel> list = this.f40873c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setSelectItem(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f40874d = str;
        }
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f40875e = onPopupSelectListClickListener;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;

        public ItemViewHolder(View view) {
            super(view);
            this.img = (ImageView) view.findViewById(R.id.select_item_icon);
            this.name = (TextView) view.findViewById(R.id.select_item_name);
        }
    }
}
