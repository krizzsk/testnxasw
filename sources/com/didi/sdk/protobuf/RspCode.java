package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum RspCode implements ProtoEnum {
    kRspCodeConnSvrMin(1),
    kRspCodeConnSvrTimedOut(2),
    kRspCodeConnSvrInternalError(3),
    kRspCodeConnSvrMax(99),
    kRspCodeCdntSvrMin(201),
    kRspCodeCdntSvrNotExist(202),
    kRspCodeCdntSvrAccessCkvError(203),
    kRspCodeCdntSvrArgsError(204),
    kRspCodeCdntSvrMax(299),
    kRspCodeConnMasterMin(401),
    kRspCodeConnMasterKeyNotExist(402),
    kRspCodeConnMasterTimedOut(403),
    kRspCodeConnMasterAccessCkvTimedOut(404),
    kRspCodeConnMasterPbDecodeError(405),
    kRspCodeConnMasterCkvDecodeFailed(406),
    kRspCodeConnMasterCkvCasNewer(407),
    kRspCodeConnMasterKeyExistWhenAdd(408),
    kRspCodeConnMasterIfOnlineOutRange(409),
    kRspCodeConnMasterMax(499),
    kRspCodeAuthSvrMin(601),
    kRspCodeAuthSvrKeyNotExist(602),
    kRspCodeAuthSvrParamError(603),
    kRspCodeAuthSvrDelTokenError(604),
    kRspCodeAuthSvrAddTokenError(605),
    kRspCodeAuthSvrLoginError(606),
    kRspCodeAuthSvrGetUserIdError(607),
    kRspCodeAuthSvrDecodeError(608),
    kRspCodeAuthSvrHmacEncodeError(609),
    kRspCodeAuthSvrBase64EncodeError(610),
    kRspCodeAuthSvrTimedOut(611),
    kRspCodeAuthSvrInnerError(612),
    kRspCodeAuthSvrDBError(613),
    kRspCodeAuthSvrMax(699),
    kRspCodePushSvrMin(1536),
    kRspCodePushSvrInternalError(1537),
    kRspCodePushSvrMsgStaged(1538),
    kRspCodePushSvrInvalidArgs(1539),
    kRspCodePushSvrKeyNotExist(1540),
    kRspCodePushSvrSmsMsgSend(1541),
    kRspCodePushSvrMax(1791),
    kRspCodeMessageSvrMin(2304),
    kRspCodeMessageSvrTimeOut(2305),
    kRspCodeMessageSvrInvalidArgs(2306),
    kRspCodeMessageSvrCkvError(2307),
    kRspCodeMessageSvrGetServerError(2308),
    kRspCodeMessageSvrToPushError(2309),
    kRspCodeMessageSvrToSessionError(2310),
    kRspCodeMessageSvrSessionInvalidArgs(2311),
    kRspCodeMessageSvrDecodeError(2312),
    kRspCodeMessageSvrMax(2559),
    kRspCodeSessionSvrMin(2560),
    kRspCodeSessionSvrTryAgain(2561),
    kRspCodeSessionSvrInvalidArguments(2562),
    kRspCodeSessionSvrNoSuchSession(2563),
    kRspCodeSessionSvrFrozen(2564),
    kRspCodeSessionSvrForbidden(2565),
    kRspCodeSessionSvrVanished(2566),
    kRspCodeSessionSvrMax(2815),
    kRspCodeFileSvrMin(2816),
    kRspCodeFileSvrTimedOut(2817),
    kRspCodeFileSvrStateError(2818),
    kRspCodeFileSvrNoSessionServer(2819),
    kRspCodeFileSvrVerificationError(2820),
    kRspCodeFileSvrNoCkvServer(2821),
    kRspCodeFileSvrCkvSetError(2822),
    kRspCodeFileSvrKeyNotExist(2823),
    kRspCodeFileSvrSessionNotReturnToken(2824),
    kRspCodeFileSvrKeyHasExist(2825),
    kRspCodeFileSvrCkvDecodeFailed(2826),
    kRspCodeFileSvrMax(3071),
    kRspCodeRepushSvrMin(3072),
    kRspCodeRepushSvrInvalidArgs(3073),
    kRspCodeRepushSvrKeyNotExist(3074),
    kRspCodeRepushSvrTimedOut(3075),
    kRspCodeRepushSvrMax(3327),
    kRspCodeTransInvalidArgs(3841),
    kRspCodeTransUnknownAPI(3842),
    kRspCodeTransSigFail(3843),
    kRspCodeTransMax(4095);
    
    private final int value;

    private RspCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
