package com.didi.beatles.p101im.thirty.greenrobot.dao.query;

import com.didi.beatles.p101im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p101im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p101im.thirty.greenrobot.dao.DaoLog;
import com.didi.beatles.p101im.thirty.greenrobot.dao.Property;
import com.didi.beatles.p101im.thirty.greenrobot.dao.internal.SqlUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.QueryBuilder */
public class QueryBuilder<T> {
    public static boolean LOG_SQL;
    public static boolean LOG_VALUES;

    /* renamed from: a */
    private final C4785d<T> f11570a;

    /* renamed from: b */
    private StringBuilder f11571b;

    /* renamed from: c */
    private final List<Object> f11572c;

    /* renamed from: d */
    private final List<Join<T, ?>> f11573d;

    /* renamed from: e */
    private final AbstractDao<T, ?> f11574e;

    /* renamed from: f */
    private final String f11575f;

    /* renamed from: g */
    private Integer f11576g;

    /* renamed from: h */
    private Integer f11577h;

    public static <T2> QueryBuilder<T2> internalCreate(AbstractDao<T2, ?> abstractDao) {
        return new QueryBuilder<>(abstractDao);
    }

    protected QueryBuilder(AbstractDao<T, ?> abstractDao) {
        this(abstractDao, "T");
    }

    protected QueryBuilder(AbstractDao<T, ?> abstractDao, String str) {
        this.f11574e = abstractDao;
        this.f11575f = str;
        this.f11572c = new ArrayList();
        this.f11573d = new ArrayList();
        this.f11570a = new C4785d<>(abstractDao, str);
    }

    /* renamed from: a */
    private void m9965a() {
        StringBuilder sb = this.f11571b;
        if (sb == null) {
            this.f11571b = new StringBuilder();
        } else if (sb.length() > 0) {
            this.f11571b.append(",");
        }
    }

    public QueryBuilder<T> where(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        this.f11570a.mo48683a(whereCondition, whereConditionArr);
        return this;
    }

    public QueryBuilder<T> whereOr(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        this.f11570a.mo48683a(mo48665or(whereCondition, whereCondition2, whereConditionArr), new WhereCondition[0]);
        return this;
    }

    /* renamed from: or */
    public WhereCondition mo48665or(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.f11570a.mo48680a(" OR ", whereCondition, whereCondition2, whereConditionArr);
    }

    public WhereCondition and(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.f11570a.mo48680a(" AND ", whereCondition, whereCondition2, whereConditionArr);
    }

    public <J> Join<T, J> join(Class<J> cls, Property property) {
        return join(this.f11574e.getPkProperty(), cls, property);
    }

    public <J> Join<T, J> join(Property property, Class<J> cls) {
        AbstractDao<?, ?> dao = this.f11574e.getSession().getDao(cls);
        return m9964a(this.f11575f, property, dao, dao.getPkProperty());
    }

    public <J> Join<T, J> join(Property property, Class<J> cls, Property property2) {
        return m9964a(this.f11575f, property, this.f11574e.getSession().getDao(cls), property2);
    }

    public <J> Join<T, J> join(Join<?, T> join, Property property, Class<J> cls, Property property2) {
        return m9964a(join.f11561e, property, this.f11574e.getSession().getDao(cls), property2);
    }

    /* renamed from: a */
    private <J> Join<T, J> m9964a(String str, Property property, AbstractDao<J, ?> abstractDao, Property property2) {
        Join join = new Join(str, property, abstractDao, property2, "J" + (this.f11573d.size() + 1));
        this.f11573d.add(join);
        return join;
    }

    public QueryBuilder<T> orderAsc(Property... propertyArr) {
        m9967a(" ASC", propertyArr);
        return this;
    }

    public QueryBuilder<T> orderDesc(Property... propertyArr) {
        m9967a(" DESC", propertyArr);
        return this;
    }

    /* renamed from: a */
    private void m9967a(String str, Property... propertyArr) {
        for (Property property : propertyArr) {
            m9965a();
            append(this.f11571b, property);
            if (String.class.equals(property.type)) {
                this.f11571b.append(" COLLATE LOCALIZED");
            }
            this.f11571b.append(str);
        }
    }

    public QueryBuilder<T> orderCustom(Property property, String str) {
        m9965a();
        append(this.f11571b, property).append(' ');
        this.f11571b.append(str);
        return this;
    }

    public QueryBuilder<T> orderRaw(String str) {
        m9965a();
        this.f11571b.append(str);
        return this;
    }

    /* access modifiers changed from: protected */
    public StringBuilder append(StringBuilder sb, Property property) {
        this.f11570a.mo48681a(property);
        sb.append(this.f11575f);
        sb.append('.');
        sb.append('\'');
        sb.append(property.columnName);
        sb.append('\'');
        return sb;
    }

    public QueryBuilder<T> limit(int i) {
        this.f11576g = Integer.valueOf(i);
        return this;
    }

    public QueryBuilder<T> offset(int i) {
        this.f11577h = Integer.valueOf(i);
        return this;
    }

    public Query<T> build() {
        StringBuilder b = m9970b();
        int a = m9963a(b);
        int b2 = m9969b(b);
        String sb = b.toString();
        m9966a(sb);
        return Query.m9962a(this.f11574e, sb, this.f11572c.toArray(), a, b2);
    }

    public CursorQuery buildCursor() {
        StringBuilder b = m9970b();
        int a = m9963a(b);
        int b2 = m9969b(b);
        String sb = b.toString();
        m9966a(sb);
        return CursorQuery.m9958a(this.f11574e, sb, this.f11572c.toArray(), a, b2);
    }

    /* renamed from: b */
    private StringBuilder m9970b() {
        StringBuilder sb = new StringBuilder(SqlUtils.createSqlSelect(this.f11574e.getTablename(), this.f11575f, this.f11574e.getAllColumns()));
        m9968a(sb, this.f11575f);
        StringBuilder sb2 = this.f11571b;
        if (sb2 != null && sb2.length() > 0) {
            sb.append(" ORDER BY ");
            sb.append(this.f11571b);
        }
        return sb;
    }

    /* renamed from: a */
    private int m9963a(StringBuilder sb) {
        if (this.f11576g == null) {
            return -1;
        }
        sb.append(" LIMIT ?");
        this.f11572c.add(this.f11576g);
        return this.f11572c.size() - 1;
    }

    /* renamed from: b */
    private int m9969b(StringBuilder sb) {
        if (this.f11577h == null) {
            return -1;
        }
        if (this.f11576g != null) {
            sb.append(" OFFSET ?");
            this.f11572c.add(this.f11577h);
            return this.f11572c.size() - 1;
        }
        throw new IllegalStateException("Offset cannot be set without limit");
    }

    public DeleteQuery<T> buildDelete() {
        if (this.f11573d.isEmpty()) {
            String tablename = this.f11574e.getTablename();
            StringBuilder sb = new StringBuilder(SqlUtils.createSqlDelete(tablename, (String[]) null));
            m9968a(sb, this.f11575f);
            String replace = sb.toString().replace(this.f11575f + ".\"", Typography.quote + tablename + "\".\"");
            m9966a(replace);
            return DeleteQuery.m9959a(this.f11574e, replace, this.f11572c.toArray());
        }
        throw new DaoException("JOINs are not supported for DELETE queries");
    }

    public CountQuery<T> buildCount() {
        StringBuilder sb = new StringBuilder(SqlUtils.createSqlSelectCountStar(this.f11574e.getTablename(), this.f11575f));
        m9968a(sb, this.f11575f);
        String sb2 = sb.toString();
        m9966a(sb2);
        return CountQuery.m9957a(this.f11574e, sb2, this.f11572c.toArray());
    }

    /* renamed from: a */
    private void m9966a(String str) {
        if (LOG_SQL) {
            DaoLog.m9913d("Built SQL for query: " + str);
        }
        if (LOG_VALUES) {
            DaoLog.m9913d("Values for query: " + this.f11572c);
        }
    }

    /* renamed from: a */
    private void m9968a(StringBuilder sb, String str) {
        this.f11572c.clear();
        for (Join next : this.f11573d) {
            sb.append(" JOIN ");
            sb.append(next.f11558b.getTablename());
            sb.append(' ');
            sb.append(next.f11561e);
            sb.append(" ON ");
            SqlUtils.appendProperty(sb, next.f11557a, next.f11559c).append('=');
            SqlUtils.appendProperty(sb, next.f11561e, next.f11560d);
        }
        boolean z = !this.f11570a.mo48686a();
        if (z) {
            sb.append(" WHERE ");
            this.f11570a.mo48684a(sb, str, this.f11572c);
        }
        for (Join next2 : this.f11573d) {
            if (!next2.f11562f.mo48686a()) {
                if (!z) {
                    sb.append(" WHERE ");
                    z = true;
                } else {
                    sb.append(" AND ");
                }
                next2.f11562f.mo48684a(sb, next2.f11561e, this.f11572c);
            }
        }
    }

    public List<T> list() {
        return build().list();
    }

    public LazyList<T> listLazy() {
        return build().listLazy();
    }

    public LazyList<T> listLazyUncached() {
        return build().listLazyUncached();
    }

    public CloseableListIterator<T> listIterator() {
        return build().listIterator();
    }

    public T unique() {
        return build().unique();
    }

    public T uniqueOrThrow() {
        return build().uniqueOrThrow();
    }

    public long count() {
        return buildCount().count();
    }
}
