package com.didi.drouter.router;

import android.app.Activity;
import android.content.Intent;

public class RouterHelper {
    public static Request getRequest(Activity activity) {
        Intent intent = activity.getIntent();
        return getRequest(intent != null ? intent.getStringExtra("DRouter_start_activity_request_number") : null);
    }

    public static Result getResult(Activity activity) {
        Request request = getRequest(activity);
        if (request != null) {
            return getResult(request.getNumber());
        }
        return null;
    }

    public static Request getRequest(String str) {
        return C8531c.m17797a(str);
    }

    public static Result getResult(String str) {
        return C8531c.m17805c(str);
    }

    public static void release(Activity activity) {
        C8531c.m17800a(getRequest(activity), "complete");
    }

    public static void release(Request request) {
        C8531c.m17800a(request, "complete");
    }

    public static Request getPrimaryRequest(Result result) {
        return result.f21059a.f21081k;
    }
}
