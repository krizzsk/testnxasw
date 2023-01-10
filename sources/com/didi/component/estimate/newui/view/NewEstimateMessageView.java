package com.didi.component.estimate.newui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.estimate.newui.view.viewholder.EstimateMessageViewHolder;
import com.didi.component.estimate.newui.view.viewholder.EstimateTransferFlowViewHolder;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.sdk.util.NewUISwitchUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewEstimateMessageView extends FrameLayout {

    /* renamed from: s */
    private static int f14965s = -12;

    /* renamed from: t */
    private static int f14966t = -11;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f14967a;

    /* renamed from: b */
    private EstimateMessageViewHolder f14968b;

    /* renamed from: c */
    private EstimateMessageViewHolder f14969c;

    /* renamed from: d */
    private EstimateTransferFlowViewHolder f14970d;

    /* renamed from: e */
    private EstimateTransferFlowViewHolder f14971e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f14972f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f14973g;

    /* renamed from: h */
    private AnimatorSet f14974h;

    /* renamed from: i */
    private AnimatorSet f14975i;

    /* renamed from: j */
    private AnimatorSet f14976j;

    /* renamed from: k */
    private CarMessageModel f14977k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f14978l = -1;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public CarMessageModel f14979m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f14980n = -1;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public MessageViewClickListener f14981o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f14982p = true;

    /* renamed from: q */
    private RecyclerView f14983q;

    /* renamed from: r */
    private int f14984r;

    public interface MessageViewClickListener {
        void onTransferFlowCloseClick(CarMessageModel carMessageModel);

        void onTransferFlowItemClick(int i);
    }

    public NewEstimateMessageView(Context context) {
        super(context);
        this.f14967a = context;
        initView();
    }

    public NewEstimateMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14967a = context;
        initView();
    }

    public NewEstimateMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14967a = context;
        initView();
    }

    public void initView() {
        C60291 r0 = new EstimateMessageViewHolder.MessageListener() {
            public void onMessageClick(CarMessageModel carMessageModel) {
                if (!TextUtils.isEmpty(carMessageModel.messageLink)) {
                    Intent intent = new Intent(NewEstimateMessageView.this.f14967a, GlobalWebActivity.class);
                    intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(carMessageModel.messageLink));
                    NewEstimateMessageView.this.f14967a.startActivity(intent);
                    GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_bubble_ck", NewEstimateMessageView.this.collectGuideFlowParams(carMessageModel));
                }
            }
        };
        EstimateMessageViewHolder estimateMessageViewHolder = new EstimateMessageViewHolder(this);
        this.f14968b = estimateMessageViewHolder;
        estimateMessageViewHolder.setListener(r0);
        EstimateMessageViewHolder estimateMessageViewHolder2 = new EstimateMessageViewHolder(this);
        this.f14969c = estimateMessageViewHolder2;
        estimateMessageViewHolder2.setListener(r0);
        C60342 r02 = new EstimateTransferFlowViewHolder.TransferFlowListener() {
            public void onTransferFlowClick(CarMessageModel carMessageModel) {
                if (NewEstimateMessageView.this.f14981o != null && NewEstimateMessageView.this.f14978l > -1) {
                    NewEstimateMessageView.this.f14981o.onTransferFlowItemClick(NewEstimateMessageView.this.f14978l);
                    GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_bubble_ck", NewEstimateMessageView.this.collectGuideFlowParams(carMessageModel));
                }
            }

            public void onTransferFlowCloseClick(CarMessageModel carMessageModel) {
                boolean unused = NewEstimateMessageView.this.f14982p = false;
                CarMessageModel unused2 = NewEstimateMessageView.this.f14979m = null;
                int unused3 = NewEstimateMessageView.this.f14980n = -1;
                NewEstimateMessageView newEstimateMessageView = NewEstimateMessageView.this;
                newEstimateMessageView.m12315a((CarMessageModel) null, newEstimateMessageView.f14980n);
                if (NewEstimateMessageView.this.f14981o != null) {
                    NewEstimateMessageView.this.f14981o.onTransferFlowCloseClick(carMessageModel);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_bubble_close_ck", NewEstimateMessageView.this.collectGuideFlowParams(carMessageModel));
            }
        };
        EstimateTransferFlowViewHolder estimateTransferFlowViewHolder = new EstimateTransferFlowViewHolder(this);
        this.f14970d = estimateTransferFlowViewHolder;
        estimateTransferFlowViewHolder.setCarRecyclerView(this.f14983q);
        this.f14970d.setType(this.f14984r);
        this.f14970d.setListener(r02);
        EstimateTransferFlowViewHolder estimateTransferFlowViewHolder2 = new EstimateTransferFlowViewHolder(this);
        this.f14971e = estimateTransferFlowViewHolder2;
        estimateTransferFlowViewHolder2.setCarRecyclerView(this.f14983q);
        this.f14971e.setType(this.f14984r);
        this.f14971e.setListener(r02);
        m12312a();
    }

    /* renamed from: a */
    private void m12312a() {
        ValueAnimator a = m12308a(400, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f14972f != null && NewEstimateMessageView.this.f14972f.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f14972f.setTranslationY(((float) NewEstimateMessageView.this.f14972f.getMeasuredHeight()) * (1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                }
            }
        });
        ValueAnimator a2 = m12308a(300, 100, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f14972f != null && NewEstimateMessageView.this.f14972f.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f14972f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f14974h = animatorSet;
        animatorSet.playTogether(new Animator[]{a, a2});
        this.f14974h.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (NewEstimateMessageView.this.f14972f != null && !NewEstimateMessageView.this.f14972f.isAttachedToWindow()) {
                    NewEstimateMessageView newEstimateMessageView = NewEstimateMessageView.this;
                    newEstimateMessageView.addView(newEstimateMessageView.f14972f);
                }
                NewEstimateMessageView.this.f14972f.setAlpha(0.0f);
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        ValueAnimator a3 = m12308a(400, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f14972f != null && NewEstimateMessageView.this.f14972f.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f14972f.setTranslationY(((float) NewEstimateMessageView.this.f14972f.getMeasuredHeight()) * (1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                }
            }
        });
        ValueAnimator a4 = m12308a(300, 100, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f14972f != null && NewEstimateMessageView.this.f14972f.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f14972f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ValueAnimator a5 = m12308a(400, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f14973g != null && NewEstimateMessageView.this.f14973g.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f14973g.setTranslationY(((float) NewEstimateMessageView.this.f14973g.getMeasuredHeight()) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ValueAnimator a6 = m12308a(200, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f14973g != null && NewEstimateMessageView.this.f14973g.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f14973g.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f14975i = animatorSet2;
        animatorSet2.playTogether(new Animator[]{a3, a4, a5, a6});
        this.f14975i.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (NewEstimateMessageView.this.f14972f == null || !NewEstimateMessageView.this.f14972f.isAttachedToWindow()) {
                    NewEstimateMessageView newEstimateMessageView = NewEstimateMessageView.this;
                    newEstimateMessageView.addView(newEstimateMessageView.f14972f);
                }
                NewEstimateMessageView.this.f14972f.setAlpha(0.0f);
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (NewEstimateMessageView.this.f14973g != null && NewEstimateMessageView.this.f14973g.isAttachedToWindow()) {
                    NewEstimateMessageView newEstimateMessageView = NewEstimateMessageView.this;
                    newEstimateMessageView.removeView(newEstimateMessageView.f14973g);
                }
                View unused = NewEstimateMessageView.this.f14973g = null;
            }
        });
        ValueAnimator a7 = m12308a(400, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f14973g != null && NewEstimateMessageView.this.f14973g.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f14973g.setTranslationY(((float) NewEstimateMessageView.this.f14973g.getMeasuredHeight()) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ValueAnimator a8 = m12308a(200, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NewEstimateMessageView.this.f14973g != null && NewEstimateMessageView.this.f14973g.isAttachedToWindow()) {
                    NewEstimateMessageView.this.f14973g.setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f14976j = animatorSet3;
        animatorSet3.playTogether(new Animator[]{a7, a8});
        this.f14976j.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (NewEstimateMessageView.this.f14973g != null && NewEstimateMessageView.this.f14973g.isAttachedToWindow()) {
                    NewEstimateMessageView newEstimateMessageView = NewEstimateMessageView.this;
                    newEstimateMessageView.removeView(newEstimateMessageView.f14973g);
                }
                View unused = NewEstimateMessageView.this.f14973g = null;
            }
        });
    }

    public void reset() {
        removeAllViews();
        this.f14972f = null;
        this.f14973g = null;
        this.f14977k = null;
        this.f14978l = -1;
        this.f14979m = null;
        this.f14980n = -1;
    }

    /* renamed from: a */
    private ValueAnimator m12308a(long j, long j2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
        ofFloat.setDuration(j);
        ofFloat.setStartDelay(j2);
        ofFloat.addUpdateListener(animatorUpdateListener);
        return ofFloat;
    }

    public void setCarRecyclerView(RecyclerView recyclerView) {
        this.f14983q = recyclerView;
        this.f14970d.setCarRecyclerView(recyclerView);
        this.f14971e.setCarRecyclerView(recyclerView);
    }

    /* renamed from: a */
    private void m12313a(Animator animator) {
        if (animator != null && animator.isRunning()) {
            animator.end();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12315a(CarMessageModel carMessageModel, int i) {
        if (carMessageModel != this.f14977k) {
            m12313a((Animator) this.f14974h);
            m12313a((Animator) this.f14975i);
            m12313a((Animator) this.f14976j);
            this.f14977k = carMessageModel;
            this.f14978l = i;
            this.f14973g = this.f14972f;
            if (carMessageModel == null) {
                this.f14972f = null;
            } else if (carMessageModel.isTopGuide()) {
                this.f14971e.setData(carMessageModel, i);
                m12319b();
                this.f14972f = this.f14970d.itemView;
            } else {
                this.f14969c.setData(carMessageModel);
                m12321c();
                this.f14972f = this.f14968b.itemView;
            }
            if (this.f14972f != null) {
                if (this.f14973g != null) {
                    this.f14975i.start();
                } else {
                    this.f14974h.start();
                }
            } else if (this.f14973g != null) {
                this.f14976j.start();
            }
            GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_bubble_sw", collectGuideFlowParams(carMessageModel));
        }
    }

    /* renamed from: b */
    private void m12319b() {
        EstimateTransferFlowViewHolder estimateTransferFlowViewHolder = this.f14970d;
        this.f14970d = this.f14971e;
        this.f14971e = estimateTransferFlowViewHolder;
    }

    /* renamed from: c */
    private void m12321c() {
        EstimateMessageViewHolder estimateMessageViewHolder = this.f14968b;
        this.f14968b = this.f14969c;
        this.f14969c = estimateMessageViewHolder;
    }

    public boolean setMessageData(List<EstimateItemModel> list, EstimateItemModel estimateItemModel, boolean z) {
        boolean z2;
        this.f14979m = null;
        this.f14980n = -1;
        if (NewUISwitchUtils.getEstimateNewAbStatus() == 1) {
            z2 = m12317a(list, estimateItemModel, z);
        } else {
            z2 = m12317a(list, estimateItemModel, z);
        }
        m12315a(this.f14979m, this.f14980n);
        return z2;
    }

    /* renamed from: a */
    private boolean m12317a(List<EstimateItemModel> list, EstimateItemModel estimateItemModel, boolean z) {
        EstimateItemModel estimateItemModel2 = null;
        this.f14979m = null;
        this.f14980n = -1;
        if (list != null) {
            estimateItemModel2 = list.get(0);
        }
        if (estimateItemModel2 != null && !CollectionUtils.isEmpty((Collection) estimateItemModel2.carMessage) && estimateItemModel2.carMessage.get(0).isTopGuide()) {
            this.f14979m = estimateItemModel2.carMessage.get(0);
        } else if (estimateItemModel != null && !CollectionUtils.isEmpty((Collection) estimateItemModel.carMessage) && (z || !estimateItemModel.carMessage.get(0).isTopGuide())) {
            this.f14979m = estimateItemModel.carMessage.get(0);
        }
        if (this.f14979m != null) {
            this.f14980n = 0;
        }
        try {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            if (this.f14979m == null) {
                layoutParams.bottomMargin = 0;
            } else if (this.f14979m.isTopGuide()) {
                if (Build.VERSION.SDK_INT >= 21) {
                    setTranslationZ(1.0f);
                }
                layoutParams.bottomMargin = UiUtils.dip2px(this.f14967a, (float) f14966t);
            } else {
                layoutParams.bottomMargin = UiUtils.dip2px(this.f14967a, (float) f14965s);
            }
            setLayoutParams(layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f14979m != null) {
            return true;
        }
        return false;
    }

    public int messageMargin() {
        CarMessageModel carMessageModel = this.f14979m;
        if (carMessageModel == null) {
            return 0;
        }
        if (!carMessageModel.isTopGuide()) {
            return UiUtils.dip2px(this.f14967a, (float) f14965s);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return UiUtils.dip2px(this.f14967a, (float) f14966t);
        }
        return 0;
    }

    public void setMessageViewClickListener(MessageViewClickListener messageViewClickListener) {
        this.f14981o = messageViewClickListener;
    }

    public Map<String, Object> collectGuideFlowParams(CarMessageModel carMessageModel) {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        HashMap hashMap = new HashMap();
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null)) {
            hashMap.put("cartype", Integer.valueOf(newEstimateItem.carConfig.carLevel));
            hashMap.put("bubble_id", newEstimateItem.carConfig.estimateId);
            if (carMessageModel != null && !TextUtils.isEmpty(carMessageModel.messageTypeId)) {
                hashMap.put("id", carMessageModel.messageTypeId);
            }
            if (newEstimateItem.carConfig.guideType != null) {
                hashMap.put(ParamKeys.PARAM_GUIDE_TYPE, newEstimateItem.carConfig.guideType.toString());
            }
            if (newEstimateItem.carConfig.extraData != null) {
                newEstimateItem.carConfig.extraData.putAllExtraLog(hashMap);
            }
        }
        return hashMap;
    }

    public void setType(int i) {
        this.f14984r = i;
        EstimateTransferFlowViewHolder estimateTransferFlowViewHolder = this.f14970d;
        if (estimateTransferFlowViewHolder != null) {
            estimateTransferFlowViewHolder.setType(i);
        }
        EstimateTransferFlowViewHolder estimateTransferFlowViewHolder2 = this.f14971e;
        if (estimateTransferFlowViewHolder2 != null) {
            estimateTransferFlowViewHolder2.setType(this.f14984r);
        }
    }
}
