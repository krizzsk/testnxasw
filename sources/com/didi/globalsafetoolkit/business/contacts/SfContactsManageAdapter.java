package com.didi.globalsafetoolkit.business.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.globalsafetoolkit.business.contacts.viewhoder.SfContactInfoShowVH;
import com.didi.globalsafetoolkit.model.SfContactsModel;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.taxis99.R;
import java.util.List;

public class SfContactsManageAdapter extends RecyclerView.Adapter {

    /* renamed from: a */
    private static final int f24971a = 0;

    /* renamed from: b */
    private static final int f24972b = 1;

    /* renamed from: c */
    private static final int f24973c = 2;

    /* renamed from: d */
    private static final int f24974d = 5;

    /* renamed from: e */
    private List<SfContactsModel> f24975e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f24976f;

    /* renamed from: g */
    private SfContactInfoShowVH.Callback f24977g;

    public void setData(List<SfContactsModel> list) {
        this.f24975e = list;
    }

    public void setAddContactVHClickListener(View.OnClickListener onClickListener) {
        this.f24976f = onClickListener;
    }

    public void setDeleteListener(SfContactInfoShowVH.Callback callback) {
        this.f24977g = callback;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new SfContactInfoShowVH(viewGroup);
        }
        if (i == 1) {
            return new AddContactsVH(viewGroup);
        }
        if (i != 2) {
            return new SfContactInfoShowVH(viewGroup);
        }
        return new Contacts2UpLimitVH(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof SfContactInfoShowVH) {
            SfContactInfoShowVH sfContactInfoShowVH = (SfContactInfoShowVH) viewHolder;
            sfContactInfoShowVH.setData(this.f24975e.get(i));
            sfContactInfoShowVH.setCallback(this.f24977g);
        }
    }

    public int getItemViewType(int i) {
        if (i < this.f24975e.size()) {
            return 0;
        }
        if (this.f24975e.size() > 0 && this.f24975e.size() < 5) {
            return 1;
        }
        if (this.f24975e.size() == 5) {
            return 2;
        }
        return 0;
    }

    public int getItemCount() {
        List<SfContactsModel> list = this.f24975e;
        if (list == null) {
            return 0;
        }
        return list.size() + 1;
    }

    private class AddContactsVH extends RecyclerView.ViewHolder {
        public TextView addTrustedContactTv;

        private AddContactsVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_add_contacts_layout, viewGroup, false));
            TextView textView = (TextView) this.itemView.findViewById(R.id.sf_add_trusted_contact_tv);
            this.addTrustedContactTv = textView;
            textView.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_add));
            this.itemView.setOnClickListener(SfContactsManageAdapter.this.f24976f);
        }
    }

    private class Contacts2UpLimitVH extends RecyclerView.ViewHolder {
        public TextView sfContact2UpLimit;

        private Contacts2UpLimitVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_contacts_to_uplimit, viewGroup, false));
            TextView textView = (TextView) this.itemView.findViewById(R.id.sf_contact_2_up_limit);
            this.sfContact2UpLimit = textView;
            textView.setText(SfStringGetter.getString(R.string.sf_already_added_5));
        }
    }
}
