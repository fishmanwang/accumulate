package com.accumulate.dto;

/**
 * Created by tjwang on 2016/10/9.
 */
public class KeyValue<K, V> extends BaseDTO {
    private K k;
    private V v;

    public KeyValue() {
    }

    public KeyValue(K k, V v) {
        setK(k);
        setV(v);
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
