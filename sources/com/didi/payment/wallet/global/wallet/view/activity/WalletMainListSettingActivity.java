package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.utils.PayBaseConfigUtil;
import com.didi.payment.base.web.WalletDiminaUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.basemodel.helper.AccountFreezeConfirmDialogHelper;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletCommonContract;
import com.didi.payment.wallet.global.wallet.contract.WalletMainListSettingContract;
import com.didi.payment.wallet.global.wallet.entity.WalletSettingPageInfo;
import com.didi.payment.wallet.global.wallet.presenter.WalletMainListSettingPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletMainListSettingListAdapter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.unifiedPay.util.UIUtils;
import com.didiglobal.pay.paysecure.tmx.ITMXHost;
import com.taxis99.R;
import java.io.Serializable;
import java.util.List;

public class WalletMainListSettingActivity extends WalletBaseActivity implements View.OnClickListener, WalletMainListSettingContract.View, ITMXHost {
    public static final int REQ_CODE_FAST_PAY_SETTING = 10001;

    /* renamed from: a */
    WalletSettingPageInfo f34687a = null;

    /* renamed from: b */
    private ImageView f34688b;

    /* renamed from: c */
    private RecyclerView f34689c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WalletMainListSettingListAdapter f34690d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WalletMainListSettingContract.Presenter f34691e;

    public void initLoadingDialog(Activity activity) {
    }

    public void releaseLoadingDialog() {
    }

    public void setListener(WalletCommonContract.NullListener nullListener) {
    }

    public static void startActivity(Context context, WalletSettingPageInfo walletSettingPageInfo) {
        Intent intent = new Intent(context, WalletMainListSettingActivity.class);
        intent.putExtra(WalletExtraConstant.Key.WALLET_SIDEBAR_PAGE_MODEL, walletSettingPageInfo);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_mainlist_setting);
        m26510a(getIntent());
        m26509a();
        WalletMainListSettingPresenter walletMainListSettingPresenter = new WalletMainListSettingPresenter(this, this);
        this.f34691e = walletMainListSettingPresenter;
        walletMainListSettingPresenter.init();
        m26512b();
    }

    /* renamed from: a */
    private void m26510a(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra(WalletExtraConstant.Key.WALLET_SIDEBAR_PAGE_MODEL);
        if (serializableExtra instanceof WalletSettingPageInfo) {
            this.f34687a = (WalletSettingPageInfo) serializableExtra;
        }
    }

    /* renamed from: a */
    private void m26509a() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_left);
        this.f34688b = imageView;
        imageView.setOnClickListener(this);
        this.f34689c = (RecyclerView) findViewById(R.id.rv_mainlist_setting_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.f34689c.setLayoutManager(linearLayoutManager);
        this.f34689c.setItemAnimator(new DefaultItemAnimator());
        ItemDivider itemDivider = new ItemDivider(this, 1);
        itemDivider.setDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_balance_history_list_divider));
        this.f34689c.addItemDecoration(itemDivider);
        WalletMainListSettingListAdapter walletMainListSettingListAdapter = new WalletMainListSettingListAdapter(this);
        this.f34690d = walletMainListSettingListAdapter;
        walletMainListSettingListAdapter.setCallback(new WalletMainListSettingListAdapter.Callback() {
            public void onSettingItemClicked(int i, String str, WalletMainListSettingContract.SettingItemModel settingItemModel) {
                if (i == 2 && WalletMainListSettingActivity.this.f34687a != null && WalletMainListSettingActivity.this.f34687a.freezonData != null && WalletMainListSettingActivity.this.f34687a.freezonData.isFrozen()) {
                    if (AccountFreezeConfirmDialogHelper.showAccountFrozenConfirmDialog2(WalletMainListSettingActivity.this, (AccountFreezeData) AccountFreezeData.Builder.from(WalletMainListSettingActivity.this.f34687a.freezonData).btnPos(ResourcesHelper.getString(WalletMainListSettingActivity.this, R.string.GRider_Unfreeze_Details_cscc)).btnNeg(ResourcesHelper.getString(WalletMainListSettingActivity.this, R.string.GRider_Unfreeze_Confirmation_bqam)).putExtra("entrance", -1).build())) {
                        return;
                    }
                }
                WalletSPUtils.setIsShowSettingRedDot(WalletMainListSettingActivity.this.getContext(), settingItemModel.type, true);
                if (WalletMainListSettingActivity.this.f34690d != null) {
                    WalletMainListSettingActivity.this.f34690d.refreshRedDot(settingItemModel.type);
                }
                WalletMainListSettingActivity.this.f34691e.onSettingItemClicked(i, str, settingItemModel.subSetting);
            }
        });
        this.f34689c.setAdapter(this.f34690d);
        initLoadingDialog(this, R.id.layout_title_bar);
    }

    /* renamed from: b */
    private void m26512b() {
        if (PayBaseConfigUtil.isDebugMode()) {
            View findViewById = findViewById(R.id.tv_diminaDebug);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletDiminaUtil.INSTANCE.openDebugModel();
                }
            });
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.iv_left) {
            finish();
        }
    }

    public void updateContent(List<WalletMainListSettingContract.SettingItemModel> list) {
        WalletMainListSettingListAdapter walletMainListSettingListAdapter = this.f34690d;
        if (walletMainListSettingListAdapter != null) {
            walletMainListSettingListAdapter.setData(list);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 4) {
            if (i != 10001) {
                return;
            }
        } else if (i2 == -1) {
            finish();
        }
        if (i2 == -1) {
            this.f34691e.requestData();
        }
    }

    public void onUpdate(WalletSettingPageInfo walletSettingPageInfo) {
        this.f34687a = walletSettingPageInfo;
    }

    protected static class ItemDivider extends DividerItemDecoration {
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
            return this.mInnerPaddingLeft;
        }
    }
}
