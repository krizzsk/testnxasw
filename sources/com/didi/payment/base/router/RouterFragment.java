package com.didi.payment.base.router;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.didi.payment.base.router.ActivityLauncher;
import java.util.Random;

public class RouterFragment extends Fragment {

    /* renamed from: a */
    private SparseArray<ActivityLauncher.Callback> f32388a = new SparseArray<>();

    /* renamed from: b */
    private Random f32389b = new Random();

    public static RouterFragment newInstance() {
        return new RouterFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void startActivityForResult(Intent intent, ActivityLauncher.Callback callback) {
        int a = m24593a();
        this.f32388a.put(a, callback);
        startActivityForResult(intent, a);
    }

    /* renamed from: a */
    private int m24593a() {
        int nextInt;
        int i = 0;
        do {
            nextInt = this.f32389b.nextInt(65535);
            i++;
            if (this.f32388a.indexOfKey(nextInt) < 0 || i >= 10) {
                return nextInt;
            }
            nextInt = this.f32389b.nextInt(65535);
            i++;
            break;
        } while (i >= 10);
        return nextInt;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ActivityLauncher.Callback callback = this.f32388a.get(i);
        this.f32388a.remove(i);
        if (callback != null) {
            callback.onActivityResult(i2, intent);
        }
    }
}
