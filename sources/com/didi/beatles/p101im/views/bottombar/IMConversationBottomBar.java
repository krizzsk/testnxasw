package com.didi.beatles.p101im.views.bottombar;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.IMCommonContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.action.IMActionItem;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.access.utils.ConfigLoadListener;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.api.entity.IMSessionExtendInfo;
import com.didi.beatles.p101im.common.IMBtsAudioHelper;
import com.didi.beatles.p101im.data.IMInnerData;
import com.didi.beatles.p101im.event.IMMessageUnlockRecyclerViewEvent;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.IIMGlobalModule;
import com.didi.beatles.p101im.module.IIMUserModule;
import com.didi.beatles.p101im.module.IMEmojiModule;
import com.didi.beatles.p101im.module.IMUsefulExpressionCallback;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.omega.IMMsgOmega;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p101im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p101im.protocol.model.IMExtendActionItem;
import com.didi.beatles.p101im.protocol.model.IMTabActionItem;
import com.didi.beatles.p101im.protocol.view.IMGuideConfig;
import com.didi.beatles.p101im.protocol.view.IMSkinConfig;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMEmotionInputDetector;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMParamUtil;
import com.didi.beatles.p101im.utils.IMPermissionDescUtil;
import com.didi.beatles.p101im.utils.IMStreetUtils;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.utils.IMToastHelper;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.views.IMRecommendEmojiView;
import com.didi.beatles.p101im.views.bottombar.IMBaseBottomBar;
import com.didi.beatles.p101im.views.bottombar.contain.IMBtmContainCallback;
import com.didi.beatles.p101im.views.bottombar.contain.IMBtmContainManager;
import com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorder;
import com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderAdmin;
import com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg;
import com.didi.beatles.p101im.views.bottombar.tab.IMBtmTabContainManager;
import com.didi.beatles.p101im.views.bottombar.tab.IMBtmTabUtil;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.bottombar.IMConversationBottomBar */
public class IMConversationBottomBar extends IMBaseBottomBar {
    public static final int TYPE_DO_NOTIING = 3;
    public static final int TYPE_SET_VOICE_MODE = 4;
    public static final int TYPE_SHOW_COMMON_WORD = 2;
    public static final int TYPE_SHOW_KEY_BOARD = 1;
    public static final int TYPE_SHOW_ROBOT = 5;

    /* renamed from: j */
    private static final String f11811j = "IMConversationBtmBar";

    /* renamed from: s */
    private static final int f11812s = 5;

    /* renamed from: A */
    private boolean f11813A = false;

    /* renamed from: B */
    private IMBtmRecorder f11814B;

    /* renamed from: C */
    private View.OnClickListener f11815C = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            int id = view.getId();
            if (id == R.id.bottombar_voice_btn) {
                IMConversationBottomBar.this.m10159m();
            } else if (id == R.id.bottombar_keyboard_btn) {
                IMConversationBottomBar.this.setModeKeyboard(false);
            } else if (id == R.id.btn_send) {
                IMConversationBottomBar.this.m10157l();
            } else if (id == R.id.bottombar_commomword_btn) {
                IMConversationBottomBar.this.m10123a(1, false);
            } else if (id == R.id.et_sendmessage) {
                IMConversationBottomBar.this.m10153j();
            } else if (id != R.id.bottombar_more_btn) {
            } else {
                if (!IMConversationBottomBar.this.m10117B()) {
                    IMConversationBottomBar.this.m10123a(2, false);
                } else if (IMConversationBottomBar.this.f11823f.isTagExpandShow(String.valueOf(2))) {
                    IMConversationBottomBar.this.m10123a(3, false);
                } else {
                    IMConversationBottomBar.this.f11826i.invokeActionItem(IMConversationBottomBar.this.f11840y, true);
                }
            }
        }
    };

    /* renamed from: D */
    private View.OnFocusChangeListener f11816D = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z) {
            if (z && IMConversationBottomBar.this.mListener != null) {
                IMConversationBottomBar.this.mListener.onEditFocus();
            }
        }
    };

    /* renamed from: E */
    private TextWatcher f11817E = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!TextUtils.isEmpty(charSequence)) {
                IMConversationBottomBar.this.f11828l.setVisibility(0);
                IMConversationBottomBar.this.f11820c.setVisibility(8);
                IMConversationBottomBar.this.m10144e();
                if (IMConversationBottomBar.this.f11832p) {
                    if (charSequence.toString().length() < 5) {
                        int a = IMConversationBottomBar.this.m10133b(charSequence.toString());
                        if (a != -1) {
                            IMConversationBottomBar.this.m10122a(a);
                        } else {
                            IMConversationBottomBar.this.m10155k();
                        }
                    } else {
                        IMConversationBottomBar.this.m10155k();
                    }
                }
            } else {
                IMConversationBottomBar.this.f11828l.setVisibility(8);
                IMConversationBottomBar.this.m10142d();
                IMConversationBottomBar.this.m10149h();
            }
        }
    };

    /* renamed from: a */
    IMSkinTextView f11818a;

    /* renamed from: b */
    IMSkinTextView f11819b;

    /* renamed from: c */
    IMSkinTextView f11820c;

    /* renamed from: d */
    IMSkinTextView f11821d;

    /* renamed from: e */
    View f11822e;

    /* renamed from: f */
    IMEmotionInputDetector f11823f;

    /* renamed from: g */
    boolean f11824g;

    /* renamed from: h */
    boolean f11825h;

    /* renamed from: i */
    IMBtmContainManager f11826i;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public EditText f11827k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TextView f11828l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public TextView f11829m;
    public View mContentRootView;
    public IMBottomSkinManager mSkinManager;

    /* renamed from: n */
    private TextView f11830n;

    /* renamed from: o */
    private boolean f11831o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f11832p;

    /* renamed from: q */
    private ViewGroup f11833q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public List<IMEmojiModule> f11834r;

    /* renamed from: t */
    private IMBtmTabContainManager f11835t;

    /* renamed from: u */
    private FrameLayout f11836u;

    /* renamed from: v */
    private IMRecommendEmojiView f11837v;

    /* renamed from: w */
    private boolean f11838w = true;

    /* renamed from: x */
    private boolean f11839x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public IMActionItem f11840y = null;

    /* renamed from: z */
    private IMBottomGuideManager f11841z = null;

    public void onActivityCreate() {
        super.onActivityCreate();
        m10135b();
        m10147g();
        m10173v();
        m10174w();
        m10170s();
        m10172u();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View view;
        if (this.mBusinessConfig.getIMStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            view = layoutInflater.inflate(R.layout.bts_im_bottom_bar_global_psg, viewGroup, false);
        } else {
            view = layoutInflater.inflate(R.layout.bts_im_bottom_bar, viewGroup, false);
        }
        m10125a(view);
        return view;
    }

    /* renamed from: a */
    private void m10125a(View view) {
        this.mContentRootView = view;
        view.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_background_round));
        this.f11822e = view.findViewById(R.id.rl_bottom);
        EditText editText = (EditText) view.findViewById(R.id.et_sendmessage);
        this.f11827k = editText;
        editText.setHint(getContext().getString(R.string.bts_im_chat_input_default));
        this.f11827k.setCursorVisible(true);
        this.f11827k.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_input_bg));
        this.f11819b = (IMSkinTextView) view.findViewById(R.id.bottombar_keyboard_btn);
        this.f11818a = (IMSkinTextView) view.findViewById(R.id.bottombar_voice_btn);
        this.f11828l = (TextView) view.findViewById(R.id.btn_send);
        this.f11821d = (IMSkinTextView) view.findViewById(R.id.bottombar_commomword_btn);
        this.f11820c = (IMSkinTextView) view.findViewById(R.id.bottombar_more_btn);
        this.f11828l.setText(getContext().getString(R.string.bts_im_button_send));
        TextView textView = (TextView) view.findViewById(R.id.voice_text);
        this.f11829m = textView;
        textView.setText(getContext().getString(R.string.bts_im_button_pushtotalk));
        this.f11829m.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_voice_text_bg_nor));
        this.f11830n = (TextView) view.findViewById(R.id.disable_text);
        m10140c(view);
        m10136b(view);
    }

    /* renamed from: b */
    private void m10135b() {
        IMBottomSkinManager iMBottomSkinManager = new IMBottomSkinManager();
        this.mSkinManager = iMBottomSkinManager;
        iMBottomSkinManager.bindVoiceBtnView(this.f11818a);
        this.mSkinManager.bindCommonWordView(this.f11821d);
        this.mSkinManager.bindKeyBoardView(this.f11819b);
        this.mSkinManager.bindMoreBtnView(this.f11820c);
        this.mSkinManager.showCommonSkin();
    }

    /* renamed from: c */
    private void m10139c() {
        if (!this.f11831o || this.f11839x || !TextUtils.isEmpty(this.f11827k.getText())) {
            m10144e();
            return;
        }
        IMSkinTextView iMSkinTextView = this.f11821d;
        if (iMSkinTextView != null) {
            iMSkinTextView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10142d() {
        IMSkinTextView iMSkinTextView;
        if (this.f11831o && !this.f11839x && (iMSkinTextView = this.f11821d) != null) {
            iMSkinTextView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10144e() {
        IMSkinTextView iMSkinTextView = this.f11821d;
        if (iMSkinTextView != null) {
            iMSkinTextView.setVisibility(8);
        }
    }

    /* renamed from: b */
    private void m10136b(View view) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.user_view_contain);
        this.f11833q = viewGroup;
        IMBtmContainManager iMBtmContainManager = new IMBtmContainManager(viewGroup, this.mBusinessId);
        this.f11826i = iMBtmContainManager;
        iMBtmContainManager.setCallback(new IMBtmContainCallback() {
            public void backToFunc() {
                IMConversationBottomBar.this.m10123a(2, false);
            }

            public void invokeAction(IMActionItem iMActionItem, final boolean z) {
                if (IMConversationBottomBar.this.mListener != null) {
                    if (z) {
                        if (IMConversationBottomBar.this.m10117B()) {
                            IMTraceUtil.addBusinessEvent("ddim_service_mini_kkrobot_ck").report();
                        } else {
                            IMTraceUtil.addBusinessEvent("ddim_service_kkrobot_add_ck").add("order_id", IMConversationBottomBar.this.m10118C()).add(IMConversationBottomBar.this.m10119D()).report();
                        }
                    }
                    IMActionInvokeReturn invokeAction = IMConversationBottomBar.this.mListener.invokeAction(iMActionItem, new IMActionInvokeEnv(IMConversationBottomBar.this.getContext()) {
                        public String getRobotGuideId() {
                            return IMConversationBottomBar.this.mBusinessParam != null ? IMConversationBottomBar.this.mBusinessParam.getRobotGuideId() : "";
                        }

                        public int getBusinessId() {
                            return IMConversationBottomBar.this.mBusinessId;
                        }

                        public long getSessionId() {
                            if (IMConversationBottomBar.this.mSession != null) {
                                return IMConversationBottomBar.this.mSession.getSessionId();
                            }
                            return 0;
                        }

                        public String getOrderId() {
                            return IMConversationBottomBar.this.m10118C();
                        }

                        public int getActionSource() {
                            return IMConversationBottomBar.this.m10117B() ? z ? 1 : 2 : z ? 3 : 4;
                        }

                        public Map<String, String> getBusinessTraceParam() {
                            return IMConversationBottomBar.this.m10119D();
                        }

                        public int getContentHeight() {
                            return IMConversationBottomBar.this.f11823f.getKeyboardHeight();
                        }
                    });
                    if (!(invokeAction == null || invokeAction.containView == null)) {
                        IMConversationBottomBar.this.f11826i.refreshCustomView(invokeAction.containView, IMConversationBottomBar.this.f11840y == null);
                        IMConversationBottomBar.this.m10123a(3, false);
                    }
                    IMConversationBottomBar.this.f11826i.refreshFuncStatus(iMActionItem);
                }
            }

            public void sendCommonWord(String str, int i) {
                IMTraceUtil.addBusinessEvent("ddim_service_kkrobot_msglist_ck").add("order_id", IMConversationBottomBar.this.m10118C()).add("tips_text", str).add(IMConversationBottomBar.this.m10119D()).report();
                if (IMConversationBottomBar.this.mListener != null) {
                    IMConversationBottomBar.this.mListener.onTextMessageSend(str, 65536, i);
                }
            }

            public void addCommonWord(int i) {
                if (IMConversationBottomBar.this.mListener != null) {
                    IMConversationBottomBar.this.mListener.showAddCustomWordDialog((String) null, 1, i);
                }
            }

            public void sendEmoji(String str, String str2, String str3) {
                if (IMConversationBottomBar.this.mListener != null) {
                    IMConversationBottomBar.this.mListener.sendEmoji(str, str2, str3);
                }
            }
        });
    }

    /* renamed from: c */
    private void m10140c(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.im_bottom_tab_contain_container);
        this.f11836u = frameLayout;
        IMBtmTabContainManager iMBtmTabContainManager = new IMBtmTabContainManager(frameLayout, this.mBusinessId);
        this.f11835t = iMBtmTabContainManager;
        iMBtmTabContainManager.setExtraTraceMap(m10119D());
        this.f11835t.setCallback(new IMBtmTabContainManager.IMBtmTabContainCallback() {
            public void invokeMsgAction(boolean z) {
                IMConversationBottomBar.this.m10123a(1, true);
            }

            public void invokeEmojiAction(boolean z) {
                IMConversationBottomBar.this.m10123a(4, true);
            }

            public void invokeFuncAction(boolean z) {
                IMConversationBottomBar.this.m10123a(2, true);
            }

            public void invokePluginAction(final IMTabActionItem iMTabActionItem, final boolean z) {
                IMActionInvokeReturn invokeTabAction;
                if (IMConversationBottomBar.this.mListener != null && (invokeTabAction = IMConversationBottomBar.this.mListener.invokeTabAction(iMTabActionItem, new IMActionInvokeEnv(IMConversationBottomBar.this.getContext()) {
                    public String getRobotGuideId() {
                        return IMConversationBottomBar.this.mBusinessParam != null ? IMConversationBottomBar.this.mBusinessParam.getRobotGuideId() : "";
                    }

                    public int getBusinessId() {
                        return IMConversationBottomBar.this.mBusinessId;
                    }

                    public long getSessionId() {
                        if (IMConversationBottomBar.this.mSession != null) {
                            return IMConversationBottomBar.this.mSession.getSessionId();
                        }
                        return 0;
                    }

                    public String getOrderId() {
                        return IMConversationBottomBar.this.m10118C();
                    }

                    public int getActionSource() {
                        return z ? 5 : 6;
                    }

                    public Map<String, String> getBusinessTraceParam() {
                        return IMConversationBottomBar.this.m10119D();
                    }

                    public int getContentHeight() {
                        return IMConversationBottomBar.this.f11823f.getKeyboardHeight();
                    }

                    public int getPluginTheme() {
                        if (iMTabActionItem.pluginId != 3) {
                            return super.getPluginTheme();
                        }
                        if (IMConversationBottomBar.this.mSession == null || IMConversationBottomBar.this.mSession.getExtendSessionInfo() == null || IMConversationBottomBar.this.mSession.getExtendSessionInfo().robotTheme != 1) {
                            return 0;
                        }
                        return 1;
                    }
                })) != null && invokeTabAction.containView != null) {
                    IMConversationBottomBar.this.f11826i.refreshCustomView(invokeTabAction.containView, false);
                    IMConversationBottomBar.this.m10123a(3, true);
                }
            }
        });
    }

    /* renamed from: f */
    private boolean m10146f() {
        IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.mBusinessId);
        if (currentBusinessConfig == null) {
            return true;
        }
        return currentBusinessConfig.isUseAudioMessage();
    }

    public void setRecommendEmojiView(IMRecommendEmojiView iMRecommendEmojiView) {
        this.f11837v = iMRecommendEmojiView;
        iMRecommendEmojiView.setRecommondListener(new IMRecommendEmojiView.RecommendListener() {
            public void onClick(String str, String str2, String str3) {
                if (IMConversationBottomBar.this.mListener != null) {
                    IMConversationBottomBar.this.f11827k.setText("");
                    IMConversationBottomBar.this.mListener.sendEmoji(str, str2, str3);
                }
            }
        });
    }

    /* renamed from: g */
    private void m10147g() {
        this.f11818a.setViewClickListener(this.f11815C);
        this.f11819b.setViewClickListener(this.f11815C);
        this.f11829m.setOnClickListener(this.f11815C);
        this.f11828l.setOnClickListener(this.f11815C);
        this.f11827k.setOnClickListener(this.f11815C);
        this.f11820c.setViewClickListener(this.f11815C);
        this.f11821d.setViewClickListener(this.f11815C);
        this.f11827k.addTextChangedListener(this.f11817E);
        this.f11827k.setOnFocusChangeListener(this.f11816D);
        if (this.mBusinessConfig.getIMStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            this.f11814B = new IMBtmRecorderGlobalPsg();
        } else {
            this.f11814B = new IMBtmRecorderAdmin();
        }
        this.f11814B.bindListener(this.f11829m, this);
    }

    public void bindEmotionInputDetector(Activity activity, View view) {
        this.f11823f = IMEmotionInputDetector.with(activity).setEmotionView(this.f11833q).bindToContent(view).bindToEditText(this.f11827k).bindToCommonButton(this.f11821d).bindToBottom(this).build();
    }

    public IMEmotionInputDetector getEmotion() {
        return this.f11823f;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m10149h() {
        if (!this.f11824g || this.f11828l.isShown()) {
            this.f11820c.setVisibility(8);
        } else {
            this.f11820c.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m10129a(String str) {
        IMLog.m10020d(f11811j, "[showChatDisable]  disableHint=" + str);
        IMViewUtil.show((View) this.f11830n);
        IMViewUtil.hide(this.f11822e);
        if (TextUtils.isEmpty(str)) {
            this.f11830n.setText(IMResource.getString(R.string.im_can_not_send_msg));
        } else {
            this.f11830n.setText(str);
        }
        ViewGroup viewGroup = this.f11833q;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        IMBtmTabContainManager iMBtmTabContainManager = this.f11835t;
        if (iMBtmTabContainManager != null) {
            iMBtmTabContainManager.clear();
        }
    }

    /* renamed from: a */
    private void m10131a(boolean z, String str) {
        IMEmotionInputDetector iMEmotionInputDetector;
        IMLog.m10020d(f11811j, "showChatExpire: " + z);
        IMViewUtil.show(this.f11822e);
        IMViewUtil.hide((View) this.f11830n);
        if (this.f11838w) {
            setModeKeyboard(true);
            this.f11838w = false;
        }
        this.f11827k.setFocusable(z);
        this.f11827k.setFocusableInTouchMode(z);
        this.f11827k.setEnabled(z);
        this.f11818a.setClickable(z);
        this.f11820c.setClickable(z);
        this.f11821d.setClickable(z);
        this.f11829m.setEnabled(z);
        this.f11819b.setEnabled(z);
        if (!z) {
            this.f11827k.setHintTextColor(IMResource.getColor(R.color.bts_im_editview_disable));
            if (TextUtils.isEmpty(str)) {
                this.f11827k.setHint(IMResource.getString(R.string.im_can_not_send_msg));
            } else {
                this.f11827k.setHint(str);
            }
            if (!this.mSession.getSessionEnable() || m10152i()) {
                IMLog.m10024i(f11811j, "[showChatExpire] hide expand view with session is expired");
                this.f11833q.setVisibility(8);
            }
            this.mSkinManager.showDisableSkin();
            return;
        }
        this.f11827k.setHintTextColor(IMResource.getColor(R.color.bts_im_editview_able));
        this.f11827k.setHint(IMResource.getString(R.string.bts_im_chat_input_default));
        this.mSkinManager.showCommonSkin();
        if (this.f11833q.getVisibility() == 0 && (iMEmotionInputDetector = this.f11823f) != null && !iMEmotionInputDetector.isTagExpandShow("3") && this.mBusinessConfig.getIMStyle() != IMStyleManager.Style.GLOBAL_PSG) {
            this.f11821d.showCustomSkin(IMBottomSkinManager.KEY_BOARD);
        }
    }

    /* renamed from: i */
    private boolean m10152i() {
        List<IMSessionExtendInfo.BottomTabInfo> list;
        IMBtmTabContainManager iMBtmTabContainManager;
        int checkedPluginId;
        if (this.mSession == null || this.mSession.getExtendSessionInfo() == null || (list = this.mSession.getExtendSessionInfo().bottomTabInfoList) == null || list.size() == 0 || (iMBtmTabContainManager = this.f11835t) == null || (checkedPluginId = iMBtmTabContainManager.getCheckedPluginId()) == -1) {
            return true;
        }
        for (IMSessionExtendInfo.BottomTabInfo next : list) {
            if (next != null && next.f10966id == checkedPluginId && next.isEnable()) {
                IMLog.m10020d(f11811j, C4786I.m9980t("[shouldHideCurrentTabPanel] Still show tab : " + checkedPluginId));
                return false;
            }
        }
        IMLog.m10020d(f11811j, C4786I.m9980t("[shouldHideCurrentTabPanel] Should hide tab : " + checkedPluginId));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m10153j() {
        if (TextUtils.isEmpty(this.f11827k.getText().toString())) {
            this.f11821d.showCommonSkin();
            m10139c();
            m10149h();
        }
        m10130a(false);
        m10166p();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m10133b(String str) {
        List<IMEmojiModule> list = this.f11834r;
        if (list == null || list.size() == 0) {
            return -1;
        }
        for (int i = 0; i < this.f11834r.size(); i++) {
            if (this.f11834r.get(i).desc != null && this.f11834r.get(i).desc.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10122a(int i) {
        List<IMEmojiModule> list = this.f11834r;
        if (list != null && list.size() >= i) {
            this.f11837v.show(this.f11834r.get(i));
            HashMap hashMap = new HashMap();
            hashMap.put("name", this.f11834r.get(i).desc);
            IMMsgOmega.getInstance().track("ddim_dy_all_icon_sw", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m10155k() {
        if (this.f11837v.isShown()) {
            this.f11837v.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m10157l() {
        String trim = this.f11827k.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            this.mListener.onTextMessageSend(trim, 65536, -1);
            this.f11827k.setText("");
            return;
        }
        IMToastHelper.showShortInfo(getContext(), IMResource.getString(R.string.im_input_not_null));
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m10159m() {
        if (PermissionUtil.checkPermissionAllGranted(this.context, Permission.RECORD_AUDIO)) {
            try {
                if (IMBtsAudioHelper.checkRecordPermission()) {
                    if (this.mListener != null) {
                        this.mListener.onEditFocus();
                    }
                    m10169r();
                    m10130a(false);
                    this.f11821d.showCommonSkin();
                    m10142d();
                    this.f11827k.setVisibility(8);
                    this.f11818a.setVisibility(8);
                    this.f11819b.setVisibility(0);
                    this.f11828l.setVisibility(8);
                    this.f11829m.setVisibility(0);
                    m10149h();
                    m10163o();
                }
            } catch (Exception unused) {
                SystemUtils.showToast(Toast.makeText(getContext(), IMResource.getString(R.string.im_something_wrong_with_record_permission), 0));
            }
        } else {
            IMPermissionDescUtil.INSTANCE.showPermissionDesc(this.context, Permission.RECORD_AUDIO);
            PermissionUtil.requestPermissions((PermissionContext) getContext(), (PermissionCallback) new PermissionCallback() {
                public void isAllGranted(boolean z, String[] strArr) {
                    if (!((Activity) IMConversationBottomBar.this.getContext()).isFinishing()) {
                        IMPermissionDescUtil.INSTANCE.hidePermissionDesc();
                        if (z) {
                            try {
                                if (IMBtsAudioHelper.checkRecordPermission()) {
                                    if (IMConversationBottomBar.this.mListener != null) {
                                        IMConversationBottomBar.this.mListener.onEditFocus();
                                    }
                                    IMConversationBottomBar.this.m10169r();
                                    IMConversationBottomBar.this.m10130a(false);
                                    IMConversationBottomBar.this.f11821d.showCommonSkin();
                                    IMConversationBottomBar.this.m10142d();
                                    IMConversationBottomBar.this.f11827k.setVisibility(8);
                                    IMConversationBottomBar.this.f11818a.setVisibility(8);
                                    IMConversationBottomBar.this.f11819b.setVisibility(0);
                                    IMConversationBottomBar.this.f11828l.setVisibility(8);
                                    IMConversationBottomBar.this.f11829m.setVisibility(0);
                                    IMConversationBottomBar.this.m10149h();
                                    IMConversationBottomBar.this.m10163o();
                                }
                            } catch (Exception unused) {
                                SystemUtils.showToast(Toast.makeText(IMConversationBottomBar.this.getContext(), IMResource.getString(R.string.im_something_wrong_with_record_permission), 0));
                            }
                        }
                    }
                }
            }, Permission.RECORD_AUDIO, false);
        }
    }

    /* renamed from: n */
    private void m10161n() {
        IMBtmTabContainManager iMBtmTabContainManager = this.f11835t;
        if (iMBtmTabContainManager != null) {
            iMBtmTabContainManager.showTab();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m10163o() {
        IMBtmTabContainManager iMBtmTabContainManager = this.f11835t;
        if (iMBtmTabContainManager != null) {
            iMBtmTabContainManager.hideTab();
        }
    }

    /* renamed from: p */
    private void m10166p() {
        IMBtmTabContainManager iMBtmTabContainManager = this.f11835t;
        if (iMBtmTabContainManager != null) {
            iMBtmTabContainManager.reset();
        }
    }

    public void setModeKeyboard(boolean z) {
        if (!z) {
            m10167q();
            m10130a(false);
        }
        this.f11827k.setVisibility(0);
        this.f11819b.setVisibility(8);
        this.f11818a.setVisibility(m10146f() ? 0 : 8);
        this.f11827k.requestFocus();
        this.f11829m.setVisibility(8);
        m10161n();
        if (TextUtils.isEmpty(this.f11827k.getText())) {
            this.f11828l.setVisibility(8);
            m10142d();
            m10149h();
            return;
        }
        m10144e();
        this.f11828l.setVisibility(0);
        this.f11820c.setVisibility(8);
    }

    /* renamed from: q */
    private void m10167q() {
        IMEmotionInputDetector iMEmotionInputDetector = this.f11823f;
        if (iMEmotionInputDetector != null) {
            iMEmotionInputDetector.showSoftInput();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m10169r() {
        IMEmotionInputDetector iMEmotionInputDetector = this.f11823f;
        if (iMEmotionInputDetector != null) {
            iMEmotionInputDetector.hideSoftInput();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10130a(boolean z) {
        if (this.f11833q.isShown()) {
            this.f11833q.setVisibility(8);
            EventBus.getDefault().post(new IMMessageUnlockRecyclerViewEvent(0));
            if (!z) {
                this.f11821d.showCommonSkin();
            }
            m10166p();
        }
    }

    public IMBaseBottomBar.BottomBarListener getBottomBarListener() {
        return this.mListener;
    }

    /* renamed from: s */
    private void m10170s() {
        String draft = this.mSession.getDraft();
        if (!IMTextUtil.isEmpty(draft)) {
            this.f11827k.setText(draft);
            this.f11827k.requestFocus();
            this.f11827k.setSelection(draft.length());
        }
    }

    /* renamed from: t */
    private void m10171t() {
        IMLog.m10020d(f11811j, "[resetDraft]");
        EditText editText = this.f11827k;
        if (editText != null) {
            editText.setText("");
        }
    }

    /* renamed from: u */
    private void m10172u() {
        IMBottomGuideManager iMBottomGuideManager = new IMBottomGuideManager(this);
        this.f11841z = iMBottomGuideManager;
        iMBottomGuideManager.showBottomGuide();
    }

    public void onDestroy() {
        super.onDestroy();
        EditText editText = this.f11827k;
        if (editText != null) {
            editText.removeTextChangedListener(this.f11817E);
            this.f11827k.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.f11827k.setCursorVisible(false);
        }
        IMBtmContainManager iMBtmContainManager = this.f11826i;
        if (iMBtmContainManager != null) {
            iMBtmContainManager.release();
        }
        IMBottomGuideManager iMBottomGuideManager = this.f11841z;
        if (iMBottomGuideManager != null) {
            iMBottomGuideManager.release();
        }
        IMBtmTabContainManager iMBtmTabContainManager = this.f11835t;
        if (iMBtmTabContainManager != null) {
            iMBtmTabContainManager.release();
        }
    }

    /* renamed from: v */
    private void m10173v() {
        this.f11832p = this.mBusinessConfig.isShowEmoji();
        this.f11831o = this.mBusinessConfig.isShowUsefulExpression();
    }

    /* renamed from: w */
    private void m10174w() {
        m10139c();
        if (!(this.mSession == null || this.mSession.getExtendSessionInfo() == null)) {
            IMSessionExtendInfo extendSessionInfo = this.mSession.getExtendSessionInfo();
            boolean z = extendSessionInfo.bottomTabInfoList != null && extendSessionInfo.bottomTabInfoList.size() > 0;
            if (this.mSession.getExtendSessionInfo().openActionIds == null || !this.mSession.getExtendSessionInfo().openActionIds.contains(3)) {
                if (z) {
                    if (!this.mSession.getSessionEnable()) {
                        IMLog.m10024i(f11811j, "TAB btm session disable so initBottomInput return");
                        return;
                    }
                } else if (this.mSession.getExtendSessionInfo().input == 0) {
                    IMLog.m10024i(f11811j, "mSession status is disable initBottomInput return");
                    return;
                }
            } else if (!this.mSession.getSessionEnable()) {
                IMLog.m10024i(f11811j, "robot btm session disable so initBottomInput return");
                return;
            }
        }
        if (this.mBusinessParam != null) {
            int bottomInputConfig = this.mBusinessParam.getBottomInputConfig();
            if (bottomInputConfig == 4 && !m10146f()) {
                bottomInputConfig = 3;
            }
            if (bottomInputConfig == 1) {
                m10167q();
                m10137b(false);
            } else if (bottomInputConfig == 2) {
                m10137b(true);
            } else if (bottomInputConfig == 3) {
                m10137b(false);
            } else if (bottomInputConfig == 4) {
                m10159m();
            } else if (bottomInputConfig != 5) {
                m10137b(this.mBusinessConfig.isDefaultOpenUsefulExpression());
            } else {
                m10137b(true);
                IMBtmTabContainManager iMBtmTabContainManager = this.f11835t;
                if (iMBtmTabContainManager != null) {
                    iMBtmTabContainManager.setCheck(3);
                }
            }
        }
    }

    /* renamed from: b */
    private void m10137b(boolean z) {
        IMLog.m10020d(f11811j, "initReplayAndEmoji isShow:" + this.f11831o + " isExpand: " + z + " isEmoji:" + this.f11832p);
        if (this.f11831o) {
            this.f11826i.configMsg(this.f11832p);
            m10177z();
            if (z && !m10175x() && !m10176y()) {
                m10123a(1, false);
            }
            if (m10117B()) {
                IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("ddim_service_mini_kkrobot_sw").add("order_id", m10118C()).add(m10119D());
                IMActionItem iMActionItem = this.f11840y;
                if (!(iMActionItem == null || iMActionItem.item == null)) {
                    IMExtendActionItem iMExtendActionItem = this.f11840y.item;
                    Context context = getContext();
                    IMGuideConfig btmGuideConfig = iMExtendActionItem.getBtmGuideConfig(context, this.mSession.getSessionId() + "", this.mListener.getBottomGuideConfigList());
                    if (btmGuideConfig != null) {
                        add.add("btn_tips", btmGuideConfig.text);
                    }
                }
                add.report();
                return;
            }
            return;
        }
        this.f11833q.setVisibility(8);
    }

    /* renamed from: x */
    private boolean m10175x() {
        IMBtmContainManager iMBtmContainManager = this.f11826i;
        if (iMBtmContainManager == null) {
            return false;
        }
        for (IMActionItem next : iMBtmContainManager.getFuncList()) {
            if (next.item != null && next.enable && next.item.invokeWhenEnter()) {
                this.f11826i.invokeActionItem(next, false);
                return true;
            }
        }
        return false;
    }

    /* renamed from: y */
    private boolean m10176y() {
        List<IMTabActionItem> tabActionItemList;
        IMBtmTabContainManager iMBtmTabContainManager = this.f11835t;
        if (iMBtmTabContainManager == null || (tabActionItemList = iMBtmTabContainManager.getTabActionItemList()) == null) {
            return false;
        }
        int bottomTabSelectPluginId = IMPreference.getInstance(getContext()).getBottomTabSelectPluginId(IMCommonContextInfoHelper.getUid(), 4);
        for (IMTabActionItem next : tabActionItemList) {
            if (next.enable && bottomTabSelectPluginId == next.pluginId) {
                IMLog.m10020d(f11811j, C4786I.m9980t("[tryShowTabActionWhenInit] setCheck=", Integer.valueOf(bottomTabSelectPluginId)));
                this.f11835t.setCheck(next.pluginId);
                return true;
            }
        }
        return false;
    }

    /* renamed from: z */
    private void m10177z() {
        boolean z;
        IMSkinConfig moreSkinConfig;
        if (this.f11831o) {
            this.f11826i.refreshSystemComWords(this.mBusinessConfig.getQuickMessages(mo48907a(), this.mBusinessId), IMStreetUtils.enableStreetImage(this.mSession));
            IIMUserModule userModel = IMManager.getInstance().getUserModel();
            if (userModel == null) {
                IMLog.m10021e(f11811j, "getCustomCommonWord failed while userModule is null !");
            } else if (!this.f11813A) {
                this.f11813A = true;
                userModel.executeUsfulExpression(3, 0, (String) null, new IMUsefulExpressionCallback() {
                    public void onResponse(int i, String str) {
                        if (i == 0) {
                            IMConversationBottomBar.this.f11826i.refreshCustomWords(IMManager.getInstance().getCustomUsefulExpression());
                        }
                    }
                });
            }
            this.f11834r = null;
            if (this.mBusinessConfig.isShowEmoji()) {
                IMLog.m10024i(f11811j, "try load list while get getIMEmojiList");
                this.mBusinessConfig.getIMEmojiList(mo48907a(), this.mBusinessId, new ConfigLoadListener.IMGetEmojiListCallback() {
                    public void finishLoad(ArrayList<IMEmojiModule> arrayList) {
                        if (arrayList == null || arrayList.size() == 0) {
                            IMLog.m10021e(IMConversationBottomBar.f11811j, "list is null while getIMEmojiList");
                        }
                        List unused = IMConversationBottomBar.this.f11834r = arrayList;
                        IMConversationBottomBar.this.f11826i.refreshEmojis(arrayList);
                    }
                });
            }
            if (this.f11834r != null) {
                IMLog.m10024i(f11811j, "remove tab emoji config while getIMEmojiList");
                IMSessionExtendInfo.BottomTabInfo tab = IMBtmTabUtil.getTab(getBottomBarListener(), 6);
                if (tab != null) {
                    tab.ignore = true;
                }
            } else if (IMBtmTabUtil.getTab(getBottomBarListener(), 6) != null) {
                IMLog.m10024i(f11811j, "try load im emoji config while getIMEmojiList");
                this.f11832p = true;
                IIMGlobalModule globalModel = IMManager.getInstance().getGlobalModel();
                if (globalModel != null) {
                    if (globalModel.getCommonConfig() != null) {
                        IMInnerData.getInstance().setEmojiPrefix(globalModel.getCommonConfig().emojiUrlPrefix);
                    }
                    if (this.mSession.getExtendSessionInfo() != null) {
                        this.f11834r = globalModel.getEmojiConfigList(this.mBusinessId, this.mSession.getExtendSessionInfo().emojiKey);
                    }
                }
                this.f11826i.refreshTabEmojis(this.f11834r);
            }
        }
        List<IMActionItem> systemAction = this.mListener == null ? null : this.mListener.getSystemAction();
        List<IMActionItem> interceptMoreAction = this.mListener.interceptMoreAction(this.mBusinessConfig.getIMMoreAction(mo48907a()));
        if (!(interceptMoreAction == null || this.mSession.getExtendSessionInfo() == null)) {
            for (IMActionItem iMActionItem : interceptMoreAction) {
                iMActionItem.enable = this.mSession.getExtendSessionInfo().input != 0;
            }
        }
        ArrayList<IMActionItem> arrayList = new ArrayList<>();
        if (systemAction != null) {
            arrayList.addAll(systemAction);
        }
        if (interceptMoreAction != null) {
            arrayList.addAll(interceptMoreAction);
        }
        List<IMSessionExtendInfo.BottomTabInfo> bottomTabList = this.mListener != null ? this.mListener.getBottomTabList() : null;
        if (bottomTabList != null) {
            Iterator<IMSessionExtendInfo.BottomTabInfo> it = bottomTabList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IMSessionExtendInfo.BottomTabInfo next = it.next();
                if (next != null && next.f10966id == 5) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z2 = !z && arrayList.size() > 0;
        this.f11824g = z2;
        if (z2 && !this.f11825h && this.mBusinessConfig != null) {
            this.f11825h = true;
            this.mBusinessConfig.onMoreButtonShow(this.mSession, this.mBusinessParam);
        }
        this.f11826i.refreshSystemFunc(systemAction);
        this.f11826i.refreshMoreFunc(interceptMoreAction);
        m10116A();
        this.f11840y = null;
        this.mSkinManager.bindMoreBtnView(this.f11820c);
        if (arrayList.size() == 1) {
            IMActionItem iMActionItem2 = (IMActionItem) arrayList.get(0);
            this.f11840y = iMActionItem2;
            if (!(iMActionItem2.item == null || (moreSkinConfig = iMActionItem2.item.moreSkinConfig(getContext())) == null)) {
                this.mSkinManager.updateBtnView(this.f11820c, moreSkinConfig);
            }
        }
        this.f11820c.resetViewSkin();
        m10149h();
        if (this.mSession.getExtendSessionInfo().input == 0) {
            for (IMActionItem iMActionItem3 : arrayList) {
                if (iMActionItem3.enable) {
                    this.f11820c.showCommonSkin();
                    this.f11820c.setClickable(true);
                    return;
                }
            }
        }
    }

    /* renamed from: A */
    private void m10116A() {
        if (this.mSession != null && this.mSession.getExtendSessionInfo() != null) {
            boolean z = true;
            if (!this.mSession.getSessionEnable()) {
                IMLog.m10020d(f11811j, "[onUpdateBottomTabInfo] Disable bottom tab");
                return;
            }
            List<IMSessionExtendInfo.BottomTabInfo> bottomTabList = this.mListener != null ? this.mListener.getBottomTabList() : null;
            this.f11835t.refreshTabList(bottomTabList, this.mSession.getExtendSessionInfo().robotTheme);
            if (bottomTabList == null) {
                this.f11839x = false;
            } else {
                Iterator<IMSessionExtendInfo.BottomTabInfo> it = bottomTabList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    IMSessionExtendInfo.BottomTabInfo next = it.next();
                    if (next != null && next.f10966id == 4) {
                        break;
                    }
                }
                this.f11839x = z;
            }
            IMLog.m10020d(f11811j, "[onUpdateBottomTabInfo] mHideCommonWordBtnWithTabUI=" + this.f11839x);
            m10139c();
        }
    }

    public void onStatusChanged(IMSession iMSession) {
        if (iMSession != null && iMSession.getExtendSessionInfo() != null) {
            this.mSession = iMSession;
            if (!iMSession.getSessionEnable() || iMSession.getExtendSessionInfo().input == 0) {
                m10171t();
            }
            if (iMSession.getSessionEnable()) {
                m10131a(iMSession.getSessionEnable() && iMSession.getExtendSessionInfo().input != 0, iMSession.getExtendSessionInfo().na_txt);
                m10177z();
                return;
            }
            m10129a(iMSession.getExtendSessionInfo().naTxtInvalid);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo48907a() {
        if (this.mBusinessId == 259) {
            return this.mSession.getExtendSessionInfo().qk_key;
        }
        return this.mBusinessParam != null ? this.mBusinessParam.getSceneKey() : "";
    }

    public void resumeInitStatus() {
        getViewRoot().postDelayed(new Runnable() {
            public void run() {
                IMConversationBottomBar.this.f11829m.setText(IMResource.getString(R.string.im_bottombar_record));
                IMConversationBottomBar.this.f11829m.setTextColor(IMResource.getColor(R.color.im_color_333));
                IMConversationBottomBar.this.f11829m.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_voice_text_bg_nor));
            }
        }, 200);
        this.mContentRootView.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_background_round));
        this.mSkinManager.showCommonSkin();
    }

    public void shrinkBottomBar() {
        boolean z = (this.mSession == null || this.mSession.getExtendSessionInfo() == null || this.mSession.getExtendSessionInfo().input != 0) ? false : true;
        EditText editText = this.f11827k;
        if (editText != null) {
            editText.clearFocus();
        }
        m10130a(z);
        m10169r();
    }

    public void shrinkBottomBarByRecycle() {
        if (this.mBusinessConfig.getIMStyle() != IMStyleManager.Style.GLOBAL_PSG) {
            super.shrinkBottomBarByRecycle();
        } else if (this.f11823f.isSoftInputShown()) {
            m10123a(1, false);
        } else if (!this.f11823f.isTagExpandShow("1")) {
            super.shrinkBottomBarByRecycle();
        }
    }

    public boolean onBackPressed() {
        IMBtmTabContainManager iMBtmTabContainManager;
        IMBtmRecorder iMBtmRecorder = this.f11814B;
        boolean z = true;
        if (iMBtmRecorder != null && iMBtmRecorder.interceptBackPressed()) {
            return true;
        }
        if (getEmotion() == null || !getEmotion().interceptBackPress()) {
            z = false;
        }
        if (z && (iMBtmTabContainManager = this.f11835t) != null) {
            iMBtmTabContainManager.reset();
        }
        return z;
    }

    public void onPause() {
        IMSession iMSession = this.mSession;
        EditText editText = this.f11827k;
        iMSession.setDraft(editText != null ? editText.getText().toString() : "");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10123a(int i, boolean z) {
        if (this.f11823f != null && this.f11826i != null) {
            boolean z2 = false;
            if (this.mSession.getExtendSessionInfo() == null || this.mSession.getExtendSessionInfo().input != 1) {
                if (this.f11823f.isTagExpandShow(String.valueOf(i))) {
                    shrinkBottomBar();
                } else {
                    if (i == 1) {
                        z2 = true;
                    }
                    m10124a(i, z2, z);
                }
                this.f11821d.showDisableSkin();
            } else if (this.mBusinessConfig.getIMStyle() != IMStyleManager.Style.GLOBAL_PSG) {
                if (i == 1) {
                    z2 = true;
                }
                m10124a(i, z2, z);
            } else if (this.f11823f.isTagExpandShow(String.valueOf(i))) {
                shrinkBottomBar();
            } else {
                m10124a(i, false, z);
            }
        }
    }

    /* renamed from: a */
    private void m10124a(int i, boolean z, boolean z2) {
        IMEmotionInputDetector iMEmotionInputDetector = this.f11823f;
        if (iMEmotionInputDetector != null && this.f11826i != null) {
            if (!iMEmotionInputDetector.isTagExpandShow(String.valueOf(i))) {
                if (i == 2) {
                    IMTraceUtil.addBusinessEvent("ddim_service_kkrobot_add_sw").add("order_id", m10118C()).add(m10119D()).report();
                }
                if (this.mBusinessConfig != null) {
                    this.mBusinessConfig.onBottomBarExpandViewShow(i, this.mSession, this.mBusinessParam);
                }
            }
            if (!z2) {
                m10166p();
            }
            this.f11823f.changeExpandView(String.valueOf(i), z);
            this.f11826i.showContainView(i, IMStreetUtils.enableStreetImage(this.mSession));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public boolean m10117B() {
        IMActionItem iMActionItem = this.f11840y;
        return (iMActionItem == null || iMActionItem.item == null || !this.f11840y.item.moreInvokeAction()) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public String m10118C() {
        return IMParamUtil.getTraceOrderId(this.mBusinessParam, this.mSession);
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public Map<String, String> m10119D() {
        return IMParamUtil.getTraceExtra(this.mBusinessParam, this.mActivityFrom);
    }
}
