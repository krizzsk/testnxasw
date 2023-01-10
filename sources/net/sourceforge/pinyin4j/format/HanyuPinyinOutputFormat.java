package net.sourceforge.pinyin4j.format;

public final class HanyuPinyinOutputFormat {

    /* renamed from: a */
    private HanyuPinyinVCharType f6921a;

    /* renamed from: b */
    private HanyuPinyinCaseType f6922b;

    /* renamed from: c */
    private HanyuPinyinToneType f6923c;

    public HanyuPinyinOutputFormat() {
        restoreDefault();
    }

    public void restoreDefault() {
        this.f6921a = HanyuPinyinVCharType.WITH_U_AND_COLON;
        this.f6922b = HanyuPinyinCaseType.LOWERCASE;
        this.f6923c = HanyuPinyinToneType.WITH_TONE_NUMBER;
    }

    public HanyuPinyinCaseType getCaseType() {
        return this.f6922b;
    }

    public void setCaseType(HanyuPinyinCaseType hanyuPinyinCaseType) {
        this.f6922b = hanyuPinyinCaseType;
    }

    public HanyuPinyinToneType getToneType() {
        return this.f6923c;
    }

    public void setToneType(HanyuPinyinToneType hanyuPinyinToneType) {
        this.f6923c = hanyuPinyinToneType;
    }

    public HanyuPinyinVCharType getVCharType() {
        return this.f6921a;
    }

    public void setVCharType(HanyuPinyinVCharType hanyuPinyinVCharType) {
        this.f6921a = hanyuPinyinVCharType;
    }
}
