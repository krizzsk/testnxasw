package com.didi.sdk.messagecenter.p153pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.MsgType */
public enum MsgType implements ProtoEnum {
    kMsgTypeMin(0),
    kMsgTypeAppTypeMin(256),
    kMsgTypeConnSvrConnectChallenge(257),
    kMsgTypeAppHeartbeatReq(259),
    kMsgTypeAppHeartbeatRsp(260),
    kMsgTypeCdntSvrDownReq(261),
    kMsgTypeCdntSvrDownRsp(262),
    kMsgTypeAppPushMessageReq(263),
    kMsgTypeAppPushMessageRsp(264),
    kMsgTypeAppSynchronizeReq(265),
    kMsgTypeAppTypeMax(511),
    kMsgTypeConnSvrTypeMin(512),
    kMsgTypeConnSvrConnectReq(513),
    kMsgTypeConnSvrConnectRsp(514),
    kMsgTypeConnSvrDisconnectReq(515),
    kMsgTypeConnSvrDisconnectRsp(516),
    kMsgTypeConnSvrGetOnlineReq(517),
    kMsgTypeConnSvrGetOnlineRsp(518),
    kMsgTypeConnSvrGetOnlineCountReq(519),
    kMsgTypeConnSvrGetOnlineCountRsp(520),
    kMsgTypeConnSvrHeartbeatReq(521),
    kMsgTypeConnSvrHeartbeatRsp(522),
    kMsgTypeConnSvrGetIfOnlineReq(523),
    kMsgTypeConnSvrGetIfOnlineRsp(524),
    kMsgTypeConnSvrKickNoRspReq(525),
    kMsgTypeConnSvrTypeMax(767),
    kMsgTypeConnMasterTypeMin(768),
    kMsgTypeConnMasterGetRouteReq(769),
    kMsgTypeConnMasterGetRouteRsp(770),
    kMsgTypeConnMasterSetRouteReq(771),
    kMsgTypeConnMasterSetRouteRsp(772),
    kMsgTypeConnMasterDelRouteReq(773),
    kMsgTypeConnMasterDelRouteRsp(774),
    kMsgTypeConnMasterGetOnlineReq(775),
    kMsgTypeConnMasterGetOnlineRsp(776),
    kMsgTypeConnMasterGetOnlineCountReq(777),
    kMsgTypeConnMasterGetOnlineCountRsp(778),
    kMsgTypeConnMasterGetIfOnlineReq(779),
    kMsgTypeConnMasterGetIfOnlineRsp(780),
    kMsgTypeConnMasterKickReq(781),
    kMsgTypeConnMasterKickRsp(782),
    kMsgTypeConnMasterTypeMax(1023),
    kMsgTypeCdntSvrTypeMin(1024),
    kMsgTypeCdntSvrUpReq(1025),
    kMsgTypeCdntSvrUpRsp(1026),
    kMsgTypeCdntSvrSetRelationReq(1027),
    kMsgTypeCdntSvrSetRelationRsp(1028),
    kMsgTypeCdntSvrDelRelationReq(1029),
    kMsgTypeCdntSvrDelRelationRsp(1030),
    kMsgTypeCdntSvrGetRelationReq(1031),
    kMsgTypeCdntSvrGetRelationRsp(1032),
    kMsgTypeCdntSvrAddRelationReq(1033),
    kMsgTypeCdntSvrAddRelationRsp(1034),
    kMsgTypeCdntSvrTypeMax(1279),
    kMsgTypeAuthSvrTypeMin(1280),
    kMsgTypeAuthSvrAddUserReq(1281),
    kMsgTypeAuthSvrAddUserRsp(1282),
    kMsgTypeAuthSvrDelUserReq(1283),
    kMsgTypeAuthSvrDelUserRsp(1284),
    kMsgTypeAuthSvrLoginReq(1285),
    kMsgTypeAuthSvrLoginRsp(1286),
    kMsgTypeAuthSvrQueryUserReq(1287),
    kMsgTypeAuthSvrQueryUserRsp(1288),
    kMsgTypeAuthSvrSignReq(1289),
    kMsgTypeAuthSvrSignRsp(1290),
    kMsgTypeAuthSvrTypeMax(1535),
    kMsgTypePushSvrTypeMin(1536),
    kMsgTypePushSvrReq(1537),
    kMsgTypePushSvrRsp(1538),
    kMsgTypePushSvrMultiReq(1539),
    kMsgTypePushSvrMultiRsp(1540),
    kMsgTypePushSvrAppRspReq(1541),
    kMsgTypePushSvrRetryReq(1543),
    kMsgTypePushSvrRetryRsp(1544),
    kMsgTypePushStatReq(1545),
    kMsgTypePushStatRsp(1552),
    kMsgTypePushSvrTypeMax(1791),
    kMsgTypeCollectSvrTypeMin(1792),
    kMsgTypeCollectSvrNoRspReq(1793),
    kMsgTypeCollectSvrHeartbeatReq(1795),
    kMsgTypeCollectSvrHeartbeatRsp(1796),
    kMsgTypeCollectSvrTypeMax(2047),
    kMsgTypeDispatchSvrTypeMin(2048),
    kMsgTypeDispatchSvrNoRspReq(2049),
    kMsgTypeDispatchSvrReq(2051),
    kMsgTypeDispatchSvrRsp(2052),
    kMsgTypeDispatchSvrTypeMax(2303),
    kMsgTypeMessageSvrTypeMin(2304),
    kMsgTypeMessageSvrGetSessionsReq(2305),
    kMsgTypeMessageSvrGetSessionsRsp(2306),
    kMsgTypeMessageSvrGetMessagesReq(2307),
    kMsgTypeMessageSvrGetMessagesRsp(2308),
    kMsgTypeMessageSvrSendTextReq(2309),
    kMsgTypeMessageSvrSendTextRsp(2310),
    kMsgTypeMessageSvrNewObjectReq(2311),
    kMsgTypeMessageSvrNewObjectRsp(2312),
    kMsgTypeMessageSvrSendObjectReq(2313),
    kMsgTypeMessageSvrSendObjectRsp(2314),
    kMsgTypeMessageSvrNotification(2315),
    kMsgTypeMessageSvrTypeMax(2559),
    kMsgTypeSessionSvrTypeMin(2560),
    kMsgTypeSessionSvrCreateReq(2561),
    kMsgTypeSessionSvrCreateRsp(2562),
    kMsgTypeSessionSvrFreezeReq(2563),
    kMsgTypeSessionSvrFreezeRsp(2564),
    kMsgTypeSessionSvrGetSessionsReq(2565),
    kMsgTypeSessionSvrGetSessionsRsp(2566),
    kMsgTypeSessionSvrNewMessageReq(2567),
    kMsgTypeSessionSvrNewMessageRsp(2568),
    kMsgTypeSessionSvrGetMessageReq(2569),
    kMsgTypeSessionSvrGetMessageRsp(2570),
    kMsgTypeSessionSvrNewObjectReq(2571),
    kMsgTypeSessionSvrNewObjectRsp(2572),
    kMsgTypeSessionSvrSendObjectReq(2573),
    kMsgTypeSessionSvrSendObjectRsp(2574),
    kMsgTypeSessionSvrCheckObjectReq(2575),
    kMsgTypeSessionSvrCheckObjectRsp(2576),
    kMsgTypeSessionSvrTypeMax(2815),
    kMsgTypeFileSvrTypeMin(2816),
    kMsgTypeFileSvrUploadReq(2817),
    kMsgTypeFileSvrUploadRsp(2818),
    kMsgTypeFileSvrDownloadReq(2819),
    kMsgTypeFileSvrDownloadRsp(2820),
    kMsgTypeFileSvrTypeMax(3071),
    kMsgTypeRepushSvrTypeMin(3072),
    kMsgTypeRepushSvrStageMsgReq(3073),
    kMsgTypeRepushSvrStageMsgRsp(3074),
    kMsgTypeRepushSvrTypeMax(3327),
    kMsgTypeDbSvrTypeMin(3328),
    kMsgTypeDbSvrSqlQueryReq(3329),
    kMsgTypeDbSvrSqlQueryRsp(3330),
    kMsgTypeDbSvrSqlExecReq(3331),
    kMsgTypeDbSvrSqlExecRsp(3332),
    kMsgTypeDbSvrSelectDbReq(3333),
    kMsgTypeDbSvrSelectDbRsp(3334),
    kMsgTypeDbSvrInvalidReqRsp(3336),
    kMsgTypeDbSvrTypeMax(3583);
    
    private final int value;

    private MsgType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
