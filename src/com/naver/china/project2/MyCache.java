package com.naver.china.project2;

import java.util.HashMap;

/**
 * @ClassName MyCache -- 简单版实现LRU算法
 * @Description 使用链表及hashMap的结构方式进行处理，没有使用继承LinkedHashMap
 * @Author XuLei
 * @Date 2020/04/13 20:53
 * @Version 1.0
 */
public class MyCache<K,V> {

    private final int MAX_CACHE_SIZE;
    private Entry first;
    private Entry last;

    // 目前暂时不考虑线程安全
    private HashMap<K, Entry<K, V>> hashMap;

    /**
     *@description 初始化缓存大小
     *@return : null
     *@author XuLei
     **/
    public MyCache(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<K, Entry<K, V>>();
    }

    /**
     *@description 获取缓存
     *@param key
     *@param value
     *@return : void
     *@author XuLei
     **/
    public void put(K key, V value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            if (hashMap.size() >= MAX_CACHE_SIZE) {
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key, entry);
    }

    /**
     *@description GET操作
     *@param key
     *@return : V
     *@author XuLei
     **/
    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) return null;
        moveToFirst(entry);
        return entry.value;
    }

    /**
     *@description 清除缓存
     *@param key
     *@return : void
     *@author XuLei
     **/
    public void remove(K key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            if (entry.pre != null) entry.pre.next = entry.next;
            if (entry.next != null) entry.next.pre = entry.pre;
            if (entry == first) first = entry.next;
            if (entry == last) last = entry.pre;
        }
        hashMap.remove(key);
    }

    private void moveToFirst(Entry entry) {
        if (entry == first) return;
        if (entry.pre != null) entry.pre.next = entry.next;
        if (entry.next != null) entry.next.pre = entry.pre;
        if (entry == last) last = last.pre;

        if (first == null || last == null) {
            first = last = entry;
            return;
        }

        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) first = null;
            else last.next = null;
        }
    }


    private Entry<K, V> getEntry(K key) {
        return hashMap.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry entry = first;
        while (entry != null) {
            sb.append(String.format("%s:%s ", entry.key, entry.value));
            entry = entry.next;
        }
        return sb.toString();
    }
    /**
     *@description 临时内部类存储 数据关系，K,V及当前元素（Entry）,来做的相关的最少使用算法-LRU
     *@author XuLei
     **/
    class Entry<K, V> {
        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }
}
