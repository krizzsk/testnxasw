package com.didiglobal.dittoview.view.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.didiglobal.dittoview.DittoEventListener;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;

class DittoRecyclerAdapter extends RecyclerView.Adapter<DittoHolder> {

    /* renamed from: a */
    public ArrayList<SubCardData> f52561a = new ArrayList<>();

    /* renamed from: b */
    private ArrayList<View> f52562b = new ArrayList<>();

    /* renamed from: c */
    private DittoEventListener f52563c;

    public int getItemViewType(int i) {
        return i;
    }

    DittoRecyclerAdapter() {
    }

    /* renamed from: a */
    public DittoHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DittoHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ditto_rv_holder_layout, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(DittoHolder dittoHolder, int i) {
        dittoHolder.bind(i);
        View view = dittoHolder.itemView;
        View view2 = this.f52562b.get(i);
        ViewParent parent = view2.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeAllViews();
        }
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).addView(view2);
        }
    }

    public int getItemCount() {
        return this.f52562b.size();
    }

    /* renamed from: a */
    public void mo128912a(View view) {
        this.f52562b.add(view);
        this.f52561a.add(new SubCardData("", this.f52562b.size() - 1, (String) view.getTag(R.id.cardId)));
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo128915a(String str) {
        Iterator<SubCardData> it = this.f52561a.iterator();
        while (it.hasNext()) {
            it.next().cardId = str;
        }
    }

    /* renamed from: a */
    public void mo128913a(DittoEventListener dittoEventListener) {
        this.f52563c = dittoEventListener;
    }

    class DittoHolder extends RecyclerView.ViewHolder {
        private int position = 1;

        public DittoHolder(View view) {
            super(view);
        }

        public void bind(int i) {
            this.position = i + 1;
        }
    }
}
