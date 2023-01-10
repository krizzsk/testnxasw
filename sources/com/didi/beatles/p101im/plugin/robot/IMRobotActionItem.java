package com.didi.beatles.p101im.plugin.robot;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.beatles.p101im.IMCommonContextInfoHelper;
import com.didi.beatles.p101im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p101im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p101im.protocol.model.IMBottomGuideConfig;
import com.didi.beatles.p101im.protocol.model.IMExtendActionItem;
import com.didi.beatles.p101im.protocol.view.IMGuideConfig;
import com.didi.beatles.p101im.protocol.view.IMSkinConfig;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotActionItem */
public class IMRobotActionItem extends IMExtendActionItem {
    /* renamed from: a */
    private int m9819a() {
        return 3;
    }

    public boolean moreInvokeAction() {
        return true;
    }

    public IMRobotActionItem(Context context) {
        super(3, context.getString(R.string.im_plugin_robot_action_title), R.drawable.im_plugin_robot_action_icon);
    }

    public boolean invokeWhenEnter() {
        return IMRobotGuideHelper.enterShow();
    }

    public IMSkinConfig moreSkinConfig(Context context) {
        IMSkinConfig iMSkinConfig = new IMSkinConfig();
        iMSkinConfig.skinElement.add(new IMSkinConfig.Element(2, R.drawable.im_robot_more_btn));
        iMSkinConfig.skinElement.add(new IMSkinConfig.Element(1, R.drawable.im_robot_more_btn_d));
        iMSkinConfig.skinElement.add(new IMSkinConfig.Element(3, R.drawable.im_robot_more_btn_c));
        return iMSkinConfig;
    }

    public boolean funcRedDot(Context context) {
        return IMRobotGuideHelper.canFuncRedDot(context, IMCommonContextInfoHelper.getUid(), m9819a());
    }

    public IMGuideConfig getBtmGuideConfig(Context context, String str, List<IMBottomGuideConfig> list) {
        IMBottomGuideConfig a = m9820a(list);
        if (IMRobotGuideHelper.canShowPop(context, IMCommonContextInfoHelper.getUid(), str, a)) {
            return IMRobotGuideHelper.popShowConfig(context, a);
        }
        return null;
    }

    public void showBtmGuide(Context context, IMGuideConfig iMGuideConfig, String str) {
        IMRobotGuideHelper.onShowPop(context, IMCommonContextInfoHelper.getUid(), str);
    }

    public IMActionInvokeReturn invokeAction(Context context, IMActionInvokeEnv iMActionInvokeEnv) {
        IMRobotConstant.setData(iMActionInvokeEnv.getOrderId(), iMActionInvokeEnv.getBusinessTraceParam(), iMActionInvokeEnv.getActionSource());
        IMRobotGuideHelper.onClickRedDot(context, IMCommonContextInfoHelper.getUid(), m9819a());
        IMActionInvokeReturn iMActionInvokeReturn = new IMActionInvokeReturn();
        IMRobotPanelView iMRobotPanelView = new IMRobotPanelView(context, iMActionInvokeEnv);
        iMRobotPanelView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        iMActionInvokeReturn.containView = iMRobotPanelView;
        return iMActionInvokeReturn;
    }

    /* renamed from: a */
    private IMBottomGuideConfig m9820a(List<IMBottomGuideConfig> list) {
        if (list != null && !list.isEmpty()) {
            for (IMBottomGuideConfig next : list) {
                if (next.pluginId == 3) {
                    return next;
                }
            }
        }
        return null;
    }
}
