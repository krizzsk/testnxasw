package com.didi.soda.order.component.preview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.business.component.image.GestureDetector;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.order.component.preview.Contract;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u001c\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0014J$\u0010 \u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo148868d2 = {"Lcom/didi/soda/order/component/preview/EvaluatePreviewImageView;", "Lcom/didi/soda/order/component/preview/Contract$AbsEvaluateImageView;", "()V", "backView", "Landroid/view/View;", "gestureDetector", "Lcom/didi/soda/business/component/image/GestureDetector;", "imageRect", "Landroid/graphics/Rect;", "imageView", "Landroid/widget/ImageView;", "isLoadPreviewImage", "", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initView", "", "root", "loadBigImage", "imageUrl", "", "placeDrawable", "Landroid/graphics/drawable/Drawable;", "loadLocalImage", "imageStr", "loadNetworkImageView", "width", "", "onCreate", "updateView", "localImageStr", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EvaluatePreviewImageView.kt */
public final class EvaluatePreviewImageView extends Contract.AbsEvaluateImageView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f */
    private static final int f45991f = 0;

    /* renamed from: g */
    private static final int f45992g = 1;

    /* renamed from: h */
    private static final int f45993h = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ImageView f45994a;

    /* renamed from: b */
    private View f45995b;

    /* renamed from: c */
    private GestureDetector f45996c;

    /* renamed from: d */
    private Rect f45997d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f45998e;

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_evaluate_preview_image, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        initView(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…nitView(it)\n            }");
        return inflate;
    }

    public final void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "root");
        View findViewById = view.findViewById(R.id.customer_iv_evaluate_preview_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.c…v_evaluate_preview_image)");
        this.f45994a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.customer_cl_preview_image_back);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.c…er_cl_preview_image_back)");
        this.f45995b = findViewById2;
    }

    public void updateView(int i, String str, String str2) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            m34137a(str);
        } else {
            m34134a(i, str2);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ImageView imageView = this.f45994a;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        ViewCompat.setTransitionName(imageView, getScopeContext().getBundle().getString(Const.PageParams.TRANSITION_NAMES));
        View view = this.f45995b;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EvaluatePreviewImageView.m34136a(EvaluatePreviewImageView.this, view);
            }
        });
        this.f45996c = new GestureDetector(getContext(), new EvaluatePreviewImageView$onCreate$2(this));
        getView().setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return EvaluatePreviewImageView.m34139a(EvaluatePreviewImageView.this, view, motionEvent);
            }
        });
        ImageView imageView3 = this.f45994a;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.post(new Runnable() {
            public final void run() {
                EvaluatePreviewImageView.m34135a(EvaluatePreviewImageView.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34136a(EvaluatePreviewImageView evaluatePreviewImageView, View view) {
        Intrinsics.checkNotNullParameter(evaluatePreviewImageView, "this$0");
        Contract.AbsEvaluateImagePresenter absEvaluateImagePresenter = (Contract.AbsEvaluateImagePresenter) evaluatePreviewImageView.getPresenter();
        if (absEvaluateImagePresenter != null) {
            absEvaluateImagePresenter.finish(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m34139a(EvaluatePreviewImageView evaluatePreviewImageView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(evaluatePreviewImageView, "this$0");
        GestureDetector gestureDetector = evaluatePreviewImageView.f45996c;
        if (gestureDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
            gestureDetector = null;
        }
        gestureDetector.onMotionEvent(motionEvent, evaluatePreviewImageView.f45997d);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34135a(EvaluatePreviewImageView evaluatePreviewImageView) {
        Intrinsics.checkNotNullParameter(evaluatePreviewImageView, "this$0");
        evaluatePreviewImageView.f45997d = new Rect();
        ImageView imageView = evaluatePreviewImageView.f45994a;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        imageView.getGlobalVisibleRect(evaluatePreviewImageView.f45997d);
    }

    /* renamed from: a */
    private final void m34137a(String str) {
        Unit unit;
        Bitmap convertStringToIcon = BitmapUtil.convertStringToIcon(str);
        ImageView imageView = null;
        if (convertStringToIcon == null) {
            unit = null;
        } else {
            ImageView imageView2 = this.f45994a;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                imageView2 = null;
            }
            imageView2.setImageBitmap(convertStringToIcon);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ImageView imageView3 = this.f45994a;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            } else {
                imageView = imageView3;
            }
            imageView.setImageResource(R.drawable.customer_skin_img_business_goods_item_x11);
        }
    }

    /* renamed from: a */
    private final void m34134a(int i, String str) {
        ImageView imageView = this.f45994a;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.customer_skin_img_business_goods_item_x11);
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            FlyImageLoader.loadImage1x1(getScopeContext(), str).override(i, i).centerCrop().dontAnimate().placeholder((int) R.drawable.customer_skin_img_business_goods_item_x11).error((int) R.drawable.customer_skin_img_business_goods_item_x11).intoDrawableImageView(getContext(), new ImageView(getContext()), new EvaluatePreviewImageView$loadNetworkImageView$1(this, str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m34138a(String str, Drawable drawable) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            int screenWidth = DisplayUtils.getScreenWidth(getContext());
            FlyImageLoader.ImageRequestWrapper listener = FlyImageLoader.loadImage1x1(getScopeContext(), str).centerCrop().dontAnimate().override(screenWidth, screenWidth).placeholder(drawable).listener(new EvaluatePreviewImageView$loadBigImage$1(this));
            ImageView imageView = this.f45994a;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                imageView = null;
            }
            listener.into(imageView);
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/order/component/preview/EvaluatePreviewImageView$Companion;", "", "()V", "TYPE_CLICK_BACK_BTN_CLOSE", "", "TYPE_CLICK_BLANK_AREA_CLOSE", "TYPE_GLIDE_CLOSE", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: EvaluatePreviewImageView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
