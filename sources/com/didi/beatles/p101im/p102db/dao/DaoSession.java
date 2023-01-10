package com.didi.beatles.p101im.p102db.dao;

import com.didi.beatles.p101im.p102db.entity.IMSessionDaoEntity;
import com.didi.beatles.p101im.p102db.entity.IMUserDaoEntity;
import com.didi.beatles.p101im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p101im.thirty.greenrobot.dao.AbstractDaoSession;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p101im.thirty.greenrobot.dao.identityscope.IdentityScopeType;
import com.didi.beatles.p101im.thirty.greenrobot.dao.internal.DaoConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.db.dao.DaoSession */
public class DaoSession extends AbstractDaoSession {

    /* renamed from: a */
    private final DaoConfig f11004a;

    /* renamed from: b */
    private final DaoConfig f11005b;

    /* renamed from: c */
    private final SessionDao f11006c;

    /* renamed from: d */
    private final UserDao f11007d;

    /* renamed from: e */
    private Database f11008e;

    /* renamed from: f */
    private Map<String, MessageDao> f11009f = new HashMap();

    /* renamed from: g */
    private Map<String, UserDao> f11010g = new HashMap();

    /* renamed from: h */
    private Map<String, DaoConfig> f11011h = new HashMap();

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<String, DaoConfig> map) {
        super(database);
        this.f11008e = database;
        DaoConfig clone = map.get(DaoMaster.SESSION_TABLE).clone();
        this.f11004a = clone;
        clone.initIdentityScope(identityScopeType);
        DaoConfig clone2 = map.get(DaoMaster.USER_TABLE).clone();
        this.f11005b = clone2;
        clone2.initIdentityScope(identityScopeType);
        this.f11006c = new SessionDao(this.f11004a, this);
        this.f11007d = new UserDao(this.f11005b, this);
        registerDao(IMSessionDaoEntity.class, this.f11006c);
        registerDao(IMUserDaoEntity.class, this.f11007d);
    }

    public void clear() {
        this.f11004a.getIdentityScope().clear();
        this.f11005b.getIdentityScope().clear();
        if (!this.f11011h.isEmpty()) {
            for (Map.Entry value : this.f11011h.entrySet()) {
                try {
                    ((DaoConfig) value.getValue()).getIdentityScope().clear();
                } catch (Exception unused) {
                }
            }
        }
        if (!this.f11009f.isEmpty()) {
            this.f11009f.clear();
        }
    }

    /* renamed from: a */
    private DaoConfig m9608a(Class<? extends AbstractDao<?, ?>> cls, String str) {
        Map<String, DaoConfig> map = this.f11011h;
        if (map != null && map.containsKey(str)) {
            return this.f11011h.get(str);
        }
        DaoConfig daoConfig = new DaoConfig(this.f11008e, cls, str);
        this.f11011h.put(str, daoConfig);
        return daoConfig;
    }

    public boolean containsMessageDao(long j) {
        String str = "im_message_table_" + j;
        Map<String, MessageDao> map = this.f11009f;
        return map != null && map.containsKey(str);
    }

    public MessageDao getMessageDao(long j) {
        String str = "im_message_table_" + j;
        Map<String, MessageDao> map = this.f11009f;
        if (map != null && map.containsKey(str)) {
            return this.f11009f.get(str);
        }
        DaoConfig a = m9608a(MessageDao.class, str);
        a.initIdentityScope(IdentityScopeType.Session);
        MessageDao messageDao = new MessageDao(a, this, str);
        messageDao.createTable(this.f11008e, true);
        messageDao.updateTable(this.f11008e);
        this.f11009f.put(str, messageDao);
        return messageDao;
    }

    public UserDao getUserDao(long j) {
        String str = "im_user_table_" + j;
        Map<String, UserDao> map = this.f11010g;
        if (map != null && map.containsKey(str)) {
            return this.f11010g.get(str);
        }
        DaoConfig a = m9608a(UserDao.class, str);
        a.initIdentityScope(IdentityScopeType.Session);
        UserDao userDao = new UserDao(a, this);
        userDao.createTableDynamic(this.f11008e, true);
        this.f11010g.put(str, userDao);
        return userDao;
    }

    public boolean removeMessageDao(String str) {
        Map<String, MessageDao> map = this.f11009f;
        if (map == null || !map.containsKey(str)) {
            return false;
        }
        this.f11009f.remove(str);
        return true;
    }

    public boolean removeUserDao(String str) {
        Map<String, UserDao> map = this.f11010g;
        if (map == null || !map.containsKey(str)) {
            return false;
        }
        this.f11010g.remove(str);
        return true;
    }

    public SessionDao getSessionDao() {
        return this.f11006c;
    }

    public UserDao getUserDao() {
        return this.f11007d;
    }
}
