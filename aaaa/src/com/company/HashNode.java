package com.company;

public class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

    public HashNode(K keys, V values) {
        this.key = keys;
        this.value = values;
    }
}
