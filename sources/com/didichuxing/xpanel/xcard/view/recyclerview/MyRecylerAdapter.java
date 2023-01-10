package com.didichuxing.xpanel.xcard.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.xpanel.xcard.ICardListener;
import com.didichuxing.xpanel.xcard.XPanelCardDataHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class MyRecylerAdapter extends RecyclerView.Adapter<MyHolder> {

    /* renamed from: a */
    public ArrayList<SubCardData> f52268a = new ArrayList<>();

    /* renamed from: b */
    private String f52269b = "XpanelHorizontalRecyclerView";

    /* renamed from: c */
    private Context f52270c;

    /* renamed from: d */
    private StartSnapHelper f52271d;

    /* renamed from: e */
    private XPanelHorizontalRecyclerView f52272e;

    /* renamed from: f */
    private ArrayList<View> f52273f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public XPanelCardDataHelper f52274g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ICardListener f52275h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f52276i;

    public int getItemViewType(int i) {
        return i;
    }

    public MyRecylerAdapter(Context context, StartSnapHelper startSnapHelper, XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView) {
        this.f52270c = context;
        this.f52271d = startSnapHelper;
        this.f52272e = xPanelHorizontalRecyclerView;
    }

    /* renamed from: a */
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyHolder(this.f52273f.get(i), this.f52271d, this.f52272e);
    }

    /* renamed from: a */
    public void onBindViewHolder(MyHolder myHolder, int i) {
        myHolder.bind(i);
    }

    public int getItemCount() {
        return this.f52273f.size();
    }

    /* renamed from: a */
    public void mo128333a(View view) {
        this.f52273f.add(view);
        this.f52268a.add(new SubCardData("", this.f52273f.size() - 1, (String) view.getTag(R.id.cardId)));
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo128337a(String str) {
        Iterator<SubCardData> it = this.f52268a.iterator();
        while (it.hasNext()) {
            it.next().cardId = str;
        }
    }

    /* renamed from: a */
    public void mo128335a(XPanelCardDataHelper xPanelCardDataHelper) {
        this.f52274g = xPanelCardDataHelper;
    }

    /* renamed from: a */
    public void mo128334a(ICardListener iCardListener) {
        this.f52275h = iCardListener;
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
                        if (MyRecylerAdapter.this.f52276i == 0 && xPanelHorizontalRecyclerView.getLayoutManager().getChildCount() > 0) {
                            int unused = MyRecylerAdapter.this.f52276i = xPanelHorizontalRecyclerView.getLayoutManager().getChildAt(0).getMeasuredWidth();
                        }
                        xPanelHorizontalRecyclerView.smoothScrollBy(MyRecylerAdapter.this.f52276i, 0);
                    } else if (left >= 0 || right >= measuredWidth || right <= 0) {
                        HashMap hashMap = new HashMap();
                        if (view.getTag(R.id.cardId) != null) {
                            hashMap.put("subcard_id", (String) view.getTag(R.id.cardId));
                        }
                        hashMap.put("scroolCard_position", MyHolder.this.position + "");
                        if (MyRecylerAdapter.this.f52274g != null) {
                            MyRecylerAdapter.this.f52274g.onClick(str);
                            MyRecylerAdapter.this.f52274g.clickSubCardOmega(hashMap);
                            MyRecylerAdapter.this.f52274g.clickOmega("card", hashMap);
                        } else if (MyRecylerAdapter.this.f52275h != null) {
                            hashMap.put("url", str);
                            MyRecylerAdapter.this.f52275h.handleEvent("click", hashMap);
                            MyRecylerAdapter.this.f52275h.handleEvent("xpanel_subcard_ck", hashMap);
                            MyRecylerAdapter.this.f52275h.handleEvent("xpanel_card_ck", hashMap);
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
