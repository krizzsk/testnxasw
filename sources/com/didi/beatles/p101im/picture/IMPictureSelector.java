package com.didi.beatles.p101im.picture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.beatles.p101im.picture.config.IMPictureConfig;
import com.didi.beatles.p101im.picture.config.IMPictureMimeType;
import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.IMPictureSelector */
public final class IMPictureSelector {

    /* renamed from: a */
    private final WeakReference<Activity> f11191a;

    /* renamed from: b */
    private final WeakReference<Fragment> f11192b;

    private IMPictureSelector(Activity activity) {
        this(activity, (Fragment) null);
    }

    private IMPictureSelector(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    private IMPictureSelector(Activity activity, Fragment fragment) {
        this.f11191a = new WeakReference<>(activity);
        this.f11192b = new WeakReference<>(fragment);
    }

    public static IMPictureSelector create(Activity activity) {
        return new IMPictureSelector(activity);
    }

    public static IMPictureSelector create(Fragment fragment) {
        return new IMPictureSelector(fragment);
    }

    public IMPictureSelectionModel openGallery() {
        return new IMPictureSelectionModel(this, IMPictureMimeType.ofImage());
    }

    public IMPictureSelectionModel openCamera() {
        return new IMPictureSelectionModel(this, IMPictureMimeType.ofImage(), true);
    }

    public static List<IMLocalMedia> obtainMultipleResult(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent == null) {
            return arrayList;
        }
        List<IMLocalMedia> list = (List) intent.getSerializableExtra(IMPictureConfig.EXTRA_RESULT_SELECTION);
        return list == null ? new ArrayList() : list;
    }

    public static Intent putIntentResult(List<IMLocalMedia> list) {
        return new Intent().putExtra(IMPictureConfig.EXTRA_RESULT_SELECTION, (Serializable) list);
    }

    public static List<IMLocalMedia> obtainSelectorList(Bundle bundle) {
        if (bundle != null) {
            return (List) bundle.getSerializable(IMPictureConfig.EXTRA_SELECT_LIST);
        }
        return new ArrayList();
    }

    public static void saveSelectorList(Bundle bundle, List<IMLocalMedia> list) {
        bundle.putSerializable(IMPictureConfig.EXTRA_SELECT_LIST, (Serializable) list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Activity mo47915a() {
        return (Activity) this.f11191a.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Fragment mo47916b() {
        WeakReference<Fragment> weakReference = this.f11192b;
        if (weakReference != null) {
            return (Fragment) weakReference.get();
        }
        return null;
    }
}
