package com.didichuxing.xpanel.debug.p199ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.xpanel.agent.net.XPanelRequest;
import com.didichuxing.xpanel.debug.models.DebugInfo;
import com.didichuxing.xpanel.debug.models.ListItem;
import com.didichuxing.xpanel.util.Utils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didichuxing.xpanel.debug.ui.DetailActivity */
public class DetailActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f52063a;

    /* renamed from: b */
    private int f52064b;

    /* renamed from: c */
    private DebugInfoAdapter f52065c;

    /* renamed from: d */
    private RecyclerView f52066d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DebugInfo f52067e;

    /* renamed from: f */
    private ActionBar f52068f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<ListItem> f52069g = new ArrayList();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.oc_x_panel_debug_detail_activity);
        this.f52063a = this;
        Intent intent = getIntent();
        if (intent != null) {
            this.f52064b = intent.getIntExtra("position", -1);
        }
        ActionBar actionBar = getActionBar();
        this.f52068f = actionBar;
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            this.f52068f.setHomeButtonEnabled(true);
            this.f52068f.setDisplayShowTitleEnabled(true);
            this.f52068f.setTitle(R.string.oc_x_panel_debug_detai_title);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.oc_x_panel_debug_address_list);
        this.f52066d = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f52063a));
        DebugInfoAdapter debugInfoAdapter = new DebugInfoAdapter();
        this.f52065c = debugInfoAdapter;
        this.f52066d.setAdapter(debugInfoAdapter);
        this.f52066d.setOverScrollMode(2);
        m39165a();
    }

    /* renamed from: a */
    private void m39165a() {
        this.f52069g.clear();
        if (XPanelRequest.mDebugInfos.size() > this.f52064b) {
            DebugInfo debugInfo = XPanelRequest.mDebugInfos.get(this.f52064b);
            this.f52067e = debugInfo;
            if (debugInfo != null) {
                ListItem listItem = new ListItem();
                listItem.content = this.f52067e.getRequestUrl();
                listItem.description = "概况";
                this.f52069g.add(listItem);
                ListItem listItem2 = new ListItem();
                listItem2.content = this.f52067e.getRequestTime();
                this.f52069g.add(listItem2);
                ListItem listItem3 = new ListItem();
                listItem3.description = "请求参数";
                listItem3.isShowDivider = true;
                this.f52069g.add(listItem3);
                HashMap<String, Object> params = this.f52067e.getParams();
                List<String> keyList = this.f52067e.getKeyList();
                for (int i = 0; i < keyList.size(); i++) {
                    ListItem listItem4 = new ListItem();
                    String str = keyList.get(i);
                    Object obj = params.get(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" : ");
                    sb.append(obj == null ? "" : obj.toString());
                    listItem4.content = sb.toString();
                    this.f52069g.add(listItem4);
                }
                ListItem listItem5 = new ListItem();
                listItem5.content = this.f52067e.getResult();
                listItem5.description = "返回结果";
                listItem5.subContent = this.f52067e.getRequestTime() + " " + this.f52067e.getDimension();
                listItem5.isShowDivider = true;
                this.f52069g.add(listItem5);
            }
        }
    }

    /* renamed from: com.didichuxing.xpanel.debug.ui.DetailActivity$DebugInfoAdapter */
    private class DebugInfoAdapter extends RecyclerView.Adapter {
        private DebugInfoAdapter() {
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new SimpleHolder(LayoutInflater.from(DetailActivity.this.f52063a).inflate(R.layout.oc_x_panel_debug_item, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            SimpleHolder simpleHolder = (SimpleHolder) viewHolder;
            ListItem listItem = (ListItem) DetailActivity.this.f52069g.get(i);
            if (DetailActivity.this.f52067e != null) {
                String str = listItem.content;
                String str2 = listItem.description;
                String str3 = listItem.subContent;
                simpleHolder.divider1.setVisibility(listItem.isShowDivider ? 0 : 8);
                simpleHolder.content.setText(str);
                simpleHolder.content.setVisibility(Utils.getVisibility(str));
                simpleHolder.subContent.setText(str3);
                simpleHolder.subContent.setVisibility(Utils.getVisibility(str3));
                simpleHolder.description1.setText(str2);
                simpleHolder.description1.setVisibility(Utils.getVisibility(str2));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) simpleHolder.content.getLayoutParams();
                if (layoutParams != null && simpleHolder.content.getVisibility() == 0) {
                    if (TextUtils.isEmpty(str2)) {
                        layoutParams.bottomMargin = DetailActivity.this.getResources().getDimensionPixelSize(R.dimen._16dp);
                        simpleHolder.content.setLayoutParams(layoutParams);
                        return;
                    }
                    layoutParams.bottomMargin = 0;
                    simpleHolder.content.setLayoutParams(layoutParams);
                }
            }
        }

        public int getItemCount() {
            if (DetailActivity.this.f52067e == null) {
                return 0;
            }
            return DetailActivity.this.f52069g.size();
        }

        /* renamed from: com.didichuxing.xpanel.debug.ui.DetailActivity$DebugInfoAdapter$SimpleHolder */
        private class SimpleHolder extends RecyclerView.ViewHolder {
            public TextView content;
            public TextView description1;
            public View divider1;
            public TextView subContent;

            public SimpleHolder(View view) {
                super(view);
                TextView textView = (TextView) view.findViewById(R.id.oc_x_panel_debug_content);
                this.content = textView;
                textView.setTextIsSelectable(true);
                TextView textView2 = (TextView) view.findViewById(R.id.oc_x_panel_debug_sub_content);
                this.subContent = textView2;
                textView2.setTextIsSelectable(true);
                this.divider1 = view.findViewById(R.id.oc_x_panel_debug_divider1);
                TextView textView3 = (TextView) view.findViewById(R.id.oc_x_panel_debug_item_description1);
                this.description1 = textView3;
                textView3.setTextIsSelectable(true);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
