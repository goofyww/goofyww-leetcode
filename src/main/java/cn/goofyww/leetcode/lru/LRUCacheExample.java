package cn.goofyww.leetcode.lru;

import java.util.Map;

/**
 * LRU缓存 使用实例
 */
public class LRUCacheExample {

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache();
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(2);
        lruCache.put(3, 3);
        lruCache.put(12, 12);

        Map<Integer, LRUCache.DLinkedNode> cacheMap = lruCache.getCacheMap();
        cacheMap.forEach((k, v) -> {
            System.out.printf("k:%d\tv:%d\n", k, v.value);
        });
    }

}
