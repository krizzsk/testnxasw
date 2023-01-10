package com.p226hp.hpl.sparta;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* renamed from: com.hp.hpl.sparta.Parser */
public class Parser {
    public static Document parse(String str, Reader reader) throws ParseException, IOException {
        C20727a aVar = new C20727a();
        new C20734h(str, reader, (ParseLog) null, (String) null, (ParseHandler) aVar);
        return aVar.mo171195a();
    }

    public static Document parse(String str, Reader reader, ParseLog parseLog) throws ParseException, IOException {
        C20727a aVar = new C20727a();
        new C20734h(str, reader, parseLog, (String) null, (ParseHandler) aVar);
        return aVar.mo171195a();
    }

    public static Document parse(String str) throws ParseException, IOException {
        return parse(str.toCharArray());
    }

    public static Document parse(char[] cArr) throws ParseException, IOException {
        C20727a aVar = new C20727a();
        new C20734h("file:anonymous-string", cArr, (ParseLog) null, (String) null, (ParseHandler) aVar);
        return aVar.mo171195a();
    }

    public static Document parse(byte[] bArr) throws ParseException, IOException {
        C20727a aVar = new C20727a();
        new C20733g("file:anonymous-string", new ByteArrayInputStream(bArr), (ParseLog) null, (String) null, aVar);
        return aVar.mo171195a();
    }

    public static Document parse(String str, Reader reader, ParseLog parseLog, String str2) throws ParseException, EncodingMismatchException, IOException {
        C20727a aVar = new C20727a();
        new C20734h(str, reader, parseLog, str2, (ParseHandler) aVar);
        return aVar.mo171195a();
    }

    public static Document parse(String str, InputStream inputStream, ParseLog parseLog) throws ParseException, IOException {
        C20727a aVar = new C20727a();
        new C20733g(str, inputStream, parseLog, (String) null, aVar);
        return aVar.mo171195a();
    }

    public static Document parse(String str, InputStream inputStream) throws ParseException, IOException {
        C20727a aVar = new C20727a();
        new C20733g(str, inputStream, (ParseLog) null, (String) null, aVar);
        return aVar.mo171195a();
    }

    public static Document parse(String str, InputStream inputStream, ParseLog parseLog, String str2) throws ParseException, IOException {
        C20727a aVar = new C20727a();
        new C20733g(str, inputStream, parseLog, str2, aVar);
        return aVar.mo171195a();
    }

    public static void parse(String str, Reader reader, ParseHandler parseHandler) throws ParseException, IOException {
        new C20734h(str, reader, (ParseLog) null, (String) null, parseHandler);
    }

    public static void parse(String str, Reader reader, ParseLog parseLog, ParseHandler parseHandler) throws ParseException, IOException {
        new C20734h(str, reader, parseLog, (String) null, parseHandler);
    }

    public static void parse(String str, ParseHandler parseHandler) throws ParseException, IOException {
        parse(str.toCharArray(), parseHandler);
    }

    public static void parse(char[] cArr, ParseHandler parseHandler) throws ParseException, IOException {
        new C20734h("file:anonymous-string", cArr, (ParseLog) null, (String) null, parseHandler);
    }

    public static void parse(byte[] bArr, ParseHandler parseHandler) throws ParseException, IOException {
        new C20733g("file:anonymous-string", new ByteArrayInputStream(bArr), (ParseLog) null, (String) null, parseHandler);
    }

    public static void parse(String str, InputStream inputStream, ParseLog parseLog, ParseHandler parseHandler) throws ParseException, IOException {
        new C20733g(str, inputStream, parseLog, (String) null, parseHandler);
    }

    public static void parse(String str, InputStream inputStream, ParseHandler parseHandler) throws ParseException, IOException {
        new C20733g(str, inputStream, (ParseLog) null, (String) null, parseHandler);
    }

    public static void parse(String str, InputStream inputStream, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        new C20733g(str, inputStream, parseLog, str2, parseHandler);
    }

    public static void parse(String str, Reader reader, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        new C20734h(str, reader, parseLog, str2, parseHandler);
    }
}
