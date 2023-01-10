package com.didi.soda.home.topgun.component.filter.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.home.topgun.component.filter.panel.FilterCategoryPanel;
import com.didi.soda.home.topgun.model.FilterModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class FilterCategoryPanel extends FilterPanel {
    public static final int CATEGORY_SHOW_TYPE = 2;

    /* renamed from: a */
    private RecyclerView f45361a;

    /* renamed from: b */
    private CategoryAdapter f45362b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<FilterModel.FilterItemRvModel> f45363c = new ArrayList();

    /* renamed from: d */
    private FilterModel.FilterItemRvModel f45364d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ColorMatrixColorFilter f45365e;

    public FilterCategoryPanel(Context context) {
        super(context);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.f45365e = new ColorMatrixColorFilter(colorMatrix);
    }

    public View createRootView(Context context) {
        RecyclerView recyclerView = new RecyclerView(context);
        this.f45361a = recyclerView;
        return recyclerView;
    }

    public void bindData(FilterModel filterModel) {
        super.bindData(filterModel);
        int i = 2;
        if (filterModel.mShowType == 2) {
            FilterModel.FilterComponentModel filterComponentModel = filterModel.mFilterComponent.get(0);
            if (this.f45362b == null) {
                this.f45361a.addItemDecoration(new SpaceItemDecoration());
                if (filterComponentModel.mColNum > 0) {
                    i = filterComponentModel.mColNum;
                }
                RecyclerView recyclerView = this.f45361a;
                recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), i));
                RecyclerView recyclerView2 = this.f45361a;
                CategoryAdapter categoryAdapter = new CategoryAdapter();
                this.f45362b = categoryAdapter;
                recyclerView2.setAdapter(categoryAdapter);
                this.f45361a.setItemAnimator((RecyclerView.ItemAnimator) null);
            }
            this.f45363c.clear();
            this.f45363c.addAll(filterComponentModel.mItems);
            this.f45362b.notifyDataSetChanged();
            for (FilterModel.FilterItemRvModel next : this.f45363c) {
                if (next.mIsSelected) {
                    this.f45364d = next;
                }
                next.mIsBind = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
        super.onDetach();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33701a(FilterModel.FilterItemRvModel filterItemRvModel, int i) {
        FilterModel.FilterItemRvModel filterItemRvModel2 = this.f45364d;
        if (filterItemRvModel2 != null) {
            filterItemRvModel2.mIsSelected = false;
        }
        int indexOf = this.f45363c.indexOf(this.f45364d);
        this.f45364d = filterItemRvModel;
        filterItemRvModel.mIsSelected = true;
        this.f45362b.notifyItemChanged(i);
        this.f45362b.notifyItemChanged(indexOf);
        doConfirm(true, false);
    }

    private class CategoryAdapter extends RecyclerView.Adapter<ViewHolder> {
        private CategoryAdapter() {
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_home_filter_category, viewGroup, false));
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.bindData((FilterModel.FilterItemRvModel) FilterCategoryPanel.this.f45363c.get(i), i);
        }

        public int getItemCount() {
            return FilterCategoryPanel.this.f45363c.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mCategoryImageView;
        private TextView mCategoryNameView;

        ViewHolder(View view) {
            super(view);
            this.mCategoryNameView = (TextView) view.findViewById(R.id.customer_tv_home_filter_category_name);
            this.mCategoryImageView = (ImageView) view.findViewById(R.id.customer_tv_home_filter_category_img);
        }

        /* access modifiers changed from: package-private */
        public void bindData(FilterModel.FilterItemRvModel filterItemRvModel, int i) {
            Context context = this.itemView.getContext();
            filterItemRvModel.mIsBind = true;
            if (filterItemRvModel.mIsSelected) {
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mCategoryNameView, IToolsService.FontType.MEDIUM);
            } else {
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mCategoryNameView, IToolsService.FontType.LIGHT);
            }
            this.mCategoryNameView.setText(filterItemRvModel.mName);
            FlyImageLoader.loadImageUnspecified(context, filterItemRvModel.mImg).fitCenter().transform(new RoundedCornersTransformation(context, DisplayUtils.dip2px(context, 4.0f), 0, RoundedCornersTransformation.CornerType.BOTTOM_RIGHT, true)).into(this.mCategoryImageView);
            if (!filterItemRvModel.mIsCanChoice) {
                this.itemView.setOnClickListener((View.OnClickListener) null);
                this.mCategoryImageView.setColorFilter(FilterCategoryPanel.this.f45365e);
                this.mCategoryImageView.setAlpha(0.48f);
                this.mCategoryNameView.setEnabled(false);
            } else {
                this.mCategoryImageView.setAlpha(1.0f);
                this.mCategoryImageView.setColorFilter((ColorFilter) null);
                this.mCategoryNameView.setEnabled(true);
                this.itemView.setOnClickListener(new View.OnClickListener(filterItemRvModel, i) {
                    public final /* synthetic */ FilterModel.FilterItemRvModel f$1;
                    public final /* synthetic */ int f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        FilterCategoryPanel.ViewHolder.this.lambda$bindData$0$FilterCategoryPanel$ViewHolder(this.f$1, this.f$2, view);
                    }
                });
            }
            this.itemView.setSelected(filterItemRvModel.mIsSelected);
            if (filterItemRvModel.mIsSelected) {
                this.mCategoryNameView.setSelected(true);
            }
        }

        public /* synthetic */ void lambda$bindData$0$FilterCategoryPanel$ViewHolder(FilterModel.FilterItemRvModel filterItemRvModel, int i, View view) {
            FilterCategoryPanel.this.m33701a(filterItemRvModel, i);
        }
    }

    static class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Resources resources = recyclerView.getContext().getResources();
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            rect.bottom = (int) resources.getDimension(R.dimen.customer_9px);
            rect.top = (int) resources.getDimension(R.dimen.customer_9px);
            if (childLayoutPosition % 2 == 0) {
                rect.left = (int) resources.getDimension(R.dimen.customer_24px);
                rect.right = (int) resources.getDimension(R.dimen.customer_9px);
            } else {
                rect.right = (int) resources.getDimension(R.dimen.customer_24px);
                rect.left = (int) resources.getDimension(R.dimen.customer_9px);
            }
            int itemCount = recyclerView.getAdapter().getItemCount();
            if (childLayoutPosition >= itemCount - 2) {
                if (itemCount % 2 == 0) {
                    rect.bottom = (int) resources.getDimension(R.dimen.customer_24px);
                } else if (childLayoutPosition == itemCount - 1) {
                    rect.bottom = (int) resources.getDimension(R.dimen.customer_24px);
                }
            }
            if (childLayoutPosition == 0 || childLayoutPosition == 1) {
                rect.top = (int) resources.getDimension(R.dimen.customer_18px);
            }
        }
    }
}
