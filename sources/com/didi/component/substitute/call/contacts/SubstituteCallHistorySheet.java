package com.didi.component.substitute.call.contacts;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.substitute.call.widget.HistoryContactsAdapter;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.travel.psnger.model.response.estimate.daijiao.AddAnother;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001aH\u0014J\"\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001aH\u0016J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, mo148868d2 = {"Lcom/didi/component/substitute/call/contacts/SubstituteCallHistorySheet;", "Lcom/didi/sdk/view/SimplePopupBase;", "()V", "mAdapter", "Lcom/didi/component/substitute/call/widget/HistoryContactsAdapter;", "mAddAnother", "Landroid/widget/TextView;", "mAddAnotherImage", "Landroid/widget/ImageView;", "mAddAnotherLayout", "Landroid/view/View;", "mBottomBtn", "mCloseImg", "mHistoryList", "Landroidx/recyclerview/widget/RecyclerView;", "mManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mModel", "Lcom/didi/travel/psnger/model/response/estimate/daijiao/SubstituteCallModel;", "mRefreshNumLis", "Lcom/didi/component/core/event/BaseEventPublisher$OnEventListener;", "Lcom/didi/component/core/event/BaseEventPublisher$NullEvent;", "mShadow", "mSubTitle", "mTitle", "bindData", "", "canScroll", "", "getLayout", "", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "refreshAnother", "setShadowVisible", "Companion", "comp-substitute-call_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SubstituteCallHistorySheet.kt */
public final class SubstituteCallHistorySheet extends SimplePopupBase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private SubstituteCallModel f17947a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HistoryContactsAdapter f17948b;

    /* renamed from: c */
    private ImageView f17949c;

    /* renamed from: d */
    private TextView f17950d;

    /* renamed from: e */
    private TextView f17951e;

    /* renamed from: f */
    private RecyclerView f17952f;

    /* renamed from: g */
    private View f17953g;

    /* renamed from: h */
    private ImageView f17954h;

    /* renamed from: i */
    private TextView f17955i;

    /* renamed from: j */
    private TextView f17956j;

    /* renamed from: k */
    private View f17957k;

    /* renamed from: l */
    private LinearLayoutManager f17958l;

    /* renamed from: m */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17959m = new SubstituteCallHistorySheet$mRefreshNumLis$1(this);

    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.substitute_call_history_contacts_layout;
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/component/substitute/call/contacts/SubstituteCallHistorySheet$Companion;", "", "()V", "newInstance", "Lcom/didi/component/substitute/call/contacts/SubstituteCallHistorySheet;", "comp-substitute-call_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SubstituteCallHistorySheet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SubstituteCallHistorySheet newInstance() {
            return new SubstituteCallHistorySheet();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setCanceledOnTouchOutside(false);
        return onCreateDialog;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Confirm.EVENT_SUBSTITUTE_CALL_REFRESH_HISTORY_NUM, this.f17959m, BaseEventPublisher.NullEvent.class);
    }

    public void onDetach() {
        super.onDetach();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Confirm.EVENT_SUBSTITUTE_CALL_REFRESH_HISTORY_NUM, this.f17959m, BaseEventPublisher.NullEvent.class);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.s_call_close_img);
        this.f17949c = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new SubstituteCallHistorySheet$initView$1(this));
        }
        this.f17950d = (TextView) this.mRootView.findViewById(R.id.s_call_title);
        this.f17951e = (TextView) this.mRootView.findViewById(R.id.s_call_sub_title);
        this.f17957k = this.mRootView.findViewById(R.id.s_call_shadow);
        this.f17952f = (RecyclerView) this.mRootView.findViewById(R.id.s_call_history_list);
        HistoryContactsAdapter historyContactsAdapter = new HistoryContactsAdapter(getContext());
        this.f17948b = historyContactsAdapter;
        if (historyContactsAdapter != null) {
            historyContactsAdapter.setCallback$comp_substitute_call_release(new SubstituteCallHistorySheet$initView$2(this));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.f17958l = linearLayoutManager;
        RecyclerView recyclerView = this.f17952f;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        this.f17953g = this.mRootView.findViewById(R.id.s_call_add_another_layout);
        this.f17954h = (ImageView) this.mRootView.findViewById(R.id.s_call_add_another_image);
        this.f17955i = (TextView) this.mRootView.findViewById(R.id.s_call_add_another);
        View view = this.f17953g;
        if (view != null) {
            view.setOnClickListener(new SubstituteCallHistorySheet$initView$3(this));
        }
        TextView textView = this.f17956j;
        if (textView != null) {
            textView.setOnClickListener(SubstituteCallHistorySheet$initView$4.INSTANCE);
        }
        m15235a();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            dismiss();
        }
    }

    /* renamed from: a */
    private final void m15235a() {
        SubstituteCallModel substituteCallModel = FormStore.getInstance().getSubstituteCallModel();
        if (substituteCallModel != null) {
            LEGORichInfo title = substituteCallModel.getTitle();
            if (title != null) {
                title.bindTextView(this.f17950d);
            }
            LEGORichInfo content = substituteCallModel.getContent();
            if (content != null) {
                content.bindTextView(this.f17951e);
            }
            List<FriendItem> friendItems = substituteCallModel.getFriendItems();
            if (friendItems != null) {
                FriendItem selectedFriend = FormStore.getInstance().getSelectedFriend();
                if (selectedFriend != null) {
                    for (FriendItem next : friendItems) {
                        if (next.isSelected() == 1 && next.getFriendId() != selectedFriend.getFriendId()) {
                            next.setSelected(0);
                        }
                        if (next.getFriendId() == selectedFriend.getFriendId()) {
                            next.setSelected(1);
                        }
                    }
                }
                RecyclerView recyclerView = this.f17952f;
                if (recyclerView != null) {
                    recyclerView.setAdapter(this.f17948b);
                }
                HistoryContactsAdapter historyContactsAdapter = this.f17948b;
                if (historyContactsAdapter != null) {
                    historyContactsAdapter.setData(friendItems);
                }
                UIThreadHandler.post(new SubstituteCallHistorySheet$bindData$1$1$2(this), 200);
            }
            m15238d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m15236b() {
        if (m15237c()) {
            View view = this.f17957k;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.f17957k;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    /* renamed from: c */
    private final boolean m15237c() {
        HistoryContactsAdapter historyContactsAdapter = this.f17948b;
        if (historyContactsAdapter != null && historyContactsAdapter.getItemCount() < 1) {
            return false;
        }
        LinearLayoutManager linearLayoutManager = this.f17958l;
        Integer num = null;
        Integer valueOf = linearLayoutManager == null ? null : Integer.valueOf(linearLayoutManager.findLastCompletelyVisibleItemPosition());
        HistoryContactsAdapter historyContactsAdapter2 = this.f17948b;
        if (historyContactsAdapter2 != null) {
            num = Integer.valueOf(historyContactsAdapter2.getItemCount() - 1);
        }
        return !Intrinsics.areEqual((Object) valueOf, (Object) num);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m15238d() {
        AddAnother addAnother;
        ImageView imageView;
        SubstituteCallModel substituteCallModel = FormStore.getInstance().getSubstituteCallModel();
        if (substituteCallModel != null && (addAnother = substituteCallModel.getAddAnother()) != null) {
            Context context = getContext();
            if (!(context == null || (imageView = this.f17954h) == null)) {
                Glide.with(context).load(addAnother.getIcon()).into(imageView);
            }
            LEGORichInfo title = addAnother.getTitle();
            if (title != null) {
                title.bindTextView(this.f17955i);
            }
        }
    }
}
