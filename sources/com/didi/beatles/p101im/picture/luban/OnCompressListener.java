package com.didi.beatles.p101im.picture.luban;

import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.luban.OnCompressListener */
public interface OnCompressListener {
    void onError(Throwable th);

    void onStart();

    void onSuccess(List<IMLocalMedia> list);
}
