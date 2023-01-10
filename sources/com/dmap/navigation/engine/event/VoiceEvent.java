package com.dmap.navigation.engine.event;

public final class VoiceEvent extends NaviEvent {

    /* renamed from: a */
    private final String f54527a;

    /* renamed from: b */
    private final String f54528b;

    /* renamed from: c */
    private final int f54529c;

    /* renamed from: d */
    private final int f54530d;

    /* renamed from: e */
    private final int f54531e;

    /* renamed from: f */
    private final int f54532f;

    /* renamed from: g */
    private final int f54533g;

    /* renamed from: h */
    private final int f54534h;

    /* renamed from: i */
    private final int f54535i;

    public VoiceEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f54527a = str;
        this.f54528b = str2;
        this.f54529c = i;
        this.f54530d = i2;
        this.f54531e = i3;
        this.f54532f = i4;
        this.f54533g = i5;
        this.f54534h = i6;
        this.f54535i = i7;
    }

    public final String toString() {
        return "VoiceEvent{eventId='" + this.f54527a + '\'' + ", text='" + this.f54528b + '\'' + ", prefix=" + this.f54529c + ", priority=" + this.f54530d + ", type=" + this.f54531e + ", voiceType=" + this.f54532f + ", subType=" + this.f54533g + ", distanceKind=" + this.f54534h + ", eventIdRaw=" + this.f54535i + '}';
    }

    public final String getEventId() {
        return this.f54527a;
    }

    public final String getText() {
        return this.f54528b;
    }

    public final int getPrefix() {
        return this.f54529c;
    }

    public final int getPriority() {
        return this.f54530d;
    }

    public final int getType() {
        return this.f54531e;
    }

    public final int getVoiceType() {
        return this.f54532f;
    }

    public final int getSubType() {
        return this.f54533g;
    }

    public final int getDistanceKind() {
        return this.f54534h;
    }

    public final int getEventIdRaw() {
        return this.f54535i;
    }
}
