package com.didiglobal.privacy.domainmonitor.urlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public class MonitorHttpsURLConnection extends HttpsURLConnection {

    /* renamed from: a */
    private final HttpsURLConnection f53081a;

    /* renamed from: b */
    private final MonitorHttpURLConnection f53082b;

    protected MonitorHttpsURLConnection(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        this.f53082b = new MonitorHttpURLConnection(httpsURLConnection);
        this.f53081a = httpsURLConnection;
    }

    public String getCipherSuite() {
        return this.f53081a.getCipherSuite();
    }

    public Certificate[] getLocalCertificates() {
        return this.f53081a.getLocalCertificates();
    }

    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        try {
            return this.f53081a.getServerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            this.f53082b.mo129838a((IOException) e);
            throw e;
        }
    }

    public void disconnect() {
        this.f53082b.disconnect();
    }

    public boolean usingProxy() {
        return this.f53082b.usingProxy();
    }

    public void connect() throws IOException {
        this.f53082b.connect();
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        try {
            return this.f53081a.getPeerPrincipal();
        } catch (SSLPeerUnverifiedException e) {
            this.f53082b.mo129838a((IOException) e);
            throw e;
        }
    }

    public Principal getLocalPrincipal() {
        return this.f53081a.getLocalPrincipal();
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f53081a.setHostnameVerifier(hostnameVerifier);
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f53081a.getHostnameVerifier();
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f53081a.setSSLSocketFactory(sSLSocketFactory);
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.f53081a.getSSLSocketFactory();
    }

    public String getHeaderFieldKey(int i) {
        return this.f53082b.getHeaderFieldKey(i);
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f53082b.setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long j) {
        this.f53082b.setFixedLengthStreamingMode(j);
    }

    public void setChunkedStreamingMode(int i) {
        this.f53082b.setChunkedStreamingMode(i);
    }

    public String getHeaderField(int i) {
        return this.f53082b.getHeaderField(i);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f53082b.setInstanceFollowRedirects(z);
    }

    public boolean getInstanceFollowRedirects() {
        return this.f53082b.getInstanceFollowRedirects();
    }

    public void setRequestMethod(String str) throws ProtocolException {
        this.f53082b.setRequestMethod(str);
    }

    public String getRequestMethod() {
        return this.f53082b.getRequestMethod();
    }

    public int getResponseCode() throws IOException {
        return this.f53082b.getResponseCode();
    }

    public String getResponseMessage() throws IOException {
        return this.f53082b.getResponseMessage();
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.f53082b.getHeaderFieldDate(str, j);
    }

    public Permission getPermission() throws IOException {
        return this.f53082b.getPermission();
    }

    public InputStream getErrorStream() {
        return this.f53082b.getErrorStream();
    }

    public void setConnectTimeout(int i) {
        this.f53082b.setConnectTimeout(i);
    }

    public int getConnectTimeout() {
        return this.f53082b.getConnectTimeout();
    }

    public void setReadTimeout(int i) {
        this.f53082b.setReadTimeout(i);
    }

    public int getReadTimeout() {
        return this.f53082b.getReadTimeout();
    }

    public URL getURL() {
        return this.f53082b.getURL();
    }

    public int getContentLength() {
        return this.f53082b.getContentLength();
    }

    public long getContentLengthLong() {
        return this.f53082b.getContentLengthLong();
    }

    public String getContentType() {
        return this.f53082b.getContentType();
    }

    public String getContentEncoding() {
        return this.f53082b.getContentEncoding();
    }

    public long getExpiration() {
        return this.f53082b.getExpiration();
    }

    public long getDate() {
        return this.f53082b.getDate();
    }

    public long getLastModified() {
        return this.f53082b.getLastModified();
    }

    public String getHeaderField(String str) {
        return this.f53082b.getHeaderField(str);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.f53082b.getHeaderFields();
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.f53082b.getHeaderFieldInt(str, i);
    }

    public long getHeaderFieldLong(String str, long j) {
        return this.f53082b.getHeaderFieldLong(str, j);
    }

    public Object getContent() throws IOException {
        return this.f53082b.getContent();
    }

    public Object getContent(Class[] clsArr) throws IOException {
        return this.f53082b.getContent(clsArr);
    }

    public InputStream getInputStream() throws IOException {
        return this.f53082b.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f53082b.getOutputStream();
    }

    public String toString() {
        return this.f53082b.toString();
    }

    public void setDoInput(boolean z) {
        this.f53082b.setDoInput(z);
    }

    public boolean getDoInput() {
        return this.f53082b.getDoInput();
    }

    public void setDoOutput(boolean z) {
        this.f53082b.setDoOutput(z);
    }

    public boolean getDoOutput() {
        return this.f53082b.getDoOutput();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f53082b.setAllowUserInteraction(z);
    }

    public boolean getAllowUserInteraction() {
        return this.f53082b.getAllowUserInteraction();
    }

    public void setUseCaches(boolean z) {
        this.f53082b.setUseCaches(z);
    }

    public boolean getUseCaches() {
        return this.f53082b.getUseCaches();
    }

    public void setIfModifiedSince(long j) {
        this.f53082b.setIfModifiedSince(j);
    }

    public long getIfModifiedSince() {
        return this.f53082b.getIfModifiedSince();
    }

    public boolean getDefaultUseCaches() {
        return this.f53082b.getDefaultUseCaches();
    }

    public void setDefaultUseCaches(boolean z) {
        this.f53082b.setDefaultUseCaches(z);
    }

    public void setRequestProperty(String str, String str2) {
        this.f53082b.setRequestProperty(str, str2);
    }

    public void addRequestProperty(String str, String str2) {
        this.f53082b.addRequestProperty(str, str2);
    }

    public String getRequestProperty(String str) {
        return this.f53082b.getRequestProperty(str);
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f53082b.getRequestProperties();
    }

    public int hashCode() {
        return this.f53082b.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f53082b.equals(obj);
    }
}
