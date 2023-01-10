package com.didi.soda.business.component.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import butterknife.BindView;
import com.didi.app.nova.skeleton.image.ImageRequestListener;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.business.component.image.Contract;
import com.didi.soda.business.component.image.GestureDetector;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.imageloader.ImageResourceReadyListener;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goods.CustomerPriceView;
import com.didi.soda.goods.contract.GoodsItemState;
import com.taxis99.R;

public class BusinessPreviewImageView extends Contract.AbsBusinessImageView {

    /* renamed from: a */
    private static final int f42252a = 0;

    /* renamed from: b */
    private static final int f42253b = 1;

    /* renamed from: c */
    private static final int f42254c = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f42255d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GestureDetector f42256e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Rect f42257f;
    @BindView(19036)
    TextView mAddBtn;
    @BindView(18130)
    FrameLayout mAddContainer;
    @BindView(17888)
    View mBackView;
    @BindView(18373)
    ImageView mImageView;
    @BindView(19037)
    TextView mNameView;
    @BindView(19038)
    CustomerPriceView mPriceView;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m31758a(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m31766b(View view) {
    }

    public void updateView(PreviewImageModel previewImageModel) {
        if (previewImageModel != null) {
            m31759a(previewImageModel);
            this.mPriceView.setFontType(IToolsService.FontType.LIGHT, IToolsService.FontType.LIGHT);
            this.mPriceView.setPriceStr(previewImageModel.mPrice, previewImageModel.mOriginPrice);
            this.mNameView.setText(previewImageModel.mName);
            m31763a(previewImageModel.mGoodsItemState);
            this.mAddContainer.setOnClickListener(new View.OnClickListener(previewImageModel) {
                public final /* synthetic */ PreviewImageModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BusinessPreviewImageView.this.m31761a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31761a(PreviewImageModel previewImageModel, View view) {
        ((Contract.AbsBusinessImagePresenter) getPresenter()).clickAddBtn(previewImageModel);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_business_image, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ViewCompat.setTransitionName(this.mImageView, getScopeContext().getBundle().getString(Const.PageParams.TRANSITION_NAMES));
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessPreviewImageView.this.m31767c(view);
            }
        });
        this.f42256e = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() {
            public void onGlide() {
                ((Contract.AbsBusinessImagePresenter) BusinessPreviewImageView.this.getPresenter()).finish(1);
            }

            public void onClick() {
                ((Contract.AbsBusinessImagePresenter) BusinessPreviewImageView.this.getPresenter()).finish(2);
            }
        });
        getView().setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BusinessPreviewImageView.this.f42256e.onMotionEvent(motionEvent, BusinessPreviewImageView.this.f42257f);
                return true;
            }
        });
        this.mImageView.post(new Runnable() {
            public final void run() {
                BusinessPreviewImageView.this.m31757a();
            }
        });
        this.mNameView.setOnClickListener($$Lambda$BusinessPreviewImageView$lzMpBGSPXmKVwXpJQyd0P7exQSw.INSTANCE);
        this.mPriceView.setOnClickListener($$Lambda$BusinessPreviewImageView$XeADVQlftcjlzQXxXj6ocgbF_0.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m31767c(View view) {
        ((Contract.AbsBusinessImagePresenter) getPresenter()).finish(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31757a() {
        Rect rect = new Rect();
        this.f42257f = rect;
        this.mImageView.getGlobalVisibleRect(rect);
    }

    /* renamed from: a */
    private void m31763a(GoodsItemState goodsItemState) {
        this.mAddBtn.setText(getContext().getResources().getString(R.string.customer_global_add));
        if (goodsItemState == GoodsItemState.FOR_SALE) {
            this.mAddContainer.setEnabled(true);
            return;
        }
        this.mAddContainer.setEnabled(false);
        this.mAddBtn.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
    }

    /* renamed from: a */
    private void m31759a(final PreviewImageModel previewImageModel) {
        if (previewImageModel.mImageUrl != null) {
            this.mImageView.setImageResource(R.drawable.customer_skin_img_business_goods_item_x11);
            FlyImageLoader.loadImage1x1(getScopeContext(), previewImageModel.mImageUrl).override(previewImageModel.mViewWidth, previewImageModel.mViewHeight).centerCrop().dontAnimate().intoDrawableImageView(getContext(), new ImageView(getContext()), new ImageResourceReadyListener() {
                public void onResourceReady(Drawable drawable) {
                    if (!BusinessPreviewImageView.this.f42255d) {
                        BusinessPreviewImageView.this.mImageView.setImageDrawable(drawable);
                        BusinessPreviewImageView.this.m31760a(previewImageModel, drawable);
                    }
                }
            });
            return;
        }
        m31760a(previewImageModel, ContextCompat.getDrawable(getContext(), R.drawable.customer_skin_img_business_goods_item_x11));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31760a(final PreviewImageModel previewImageModel, Drawable drawable) {
        if (previewImageModel.mPreviewImageUrl != null) {
            int screenWidth = DisplayUtils.getScreenWidth(getContext());
            FlyImageLoader.loadImage1x1(getScopeContext(), previewImageModel.mPreviewImageUrl).centerCrop().dontAnimate().override(screenWidth, screenWidth).placeholder(drawable).listener(new ImageRequestListener() {
                public boolean onException(Exception exc, boolean z) {
                    return true;
                }

                public boolean onResourceReady(Object obj, boolean z, boolean z2) {
                    boolean unused = BusinessPreviewImageView.this.f42255d = true;
                    ((Contract.AbsBusinessImagePresenter) BusinessPreviewImageView.this.getPresenter()).onBigImageSw(previewImageModel);
                    return false;
                }
            }).into(this.mImageView);
        }
    }
}
