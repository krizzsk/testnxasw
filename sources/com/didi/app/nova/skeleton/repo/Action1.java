package com.didi.app.nova.skeleton.repo;

public interface Action1<T> extends Action<T> {
    void call(T t);
}
