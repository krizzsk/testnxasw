package com.didi.component.groupform.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.groupform.presenter.AbsGroupFormPresenter;
import com.didi.component.groupform.view.adapter.FormViewOptionAdapter;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel3;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.model.response.estimate.CarFareConfirmBreak;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.FormOperationModels;
import com.didichuxing.omega.sdk.Omega;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GroupFormViewNewUI implements IViewContainer, IGroupFormView {

    /* renamed from: a */
    private View f15902a;

    /* renamed from: b */
    private TextView f15903b;

    /* renamed from: c */
    private AbsGroupFormPresenter f15904c;

    /* renamed from: d */
    private RecyclerView f15905d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f15906e;

    /* renamed from: f */
    private GridLayoutManager f15907f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FormViewOptionAdapter f15908g;

    /* renamed from: h */
    private Drawable f15909h;

    /* renamed from: i */
    private LEGODrawer f15910i;

    /* renamed from: j */
    private ConstraintLayout f15911j;

    /* renamed from: k */
    private List<Integer> f15912k;

    /* renamed from: l */
    private FrameLayout f15913l;

    /* renamed from: m */
    private IComponent f15914m;

    /* renamed from: n */
    private boolean f15915n;

    /* renamed from: o */
    private boolean f15916o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final Logger f15917p = LoggerFactory.getLogger(getClass());

    public void setupPointText(String str, boolean z, boolean z2) {
    }

    public void updateText() {
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f15904c.setComponentCreator(iComponentCreator);
    }

    public GroupFormViewNewUI(Context context, ViewGroup viewGroup) {
        this.f15906e = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.f15908g = new FormViewOptionAdapter();
        View inflate = from.inflate(R.layout.global_group_form_new_ui_layout, viewGroup, false);
        this.f15902a = inflate;
        this.f15903b = (TextView) inflate.findViewById(R.id.form_btn);
        this.f15911j = (ConstraintLayout) this.f15902a.findViewById(R.id.global_form_layout);
        this.f15913l = (FrameLayout) this.f15902a.findViewById(R.id.payway_container);
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.carConfig == null || TextUtils.isEmpty(newEstimateItem.carConfig.confirmText)) {
            this.f15903b.setText(R.string.global_confirm_btn_new);
        } else {
            this.f15903b.setText(newEstimateItem.carConfig.confirmText);
        }
        Drawable drawable = DidiThemeManager.getIns().getResPicker(context).getDrawable(R.attr.global_overall_main_button_selector);
        this.f15909h = drawable;
        this.f15903b.setBackground(drawable);
        try {
            this.f15903b.setTextColor(ContextCompat.getColorStateList(context, DidiThemeManager.getIns().getResPicker(context).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
        } catch (Resources.NotFoundException e) {
            Omega.trackError("comp-group-form", e);
        }
        this.f15905d = (RecyclerView) this.f15902a.findViewById(R.id.global_form_option_container);
        ViewGroup.LayoutParams layoutParams = this.f15911j.getLayoutParams();
        this.f15911j.setBackgroundResource(R.drawable.form_bg);
        layoutParams.height = UiUtils.dip2px(this.f15906e, 169.0f);
        FormStore.getInstance().setmGroupFormViewChanged(true);
        this.f15905d.setLayoutParams((ConstraintLayout.LayoutParams) this.f15905d.getLayoutParams());
        this.f15911j.setLayoutParams(layoutParams);
        this.f15905d.setAdapter(this.f15908g);
        this.f15903b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (!Utils.isFastDoubleClick()) {
                    GroupFormViewNewUI.this.f15917p.debug("FastDoubleClickTest click ", new Object[0]);
                    EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                    if (newEstimateItem != null && newEstimateItem.carConfig != null) {
                        if (newEstimateItem.carConfig.carAvailable != 0) {
                            if (GroupFormViewNewUI.this.estimateNoPriceIntercept()) {
                                GroupFormViewNewUI.this.noPriceSendOrderDialog(FormStore.getInstance().getNewEstimateItem().carBreakModel.carFareConfirm);
                            } else {
                                GroupFormViewNewUI.this.onConfirmClick();
                            }
                        } else if (!TextUtils.isEmpty(newEstimateItem.carConfig.unvailableToastText)) {
                            LEGOToastHelper.showToast(GroupFormViewNewUI.this.f15906e, newEstimateItem.carConfig.unvailableToastText);
                        } else {
                            LEGOToastHelper.showToast(GroupFormViewNewUI.this.f15906e, GroupFormViewNewUI.this.f15906e.getString(R.string.GRider_page_Model_current_HCmg));
                        }
                    }
                }
            }
        });
    }

    public void onConfirmClick() {
        if (FormStore.getInstance().isTwoPriceBiz()) {
            FormStore.getInstance().setTwoPriceSeatConfirm(false);
        }
        FormStore.getInstance().setFlexOfferPrice(false);
        this.f15904c.onConfirmPriceIntercept();
    }

    public boolean estimateNoPriceIntercept() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null && newEstimateItem.carBreakModel != null && newEstimateItem.carBreakModel.carFareConfirm != null && !TextUtils.isEmpty(newEstimateItem.carBreakModel.carFareConfirm.fareTitle) && !TextUtils.isEmpty(newEstimateItem.carBreakModel.carFareConfirm.confirmText) && !TextUtils.isEmpty(newEstimateItem.carBreakModel.carFareConfirm.cancelText)) {
            return true;
        }
        return false;
    }

    public void noPriceSendOrderDialog(final CarFareConfirmBreak carFareConfirmBreak) {
        LEGOBaseDrawerModel lEGOBaseDrawerModel;
        noPriceDialogDismiss();
        if (TextUtils.isEmpty(carFareConfirmBreak.linkText) || TextUtils.isEmpty(carFareConfirmBreak.link)) {
            lEGOBaseDrawerModel = new LEGODrawerModel1(carFareConfirmBreak.fareTitle, new LEGOBtnTextAndCallback(carFareConfirmBreak.confirmText, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (GroupFormViewNewUI.this.estimateNoPriceIntercept()) {
                        GroupFormViewNewUI.this.onConfirmClick();
                    }
                    GroupFormViewNewUI.this.noPriceDialogDismiss();
                }
            }));
        } else {
            lEGOBaseDrawerModel = new LEGODrawerModel3(carFareConfirmBreak.fareTitle, carFareConfirmBreak.linkText, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    Intent intent = new Intent(GroupFormViewNewUI.this.f15906e, GlobalWebActivity.class);
                    intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(carFareConfirmBreak.link));
                    GroupFormViewNewUI.this.f15906e.startActivity(intent);
                }
            }, new LEGOBtnTextAndCallback(carFareConfirmBreak.confirmText, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (GroupFormViewNewUI.this.estimateNoPriceIntercept()) {
                        GroupFormViewNewUI.this.onConfirmClick();
                    }
                    GroupFormViewNewUI.this.noPriceDialogDismiss();
                }
            }));
        }
        lEGOBaseDrawerModel.addMinorBtn(new LEGOBtnTextAndCallback(carFareConfirmBreak.cancelText, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GroupFormViewNewUI.this.noPriceDialogDismiss();
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        }));
        if (!TextUtils.isEmpty(carFareConfirmBreak.farText)) {
            lEGOBaseDrawerModel.setSubTitle(carFareConfirmBreak.farText);
        }
        lEGOBaseDrawerModel.setClickOutsideCanCancel(false);
        lEGOBaseDrawerModel.setIsShowCloseImg(true);
        lEGOBaseDrawerModel.setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GroupFormViewNewUI.this.noPriceDialogDismiss();
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        });
        LEGODrawer showDrawerTemplate = LEGOUICreator.showDrawerTemplate(this.f15906e, lEGOBaseDrawerModel);
        this.f15910i = showDrawerTemplate;
        showDrawerTemplate.show();
    }

    public void noPriceDialogDismiss() {
        LEGODrawer lEGODrawer = this.f15910i;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            this.f15910i.dismiss();
        }
    }

    public void setPresenter(AbsGroupFormPresenter absGroupFormPresenter) {
        this.f15908g.setPresenter(absGroupFormPresenter);
        this.f15904c = absGroupFormPresenter;
    }

    public View getView() {
        return this.f15902a;
    }

    public void setEnabled(boolean z) {
        this.f15903b.setEnabled(z);
    }

    public void setButtonText(CharSequence charSequence) {
        this.f15903b.setText(charSequence);
    }

    public void setButtonBg(Drawable drawable) {
        if (drawable != null) {
            this.f15903b.setBackground(drawable);
        } else {
            this.f15903b.setBackground(this.f15909h);
        }
    }

    public void setOptionViews(List<Integer> list) {
        LEGODrawer lEGODrawer = this.f15910i;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_BOTTOM_FORM_HINTED);
        }
        if (list != null) {
            List<Integer> list2 = this.f15912k;
            if (list2 == null) {
                this.f15912k = new ArrayList();
            } else {
                list2.clear();
            }
            if (!this.f15915n) {
                this.f15914m = this.f15904c.inflateComponent(ComponentType.PAYWAY, this.f15913l);
                this.f15915n = true;
            }
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem != null && newEstimateItem.showDataPick()) {
                this.f15912k.add(2);
            }
            FormStore.getInstance().setHasSubstituteCall(false);
            if (newEstimateItem != null && newEstimateItem.mFormOperationModel != null && !CollectionUtils.isEmpty((Collection) newEstimateItem.mFormOperationModel.items)) {
                Iterator<FormOperationModels> it = newEstimateItem.mFormOperationModel.items.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FormOperationModels next = it.next();
                    if (next.mFormOperationType == 1) {
                        this.f15912k.add(7);
                        if (!GlobalSPUtil.isShowPaywayGuide(this.f15906e)) {
                            this.f15904c.showNoviceGuidance(next.mEducationPopupCount);
                        }
                        FormStore.getInstance().setHasSubstituteCall(true);
                        m13196a();
                    }
                }
            }
            this.f15908g.setModelList(this.f15912k);
            ConstraintLayout.LayoutParams layoutParams = null;
            if (this.f15903b.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                layoutParams = (ConstraintLayout.LayoutParams) this.f15903b.getLayoutParams();
            }
            if (this.f15908g.getModelListSize() == 0) {
                layoutParams.width = -1;
                layoutParams.setMarginStart(UiUtils.dip2px(this.f15906e, 10.0f));
            } else {
                layoutParams.width = -2;
                layoutParams.setMarginStart(UiUtils.dip2px(this.f15906e, 0.0f));
            }
            if (this.f15907f == null) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f15906e, 6);
                this.f15907f = gridLayoutManager;
                gridLayoutManager.setAutoMeasureEnabled(true);
                this.f15907f.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    public int getSpanSize(int i) {
                        int modelListSize = GroupFormViewNewUI.this.f15908g.getModelListSize();
                        int i2 = modelListSize % (6 / FormViewOptionAdapter.RECYCLER_VIEW_SINGLE_COL_SPANS);
                        if (i < modelListSize - i2 || i2 <= 0) {
                            return FormViewOptionAdapter.RECYCLER_VIEW_SINGLE_COL_SPANS;
                        }
                        return 6 / i2;
                    }
                });
                this.f15905d.setLayoutManager(this.f15907f);
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    GroupFormViewNewUI.this.f15908g.notifyDataSetChanged();
                }
            });
        }
    }

    /* renamed from: a */
    private void m13196a() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f15905d.getLayoutParams();
        layoutParams.setMarginEnd(UIUtils.dip2pxInt(this.f15906e, 30.0f));
        this.f15905d.setLayoutParams(layoutParams);
    }

    public void onDestroy() {
        FormViewOptionAdapter formViewOptionAdapter = this.f15908g;
        if (formViewOptionAdapter != null) {
            formViewOptionAdapter.onDestroy();
        }
    }

    public void setMaxColCount(int i) {
        FormViewOptionAdapter.RECYCLER_VIEW_SINGLE_COL_SPANS = 6 / i;
    }

    public void setVisible(boolean z) {
        this.f15902a.setVisibility(z ? 0 : 8);
    }
}
