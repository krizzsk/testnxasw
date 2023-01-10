package com.didi.beatles.p101im.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.data.IMInnerData */
public class IMInnerData {

    /* renamed from: a */
    private static IMInnerData f10999a = null;

    /* renamed from: d */
    private static final int f11000d = 10;

    /* renamed from: b */
    private String f11001b;

    /* renamed from: c */
    private Map<Long, String> f11002c = new HashMap();

    /* renamed from: e */
    private List<IMEmojiPerfixListener> f11003e = new ArrayList();

    /* renamed from: com.didi.beatles.im.data.IMInnerData$IMEmojiPerfixListener */
    public interface IMEmojiPerfixListener {
        void emojiPrefixUpdate(String str);
    }

    private IMInnerData() {
    }

    public static IMInnerData getInstance() {
        if (f10999a == null) {
            f10999a = new IMInnerData();
        }
        return f10999a;
    }

    public String getEmojiPrefix() {
        return this.f11001b;
    }

    public void setEmojiPrefix(String str) {
        this.f11001b = str;
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.f11003e.size(); i++) {
                this.f11003e.get(i).emojiPrefixUpdate(str);
            }
        }
    }

    public void addRecommendInfo(Long l, String str) {
        if (this.f11002c.size() >= 10) {
            this.f11002c.clear();
        }
        this.f11002c.put(l, str);
    }

    public String getRecommendInfo(Long l) {
        return this.f11002c.get(l);
    }

    public void addEmojiPrefixObserver(IMEmojiPerfixListener iMEmojiPerfixListener) {
        this.f11003e.add(iMEmojiPerfixListener);
    }

    public void removeEmojiPrefixObserver(IMEmojiPerfixListener iMEmojiPerfixListener) {
        this.f11003e.remove(iMEmojiPerfixListener);
    }
}
