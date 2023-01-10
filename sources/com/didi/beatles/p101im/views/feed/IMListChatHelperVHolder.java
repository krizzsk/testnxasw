package com.didi.beatles.p101im.views.feed;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.api.entity.IMHelperBody;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.IIMUserModule;
import com.didi.beatles.p101im.module.IMUserInfoCallback;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.module.entity.IMUser;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.feed.IMListChatVHolder;
import com.didi.beatles.p101im.views.popup.IMSessionDeletePopup;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.feed.IMListChatHelperVHolder */
public class IMListChatHelperVHolder extends IMListChatVHolder<ChatHelperListener> {
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ChatHelperListener f12087k;

    /* renamed from: l */
    private ChatHelperListener f12088l = new ChatHelperListener() {
        public void deleteHelper(View view, IMSession iMSession) {
            if (IMListChatHelperVHolder.this.f12087k != null) {
                IMListChatHelperVHolder.this.f12087k.deleteHelper(view, iMSession);
            }
        }

        public void openNotify(View view, IMSession iMSession, boolean z) {
            if (IMListChatHelperVHolder.this.f12087k != null) {
                IMListChatHelperVHolder.this.f12087k.openNotify(view, iMSession, z);
            }
        }

        public void onClick(View view, IMSession iMSession) {
            IMTraceUtil.addBusinessEvent("ddim_service_list_ck").add("product_id", Integer.valueOf(iMSession.getBusinessId())).add("no_appid", Long.valueOf(iMSession.getPeerUid())).add("type", Integer.valueOf(iMSession.getIsHelperForbid() ? 1 : 0)).add("position", Integer.valueOf(IMListChatHelperVHolder.this.f12099i)).report();
            if (IMListChatHelperVHolder.this.f12087k != null) {
                IMListChatHelperVHolder.this.f12087k.onClick(view, iMSession);
            }
        }
    };

    /* renamed from: com.didi.beatles.im.views.feed.IMListChatHelperVHolder$ChatHelperListener */
    public interface ChatHelperListener extends IMListChatVHolder.ClickListener {
        void deleteHelper(View view, IMSession iMSession);

        void openNotify(View view, IMSession iMSession, boolean z);
    }

    public IMListChatHelperVHolder(Activity activity, ViewGroup viewGroup) {
        super(activity, viewGroup);
        this.f12096f.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_list_top_star));
    }

    public void bindData(IMSession iMSession, int i, boolean z, ChatHelperListener chatHelperListener) {
        super.bindData(iMSession, i, z, this.f12088l);
        this.f12087k = chatHelperListener;
        m10369c();
        m10370d();
        m10371e();
        this.f12097g.setVisibility(this.f12098h.getIsHelperForbid() ? 0 : 8);
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                IMListChatHelperVHolder.this.m10372f();
                return true;
            }
        });
    }

    /* renamed from: c */
    private void m10369c() {
        if (this.f12098h.getExtendSessionInfo() == null || this.f12098h.getExtendSessionInfo().istop != 1) {
            this.f12096f.setVisibility(8);
        } else {
            this.f12096f.setVisibility(0);
        }
    }

    /* renamed from: d */
    private void m10370d() {
        List<Long> userIds = this.f12098h.getUserIds();
        IIMUserModule userModel = IMManager.getInstance().getUserModel();
        if (userIds.size() == 2 && userModel != null) {
            userModel.getUserInfo(new long[]{userIds.get(0).longValue(), userIds.get(1).longValue()}, (IMUserInfoCallback) new IMUserInfoCallback() {
                public void onUserInfoLoaded(HashMap<Long, IMUser> hashMap, long[] jArr) {
                    if (jArr.length == 2 && IMListChatHelperVHolder.this.f12098h.getUserIds().size() == 2 && jArr[0] == IMListChatHelperVHolder.this.f12098h.getUserIds().get(0).longValue() && jArr[1] == IMListChatHelperVHolder.this.f12098h.getUserIds().get(1).longValue() && IMListChatHelperVHolder.this.f12091a != null && !IMListChatHelperVHolder.this.f12091a.isFinishing()) {
                        IMUser iMUser = null;
                        if (hashMap != null) {
                            iMUser = hashMap.get(IMSession.getPeerId(IMListChatHelperVHolder.this.f12098h.getUserIds()));
                        }
                        if (iMUser == null) {
                            IMListChatHelperVHolder.this.f12092b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_helper_name_default));
                            IMListChatHelperVHolder.this.f12095e.setImageResource(R.drawable.bts_im_general_default_avatar);
                            return;
                        }
                        if (!TextUtils.isEmpty(iMUser.getNickName())) {
                            IMListChatHelperVHolder.this.f12092b.setText(iMUser.getNickName());
                        } else {
                            IMListChatHelperVHolder.this.f12092b.setText(IMContextInfoHelper.getContext().getString(R.string.bts_im_helper_name_default));
                        }
                        if (!TextUtils.isEmpty(iMUser.getAvatarUrl())) {
                            BtsImageLoader.getInstance().loadInto((Object) iMUser.getAvatarUrl(), (View) IMListChatHelperVHolder.this.f12095e, (int) R.drawable.bts_im_general_default_avatar);
                            return;
                        }
                        IMListChatHelperVHolder.this.f12095e.setImageResource(R.drawable.bts_im_general_default_avatar);
                    }
                }
            }, false);
        }
    }

    /* renamed from: e */
    private void m10371e() {
        String str;
        IMHelperBody iMHelperBody = (IMHelperBody) IMJsonUtil.objectFromJson(this.f12098h.getLastMessage(), IMHelperBody.class);
        if (iMHelperBody != null) {
            str = iMHelperBody.title;
        } else if (TextUtils.isEmpty(this.f12098h.getLastMessage())) {
            str = IMContextInfoHelper.getContext().getString(R.string.bts_im_chat_last_msg);
        } else {
            str = this.f12098h.getLastMessage();
        }
        this.f12093c.setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m10372f() {
        final boolean z = !this.f12098h.getIsHelperForbid();
        final ArrayList arrayList = new ArrayList();
        if (this.f12098h.getIsHelperCanForbid()) {
            arrayList.add(new IMSessionDeletePopup.TextConfig() {
                public String getContent() {
                    return IMListChatHelperVHolder.this.itemView.getResources().getString(!z ? R.string.im_feed_notify_open : R.string.im_feed_notify_close);
                }

                public int getTextColor() {
                    return IMListChatHelperVHolder.this.itemView.getResources().getColor(R.color.bts_im_color_gray);
                }
            });
        }
        arrayList.add(new IMSessionDeletePopup.TextConfig() {
            public String getContent() {
                return IMListChatHelperVHolder.this.itemView.getContext().getString(R.string.im_pop_delete);
            }

            public int getTextColor() {
                return Color.parseColor("#EB4D3D");
            }
        });
        new IMSessionDeletePopup(this.f12091a).show(this.f12092b, arrayList, new IMSessionDeletePopup.PopupOnClickListener() {
            public void onItemClick(int i) {
                if (arrayList.size() > 1 && i == 0) {
                    IMTraceUtil.addBusinessEvent(z ? "ddim_service_list_notice_off_ck" : "ddim_service_list_notice_on_ck").add("product_id", Integer.valueOf(IMListChatHelperVHolder.this.f12098h.getBusinessId())).add("no_appid", Long.valueOf(IMListChatHelperVHolder.this.f12098h.getPeerUid())).report();
                    if (IMListChatHelperVHolder.this.f12100j != null) {
                        ((ChatHelperListener) IMListChatHelperVHolder.this.f12100j).openNotify(IMListChatHelperVHolder.this.itemView, IMListChatHelperVHolder.this.f12098h, true ^ z);
                    }
                } else if ((arrayList.size() == 1 || i == 1) && IMListChatHelperVHolder.this.f12100j != null) {
                    ((ChatHelperListener) IMListChatHelperVHolder.this.f12100j).deleteHelper(IMListChatHelperVHolder.this.itemView, IMListChatHelperVHolder.this.f12098h);
                }
            }
        });
    }
}
