package com.didichuxing.diface.biz.bioassay.alpha.p181M.compare;

import com.didichuxing.diface.data.BaseResult;
import java.io.Serializable;

/* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.compare.CompareResult */
public class CompareResult extends BaseResult {
    public static final int CODE_BI_FAILED = 100005;
    public static final int CODE_FAILED = 100001;
    public static final int CODE_OVER_TIMES = 100002;
    public static final int CODE_SYSTEM_BUSY = 100004;
    public Data data;

    /* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.compare.CompareResult$Data */
    public static class Data implements Serializable {
        public int code;
        public String message;
        public Result result;

        public String toString() {
            return "Data{code=" + this.code + ", message='" + this.message + '\'' + ", result=" + this.result + '}';
        }
    }

    /* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.compare.CompareResult$Result */
    public static class Result implements Serializable {
        public AppealInfo appealInfo;
        public String session_id;
        public boolean show_appeal_entry;

        /* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.compare.CompareResult$Result$AppealInfo */
        public static class AppealInfo implements Serializable {
            public String faceSessionId;
            public String idCard;
            public String name;
        }

        public String toString() {
            return "Result{session_id='" + this.session_id + '\'' + '}';
        }
    }

    public String toString() {
        return "CompareResult{data=" + this.data + '}';
    }
}
