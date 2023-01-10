package com.didi.beatles.p101im.views.bottombar.contain;

import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.adapter.IMCommonWordAdapter;
import com.didi.beatles.p101im.adapter.IMEmojiAdapter;
import com.didi.beatles.p101im.event.IMAddCustomWordEvent;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.IIMUserModule;
import com.didi.beatles.p101im.module.IMEmojiModule;
import com.didi.beatles.p101im.module.IMUsefulExpressionCallback;
import com.didi.beatles.p101im.omega.IMMsgOmega;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMEmotionInputDetector;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.beatles.p101im.views.buttonView.IMSwitchView;
import com.didi.beatles.p101im.views.dialog.IMAddCommonWordDialog;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainMsg */
class IMBtmContainMsg extends C4858a {

    /* renamed from: c */
    private static final double f11885c = 4.5d;

    /* renamed from: d */
    private final boolean f11886d;

    /* renamed from: e */
    private final int f11887e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Callback f11888f;

    /* renamed from: g */
    private IIMUserModule f11889g;

    /* renamed from: h */
    private Toast f11890h;

    /* renamed from: i */
    private RecyclerView f11891i;

    /* renamed from: j */
    private IMCommonWordAdapter f11892j;

    /* renamed from: k */
    private RecyclerView f11893k;

    /* renamed from: l */
    private IMEmojiAdapter f11894l;

    /* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainMsg$Callback */
    interface Callback {
        void addCommonWord(int i);

        void sendCommonWord(String str, int i);

        void sendEmoji(String str, String str2, String str3);
    }

    IMBtmContainMsg(View view, boolean z, int i) {
        super(view);
        this.f11886d = z;
        this.f11887e = i;
        m10212a(view);
        EventBus.getDefault().register(this);
    }

    /* renamed from: a */
    public void mo48975a(Callback callback) {
        this.f11888f = callback;
    }

    /* renamed from: a */
    public void mo48947a() {
        this.f11888f = null;
        EventBus.getDefault().unregister(this);
    }

    /* renamed from: a */
    private void m10212a(View view) {
        this.f11891i = (RecyclerView) view.findViewById(R.id.bottom_list);
        if (this.f11886d) {
            this.f11893k = (RecyclerView) view.findViewById(R.id.emoji_recyclerview);
            IMSwitchView iMSwitchView = (IMSwitchView) view.findViewById(R.id.im_bottombar_switch);
            iMSwitchView.setVisibility(0);
            iMSwitchView.setOnCheckListener(new IMSwitchView.IMSwitchCheckListener() {
                public void leftBtnChecked() {
                    IMBtmContainMsg.this.m10218b();
                }

                public void rightBtnChecked() {
                    IMBtmContainMsg.this.m10222c();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10218b() {
        RecyclerView recyclerView = this.f11893k;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
        this.f11891i.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10222c() {
        RecyclerView recyclerView = this.f11893k;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        this.f11891i.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10224d() {
        RecyclerView recyclerView = this.f11891i;
        if (recyclerView != null && recyclerView.isShown() && this.f11892j != null) {
            this.f11891i.smoothScrollToPosition(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48976a(List<IMEmojiModule> list) {
        if (this.f11886d) {
            IMEmojiAdapter iMEmojiAdapter = this.f11894l;
            if (iMEmojiAdapter != null) {
                iMEmojiAdapter.changeEmojiList(list);
            } else {
                m10223c(list);
            }
        }
    }

    /* renamed from: c */
    private void m10223c(List<IMEmojiModule> list) {
        if (this.f11893k != null) {
            this.f11893k.setLayoutManager(new GridLayoutManager(this.f11895a, 4, 1, false));
            IMEmojiAdapter iMEmojiAdapter = new IMEmojiAdapter(this.f11895a, (IMEmotionInputDetector.keyboardHeight - IMViewUtil.dp2px(this.f11895a, 50.0f)) / 2, list, new IMEmojiAdapter.IMEmojiViewOnClickListener() {
                public void onClick(String str, String str2, String str3) {
                    if (IMBtmContainMsg.this.f11888f != null) {
                        IMBtmContainMsg.this.f11888f.sendEmoji(str, str2, str3);
                    }
                }
            });
            this.f11894l = iMEmojiAdapter;
            this.f11893k.setAdapter(iMEmojiAdapter);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48977a(List<String> list, boolean z) {
        IMCommonWordAdapter iMCommonWordAdapter = this.f11892j;
        if (iMCommonWordAdapter != null) {
            iMCommonWordAdapter.replaceSystemList(list, z);
        } else {
            m10220b(list, z);
        }
    }

    /* renamed from: b */
    private void m10220b(List<String> list, boolean z) {
        int i;
        if (list != null && list.size() > 0) {
            if (this.f11886d) {
                i = IMEmotionInputDetector.keyboardHeight - IMViewUtil.dp2px(this.f11895a, 50.0f);
            } else {
                i = IMEmotionInputDetector.keyboardHeight;
            }
            List<String> list2 = list;
            IMCommonWordAdapter iMCommonWordAdapter = new IMCommonWordAdapter(this.f11895a, list2, IMManager.getInstance().getCustomUsefulExpression(), (int) (((double) i) / f11885c), this.f11887e, z);
            this.f11892j = iMCommonWordAdapter;
            iMCommonWordAdapter.setCommonWordClickListener(new IMCommonWordAdapter.IMCommonWordClickListener() {
                public void sendCommonWord(String str, int i) {
                    if (IMBtmContainMsg.this.f11888f != null) {
                        IMBtmContainMsg.this.f11888f.sendCommonWord(str, i);
                    }
                }

                public void addCommonWord(int i) {
                    if (IMBtmContainMsg.this.f11888f != null) {
                        IMBtmContainMsg.this.f11888f.addCommonWord(i);
                    }
                }

                public void deleteCommonWord(String str) {
                    IMBtmContainMsg.this.m10217a(str);
                }
            });
            if (IMContextInfoHelper.isPad()) {
                this.f11891i.setLayoutManager(new LinearLayoutManager(this.f11895a, 0, false));
            } else {
                this.f11891i.setLayoutManager(new LinearLayoutManager(this.f11895a, 1, false));
            }
            this.f11891i.setAdapter(this.f11892j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo48978b(List<String> list) {
        IMCommonWordAdapter iMCommonWordAdapter = this.f11892j;
        if (iMCommonWordAdapter != null) {
            iMCommonWordAdapter.replaceCustomList(list);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    /* renamed from: a */
    public void mo48974a(IMAddCustomWordEvent iMAddCustomWordEvent) {
        final IMAddCommonWordDialog.CustomWord customWord = iMAddCustomWordEvent.customWord;
        if (this.f11889g == null) {
            this.f11889g = IMManager.getInstance().getUserModel();
        }
        IIMUserModule iIMUserModule = this.f11889g;
        if (iIMUserModule != null && customWord != null) {
            iIMUserModule.executeUsfulExpression(1, customWord.resource, customWord.text, new IMUsefulExpressionCallback() {
                public void onResponse(int i, String str) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("source", Integer.valueOf(customWord.resource));
                    if (i == 0) {
                        hashMap.put("state", 1);
                    } else {
                        hashMap.put("state", 2);
                    }
                    IMMsgOmega.getInstance().track("ddim_dy_all_sure_ck", hashMap);
                    if (i == 0) {
                        IMBtmContainMsg.this.mo48978b(IMManager.getInstance().getCustomUsefulExpression());
                        IMBtmContainMsg.this.m10210a((int) R.drawable.im_toast_succeed, (int) R.string.im_add_word_succeed);
                        IMBtmContainMsg.this.m10224d();
                        return;
                    }
                    IMBtmContainMsg.this.m10211a((int) R.drawable.im_toast_warm, str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10217a(String str) {
        if (this.f11889g == null) {
            this.f11889g = IMManager.getInstance().getUserModel();
        }
        IIMUserModule iIMUserModule = this.f11889g;
        if (iIMUserModule != null) {
            iIMUserModule.executeUsfulExpression(2, 0, str, new IMUsefulExpressionCallback() {
                public void onResponse(int i, String str) {
                    if (i == 0) {
                        IMBtmContainMsg.this.mo48978b(IMManager.getInstance().getCustomUsefulExpression());
                    } else {
                        IMBtmContainMsg.this.m10211a((int) R.drawable.im_toast_warm, str);
                    }
                    HashMap hashMap = new HashMap();
                    if (i == 0) {
                        hashMap.put("state", 1);
                    } else {
                        hashMap.put("state", 2);
                    }
                    IMMsgOmega.getInstance().track("ddim_dy_all_del_ck", hashMap);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10210a(int i, int i2) {
        m10211a(i, IMResource.getString(i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10211a(int i, String str) {
        if (this.f11890h == null) {
            this.f11890h = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) str, 0);
        }
        SystemUtils.showToast(this.f11890h);
        IMTipsToast.setIconKeepSize(this.f11890h, i);
        IMTipsToast.setText(this.f11890h, str);
    }
}
