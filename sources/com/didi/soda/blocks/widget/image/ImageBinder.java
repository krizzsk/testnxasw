package com.didi.soda.blocks.widget.image;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.optimize.OptimizeController;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.style.BaseBinder;
import com.didi.soda.blocks.style.ValueManagerKt;
import com.didi.soda.blocks.utils.ColorUtils;
import com.didi.soda.blocks.utils.ImageRenderUtil;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "Image")
@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J0\u0010\u001b\u001a\u00020\u001c2&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f\u0018\u0001` H\u0016J0\u0010!\u001a\u00020\u001c2&\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f\u0018\u0001` H\u0016J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J4\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\rH\u0002J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u0013H\u0002J\u0010\u00101\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00102\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020*H\u0002J\u0012\u00104\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0002J0\u00106\u001a\u0002072&\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001f\u0018\u0001` H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u00068"}, mo148868d2 = {"Lcom/didi/soda/blocks/widget/image/ImageBinder;", "Lcom/didi/soda/blocks/style/BaseBinder;", "Lcom/didi/soda/blocks/widget/image/RoundedImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "observer", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "getObserver", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "setObserver", "(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V", "originSource", "", "getOriginSource", "()I", "setOriginSource", "(I)V", "placeholder", "", "getPlaceholder", "()Ljava/lang/String;", "setPlaceholder", "(Ljava/lang/String;)V", "src", "getSrc", "setSrc", "bindInterceptedStyles", "", "styles", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bindProps", "props", "createView", "loadImage", "url", "width", "height", "setBorderBottomLeftRadius", "radius", "", "setBorderBottomRightRadius", "setBorderColor", "color", "setBorderRadius", "setBorderStyle", "style", "setBorderTopLeftRadius", "setBorderTopRightRadius", "setBorderWidth", "setContentMode", "resize", "shouldShow", "", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ImageBinder.kt */
public final class ImageBinder extends BaseBinder<RoundedImageView> {
    private ViewTreeObserver.OnPreDrawListener observer;
    private int originSource;
    private String placeholder;
    private String src;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageBinder(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public final ViewTreeObserver.OnPreDrawListener getObserver() {
        return this.observer;
    }

    public final void setObserver(ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        this.observer = onPreDrawListener;
    }

    public final String getSrc() {
        return this.src;
    }

    public final void setSrc(String str) {
        this.src = str;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final void setPlaceholder(String str) {
        this.placeholder = str;
    }

    public final int getOriginSource() {
        return this.originSource;
    }

    public final void setOriginSource(int i) {
        this.originSource = i;
    }

    public RoundedImageView createView(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new RoundedImageView(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.get(com.didi.soda.blocks.constant.Const.BlockParamConst.SRC);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldShow(java.util.HashMap<java.lang.String, java.lang.Object> r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0010
            java.lang.String r0 = "src"
            java.lang.Object r2 = r2.get(r0)
            if (r2 == 0) goto L_0x0010
            java.lang.String r2 = r2.toString()
            goto L_0x0011
        L_0x0010:
            r2 = 0
        L_0x0011:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r2 = r2 ^ 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.widget.image.ImageBinder.shouldShow(java.util.HashMap):boolean");
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        ViewTreeObserver viewTreeObserver;
        String str = null;
        this.src = str;
        this.placeholder = str;
        this.originSource = 0;
        if (this.observer != null) {
            RoundedImageView roundedImageView = (RoundedImageView) getView();
            if (!(roundedImageView == null || (viewTreeObserver = roundedImageView.getViewTreeObserver()) == null)) {
                viewTreeObserver.removeOnPreDrawListener(this.observer);
            }
            this.observer = null;
        }
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                switch (str2.hashCode()) {
                    case -934437708:
                        if (!str2.equals(Const.BlockParamConst.RESIZE)) {
                            break;
                        } else {
                            setContentMode(value.toString());
                            break;
                        }
                    case 114148:
                        if (!str2.equals(Const.BlockParamConst.SRC)) {
                            break;
                        } else {
                            this.src = value.toString();
                            break;
                        }
                    case 598246771:
                        if (!str2.equals(Const.BlockParamConst.PLACEHOLDER)) {
                            break;
                        } else {
                            this.placeholder = value.toString();
                            break;
                        }
                    case 1740934881:
                        if (!str2.equals(Const.BlockParamConst.ORIGIN_SOURCE)) {
                            break;
                        } else {
                            this.originSource = Integer.parseInt(value.toString());
                            break;
                        }
                }
            }
            if (OptimizeController.INSTANCE.isOpenGallery()) {
                this.observer = new ImageBinder$bindProps$$inlined$let$lambda$1(this, hashMap);
                ViewTreeObserver viewTreeObserver2 = ((RoundedImageView) getView()).getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    viewTreeObserver2.addOnPreDrawListener(this.observer);
                }
            } else {
                loadImage(this.src, this.placeholder);
            }
            super.bindProps(hashMap);
        }
    }

    public void bindInterceptedStyles(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                switch (str.hashCode()) {
                    case -1228066334:
                        if (!str.equals(Const.StyleConst.BORDER_TOP_LEFT_RADIUS)) {
                            break;
                        } else {
                            setBorderTopLeftRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -1122140597:
                        if (!str.equals(Const.StyleConst.BORDER_TOP_START_RADIUS)) {
                            break;
                        } else {
                            setBorderTopLeftRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -867333731:
                        if (!str.equals(Const.StyleConst.BORDER_BOTTOM_START_RADIUS)) {
                            break;
                        } else {
                            setBorderBottomLeftRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -483490364:
                        if (!str.equals(Const.StyleConst.BORDER_TOP_END_RADIUS)) {
                            break;
                        } else {
                            setBorderTopRightRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -148030058:
                        if (!str.equals(Const.StyleConst.BORDER_BOTTOM_END_RADIUS)) {
                            break;
                        } else {
                            setBorderBottomRightRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 333432965:
                        if (!str.equals(Const.StyleConst.BORDER_TOP_RIGHT_RADIUS)) {
                            break;
                        } else {
                            setBorderTopRightRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 581268560:
                        if (!str.equals(Const.StyleConst.BORDER_BOTTOM_LEFT_RADIUS)) {
                            break;
                        } else {
                            setBorderBottomLeftRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 588239831:
                        if (!str.equals(Const.StyleConst.BORDER_BOTTOM_RIGHT_RADIUS)) {
                            break;
                        } else {
                            setBorderBottomRightRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 722830999:
                        if (!str.equals("borderColor")) {
                            break;
                        } else {
                            setBorderColor(ColorUtils.parseColor(value.toString()));
                            break;
                        }
                    case 737768677:
                        if (!str.equals(Const.StyleConst.BORDER_STYLE)) {
                            break;
                        } else {
                            setBorderStyle(value.toString());
                            break;
                        }
                    case 741115130:
                        if (!str.equals("borderWidth")) {
                            break;
                        } else {
                            setBorderWidth(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 1349188574:
                        if (!str.equals("borderRadius")) {
                            break;
                        } else {
                            setBorderRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                }
            }
        }
        super.bindInterceptedStyles(hashMap);
    }

    private final void loadImage(String str, String str2) {
        loadImage(str, str2, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    public final void loadImage(String str, String str2, int i, int i2, int i3) {
        ImageRenderUtil.renderImage(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext(), (ImageView) getView(), str, str2, i, i2, i3);
    }

    private final void setContentMode(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.FIT_XY);
                        return;
                    }
                    break;
                case -1008619738:
                    if (str.equals("origin")) {
                        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.CENTER);
                        return;
                    }
                    break;
                case 94852023:
                    if (str.equals("cover")) {
                        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.CENTER_CROP);
                        return;
                    }
                    break;
                case 951526612:
                    if (str.equals("contain")) {
                        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.FIT_CENTER);
                        return;
                    }
                    break;
            }
        }
        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.FIT_XY);
    }

    private final void setBorderWidth(float f) {
        ((RoundedImageView) getView()).setBorderWidth(f);
    }

    private final void setBorderColor(int i) {
        ((RoundedImageView) getView()).setBorderColor(i);
    }

    private final void setBorderStyle(String str) {
        ((RoundedImageView) getView()).setBorderStyle(str);
    }

    private final void setBorderRadius(float f) {
        getMBackgroundHelper().setBorderRadius(f);
        ((RoundedImageView) getView()).setBorderRadius(f);
    }

    private final void setBorderTopLeftRadius(float f) {
        getMBackgroundHelper().setBorderTopLeftRadius(f);
        ((RoundedImageView) getView()).setCornerRadii(getMBackgroundHelper().getBorderRadii());
    }

    private final void setBorderTopRightRadius(float f) {
        getMBackgroundHelper().setBorderTopLeftRadius(f);
        ((RoundedImageView) getView()).setCornerRadii(getMBackgroundHelper().getBorderRadii());
    }

    private final void setBorderBottomRightRadius(float f) {
        getMBackgroundHelper().setBorderBottomRightRadius(f);
        ((RoundedImageView) getView()).setCornerRadii(getMBackgroundHelper().getBorderRadii());
    }

    private final void setBorderBottomLeftRadius(float f) {
        getMBackgroundHelper().setBorderBottomLeftRadius(f);
        ((RoundedImageView) getView()).setCornerRadii(getMBackgroundHelper().getBorderRadii());
    }
}
