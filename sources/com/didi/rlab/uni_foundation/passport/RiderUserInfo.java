package com.didi.rlab.uni_foundation.passport;

import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class RiderUserInfo extends UniModel {

    /* renamed from: A */
    private long f36867A;

    /* renamed from: B */
    private String f36868B;

    /* renamed from: C */
    private long f36869C;

    /* renamed from: D */
    private long f36870D;

    /* renamed from: E */
    private long f36871E;

    /* renamed from: F */
    private String f36872F;

    /* renamed from: G */
    private String f36873G;

    /* renamed from: H */
    private String f36874H;

    /* renamed from: I */
    private String f36875I;

    /* renamed from: J */
    private String f36876J;

    /* renamed from: K */
    private long f36877K;

    /* renamed from: L */
    private String f36878L;

    /* renamed from: M */
    private String f36879M;

    /* renamed from: N */
    private long f36880N;

    /* renamed from: O */
    private long f36881O;

    /* renamed from: P */
    private long f36882P;

    /* renamed from: Q */
    private long f36883Q;

    /* renamed from: R */
    private long f36884R;

    /* renamed from: S */
    private long f36885S;

    /* renamed from: T */
    private long f36886T;

    /* renamed from: U */
    private long f36887U;

    /* renamed from: V */
    private long f36888V;

    /* renamed from: W */
    private String f36889W;

    /* renamed from: X */
    private String f36890X;

    /* renamed from: Y */
    private String f36891Y;

    /* renamed from: a */
    private long f36892a;

    /* renamed from: b */
    private String f36893b;

    /* renamed from: c */
    private String f36894c;

    /* renamed from: d */
    private String f36895d;

    /* renamed from: e */
    private String f36896e;

    /* renamed from: f */
    private long f36897f;

    /* renamed from: g */
    private long f36898g;

    /* renamed from: h */
    private long f36899h;

    /* renamed from: i */
    private long f36900i;

    /* renamed from: j */
    private long f36901j;

    /* renamed from: k */
    private long f36902k;

    /* renamed from: l */
    private long f36903l;

    /* renamed from: m */
    private String f36904m;

    /* renamed from: n */
    private String f36905n;

    /* renamed from: o */
    private String f36906o;

    /* renamed from: p */
    private long f36907p;

    /* renamed from: q */
    private String f36908q;

    /* renamed from: r */
    private String f36909r;

    /* renamed from: s */
    private boolean f36910s;

    /* renamed from: t */
    private RiderCenter f36911t;

    /* renamed from: u */
    private String f36912u;

    /* renamed from: v */
    private String f36913v;

    /* renamed from: w */
    private long f36914w;

    /* renamed from: x */
    private LevelInfo f36915x;

    /* renamed from: y */
    private long f36916y;

    /* renamed from: z */
    private String f36917z;

    public long getID() {
        return this.f36892a;
    }

    public void setID(long j) {
        this.f36892a = j;
    }

    public String getPhone() {
        return this.f36893b;
    }

    public void setPhone(String str) {
        this.f36893b = str;
    }

    public String getRealname() {
        return this.f36894c;
    }

    public void setRealname(String str) {
        this.f36894c = str;
    }

    public String getNickname() {
        return this.f36895d;
    }

    public void setNickname(String str) {
        this.f36895d = str;
    }

    public String getHeadImg() {
        return this.f36896e;
    }

    public void setHeadImg(String str) {
        this.f36896e = str;
    }

    public long getCountyGroupID() {
        return this.f36897f;
    }

    public void setCountyGroupID(long j) {
        this.f36897f = j;
    }

    public long getCountyID() {
        return this.f36898g;
    }

    public void setCountyID(long j) {
        this.f36898g = j;
    }

    public long getCityID() {
        return this.f36899h;
    }

    public void setCityID(long j) {
        this.f36899h = j;
    }

    public long getAreaID() {
        return this.f36900i;
    }

    public void setAreaID(long j) {
        this.f36900i = j;
    }

    public long getStatus() {
        return this.f36901j;
    }

    public void setStatus(long j) {
        this.f36901j = j;
    }

    public long getWorkType() {
        return this.f36902k;
    }

    public void setWorkType(long j) {
        this.f36902k = j;
    }

    public long getChannel() {
        return this.f36903l;
    }

    public void setChannel(long j) {
        this.f36903l = j;
    }

    public String getLevel() {
        return this.f36904m;
    }

    public void setLevel(String str) {
        this.f36904m = str;
    }

    public String getLevelUrl() {
        return this.f36905n;
    }

    public void setLevelUrl(String str) {
        this.f36905n = str;
    }

    public String getVehicleType() {
        return this.f36906o;
    }

    public void setVehicleType(String str) {
        this.f36906o = str;
    }

    public long getNavType() {
        return this.f36907p;
    }

    public void setNavType(long j) {
        this.f36907p = j;
    }

    public String getCountryCode() {
        return this.f36908q;
    }

    public void setCountryCode(String str) {
        this.f36908q = str;
    }

    public String getCountry() {
        return this.f36909r;
    }

    public void setCountry(String str) {
        this.f36909r = str;
    }

    public boolean getTtsSwitch() {
        return this.f36910s;
    }

    public void setTtsSwitch(boolean z) {
        this.f36910s = z;
    }

    public RiderCenter getDidiSelect() {
        return this.f36911t;
    }

    public void setDidiSelect(RiderCenter riderCenter) {
        this.f36911t = riderCenter;
    }

    public String getLevelTitle() {
        return this.f36912u;
    }

    public void setLevelTitle(String str) {
        this.f36912u = str;
    }

    public String getCertsUrl() {
        return this.f36913v;
    }

    public void setCertsUrl(String str) {
        this.f36913v = str;
    }

    public long getLevelVersion() {
        return this.f36914w;
    }

    public void setLevelVersion(long j) {
        this.f36914w = j;
    }

    public LevelInfo getLevelInfo() {
        return this.f36915x;
    }

    public void setLevelInfo(LevelInfo levelInfo) {
        this.f36915x = levelInfo;
    }

    public long getActivateTime() {
        return this.f36916y;
    }

    public void setActivateTime(long j) {
        this.f36916y = j;
    }

    public String getAddress() {
        return this.f36917z;
    }

    public void setAddress(String str) {
        this.f36917z = str;
    }

    public long getBirthDate() {
        return this.f36867A;
    }

    public void setBirthDate(long j) {
        this.f36867A = j;
    }

    public String getCityName() {
        return this.f36868B;
    }

    public void setCityName(String str) {
        this.f36868B = str;
    }

    public long getClientType() {
        return this.f36869C;
    }

    public void setClientType(long j) {
        this.f36869C = j;
    }

    public long getCreateTime() {
        return this.f36870D;
    }

    public void setCreateTime(long j) {
        this.f36870D = j;
    }

    public long getCrimeScore() {
        return this.f36871E;
    }

    public void setCrimeScore(long j) {
        this.f36871E = j;
    }

    public String getEmail() {
        return this.f36872F;
    }

    public void setEmail(String str) {
        this.f36872F = str;
    }

    public String getEmergencyContactName() {
        return this.f36873G;
    }

    public void setEmergencyContactName(String str) {
        this.f36873G = str;
    }

    public String getEmergencyContactPhone() {
        return this.f36874H;
    }

    public void setEmergencyContactPhone(String str) {
        this.f36874H = str;
    }

    public String getEmployeeNo() {
        return this.f36875I;
    }

    public void setEmployeeNo(String str) {
        this.f36875I = str;
    }

    public String getEquipment() {
        return this.f36876J;
    }

    public void setEquipment(String str) {
        this.f36876J = str;
    }

    public long getExpireTime() {
        return this.f36877K;
    }

    public void setExpireTime(long j) {
        this.f36877K = j;
    }

    public String getExtra() {
        return this.f36878L;
    }

    public void setExtra(String str) {
        this.f36878L = str;
    }

    public String getIdNo() {
        return this.f36879M;
    }

    public void setIdNo(String str) {
        this.f36879M = str;
    }

    public long getIp() {
        return this.f36880N;
    }

    public void setIp(long j) {
        this.f36880N = j;
    }

    public long getLastLoginIp() {
        return this.f36881O;
    }

    public void setLastLoginIp(long j) {
        this.f36881O = j;
    }

    public long getLastLoginTime() {
        return this.f36882P;
    }

    public void setLastLoginTime(long j) {
        this.f36882P = j;
    }

    public long getSource() {
        return this.f36883Q;
    }

    public void setSource(long j) {
        this.f36883Q = j;
    }

    public long getTrainStatus() {
        return this.f36884R;
    }

    public void setTrainStatus(long j) {
        this.f36884R = j;
    }

    public long getUpdateTime() {
        return this.f36885S;
    }

    public void setUpdateTime(long j) {
        this.f36885S = j;
    }

    public long getVerified() {
        return this.f36886T;
    }

    public void setVerified(long j) {
        this.f36886T = j;
    }

    public long getGender() {
        return this.f36887U;
    }

    public void setGender(long j) {
        this.f36887U = j;
    }

    public long getDeadlineTime() {
        return this.f36888V;
    }

    public void setDeadlineTime(long j) {
        this.f36888V = j;
    }

    public String getVendorCode() {
        return this.f36889W;
    }

    public void setVendorCode(String str) {
        this.f36889W = str;
    }

    public String getVendorRiderLabel() {
        return this.f36890X;
    }

    public void setVendorRiderLabel(String str) {
        this.f36890X = str;
    }

    public String getVendorRiderLabelUrl() {
        return this.f36891Y;
    }

    public void setVendorRiderLabelUrl(String str) {
        this.f36891Y = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ID", Long.valueOf(this.f36892a));
        hashMap.put("phone", this.f36893b);
        hashMap.put("realname", this.f36894c);
        hashMap.put("nickname", this.f36895d);
        hashMap.put("headImg", this.f36896e);
        hashMap.put("countyGroupID", Long.valueOf(this.f36897f));
        hashMap.put("countyID", Long.valueOf(this.f36898g));
        hashMap.put("cityID", Long.valueOf(this.f36899h));
        hashMap.put("areaID", Long.valueOf(this.f36900i));
        hashMap.put("status", Long.valueOf(this.f36901j));
        hashMap.put("workType", Long.valueOf(this.f36902k));
        hashMap.put("channel", Long.valueOf(this.f36903l));
        hashMap.put("level", this.f36904m);
        hashMap.put("levelUrl", this.f36905n);
        hashMap.put("vehicleType", this.f36906o);
        hashMap.put("navType", Long.valueOf(this.f36907p));
        hashMap.put("countryCode", this.f36908q);
        hashMap.put("country", this.f36909r);
        hashMap.put("ttsSwitch", Boolean.valueOf(this.f36910s));
        RiderCenter riderCenter = this.f36911t;
        if (riderCenter != null) {
            hashMap.put("didiSelect", riderCenter.toMap());
        }
        hashMap.put("levelTitle", this.f36912u);
        hashMap.put("certsUrl", this.f36913v);
        hashMap.put("levelVersion", Long.valueOf(this.f36914w));
        LevelInfo levelInfo = this.f36915x;
        if (levelInfo != null) {
            hashMap.put("levelInfo", levelInfo.toMap());
        }
        hashMap.put("activateTime", Long.valueOf(this.f36916y));
        hashMap.put("address", this.f36917z);
        hashMap.put("birthDate", Long.valueOf(this.f36867A));
        hashMap.put(InvitationPageActivity.CITY_NAME, this.f36868B);
        hashMap.put("clientType", Long.valueOf(this.f36869C));
        hashMap.put("createTime", Long.valueOf(this.f36870D));
        hashMap.put("crimeScore", Long.valueOf(this.f36871E));
        hashMap.put("email", this.f36872F);
        hashMap.put("emergencyContactName", this.f36873G);
        hashMap.put("emergencyContactPhone", this.f36874H);
        hashMap.put("employeeNo", this.f36875I);
        hashMap.put("equipment", this.f36876J);
        hashMap.put("expireTime", Long.valueOf(this.f36877K));
        hashMap.put("extra", this.f36878L);
        hashMap.put("idNo", this.f36879M);
        hashMap.put("ip", Long.valueOf(this.f36880N));
        hashMap.put("lastLoginIp", Long.valueOf(this.f36881O));
        hashMap.put("lastLoginTime", Long.valueOf(this.f36882P));
        hashMap.put("source", Long.valueOf(this.f36883Q));
        hashMap.put("trainStatus", Long.valueOf(this.f36884R));
        hashMap.put("updateTime", Long.valueOf(this.f36885S));
        hashMap.put("verified", Long.valueOf(this.f36886T));
        hashMap.put("gender", Long.valueOf(this.f36887U));
        hashMap.put("deadlineTime", Long.valueOf(this.f36888V));
        hashMap.put("vendorCode", this.f36889W);
        hashMap.put("vendorRiderLabel", this.f36890X);
        hashMap.put("vendorRiderLabelUrl", this.f36891Y);
        return hashMap;
    }

    public static RiderUserInfo fromMap(Map<String, Object> map) {
        RiderUserInfo riderUserInfo = new RiderUserInfo();
        long j = 0;
        riderUserInfo.f36892a = (!map.containsKey("ID") || map.get("ID") == null) ? 0 : ((Number) map.get("ID")).longValue();
        String str = "";
        riderUserInfo.f36893b = (!map.containsKey("phone") || map.get("phone") == null) ? str : (String) map.get("phone");
        riderUserInfo.f36894c = (!map.containsKey("realname") || map.get("realname") == null) ? str : (String) map.get("realname");
        riderUserInfo.f36895d = (!map.containsKey("nickname") || map.get("nickname") == null) ? str : (String) map.get("nickname");
        riderUserInfo.f36896e = (!map.containsKey("headImg") || map.get("headImg") == null) ? str : (String) map.get("headImg");
        riderUserInfo.f36897f = (!map.containsKey("countyGroupID") || map.get("countyGroupID") == null) ? 0 : ((Number) map.get("countyGroupID")).longValue();
        riderUserInfo.f36898g = (!map.containsKey("countyID") || map.get("countyID") == null) ? 0 : ((Number) map.get("countyID")).longValue();
        riderUserInfo.f36899h = (!map.containsKey("cityID") || map.get("cityID") == null) ? 0 : ((Number) map.get("cityID")).longValue();
        riderUserInfo.f36900i = (!map.containsKey("areaID") || map.get("areaID") == null) ? 0 : ((Number) map.get("areaID")).longValue();
        riderUserInfo.f36901j = (!map.containsKey("status") || map.get("status") == null) ? 0 : ((Number) map.get("status")).longValue();
        riderUserInfo.f36902k = (!map.containsKey("workType") || map.get("workType") == null) ? 0 : ((Number) map.get("workType")).longValue();
        riderUserInfo.f36903l = (!map.containsKey("channel") || map.get("channel") == null) ? 0 : ((Number) map.get("channel")).longValue();
        riderUserInfo.f36904m = (!map.containsKey("level") || map.get("level") == null) ? str : (String) map.get("level");
        riderUserInfo.f36905n = (!map.containsKey("levelUrl") || map.get("levelUrl") == null) ? str : (String) map.get("levelUrl");
        riderUserInfo.f36906o = (!map.containsKey("vehicleType") || map.get("vehicleType") == null) ? str : (String) map.get("vehicleType");
        riderUserInfo.f36907p = (!map.containsKey("navType") || map.get("navType") == null) ? 0 : ((Number) map.get("navType")).longValue();
        riderUserInfo.f36908q = (!map.containsKey("countryCode") || map.get("countryCode") == null) ? str : (String) map.get("countryCode");
        riderUserInfo.f36909r = (!map.containsKey("country") || map.get("country") == null) ? str : (String) map.get("country");
        riderUserInfo.f36910s = (!map.containsKey("ttsSwitch") || map.get("ttsSwitch") == null) ? false : ((Boolean) map.get("ttsSwitch")).booleanValue();
        riderUserInfo.f36911t = (!map.containsKey("didiSelect") || map.get("didiSelect") == null) ? null : RiderCenter.fromMap((Map) map.get("didiSelect"));
        riderUserInfo.f36912u = (!map.containsKey("levelTitle") || map.get("levelTitle") == null) ? str : (String) map.get("levelTitle");
        riderUserInfo.f36913v = (!map.containsKey("certsUrl") || map.get("certsUrl") == null) ? str : (String) map.get("certsUrl");
        riderUserInfo.f36914w = (!map.containsKey("levelVersion") || map.get("levelVersion") == null) ? 0 : ((Number) map.get("levelVersion")).longValue();
        riderUserInfo.f36915x = (!map.containsKey("levelInfo") || map.get("levelInfo") == null) ? null : LevelInfo.fromMap((Map) map.get("levelInfo"));
        riderUserInfo.f36916y = (!map.containsKey("activateTime") || map.get("activateTime") == null) ? 0 : ((Number) map.get("activateTime")).longValue();
        riderUserInfo.f36917z = (!map.containsKey("address") || map.get("address") == null) ? str : (String) map.get("address");
        riderUserInfo.f36867A = (!map.containsKey("birthDate") || map.get("birthDate") == null) ? 0 : ((Number) map.get("birthDate")).longValue();
        riderUserInfo.f36868B = (!map.containsKey(InvitationPageActivity.CITY_NAME) || map.get(InvitationPageActivity.CITY_NAME) == null) ? str : (String) map.get(InvitationPageActivity.CITY_NAME);
        riderUserInfo.f36869C = (!map.containsKey("clientType") || map.get("clientType") == null) ? 0 : ((Number) map.get("clientType")).longValue();
        riderUserInfo.f36870D = (!map.containsKey("createTime") || map.get("createTime") == null) ? 0 : ((Number) map.get("createTime")).longValue();
        riderUserInfo.f36871E = (!map.containsKey("crimeScore") || map.get("crimeScore") == null) ? 0 : ((Number) map.get("crimeScore")).longValue();
        riderUserInfo.f36872F = (!map.containsKey("email") || map.get("email") == null) ? str : (String) map.get("email");
        riderUserInfo.f36873G = (!map.containsKey("emergencyContactName") || map.get("emergencyContactName") == null) ? str : (String) map.get("emergencyContactName");
        riderUserInfo.f36874H = (!map.containsKey("emergencyContactPhone") || map.get("emergencyContactPhone") == null) ? str : (String) map.get("emergencyContactPhone");
        riderUserInfo.f36875I = (!map.containsKey("employeeNo") || map.get("employeeNo") == null) ? str : (String) map.get("employeeNo");
        riderUserInfo.f36876J = (!map.containsKey("equipment") || map.get("equipment") == null) ? str : (String) map.get("equipment");
        riderUserInfo.f36877K = (!map.containsKey("expireTime") || map.get("expireTime") == null) ? 0 : ((Number) map.get("expireTime")).longValue();
        riderUserInfo.f36878L = (!map.containsKey("extra") || map.get("extra") == null) ? str : (String) map.get("extra");
        riderUserInfo.f36879M = (!map.containsKey("idNo") || map.get("idNo") == null) ? str : (String) map.get("idNo");
        riderUserInfo.f36880N = (!map.containsKey("ip") || map.get("ip") == null) ? 0 : ((Number) map.get("ip")).longValue();
        riderUserInfo.f36881O = (!map.containsKey("lastLoginIp") || map.get("lastLoginIp") == null) ? 0 : ((Number) map.get("lastLoginIp")).longValue();
        riderUserInfo.f36882P = (!map.containsKey("lastLoginTime") || map.get("lastLoginTime") == null) ? 0 : ((Number) map.get("lastLoginTime")).longValue();
        riderUserInfo.f36883Q = (!map.containsKey("source") || map.get("source") == null) ? 0 : ((Number) map.get("source")).longValue();
        riderUserInfo.f36884R = (!map.containsKey("trainStatus") || map.get("trainStatus") == null) ? 0 : ((Number) map.get("trainStatus")).longValue();
        riderUserInfo.f36885S = (!map.containsKey("updateTime") || map.get("updateTime") == null) ? 0 : ((Number) map.get("updateTime")).longValue();
        riderUserInfo.f36886T = (!map.containsKey("verified") || map.get("verified") == null) ? 0 : ((Number) map.get("verified")).longValue();
        riderUserInfo.f36887U = (!map.containsKey("gender") || map.get("gender") == null) ? 0 : ((Number) map.get("gender")).longValue();
        if (map.containsKey("deadlineTime") && map.get("deadlineTime") != null) {
            j = ((Number) map.get("deadlineTime")).longValue();
        }
        riderUserInfo.f36888V = j;
        riderUserInfo.f36889W = (!map.containsKey("vendorCode") || map.get("vendorCode") == null) ? str : (String) map.get("vendorCode");
        riderUserInfo.f36890X = (!map.containsKey("vendorRiderLabel") || map.get("vendorRiderLabel") == null) ? str : (String) map.get("vendorRiderLabel");
        if (map.containsKey("vendorRiderLabelUrl") && map.get("vendorRiderLabelUrl") != null) {
            str = (String) map.get("vendorRiderLabelUrl");
        }
        riderUserInfo.f36891Y = str;
        return riderUserInfo;
    }
}
