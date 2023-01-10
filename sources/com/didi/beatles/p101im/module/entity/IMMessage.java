package com.didi.beatles.p101im.module.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.beatles.p101im.api.entity.IMMessageDownExtend;
import com.didi.beatles.p101im.api.entity.IMPushBtnBody;
import com.didi.beatles.p101im.p102db.entity.IMMessageDaoEntity;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.google.gson.Gson;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.entity.IMMessage */
public class IMMessage implements Parcelable {
    public static final Parcelable.Creator<IMMessage> CREATOR = new Parcelable.Creator<IMMessage>() {
        public IMMessage createFromParcel(Parcel parcel) {
            return new IMMessage(parcel);
        }

        public IMMessage[] newArray(int i) {
            return new IMMessage[i];
        }
    };
    public static final int DOWNLOADED = 200;
    public static final int DOWNLOADING = 100;
    public static final int DOWNLOAD_FAILED = 300;
    public static final int SENDING = 100;
    public static final int SEND_BANED_SENDER = 500;
    public static final int SEND_DRAFT = 400;
    public static final int SEND_FAILED = 300;
    public static final int SEND_SUCCESS = 200;

    /* renamed from: a */
    private static final String f11133a = IMMessage.class.getSimpleName();

    /* renamed from: d */
    private static long f11134d = Long.MAX_VALUE;
    public String actionId;

    /* renamed from: b */
    private IMMessageDownExtend f11135b;
    public String batcheid;
    public List<IMPushBtnBody> btns;

    /* renamed from: c */
    private IMMessageDaoEntity f11136c;
    public String dmcCardInfo;
    public String emojiDesc;
    public String emojiID;
    public long fakeUid;
    public String floatPushText;
    public String headUrl;
    public boolean isSend;
    public boolean isShowHead;
    public String lastMessage;
    public int linkType;
    public String listText;
    public int mact;
    public long mattr;
    public long msgForUid;
    public String nickName;
    public int notifyType;
    public long oId;
    public Object objContent;
    public int pullScene;
    public String pushContent;
    public String pushText;
    public long routeId;
    public boolean showFailedMsg;
    public int sidType;
    public String topContent;
    public String topText;

    public int describeContents() {
        return 0;
    }

    public IMMessageDownExtend getMessageExtendInfo() {
        try {
            IMMessageDownExtend iMMessageDownExtend = (IMMessageDownExtend) IMJsonUtil.objectFromJson(this.f11136c.getReserveStr3(), IMMessageDownExtend.class);
            if (iMMessageDownExtend == null) {
                return new IMMessageDownExtend(-1, "", 0);
            }
            this.f11135b = iMMessageDownExtend;
            return iMMessageDownExtend;
        } catch (Exception unused) {
            return new IMMessageDownExtend(-1, "", 0);
        }
    }

    public IMMessageDownExtend getParsedMessageExtend() {
        IMMessageDownExtend iMMessageDownExtend = this.f11135b;
        if (iMMessageDownExtend != null) {
            return iMMessageDownExtend;
        }
        m9645a();
        return this.f11135b;
    }

    /* renamed from: a */
    private void m9645a() {
        IMMessageDaoEntity iMMessageDaoEntity = this.f11136c;
        if (iMMessageDaoEntity != null) {
            this.f11135b = (IMMessageDownExtend) IMJsonUtil.objectFromJson(iMMessageDaoEntity.getReserveStr3(), IMMessageDownExtend.class);
        }
    }

    public void setMessageExtendInfo(IMMessageDownExtend iMMessageDownExtend) {
        this.f11136c.setReserveStr3(IMJsonUtil.jsonFromObject(iMMessageDownExtend));
        if (iMMessageDownExtend != null) {
            this.f11135b = iMMessageDownExtend;
        }
    }

    public String getTopText() {
        return this.topText;
    }

    public void setTopText(String str) {
        this.topText = str;
    }

    public String getTopContent() {
        return this.topContent;
    }

    public void setTopContent(String str) {
        this.topContent = str;
    }

    public String getActionId() {
        return this.actionId;
    }

    public void setActionId(String str) {
        this.actionId = str;
    }

    public long getMattr() {
        return this.mattr;
    }

    public void setMattr(long j) {
        this.mattr = j;
    }

    public long getFakeUid() {
        return this.fakeUid;
    }

    public void setFakeUid(long j) {
        this.fakeUid = j;
    }

    public String getHeadUrl() {
        return this.headUrl;
    }

    public void setHeadUrl(String str) {
        this.headUrl = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public long getoId() {
        return this.oId;
    }

    public void setoId(long j) {
        this.oId = j;
    }

    public long getRouteId() {
        return this.routeId;
    }

    public void setRouteId(long j) {
        this.routeId = j;
    }

    public void setCloudUniqueMsgId(String str) {
        this.f11136c.setUnique_cloud_msg_id(str);
    }

    public String getCloudUniqueMsgId() {
        return this.f11136c.getUnique_cloud_msg_id();
    }

    public int getSidType() {
        return this.sidType;
    }

    public void setSidType(int i) {
        this.sidType = i;
    }

    public IMMessage(int i) {
        this.isShowHead = true;
        this.pullScene = 0;
        this.notifyType = -1;
        this.f11136c = new IMMessageDaoEntity();
        setType(i);
    }

    public IMMessage(IMMessageDaoEntity iMMessageDaoEntity) {
        this.isShowHead = true;
        this.pullScene = 0;
        this.notifyType = -1;
        this.f11136c = iMMessageDaoEntity;
    }

    public IMMessageDaoEntity getDaoEntity() {
        return this.f11136c;
    }

    public long getId() {
        Long id = this.f11136c.getId();
        if (id == null) {
            return 0;
        }
        return id.longValue();
    }

    public long getMid() {
        return this.f11136c.getMessage_id();
    }

    public void setUniqueId(long j, long j2) {
        this.f11136c.setMessage_id(j2);
        this.f11136c.setUnique_id(((j << 32) + j2) & f11134d);
    }

    public long getUniqueId() {
        return this.f11136c.getUnique_id();
    }

    public void setSenderUid(long j) {
        this.f11136c.setSend_uid(j);
    }

    public long getSenderUid() {
        return this.f11136c.getSend_uid();
    }

    public int getBusinessId() {
        return this.f11136c.getBusiness_id();
    }

    public void setBusinessId(int i) {
        this.f11136c.setBusiness_id(i);
    }

    public long getSid() {
        return this.f11136c.getSession_id();
    }

    public void setSid(long j) {
        this.f11136c.setSession_id(j);
    }

    public int getType() {
        return this.f11136c.getType();
    }

    public void setType(int i) {
        this.f11136c.setType(i);
    }

    public int getCategory() {
        return this.f11136c.getCategory();
    }

    public void setCategory(int i) {
        this.f11136c.setCategory(i);
    }

    public long getCreateTime() {
        return this.f11136c.getCreate_time();
    }

    public void setCreateTime(long j) {
        this.f11136c.setCreate_time(j);
    }

    public int getStatus() {
        return this.f11136c.getStatus();
    }

    public void setStatus(int i) {
        this.f11136c.setStatus(i);
    }

    public String getContent() {
        return this.f11136c.getText_content();
    }

    public void setContent(Object obj) {
        if (obj instanceof String) {
            this.f11136c.setText_content(obj.toString());
            return;
        }
        this.f11136c.setText_content(new Gson().toJson(obj));
    }

    public void setWidth(int i) {
        this.f11136c.setWidth(i);
    }

    public int getWidth() {
        return this.f11136c.getWidth();
    }

    public void setHeight(int i) {
        this.f11136c.setHeight(i);
    }

    public int getHeight() {
        return this.f11136c.getHeight();
    }

    public void setSec(int i) {
        this.f11136c.setSec(i);
    }

    public int getSec() {
        return this.f11136c.getSec();
    }

    public int getSize() {
        return this.f11136c.getSize();
    }

    public void setSize(int i) {
        this.f11136c.setSize(i);
    }

    public String getFile_name() {
        return this.f11136c.getFile_name();
    }

    public void setFile_name(String str) {
        this.f11136c.setFile_name(str);
    }

    public void setNs(String str) {
        this.f11136c.setGift_ns(str);
    }

    public String getNs() {
        return this.f11136c.getGift_ns();
    }

    public String getFtoken() {
        return this.f11136c.getGift_ftoken();
    }

    public void setFtoken(String str) {
        this.f11136c.setGift_ftoken(str);
    }

    public String getFid() {
        return this.f11136c.getGift_fid();
    }

    public void setFid(String str) {
        this.f11136c.setGift_fid(str);
    }

    public boolean isSend() {
        return this.isSend;
    }

    public void setIsSend(boolean z) {
        this.isSend = z;
    }

    public boolean isRead() {
        if (this.f11136c.getIsRead() == null) {
            return false;
        }
        return this.f11136c.getIsRead().booleanValue();
    }

    public void setIsRead(boolean z) {
        this.f11136c.setIsRead(Boolean.valueOf(z));
    }

    public String getPushText() {
        return this.pushText;
    }

    public void setPushText(String str) {
        this.pushText = str;
    }

    public String getPushContent() {
        return this.pushContent;
    }

    public void setPushContent(String str) {
        this.pushContent = str;
    }

    public long getActivityId() {
        return getMessageExtendInfo().activity_id;
    }

    public String getMsgUniqueId() {
        return getMessageExtendInfo().msg_unique_id;
    }

    public boolean isSupportReadStatus() {
        return getType() == 65536 || getType() == 327680 || getType() == 10486017 || getType() == 131072 || getType() == 65537 || getType() == 196608 || getType() == 458752;
    }

    public boolean isMarkReadAsShown() {
        return getType() == 65536 || getType() == 327680 || getType() == 10486017 || getType() == 65537 || getType() == 196608 || getType() == 458752;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isSend ? (byte) 1 : 0);
        parcel.writeByte(this.isShowHead ? (byte) 1 : 0);
        parcel.writeInt(this.sidType);
        parcel.writeLong(this.oId);
        parcel.writeLong(this.routeId);
        parcel.writeString(this.nickName);
        parcel.writeString(this.headUrl);
        parcel.writeString(this.lastMessage);
        parcel.writeString(this.listText);
        parcel.writeString(this.topText);
        parcel.writeLong(this.fakeUid);
        parcel.writeLong(this.mattr);
        parcel.writeString(this.actionId);
        parcel.writeParcelable(this.f11136c, i);
        parcel.writeInt(this.mact);
        parcel.writeString(this.batcheid);
        parcel.writeLong(this.msgForUid);
        parcel.writeInt(this.notifyType);
    }

    protected IMMessage(Parcel parcel) {
        boolean z = true;
        this.isShowHead = true;
        this.pullScene = 0;
        this.notifyType = -1;
        this.isSend = parcel.readByte() != 0;
        this.isShowHead = parcel.readByte() == 0 ? false : z;
        this.sidType = parcel.readInt();
        this.oId = parcel.readLong();
        this.routeId = parcel.readLong();
        this.nickName = parcel.readString();
        this.headUrl = parcel.readString();
        this.lastMessage = parcel.readString();
        this.listText = parcel.readString();
        this.topText = parcel.readString();
        this.fakeUid = parcel.readLong();
        this.mattr = parcel.readLong();
        this.actionId = parcel.readString();
        this.f11136c = (IMMessageDaoEntity) parcel.readParcelable(IMMessageDaoEntity.class.getClassLoader());
        this.mact = parcel.readInt();
        this.batcheid = parcel.readString();
        this.msgForUid = parcel.readLong();
        this.notifyType = parcel.readInt();
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMMessage) && getUniqueId() == ((IMMessage) obj).getUniqueId();
    }
}
