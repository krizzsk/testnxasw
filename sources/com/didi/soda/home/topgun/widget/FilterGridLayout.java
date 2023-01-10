package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.gridlayout.widget.GridLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.model.FilterUIModel;
import com.didi.soda.home.topgun.widget.FilterGridLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class FilterGridLayout extends GridLayout {

    /* renamed from: a */
    private OnClickFilterItemListener f45562a;

    /* renamed from: b */
    private int f45563b;

    /* renamed from: c */
    private Context f45564c;

    /* renamed from: d */
    private List<GridItem> f45565d = new ArrayList();

    public interface OnClickFilterItemListener {
        void onItemSelectChanged(FilterModel.FilterItemRvModel filterItemRvModel, boolean z);
    }

    interface SelectedChangeListener {
        void onItemSelectedChanged(GridItem gridItem);
    }

    public FilterGridLayout(Context context) {
        super(context);
        m33846a(context);
    }

    public FilterGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33846a(context);
    }

    public FilterGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33846a(context);
    }

    public void setOnClickFilterItemListener(OnClickFilterItemListener onClickFilterItemListener) {
        this.f45562a = onClickFilterItemListener;
    }

    public void setFilterItem(List<FilterModel.FilterItemRvModel> list) {
        GridLayout.LayoutParams layoutParams;
        this.f45565d.clear();
        removeAllViews();
        int columnCount = getColumnCount();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            GridItem a = m33845a(list.get(i));
            this.f45565d.add(a);
            int i2 = i / columnCount;
            int i3 = i % columnCount;
            if (size >= columnCount) {
                layoutParams = new GridLayout.LayoutParams(GridLayout.spec(i2, 1.0f), GridLayout.spec(i3, 1.0f));
                layoutParams.width = 0;
            } else {
                layoutParams = new GridLayout.LayoutParams(GridLayout.spec(i2), GridLayout.spec(i3));
                layoutParams.width = (this.f45563b - (DisplayUtils.dip2px(this.f45564c, 40.0f) + DisplayUtils.dip2px(this.f45564c, (float) ((columnCount - 1) * 9)))) / columnCount;
            }
            layoutParams.height = DisplayUtils.dip2px(getContext(), 36.0f);
            if (i2 > 0) {
                layoutParams.topMargin = DisplayUtils.dip2px(getContext(), 12.0f);
            }
            if (i3 > 0) {
                layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 10.0f);
            }
            addView(a.itemView, layoutParams);
        }
    }

    public List<GridItem> getUIItemList() {
        return this.f45565d;
    }

    public void confirm() {
        for (GridItem next : this.f45565d) {
            next.getItemRvModel().mIsSelected = next.isSelected();
        }
    }

    public void reset() {
        for (GridItem next : this.f45565d) {
            next.setViewSelected(next.getItemRvModel().mIsDefault);
        }
    }

    /* renamed from: a */
    private GridItem m33845a(FilterModel.FilterItemRvModel filterItemRvModel) {
        return new GridItem(this, filterItemRvModel, new SelectedChangeListener() {
            public final void onItemSelectedChanged(FilterGridLayout.GridItem gridItem) {
                FilterGridLayout.this.m33848b(gridItem);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33848b(GridItem gridItem) {
        for (GridItem next : this.f45565d) {
            if (next != gridItem) {
                if (!gridItem.isMultipleChoice()) {
                    next.setViewSelected(false);
                } else if (!next.isMultipleChoice()) {
                    next.setViewSelected(false);
                }
            }
        }
        OnClickFilterItemListener onClickFilterItemListener = this.f45562a;
        if (onClickFilterItemListener != null) {
            onClickFilterItemListener.onItemSelectChanged(gridItem.getItemRvModel(), gridItem.isSelected());
        }
    }

    /* renamed from: a */
    private void m33846a(Context context) {
        this.f45564c = context;
        this.f45563b = CustomerSystemUtil.getScreenWidth(context);
    }

    public static class GridItem extends FilterUIModel {
        ImageView imageView = ((ImageView) this.itemView.findViewById(R.id.customer_tv_home_filter_grid_item_image));
        View itemView;
        TextView textView;

        GridItem(ViewGroup viewGroup, FilterModel.FilterItemRvModel filterItemRvModel, SelectedChangeListener selectedChangeListener) {
            setItemRvModel(filterItemRvModel);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_home_filter_multiple_grid, viewGroup, false);
            this.itemView = inflate;
            this.textView = (TextView) inflate.findViewById(R.id.customer_tv_home_filter_grid_item);
            this.textView.setText(filterItemRvModel.mName);
            ViewCompat.setElevation(this.textView, (float) DisplayUtils.dip2px(viewGroup.getContext(), 0.5f));
            setMultipleChoice(filterItemRvModel.mIsMultipleChoice);
            setViewSelected(filterItemRvModel.mIsSelected);
            updateImg(isSelected(), filterItemRvModel);
            this.itemView.setOnClickListener(new View.OnClickListener(selectedChangeListener) {
                public final /* synthetic */ FilterGridLayout.SelectedChangeListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    FilterGridLayout.GridItem.this.lambda$new$0$FilterGridLayout$GridItem(this.f$1, view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$FilterGridLayout$GridItem(SelectedChangeListener selectedChangeListener, View view) {
            setViewSelected(!isSelected());
            selectedChangeListener.onItemSelectedChanged(this);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0055  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void updateImg(boolean r2, com.didi.soda.home.topgun.model.FilterModel.FilterItemRvModel r3) {
            /*
                r1 = this;
                if (r3 == 0) goto L_0x005c
                if (r2 == 0) goto L_0x000f
                java.lang.String r2 = r3.mSelectedImg
                boolean r2 = com.didi.soda.customer.foundation.util.StringUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x001a
                java.lang.String r2 = r3.mSelectedImg
                goto L_0x001c
            L_0x000f:
                java.lang.String r2 = r3.mImg
                boolean r2 = com.didi.soda.customer.foundation.util.StringUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x001a
                java.lang.String r2 = r3.mImg
                goto L_0x001c
            L_0x001a:
                java.lang.String r2 = ""
            L_0x001c:
                boolean r3 = android.text.TextUtils.isEmpty(r2)
                if (r3 != 0) goto L_0x0055
                android.widget.ImageView r3 = r1.imageView
                r0 = 0
                r3.setVisibility(r0)
                android.widget.ImageView r3 = r1.imageView
                java.lang.Object r3 = r3.getTag()
                java.lang.String r3 = java.lang.String.valueOf(r3)
                boolean r3 = android.text.TextUtils.equals(r2, r3)
                if (r3 != 0) goto L_0x005c
                android.view.View r3 = r1.itemView
                android.content.Context r3 = r3.getContext()
                com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r3 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImage1x1((android.content.Context) r3, (java.lang.String) r2)
                com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r3 = r3.fitCenter()
                com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r3 = r3.dontAnimate()
                android.widget.ImageView r0 = r1.imageView
                r3.into((android.widget.ImageView) r0)
                android.widget.ImageView r3 = r1.imageView
                r3.setTag(r2)
                goto L_0x005c
            L_0x0055:
                android.widget.ImageView r2 = r1.imageView
                r3 = 8
                r2.setVisibility(r3)
            L_0x005c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.FilterGridLayout.GridItem.updateImg(boolean, com.didi.soda.home.topgun.model.FilterModel$FilterItemRvModel):void");
        }

        /* access modifiers changed from: package-private */
        public void setViewSelected(boolean z) {
            setSelected(z);
            this.itemView.setSelected(z);
            updateImg(z, getItemRvModel());
            if (z) {
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.textView, IToolsService.FontType.BOLD);
            } else {
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.textView, IToolsService.FontType.MEDIUM);
            }
        }
    }
}
