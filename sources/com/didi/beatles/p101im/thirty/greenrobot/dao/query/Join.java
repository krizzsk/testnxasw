package com.didi.beatles.p101im.thirty.greenrobot.dao.query;

import com.didi.beatles.p101im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p101im.thirty.greenrobot.dao.Property;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.Join */
public class Join<SRC, DST> {

    /* renamed from: a */
    final String f11557a;

    /* renamed from: b */
    final AbstractDao<DST, ?> f11558b;

    /* renamed from: c */
    final Property f11559c;

    /* renamed from: d */
    final Property f11560d;

    /* renamed from: e */
    final String f11561e;

    /* renamed from: f */
    final C4785d<DST> f11562f;

    public Join(String str, Property property, AbstractDao<DST, ?> abstractDao, Property property2, String str2) {
        this.f11557a = str;
        this.f11559c = property;
        this.f11558b = abstractDao;
        this.f11560d = property2;
        this.f11561e = str2;
        this.f11562f = new C4785d<>(abstractDao, str2);
    }

    public Join<SRC, DST> where(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        this.f11562f.mo48683a(whereCondition, whereConditionArr);
        return this;
    }

    public Join<SRC, DST> whereOr(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        this.f11562f.mo48683a(mo48596or(whereCondition, whereCondition2, whereConditionArr), new WhereCondition[0]);
        return this;
    }

    /* renamed from: or */
    public WhereCondition mo48596or(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.f11562f.mo48680a(" OR ", whereCondition, whereCondition2, whereConditionArr);
    }

    public WhereCondition and(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.f11562f.mo48680a(" AND ", whereCondition, whereCondition2, whereConditionArr);
    }
}
