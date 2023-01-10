package com.didi.dimina.starbox.module.jsbridge.bridgelog;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.messager.MessageHandler;
import com.didi.dimina.starbox.module.jsbridge.bridgelog.CheckBoxItemAdapter;
import com.didi.dimina.starbox.p108ui.base.BaseFragment;
import com.taxis99.R;

public class NativeBridgeSettingFragment extends BaseFragment {

    /* renamed from: a */
    private RecyclerView f19925a;

    /* renamed from: b */
    private CheckBoxItemAdapter f19926b;

    /* access modifiers changed from: protected */
    public int onRequestLayout() {
        return R.layout.dimina_starbox_fragment_log_info_setting;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m16909a();
    }

    /* renamed from: a */
    private void m16909a() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.setting_list);
        this.f19925a = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f19926b = new CheckBoxItemAdapter(getContext());
        boolean booleanValue = ((Boolean) MMKVUtil.getInstance().get(MessageHandler.PARAM_ENABLE_ALL_BRIDGE_LISTENER, false)).booleanValue();
        this.f19926b.append(new CheckBoxItem(R.string.dm_kit_engine_first_dom_ready_native_bridge_log_info, ((Boolean) MMKVUtil.getInstance().get(MessageHandler.PARAM_ENABLE_FIRST_DOM_READY_BRIDGE_LISTENER, false)).booleanValue()));
        this.f19926b.append(new CheckBoxItem(R.string.dm_kit_engine_all_native_bridge_log_info, booleanValue));
        this.f19926b.setOnCheckBoxItemSwitchListener(new CheckBoxItemAdapter.OnCheckBoxItemSwitchListener() {
            public void onSettingItemSwitch(CheckBoxItem checkBoxItem, boolean z) {
                if (checkBoxItem.desc == R.string.dm_kit_engine_all_native_bridge_log_info) {
                    MMKVUtil.getInstance().save(MessageHandler.PARAM_ENABLE_ALL_BRIDGE_LISTENER, Boolean.valueOf(z));
                    MessageHandler.sEnableAllBridgeListener = true;
                }
                if (checkBoxItem.desc == R.string.dm_kit_engine_first_dom_ready_native_bridge_log_info) {
                    MMKVUtil.getInstance().save(MessageHandler.PARAM_ENABLE_FIRST_DOM_READY_BRIDGE_LISTENER, Boolean.valueOf(z));
                    MessageHandler.sEnableFirstDomReadyBridgeListener = true;
                }
            }
        });
        this.f19925a.setAdapter(this.f19926b);
        this.f19926b.notifyDataSetChanged();
    }
}
