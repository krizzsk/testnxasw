package com.didi.globalsafetoolkit.net;

public class SfUrls {
    public static final String EMERGENCY_ASSIST = "/other/pEmergencyAssist";
    public static final String EMERGENCY_STATUS = "/other/pGetReportingPolice";
    public static final String SAFETY_CENTER = "/other/pSafetyCenterPage";
    public static final String SHARE_SMS = "/other/pShareTripBySMS";
    public static final String START_EMERGENCY_CALL = "/other/pReportPolice";
    public static final String STOP_EMERGENCY_CALL = "/other/pStopReportPolice";
    public static final String SYNC_CONTACT = "/other/pSyncContact";

    /* renamed from: a */
    private static final boolean f25181a = true;

    /* renamed from: b */
    private static final String f25182b = "https://api.didiglobal.com/gulfstream/passenger/v2";

    /* renamed from: c */
    private static final String f25183c = "http://sim02-gsapi.didiglobal.com/gulfstream/passenger/v2";

    public interface BffAbilityId {
        public static final String ABILITY_SAFETOOLKIT_DRIVER_START_SHARE = "heimdallr/oasisDriverStartShare";
        public static final String ABILITY_SAFETOOLKIT_GET_EMERGENCY_INFO = "heimdallr/dGetEmergencyInfo";
        public static final String ABILITY_SAFETOOLKIT_REPORT_EMERGENCY_INFO = "heimdallr/dReportEmergencyInfo";
        public static final String AUTO_RECORD_REPORT = "heimdallr/pSetAutoVoiceConfig";
        public static final String NEW_SYNC_CONTACT = "ibt-sec-heimdallr/passengerContact";
    }

    public static String getBaseUrl() {
        return f25182b;
    }
}
