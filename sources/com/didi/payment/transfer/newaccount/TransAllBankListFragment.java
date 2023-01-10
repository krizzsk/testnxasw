package com.didi.payment.transfer.newaccount;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.commonsdk.view.adapter.TransBankListAdapter;
import com.didi.payment.transfer.common.IPresenter;
import com.didi.payment.transfer.common.TransBaseFragment;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransAllBankListFragment extends TransBaseFragment {

    /* renamed from: a */
    private TransBankListAdapter f33947a;

    /* renamed from: b */
    private List<String> f33948b;

    /* renamed from: c */
    private RecyclerView f33949c;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_bank_list_fragment_lay;
    }

    /* access modifiers changed from: protected */
    public IPresenter onCreatePresenter() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f33948b = Arrays.asList(getArguments().getStringArray("bank_list_inarray"));
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    /* access modifiers changed from: protected */
    public void initViews(View view) {
        super.initViews(view);
        this.f33949c = (RecyclerView) view.findViewById(R.id.trans_bank_list_options_lv);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        dividerItemDecoration.setDrawable(new ColorDrawable(Color.parseColor("#1f000000")));
        this.f33949c.addItemDecoration(dividerItemDecoration);
        TransBankListAdapter transBankListAdapter = new TransBankListAdapter(getActivity(), new ArrayList());
        this.f33947a = transBankListAdapter;
        transBankListAdapter.setOnItemclickListener(new TransBankListAdapter.OnItemClickListener() {
            public void onItemClick(String str) {
                PayEventPublisher.getPublisher().publish("selected_bank_data", str);
                TransAllBankListFragment.this.getActivity().onBackPressed();
            }
        });
        this.f33949c.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f33949c.setAdapter(this.f33947a);
        this.f33947a.updateData(this.f33948b);
    }
}
