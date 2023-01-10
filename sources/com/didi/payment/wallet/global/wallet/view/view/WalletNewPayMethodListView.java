package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.view.webview.WalletWebActivity;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.wallet.global.wallet.contract.WalletNewPayMethodListContract;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletNewPayMethodAdapter;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.unifiedPay.util.UIUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.taxis99.R;

public class WalletNewPayMethodListView extends LinearLayout implements WalletNewPayMethodListContract.View {

    /* renamed from: a */
    private TextView f34983a;

    /* renamed from: b */
    private RoundedLinearLayout f34984b;

    /* renamed from: c */
    private TextView f34985c;

    /* renamed from: d */
    private RecyclerView f34986d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WalletNewPayMethodAdapter f34987e;

    /* renamed from: f */
    private TextView f34988f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Context f34989g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WalletNewPayMethodListContract.Listener f34990h;

    public WalletNewPayMethodListView(Context context) {
        super(context);
        m26692a(context);
    }

    public WalletNewPayMethodListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26692a(context);
    }

    public WalletNewPayMethodListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26692a(context);
    }

    /* renamed from: a */
    private void m26692a(Context context) {
        this.f34989g = context;
        LayoutInflater.from(context).inflate(R.layout.wallet_global_new_paymethod_list, this);
        this.f34983a = (TextView) findViewById(R.id.tv_paymethod_title);
        this.f34984b = (RoundedLinearLayout) findViewById(R.id.rll_paymethod_list_container);
        this.f34985c = (TextView) findViewById(R.id.tv_paymethod_list_top_tips);
        this.f34986d = (RecyclerView) findViewById(R.id.rv_paymethod_list);
        this.f34988f = (TextView) findViewById(R.id.transaction_entrance);
        m26695b(context);
    }

    /* renamed from: b */
    private void m26695b(Context context) {
        this.f34989g = context;
        setOrientation(1);
        this.f34984b.setRectAdius((float) UIUtil.dip2px(this.f34989g, 20.0f));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        this.f34986d.setLayoutManager(linearLayoutManager);
        this.f34986d.setItemAnimator(new DefaultItemAnimator());
        ItemDivider itemDivider = new ItemDivider(this.f34989g, 1);
        itemDivider.setDrawable(ResourcesHelper.getDrawable(this.f34989g, R.drawable.wallet_balance_history_list_divider));
        this.f34986d.addItemDecoration(itemDivider);
        this.f34986d.setNestedScrollingEnabled(false);
        WalletNewPayMethodAdapter walletNewPayMethodAdapter = new WalletNewPayMethodAdapter(context);
        this.f34987e = walletNewPayMethodAdapter;
        walletNewPayMethodAdapter.setCallback(new WalletNewPayMethodAdapter.Callback() {
            public void onItemClicked(int i) {
                if (WalletNewPayMethodListView.this.f34990h != null) {
                    WalletNewPayMethodListView.this.f34990h.onNewPayMethodItemClicked(i);
                }
            }

            public void onItemRightLabelClicked(int i) {
                WalletNewPayMethodListContract.ItemModel itemModel = WalletNewPayMethodListView.this.f34987e.getData().get(i);
                if (itemModel != null && !TextUtils.isEmpty(itemModel.rightClickLink)) {
                    DRouter.build(itemModel.rightClickLink).start((Context) null);
                } else if (WalletNewPayMethodListView.this.f34990h != null) {
                    WalletNewPayMethodListView.this.f34990h.onNewPayMethodItemRightLabelClicked(i);
                }
            }
        });
        this.f34986d.setAdapter(this.f34987e);
    }

    public void setStyle(int i) {
        if (i == 1) {
            m26694b();
        } else if (i == 2) {
            m26691a();
        }
    }

    /* renamed from: a */
    private void m26691a() {
        this.f34983a.setTextSize(19.0f);
        this.f34987e.setItemBgSelector(R.drawable.one_payment_base_common_item_bg_selector);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        if (marginLayoutParams != null) {
            int dip2px = UIUtils.dip2px(this.f34989g, 18.0f);
            marginLayoutParams.rightMargin = dip2px;
            marginLayoutParams.leftMargin = dip2px;
            marginLayoutParams.setMarginStart(dip2px);
            marginLayoutParams.setMarginEnd(dip2px);
            setLayoutParams(marginLayoutParams);
        }
        this.f34986d.setBackgroundColor(-1);
    }

    /* renamed from: b */
    private void m26694b() {
        this.f34987e.setItemBgSelector(R.drawable.wallet_global_home_pay_method_item_bg_selector);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = UIUtils.dip2px(this.f34989g, 18.0f);
            marginLayoutParams.leftMargin = UIUtils.dip2px(this.f34989g, 18.0f);
            setLayoutParams(marginLayoutParams);
        }
        this.f34986d.setBackgroundColor(ResourcesHelper.getColor(this.f34989g, R.color.wallet_color_F8F9FA));
    }

    public void updateContent(final WalletNewPayMethodListContract.Model model) {
        int i = 8;
        if (model == null) {
            setVisibility(8);
            return;
        }
        this.f34983a.setVisibility(TextUtils.isEmpty(model.title) ? 8 : 0);
        this.f34983a.setText(model.title);
        if (TextUtils.isEmpty(model.transEntrance)) {
            this.f34988f.setVisibility(8);
        } else {
            this.f34988f.setVisibility(0);
            this.f34988f.setText(model.transEntrance);
        }
        TextView textView = this.f34985c;
        if (!TextUtils.isEmpty(model.topTips)) {
            i = 0;
        }
        textView.setVisibility(i);
        this.f34985c.setText(model.topTips);
        if (model.topTipsTextColor != 0) {
            this.f34985c.setTextColor(ResUtils.getColor(model.topTipsTextColor));
        }
        if (model.topTipsBgColor != 0) {
            this.f34985c.setBackgroundResource(model.topTipsBgColor);
        }
        if (!TextUtils.isEmpty(model.faqLink)) {
            this.f34985c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebBrowserUtil.startInternalWebActivity(WalletNewPayMethodListView.this.f34989g, model.faqLink, "");
                }
            });
        }
        if (!TextUtils.isEmpty(model.entranceLink)) {
            this.f34988f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletWebActivity.launch(WalletNewPayMethodListView.this.f34989g, "", model.entranceLink);
                }
            });
        }
        this.f34987e.setData(model.items);
    }

    public void setListener(WalletNewPayMethodListContract.Listener listener) {
        this.f34990h = listener;
    }

    private static class ItemDivider extends DividerItemDecoration {
        private final Rect mBounds = new Rect();
        private Drawable mDivider;
        private int mInnerPaddingLeft;

        public ItemDivider(Context context, int i) {
            super(context, i);
            this.mInnerPaddingLeft = UIUtils.dip2px(context, 54.0f);
        }

        public void setDrawable(Drawable drawable) {
            super.setDrawable(drawable);
            this.mDivider = drawable;
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int i;
            int i2;
            if (recyclerView.getLayoutManager() != null && this.mDivider != null) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i = recyclerView.getPaddingLeft();
                    i2 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    i2 = recyclerView.getWidth();
                    i = 0;
                }
                int childCount = recyclerView.getChildCount();
                for (int i3 = 0; i3 < childCount - 1; i3++) {
                    View childAt = recyclerView.getChildAt(i3);
                    recyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
                    int round = this.mBounds.bottom + Math.round(childAt.getTranslationY());
                    this.mDivider.setBounds(getPaddingLeftByPosition(i3, childCount) + i, round - this.mDivider.getIntrinsicHeight(), i2, round);
                    this.mDivider.draw(canvas);
                }
                canvas.restore();
            }
        }

        private int getPaddingLeftByPosition(int i, int i2) {
            if (i == i2 - 2) {
                return 0;
            }
            return this.mInnerPaddingLeft;
        }
    }
}
