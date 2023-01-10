package com.didiglobal.p205sa.biz.component.sapanel;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ISAPanel;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import com.didiglobal.p205sa.biz.component.sapanel.view.SAPanelRecView;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.SAPanelProxy */
public class SAPanelProxy implements ISAPanel {

    /* renamed from: a */
    private Context f53634a;

    /* renamed from: b */
    private SAPanelRecView f53635b;

    public SAPanelProxy(Activity activity) {
        this.f53634a = activity;
        this.f53635b = new SAPanelRecView(activity);
    }

    public void setData(List<SACardProperty> list) {
        this.f53635b.setData(list);
    }

    public void addCard(SACardProperty sACardProperty, int i) {
        this.f53635b.addCard(sACardProperty, i);
    }

    public RecyclerView getContainer() {
        return this.f53635b.getContainer();
    }

    public void removeCard(int i) {
        this.f53635b.removeCard(i);
    }

    public void updateCard(SACardProperty sACardProperty) {
        this.f53635b.updateCard(sACardProperty);
    }

    public View getView() {
        return this.f53635b.getView();
    }

    public void resumePageSize() {
        this.f53635b.resumePageSize();
    }

    public void expandPage() {
        this.f53635b.expandPage();
    }

    public void scrollTop(int i) {
        this.f53635b.scrollTop(i);
    }
}
