package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname;

import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Lookup {

    /* renamed from: a */
    private String f50338a;

    /* renamed from: b */
    private String f50339b;

    /* renamed from: c */
    private String f50340c = "";

    /* renamed from: a */
    private int m37642a(int i) {
        return i & 15;
    }

    public Lookup(String str, String str2) {
        this.f50338a = str;
        this.f50339b = str2;
    }

    public String getCname() {
        return this.f50340c;
    }

    public void Run() {
        try {
            int length = this.f50338a.length() + 2;
            byte[] a = m37644a(this.f50338a, 5);
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.send(new DatagramPacket(a, a.length, new InetSocketAddress(this.f50339b, 53)));
            DatagramPacket datagramPacket = new DatagramPacket(new byte[100], 100);
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            if (data != null) {
                DNSInput dNSInput = new DNSInput(data);
                dNSInput.jump(2);
                int readU16 = dNSInput.readU16();
                dNSInput.jump(6);
                if (dNSInput.readU16() != 0 && m37642a(readU16) == 0) {
                    int i = length + 12 + 4 + 10;
                    dNSInput.jump(i);
                    int readU162 = dNSInput.readU16();
                    byte[] bArr = new byte[readU162];
                    System.arraycopy(data, i + 2, bArr, 0, readU162);
                    int i2 = readU162 - 2;
                    byte b = bArr[i2];
                    byte b2 = bArr[readU162 - 1];
                    if (b == -64) {
                        dNSInput.jump(b2);
                        int readU8 = dNSInput.readU8();
                        byte[] bArr2 = new byte[(i2 + readU8 + 1)];
                        System.arraycopy(bArr, 0, bArr2, 0, i2);
                        System.arraycopy(data, dNSInput.current() - 1, bArr2, i2, readU8 + 1);
                        m37643a(new String(bArr2));
                    }
                }
            }
        } catch (Exception e) {
            OLog.m37861e("cname : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m37643a(String str) {
        int i;
        char[] charArray = str.toCharArray();
        String str2 = "";
        int i2 = 0;
        while (i2 < charArray.length) {
            int i3 = i2 + 1;
            char c = charArray[i2];
            int i4 = i3;
            while (true) {
                i = c + i3;
                if (i4 >= i) {
                    break;
                }
                str2 = str2 + charArray[i4];
                i4++;
            }
            if (i != charArray.length) {
                str2 = str2 + ".";
            }
            i2 = i;
        }
        this.f50340c = str2;
    }

    /* renamed from: a */
    private byte[] m37644a(String str, short s) {
        C16553a aVar = new C16553a();
        aVar.mo124356a(6);
        aVar.mo124356a(7);
        aVar.mo124357a(0, 1);
        aVar.mo124357a(1, 0);
        aVar.mo124357a(2, 0);
        aVar.mo124357a(3, 0);
        QUESTION question = new QUESTION(s, 1);
        byte[] bytes = m37646b(str).getBytes();
        return m37645a(aVar.mo124358a(), bytes, question.toByteArray());
    }

    /* renamed from: a */
    private static byte[] m37645a(byte[]... bArr) {
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (byte[] bArr3 : bArr) {
            System.arraycopy(bArr3, 0, bArr2, i2, bArr3.length);
            i2 += bArr3.length;
        }
        return bArr2;
    }

    /* renamed from: b */
    private String m37646b(String str) {
        char[] cArr = new char[(str.length() + 2)];
        char[] charArray = (str + ".").toCharArray();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (charArray[i3] == '.') {
                cArr[i] = (char) (i3 - i2);
                i++;
                while (i2 < i3) {
                    cArr[i] = charArray[i2];
                    i2++;
                    i++;
                }
                i2++;
            }
        }
        cArr[i] = 0;
        return String.valueOf(cArr);
    }
}
