package com.didi.drouter.router;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.RouterCallback;
import com.didi.drouter.utils.RouterLogger;
import java.util.WeakHashMap;

public class HolderFragment extends Fragment {

    /* renamed from: a */
    private static final String f21043a = "DRouterEmptyFragment";

    /* renamed from: c */
    private static final WeakHashMap<String, RouterCallback.ActivityCallback> f21044c = new WeakHashMap<>();

    /* renamed from: b */
    private boolean f21045b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f21045b = bundle.getBoolean("attached");
        }
    }

    public static void start(FragmentActivity fragmentActivity, Intent intent, int i, RouterCallback.ActivityCallback activityCallback) {
        HolderFragment holderFragment = new HolderFragment();
        WeakHashMap<String, RouterCallback.ActivityCallback> weakHashMap = f21044c;
        weakHashMap.put(fragmentActivity.hashCode() + "_" + i, activityCallback);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.add((Fragment) holderFragment, f21043a);
        beginTransaction.commit();
        RouterLogger.getCoreLogger().mo63950d("ActivityResult HoldFragment commit attach", new Object[0]);
        supportFragmentManager.executePendingTransactions();
        if (Build.VERSION.SDK_INT >= 16) {
            holderFragment.startActivityForResult(intent, i, intent.getBundleExtra(Extend.START_ACTIVITY_OPTIONS));
        } else {
            holderFragment.startActivityForResult(intent, i);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = getActivity().hashCode() + "_" + i;
        RouterCallback.ActivityCallback activityCallback = f21044c.get(str);
        if (activityCallback != null) {
            RouterLogger.getCoreLogger().mo63950d("ActivityResult callback", new Object[0]);
            activityCallback.onActivityResult(i2, intent);
            f21044c.remove(str);
            return;
        }
        RouterLogger.getCoreLogger().mo63950d("ActivityResult callback fail for host activity destroyed", new Object[0]);
    }

    public void onResume() {
        super.onResume();
        if (this.f21045b) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.commit();
            this.f21045b = false;
            RouterLogger.getCoreLogger().mo63950d("ActivityResult HoldFragment commit remove", new Object[0]);
        }
        this.f21045b = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("attached", this.f21045b);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
