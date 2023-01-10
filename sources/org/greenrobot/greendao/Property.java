package org.greenrobot.greendao;

import java.util.Collection;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.query.WhereCondition;
import org.osgi.framework.VersionRange;

public class Property {
    public final String columnName;
    public final String name;
    public final int ordinal;
    public final boolean primaryKey;
    public final Class<?> type;

    public Property(int i, Class<?> cls, String str, boolean z, String str2) {
        this.ordinal = i;
        this.type = cls;
        this.name = str;
        this.primaryKey = z;
        this.columnName = str2;
    }

    /* renamed from: eq */
    public WhereCondition mo38812eq(Object obj) {
        return new WhereCondition.PropertyCondition(this, "=?", obj);
    }

    public WhereCondition notEq(Object obj) {
        return new WhereCondition.PropertyCondition(this, "<>?", obj);
    }

    public WhereCondition like(String str) {
        return new WhereCondition.PropertyCondition(this, " LIKE ?", (Object) str);
    }

    public WhereCondition between(Object obj, Object obj2) {
        return new WhereCondition.PropertyCondition(this, " BETWEEN ? AND ?", new Object[]{obj, obj2});
    }

    /* renamed from: in */
    public WhereCondition mo38816in(Object... objArr) {
        StringBuilder sb = new StringBuilder(" IN (");
        SqlUtils.appendPlaceholders(sb, objArr.length).append(VersionRange.RIGHT_OPEN);
        return new WhereCondition.PropertyCondition(this, sb.toString(), objArr);
    }

    /* renamed from: in */
    public WhereCondition mo38815in(Collection<?> collection) {
        return mo38816in(collection.toArray());
    }

    public WhereCondition notIn(Object... objArr) {
        StringBuilder sb = new StringBuilder(" NOT IN (");
        SqlUtils.appendPlaceholders(sb, objArr.length).append(VersionRange.RIGHT_OPEN);
        return new WhereCondition.PropertyCondition(this, sb.toString(), objArr);
    }

    public WhereCondition notIn(Collection<?> collection) {
        return notIn(collection.toArray());
    }

    /* renamed from: gt */
    public WhereCondition mo38814gt(Object obj) {
        return new WhereCondition.PropertyCondition(this, ">?", obj);
    }

    /* renamed from: lt */
    public WhereCondition mo38821lt(Object obj) {
        return new WhereCondition.PropertyCondition(this, "<?", obj);
    }

    /* renamed from: ge */
    public WhereCondition mo38813ge(Object obj) {
        return new WhereCondition.PropertyCondition(this, ">=?", obj);
    }

    /* renamed from: le */
    public WhereCondition mo38819le(Object obj) {
        return new WhereCondition.PropertyCondition(this, "<=?", obj);
    }

    public WhereCondition isNull() {
        return new WhereCondition.PropertyCondition(this, " IS NULL");
    }

    public WhereCondition isNotNull() {
        return new WhereCondition.PropertyCondition(this, " IS NOT NULL");
    }
}
