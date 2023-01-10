package com.didi.sdk.sidebar.handler;

import com.didi.app.router.sidebar.BaseSideBarDRouterHandler;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didichuxing.xpanel.util.LogcatUtil;

public class MessageCenterHandler extends BaseSideBarDRouterHandler {
    public void callRealHandle(Request request, Result result) {
        LogcatUtil.m39237d("MessageCenterHandler", "handle clicked" + request.getUri());
        IMEngine.startChatListActivity(request.getContext());
    }
}
