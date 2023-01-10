package com.didi.safetoolkit.business.toolkit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.fragment.BaseDialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.apollo.SfApolloUtil;
import com.didi.safetoolkit.business.emergency.SfEmergencyNumHelper;
import com.didi.safetoolkit.business.toolkit.ISfToolkitContract;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import com.didi.safetoolkit.business.toolkit.view.SfViewAdapter;
import com.didi.safetoolkit.business.triprecording.DurationListener;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SfToolkitDialog extends BaseDialogFragment implements ISfToolkitContract.ToolkitView {

    /* renamed from: a */
    private View f37219a;

    /* renamed from: b */
    private View f37220b;

    /* renamed from: c */
    private TextView f37221c;

    /* renamed from: d */
    private RecyclerView f37222d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SfViewAdapter f37223e;

    /* renamed from: f */
    private List<SfViewMenuModel> f37224f;

    /* renamed from: g */
    private boolean f37225g = true;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SfToolkitPresenter f37226h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f37227i;

    /* renamed from: j */
    private DurationListener f37228j = new DurationListener() {
        public void onCallback(String str) {
            if (SfToolkitDialog.this.f37223e != null) {
                SfToolkitDialog.this.f37223e.notifyRecordTimeChanged(str);
            }
        }
    };

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.sf_toolkit_dialog_layout;
    }

    public void setShareEnable(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f37225g = bundle.getBoolean("isShareCanUse", true);
            this.f37227i = bundle.getString("orderId", "");
            this.f37224f = (ArrayList) bundle.getSerializable("menuList");
        }
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f37219a = findViewById(R.id.sf_toolkit_dialog_share_btn);
        this.f37220b = findViewById(R.id.sf_toolkit_dialog_alert_btn);
        this.f37221c = (TextView) findViewById(R.id.sf_toolkit_dialog_alert_btn_text);
        this.f37222d = (RecyclerView) findViewById(R.id.sf_toolkit_dialog_recycler_view);
        SfViewAdapter sfViewAdapter = new SfViewAdapter();
        this.f37223e = sfViewAdapter;
        sfViewAdapter.setData(this.f37224f);
        this.f37222d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f37222d.setAdapter(this.f37223e);
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        this.f37226h = new SfToolkitPresenter(this);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        setDialogSizePercent(1.0f);
        setDialogGravity(80);
        this.f37219a.setEnabled(this.f37225g);
        this.f37221c.setText(SfStringGetter.getString(R.string.sf_toolkit_dialog_alert_btn_text, SfEmergencyNumHelper.getEmergencyCallNum()));
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f37219a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean isApolloNewShare = SfApolloUtil.isApolloNewShare();
                SfToolkitDialog.this.f37226h.onShareClick(isApolloNewShare);
                if (isApolloNewShare) {
                    SfToolkitDialog.this.dismiss();
                }
            }
        });
        this.f37220b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfToolkitDialog.this.f37226h.onAlertClick();
            }
        });
        this.f37223e.setCardClickListener(new SfViewAdapter.CardClickListener() {
            public void onClick(SfViewMenuModel sfViewMenuModel) {
                if (sfViewMenuModel == null) {
                    return;
                }
                if ("safety_center".equals(sfViewMenuModel.type)) {
                    SfToolkitDialog.this.f37226h.onSafeCenterClick();
                } else if ("recode_voice".equals(sfViewMenuModel.type)) {
                    SfToolkitDialog.this.f37226h.onAudioRecordClick(SfToolkitDialog.this.f37227i, (SfViewRecordMenuModel) sfViewMenuModel);
                } else if ("monitor".equals(sfViewMenuModel.type)) {
                    SfToolkitDialog.this.f37226h.onMonitorClick((SfViewMonitorMenuModel) sfViewMenuModel);
                }
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TripRecordingManager.Companion.getInstance().setDurationListener(this.f37228j);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        TripRecordingManager.Companion.getInstance().removeDurationListener(this.f37228j);
    }

    public void updateSfViewMenuModelList(List<SfViewMenuModel> list) {
        this.f37224f = list;
        SfViewAdapter sfViewAdapter = this.f37223e;
        if (sfViewAdapter != null) {
            sfViewAdapter.setData(list);
            this.f37223e.notifyDataSetChanged();
        }
    }
}
