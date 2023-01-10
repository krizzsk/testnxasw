package com.didi.global.fintech.cashier.p118ui.viewholder;

import android.animation.LayoutTransition;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierCardChannelViewHolder;
import com.didi.global.fintech.cashier.p118ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.GlobalCashierAllMethodItemViewHolder;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.GlobalCashierItemViewHolderFactory;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\"0&H\u0016J\b\u0010(\u001a\u00020\"H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\"H\u0016J+\u0010,\u001a\u00020\"2\b\u0010-\u001a\u0004\u0018\u00010$2\b\u0010.\u001a\u0004\u0018\u00010$2\b\u0010/\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0002\u00100J,\u00101\u001a\u00020\"2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020'\u0018\u0001032\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\"0&H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00065"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCardChannelViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "allMethodHolder", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierAllMethodItemViewHolder;", "containerView", "iconConta99", "Landroid/widget/ImageView;", "getIconConta99", "()Landroid/widget/ImageView;", "setIconConta99", "(Landroid/widget/ImageView;)V", "iconGroup", "getIconGroup", "setIconGroup", "itemViewHolders", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/GlobalCashierBaseItemViewHolder;", "getItemViewHolders", "()Ljava/util/List;", "setItemViewHolders", "(Ljava/util/List;)V", "nameGroup", "Landroid/widget/TextView;", "getNameGroup", "()Landroid/widget/TextView;", "setNameGroup", "(Landroid/widget/TextView;)V", "appendSpreadItem", "", "groupName", "", "click", "Lkotlin/Function1;", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "initView", "layout", "", "removeSpreadItem", "updateHeader", "name", "icon", "iconType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "updateItems", "items", "", "Companion", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierCardChannelViewHolder */
/* compiled from: GlobalCashierCardChannelViewHolder.kt */
public final class GlobalCashierCardChannelViewHolder extends GlobalCashierBaseViewHolder implements IGlobalCashierCardChannelViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ViewGroup f23698a;

    /* renamed from: b */
    private GlobalCashierAllMethodItemViewHolder f23699b;

    /* renamed from: c */
    private List<GlobalCashierBaseItemViewHolder> f23700c = new ArrayList();
    public ImageView iconConta99;
    public ImageView iconGroup;
    public TextView nameGroup;

    public int layout() {
        return R.layout.viewholder_global_cashier_card_channel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierCardChannelViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCardChannelViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCardChannelViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierCardChannelViewHolder$Companion */
    /* compiled from: GlobalCashierCardChannelViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierCardChannelViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierCardChannelViewHolder(context, viewGroup);
        }
    }

    public final ImageView getIconGroup() {
        ImageView imageView = this.iconGroup;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iconGroup");
        return null;
    }

    public final void setIconGroup(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.iconGroup = imageView;
    }

    public final ImageView getIconConta99() {
        ImageView imageView = this.iconConta99;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iconConta99");
        return null;
    }

    public final void setIconConta99(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.iconConta99 = imageView;
    }

    public final TextView getNameGroup() {
        TextView textView = this.nameGroup;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nameGroup");
        return null;
    }

    public final void setNameGroup(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.nameGroup = textView;
    }

    public final List<GlobalCashierBaseItemViewHolder> getItemViewHolders() {
        return this.f23700c;
    }

    public final void setItemViewHolders(List<GlobalCashierBaseItemViewHolder> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f23700c = list;
    }

    public void initView() {
        super.initView();
        View findViewById = getMRootView().findViewById(R.id.card_channel_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R…d.card_channel_container)");
        this.f23698a = (ViewGroup) findViewById;
        View findViewById2 = getMRootView().findViewById(R.id.icon_group);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.icon_group)");
        setIconGroup((ImageView) findViewById2);
        View findViewById3 = getMRootView().findViewById(R.id.name_group);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.name_group)");
        setNameGroup((TextView) findViewById3);
        View findViewById4 = getMRootView().findViewById(R.id.icon_group_conta_99);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.icon_group_conta_99)");
        setIconConta99((ImageView) findViewById4);
        ViewGroup viewGroup = this.f23698a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            viewGroup = null;
        }
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(2, 1000);
        Unit unit = Unit.INSTANCE;
        viewGroup.setLayoutTransition(layoutTransition);
    }

    public void updateHeader(String str, String str2, Integer num) {
        if (num == null || num.intValue() != 2) {
            ViewKtxKt.content(getNameGroup(), str);
            ViewKtxKt.load(getIconGroup(), str2);
            getIconConta99().setVisibility(8);
            getIconGroup().setVisibility(0);
            getNameGroup().setVisibility(0);
            return;
        }
        getIconConta99().setVisibility(0);
        getIconGroup().setVisibility(8);
        getNameGroup().setVisibility(8);
        ViewKtxKt.load(getIconConta99(), str2);
    }

    public void updateItems(List<ChannelItemViewHolderData> list, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        GlobalCashierBaseItemViewHolder globalCashierBaseItemViewHolder;
        ChannelItemViewHolderData channelItemViewHolderData;
        Intrinsics.checkNotNullParameter(function1, "click");
        Iterator it = this.f23700c.iterator();
        int i = 0;
        while (true) {
            GlobalCashierBaseItemViewHolder.ViewType viewType = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            GlobalCashierBaseItemViewHolder globalCashierBaseItemViewHolder2 = (GlobalCashierBaseItemViewHolder) next;
            if (i < (list == null ? 0 : list.size())) {
                if (!(list == null || (channelItemViewHolderData = list.get(i)) == null)) {
                    viewType = channelItemViewHolderData.getViewType();
                }
                if (viewType == globalCashierBaseItemViewHolder2.viewType()) {
                    i = i2;
                }
            }
            globalCashierBaseItemViewHolder2.detach();
            i = i2;
        }
        int size = this.f23700c.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                if (!this.f23700c.get(size).getAttached()) {
                    this.f23700c.remove(size);
                }
                if (i3 < 0) {
                    break;
                }
                size = i3;
            }
        }
        if (list != null) {
            int i4 = 0;
            for (Object next2 : list) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ChannelItemViewHolderData channelItemViewHolderData2 = (ChannelItemViewHolderData) next2;
                if (getItemViewHolders().size() <= i4) {
                    GlobalCashierItemViewHolderFactory globalCashierItemViewHolderFactory = GlobalCashierItemViewHolderFactory.INSTANCE;
                    GlobalCashierBaseItemViewHolder.ViewType viewType2 = channelItemViewHolderData2.getViewType();
                    Context context = getContext();
                    ViewGroup viewGroup = this.f23698a;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        viewGroup = null;
                    }
                    globalCashierBaseItemViewHolder = globalCashierItemViewHolderFactory.newInstance(viewType2, context, viewGroup, function1);
                    GlobalCashierBaseViewHolder.attach$default(globalCashierBaseItemViewHolder, 0, 1, (Object) null);
                    getItemViewHolders().add(globalCashierBaseItemViewHolder);
                } else if (getItemViewHolders().get(i4).viewType() == channelItemViewHolderData2.getViewType()) {
                    globalCashierBaseItemViewHolder = getItemViewHolders().get(i4);
                } else {
                    getItemViewHolders().get(i4).detach();
                    GlobalCashierItemViewHolderFactory globalCashierItemViewHolderFactory2 = GlobalCashierItemViewHolderFactory.INSTANCE;
                    GlobalCashierBaseItemViewHolder.ViewType viewType3 = channelItemViewHolderData2.getViewType();
                    Context context2 = getContext();
                    ViewGroup viewGroup2 = this.f23698a;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        viewGroup2 = null;
                    }
                    GlobalCashierBaseItemViewHolder newInstance = globalCashierItemViewHolderFactory2.newInstance(viewType3, context2, viewGroup2, function1);
                    newInstance.attach(i4);
                    getItemViewHolders().set(i4, newInstance);
                    globalCashierBaseItemViewHolder = newInstance;
                }
                globalCashierBaseItemViewHolder.bindData(channelItemViewHolderData2);
                i4 = i5;
            }
        }
    }

    public void appendSpreadItem(String str, Function1<? super ChannelItemViewHolderData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "click");
        GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder = this.f23699b;
        if (globalCashierAllMethodItemViewHolder == null) {
            GlobalCashierItemViewHolderFactory globalCashierItemViewHolderFactory = GlobalCashierItemViewHolderFactory.INSTANCE;
            GlobalCashierBaseItemViewHolder.ViewType viewType = GlobalCashierBaseItemViewHolder.ViewType.AllMethod;
            Context context = getContext();
            ViewGroup viewGroup = this.f23698a;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                viewGroup = null;
            }
            GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder2 = (GlobalCashierAllMethodItemViewHolder) globalCashierItemViewHolderFactory.newInstance(viewType, context, viewGroup, function1);
            this.f23699b = globalCashierAllMethodItemViewHolder2;
            if (globalCashierAllMethodItemViewHolder2 != null) {
                GlobalCashierBaseViewHolder.attach$default(globalCashierAllMethodItemViewHolder2, 0, 1, (Object) null);
            }
            GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder3 = this.f23699b;
            if (globalCashierAllMethodItemViewHolder3 != null) {
                ChannelItemViewHolderData all_method = ChannelItemViewHolderData.Companion.getALL_METHOD();
                all_method.setContent(str);
                Unit unit = Unit.INSTANCE;
                globalCashierAllMethodItemViewHolder3.bindData(all_method);
                return;
            }
            return;
        }
        if (globalCashierAllMethodItemViewHolder != null) {
            globalCashierAllMethodItemViewHolder.detach();
        }
        GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder4 = this.f23699b;
        if (globalCashierAllMethodItemViewHolder4 != null) {
            GlobalCashierBaseViewHolder.attach$default(globalCashierAllMethodItemViewHolder4, 0, 1, (Object) null);
        }
    }

    public void removeSpreadItem() {
        GlobalCashierAllMethodItemViewHolder globalCashierAllMethodItemViewHolder = this.f23699b;
        if (globalCashierAllMethodItemViewHolder != null) {
            globalCashierAllMethodItemViewHolder.detach();
        }
        this.f23699b = null;
    }
}
