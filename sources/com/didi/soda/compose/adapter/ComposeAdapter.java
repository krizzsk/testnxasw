package com.didi.soda.compose.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.compose.card.BaseCard;
import com.didi.soda.compose.log.ComposeLogUtil;
import com.didi.soda.compose.pool.CardsPool;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 %2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\bJ\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\bJ\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u001e\u0010 \u001a\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0016\u0010#\u001a\u00020\u00142\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0014\u0010$\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo148868d2 = {"Lcom/didi/soda/compose/adapter/ComposeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/soda/compose/adapter/ItemCardHolder;", "Lcom/didi/soda/compose/card/BaseCard;", "cardsPool", "Lcom/didi/soda/compose/pool/CardsPool;", "(Lcom/didi/soda/compose/pool/CardsPool;)V", "mCards", "Ljava/util/LinkedList;", "mCardsPool", "mId2Types", "Landroid/util/SparseArray;", "", "mLayoutTypes", "mTypeId", "Ljava/util/concurrent/atomic/AtomicInteger;", "mViewTypes", "Ljava/util/concurrent/ConcurrentHashMap;", "", "appendData", "", "cards", "createBinderViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getCellTemplate", "getData", "getItemCount", "getItemViewType", "position", "getLayoutType", "onBindViewHolder", "holder", "onCreateViewHolder", "onViewRecycled", "setData", "Companion", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ComposeAdapter.kt */
public final class ComposeAdapter extends RecyclerView.Adapter<ItemCardHolder<BaseCard>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "ComposeAdapter";

    /* renamed from: a */
    private LinkedList<BaseCard> f42676a = new LinkedList<>();

    /* renamed from: b */
    private final ConcurrentHashMap<String, Integer> f42677b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private final SparseArray<String> f42678c = new SparseArray<>(64);

    /* renamed from: d */
    private final SparseArray<String> f42679d = new SparseArray<>(64);

    /* renamed from: e */
    private final AtomicInteger f42680e = new AtomicInteger(0);

    /* renamed from: f */
    private CardsPool f42681f;

    public ComposeAdapter(CardsPool cardsPool) {
        Intrinsics.checkParameterIsNotNull(cardsPool, "cardsPool");
        this.f42681f = cardsPool;
    }

    public ItemCardHolder<BaseCard> onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return m32023a(viewGroup, i);
    }

    public void onViewRecycled(ItemCardHolder<BaseCard> itemCardHolder) {
        Intrinsics.checkParameterIsNotNull(itemCardHolder, "holder");
        super.onViewRecycled(itemCardHolder);
    }

    /* renamed from: a */
    private final ItemCardHolder<BaseCard> m32023a(ViewGroup viewGroup, int i) {
        String a = m32024a(i);
        String b = m32025b(i);
        ItemCard<?, ItemCardHolder<BaseCard>> itemCard = this.f42681f.getItemCard(a);
        ComposeLogUtil.m32030i(TAG, "cellTemplate = " + a + ",layoutType = " + b + ",itemCard = " + itemCard);
        if (itemCard == null) {
            return new ItemCardHolder<>(new Space(viewGroup.getContext()));
        }
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkExpressionValueIsNotNull(from, "LayoutInflater.from(parent.context)");
        ItemCardHolder<BaseCard> create = itemCard.create(from, viewGroup);
        create.init(b);
        return create;
    }

    public void onBindViewHolder(ItemCardHolder<BaseCard> itemCardHolder, int i) {
        Intrinsics.checkParameterIsNotNull(itemCardHolder, "holder");
        String mTemplate = this.f42676a.get(i).getMTemplate();
        if (mTemplate != null) {
            ItemCard<?, ItemCardHolder<BaseCard>> itemCard = this.f42681f.getItemCard(mTemplate);
            BaseCard baseCard = this.f42676a.get(i);
            Intrinsics.checkExpressionValueIsNotNull(baseCard, "mCards[position]");
            BaseCard baseCard2 = baseCard;
            baseCard2.setMPosition(i);
            if (itemCard != null) {
                itemCard.bindViewHolder(itemCardHolder, baseCard2);
            }
        }
    }

    public int getItemViewType(int i) {
        BaseCard baseCard = this.f42676a.get(i);
        Intrinsics.checkExpressionValueIsNotNull(baseCard, "mCards[position]");
        BaseCard baseCard2 = baseCard;
        String mTemplate = baseCard2.getMTemplate();
        if (mTemplate != null && !this.f42677b.containsKey(mTemplate)) {
            int andIncrement = this.f42680e.getAndIncrement();
            this.f42677b.put(mTemplate, Integer.valueOf(andIncrement));
            this.f42678c.put(andIncrement, baseCard2.getMLayoutType());
            this.f42679d.put(andIncrement, mTemplate);
            ComposeLogUtil.m32030i(TAG, "type = " + mTemplate + ",newType = " + andIncrement + ", mLayoutType = " + baseCard2 + ".mLayoutType");
        }
        Object obj = this.f42677b.get(mTemplate);
        if (obj == null) {
            Intrinsics.throwNpe();
        }
        return ((Number) obj).intValue();
    }

    public int getItemCount() {
        return this.f42676a.size();
    }

    public final void setData(LinkedList<BaseCard> linkedList) {
        Intrinsics.checkParameterIsNotNull(linkedList, "cards");
        if (!this.f42676a.isEmpty()) {
            this.f42676a.clear();
        }
        this.f42676a.addAll(linkedList);
        notifyItemRangeChanged(0, this.f42676a.size());
    }

    public final void appendData(LinkedList<BaseCard> linkedList) {
        Intrinsics.checkParameterIsNotNull(linkedList, "cards");
        this.f42676a.addAll(linkedList);
        notifyItemInserted(this.f42676a.size());
    }

    public final LinkedList<BaseCard> getData() {
        return this.f42676a;
    }

    /* renamed from: a */
    private final String m32024a(int i) {
        if (this.f42679d.indexOfKey(i) >= 0) {
            String str = this.f42679d.get(i);
            Intrinsics.checkExpressionValueIsNotNull(str, "mId2Types[viewType]");
            return str;
        }
        throw new IllegalStateException(("Can not found item.template for viewType: " + i).toString());
    }

    /* renamed from: b */
    private final String m32025b(int i) {
        if (this.f42678c.indexOfKey(i) >= 0) {
            String str = this.f42678c.get(i);
            Intrinsics.checkExpressionValueIsNotNull(str, "mLayoutTypes[viewType]");
            return str;
        }
        throw new IllegalStateException(("Can not found layout.type for viewType: " + i).toString());
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/soda/compose/adapter/ComposeAdapter$Companion;", "", "()V", "TAG", "", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: ComposeAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
