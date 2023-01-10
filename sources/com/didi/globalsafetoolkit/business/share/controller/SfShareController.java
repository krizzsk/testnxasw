package com.didi.globalsafetoolkit.business.share.controller;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.apollo.SfApolloUtil;
import com.didi.globalsafetoolkit.business.share.SfIContactsView;
import com.didi.globalsafetoolkit.business.share.model.SfShareResponse;
import com.didi.globalsafetoolkit.model.SfContactsModel;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.util.SfCollectionUtil;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.globalsafetoolkit.util.SfLog;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

public class SfShareController extends SfBaseController {
    private TextView mGoSettingBtn;
    private View mGotoSettingDivider;
    private View mGotoSettingLayout;
    protected boolean mRefused = false;
    private View mShareBottomLayout;
    private TextView mShareBtn;

    public SfShareController(SfIContactsView sfIContactsView) {
        super(sfIContactsView);
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        super.findViews();
        this.mShareBottomLayout = ((SfIContactsView) this.mView).findViewByIdImpl(R.id.share_bottom_layout);
        this.mShareBtn = (TextView) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.share_bottom_btn);
        this.mGotoSettingLayout = ((SfIContactsView) this.mView).findViewByIdImpl(R.id.go_setting_layout);
        this.mGotoSettingDivider = ((SfIContactsView) this.mView).findViewByIdImpl(R.id.go_setting_top_divider);
        ((TextView) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.go_setting_content)).setText(SfStringGetter.getString(R.string.sf_setting_contact_permissions));
        TextView textView = (TextView) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.go_setting_btn);
        this.mGoSettingBtn = textView;
        textView.setText(SfStringGetter.getString(R.string.sf_setting));
        this.mGoSettingBtn.getPaint().setFlags(8);
        this.mTitleBar.setTitleText(SfStringGetter.getString(R.string.sf_select_contacts));
        setClickListener();
    }

    private void setClickListener() {
        C95391 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.share_bottom_btn) {
                    SfShareController.this.SMSShare();
                } else if (view.getId() == R.id.go_setting_btn) {
                    SfShareController.this.gotoSystemPermissionPage();
                } else if (view.getId() == R.id.sf_right_btn) {
                    SfShareController.this.socialShare();
                }
            }
        };
        this.mShareBtn.setOnClickListener(r0);
        this.mGoSettingBtn.setOnClickListener(r0);
        this.mTitleBar.setRightBtnClickListener(r0);
        if (SfApolloUtil.isApolloNewShare()) {
            this.mTitleBar.setRightBtnVisible(8);
        } else {
            this.mTitleBar.setRightBtnSrc(R.drawable.sf_share_btn);
        }
    }

    /* access modifiers changed from: private */
    public void socialShare() {
        GlobalSfBusinessInterface.startSocialShare(false);
        ((SfIContactsView) this.mView).finish();
    }

    /* access modifiers changed from: private */
    public void SMSShare() {
        ((SfIContactsView) this.mView).showLoading();
        this.mStore.share(this.selectList, ((SfIContactsView) this.mView).getOrderId(), new SfResponseListener<SfShareResponse>() {
            public void onSuccess(SfShareResponse sfShareResponse) {
                ((SfIContactsView) SfShareController.this.mView).stopLoading();
                if (sfShareResponse.data != null) {
                    if (sfShareResponse.data.shareSuccessCount != 0) {
                        GlobalSfBusinessInterface.onContactsShared();
                        ((Activity) ((SfIContactsView) SfShareController.this.mView).getContext()).finish();
                    }
                    if (!TextUtils.isEmpty(sfShareResponse.data.successText)) {
                        ToastHelper.showLongCompleted(SfContextHelper.getContext(), sfShareResponse.data.successText);
                    }
                }
            }

            public void onFail(int i, String str) {
                ((SfIContactsView) SfShareController.this.mView).stopLoading();
                SfLog.m20146e(str);
                ToastHelper.showLongCompleted(SfContextHelper.getContext(), str);
            }

            public void onError(SfShareResponse sfShareResponse) {
                ((SfIContactsView) SfShareController.this.mView).stopLoading();
                if (sfShareResponse != null) {
                    SfLog.m20146e(sfShareResponse.errmsg);
                    ToastHelper.showLongCompleted(SfContextHelper.getContext(), sfShareResponse.errmsg);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void getDataList() {
        this.mStore.getSystemContacts(this.mCallback);
        this.mStore.getSOSContacts(this.mCallback);
    }

    /* access modifiers changed from: protected */
    public void onPermissionRefused(boolean z) {
        this.mRefused = true;
        this.mStore.getSOSContacts(this.mCallback);
    }

    /* access modifiers changed from: protected */
    public void onPermissionGranted() {
        this.mRefused = false;
        updateGotoSettingView(false);
    }

    /* access modifiers changed from: protected */
    public void onDataLoaded(List<SfContactsModel> list) {
        if (this.mRefused) {
            if (SfCollectionUtil.isEmpty((Collection) list)) {
                updateGotoSettingView(false);
                showNoPermissionPage(this.mIsRemember);
                return;
            }
            updateGotoSettingView(true);
        }
    }

    private void updateGotoSettingView(boolean z) {
        if (z) {
            this.mGotoSettingLayout.setVisibility(0);
            this.mGotoSettingDivider.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRecyclerView.getLayoutParams();
            layoutParams.weight = 0.0f;
            layoutParams.height = -2;
            this.mRecyclerView.setLayoutParams(layoutParams);
        } else if (this.mGotoSettingLayout.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mRecyclerView.getLayoutParams();
            layoutParams2.weight = 1.0f;
            layoutParams2.height = 0;
            this.mRecyclerView.setLayoutParams(layoutParams2);
            this.mGotoSettingLayout.setVisibility(8);
            this.mGotoSettingDivider.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onSelectDateChanged(int i) {
        if (i > 0) {
            this.mShareBottomLayout.setVisibility(0);
            this.mShareBtn.setText(String.format(SfStringGetter.getString(R.string.sf_share_btn_text), new Object[]{Integer.valueOf(i)}));
            return;
        }
        this.mShareBottomLayout.setVisibility(8);
    }
}
