package com.didi.sdk.app;

import com.didi.sdk.util.SingletonHolder;
import java.util.ArrayList;
import java.util.Iterator;

public class BusinessContextManager {

    /* renamed from: a */
    private BaseBusinessContext f37917a;

    /* renamed from: b */
    private ArrayList<IBusinessContextChangedListener> f37918b = new ArrayList<>();

    /* renamed from: c */
    private boolean f37919c = true;

    private BusinessContextManager() {
    }

    public static BusinessContextManager getInstance() {
        return (BusinessContextManager) SingletonHolder.getInstance(BusinessContextManager.class);
    }

    public BaseBusinessContext getCurBusinessContext() {
        return this.f37917a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97016a(BaseBusinessContext baseBusinessContext) {
        if (baseBusinessContext != null) {
            m28569a(this.f37917a, baseBusinessContext);
            this.f37917a = baseBusinessContext;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97017a(IBusinessContextChangedListener iBusinessContextChangedListener) {
        if (iBusinessContextChangedListener != null) {
            synchronized (this.f37918b) {
                this.f37918b.add(iBusinessContextChangedListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo97019b(IBusinessContextChangedListener iBusinessContextChangedListener) {
        if (iBusinessContextChangedListener != null) {
            synchronized (this.f37918b) {
                this.f37918b.remove(iBusinessContextChangedListener);
            }
        }
    }

    /* renamed from: a */
    private void m28569a(BaseBusinessContext baseBusinessContext, BaseBusinessContext baseBusinessContext2) {
        ArrayList arrayList;
        synchronized (this.f37918b) {
            arrayList = new ArrayList(this.f37918b);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((IBusinessContextChangedListener) it.next()).onBusinessContextChanged(baseBusinessContext, baseBusinessContext2);
        }
    }

    public boolean isInHomePage() {
        return this.f37919c && ActivityLifecycleManager.getInstance().isMainActivityOnTop();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97018a(boolean z) {
        this.f37919c = z;
    }
}
