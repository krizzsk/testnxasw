package com.didi.beatles.p101im.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.access.action.IMActionItem;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.views.imageView.IMNetworkImageView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.beatles.im.adapter.IMFuncAdapter */
public class IMFuncAdapter extends RecyclerView.Adapter {

    /* renamed from: a */
    private Context f10911a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMFuncOnClickListener f10912b;

    /* renamed from: c */
    private List<IMActionItem> f10913c;

    /* renamed from: d */
    private List<IMActionItem> f10914d;

    /* renamed from: com.didi.beatles.im.adapter.IMFuncAdapter$IMFuncOnClickListener */
    public interface IMFuncOnClickListener {
        void onClick(IMActionItem iMActionItem);
    }

    public IMFuncAdapter(Context context, List<IMActionItem> list, IMFuncOnClickListener iMFuncOnClickListener) {
        this.f10911a = context;
        this.f10912b = iMFuncOnClickListener;
        this.f10913c = list;
        if (list == null) {
            this.f10913c = Collections.emptyList();
        }
        this.f10914d = Collections.emptyList();
    }

    public void changeSystemList(List<IMActionItem> list) {
        if (list != null) {
            this.f10913c = list;
            notifyDataSetChanged();
        }
    }

    public void changeMoreList(List<IMActionItem> list) {
        if (list != null) {
            this.f10914d = list;
            notifyDataSetChanged();
        }
    }

    public void refreshItem(IMActionItem iMActionItem) {
        List<IMActionItem> list;
        List<IMActionItem> list2 = this.f10913c;
        int indexOf = list2 != null ? list2.indexOf(iMActionItem) : -1;
        if (indexOf < 0 && (list = this.f10914d) != null && (indexOf = list.indexOf(iMActionItem)) >= 0) {
            List<IMActionItem> list3 = this.f10913c;
            indexOf += list3 == null ? 0 : list3.size();
        }
        if (indexOf >= 0) {
            notifyItemChanged(indexOf);
        }
    }

    public List<IMActionItem> getTotalList() {
        ArrayList arrayList = new ArrayList();
        List<IMActionItem> list = this.f10914d;
        if (list != null) {
            arrayList.addAll(list);
        }
        List<IMActionItem> list2 = this.f10913c;
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FuncViewHolder(LayoutInflater.from(this.f10911a).inflate(R.layout.im_func_item, (ViewGroup) null));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        List<IMActionItem> list;
        if (i < this.f10913c.size()) {
            list = this.f10913c;
        } else {
            list = this.f10914d;
            i -= this.f10913c.size();
        }
        final IMActionItem iMActionItem = list.get(i);
        FuncViewHolder funcViewHolder = (FuncViewHolder) viewHolder;
        funcViewHolder.imageView.setImageResource(iMActionItem.iconId);
        funcViewHolder.descTv.setText(iMActionItem.text);
        IMViewUtil.hide(funcViewHolder.dotV);
        if (iMActionItem.enable) {
            funcViewHolder.itemView.setAlpha(1.0f);
            if (iMActionItem.item != null && iMActionItem.item.funcRedDot(funcViewHolder.itemView.getContext())) {
                IMViewUtil.show(funcViewHolder.dotV);
            }
            funcViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (IMFuncAdapter.this.f10912b != null) {
                        IMFuncAdapter.this.f10912b.onClick(iMActionItem);
                    }
                }
            });
            return;
        }
        funcViewHolder.itemView.setAlpha(0.4f);
        funcViewHolder.imageView.setOnClickListener((View.OnClickListener) null);
    }

    public int getItemCount() {
        return this.f10913c.size() + this.f10914d.size();
    }

    /* renamed from: com.didi.beatles.im.adapter.IMFuncAdapter$FuncViewHolder */
    private class FuncViewHolder extends RecyclerView.ViewHolder {
        TextView descTv;
        View dotV;
        IMNetworkImageView imageView;

        FuncViewHolder(View view) {
            super(view);
            this.imageView = (IMNetworkImageView) view.findViewById(R.id.im_func_item_iv);
            this.descTv = (TextView) view.findViewById(R.id.im_func_item_tv);
            this.dotV = view.findViewById(R.id.im_func_item_dot);
        }
    }
}
