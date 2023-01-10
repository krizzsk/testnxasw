package com.didi.beatles.p101im.thirty.greenrobot.dao.internal;

import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.DatabaseStatement;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.internal.TableStatements */
public class TableStatements {

    /* renamed from: a */
    private final Database f11542a;

    /* renamed from: b */
    private final String f11543b;

    /* renamed from: c */
    private final String[] f11544c;

    /* renamed from: d */
    private final String[] f11545d;

    /* renamed from: e */
    private DatabaseStatement f11546e;

    /* renamed from: f */
    private DatabaseStatement f11547f;

    /* renamed from: g */
    private DatabaseStatement f11548g;

    /* renamed from: h */
    private DatabaseStatement f11549h;

    /* renamed from: i */
    private volatile String f11550i;

    /* renamed from: j */
    private volatile String f11551j;

    /* renamed from: k */
    private volatile String f11552k;

    /* renamed from: l */
    private volatile String f11553l;

    public TableStatements(Database database, String str, String[] strArr, String[] strArr2) {
        this.f11542a = database;
        this.f11543b = str;
        this.f11544c = strArr;
        this.f11545d = strArr2;
    }

    public DatabaseStatement getInsertStatement() {
        if (this.f11546e == null) {
            this.f11546e = this.f11542a.compileStatement(SqlUtils.createSqlInsert("INSERT INTO ", this.f11543b, this.f11544c));
        }
        return this.f11546e;
    }

    public DatabaseStatement getInsertOrReplaceStatement() {
        if (this.f11547f == null) {
            this.f11547f = this.f11542a.compileStatement(SqlUtils.createSqlInsert("INSERT OR REPLACE INTO ", this.f11543b, this.f11544c));
        }
        return this.f11547f;
    }

    public DatabaseStatement getDeleteStatement() {
        if (this.f11549h == null) {
            this.f11549h = this.f11542a.compileStatement(SqlUtils.createSqlDelete(this.f11543b, this.f11545d));
        }
        return this.f11549h;
    }

    public DatabaseStatement getUpdateStatement() {
        if (this.f11548g == null) {
            this.f11548g = this.f11542a.compileStatement(SqlUtils.createSqlUpdate(this.f11543b, this.f11544c, this.f11545d));
        }
        return this.f11548g;
    }

    public String getSelectAll() {
        if (this.f11550i == null) {
            this.f11550i = SqlUtils.createSqlSelect(this.f11543b, "T", this.f11544c);
        }
        return this.f11550i;
    }

    public String getSelectKeys() {
        if (this.f11553l == null) {
            this.f11553l = SqlUtils.createSqlSelect(this.f11543b, "T", this.f11545d);
        }
        return this.f11553l;
    }

    public String getSelectByKey() {
        if (this.f11551j == null) {
            StringBuilder sb = new StringBuilder(getSelectAll());
            sb.append("WHERE ");
            SqlUtils.appendColumnsEqValue(sb, "T", this.f11545d);
            this.f11551j = sb.toString();
        }
        return this.f11551j;
    }

    public String getSelectByRowId() {
        if (this.f11552k == null) {
            this.f11552k = getSelectAll() + "WHERE ROWID=?";
        }
        return this.f11552k;
    }
}
