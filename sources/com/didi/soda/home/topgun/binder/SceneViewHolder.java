package com.didi.soda.home.topgun.binder;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.home.topgun.binder.model.SceneComponentModel;
import com.didi.soda.home.topgun.widget.scene.SceneComponentAdapter;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/SceneViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/home/topgun/binder/model/SceneComponentModel;", "itemView", "Landroid/view/View;", "logic", "Lcom/didi/soda/home/topgun/binder/HomeSceneLogic;", "(Landroid/view/View;Lcom/didi/soda/home/topgun/binder/HomeSceneLogic;)V", "adapter", "Lcom/didi/soda/home/topgun/widget/scene/SceneComponentAdapter;", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "bindData", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeSceneBinder.kt */
public final class SceneViewHolder extends ItemViewHolder<SceneComponentModel> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HomeSceneLogic f45255a;

    /* renamed from: b */
    private final SceneComponentAdapter f45256b = new SceneComponentAdapter();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final RecyclerView f45257c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SceneViewHolder(View view, HomeSceneLogic homeSceneLogic) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(homeSceneLogic, "logic");
        this.f45255a = homeSceneLogic;
        View findViewById = view.findViewById(R.id.customer_scene_recycle_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…tomer_scene_recycle_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f45257c = recyclerView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2, 0, false);
        Unit unit = Unit.INSTANCE;
        recyclerView.setLayoutManager(gridLayoutManager);
        this.f45257c.setAdapter(this.f45256b);
        this.f45257c.addItemDecoration(new C14762b());
        this.f45257c.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            final /* synthetic */ SceneViewHolder this$0;

            {
                this.this$0 = r1;
            }

            public void onViewAttachedToWindow(View view) {
                RecyclerView.LayoutManager layoutManager;
                if (this.this$0.getItem() != null && ((SceneComponentModel) this.this$0.getItem()).getState() != null && (layoutManager = this.this$0.f45257c.getLayoutManager()) != null) {
                    layoutManager.onRestoreInstanceState(((SceneComponentModel) this.this$0.getItem()).getState());
                }
            }

            public void onViewDetachedFromWindow(View view) {
                if (this.this$0.getItem() != null) {
                    SceneComponentModel sceneComponentModel = (SceneComponentModel) this.this$0.getItem();
                    RecyclerView.LayoutManager layoutManager = this.this$0.f45257c.getLayoutManager();
                    sceneComponentModel.setState(layoutManager == null ? null : layoutManager.onSaveInstanceState());
                }
            }
        });
    }

    public final void bindData() {
        if (((SceneComponentModel) getItem()).getState() == null) {
            this.f45257c.scrollToPosition(0);
        }
        this.f45256b.setOnItemClickListener(new SceneViewHolder$bindData$1(this));
        this.f45256b.setOnItemBindListener(new SceneViewHolder$bindData$2(this));
        this.f45256b.getDataSource().clear();
        this.f45256b.getDataSource().addAll(((SceneComponentModel) getItem()).getItems());
        this.f45256b.notifyDataSetChanged();
    }
}
