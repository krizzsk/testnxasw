package com.didi.map.global.flow.scene.order.confirm.normal.line;

import com.didi.map.global.flow.scene.order.confirm.normal.LineMode;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.sdk.address.address.entity.Address;

public class BubbleLineParam {

    /* renamed from: a */
    private CommonLineParam f29186a;

    /* renamed from: b */
    private Address f29187b;

    /* renamed from: c */
    private Address f29188c;

    /* renamed from: d */
    private LineMode f29189d;

    /* renamed from: e */
    private String f29190e;

    /* renamed from: f */
    private int f29191f;

    public BubbleLineParam(CommonLineParam commonLineParam, Address address, Address address2, LineMode lineMode, String str, int i) {
        this.f29186a = commonLineParam;
        this.f29187b = address;
        this.f29188c = address2;
        this.f29189d = lineMode;
        this.f29190e = str;
        this.f29191f = i;
    }

    public CommonLineParam getCommonLineParam() {
        return this.f29186a;
    }

    public Address getStartAddress() {
        return this.f29187b;
    }

    public Address getEndAddress() {
        return this.f29188c;
    }

    public LineMode getLineMode() {
        return this.f29189d;
    }

    public String getBubbleId() {
        return this.f29190e;
    }

    public int getBizGroup() {
        return this.f29191f;
    }

    public String toString() {
        return "BubbleLineParam{commonLineParam=" + this.f29186a + ", startAddress=" + this.f29187b + ", endAddress=" + this.f29188c + ", lineMode=" + this.f29189d + ", bubbleId='" + this.f29190e + '\'' + ", bizGroup=" + this.f29191f + '}';
    }
}
