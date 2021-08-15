package cn.goofyww.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 最近最久未使用淘汰算法（LRU算法）
 * Least Recently Used
 * 可以将Cache中的数据组织成任意数据结构（包括 数组/链表），其最大容量为N
 * 时间复杂度不限
 */
public class LRUCache {

    private DLinkedNode head;
    private DLinkedNode tail;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 2;

    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    public Map<Integer, DLinkedNode> getCacheMap() {
        return cache;
    }

    public LRUCache() {
        construct(DEFAULT_CAPACITY);
    }

    public LRUCache(int capacity) {
        construct(capacity);
    }

    private void construct(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 添加节点到链表头部（头节点的后一个节点）
     */
    private void addToHead(DLinkedNode node) {
        // 将头节点给新加节点的前指针
        node.prev = head;
        // 将尾节点给新加节点的后指针
        node.next = head.next;

        // 将新加节点给原本第二节点的前指针
        head.next.prev = node;
        // 将新加节点给头节点的后指针
        head.next = node;
    }

    /**
     * 删除节点
     */
    private void removeNode(DLinkedNode node) {
        // 将要删除的节点从双向链表中排除
        // 方式：变化指针所指向的内存地址
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 删除节点，并移动节点到链表头部
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除尾部节点
     */
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    /**
     * 创建结点类
     */
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
