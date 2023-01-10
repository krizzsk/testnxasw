package com.didi.beatles.p101im.views.bottombar.contain;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.action.IMActionItem;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.module.IMEmojiModule;
import com.didi.beatles.p101im.views.bottombar.contain.IMBtmContainCustom;
import com.didi.beatles.p101im.views.bottombar.contain.IMBtmContainEmoji;
import com.didi.beatles.p101im.views.bottombar.contain.IMBtmContainFunc;
import com.didi.beatles.p101im.views.bottombar.contain.IMBtmContainMsg;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainManager */
public class IMBtmContainManager {
    public static final int CONTAIN_CUM = 3;
    public static final int CONTAIN_EMOJI = 4;
    public static final int CONTAIN_FUNC = 2;
    public static final int CONTAIN_MSG = 1;

    /* renamed from: a */
    private final Context f11865a;

    /* renamed from: b */
    private final int f11866b;

    /* renamed from: c */
    private ViewStub f11867c;

    /* renamed from: d */
    private ViewStub f11868d;

    /* renamed from: e */
    private ViewStub f11869e;

    /* renamed from: f */
    private ViewStub f11870f;

    /* renamed from: g */
    private IMBtmContainMsg f11871g;

    /* renamed from: h */
    private boolean f11872h = false;

    /* renamed from: i */
    private List<IMEmojiModule> f11873i = null;

    /* renamed from: j */
    private List<String> f11874j = null;

    /* renamed from: k */
    private List<String> f11875k = null;

    /* renamed from: l */
    private IMBtmContainFunc f11876l;

    /* renamed from: m */
    private List<IMActionItem> f11877m = null;

    /* renamed from: n */
    private List<IMActionItem> f11878n = null;

    /* renamed from: o */
    private IMBtmContainCustom f11879o;

    /* renamed from: p */
    private View f11880p = null;

    /* renamed from: q */
    private boolean f11881q = false;

    /* renamed from: r */
    private IMBtmContainEmoji f11882r;

    /* renamed from: s */
    private List<IMEmojiModule> f11883s = null;

    /* renamed from: t */
    private IMBtmContainCallback f11884t;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainManager$Type */
    public @interface Type {
    }

    public IMBtmContainManager(View view, int i) {
        this.f11865a = view.getContext();
        this.f11866b = i;
        this.f11867c = (ViewStub) view.findViewById(R.id.user_view_contain_msg);
        this.f11868d = (ViewStub) view.findViewById(R.id.user_view_contain_func);
        this.f11869e = (ViewStub) view.findViewById(R.id.user_view_contain_custom);
        this.f11870f = (ViewStub) view.findViewById(R.id.user_view_contain_emoji);
    }

    public void release() {
        IMBtmContainMsg iMBtmContainMsg = this.f11871g;
        if (iMBtmContainMsg != null) {
            iMBtmContainMsg.mo48947a();
        }
        IMBtmContainFunc iMBtmContainFunc = this.f11876l;
        if (iMBtmContainFunc != null) {
            iMBtmContainFunc.mo48947a();
        }
        IMBtmContainCustom iMBtmContainCustom = this.f11879o;
        if (iMBtmContainCustom != null) {
            iMBtmContainCustom.mo48947a();
        }
        IMBtmContainEmoji iMBtmContainEmoji = this.f11882r;
        if (iMBtmContainEmoji != null) {
            iMBtmContainEmoji.mo48947a();
        }
    }

    public void setCallback(IMBtmContainCallback iMBtmContainCallback) {
        this.f11884t = iMBtmContainCallback;
        IMBtmContainMsg iMBtmContainMsg = this.f11871g;
        if (iMBtmContainMsg != null) {
            iMBtmContainMsg.mo48975a((IMBtmContainMsg.Callback) iMBtmContainCallback);
        }
        IMBtmContainFunc iMBtmContainFunc = this.f11876l;
        if (iMBtmContainFunc != null) {
            iMBtmContainFunc.mo48956a((IMBtmContainFunc.Callback) iMBtmContainCallback);
        }
        IMBtmContainCustom iMBtmContainCustom = this.f11879o;
        if (iMBtmContainCustom != null) {
            iMBtmContainCustom.mo48949a((IMBtmContainCustom.Callback) iMBtmContainCallback);
        }
        IMBtmContainEmoji iMBtmContainEmoji = this.f11882r;
        if (iMBtmContainEmoji != null) {
            iMBtmContainEmoji.mo48953a((IMBtmContainEmoji.Callback) iMBtmContainCallback);
        }
    }

    public void showContainView(int i, boolean z) {
        IMBtmContainEmoji iMBtmContainEmoji;
        IMBtmContainCustom iMBtmContainCustom;
        IMBtmContainFunc iMBtmContainFunc;
        IMBtmContainMsg iMBtmContainMsg;
        if (i == 1) {
            m10206a(z);
            this.f11871g.f11896b.setVisibility(0);
        } else if (i == 2) {
            m10205a();
            this.f11876l.f11896b.setVisibility(0);
        } else if (i == 3) {
            m10207b();
            this.f11879o.f11896b.setVisibility(0);
        } else if (i == 4) {
            m10208c();
            this.f11882r.f11896b.setVisibility(0);
        }
        if (!(i == 1 || (iMBtmContainMsg = this.f11871g) == null)) {
            iMBtmContainMsg.f11896b.setVisibility(8);
        }
        if (!(i == 2 || (iMBtmContainFunc = this.f11876l) == null)) {
            iMBtmContainFunc.f11896b.setVisibility(8);
        }
        if (!(i == 3 || (iMBtmContainCustom = this.f11879o) == null)) {
            iMBtmContainCustom.f11896b.setVisibility(8);
        }
        if (i != 4 && (iMBtmContainEmoji = this.f11882r) != null) {
            iMBtmContainEmoji.f11896b.setVisibility(8);
        }
    }

    public void configMsg(boolean z) {
        this.f11872h = z;
    }

    public void refreshEmojis(List<IMEmojiModule> list) {
        IMBtmContainMsg iMBtmContainMsg = this.f11871g;
        if (iMBtmContainMsg != null) {
            iMBtmContainMsg.mo48976a(list);
        } else {
            this.f11873i = list;
        }
    }

    public void refreshSystemComWords(List<String> list, boolean z) {
        IMBtmContainMsg iMBtmContainMsg = this.f11871g;
        if (iMBtmContainMsg != null) {
            iMBtmContainMsg.mo48977a(list, z);
        } else {
            this.f11874j = list;
        }
    }

    public void refreshCustomWords(List<String> list) {
        IMBtmContainMsg iMBtmContainMsg = this.f11871g;
        if (iMBtmContainMsg != null) {
            iMBtmContainMsg.mo48978b(list);
        } else {
            this.f11875k = list;
        }
    }

    public void refreshCustomView(View view, boolean z) {
        IMBtmContainCustom iMBtmContainCustom = this.f11879o;
        if (iMBtmContainCustom != null) {
            iMBtmContainCustom.mo48948a(view, z);
            return;
        }
        this.f11880p = view;
        this.f11881q = z;
    }

    public void refreshTabEmojis(List<IMEmojiModule> list) {
        IMBtmContainEmoji iMBtmContainEmoji = this.f11882r;
        if (iMBtmContainEmoji != null) {
            iMBtmContainEmoji.mo48954a(list);
        } else {
            this.f11883s = list;
        }
    }

    public void refreshSystemFunc(List<IMActionItem> list) {
        IMBtmContainFunc iMBtmContainFunc = this.f11876l;
        if (iMBtmContainFunc != null) {
            iMBtmContainFunc.mo48957a(list);
        } else {
            this.f11877m = list;
        }
    }

    public void refreshMoreFunc(List<IMActionItem> list) {
        IMBtmContainFunc iMBtmContainFunc = this.f11876l;
        if (iMBtmContainFunc != null) {
            iMBtmContainFunc.mo48959b(list);
        } else {
            this.f11878n = list;
        }
    }

    public void refreshFuncStatus(IMActionItem iMActionItem) {
        IMBtmContainFunc iMBtmContainFunc = this.f11876l;
        if (iMBtmContainFunc != null) {
            iMBtmContainFunc.mo48955a(iMActionItem);
        }
    }

    /* renamed from: a */
    private void m10206a(boolean z) {
        if (this.f11871g == null) {
            this.f11871g = new IMBtmContainMsg(this.f11867c.inflate(), this.f11872h, m10209d());
            List<String> list = this.f11874j;
            if (list != null) {
                refreshSystemComWords(list, z);
                this.f11874j = null;
            }
            List<String> list2 = this.f11875k;
            if (list2 != null) {
                refreshCustomWords(list2);
                this.f11875k = null;
            }
            List<IMEmojiModule> list3 = this.f11873i;
            if (list3 != null) {
                refreshEmojis(list3);
                this.f11873i = null;
            }
            IMBtmContainCallback iMBtmContainCallback = this.f11884t;
            if (iMBtmContainCallback != null) {
                setCallback(iMBtmContainCallback);
            }
        }
    }

    /* renamed from: a */
    private void m10205a() {
        if (this.f11876l == null) {
            this.f11876l = new IMBtmContainFunc(this.f11868d.inflate());
            List<IMActionItem> list = this.f11877m;
            if (list != null) {
                refreshSystemFunc(list);
                this.f11877m = null;
            }
            List<IMActionItem> list2 = this.f11878n;
            if (list2 != null) {
                refreshMoreFunc(list2);
                this.f11878n = null;
            }
            IMBtmContainCallback iMBtmContainCallback = this.f11884t;
            if (iMBtmContainCallback != null) {
                setCallback(iMBtmContainCallback);
            }
        }
    }

    /* renamed from: b */
    private void m10207b() {
        if (this.f11879o == null) {
            IMBtmContainCustom iMBtmContainCustom = new IMBtmContainCustom(this.f11869e.inflate());
            this.f11879o = iMBtmContainCustom;
            View view = this.f11880p;
            if (view != null) {
                iMBtmContainCustom.mo48948a(view, this.f11881q);
                this.f11880p = null;
                this.f11881q = false;
            }
            IMBtmContainCallback iMBtmContainCallback = this.f11884t;
            if (iMBtmContainCallback != null) {
                setCallback(iMBtmContainCallback);
            }
        }
    }

    /* renamed from: c */
    private void m10208c() {
        if (this.f11882r == null) {
            IMBtmContainEmoji iMBtmContainEmoji = new IMBtmContainEmoji(this.f11870f.inflate());
            this.f11882r = iMBtmContainEmoji;
            List<IMEmojiModule> list = this.f11883s;
            if (list != null) {
                iMBtmContainEmoji.mo48954a(list);
                this.f11883s = null;
            }
            IMBtmContainCallback iMBtmContainCallback = this.f11884t;
            if (iMBtmContainCallback != null) {
                setCallback(iMBtmContainCallback);
            }
        }
    }

    /* renamed from: d */
    private int m10209d() {
        if (IMContextInfoHelper.isPad()) {
            return 4;
        }
        IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(this.f11865a).getCurrentBusinessConfig(this.f11866b);
        if (currentBusinessConfig == null) {
            return 1;
        }
        return currentBusinessConfig.getCommonWordType();
    }

    public void invokeActionItem(IMActionItem iMActionItem, boolean z) {
        IMBtmContainCallback iMBtmContainCallback;
        if (iMActionItem != null && (iMBtmContainCallback = this.f11884t) != null) {
            iMBtmContainCallback.invokeAction(iMActionItem, z);
        }
    }

    public List<IMActionItem> getFuncList() {
        IMBtmContainFunc iMBtmContainFunc = this.f11876l;
        if (iMBtmContainFunc != null) {
            return iMBtmContainFunc.mo48958b();
        }
        ArrayList arrayList = new ArrayList();
        List<IMActionItem> list = this.f11878n;
        if (list != null) {
            arrayList.addAll(list);
        }
        List<IMActionItem> list2 = this.f11877m;
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }
}
