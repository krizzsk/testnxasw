package com.didi.dimina.starbox.module.jsbridge.bridgelog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.starbox.p108ui.base.AbsViewBinder;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CheckBoxItemAdapter extends RecyclerView.Adapter<AbsViewBinder<CheckBoxItem>> {

    /* renamed from: b */
    private static final String f19920b = "AbsRecyclerAdapter";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnCheckBoxItemSwitchListener f19921a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<CheckBoxItem> f19922c;

    /* renamed from: d */
    private LayoutInflater f19923d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Handler f19924e = new Handler(Looper.getMainLooper());

    public interface OnCheckBoxItemSwitchListener {
        void onSettingItemSwitch(CheckBoxItem checkBoxItem, boolean z);
    }

    public CheckBoxItemAdapter(Context context) {
        if (context == null) {
            LogUtil.m16840e(f19920b, "Context should not be null");
            return;
        }
        this.f19922c = new ArrayList();
        this.f19923d = LayoutInflater.from(context);
    }

    public final AbsViewBinder<CheckBoxItem> onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SettingItemViewHolder(this.f19923d.inflate(R.layout.dimina_starbox_item_check_box, viewGroup, false));
    }

    public final void onBindViewHolder(AbsViewBinder<CheckBoxItem> absViewBinder, int i) {
        CheckBoxItem checkBoxItem = this.f19922c.get(i);
        absViewBinder.setData(checkBoxItem);
        absViewBinder.bind(checkBoxItem, i);
    }

    public int getItemCount() {
        return this.f19922c.size();
    }

    public void append(CheckBoxItem checkBoxItem) {
        this.f19922c.add(checkBoxItem);
    }

    public class SettingItemViewHolder extends AbsViewBinder<CheckBoxItem> {
        private TextView mDesc;
        private CheckBox mMenuSwitch;

        public SettingItemViewHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public void getViews() {
            this.mMenuSwitch = (CheckBox) getView(R.id.menu_switch);
            this.mDesc = (TextView) getView(R.id.desc);
        }

        public void bind(final CheckBoxItem checkBoxItem) {
            this.mDesc.setText(checkBoxItem.desc);
            this.mMenuSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (z) {
                        for (CheckBoxItem checkBoxItem : CheckBoxItemAdapter.this.f19922c) {
                            checkBoxItem.isChecked = checkBoxItem == checkBoxItem;
                        }
                    }
                    if (!z) {
                        for (CheckBoxItem checkBoxItem2 : CheckBoxItemAdapter.this.f19922c) {
                            if (checkBoxItem2 == checkBoxItem) {
                                checkBoxItem2.isChecked = false;
                            }
                        }
                    }
                    if (CheckBoxItemAdapter.this.f19921a != null) {
                        for (CheckBoxItem checkBoxItem3 : CheckBoxItemAdapter.this.f19922c) {
                            CheckBoxItemAdapter.this.f19921a.onSettingItemSwitch(checkBoxItem3, checkBoxItem3.isChecked);
                        }
                    }
                    CheckBoxItemAdapter.this.f19924e.post(new Runnable() {
                        public void run() {
                            CheckBoxItemAdapter.this.notifyDataSetChanged();
                        }
                    });
                }
            });
            this.mMenuSwitch.setChecked(checkBoxItem.isChecked);
        }

        /* access modifiers changed from: protected */
        public void onViewClick(View view, CheckBoxItem checkBoxItem) {
            super.onViewClick(view, checkBoxItem);
        }
    }

    public void setOnCheckBoxItemSwitchListener(OnCheckBoxItemSwitchListener onCheckBoxItemSwitchListener) {
        this.f19921a = onCheckBoxItemSwitchListener;
    }
}
