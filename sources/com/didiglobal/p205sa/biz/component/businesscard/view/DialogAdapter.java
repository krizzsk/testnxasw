package com.didiglobal.p205sa.biz.component.businesscard.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.p205sa.biz.component.businesscard.model.BusinessCardModel;
import com.didiglobal.p205sa.biz.component.businesscard.viewholder.BaseViewHolder;
import com.didiglobal.p205sa.biz.component.businesscard.viewholder.BusinessViewHolder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.businesscard.view.DialogAdapter */
public class DialogAdapter extends RecyclerView.Adapter {

    /* renamed from: b */
    private static final int f53350b = 1;

    /* renamed from: a */
    private Logger f53351a = LoggerFactory.getLogger("DialogAdapter");
    public List<BusinessCardModel.BusinessMenuModel> businessMenu = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnItemClickListener f53352c;

    /* renamed from: com.didiglobal.sa.biz.component.businesscard.view.DialogAdapter$OnItemClickListener */
    public interface OnItemClickListener {
        void onItemClick(int i, BusinessCardModel.BusinessMenuModel businessMenuModel);
    }

    public int getItemViewType(int i) {
        return 1;
    }

    /* renamed from: a */
    private void m39901a(String str) {
        this.f53351a.info(str, new Object[0]);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new BusinessViewHolder(viewGroup);
        }
        return new BusinessViewHolder(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        final BusinessCardModel.BusinessMenuModel a = m39899a(i);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DialogAdapter.this.f53352c != null) {
                    DialogAdapter.this.f53352c.onItemClick(i, a);
                }
            }
        });
        ((BaseViewHolder) viewHolder).setData(a);
    }

    public int getItemCount() {
        List<BusinessCardModel.BusinessMenuModel> list = this.businessMenu;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: a */
    private BusinessCardModel.BusinessMenuModel m39899a(int i) {
        List<BusinessCardModel.BusinessMenuModel> list = this.businessMenu;
        if (list != null && list.size() >= i) {
            return this.businessMenu.get(i);
        }
        m39901a("getdata exception " + i);
        return null;
    }

    public void setData(List<BusinessCardModel.BusinessMenuModel> list) {
        if (list != null && !list.isEmpty()) {
            this.businessMenu.clear();
            this.businessMenu.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f53352c = onItemClickListener;
    }
}
