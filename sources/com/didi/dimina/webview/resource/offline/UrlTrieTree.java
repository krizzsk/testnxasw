package com.didi.dimina.webview.resource.offline;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class UrlTrieTree {

    /* renamed from: b */
    private static final Object f20266b = new Object();

    /* renamed from: a */
    private final TrieNode f20267a;

    private class TrieNode {
        public ArrayList<TrieNode> children;
        /* access modifiers changed from: private */
        public String localPath;
        /* access modifiers changed from: private */
        public OfflineBundleInfo offlineBundleInfo;
        public String trieNode;

        private TrieNode() {
        }
    }

    public UrlTrieTree() {
        TrieNode trieNode = new TrieNode();
        this.f20267a = trieNode;
        trieNode.trieNode = "root";
        this.f20267a.children = new ArrayList<>();
    }

    /* renamed from: a */
    private Queue<String> m17090a(String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        List<String> pathSegments = parse.getPathSegments();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.add(scheme);
        linkedBlockingDeque.add(host);
        for (String add : pathSegments) {
            linkedBlockingDeque.add(add);
        }
        return linkedBlockingDeque;
    }

    /* renamed from: a */
    private TrieNode m17089a(TrieNode trieNode, String str) {
        if (trieNode.trieNode.equals(str)) {
            return trieNode;
        }
        Iterator<TrieNode> it = trieNode.children.iterator();
        while (it.hasNext()) {
            TrieNode next = it.next();
            if (next.trieNode.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void addNode(String str, String str2) {
        synchronized (f20266b) {
            TrieNode trieNode = this.f20267a;
            Queue<String> a = m17090a(str);
            do {
                String poll = a.poll();
                TrieNode a2 = m17089a(trieNode, poll);
                if (a2 == null) {
                    a2 = new TrieNode();
                    a2.trieNode = poll;
                    if (a.size() != 0) {
                        a2.children = new ArrayList<>();
                    } else {
                        String unused = a2.localPath = str2;
                    }
                    trieNode.children.add(a2);
                }
                trieNode = a2;
            } while (a.size() > 0);
        }
    }

    public void addNode(String str, OfflineBundleInfo offlineBundleInfo) {
        synchronized (f20266b) {
            TrieNode trieNode = this.f20267a;
            Queue<String> a = m17090a(str);
            do {
                String poll = a.poll();
                TrieNode a2 = m17089a(trieNode, poll);
                if (a2 == null) {
                    a2 = new TrieNode();
                    a2.trieNode = poll;
                    if (a.size() != 0) {
                        a2.children = new ArrayList<>();
                    } else {
                        OfflineBundleInfo unused = a2.offlineBundleInfo = offlineBundleInfo;
                    }
                    trieNode.children.add(a2);
                }
                trieNode = a2;
            } while (a.size() > 0);
        }
    }

    public String searchUrl(String str) {
        synchronized (f20266b) {
            Queue<String> a = m17090a(str);
            TrieNode trieNode = this.f20267a;
            do {
                String peek = a.peek();
                int size = a.size();
                Iterator<TrieNode> it = trieNode.children.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TrieNode next = it.next();
                    if (next.trieNode.equals(peek)) {
                        a.poll();
                        trieNode = next;
                        break;
                    }
                }
                if (size == a.size()) {
                    return null;
                }
            } while (a.size() > 0);
            String access$100 = trieNode.localPath;
            return access$100;
        }
    }

    public OfflineBundleInfo searchUrlEx(String str) {
        synchronized (f20266b) {
            Queue<String> a = m17090a(str);
            TrieNode trieNode = this.f20267a;
            do {
                String peek = a.peek();
                int size = a.size();
                Iterator<TrieNode> it = trieNode.children.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TrieNode next = it.next();
                    if (next.trieNode.equals(peek)) {
                        a.poll();
                        trieNode = next;
                        break;
                    }
                }
                if (size == a.size()) {
                    return null;
                }
                if (!trieNode.trieNode.equalsIgnoreCase("root") && trieNode.children == null) {
                    OfflineBundleInfo access$200 = trieNode.offlineBundleInfo;
                    return access$200;
                }
            } while (a.size() > 0);
            OfflineBundleInfo access$2002 = trieNode.offlineBundleInfo;
            return access$2002;
        }
    }
}
