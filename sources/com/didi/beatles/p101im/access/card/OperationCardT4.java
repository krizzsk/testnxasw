package com.didi.beatles.p101im.access.card;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.beatles.p101im.access.msg.OperationMsgT4;
import com.didi.beatles.p101im.access.style.custom.msgcard.IMMsgCardCusView;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.KotlinExtKt;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.messageCard.IMBaseRenderView;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/beatles/im/access/card/OperationCardT4;", "T", "Lcom/didi/beatles/im/access/style/custom/msgcard/IMMsgCardCusView;", "Lcom/didi/beatles/im/views/messageCard/IMBaseRenderView;", "context", "Landroid/content/Context;", "adapter", "Lcom/didi/beatles/im/adapter/MessageAdapter;", "(Landroid/content/Context;Lcom/didi/beatles/im/adapter/MessageAdapter;)V", "mDecorateIcon", "Landroid/widget/ImageView;", "mLeftIcon", "mSubTitle", "Landroid/widget/TextView;", "mTitleTv", "msgContent", "Lcom/didi/beatles/im/access/msg/OperationMsgT4;", "onFindViewById", "", "onInflatView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "onSetUpView", "imMessage", "Lcom/didi/beatles/im/module/entity/IMMessage;", "onUpdateView", "onViewClick", "im_library_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* renamed from: com.didi.beatles.im.access.card.OperationCardT4 */
/* compiled from: OperationCardT4.kt */
public final class OperationCardT4<T extends IMMsgCardCusView> extends IMBaseRenderView<T> {

    /* renamed from: a */
    private TextView f10572a;

    /* renamed from: b */
    private ImageView f10573b;

    /* renamed from: c */
    private ImageView f10574c;

    /* renamed from: d */
    private TextView f10575d;

    /* renamed from: e */
    private OperationMsgT4 f10576e;

    /* renamed from: f */
    private HashMap f10577f;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f10577f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f10577f == null) {
            this.f10577f = new HashMap();
        }
        View view = (View) this.f10577f.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f10577f.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OperationCardT4(Context context, MessageAdapter messageAdapter) {
        super(context, 1, messageAdapter);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(messageAdapter, "adapter");
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        View inflate = this.inflater.inflate(R.layout.onemessage_operation_card_template4, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "inflater.inflate(R.layou…template4, parent, false)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10572a = (TextView) findViewById(R.id.title_tv);
        this.f10573b = (ImageView) findViewById(R.id.left_icon);
        this.f10575d = (TextView) findViewById(R.id.sub_title_tv);
        this.f10574c = (ImageView) findViewById(R.id.decorate_icon);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        OperationMsgT4 operationMsgT4;
        IMMessage iMMessage2 = this.message;
        Intrinsics.checkExpressionValueIsNotNull(iMMessage2, "message");
        this.f10576e = (OperationMsgT4) IMJsonUtil.objectFromJson(iMMessage2.getContent(), OperationMsgT4.class);
        ImageView imageView = this.f10573b;
        String str = null;
        ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
        OperationMsgT4 operationMsgT42 = this.f10576e;
        if ((operationMsgT42 == null || operationMsgT42.getImageWidth() != 0) && ((operationMsgT4 = this.f10576e) == null || operationMsgT4.getImageHeight() != 0)) {
            if (layoutParams != null) {
                OperationMsgT4 operationMsgT43 = this.f10576e;
                layoutParams.height = (operationMsgT43 != null ? Integer.valueOf(operationMsgT43.getImageHeight()) : null).intValue();
            }
            if (layoutParams != null) {
                OperationMsgT4 operationMsgT44 = this.f10576e;
                layoutParams.width = (operationMsgT44 != null ? Integer.valueOf(operationMsgT44.getImageWidth()) : null).intValue();
            }
        } else {
            if (layoutParams != null) {
                layoutParams.height = KotlinExtKt.dp2px(40);
            }
            if (layoutParams != null) {
                layoutParams.width = KotlinExtKt.dp2px(40);
            }
        }
        ImageView imageView2 = this.f10573b;
        if (imageView2 != null) {
            imageView2.setLayoutParams(layoutParams);
        }
        BtsImageLoader instance = BtsImageLoader.getInstance();
        OperationMsgT4 operationMsgT45 = this.f10576e;
        instance.loadInto(operationMsgT45 != null ? operationMsgT45.getImage() : null, this.f10573b);
        BtsImageLoader instance2 = BtsImageLoader.getInstance();
        OperationMsgT4 operationMsgT46 = this.f10576e;
        instance2.loadInto(operationMsgT46 != null ? operationMsgT46.getImageDecorate() : null, this.f10574c);
        OperationMsgT4 operationMsgT47 = this.f10576e;
        CharSequence title = operationMsgT47 != null ? operationMsgT47.getTitle() : null;
        boolean z = true;
        if (!(title == null || title.length() == 0) && (Intrinsics.areEqual((Object) title, (Object) "null") ^ true)) {
            TextView textView = this.f10572a;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.f10572a;
            if (textView2 != null) {
                OperationMsgT4 operationMsgT48 = this.f10576e;
                textView2.setText(operationMsgT48 != null ? operationMsgT48.getTitle() : null);
            }
        } else {
            TextView textView3 = this.f10572a;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        OperationMsgT4 operationMsgT49 = this.f10576e;
        CharSequence content = operationMsgT49 != null ? operationMsgT49.getContent() : null;
        if ((content == null || content.length() == 0) || !(!Intrinsics.areEqual((Object) content, (Object) "null"))) {
            z = false;
        }
        if (z) {
            TextView textView4 = this.f10575d;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            TextView textView5 = this.f10575d;
            if (textView5 != null) {
                OperationMsgT4 operationMsgT410 = this.f10576e;
                if (operationMsgT410 != null) {
                    str = operationMsgT410.getContent();
                }
                textView5.setText(str);
                return;
            }
            return;
        }
        TextView textView6 = this.f10575d;
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
    }
}
