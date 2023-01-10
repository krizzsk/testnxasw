package com.didi.zxing.barcodescanner.store;

import android.content.Context;
import com.didi.sdk.dependency.ConstantHolder;
import com.didi.sdk.dependency.ConstantListener;
import com.didi.sdk.store.BaseStore;
import java.util.ArrayList;
import java.util.Collections;

public class DqrStore extends BaseStore {

    /* renamed from: a */
    private static final String f48108a = "DQR-Store";

    /* renamed from: b */
    private static volatile DqrStore f48109b;

    public static DqrStore getInstance() {
        if (f48109b == null) {
            synchronized (DqrStore.class) {
                if (f48109b == null) {
                    ConstantListener constantListener = ConstantHolder.getInstance().getConstantListener();
                    final ArrayList arrayList = new ArrayList();
                    if (constantListener != null) {
                        Collections.addAll(arrayList, ConstantHolder.getInstance().getConstantListener().getBusinessIds());
                    }
                    arrayList.add(f48108a);
                    ConstantHolder.getInstance().setConstantListener(new ConstantListener() {
                        public String[] getBusinessIds() {
                            ArrayList arrayList = arrayList;
                            return (String[]) arrayList.toArray(new String[arrayList.size()]);
                        }
                    });
                    f48109b = new DqrStore();
                }
            }
        }
        return f48109b;
    }

    private DqrStore() {
        super(f48108a);
    }

    public int getInt(Context context, String str, int i) {
        try {
            return Integer.valueOf(getString(context, str, i + "")).intValue();
        } catch (Exception unused) {
            return i;
        }
    }

    public void putAndSave(Context context, String str, int i) {
        super.putAndSave(context, str, i + "");
    }

    public String getString(Context context, String str, String str2) {
        Object inner = getInner(context, str);
        if (inner instanceof byte[]) {
            return new String((byte[]) inner);
        }
        return inner instanceof String ? (String) inner : str2;
    }
}
