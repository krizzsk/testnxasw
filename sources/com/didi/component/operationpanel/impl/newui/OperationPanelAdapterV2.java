package com.didi.component.operationpanel.impl.newui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.router.GlobalRouter;
import com.didi.component.common.view.PositionSensitiveView;
import com.didi.component.core.IComponent;
import com.didi.component.core.IView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.operationpanel.AbsOperationPanelPresenter;
import com.didi.component.operationpanel.OperationPanelItemModel;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OperationPanelAdapterV2 extends RecyclerView.Adapter {

    /* renamed from: a */
    private static final int f16619a = 1;

    /* renamed from: b */
    private static final int f16620b = 2;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AbsOperationPanelPresenter f16621c;

    /* renamed from: d */
    private List<OperationPanelItemModel> f16622d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f16623e;

    /* renamed from: f */
    private Set<IComponent> f16624f = new HashSet();

    public OperationPanelAdapterV2(Context context) {
        this.f16623e = context;
    }

    public void setData(List<OperationPanelItemModel> list) {
        this.f16622d = list;
        notifyDataSetChanged();
    }

    public void setPresenter(AbsOperationPanelPresenter absOperationPanelPresenter) {
        this.f16621c = absOperationPanelPresenter;
    }

    public List<OperationPanelItemModel> getData() {
        return this.f16622d;
    }

    public int getItemViewType(int i) {
        return this.f16622d.get(i).f16618id == 520 ? 2 : 1;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new OperationPanelCommonVH(viewGroup);
        }
        if (i != 2) {
            return new OperationPanelCommonVH(viewGroup);
        }
        return new OperationComponentViewVH(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((OperationPanelBaseVH) viewHolder).bindData(this.f16622d.get(i), i);
    }

    public int getItemCount() {
        List<OperationPanelItemModel> list = this.f16622d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onRemove() {
        for (IComponent removeComponent : this.f16624f) {
            this.f16621c.removeComponent(removeComponent);
        }
    }

    private class OperationPanelBaseVH extends RecyclerView.ViewHolder {
        public OperationPanelBaseVH(View view) {
            super(view);
        }

        public void bindData(final OperationPanelItemModel operationPanelItemModel, int i) {
            this.itemView.setEnabled(operationPanelItemModel.enable);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (OperationPanelAdapterV2.this.f16621c != null) {
                        OperationPanelAdapterV2.this.f16621c.onOperationPanelItemClicked(operationPanelItemModel);
                    }
                }
            });
        }
    }

    private class OperationComponentViewVH extends OperationPanelBaseVH {
        IView cView;
        View componentView;

        public OperationComponentViewVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_operation_panel_item_component_view, viewGroup, false));
        }

        public void bindData(OperationPanelItemModel operationPanelItemModel, int i) {
            if (this.componentView == null) {
                ViewGroup viewGroup = (ViewGroup) this.itemView;
                IComponent inflateComponent = OperationPanelAdapterV2.this.f16621c.inflateComponent(operationPanelItemModel.componentType, viewGroup);
                viewGroup.removeAllViews();
                if (inflateComponent != null) {
                    IView view = inflateComponent.getView();
                    this.cView = view;
                    View view2 = view.getView();
                    this.componentView = view2;
                    viewGroup.addView(view2);
                }
            }
            IView iView = this.cView;
            if (iView instanceof PositionSensitiveView) {
                ((PositionSensitiveView) iView).setPositionOfParentComponent(i);
            }
        }
    }

    public class OperationPanelCommonVH extends OperationPanelBaseVH {
        private TextView mEdit = ((TextView) this.itemView.findViewById(R.id.operation_panel_item_edit));
        private ImageView mIconArray = ((ImageView) this.itemView.findViewById(R.id.operation_panel_item_more));
        public ImageView mIconView = ((ImageView) this.itemView.findViewById(R.id.operation_panel_item_icon));
        private TextView mNameView = ((TextView) this.itemView.findViewById(R.id.operation_panel_item_text));
        private TextView mSubtitle = ((TextView) this.itemView.findViewById(R.id.operation_panel_item_subtitle));

        public OperationPanelCommonVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_operation_panel_item_new_layout, viewGroup, false));
        }

        public void bindData(OperationPanelItemModel operationPanelItemModel, int i) {
            super.bindData(operationPanelItemModel, i);
            if (operationPanelItemModel.title != null && !TextUtils.isEmpty(operationPanelItemModel.title.getContent())) {
                operationPanelItemModel.title.bindTextView(this.mNameView);
            }
            if (!TextUtils.isEmpty(operationPanelItemModel.icon)) {
                Glide.with(OperationPanelAdapterV2.this.f16623e).asBitmap().load((Object) new GlideUrl(operationPanelItemModel.icon)).into(this.mIconView);
            }
            if (!TextUtils.isEmpty(operationPanelItemModel.corner_icon)) {
                Glide.with(OperationPanelAdapterV2.this.f16623e).asBitmap().load((Object) new GlideUrl(operationPanelItemModel.corner_icon)).into(this.mIconArray);
            }
            OperationPanelAdapterV2.this.m13958a(this.mNameView);
            if (!OperationPanelAdapterV2.this.m13960a() || operationPanelItemModel.f16618id != 521) {
                this.mEdit.setVisibility(8);
            } else {
                this.mEdit.setVisibility(0);
            }
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                if (order.isShowSplitFare()) {
                    this.mEdit.setText(ResourcesHelper.getString(OperationPanelAdapterV2.this.f16623e, R.string.GRider_page_Test_yjAZ));
                    this.mEdit.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            DRouter.build(GlobalRouter.PAGE_SPLIT_FARE_CONTACTS).start(OperationPanelAdapterV2.this.f16623e);
                        }
                    });
                } else {
                    this.mEdit.setText(ResourcesHelper.getString(OperationPanelAdapterV2.this.f16623e, R.string.GRider_2020_Cancel_qFbG));
                    this.mEdit.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.SPLIT_FARE_USER_REFUSE_SPLIT);
                        }
                    });
                }
            }
            if (operationPanelItemModel.f16618id != 529) {
                this.mSubtitle.setVisibility(8);
            } else if (operationPanelItemModel.richInfo == null || TextUtils.isEmpty(operationPanelItemModel.richInfo.getContent())) {
                this.mSubtitle.setVisibility(8);
            } else {
                this.mSubtitle.setVisibility(0);
                operationPanelItemModel.richInfo.bindTextView(this.mSubtitle);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m13960a() {
        List<OperationPanelItemModel> list = this.f16622d;
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (OperationPanelItemModel operationPanelItemModel : this.f16622d) {
            if (operationPanelItemModel.f16618id == 520) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13958a(TextView textView) {
        if (textView != null && textView.getText() != null) {
            String string = ResourcesHelper.getString(textView.getContext(), R.string.contentdesc_button, textView.getText().toString());
            textView.setContentDescription(string);
            if (textView.getParent() != null) {
                ((View) textView.getParent()).setContentDescription(string);
            }
        }
    }
}
