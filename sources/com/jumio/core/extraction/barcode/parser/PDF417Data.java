package com.jumio.core.extraction.barcode.parser;

import com.jumio.core.enums.JumioGender;
import com.jumio.core.extraction.barcode.enums.EyeColor;
import java.util.Date;

public class PDF417Data {

    /* renamed from: a */
    public Date f57576a = null;

    /* renamed from: b */
    public Date f57577b = null;

    /* renamed from: c */
    public String f57578c = "";

    /* renamed from: d */
    public String f57579d = "";

    /* renamed from: e */
    public String f57580e = "";

    /* renamed from: f */
    public String f57581f = "";

    /* renamed from: g */
    public String f57582g = "";

    /* renamed from: h */
    public String f57583h = "";

    /* renamed from: i */
    public String f57584i = "";

    /* renamed from: j */
    public String f57585j = "";

    /* renamed from: k */
    public Date f57586k = null;

    /* renamed from: l */
    public JumioGender f57587l = null;

    /* renamed from: m */
    public EyeColor f57588m = null;

    /* renamed from: n */
    public String f57589n = "";

    /* renamed from: o */
    public String f57590o = "";

    /* renamed from: p */
    public String f57591p = "";

    /* renamed from: q */
    public String f57592q = "";

    /* renamed from: r */
    public String f57593r = "";

    /* renamed from: s */
    public String f57594s = "";

    /* renamed from: t */
    public String f57595t = "";

    /* renamed from: u */
    public final StringBuilder f57596u = new StringBuilder();

    /* renamed from: a */
    public final String mo172090a(String str) {
        if (!(str == null || str.length() == 0)) {
            String trim = str.replace(",", " ").trim();
            if (trim.equalsIgnoreCase("none") || trim.equalsIgnoreCase("unavl")) {
                return "";
            }
            return trim;
        }
        return "";
    }

    public void addUnparsedData(String str, String str2) {
        StringBuilder sb = this.f57596u;
        sb.append(str);
        sb.append(str2);
    }

    public String getAddressCity() {
        return this.f57592q;
    }

    public String getAddressState() {
        return this.f57593r;
    }

    public String getAddressStreet1() {
        return this.f57590o;
    }

    public String getAddressStreet2() {
        return this.f57591p;
    }

    public String getAddressZip() {
        return this.f57594s;
    }

    public Date getDateOfBirth() {
        return this.f57586k;
    }

    public String getEndorsementCodes() {
        return this.f57581f;
    }

    public Date getExpiryDate() {
        return this.f57577b;
    }

    public EyeColor getEyeColor() {
        return this.f57588m;
    }

    public String getFirstName() {
        return this.f57582g;
    }

    public JumioGender getGender() {
        return this.f57587l;
    }

    public String getHeight() {
        return this.f57589n;
    }

    public String getIdNumber() {
        return this.f57595t;
    }

    public Date getIssueDate() {
        return this.f57576a;
    }

    public String getIssuingCountry() {
        return this.f57578c;
    }

    public String getLastName() {
        return this.f57583h;
    }

    public String getMiddleName() {
        return this.f57584i;
    }

    public String getNameSuffix() {
        return this.f57585j;
    }

    public String getRestrictionCodes() {
        return this.f57580e;
    }

    public StringBuilder getUnparsedData() {
        return this.f57596u;
    }

    public String getVehicleClass() {
        return this.f57579d;
    }

    public void setAddressCity(String str) {
        this.f57592q = mo172090a(str);
    }

    public void setAddressState(String str) {
        this.f57593r = mo172090a(str);
    }

    public void setAddressStreet1(String str) {
        this.f57590o = mo172090a(str);
    }

    public void setAddressStreet2(String str) {
        this.f57591p = mo172090a(str);
    }

    public void setAddressZip(String str) {
        this.f57594s = mo172090a(str);
    }

    public void setDateOfBirth(Date date) {
        this.f57586k = date;
    }

    public void setEndorsementCodes(String str) {
        if (str != null && !str.trim().equals("")) {
            this.f57581f = str.trim();
        }
    }

    public void setExpiryDate(Date date) {
        this.f57577b = date;
    }

    public void setEyeColor(EyeColor eyeColor) {
        if (eyeColor != null) {
            this.f57588m = eyeColor;
        }
    }

    public void setFirstName(String str) {
        this.f57582g = mo172090a(str.trim());
    }

    public void setGender(JumioGender jumioGender) {
        if (jumioGender != null) {
            this.f57587l = jumioGender;
        }
    }

    public void setHeight(String str) {
        if (str != null && !str.trim().equals("")) {
            this.f57589n = str.trim();
        }
    }

    public void setIdNumber(String str) {
        this.f57595t = mo172090a(str);
    }

    public void setIssueDate(Date date) {
        this.f57576a = date;
    }

    public void setIssuingCountry(String str) {
        this.f57578c = mo172090a(str);
    }

    public void setLastName(String str) {
        this.f57583h = mo172090a(str.trim());
    }

    public void setMiddleName(String str) {
        this.f57584i = mo172090a(str.trim());
    }

    public void setNameSuffix(String str) {
        this.f57585j = mo172090a(str.trim());
    }

    public void setRestrictionCodes(String str) {
        if (str != null && !str.trim().equals("")) {
            this.f57580e = str.trim();
        }
    }

    public void setVehicleClass(String str) {
        if (str != null && !str.trim().equals("")) {
            this.f57579d = str.trim();
        }
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        if (this.f57576a != null) {
            sb.append("issueDate: ");
            sb.append(this.f57576a.toString());
            sb.append(str);
        }
        if (this.f57577b != null) {
            sb.append("expiryDate: ");
            sb.append(this.f57577b.toString());
            sb.append(str);
        }
        String str2 = this.f57578c;
        if (str2 != null && !str2.equals("")) {
            sb.append("issuingCountry: ");
            sb.append(this.f57578c);
            sb.append(str);
        }
        String str3 = this.f57579d;
        if (str3 != null && !str3.equals("")) {
            sb.append("vehicleClass: ");
            sb.append(this.f57579d);
            sb.append(str);
        }
        String str4 = this.f57580e;
        if (str4 != null && !str4.equals("")) {
            sb.append("restrictionCodes: ");
            sb.append(this.f57580e);
            sb.append(str);
        }
        String str5 = this.f57581f;
        if (str5 != null && !str5.equals("")) {
            sb.append("endorsementCodes: ");
            sb.append(this.f57581f);
            sb.append(str);
        }
        String str6 = this.f57582g;
        if (str6 != null && !str6.equals("")) {
            sb.append("firstName: ");
            sb.append(this.f57582g);
            sb.append(str);
        }
        String str7 = this.f57583h;
        if (str7 != null && !str7.equals("")) {
            sb.append("lastName: ");
            sb.append(this.f57583h);
            sb.append(str);
        }
        String str8 = this.f57584i;
        if (str8 != null && !str8.equals("")) {
            sb.append("middleName: ");
            sb.append(this.f57584i);
            sb.append(str);
        }
        if (this.f57586k != null) {
            sb.append("dateOfBirth: ");
            sb.append(this.f57586k);
            sb.append(str);
        }
        if (this.f57587l != null) {
            sb.append("sex: ");
            sb.append(this.f57587l.name());
            sb.append(str);
        }
        if (this.f57588m != null) {
            sb.append("eyeColor: ");
            sb.append(this.f57588m);
            sb.append(str);
        }
        String str9 = this.f57589n;
        if (str9 != null && !str9.equals("")) {
            sb.append("height: ");
            sb.append(this.f57589n);
            sb.append(str);
        }
        String str10 = this.f57590o;
        if (str10 != null && !str10.equals("")) {
            sb.append("addressStreet1: ");
            sb.append(this.f57590o);
            sb.append(str);
        }
        String str11 = this.f57591p;
        if (str11 != null && !str11.equals("")) {
            sb.append("addressStreet2: ");
            sb.append(this.f57591p);
            sb.append(str);
        }
        String str12 = this.f57592q;
        if (str12 != null && !str12.equals("")) {
            sb.append("addressCity: ");
            sb.append(this.f57592q);
            sb.append(str);
        }
        String str13 = this.f57593r;
        if (str13 != null && !str13.equals("")) {
            sb.append("addressState: ");
            sb.append(this.f57593r);
            sb.append(str);
        }
        String str14 = this.f57594s;
        if (str14 != null && !str14.equals("")) {
            sb.append("addressZip: ");
            sb.append(this.f57594s);
            sb.append(str);
        }
        String str15 = this.f57595t;
        if (str15 != null && !str15.equals("")) {
            sb.append("idNumber: ");
            sb.append(this.f57595t);
        }
        return sb.toString();
    }

    public String toString() {
        return toString(", ");
    }
}
