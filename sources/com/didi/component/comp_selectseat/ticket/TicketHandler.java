package com.didi.component.comp_selectseat.ticket;

import android.text.TextUtils;
import com.didi.component.common.util.GLog;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TicketHandler implements IRouterHandler {

    /* renamed from: a */
    private static final String f14342a = "TicketHandler";

    public void handle(Request request, Result result) {
        String queryParameter = request.getUri().getQueryParameter("detail_data");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                String decode = URLDecoder.decode(queryParameter, "UTF-8");
                GLog.m11357e(f14342a, "handle: " + decode);
                if (((TicketModel) new Gson().fromJson(decode, TicketModel.class)) != null) {
                    request.getContext().startActivity(TicketActivity.getIntent(request.getContext(), decode));
                } else {
                    GLog.m11357e(f14342a, "ticketModel is null ");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                GLog.m11357e(f14342a, " setData>> " + e2.toString());
            }
        }
    }
}
