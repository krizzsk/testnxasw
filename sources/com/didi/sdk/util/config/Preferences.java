package com.didi.sdk.util.config;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.bizconfig.store.BizConfigModel;
import com.didi.sdk.util.SingletonHolder;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.taxis99.R;
import org.json.JSONArray;
import org.json.JSONException;
import rui.config.RConfigConstants;

@Deprecated
public class Preferences {

    /* renamed from: a */
    private static Preferences f40443a = null;
    public static boolean mLogout = false;

    /* renamed from: b */
    private PreferenceProxy f40444b;

    /* renamed from: c */
    private PreferenceEditorProxy f40445c;

    /* renamed from: d */
    private Context f40446d;

    private Preferences() {
    }

    public static Preferences getInstance() {
        return (Preferences) SingletonHolder.getInstance(Preferences.class);
    }

    public void init(Context context) {
        this.f40444b = new PreferenceProxy(context);
        this.f40446d = context.getApplicationContext();
        this.f40445c = this.f40444b.getEditor();
    }

    public String getUrl() {
        return this.f40444b.getString("service_url", (String) null);
    }

    public void setUrl(String str) {
        this.f40445c.putString("service_url", str);
        this.f40445c.commit();
    }

    public String getPhone() {
        return this.f40444b.getString("phone", "");
    }

    public void setPhone(String str) {
        this.f40445c.putString("phone", str);
        this.f40445c.commit();
    }

    public String getToken() {
        return this.f40444b.getString("token", "");
    }

    public void setToken(String str) {
        this.f40445c.putString("token", str);
        this.f40445c.commit();
    }

    public String getTToken() {
        return this.f40444b.getString("ttoken", "");
    }

    public void setTToken(String str) {
        this.f40445c.putString("ttoken", str);
        this.f40445c.commit();
    }

    public long getTTokenLastTime() {
        return this.f40444b.getLong("ttoken_last_time", 0);
    }

    public void setTTokenLastTime(long j) {
        this.f40445c.putLong("ttoken_last_time", j);
        this.f40445c.commit();
    }

    public int getProtectShow() {
        return this.f40444b.getInt("protect", 0);
    }

    public void setProtectShow(int i) {
        this.f40445c.putInt("protect", i);
        this.f40445c.commit();
    }

    public String getServicePhone() {
        return this.f40444b.getString(BizConfigModel.KEY_SERVICE_PHONE, "");
    }

    public void setServicePhone(String str) {
        this.f40445c.putString(BizConfigModel.KEY_SERVICE_PHONE, str);
        this.f40445c.commit();
    }

    public String getPsngrId() {
        return this.f40444b.getString("psngr_id", "");
    }

    public void setPsngrId(String str) {
        this.f40445c.putString("psngr_id", str);
        this.f40445c.commit();
    }

    public int getHomeNotice() {
        return this.f40444b.getInt("homenotice", 0);
    }

    public void setHomeNotice() {
        this.f40445c.putInt("homenotice", getHomeNotice() + 1);
    }

    public boolean isEmptyToken() {
        return TextUtils.isEmpty(getToken());
    }

    public String getCode() {
        return this.f40444b.getString("code", (String) null);
    }

    public void setCode(String str) {
        this.f40445c.putString("code", str);
        this.f40445c.commit();
    }

    public void setHomeCityId(int i) {
        this.f40445c.putInt("home_1_id", i);
        this.f40445c.commit();
    }

    public String getHomeLongitude() {
        return this.f40444b.getString("home_1_lon", "-1");
    }

    public void setHomeLongitude(String str) {
        this.f40445c.putString("home_1_lon", str);
        this.f40445c.commit();
    }

    public String getHomeLatitude() {
        return this.f40444b.getString("home_1_lat", "-1");
    }

    public void setHomeLatitude(String str) {
        this.f40445c.putString("home_1_lat", str);
        this.f40445c.commit();
    }

    public String getHomeAddr() {
        return this.f40444b.getString("home_1_addr", (String) null);
    }

    public void setHomeAddr(String str) {
        this.f40445c.putString("home_1_addr", str);
        this.f40445c.commit();
    }

    public String getHomeName() {
        return this.f40444b.getString("home_1", "");
    }

    public void setHomeName(String str) {
        this.f40445c.putString("home_1", str);
        this.f40445c.commit();
    }

    public String getCompanyName() {
        return this.f40444b.getString("company_1", "");
    }

    public void setCompanyName(String str) {
        this.f40445c.putString("company_1", str);
        this.f40445c.commit();
    }

    public void setCompanyCityId(int i) {
        this.f40445c.putInt("company_1_id", i);
        this.f40445c.commit();
    }

    public String getCompanyLongitude() {
        return this.f40444b.getString("company_1_lon", "-1");
    }

    public void setCompanyLongitude(String str) {
        this.f40445c.putString("company_1_lon", str);
        this.f40445c.commit();
    }

    public String getCompanyLatitude() {
        return this.f40444b.getString("company_1_lat", "-1");
    }

    public void setCompanyLatitude(String str) {
        this.f40445c.putString("company_1_lat", str);
        this.f40445c.commit();
    }

    public String getCompanyAddr() {
        return this.f40444b.getString("company_1_addr", (String) null);
    }

    public void setCompanyAddr(String str) {
        this.f40445c.putString("company_1_addr", str);
        this.f40445c.commit();
    }

    public boolean isFirstBoot() {
        return this.f40444b.getBoolean("isFirstBoot", true);
    }

    public void setFirstBoot(boolean z) {
        this.f40445c.putBoolean("isFirstBoot", z);
        this.f40445c.commit();
    }

    public int getVoucherPointFlag() {
        return this.f40444b.getInt("vocher_point", 2);
    }

    public void setVoucherPointFlag(int i) {
        this.f40445c.putInt("vocher_point", i);
        this.f40445c.commit();
    }

    public int getGuide() {
        return this.f40444b.getInt("show_guide", 0);
    }

    public void setGuide(int i) {
        this.f40445c.putInt("show_guide", i);
        this.f40445c.commit();
    }

    public int getOrderCount() {
        return this.f40444b.getInt("order_count", 0);
    }

    public void setOrderCount(int i) {
        this.f40445c.putInt("order_count", i);
        this.f40445c.commit();
    }

    public void setBadOrderCount(int i) {
        this.f40445c.putInt("bad_order_count", i);
        this.f40445c.commit();
    }

    public long getTimeOffset() {
        return this.f40444b.getLong("time_offset", 0);
    }

    public void setUnFinishSign(int i) {
        this.f40445c.putInt("unfinish", i);
        this.f40445c.commit();
    }

    public void setCreateOrderTimes(long j) {
        this.f40445c.putLong("create_order_time", j);
        this.f40445c.commit();
    }

    public void setSoundsSwitch(boolean z) {
        this.f40445c.putBoolean("switch_state", z);
        this.f40445c.commit();
    }

    public boolean getSoundsSwtich() {
        return this.f40444b.getBoolean("switch_state", true);
    }

    public long getWaitingTipsUpdateTime() {
        return this.f40444b.getLong("waiting_tips_update_time", -1);
    }

    public int getCreateOrderStyle() {
        return this.f40444b.getInt("create_order_style", 0);
    }

    public void setCreateOrderStyle(int i) {
        this.f40445c.putInt("create_order_style", i);
        this.f40445c.commit();
    }

    public String getCurrentCity() {
        return this.f40444b.getString("current_city", "");
    }

    public void setCurrentCity(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f40444b.getString("current_city", ""))) {
            this.f40445c.putString("current_city", str);
            this.f40445c.commit();
        }
    }

    public String getCurrentCityId() {
        String string = this.f40444b.getString("city_id", "");
        TextUtils.isEmpty(string);
        return string;
    }

    public void setCurrentCityId(String str) {
        this.f40445c.putString("city_id", str);
        this.f40445c.commit();
    }

    public String getMyLng() {
        return this.f40444b.getString("my_lng", (String) null);
    }

    public void setMyLng(String str) {
        this.f40445c.putString("my_lng", str);
        this.f40445c.commit();
    }

    public String getMyLat() {
        return this.f40444b.getString("my_lat", (String) null);
    }

    public void setMyLat(String str) {
        this.f40445c.putString("my_lat", str);
        this.f40445c.commit();
    }

    public void setIsShowShare(boolean z) {
        this.f40445c.putBoolean("show_share", z);
        this.f40445c.commit();
    }

    public boolean isShowShare() {
        return this.f40444b.getBoolean("show_share", true);
    }

    public void saveAdvertisementVersion(String str) {
        this.f40445c.putString("coverinfo_version", str);
        this.f40445c.commit();
    }

    public String getAdvertisementVersion() {
        return this.f40444b.getString("coverinfo_version", (String) null);
    }

    public void saveTaxiAnnouncementWebUrl(String str) {
        this.f40445c.putString("taxi_announcement_web_url", str);
        this.f40445c.commit();
    }

    public String getTaxiAnnouncementWebUrl() {
        return this.f40444b.getString("taxi_announcement_web_url", "");
    }

    public void saveFlierAnnouncementWebUrl(String str) {
        this.f40445c.putString("flier_announcement_web_url", str);
        this.f40445c.commit();
    }

    public String getFlierAnnouncementWebUrl() {
        return this.f40444b.getString("flier_announcement_web_url", "");
    }

    public void saveCarAnnouncementWebUrl(String str) {
        this.f40445c.putString("car_announcement_web_url", str);
        this.f40445c.commit();
    }

    public String getCarAnnouncementWebUrl() {
        return this.f40444b.getString("car_announcement_web_url", "");
    }

    public void saveDDriveAnnouncementWebUrl(String str) {
        this.f40445c.putString("ddrive_announcement_web_url", str);
        this.f40445c.commit();
    }

    public String getDDriveAnnouncementWebUrl() {
        return this.f40444b.getString("ddrive_announcement_web_url", "");
    }

    public void saveTaxiAnnouncementCount(int i) {
        this.f40445c.putInt("taxi_announcement_count", i);
        this.f40445c.commit();
    }

    public int getTaxiAnnouncementCount() {
        return this.f40444b.getInt("taxi_announcement_count", 0);
    }

    public void saveCarAnnouncementCount(int i) {
        this.f40445c.putInt("car_announcement_count", i);
        this.f40445c.commit();
    }

    public void saveDDriveAnnouncementCount(int i) {
        this.f40445c.putInt("ddrive_announcement_count", i);
        this.f40445c.commit();
    }

    public int getDDriveAnnouncementCount() {
        return this.f40444b.getInt("ddrive_announcement_count", 0);
    }

    public int getFlierAnnouncementCount() {
        return this.f40444b.getInt("flier_announcement_count", 0);
    }

    public void saveFlierAnnouncementCount(int i) {
        this.f40445c.putInt("flier_announcement_count", i);
        this.f40445c.commit();
    }

    public int getCarAnnouncementCount() {
        return this.f40444b.getInt("car_announcement_count", 0);
    }

    public String getTaxiAnnouncementVersion() {
        return this.f40444b.getString("taxi_announcement_version", "2353299186");
    }

    public void saveFlierAnnouncementVersion(String str) {
        this.f40445c.putString("flier_announcement_version", str);
        this.f40445c.commit();
    }

    public String getFlierAnnouncementVersion() {
        return this.f40444b.getString("flier_announcement_version", "2353299186");
    }

    public void saveTaxiAnnouncementVersion(String str) {
        this.f40445c.putString("taxi_announcement_version", str);
        this.f40445c.commit();
    }

    public void saveCarAnnouncementVersion(String str) {
        this.f40445c.putString("car_announcement_version", str);
        this.f40445c.commit();
    }

    public String getCarAnnouncementVersion() {
        return this.f40444b.getString("car_announcement_version", "2353299186");
    }

    public void saveDDriveAnnouncementVersion(String str) {
        this.f40445c.putString("ddrive_announcement_version", str);
        this.f40445c.commit();
    }

    public String getDDriveAnnouncementVersion() {
        return this.f40444b.getString("ddrive_announcement_version", "2353299186");
    }

    public void saveCityListVersion(int i) {
        this.f40445c.putInt("city_list_version", i);
        this.f40445c.commit();
    }

    public int getCityListVersion() {
        return this.f40444b.getInt("city_list_version", 0);
    }

    public boolean hasWaitIntroShown() {
        return this.f40444b.getBoolean("has_wait_intro_shown", false);
    }

    public void setWaitIntroShown() {
        this.f40445c.putBoolean("has_wait_intro_shown", true);
        this.f40445c.commit();
    }

    public String getLatitudeString() {
        return this.f40444b.getString("lat", (String) null);
    }

    public void setLatitudeString(String str) {
        this.f40445c.putString("lat", str);
        this.f40445c.commit();
    }

    public String getLongitudeString() {
        return this.f40444b.getString("lng", (String) null);
    }

    public void setLongitudeString(String str) {
        this.f40445c.putString("lng", str);
        this.f40445c.commit();
    }

    public boolean getOrderDelConfirm() {
        return this.f40444b.getBoolean("order_del_confirm", false);
    }

    public void setOrderDelConfirm(boolean z) {
        this.f40445c.putBoolean("order_del_confirm", z);
        this.f40445c.commit();
    }

    public String[] getTaxiLabels() {
        String string = this.f40444b.getString("str_taxi_labels", (String) null);
        if (TextUtil.isEmpty(string)) {
            return new String[0];
        }
        return string.split(",");
    }

    public void setTaxiLabels(String str) {
        this.f40445c.putString("str_taxi_labels", str);
        this.f40445c.commit();
    }

    public String[] getTaxiPreLabels() {
        String string = this.f40444b.getString("str_taxi_pre_labels", (String) null);
        if (TextUtil.isEmpty(string)) {
            return new String[0];
        }
        return string.split(",");
    }

    public void setTaxiPreLabels(String str) {
        this.f40445c.putString("str_taxi_pre_labels", str);
        this.f40445c.commit();
    }

    public String[] getCarLabels() {
        String string = this.f40444b.getString("str_car_labels", (String) null);
        if (TextUtil.isEmpty(string)) {
            return new String[0];
        }
        return string.split(",");
    }

    public void setCarLabels(String str) {
        this.f40445c.putString("str_car_labels", str);
        this.f40445c.commit();
    }

    public boolean getTaxiHasAutoPopAnnouncement() {
        return this.f40444b.getBoolean("taxi_has_auto_pop_announcement", false);
    }

    public void setTaxiHasAutoPopAnnouncement(boolean z) {
        this.f40445c.putBoolean("taxi_has_auto_pop_announcement", z);
        this.f40445c.commit();
    }

    public boolean getCarHasAutoPopAnnouncement() {
        return this.f40444b.getBoolean("car_has_auto_pop_announcement", false);
    }

    public void setCarHasAutoPopAnnouncement(boolean z) {
        this.f40445c.putBoolean("car_has_auto_pop_announcement", z);
        this.f40445c.commit();
    }

    public boolean getDDriveHasAutoPopAnnouncement() {
        return this.f40444b.getBoolean("ddrive_has_auto_pop_announcement", false);
    }

    public void setDDriveHasAutoPopAnnouncement(boolean z) {
        this.f40445c.putBoolean("ddrive_has_auto_pop_announcement", z);
        this.f40445c.commit();
    }

    public boolean getFlierHasAutoPopAnnouncement() {
        return this.f40444b.getBoolean("flier_has_auto_pop_announcement", false);
    }

    public void setFlierHasAutoPopAnnouncement(boolean z) {
        this.f40445c.putBoolean("flier_has_auto_pop_announcement", z);
        this.f40445c.commit();
    }

    public boolean getTaxiAutoPop() {
        return this.f40444b.getBoolean("taxi_auto_pop", false);
    }

    public void setTaxiAutoPop(int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.f40445c.putBoolean("taxi_auto_pop", z);
        this.f40445c.commit();
    }

    public boolean getCarAutoPop() {
        return this.f40444b.getBoolean("car_auto_pop", false);
    }

    public void setCarAutoPop(int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.f40445c.putBoolean("car_auto_pop", z);
        this.f40445c.commit();
    }

    public boolean getDDriveAutoPop() {
        return this.f40444b.getBoolean("ddrive_auto_pop", false);
    }

    public void setDDriveAutoPop(int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.f40445c.putBoolean("ddrive_auto_pop", z);
        this.f40445c.commit();
    }

    public boolean getFlierAutoPop() {
        return this.f40444b.getBoolean("flier_auto_pop", false);
    }

    public void setFlierAutoPop(int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.f40445c.putBoolean("flier_auto_pop", z);
        this.f40445c.commit();
    }

    public int getSwitcherPannel() {
        return this.f40444b.getInt("channel_index", -1);
    }

    public void setSwitcherPannel(int i) {
        this.f40445c.putInt("channel_index", i);
        this.f40445c.commit();
    }

    public void setCarInvoiceType(String str) {
        this.f40445c.putString("car_invoice", str);
        this.f40445c.commit();
    }

    public String getDynamicPriceTips() {
        return this.f40444b.getString("dynamic_price_tips", "");
    }

    public void setDynamicPriceTips(String str) {
        this.f40445c.putString("dynamic_price_tips", str);
        this.f40445c.commit();
    }

    public boolean getDynamicPriceFirst() {
        return this.f40444b.getBoolean("dynamic_price_flag", false);
    }

    public void setDynamicPriceFirst(boolean z) {
        this.f40445c.putBoolean("dynamic_price_flag", z);
        this.f40445c.commit();
    }

    public String getDriverInfoh5url() {
        return this.f40444b.getString("comment_h5_url", (String) null);
    }

    public void saveDriverInfoh5url(String str) {
        this.f40445c.putString("comment_h5_url", str);
        this.f40445c.commit();
    }

    public void setCarComplaintType(String str) {
        if (str != null && str.length() != 0) {
            this.f40445c.putString("car_complaint", str.replaceAll(Const.jsQuote, ""));
            this.f40445c.commit();
        }
    }

    public String[] getArrayCarComplaintType() {
        String string = this.f40444b.getString("car_complaint", (String) null);
        if (TextUtil.isEmpty(string)) {
            return null;
        }
        return string.replaceAll(Const.jsQuote, "").split(",");
    }

    public String getCarBadCmtMarks() {
        return this.f40444b.getString("bad_cmt_marks", "");
    }

    public void setCarBadCmtMarks(String str) {
        this.f40445c.putString("bad_cmt_marks", str);
        this.f40445c.commit();
    }

    public void setCarGoodComment(String str) {
        this.f40445c.putString("car_good_complaint", str);
        this.f40445c.commit();
    }

    public String[] getArrayCarGoodComment() {
        String string = this.f40444b.getString("car_good_complaint", (String) null);
        if (TextUtil.isEmpty(string)) {
            return new String[0];
        }
        return string.split(",");
    }

    public void setCarBadComment(String str) {
        this.f40445c.putString("car_bad_complaint", str);
        this.f40445c.commit();
    }

    public String[] getArrayCarBadComment() {
        String string = this.f40444b.getString("car_bad_complaint", (String) null);
        if (TextUtil.isEmpty(string)) {
            return new String[0];
        }
        return string.split(",");
    }

    public String getCarCommentFinishTips() {
        return this.f40444b.getString("car_comment_finish_tips", "");
    }

    public void setCarCommentFinishTips(String str) {
        this.f40445c.putString("car_comment_finish_tips", str);
        this.f40445c.commit();
    }

    public String getCarCommentTips() {
        return this.f40444b.getString("car_comment_tips", "");
    }

    public void setCarCommentTips(String str) {
        this.f40445c.putString("car_comment_tips", str);
        this.f40445c.commit();
    }

    public String getCarGoodCmtTips() {
        return this.f40444b.getString("car_good_comment_tips", "");
    }

    public void setCarGoodCmtTips(String str) {
        this.f40445c.putString("car_good_comment_tips", str);
        this.f40445c.commit();
    }

    public String getCarBadCmtTips() {
        return this.f40444b.getString("car_bad_comment_tips", "");
    }

    public void setCarBadCmtTips(String str) {
        this.f40445c.putString("car_bad_comment_tips", str);
        this.f40445c.commit();
    }

    public String getCarCancelTripRealtimeTip() {
        return this.f40444b.getString("car_cancel_trip_realtime_tip", "");
    }

    public void setCarCancelTripRealtimeTip(String str) {
        this.f40445c.putString("car_cancel_trip_realtime_tip", str);
        this.f40445c.commit();
    }

    public String getCarCancelTripBookingTip() {
        return this.f40444b.getString("car_cancel_trip_booking_tip", "");
    }

    public void setCarCancelTripBookingTip(String str) {
        this.f40445c.putString("car_cancel_trip_booking_tip", str);
        this.f40445c.commit();
    }

    public void setCarCancelTripTextOption(String str) {
        this.f40445c.putString("car_cancel_trip_text_options", str);
        this.f40445c.commit();
    }

    public String[] getArrayCarCancelTripTextOption() {
        String string = this.f40444b.getString("car_cancel_trip_text_options", (String) null);
        if (TextUtil.isEmpty(string)) {
            return null;
        }
        return string.split(RConfigConstants.KEYWORD_COLOR_SIGN);
    }

    public void setCarCancelTripIconOption(String str) {
        this.f40445c.putString("car_cancel_trip_icon_options", str);
        this.f40445c.commit();
    }

    public String[] getArrayCarCancelTripIconOption() {
        String string = this.f40444b.getString("car_cancel_trip_icon_options", (String) null);
        if (TextUtil.isEmpty(string)) {
            return null;
        }
        return string.split(RConfigConstants.KEYWORD_COLOR_SIGN);
    }

    public boolean getCarFirstGrabbedShowTip() {
        return this.f40444b.getBoolean("car_first_grab_show_tip", false);
    }

    public void setCarFirstGrabbedShowTip(boolean z) {
        this.f40445c.putBoolean("car_first_grab_show_tip", z);
        this.f40445c.commit();
    }

    public void saveAnnouncementVersion(String str) {
        this.f40445c.putString("announcement_version", str);
        this.f40445c.commit();
    }

    public String getAnnouncementVersion() {
        return this.f40444b.getString("announcement_version", "3999944283");
    }

    public void saveTaxiAnnouncementStartTime(long j) {
        this.f40445c.putLong("taxi_announcement_start_time", j);
        this.f40445c.commit();
    }

    public long getTaxiAnnouncementStartTime() {
        return this.f40444b.getLong("taxi_announcement_start_time", 0);
    }

    public void saveTaxiAnnouncementEndTime(long j) {
        this.f40445c.putLong("taxi_announcement_end_time", j);
        this.f40445c.commit();
    }

    public long getTaxiAnnouncementEndTime() {
        return this.f40444b.getLong("taxi_announcement_end_time", 0);
    }

    public void saveCarAnnouncementStartTime(long j) {
        this.f40445c.putLong("car_announcement_start_time", j);
        this.f40445c.commit();
    }

    public long getCarAnnouncementStartTime() {
        return this.f40444b.getLong("car_announcement_start_time", 0);
    }

    public void saveCarAnnouncementEndTime(long j) {
        this.f40445c.putLong("car_announcement_end_time", j);
        this.f40445c.commit();
    }

    public long getCarAnnouncementEndTime() {
        return this.f40444b.getLong("car_announcement_end_time", 0);
    }

    public void saveDDriveAnnouncementStartTime(long j) {
        this.f40445c.putLong("ddrive_announcement_start_time", j);
        this.f40445c.commit();
    }

    public long getDDriveAnnouncementStartTime() {
        return this.f40444b.getLong("ddrive_announcement_start_time", 0);
    }

    public void saveDDriveAnnouncementEndTime(long j) {
        this.f40445c.putLong("ddrive_announcement_end_time", j);
        this.f40445c.commit();
    }

    public long getDDriveAnnouncementEndTime() {
        return this.f40444b.getLong("ddrive_announcement_end_time", 0);
    }

    public void saveFlierAnnouncementStartTime(long j) {
        this.f40445c.putLong("flier_announcement_start_time", j);
        this.f40445c.commit();
    }

    public long getFlierAnnouncementStartTime() {
        return this.f40444b.getLong("flier_announcement_start_time", 0);
    }

    public void saveFlierAnnouncementEndTime(long j) {
        this.f40445c.putLong("flier_announcement_end_time", j);
        this.f40445c.commit();
    }

    public long getFlierAnnouncementEndTime() {
        return this.f40444b.getLong("flier_announcement_end_time", 0);
    }

    public long getCommonConfigVersion1() {
        return this.f40444b.getLong("common_config_ver_1", 0);
    }

    public void setCommonConfigVersion1(long j) {
        this.f40445c.putLong("common_config_ver_1", j);
        this.f40445c.commit();
    }

    public void setAppVesion(String str) {
        this.f40445c.putString("app_version", str);
        this.f40445c.commit();
    }

    public String getAppVersion() {
        return this.f40444b.getString("app_version", "");
    }

    public int getCarConfigVersion() {
        return this.f40444b.getInt("car_config_version_int", 0);
    }

    public void setCarConfigVersion(int i) {
        this.f40445c.putInt("car_config_version_int", i);
        this.f40445c.commit();
    }

    public int getCarConfigOrderStatus() {
        return this.f40444b.getInt("p_order_get_req", 3);
    }

    public void setCarConfigOrderStatus(int i) {
        this.f40445c.putInt("p_order_get_req", i);
        this.f40445c.commit();
    }

    public int getCarConfigPayResult() {
        return this.f40444b.getInt("p_pay_status_req", 3);
    }

    public void setCarConfigPayResult(int i) {
        this.f40445c.putInt("p_pay_status_req", i);
        this.f40445c.commit();
    }

    public int getQueryCarOrderStatus() {
        return this.f40444b.getInt("p_get_order_status_spare", 15);
    }

    public void setQueryCarOrderStatus(int i) {
        this.f40445c.putInt("'p_get_order_status_spare", i);
        this.f40445c.commit();
    }

    public int getCarOrderStatusSwitch() {
        return this.f40444b.getInt("p_get_order_status_spare_open", 1);
    }

    public void setCarOrderStatusSwitch(int i) {
        this.f40445c.putInt("'p_get_order_status_spare_open", i);
        this.f40445c.commit();
    }

    public boolean getPushReConnConfigResult() {
        return this.f40444b.getBoolean("p_push_reconnect", false);
    }

    public void setPushReConnConfigResult(boolean z) {
        this.f40445c.putBoolean("p_push_reconnect", z);
        this.f40445c.commit();
    }

    public void setTraceLogSeqid(long j) {
        this.f40445c.putLong("tracelog_seqid", j);
        this.f40445c.commit();
    }

    public long getTraceLogSegid() {
        return this.f40444b.getLong("tracelog_seqid", 0);
    }

    public long getUpdateLogTime() {
        return this.f40444b.getLong("update_log_time", 0);
    }

    public long getShowWxAgentFlag() {
        return (long) this.f40444b.getInt("car_wxagent_flag", 0);
    }

    public void setWxAgentFlag(int i) {
        this.f40445c.putInt("car_wxagent_flag", i);
        this.f40445c.commit();
    }

    public String getClientIdString() {
        return this.f40444b.getString("cid", (String) null);
    }

    public void setClientIdString(String str) {
        this.f40445c.putString("cid", str);
        this.f40445c.commit();
    }

    public String getMiPushRegId() {
        return this.f40444b.getString("regid", (String) null);
    }

    public void setMiPushRegId(String str) {
        this.f40445c.putString("regid", str);
        this.f40445c.commit();
    }

    public int getVirtualStatus() {
        return this.f40444b.getInt("virtual_status", 2);
    }

    public void setVirtualStatus(int i) {
        this.f40445c.putInt("virtual_status", i);
        this.f40445c.commit();
    }

    public int getFoundVersion() {
        return this.f40444b.getInt("found_version", 0);
    }

    public void setFoundVersion(int i) {
        this.f40445c.putInt("found_version", i);
        this.f40445c.commit();
    }

    public void setCommonVresion(String str) {
        this.f40445c.putString("common_version", str);
        this.f40445c.commit();
    }

    public String getCommonVersion() {
        return this.f40444b.getString("common_version", "");
    }

    public String getSid() {
        return this.f40444b.getString("session_id", (String) null);
    }

    public void setSid(String str) {
        this.f40445c.putString("session_id", str);
        this.f40445c.commit();
    }

    public boolean getIMUnreadFlag() {
        return this.f40444b.getBoolean("im_unread_flag", false);
    }

    public void setIMUnreadFlag(boolean z) {
        this.f40445c.putBoolean("im_unread_flag", z);
        this.f40445c.commit();
    }

    public long getWanLiuStarttime() {
        return this.f40444b.getLong("wanliu_chris_start_time", 0);
    }

    public void setWanLiuStarttime(long j) {
        this.f40445c.putLong("wanliu_chris_start_time", j);
        this.f40445c.commit();
    }

    public long getWanLiuEndtime() {
        return this.f40444b.getLong("wanliu_chris_end_time", 0);
    }

    public void setWanLiuEndtime(long j) {
        this.f40445c.putLong("wanliu_chris_end_time", j);
        this.f40445c.commit();
    }

    public int getIMInputState() {
        return this.f40444b.getInt("im_input_state", 0);
    }

    public void setIMInputState(int i) {
        this.f40445c.putInt("im_input_state", i);
        this.f40445c.commit();
    }

    public boolean getMessageHasNew() {
        return this.f40444b.getBoolean("message_has_new", false);
    }

    public void setMessageHasNew(boolean z) {
        this.f40445c.putBoolean("message_has_new", z);
        this.f40445c.commit();
    }

    public boolean isInviteSwitch() {
        return this.f40444b.getBoolean("invite_switch", false);
    }

    public void setInviteSwitch(boolean z) {
        this.f40445c.putBoolean("invite_switch", z);
        this.f40445c.commit();
    }

    public String getInviteSwitchTitle() {
        return this.f40444b.getString("invite_switch_title", (String) null);
    }

    public void setInviteSwitchTitle(String str) {
        this.f40445c.putString("invite_switch_title", str);
        this.f40445c.commit();
    }

    public String getInviteSwitchUrl() {
        return this.f40444b.getString("invite_switch_url", "");
    }

    public void setInviteSwitchUrl(String str) {
        this.f40445c.putString("invite_switch_url", str);
        this.f40445c.commit();
    }

    public String getInviteItemVersion() {
        return this.f40444b.getString("invite_item_version", "");
    }

    public void setInviteItemVersion(String str) {
        this.f40445c.putString("invite_item_version", str);
        this.f40445c.commit();
    }

    public boolean isInviteRedPoint() {
        return this.f40444b.getBoolean("invite_red_point", false);
    }

    public void setInviteRedPoint(boolean z) {
        this.f40445c.putBoolean("invite_red_point", z);
        this.f40445c.commit();
    }

    public boolean isNoticationMessage() {
        return this.f40444b.getBoolean("notify_center_is_open", false);
    }

    public void setNoticationMessage(boolean z) {
        this.f40445c.putBoolean("notify_center_is_open", z);
        this.f40445c.commit();
    }

    public void setShowPreassign(boolean z) {
        this.f40445c.putBoolean("show_preassign", z);
        this.f40445c.commit();
    }

    public boolean isShowedPreassign() {
        return this.f40444b.getBoolean("show_preassign", false);
    }

    public String[] getRootDomain() {
        String string = this.f40444b.getString("root_domain", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
            return strArr;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setRootDomain(String str) {
        this.f40445c.putString("root_domain", str);
        this.f40445c.commit();
    }

    public String[] getThirdDomain() {
        String string = this.f40444b.getString("third_domain", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
            return strArr;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setThirdDomain(String str) {
        this.f40445c.putString("third_domain", str);
        this.f40445c.commit();
    }

    public boolean getOpenActivity() {
        return this.f40444b.getBoolean("open_activity_flag", false);
    }

    public void setOpenActivity(boolean z) {
        this.f40445c.putBoolean("open_activity_flag", z);
        this.f40445c.commit();
    }

    public int getActivityId() {
        return this.f40444b.getInt("activity_id", 0);
    }

    public void setActivityId(int i) {
        this.f40445c.putInt("activity_id", i);
        this.f40445c.commit();
    }

    public void setActivityName(String str) {
        this.f40445c.putString("activity_name", str);
        this.f40445c.commit();
    }

    public String getActivityString() {
        PreferenceProxy preferenceProxy = this.f40444b;
        Context context = this.f40446d;
        return preferenceProxy.getString("activity_name", context != null ? context.getResources().getString(R.string.airport) : "");
    }

    public String getActivityIcon() {
        return this.f40444b.getString("activity_icon", "");
    }

    public void setActivityIcon(String str) {
        this.f40445c.putString("activity_icon", str);
        this.f40445c.commit();
    }

    public void setActivityIconCar(String str) {
        this.f40445c.putString("activity_icon_car", str);
        this.f40445c.commit();
    }

    public void setNotUseLocalCache(boolean z) {
        this.f40445c.putBoolean("not_use_local_cache", z);
        this.f40445c.commit();
    }

    public boolean isAction() {
        return this.f40444b.getBoolean("user_action", false);
    }

    public void setAction(boolean z) {
        this.f40445c.putBoolean("user_action", z);
        this.f40445c.commit();
    }

    public int getAppWatcherDelayTime() {
        return this.f40444b.getInt("appwatcher_delaytime", 5);
    }

    public void setAppWatcherDelayTime(int i) {
        this.f40445c.putInt("appwatcher_delaytime", i);
        this.f40445c.commit();
    }

    public int getAppWatcherMaxRunTimesInDay() {
        return this.f40444b.getInt("appwatcher_maxruntimes_inday", 1);
    }

    public void setAppWatcherMaxRunTimesInDay(int i) {
        this.f40445c.putInt("appwatcher_maxruntimes_inday", i);
        this.f40445c.commit();
    }

    public int getAppWatcherMaxRunTimesInWeek() {
        return this.f40444b.getInt("appwatcher_maxruntimes_inweek", 2);
    }

    public void setAppWatcherMaxRunTimesInWeek(int i) {
        this.f40445c.putInt("appwatcher_maxruntimes_inweek", i);
        this.f40445c.commit();
    }

    public boolean getAppWatcherListenFlag() {
        return this.f40444b.getBoolean("appwatcher_listenflag", false);
    }

    public void setAppWatcherListenFlag(boolean z) {
        this.f40445c.putBoolean("appwatcher_listenflag", z);
        this.f40445c.commit();
    }

    public int getRecentAppStartDay() {
        return this.f40444b.getInt("appwatcher_start_day", 0);
    }

    public void setRecentAppStartDay(int i) {
        this.f40445c.putInt("appwatcher_start_day", i);
        this.f40445c.commit();
    }

    public int getRecentAppStartWeek() {
        return this.f40444b.getInt("appwatcher_start_week", 0);
    }

    public void setRecentAppStartWeek(int i) {
        this.f40445c.putInt("appwatcher_start_week", i);
        this.f40445c.commit();
    }

    public boolean isNewServerManageMent() {
        return this.f40444b.getBoolean("server_management", false);
    }

    public void setNewServerManageMent(boolean z) {
        this.f40445c.putBoolean("server_management", z);
        this.f40445c.commit();
    }

    public boolean getQqShareOpen() {
        return this.f40444b.getBoolean("qq_share_open", false);
    }

    public void setQqShareOpen(boolean z) {
        this.f40445c.putBoolean("qq_share_open", z);
        this.f40445c.commit();
    }

    public String getEstimatePriceUrl() {
        return this.f40444b.getString("estimate_price_url", "");
    }

    public void setEstimatePriceUrl(String str) {
        this.f40445c.putString("estimate_price_url", str);
        this.f40445c.commit();
    }

    public boolean getQzoneShareOpen() {
        return this.f40444b.getBoolean("qzone_share_open", false);
    }

    public void setQzoneShareOpen(boolean z) {
        this.f40445c.putBoolean("qzone_share_open", z);
        this.f40445c.commit();
    }

    public boolean getWeiboShareOpen() {
        return this.f40444b.getBoolean("weibo_share_open", false);
    }

    public void setWeiboShareOpen(boolean z) {
        this.f40445c.putBoolean("weibo_share_open", z);
        this.f40445c.commit();
    }

    public int getAppWatchStartTimesInWeek() {
        return this.f40444b.getInt("appwatcher_start_times_in_week", 0);
    }

    public void setAppWatchStartTimesInWeek(int i) {
        this.f40445c.putInt("appwatcher_start_times_in_week", i);
        this.f40445c.commit();
    }

    public int getAppWatchStartTimesInDay() {
        return this.f40444b.getInt("appwatcher_start_times_in_day", 0);
    }

    public void setAppWatchStartTimesInDay(int i) {
        this.f40445c.putInt("appwatcher_start_times_in_day", i);
        this.f40445c.commit();
    }

    public int getTabMemory() {
        return this.f40444b.getInt("default_tab_memory", 1);
    }

    public void setTabMemory(int i) {
        this.f40445c.putInt("default_tab_memory", i);
        this.f40445c.commit();
    }

    public String getGameVersion() {
        return this.f40444b.getString("game_version", "0");
    }

    public void setGameVersion(String str) {
        this.f40445c.putString("game_version", str);
        this.f40445c.commit();
    }

    public String getGameID() {
        return this.f40444b.getString("game_id", "");
    }

    public void setGameID(String str) {
        this.f40445c.putString("game_id", str);
        this.f40445c.commit();
    }

    public String getGameH5Url() {
        return this.f40444b.getString("game_h5url", "");
    }

    public void setGameH5Url(String str) {
        this.f40445c.putString("game_h5url", str);
        this.f40445c.commit();
    }

    public String getGameTitle() {
        return this.f40444b.getString("game_title", "");
    }

    public void setGameTitle(String str) {
        this.f40445c.putString("game_title", str);
        this.f40445c.commit();
    }

    public String getGameIcon() {
        return this.f40444b.getString("game_icon", "");
    }

    public void setGameIcon(String str) {
        this.f40445c.putString("game_icon", str);
        this.f40445c.commit();
    }

    public boolean isMenuGameRedPoint() {
        return this.f40444b.getBoolean("game_show_redpoint", false);
    }

    public void setMenuGameRedPoint(boolean z) {
        this.f40445c.putBoolean("game_show_redpoint", z);
        this.f40445c.commit();
    }

    public boolean getMenuGameInfoShow() {
        return this.f40444b.getBoolean("game_show_gameinfo", false);
    }

    public void setMenuGameInfoShow(boolean z) {
        this.f40445c.putBoolean("game_show_gameinfo", z);
        this.f40445c.commit();
    }

    public boolean isMenuGameShow() {
        return this.f40444b.getBoolean("game_show", false);
    }

    public void setMenuGameShow(boolean z) {
        this.f40445c.putBoolean("game_show", z);
        this.f40445c.commit();
    }

    public boolean setIsNewFound(boolean z) {
        this.f40445c.putBoolean("isShowFootBarTaxi", z);
        this.f40445c.commit();
        return z;
    }

    public boolean getIsNewFound() {
        return this.f40444b.getBoolean("isShowFootBarTaxi", false);
    }

    public boolean getBizShow4FootBar() {
        return this.f40444b.getBoolean("footbarTaxiType", false);
    }

    public void setBizShow4FootBar(boolean z) {
        this.f40445c.putBoolean("footbarTaxiType", z);
        this.f40445c.commit();
    }

    public int getBizFootBarShowType() {
        return this.f40444b.getInt("footbarTaxiTipType", 0);
    }

    public void setBizFootBarShowType(int i) {
        this.f40445c.putInt("footbarTaxiTipType", i);
        this.f40445c.commit();
    }

    public String getBizFootBarShowTips() {
        return this.f40444b.getString("footbarTaxiTip", "");
    }

    public void setBizFootBarShowTips(String str) {
        this.f40445c.putString("footbarTaxiTip", str);
        this.f40445c.commit();
    }

    public String getBizGameIcon() {
        return this.f40444b.getString("footbarTaxiTipIcon", "");
    }

    public void setBizGameIcon(String str) {
        this.f40445c.putString("footbarTaxiTipIcon", str);
        this.f40445c.commit();
    }

    public String getBizGameH5Url() {
        return this.f40444b.getString("footbarTaxiUrl", "");
    }

    public void setBizGameH5Url(String str) {
        this.f40445c.putString("footbarTaxiUrl", str);
        this.f40445c.commit();
    }

    public String getFoundConfigVersion() {
        return this.f40444b.getString("found_conf_version", "-1");
    }

    public void setFoundConfigVersion(String str) {
        this.f40445c.putString("found_conf_version", str);
        this.f40445c.commit();
    }

    public boolean getFoundMenuConfigIsLoaded() {
        return this.f40444b.getBoolean("found_menu_config_isloaded", false);
    }

    public void setFoundMenuConfigIsLoaded(boolean z) {
        this.f40445c.putBoolean("found_menu_config_isloaded", z);
        this.f40445c.commit();
    }

    public void setFoundMenuIsShow(boolean z) {
        this.f40445c.putBoolean("found_menu_isshow", z);
        this.f40445c.commit();
    }

    public boolean isShowMenuBiz() {
        return this.f40444b.getBoolean("found_menu_isshow", false);
    }

    public void setIsNewFoundUrl(boolean z) {
        this.f40445c.putBoolean("is_new_found_url", z);
        this.f40445c.commit();
    }

    public boolean isNewFoundUrl() {
        return this.f40444b.getBoolean("is_new_found_url", false);
    }

    public String getFoundMenuTitle() {
        return this.f40444b.getString("found_title", "");
    }

    public void setFoundMenuTitle(String str) {
        this.f40445c.putString("found_title", str);
        this.f40445c.commit();
    }

    public String getFoundMenuH5Url() {
        return this.f40444b.getString("found_h5_url", "");
    }

    public void setFoundMenuH5Url(String str) {
        this.f40445c.putString("found_h5_url", str);
        this.f40445c.commit();
    }

    public String getMenuBizFoodUrl() {
        return this.f40444b.getString("found_submenu_one_h5url", "");
    }

    public void setMenuBizFoodUrl(String str) {
        this.f40445c.putString("found_submenu_one_h5url", str);
        this.f40445c.commit();
    }

    public boolean isShowMenuBizCommunity() {
        return this.f40444b.getBoolean("is_show_menu_biz_community", false);
    }

    public void setShowMenuBizCommunity(boolean z) {
        this.f40445c.putBoolean("is_show_menu_biz_community", z);
        this.f40445c.commit();
    }

    public String getMenuBizCommunityUrl() {
        return this.f40444b.getString("menu_biz_community_url", "");
    }

    public void setMenuBizCommunityUrl(String str) {
        this.f40445c.putString("menu_biz_community_url", str);
        this.f40445c.commit();
    }

    public String getMenuBizCommunityTitle() {
        return this.f40444b.getString("menu_biz_community_title", "");
    }

    public void setMenuBizCommunityTitle(String str) {
        this.f40445c.putString("menu_biz_community_title", str);
        this.f40445c.commit();
    }

    public String getMenuBizFoodTitle() {
        return this.f40444b.getString("found_submenu_one_title", "");
    }

    public void setMenuBizFoodTitle(String str) {
        this.f40445c.putString("found_submenu_one_title", str);
        this.f40445c.commit();
    }

    public void setMenuBizFoodIcon(String str) {
        this.f40445c.putString("found_submenu_one_icon", str);
        this.f40445c.commit();
    }

    public boolean isShowMenuBizFood() {
        return this.f40444b.getBoolean("found_submenu_one_isshow", false);
    }

    public void setShowMenuBizFood(boolean z) {
        this.f40445c.putBoolean("found_submenu_one_isshow", z);
        this.f40445c.commit();
    }

    public boolean isShowMenuBizGame() {
        return this.f40444b.getBoolean("found_submenu_two_isshow", false);
    }

    public void setShowMenuBizGame(boolean z) {
        this.f40445c.putBoolean("found_submenu_two_isshow", z);
        this.f40445c.commit();
    }

    public String getMenuBizGameTitle() {
        return this.f40444b.getString("found_submenu_two_title", "");
    }

    public void setMenuBizGameTitle(String str) {
        this.f40445c.putString("found_submenu_two_title", str);
        this.f40445c.commit();
    }

    public String getMenuBizGameUrl() {
        return this.f40444b.getString("found_submenu_two_h5url", "");
    }

    public void setMenuBizGameUrl(String str) {
        this.f40445c.putString("found_submenu_two_h5url", str);
        this.f40445c.commit();
    }

    public String getMenuBizGameIcon() {
        return this.f40444b.getString("found_submenu_two_icon", "");
    }

    public void setMenuBizGameIcon(String str) {
        this.f40445c.putString("found_submenu_two_icon", str);
        this.f40445c.commit();
    }

    public boolean isGameShow4FootBar() {
        return this.f40444b.getBoolean("game_show_footbar", false);
    }

    public void setGameShow4FootBar(boolean z) {
        this.f40445c.putBoolean("game_show_footbar", z);
        this.f40445c.commit();
    }

    public int getMenuGameShowType() {
        return this.f40444b.getInt("game_show_type", 1);
    }

    public void setMenuGameShowType(int i) {
        this.f40445c.putInt("game_show_type", i);
        this.f40445c.commit();
    }

    public int getGameFootBarShowType() {
        return this.f40444b.getInt("game_footbar_showtype", 0);
    }

    public String getGameFootBarShowTips() {
        return this.f40444b.getString("game_footbar_showtips", "");
    }

    public void setGameFootBarShowTips(String str) {
        this.f40445c.putString("game_footbar_showtips", str);
        this.f40445c.commit();
    }

    public String getGameMenuText() {
        return this.f40444b.getString("game_menu_text", "");
    }

    public void setGameMenuText(String str) {
        this.f40445c.putString("game_menu_text", str);
        this.f40445c.commit();
    }

    public boolean getMenuShowGame() {
        return this.f40444b.getBoolean("menu_show_game", true);
    }

    public void setMenuShowGame(boolean z) {
        this.f40445c.putBoolean("menu_show_game", z);
        this.f40445c.commit();
    }

    public void isShowFootBarFood(boolean z) {
        this.f40445c.putBoolean("isShowFootBarFood", z);
        this.f40445c.commit();
    }

    public boolean getShowFootBarFood() {
        return this.f40444b.getBoolean("isShowFootBarFood", false);
    }

    public String getFootbarFoodTitle() {
        return this.f40444b.getString("footbarFoodTitle", "");
    }

    public void setFootbarFoodTitle(String str) {
        this.f40445c.putString("footbarFoodTitle", str);
        this.f40445c.commit();
    }

    public String getFootbarFoodTip() {
        return this.f40444b.getString("footbarFoodTip", "");
    }

    public void setFootbarFoodTip(String str) {
        this.f40445c.putString("footbarFoodTip", str);
        this.f40445c.commit();
    }

    public String getFootbarOldFoodTip() {
        return this.f40444b.getString("footbarOldFoodTip", "");
    }

    public void setFootbarOldFoodTip(String str) {
        this.f40445c.putString("footbarOldFoodTip", str);
        this.f40445c.commit();
    }

    public String getFootbarFoodIcon() {
        return this.f40444b.getString("footbarFoodIcon", "");
    }

    public void setFootbarFoodIcon(String str) {
        this.f40445c.putString("footbarFoodIcon", str);
        this.f40445c.commit();
    }

    public String getFootbarFoodUrl() {
        return this.f40444b.getString("footbarFoodUrl", "");
    }

    public void setFootbarFoodUrl(String str) {
        this.f40445c.putString("footbarFoodUrl", str);
        this.f40445c.commit();
    }

    public void isShowFootBarGame(boolean z) {
        this.f40445c.putBoolean("isShowFootBarGame", z);
        this.f40445c.commit();
    }

    public boolean getShowFootBarGame() {
        return this.f40444b.getBoolean("isShowFootBarGame", false);
    }

    public String getFootbarGameTitle() {
        return this.f40444b.getString("footbarGameTitle", "");
    }

    public void setFootbarGameTitle(String str) {
        this.f40445c.putString("footbarGameTitle", str);
        this.f40445c.commit();
    }

    public String getFootbarGameTip() {
        return this.f40444b.getString("footbarGameTip", "");
    }

    public void setFootbarGameTip(String str) {
        this.f40445c.putString("footbarGameTip", str);
        this.f40445c.commit();
    }

    public String getFootbarOldGameTip() {
        return this.f40444b.getString("footbarOldGameTip", "");
    }

    public void setFootbarOldGameTip(String str) {
        this.f40445c.putString("footbarOldGameTip", str);
        this.f40445c.commit();
    }

    public String getFootbarGameIcon() {
        return this.f40444b.getString("footbarGameIcon", "");
    }

    public void setFootbarGameIcon(String str) {
        this.f40445c.putString("footbarGameIcon", str);
        this.f40445c.commit();
    }

    public String getFootbarGameUrl() {
        return this.f40444b.getString("footbarGameUrl", "");
    }

    public void setFootbarGameUrl(String str) {
        this.f40445c.putString("footbarGameUrl", str);
        this.f40445c.commit();
    }

    public String getEgretGamePluginVersion() {
        return this.f40444b.getString("egret_plugin_version", "");
    }

    public void setEgretGamePluginVersion(String str) {
        this.f40445c.putString("egret_plugin_version", str);
        this.f40445c.commit();
    }

    public void setEgretGamePluginName(String str) {
        this.f40445c.putString("egret_plugin_name", str);
        this.f40445c.commit();
    }

    public void setEgretGamePluginZIPUrl(String str) {
        this.f40445c.putString("egret_plugin_zip_url", str);
        this.f40445c.commit();
    }

    public String getLayaGamePluginVersion() {
        return this.f40444b.getString("laya_plugin_version", "");
    }

    public void setLayaGamePluginVersion(String str) {
        this.f40445c.putString("laya_plugin_version", str);
        this.f40445c.commit();
    }

    public void setLayaGamePluginName(String str) {
        this.f40445c.putString("Laya_plugin_name", str);
        this.f40445c.commit();
    }

    public void setLayaGamePluginZIPUrl(String str) {
        this.f40445c.putString("Laya_plugin_zip_url", str);
        this.f40445c.commit();
    }

    public void reset() {
        setUnFinishSign(0);
        setToken((String) null);
        setTToken((String) null);
        setCreateOrderTimes(0);
        setHomeAddr((String) null);
        setHomeName((String) null);
        setCompanyAddr((String) null);
        setCompanyName((String) null);
        setHomeLatitude("-1");
        setHomeLongitude("-1");
        setCompanyLatitude("-1");
        setCompanyLongitude("-1");
        setHomeCityId(-1);
        setCompanyCityId(-1);
        setOrderCount(0);
        setBadOrderCount(0);
        setVirtualStatus(2);
        setPsngrId((String) null);
        setVoucherPointFlag(2);
        setFoundMenuConfigIsLoaded(false);
    }

    public void clear() {
        reset();
        this.f40445c.clear();
    }

    public void commit() {
        PreferenceEditorProxy preferenceEditorProxy = this.f40445c;
        if (preferenceEditorProxy != null) {
            preferenceEditorProxy.commit();
        }
    }

    public String getDiDiUUID() {
        PreferenceProxy preferenceProxy = this.f40444b;
        if (preferenceProxy == null) {
            return null;
        }
        return preferenceProxy.getString("didi_uuid", (String) null);
    }

    public void setDiDiUUID(String str) {
        PreferenceEditorProxy preferenceEditorProxy = this.f40445c;
        if (preferenceEditorProxy != null) {
            preferenceEditorProxy.putString("didi_uuid", str);
            this.f40445c.clear();
        }
    }

    public boolean isTopicOpen() {
        return this.f40444b.getBoolean("topic_open", false);
    }

    public void setTopicOpen(boolean z) {
        this.f40445c.putBoolean("topic_open", z);
        this.f40445c.commit();
    }

    public String getTopicName() {
        return this.f40444b.getString("topic_name", "");
    }

    public void setTopicName(String str) {
        this.f40445c.putString("topic_name", str);
        this.f40445c.commit();
    }

    public String getTopicButtonText1() {
        return this.f40444b.getString("buttonText1", "");
    }

    public void setTopicButtonText1(String str) {
        this.f40445c.putString("buttonText1", str);
        this.f40445c.commit();
    }

    public String getTopicButtonUrl1() {
        return this.f40444b.getString("buttonUrl1", "");
    }

    public void setTopicButtonUrl1(String str) {
        this.f40445c.putString("buttonUrl1", str);
        this.f40445c.commit();
    }

    public String getTopicButtonText2() {
        return this.f40444b.getString("buttonText2", "");
    }

    public void setTopicButtonText2(String str) {
        this.f40445c.putString("buttonText2", str);
        this.f40445c.commit();
    }

    public String getTopicButtonUrl2() {
        return this.f40444b.getString("buttonUrl2", "");
    }

    public void setTopicButtonUrl2(String str) {
        this.f40445c.putString("buttonUrl2", str);
        this.f40445c.commit();
    }

    public String getTopicHomeUrl() {
        return this.f40444b.getString("home_url", "");
    }

    public void setTopicHomeUrl(String str) {
        this.f40445c.putString("home_url", str);
        this.f40445c.commit();
    }

    public String getTopicIconUrl() {
        return this.f40444b.getString("icon_url", "");
    }

    public void setTopicIconUrl(String str) {
        this.f40445c.putString("icon_url", str);
        this.f40445c.commit();
    }

    public String getPublicize() {
        return this.f40444b.getString("publicize", "");
    }

    public void setPublicize(String str) {
        this.f40445c.putString("publicize", str);
        this.f40445c.commit();
    }

    public boolean isFlierOpen() {
        return this.f40444b.getBoolean("flier_open", false);
    }

    public void setFlierOpen(boolean z) {
        this.f40445c.putBoolean("flier_open", z);
        this.f40445c.commit();
    }

    public boolean isFlierAbility() {
        return this.f40444b.getBoolean("bill_ability", true);
    }

    public void setFlierAbility(boolean z) {
        this.f40445c.putBoolean("bill_ability", z);
        this.f40445c.commit();
    }

    public String getFlierName() {
        return this.f40444b.getString("flier_name", "");
    }

    public void setFlierName(String str) {
        this.f40445c.putString("flier_name", str);
        this.f40445c.commit();
    }

    public String getFlierMsg() {
        return this.f40444b.getString("msg", "");
    }

    public void setFlierMsg(String str) {
        this.f40445c.putString("msg", str);
        this.f40445c.commit();
    }

    public boolean isFlierInvoiceSwitch() {
        return this.f40444b.getBoolean("fast_car_invoice_switch", true);
    }

    public void setFlierInvoiceSwitch(int i) {
        PreferenceEditorProxy preferenceEditorProxy = this.f40445c;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        preferenceEditorProxy.putBoolean("fast_car_invoice_switch", z);
        this.f40445c.commit();
    }

    public boolean hasCarPoolGuidShown() {
        return this.f40444b.getBoolean("hasCarPoolGuideShown", false);
    }

    public void setCarPoolGuideShown(boolean z) {
        this.f40445c.putBoolean("hasCarPoolGuideShown", z);
        this.f40445c.commit();
    }

    public boolean isFirstClickVoice() {
        return this.f40444b.getBoolean("isFirstClickVoice1", true);
    }

    public void setFirstClickVoide(boolean z) {
        this.f40445c.putBoolean("isFirstClickVoice1", false);
        this.f40445c.commit();
    }

    public boolean isFirstUseCarPool() {
        return this.f40444b.getBoolean("isFirstUseCarPool", true);
    }

    public void setIsFirstUseCarPool(boolean z) {
        this.f40445c.putBoolean("isFirstUseCarPool", z);
        this.f40445c.commit();
    }

    public boolean isFirstLoadDepartNotication() {
        return this.f40444b.getBoolean("isFirstLoadDepartNotication", true);
    }

    public void setIsFirstLoadDepartNoticatoin(boolean z) {
        this.f40445c.putBoolean("isFirstLoadDepartNotication", z);
        this.f40445c.commit();
    }

    public void setSmooth(boolean z) {
        this.f40445c.putBoolean("driver_smooth", z);
        this.f40445c.commit();
    }

    public boolean isSmoothOpen() {
        return this.f40444b.getBoolean("driver_smooth", false);
    }

    public void setSmoothHomeFrequency(int i) {
        this.f40445c.putInt("smooth_home_frequency", i);
        this.f40445c.commit();
    }

    public int getSmoothHomeFreguency() {
        return this.f40444b.getInt("smooth_home_frequency", 10000);
    }

    public void setSmoothGoingFrequency(int i) {
        this.f40445c.putInt("smooth_going_frequency", i);
        this.f40445c.commit();
    }

    public int getSmoothGoingFreguency() {
        return this.f40444b.getInt("smooth_going_frequency", 10000);
    }

    public void setDriverIcon(String str, String str2) {
        PreferenceEditorProxy preferenceEditorProxy = this.f40445c;
        preferenceEditorProxy.putString("driver_icon_" + str, str2);
        this.f40445c.commit();
    }
}
