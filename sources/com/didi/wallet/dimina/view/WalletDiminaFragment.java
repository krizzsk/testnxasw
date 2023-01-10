package com.didi.wallet.dimina.view;

import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.commoninterfacelib.permission.TheOneBaseFragment;
import com.didi.payment.base.router.CodeScan;
import com.didi.wallet.dimina.DiminaLaunchModel;
import com.didi.wallet.dimina.DiminaWalletModule;
import com.taxis99.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(mo148867d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006$"}, mo148868d2 = {"Lcom/didi/wallet/dimina/view/WalletDiminaFragment;", "Lcom/didi/commoninterfacelib/permission/TheOneBaseFragment;", "Landroid/view/KeyEvent$Callback;", "()V", "diminaLaunchModel", "Lcom/didi/wallet/dimina/DiminaLaunchModel;", "getDiminaLaunchModel", "()Lcom/didi/wallet/dimina/DiminaLaunchModel;", "diminaLaunchModel$delegate", "Lkotlin/Lazy;", "onAccessBlock", "", "event", "Lcom/didi/payment/base/router/CodeScan;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onKeyDown", "", "p0", "", "p1", "Landroid/view/KeyEvent;", "onKeyLongPress", "onKeyMultiple", "p2", "onKeyUp", "onViewCreated", "view", "Companion", "wallet-service-dimina_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletDiminaFragment.kt */
public final class WalletDiminaFragment extends TheOneBaseFragment implements KeyEvent.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIMINA_ROUTER_URL = "DIMINA_ROUTER_URL";
    public static final String IS_NEED_FINISH_ACTIVITY = "IS_NEED_FINISH_ACTIVITY";

    /* renamed from: a */
    private final Lazy f47837a = LazyKt.lazy(new WalletDiminaFragment$diminaLaunchModel$2(this));

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    @Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/wallet/dimina/view/WalletDiminaFragment$Companion;", "", "()V", "DIMINA_ROUTER_URL", "", "IS_NEED_FINISH_ACTIVITY", "newInstance", "Lcom/didi/wallet/dimina/view/WalletDiminaFragment;", "url", "isNeedFinishActivity", "", "wallet-service-dimina_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletDiminaFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ WalletDiminaFragment newInstance$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.newInstance(str, z);
        }

        public final WalletDiminaFragment newInstance(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "url");
            WalletDiminaFragment walletDiminaFragment = new WalletDiminaFragment();
            Uri.parse(str);
            Bundle bundle = new Bundle();
            bundle.putBoolean(WalletDiminaFragment.IS_NEED_FINISH_ACTIVITY, z);
            bundle.putString(WalletDiminaFragment.DIMINA_ROUTER_URL, str);
            walletDiminaFragment.setArguments(bundle);
            return walletDiminaFragment;
        }
    }

    /* renamed from: a */
    private final DiminaLaunchModel m35941a() {
        return (DiminaLaunchModel) this.f47837a.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        EventBus.getDefault().register(this);
        return layoutInflater.inflate(R.layout.frag_wallet_dimina, viewGroup, false);
    }

    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAccessBlock(CodeScan codeScan) {
        Intrinsics.checkNotNullParameter(codeScan, "event");
        DiminaWalletModule.callbackFromScan(codeScan);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        m35941a().launchDimina(bundle);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!(keyEvent != null && keyEvent.getKeyCode() == 4)) {
            return false;
        }
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        if (!(!fragments.isEmpty())) {
            return false;
        }
        Fragment fragment = fragments.get(fragments.size() - 1);
        if (fragment instanceof KeyEvent.Callback) {
            return ((KeyEvent.Callback) fragment).onKeyUp(i, keyEvent);
        }
        return false;
    }
}
