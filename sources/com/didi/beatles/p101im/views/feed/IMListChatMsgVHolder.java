package com.didi.beatles.p101im.views.feed;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.api.entity.IMOrderStatusChangeBody;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.IIMUserModule;
import com.didi.beatles.p101im.module.IMUserInfoCallback;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.module.entity.IMUser;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.omega.OmegaUtil;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.IMSpanny;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.feed.IMListChatVHolder;
import com.didi.beatles.p101im.views.popup.IMSessionDeletePopup;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.feed.IMListChatMsgVHolder */
public class IMListChatMsgVHolder extends IMListChatVHolder<ChatMsgListener> {
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ChatMsgListener f12089k;

    /* renamed from: l */
    private ChatMsgListener f12090l = new ChatMsgListener() {
        public void deleteMsg(View view, IMSession iMSession) {
            if (IMListChatMsgVHolder.this.f12089k != null) {
                IMListChatMsgVHolder.this.f12089k.deleteMsg(view, iMSession);
            }
        }

        public void onClick(View view, IMSession iMSession) {
            IMTraceUtil.addBusinessEvent("ddim_message_list_item_ck").add("send_uid", Long.valueOf(iMSession.getPeerUid())).report();
            if (IMListChatMsgVHolder.this.f12089k != null) {
                IMListChatMsgVHolder.this.f12089k.onClick(view, iMSession);
            }
        }
    };

    /* renamed from: com.didi.beatles.im.views.feed.IMListChatMsgVHolder$ChatMsgListener */
    public interface ChatMsgListener extends IMListChatVHolder.ClickListener {
        void deleteMsg(View view, IMSession iMSession);
    }

    public IMListChatMsgVHolder(Activity activity, ViewGroup viewGroup) {
        super(activity, viewGroup);
    }

    public void bindData(IMSession iMSession, int i, boolean z, ChatMsgListener chatMsgListener) {
        super.bindData(iMSession, i, z, this.f12090l);
        this.f12089k = chatMsgListener;
        m10375c();
        if (this.f12098h.getType() != 2) {
            m10376d();
        } else {
            m10377e();
        }
        m10378f();
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                IMListChatMsgVHolder.this.m10380h();
                return true;
            }
        });
    }

    /* renamed from: c */
    private void m10375c() {
        if (this.f12098h.getType() != 2 || !this.f12098h.getIsForbid()) {
            this.f12097g.setVisibility(8);
            return;
        }
        this.f12097g.setVisibility(0);
        this.f12097g.setImageResource(IMResource.getDrawableID(R.drawable.im_forbid_trouble));
    }

    /* renamed from: d */
    private void m10376d() {
        List<Long> userIds = this.f12098h.getUserIds();
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userIds.size() == 2 && userModel != null) {
            userModel.getUserInfo(new long[]{userIds.get(0).longValue(), userIds.get(1).longValue()}, (IMUserInfoCallback) new IMUserInfoCallback() {
                public void onUserInfoLoaded(HashMap<Long, IMUser> hashMap, long[] jArr) {
                    if (jArr.length == 2 && IMListChatMsgVHolder.this.f12098h.getUserIds().size() == 2 && jArr[0] == IMListChatMsgVHolder.this.f12098h.getUserIds().get(0).longValue() && jArr[1] == IMListChatMsgVHolder.this.f12098h.getUserIds().get(1).longValue() && IMListChatMsgVHolder.this.f12091a != null && !IMListChatMsgVHolder.this.f12091a.isFinishing()) {
                        IMUser iMUser = null;
                        if (hashMap != null) {
                            iMUser = hashMap.get(IMSession.getPeerId(IMListChatMsgVHolder.this.f12098h.getUserIds()));
                        }
                        if (iMUser == null) {
                            IMListChatMsgVHolder.this.f12092b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_user_default_name));
                            IMListChatMsgVHolder.this.f12095e.setImageResource(R.drawable.bts_im_general_default_avatar);
                            IMListChatMsgVHolder.this.f12096f.setVisibility(8);
                            return;
                        }
                        if (!TextUtils.isEmpty(iMUser.getNickName())) {
                            OmegaUtil.trackTitleNamePath(iMUser.getNickName(), IMListChatMsgVHolder.this.f12098h, 3);
                            IMListChatMsgVHolder.this.f12092b.setText(iMUser.getNickName());
                        } else {
                            IMListChatMsgVHolder.this.f12092b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_user_default_name));
                        }
                        if (!TextUtils.isEmpty(iMUser.getAvatarUrl())) {
                            BtsImageLoader.getInstance().loadInto((Object) iMUser.getAvatarUrl(), (View) IMListChatMsgVHolder.this.f12095e, (int) R.drawable.bts_im_general_default_avatar);
                        } else {
                            IMListChatMsgVHolder.this.f12095e.setImageResource(R.drawable.bts_im_general_default_avatar);
                        }
                        if (iMUser.getMIcon() == 1) {
                            IMListChatMsgVHolder.this.f12096f.setVisibility(0);
                        } else {
                            IMListChatMsgVHolder.this.f12096f.setVisibility(8);
                        }
                    }
                }
            }, false);
        }
    }

    /* renamed from: e */
    private void m10377e() {
        if (TextUtils.isEmpty(this.f12098h.getSessionName())) {
            this.f12092b.setText(IMResource.getString(R.string.bts_user_default_name));
        } else {
            this.f12092b.setText(this.f12098h.getSessionName());
        }
        if (!TextUtils.isEmpty(this.f12098h.getSessionImg())) {
            BtsImageLoader.getInstance().loadInto((Object) this.f12098h.getSessionImg(), (View) this.f12095e, IMResource.getDrawableID(R.drawable.bts_im_general_default_avatar));
        } else {
            this.f12095e.setImageResource(IMResource.getDrawableID(R.drawable.bts_im_general_default_avatar));
        }
    }

    /* renamed from: f */
    private void m10378f() {
        if (!IMTextUtil.isEmpty(this.f12098h.getDraft())) {
            this.f12093c.setText(new IMSpanny((CharSequence) IMContextInfoHelper.getContext().getString(R.string.bts_im_chat_save), (Object) new ForegroundColorSpan(IMResource.getColor(R.color.im_nomix_orange))).append((CharSequence) this.f12098h.getDraft()));
            return;
        }
        this.f12093c.setText(m10379g());
    }

    /* renamed from: g */
    private IMSpanny m10379g() {
        String str;
        StringBuilder sb;
        String str2;
        int lastMsgStatus = this.f12098h.getLastMsgStatus();
        try {
            IMOrderStatusChangeBody iMOrderStatusChangeBody = (IMOrderStatusChangeBody) IMJsonUtil.objectFromJson(this.f12098h.getLastMessage(), IMOrderStatusChangeBody.class, true);
            if (iMOrderStatusChangeBody == null) {
                str = this.f12098h.getLastMessage();
            } else if (iMOrderStatusChangeBody.format_type == 1) {
                if (IMTextUtil.isEmpty(iMOrderStatusChangeBody.title)) {
                    str = iMOrderStatusChangeBody.block.text;
                } else {
                    str = Const.jaLeft + iMOrderStatusChangeBody.title + Const.jaRight + iMOrderStatusChangeBody.block.text;
                }
            } else if (iMOrderStatusChangeBody.format_type == 2) {
                if (IMTextUtil.isEmpty(iMOrderStatusChangeBody.title)) {
                    sb = new StringBuilder();
                    sb.append(iMOrderStatusChangeBody.block.from);
                    sb.append("-");
                    str2 = iMOrderStatusChangeBody.block.f10964to;
                } else {
                    sb = new StringBuilder();
                    sb.append(Const.jaLeft);
                    sb.append(iMOrderStatusChangeBody.title);
                    sb.append(Const.jaRight);
                    sb.append(iMOrderStatusChangeBody.block.from);
                    sb.append("-");
                    str2 = iMOrderStatusChangeBody.block.f10964to;
                }
                sb.append(str2);
                str = sb.toString();
            } else {
                str = "";
            }
        } catch (Exception unused) {
            str = this.f12098h.getLastMessage();
        }
        IMSpanny iMSpanny = new IMSpanny();
        if (lastMsgStatus == 100) {
            iMSpanny.append((CharSequence) str, new ImageSpan(this.f12091a, R.drawable.bts_im_chat_msg_status));
        } else if (lastMsgStatus == 300 || lastMsgStatus == 500) {
            iMSpanny.append((CharSequence) IMContextInfoHelper.getContext().getString(R.string.bts_im_chat_send_fail), (Object) new ForegroundColorSpan(IMResource.getColor(R.color.im_nomix_orange))).append((CharSequence) str);
        } else if (TextUtils.isEmpty(str)) {
            iMSpanny.append((CharSequence) "");
        } else {
            iMSpanny.append((CharSequence) str);
        }
        return iMSpanny;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m10380h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IMSessionDeletePopup.TextConfig() {
            public String getContent() {
                return IMListChatMsgVHolder.this.itemView.getContext().getString(R.string.im_pop_delete);
            }

            public int getTextColor() {
                return Color.parseColor("#EB4D3D");
            }
        });
        new IMSessionDeletePopup(this.f12091a).show(this.f12092b, arrayList, new IMSessionDeletePopup.PopupOnClickListener() {
            public void onItemClick(int i) {
                if (i == 0 && IMListChatMsgVHolder.this.f12100j != null) {
                    ((ChatMsgListener) IMListChatMsgVHolder.this.f12100j).deleteMsg(IMListChatMsgVHolder.this.itemView, IMListChatMsgVHolder.this.f12098h);
                }
            }
        });
    }
}
