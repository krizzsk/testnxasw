package com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.ListViewAdapter;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.view.SugListView;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.List;

public class FuzzyMatchListView extends FrameLayout {

    /* renamed from: e */
    private static final int f9053e = 5;

    /* renamed from: a */
    private ViewGroup f9054a;

    /* renamed from: b */
    private ViewGroup f9055b;

    /* renamed from: c */
    private SugListView f9056c;

    /* renamed from: d */
    private FuzzyMatchCardCallback f9057d;

    /* renamed from: f */
    private int f9058f = 0;

    public FuzzyMatchListView(Context context) {
        super(context);
        m7757a();
    }

    public FuzzyMatchListView(Context context, FuzzyMatchCardCallback fuzzyMatchCardCallback) {
        super(context);
        m7757a();
        setCardCallback(fuzzyMatchCardCallback);
    }

    /* renamed from: a */
    private void m7757a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.framelayout_list_view, this, false);
        SugListView sugListView = (SugListView) inflate.findViewById(R.id.list_view);
        this.f9056c = sugListView;
        sugListView.setPadding(0, ViewUtils.dip2px(getContext(), 20.0f), 0, 0);
        this.f9056c.setDivider((Drawable) null);
        this.f9056c.setDividerHeight(0);
        this.f9056c.setAdapter(new ArrayAdapter(getContext(), 17367043, new String[0]));
        this.f9054a = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.poi_one_address_address_power_by_google_view, this.f9056c, false);
        this.f9055b = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.poi_white_logo_view, this.f9056c, false);
        addView(inflate);
    }

    public void setCardCallback(FuzzyMatchCardCallback fuzzyMatchCardCallback) {
        if (fuzzyMatchCardCallback != null) {
            this.f9057d = fuzzyMatchCardCallback;
        }
    }

    private void setLogoView(ListView listView) {
        if (listView != null) {
            listView.removeFooterView(this.f9054a);
            listView.removeFooterView(this.f9055b);
            TextView textView = (TextView) this.f9054a.findViewById(R.id.powered_by_text);
            textView.setText(String.format(textView.getText().toString(), new Object[]{""}));
            listView.addFooterView(this.f9054a, (Object) null, false);
        }
    }

    private void setContainerHeightByListView(ListView listView) {
        ListAdapter adapter;
        if (listView != null && (adapter = listView.getAdapter()) != null) {
            int i = 0;
            for (int i2 = 0; i2 < Math.min(adapter.getCount(), 5); i2++) {
                View view = adapter.getView(i2, (View) null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int dividerHeight = i + (listView.getDividerHeight() * (adapter.getCount() - 1));
            if (((double) dividerHeight) > ((double) getScreenHeight()) * 0.4d) {
                layoutParams.height = (int) (((double) getScreenHeight()) * 0.4d);
            } else {
                layoutParams.height = dividerHeight;
            }
            setLayoutParams(layoutParams);
        }
    }

    public void updateListData(List<RpcPoi> list, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, boolean z, int i2) {
        if (list != null) {
            if (z) {
                setLogoView(this.f9056c);
            } else {
                this.f9056c.removeFooterView(this.f9054a);
                this.f9056c.removeFooterView(this.f9055b);
                this.f9056c.addFooterView(this.f9055b);
            }
            ListViewAdapter listViewAdapter = new ListViewAdapter(list, trackParameterForChild, i, i2);
            listViewAdapter.setSupportConfirmDropOff(true);
            listViewAdapter.setOnItemSelectedListener(new ListViewAdapter.OnItemSelectedListener() {
                public final void onItemSelected(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
                    FuzzyMatchListView.this.m7758a(rpcPoi, trackParameterForChild, i, i2);
                }
            });
            this.f9056c.setAdapter(listViewAdapter);
            setContainerHeightByListView(this.f9056c);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7758a(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
        FuzzyMatchCardCallback fuzzyMatchCardCallback = this.f9057d;
        if (fuzzyMatchCardCallback != null) {
            fuzzyMatchCardCallback.onSelectAddress(rpcPoi, trackParameterForChild, i, i2);
        }
    }

    public int getScreenHeight() {
        if (this.f9058f <= 0 && getContext() != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.f9058f = displayMetrics.heightPixels;
        }
        return this.f9058f;
    }
}
