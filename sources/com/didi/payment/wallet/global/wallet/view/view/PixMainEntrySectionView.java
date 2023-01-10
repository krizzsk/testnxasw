package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.view.adapter.PixEntryAdapter;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.List;

public class PixMainEntrySectionView extends LinearLayout {
    public static final int STYLE_MAIN_HOME = 0;
    public static final int STYLE_MAIN_HOME_BLOCKED = 4;
    public static final int STYLE_MAIN_HOME_OP = 1;
    public static final int STYLE_MAIN_LIST = 2;
    public static final int STYLE_MAIN_LIST_BLOCKED = 5;
    public static final int STYLE_MAIN_LIST_NEW = 3;

    /* renamed from: a */
    private LayoutInflater f34919a;

    /* renamed from: b */
    private RecyclerView f34920b;

    /* renamed from: c */
    private PixEntryAdapter f34921c;

    /* renamed from: d */
    private int f34922d = 0;

    /* renamed from: e */
    private View f34923e;

    /* renamed from: f */
    private TextView f34924f;

    public PixMainEntrySectionView(Context context) {
        super(context);
        this.f34919a = LayoutInflater.from(context);
        m26667a();
    }

    public PixMainEntrySectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34919a = LayoutInflater.from(context);
        m26667a();
    }

    public PixMainEntrySectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34919a = LayoutInflater.from(context);
        m26667a();
    }

    /* renamed from: a */
    private void m26667a() {
        this.f34919a.inflate(R.layout.pix_main_entry_list_section, this);
        this.f34923e = findViewById(R.id.pix_entry_root);
        this.f34924f = (TextView) findViewById(R.id.w_home_pix_entry_title_tv);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.pix_channel_pix_main_entry);
        this.f34920b = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f34920b.getLayoutParams();
        marginLayoutParams.topMargin = UIUtil.dip2px(getContext(), 12.0f);
        this.f34920b.setLayoutParams(marginLayoutParams);
        PixEntryAdapter pixEntryAdapter = new PixEntryAdapter(getContext());
        this.f34921c = pixEntryAdapter;
        this.f34920b.setAdapter(pixEntryAdapter);
        this.f34921c.setStyle(0);
    }

    public void setStyle(int i) {
        if (i == 0 || i == 1) {
            this.f34923e.setBackgroundColor(getResources().getColor(R.color.wallet_color_EEFAF1));
            this.f34923e.setPadding(0, 0, 0, UIUtil.dip2px(getContext(), 10.0f));
            this.f34924f.setTextSize(16.0f);
        } else if (i == 2 || i == 3) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34924f.getLayoutParams();
            layoutParams.topMargin = UIUtil.dip2px(getContext(), 12.0f);
            this.f34924f.setLayoutParams(layoutParams);
            this.f34924f.setTextSize(2, (float) 19);
            this.f34920b.setBackground(ResourcesHelper.getDrawable(getContext(), R.drawable.w_common_rectangle_white_corner20_bg));
            this.f34920b.setPadding(0, UIUtil.dip2px(getContext(), 10.0f), 0, UIUtil.dip2px(getContext(), 12.0f));
        } else if (i == 4) {
            this.f34923e.setBackgroundColor(getResources().getColor(R.color.white));
            this.f34923e.setPadding(0, 0, 0, UIUtil.dip2px(getContext(), 10.0f));
            this.f34924f.setTextSize(16.0f);
        } else if (i == 5) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f34924f.getLayoutParams();
            layoutParams2.topMargin = UIUtil.dip2px(getContext(), 12.0f);
            this.f34924f.setLayoutParams(layoutParams2);
            this.f34924f.setTextSize(2, 19.0f);
            this.f34920b.setBackgroundColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_F3F4F5));
            this.f34920b.setPadding(0, UIUtil.dip2px(getContext(), 10.0f), 0, UIUtil.dip2px(getContext(), 12.0f));
        }
    }

    public void setPixEntries(String str, WalletHomeResp.PixEntrySection pixEntrySection) {
        if (!TextUtil.isEmpty(str)) {
            this.f34924f.setText(str);
        }
        if (WalletHomeResp.isSectionValid(pixEntrySection)) {
            this.f34921c.setChannels(pixEntrySection.entryList);
            this.f34921c.notifyDataSetChanged();
        }
    }

    public void setPixEntries(String str, List<WalletHomeResp.PixEntry> list) {
        if (!TextUtil.isEmpty(str)) {
            this.f34924f.setText(str);
        }
        this.f34921c.setChannels(list);
        this.f34921c.notifyDataSetChanged();
    }

    public void setEventDeliveryListener(IPixEntryClickListener iPixEntryClickListener) {
        this.f34921c.setEntryListener(iPixEntryClickListener);
    }
}
