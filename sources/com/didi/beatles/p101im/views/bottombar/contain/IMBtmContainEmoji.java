package com.didi.beatles.p101im.views.bottombar.contain;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.beatles.p101im.adapter.IMEmojiAdapter;
import com.didi.beatles.p101im.module.IMEmojiModule;
import com.didi.beatles.p101im.utils.IMEmotionInputDetector;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.views.buttonView.IMSwitchView;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainEmoji */
class IMBtmContainEmoji extends C4858a {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Callback f11859c;

    /* renamed from: d */
    private RecyclerView f11860d;

    /* renamed from: e */
    private IMEmojiAdapter f11861e;

    /* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainEmoji$Callback */
    interface Callback {
        void sendEmoji(String str, String str2, String str3);
    }

    IMBtmContainEmoji(View view) {
        super(view);
        m10192a(view);
    }

    /* renamed from: a */
    public void mo48953a(Callback callback) {
        this.f11859c = callback;
    }

    /* renamed from: a */
    public void mo48947a() {
        this.f11859c = null;
    }

    /* renamed from: a */
    private void m10192a(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.emoji_recyclerview);
        this.f11860d = recyclerView;
        recyclerView.setVisibility(0);
        ((IMSwitchView) view.findViewById(R.id.im_bottombar_switch)).setVisibility(8);
        view.findViewById(R.id.bottom_list).setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48954a(List<IMEmojiModule> list) {
        IMEmojiAdapter iMEmojiAdapter = this.f11861e;
        if (iMEmojiAdapter != null) {
            iMEmojiAdapter.changeEmojiList(list);
        } else {
            m10193b(list);
        }
    }

    /* renamed from: b */
    private void m10193b(List<IMEmojiModule> list) {
        if (this.f11860d != null) {
            this.f11860d.setLayoutManager(new GridLayoutManager(this.f11895a, 4, 1, false));
            IMEmojiAdapter iMEmojiAdapter = new IMEmojiAdapter(this.f11895a, (IMEmotionInputDetector.keyboardHeight - IMViewUtil.dp2px(this.f11895a, 50.0f)) / 2, list, new IMEmojiAdapter.IMEmojiViewOnClickListener() {
                public void onClick(String str, String str2, String str3) {
                    if (IMBtmContainEmoji.this.f11859c != null) {
                        IMBtmContainEmoji.this.f11859c.sendEmoji(str, str2, str3);
                    }
                }
            });
            this.f11861e = iMEmojiAdapter;
            this.f11860d.setAdapter(iMEmojiAdapter);
        }
    }
}
