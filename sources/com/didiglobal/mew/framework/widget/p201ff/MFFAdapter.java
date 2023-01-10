package com.didiglobal.mew.framework.widget.p201ff;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didiglobal.mew.framework.widget.ff.MFFAdapter */
public class MFFAdapter extends RecyclerView.Adapter<MFFViewHolder> {

    /* renamed from: d */
    private static int f52770d = 1001;

    /* renamed from: e */
    private static int f52771e = 1002;

    /* renamed from: a */
    private ArrayList<MFFCardProperty> f52772a = new ArrayList<>();

    /* renamed from: b */
    private int f52773b;

    /* renamed from: c */
    private int f52774c;

    public MFFViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == f52771e) {
            return new MFFViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mew_widget_card_main, viewGroup, false));
        }
        return new MFFViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mew_widget_card, viewGroup, false));
    }

    public void onBindViewHolder(MFFViewHolder mFFViewHolder, int i) {
        MFFCardProperty mFFCardProperty;
        ArrayList<MFFCardProperty> arrayList = this.f52772a;
        if (arrayList != null && (mFFCardProperty = arrayList.get(i)) != null && mFFCardProperty.view != null) {
            View view = mFFViewHolder.itemView;
            view.getContext();
            CardView cardView = new CardView(view.getContext());
            cardView.setRadius(60.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                cardView.setElevation(0.0f);
            }
            cardView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ViewParent parent = cardView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViews();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                viewGroup.removeAllViews();
                viewGroup.addView(cardView);
            }
            View view2 = this.f52772a.get(i).view;
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            ViewParent parent2 = view2.getParent();
            if (parent2 != null && (parent2 instanceof ViewGroup)) {
                ((ViewGroup) parent2).removeAllViews();
            }
            cardView.addView(this.f52772a.get(i).view);
        }
    }

    public int getItemCount() {
        ArrayList<MFFCardProperty> arrayList = this.f52772a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getItemViewType(int i) {
        if (i == this.f52774c) {
            return f52771e;
        }
        return f52770d;
    }

    public void setElevation(int i, int i2) {
        this.f52773b = i;
        this.f52774c = i2;
    }

    public void clear() {
        this.f52772a.clear();
        notifyDataSetChanged();
    }

    public void addCardProperty(int i, MFFCardProperty mFFCardProperty) {
        this.f52772a.add(i, mFFCardProperty);
        notifyItemChanged(i);
    }

    public void setCardPropertyList(List<MFFCardProperty> list) {
        this.f52772a.clear();
        this.f52772a.addAll(list);
        notifyDataSetChanged();
    }

    public void addCardPropertyList(List<MFFCardProperty> list) {
        this.f52772a.addAll(list);
        notifyDataSetChanged();
    }
}
