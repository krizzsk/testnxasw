package com.didi.globalsafetoolkit.business.contacts.viewhoder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.globalsafetoolkit.model.SfContactsModel;

public abstract class SfBaseVH extends RecyclerView.ViewHolder {
    public abstract void setData(SfContactsModel sfContactsModel);

    public SfBaseVH(View view) {
        super(view);
    }
}
