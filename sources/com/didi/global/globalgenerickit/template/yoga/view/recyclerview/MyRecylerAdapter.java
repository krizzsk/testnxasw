package com.didi.global.globalgenerickit.template.yoga.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class MyRecylerAdapter extends RecyclerView.Adapter<MyHolder> {

    /* renamed from: a */
    public ArrayList<SubCardData> f24223a = new ArrayList<>();

    /* renamed from: b */
    private String f24224b = "XpanelHorizontalRecyclerView";

    /* renamed from: c */
    private Context f24225c;

    /* renamed from: d */
    private StartSnapHelper f24226d;

    /* renamed from: e */
    private XPanelHorizontalRecyclerView f24227e;

    /* renamed from: f */
    private ArrayList<View> f24228f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EventListener f24229g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f24230h;

    public int getItemViewType(int i) {
        return i;
    }

    public MyRecylerAdapter(Context context, StartSnapHelper startSnapHelper, XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView) {
        this.f24225c = context;
        this.f24226d = startSnapHelper;
        this.f24227e = xPanelHorizontalRecyclerView;
    }

    /* renamed from: a */
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyHolder(this.f24228f.get(i), this.f24226d, this.f24227e);
    }

    /* renamed from: a */
    public void onBindViewHolder(MyHolder myHolder, int i) {
        myHolder.bind(i);
    }

    public int getItemCount() {
        return this.f24228f.size();
    }

    /* renamed from: a */
    public void mo71938a(View view) {
        this.f24228f.add(view);
        this.f24223a.add(new SubCardData("", this.f24228f.size() - 1, (String) view.getTag(R.id.cardId)));
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo71941a(String str) {
        Iterator<SubCardData> it = this.f24223a.iterator();
        while (it.hasNext()) {
            it.next().cardId = str;
        }
    }

    /* renamed from: a */
    public void mo71939a(EventListener eventListener) {
        this.f24229g = eventListener;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public int position = 1;

        public MyHolder(final View view, StartSnapHelper startSnapHelper, final XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView) {
            super(view);
            view.setOnClickListener(new View.OnClickListener(MyRecylerAdapter.this) {
                public void onClick(View view) {
                    String str;
                    AutoTrackHelper.trackViewOnClick(view);
                    try {
                        str = (String) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        str = "";
                    }
                    int measuredWidth = xPanelHorizontalRecyclerView.getMeasuredWidth();
                    int left = view.getLeft();
                    int right = view.getRight();
                    if (left < measuredWidth && right > measuredWidth) {
                        if (MyRecylerAdapter.this.f24230h == 0 && xPanelHorizontalRecyclerView.getLayoutManager().getChildCount() > 0) {
                            int unused = MyRecylerAdapter.this.f24230h = xPanelHorizontalRecyclerView.getLayoutManager().getChildAt(0).getMeasuredWidth();
                        }
                        xPanelHorizontalRecyclerView.smoothScrollBy(MyRecylerAdapter.this.f24230h, 0);
                    } else if (left >= 0 || right >= measuredWidth || right <= 0) {
                        HashMap hashMap = new HashMap();
                        if (view.getTag(R.id.cardId) != null) {
                            hashMap.put("subcard_id", (String) view.getTag(R.id.cardId));
                        }
                        hashMap.put("scroolCard_position", MyHolder.this.position + "");
                        if (MyRecylerAdapter.this.f24229g != null) {
                            hashMap.put("url", str);
                            MyRecylerAdapter.this.f24229g.handleEvent("click", str, hashMap);
                            MyRecylerAdapter.this.f24229g.handleEvent("xpanel_subcard_ck", str, hashMap);
                            MyRecylerAdapter.this.f24229g.handleEvent("xpanel_card_ck", str, hashMap);
                        }
                    } else {
                        XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView = xPanelHorizontalRecyclerView;
                        xPanelHorizontalRecyclerView.smoothScrollBy(left - xPanelHorizontalRecyclerView.decorationPadding, 0);
                    }
                }
            });
        }

        public void bind(int i) {
            this.position = i + 1;
        }
    }
}
