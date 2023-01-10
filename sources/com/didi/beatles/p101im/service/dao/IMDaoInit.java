package com.didi.beatles.p101im.service.dao;

import com.didi.beatles.p101im.p102db.dao.DaoMaster;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;

/* renamed from: com.didi.beatles.im.service.dao.IMDaoInit */
public interface IMDaoInit {
    void end();

    Database getInitDatabase();

    DaoMaster.DevOpenHelper getOpenHelper();

    void init(long j) throws Exception;
}
