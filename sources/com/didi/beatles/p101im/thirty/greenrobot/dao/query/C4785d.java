package com.didi.beatles.p101im.thirty.greenrobot.dao.query;

import com.didi.beatles.p101im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p101im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p101im.thirty.greenrobot.dao.Property;
import com.didi.beatles.p101im.thirty.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.d */
/* compiled from: WhereCollector */
class C4785d<T> {

    /* renamed from: a */
    private final AbstractDao<T, ?> f11579a;

    /* renamed from: b */
    private final List<WhereCondition> f11580b = new ArrayList();

    /* renamed from: c */
    private final String f11581c;

    C4785d(AbstractDao<T, ?> abstractDao, String str) {
        this.f11579a = abstractDao;
        this.f11581c = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48683a(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        mo48682a(whereCondition);
        this.f11580b.add(whereCondition);
        for (WhereCondition whereCondition2 : whereConditionArr) {
            mo48682a(whereCondition2);
            this.f11580b.add(whereCondition2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WhereCondition mo48680a(String str, WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        StringBuilder sb = new StringBuilder("(");
        ArrayList arrayList = new ArrayList();
        mo48685a(sb, (List<Object>) arrayList, whereCondition);
        sb.append(str);
        mo48685a(sb, (List<Object>) arrayList, whereCondition2);
        for (WhereCondition a : whereConditionArr) {
            sb.append(str);
            mo48685a(sb, (List<Object>) arrayList, a);
        }
        sb.append(VersionRange.RIGHT_OPEN);
        return new WhereCondition.StringCondition(sb.toString(), arrayList.toArray());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48685a(StringBuilder sb, List<Object> list, WhereCondition whereCondition) {
        mo48682a(whereCondition);
        whereCondition.appendTo(sb, this.f11581c);
        whereCondition.appendValuesTo(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48682a(WhereCondition whereCondition) {
        if (whereCondition instanceof WhereCondition.PropertyCondition) {
            mo48681a(((WhereCondition.PropertyCondition) whereCondition).property);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48681a(Property property) {
        AbstractDao<T, ?> abstractDao = this.f11579a;
        if (abstractDao != null) {
            Property[] properties = abstractDao.getProperties();
            int length = properties.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (property == properties[i]) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                throw new DaoException("Property '" + property.name + "' is not part of " + this.f11579a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48684a(StringBuilder sb, String str, List<Object> list) {
        ListIterator<WhereCondition> listIterator = this.f11580b.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.hasPrevious()) {
                sb.append(" AND ");
            }
            WhereCondition next = listIterator.next();
            next.appendTo(sb, str);
            next.appendValuesTo(list);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo48686a() {
        return this.f11580b.isEmpty();
    }
}
