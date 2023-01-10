package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SAPanelAdapter */
public class SAPanelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    private List<SACardProperty> f53676a;

    /* renamed from: b */
    private HashMap<Integer, SACardProperty> f53677b = new HashMap<>();

    /* renamed from: c */
    private Logger f53678c = LoggerFactory.getLogger("SAPanelAdapter");

    /* renamed from: d */
    private HashMap<Integer, Integer> f53679d = new HashMap<>();

    /* renamed from: e */
    private Context f53680e;

    public SAPanelAdapter(Context context) {
        this.f53680e = context;
        this.f53676a = new ArrayList();
    }

    public List<SACardProperty> getmCardList() {
        return this.f53676a;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        SACardProperty sACardProperty = this.f53677b.get(Integer.valueOf(i));
        PanelItemContainer panelItemContainer = new PanelItemContainer(sACardProperty.getId(), this.f53679d.get(Integer.valueOf(i)).intValue(), this.f53680e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (sACardProperty.getView().getParent() != null && (sACardProperty.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) sACardProperty.getView().getParent()).removeAllViews();
        }
        panelItemContainer.addView(sACardProperty.getView(), layoutParams);
        return new SAViewHolder(panelItemContainer);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        SACardProperty sACardProperty = this.f53676a.get(i);
        if (sACardProperty.getListener() != null) {
            sACardProperty.getListener().cardWillDisplay();
        }
    }

    /* renamed from: a */
    private int m40062a(SACardProperty sACardProperty) {
        if (sACardProperty == null || sACardProperty.getView() == null) {
            return -1;
        }
        return sACardProperty.getView().hashCode();
    }

    public int getItemCount() {
        return this.f53676a.size();
    }

    public int getItemViewType(int i) {
        int a = m40062a(this.f53676a.get(i));
        this.f53679d.put(Integer.valueOf(a), Integer.valueOf(i));
        return a;
    }

    public void updateCard(SACardProperty sACardProperty) {
        int i = 0;
        while (i < this.f53676a.size()) {
            SACardProperty sACardProperty2 = this.f53676a.get(i);
            if (sACardProperty.getId() == null || !sACardProperty2.getId().equals(sACardProperty2.getId())) {
                i++;
            } else {
                sACardProperty2.setView(sACardProperty.getView());
                notifyItemChanged(i);
                return;
            }
        }
    }

    public void setCardPropertyList(List<SACardProperty> list) {
        this.f53676a.clear();
        this.f53677b.clear();
        this.f53679d.clear();
        this.f53676a.addAll(list);
        Logger logger = this.f53678c;
        logger.info("modelist size: " + this.f53676a.size(), new Object[0]);
        for (SACardProperty next : list) {
            Logger logger2 = this.f53678c;
            logger2.info("cardid: " + next.getId(), new Object[0]);
            this.f53677b.put(Integer.valueOf(m40062a(next)), next);
        }
        notifyDataSetChanged();
    }

    public void addCard(SACardProperty sACardProperty, int i) {
        this.f53676a.add(i, sACardProperty);
        this.f53677b.put(Integer.valueOf(m40062a(sACardProperty)), sACardProperty);
        this.f53679d.put(Integer.valueOf(m40062a(sACardProperty)), Integer.valueOf(i));
        notifyItemInserted(i);
    }

    public void removeCard(int i) {
        this.f53676a.remove(i);
        this.f53677b.remove(Integer.valueOf(m40062a(this.f53676a.get(i))));
        notifyItemRemoved(i);
    }
}
