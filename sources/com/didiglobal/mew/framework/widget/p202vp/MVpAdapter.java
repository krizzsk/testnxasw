package com.didiglobal.mew.framework.widget.p202vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didiglobal.mew.framework.widget.vp.MVpAdapter */
public class MVpAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private ArrayList<MVPCardProperty> f52797a = new ArrayList<>();

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mew_widget_vp_view_holder, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        MVPCardProperty mVPCardProperty;
        ArrayList<MVPCardProperty> arrayList = this.f52797a;
        if (arrayList != null && (mVPCardProperty = arrayList.get(i)) != null && mVPCardProperty.view != null) {
            View view = viewHolder.itemView;
            View view2 = this.f52797a.get(i).view;
            ViewParent parent = view2.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViews();
            }
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(view2);
            }
        }
    }

    public int getItemCount() {
        ArrayList<MVPCardProperty> arrayList = this.f52797a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void clear() {
        this.f52797a.clear();
        notifyDataSetChanged();
    }

    public void addCardProperty(int i, MVPCardProperty mVPCardProperty) {
        this.f52797a.add(i, mVPCardProperty);
        notifyItemChanged(i);
    }

    public void setCardPropertyList(List<MVPCardProperty> list) {
        this.f52797a.clear();
        this.f52797a.addAll(list);
        notifyDataSetChanged();
    }

    public void addCardPropertyList(List<MVPCardProperty> list) {
        this.f52797a.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: com.didiglobal.mew.framework.widget.vp.MVpAdapter$ViewHolder */
    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }
}
