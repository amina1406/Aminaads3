package com.company;

import java.util.ArrayList;

public class HashMap<K, V> {
    private ArrayList<HashNode<K, V>> bucket;
    private int nBuckets;
    private int size;

    public HashMap() {
        bucket = new ArrayList<>();
        nBuckets = 10;
        size = 0;
        for (int i = 0; i < nBuckets; i++) {
            bucket.add(null);
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % nBuckets;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(bucketIndex);
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }
        if (head == null)
            return null;
        size--;
        if (prev != null)
            prev.next = head.next;
        else
            bucket.set(bucketIndex, head.next);
        return head.value;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucket.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucket.set(bucketIndex, newNode);
        if ((1.0 * size) / nBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucket;
            bucket = new ArrayList<HashNode<K, V>>();
            nBuckets = 2 * nBuckets;
            size = 0;
            for (int i = 0; i < nBuckets; i++) {
                bucket.add(null);
            }
            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }

    }
}
