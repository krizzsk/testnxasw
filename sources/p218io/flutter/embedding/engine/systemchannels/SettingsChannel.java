package p218io.flutter.embedding.engine.systemchannels;

import java.util.HashMap;
import java.util.Map;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.plugin.common.BasicMessageChannel;
import p218io.flutter.plugin.common.JSONMessageCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.SettingsChannel */
public class SettingsChannel {
    public static final String CHANNEL_NAME = "flutter/settings";

    /* renamed from: a */
    private static final String f60503a = "SettingsChannel";

    /* renamed from: b */
    private static final String f60504b = "textScaleFactor";

    /* renamed from: c */
    private static final String f60505c = "alwaysUse24HourFormat";

    /* renamed from: d */
    private static final String f60506d = "platformBrightness";
    public final BasicMessageChannel<Object> channel;

    public SettingsChannel(DartExecutor dartExecutor) {
        this.channel = new BasicMessageChannel<>(dartExecutor, CHANNEL_NAME, JSONMessageCodec.INSTANCE);
    }

    public MessageBuilder startMessage() {
        return new MessageBuilder(this.channel);
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder */
    public static class MessageBuilder {
        private final BasicMessageChannel<Object> channel;
        private Map<String, Object> message = new HashMap();

        MessageBuilder(BasicMessageChannel<Object> basicMessageChannel) {
            this.channel = basicMessageChannel;
        }

        public MessageBuilder setTextScaleFactor(float f) {
            this.message.put(SettingsChannel.f60504b, Float.valueOf(f));
            return this;
        }

        public MessageBuilder setUse24HourFormat(boolean z) {
            this.message.put(SettingsChannel.f60505c, Boolean.valueOf(z));
            return this;
        }

        public MessageBuilder setPlatformBrightness(PlatformBrightness platformBrightness) {
            this.message.put(SettingsChannel.f60506d, platformBrightness.name);
            return this;
        }

        public void send() {
            Log.m45259v(SettingsChannel.f60503a, "Sending message: \ntextScaleFactor: " + this.message.get(SettingsChannel.f60504b) + "\nalwaysUse24HourFormat: " + this.message.get(SettingsChannel.f60505c) + "\nplatformBrightness: " + this.message.get(SettingsChannel.f60506d));
            this.channel.send(this.message);
        }
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.SettingsChannel$PlatformBrightness */
    public enum PlatformBrightness {
        light("light"),
        dark("dark");
        
        public String name;

        private PlatformBrightness(String str) {
            this.name = str;
        }
    }
}
