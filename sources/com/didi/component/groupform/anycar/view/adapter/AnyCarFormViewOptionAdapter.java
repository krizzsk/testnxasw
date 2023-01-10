package com.didi.component.groupform.anycar.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.core.IComponent;
import com.didi.component.groupform.anycar.presenter.AbsAnycarGroupFormPresenter;
import com.didi.drouter.api.DRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnyCarFormViewOptionAdapter extends RecyclerView.Adapter {
    public static int RECYCLER_VIEW_SINGLE_COL_SPANS = 2;
    public static final int RECYCLER_VIEW_SPAN_COUNT = 6;
    public static final int VIEW_TYPE_COMPANY = 6;
    public static final int VIEW_TYPE_DISPATCH_FEE = 5;
    public static final int VIEW_TYPE_OPTIONS = 3;
    public static final int VIEW_TYPE_PAYWAY = 1;
    public static final int VIEW_TYPE_SEAT_COUNT = 4;
    public static final int VIEW_TYPE_SUBSTITUTE_CALL = 7;
    public static final int VIEW_TYPE_TIME_PICKER = 2;

    /* renamed from: a */
    private AbsAnycarGroupFormPresenter f15882a;

    /* renamed from: b */
    private List<Integer> f15883b = new ArrayList();

    /* renamed from: c */
    private HashMap<Integer, IComponent> f15884c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f15885d;

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 7) {
            return null;
        }
        IComponent inflateComponent = this.f15882a.inflateComponent(ComponentType.ANYCAR_FORM_COMMON_ITEM, viewGroup);
        this.f15884c.put(Integer.valueOf(i), inflateComponent);
        View view = inflateComponent.getView().getView();
        view.setOnClickListener(new OnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                DRouter.build(AnyCarFormViewOptionAdapter.this.f15885d).start();
            }
        });
        return new SubstituteCallViewHolder(view);
    }

    public int getItemCount() {
        return this.f15883b.size();
    }

    public int getItemViewType(int i) {
        return this.f15883b.get(i).intValue();
    }

    public void setPresenter(AbsAnycarGroupFormPresenter absAnycarGroupFormPresenter) {
        this.f15882a = absAnycarGroupFormPresenter;
    }

    public void setModelList(List<Integer> list) {
        this.f15883b = list;
    }

    public int getModelListSize() {
        List<Integer> list = this.f15883b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.f15882a != null) {
            for (IComponent removeComponent : this.f15884c.values()) {
                this.f15882a.removeComponent(removeComponent);
            }
        }
    }

    public void setSubstituteCallScheme(String str) {
        this.f15885d = str;
    }
}
