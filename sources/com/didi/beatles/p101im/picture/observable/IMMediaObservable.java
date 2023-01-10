package com.didi.beatles.p101im.picture.observable;

import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import com.didi.beatles.p101im.picture.entity.IMLocalMediaFolder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.observable.IMMediaObservable */
public class IMMediaObservable implements IMSubjectListener {

    /* renamed from: e */
    private static volatile IMMediaObservable f11282e;

    /* renamed from: a */
    private List<IMObserverListener> f11283a = new ArrayList();

    /* renamed from: b */
    private List<IMLocalMediaFolder> f11284b = new ArrayList();

    /* renamed from: c */
    private List<IMLocalMedia> f11285c = new ArrayList();

    /* renamed from: d */
    private List<IMLocalMedia> f11286d = new ArrayList();

    private IMMediaObservable() {
    }

    public static IMMediaObservable getInstance() {
        if (f11282e == null) {
            synchronized (IMMediaObservable.class) {
                if (f11282e == null) {
                    f11282e = new IMMediaObservable();
                }
            }
        }
        return f11282e;
    }

    public void saveLocalFolders(List<IMLocalMediaFolder> list) {
        if (list != null) {
            this.f11284b = list;
        }
    }

    public void saveLocalMedia(List<IMLocalMedia> list) {
        this.f11285c = list;
    }

    public List<IMLocalMedia> readLocalMedias() {
        if (this.f11285c == null) {
            this.f11285c = new ArrayList();
        }
        return this.f11285c;
    }

    public List<IMLocalMediaFolder> readLocalFolders() {
        if (this.f11284b == null) {
            this.f11284b = new ArrayList();
        }
        return this.f11284b;
    }

    public List<IMLocalMedia> readSelectLocalMedias() {
        return this.f11286d;
    }

    public void clearLocalFolders() {
        List<IMLocalMediaFolder> list = this.f11284b;
        if (list != null) {
            list.clear();
        }
    }

    public void clearLocalMedia() {
        List<IMLocalMedia> list = this.f11285c;
        if (list != null) {
            list.clear();
        }
    }

    public void clearSelectedLocalMedia() {
        List<IMLocalMedia> list = this.f11286d;
        if (list != null) {
            list.clear();
        }
    }

    public void add(IMObserverListener iMObserverListener) {
        this.f11283a.add(iMObserverListener);
    }

    public void remove(IMObserverListener iMObserverListener) {
        if (this.f11283a.contains(iMObserverListener)) {
            this.f11283a.remove(iMObserverListener);
        }
    }
}
