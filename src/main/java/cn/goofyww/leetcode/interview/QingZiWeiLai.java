package cn.goofyww.leetcode.interview;

import cn.goofyww.leetcode.linked.Node;

/**
 * TODO 青子未来
 * 90分钟内，尽可能用最熟悉的语言实现更多的题，题号写在代码之前（至少完成一道，尽量避免用已封装好的现有的类库）
 */
public class QingZiWeiLai {

    /**
     * 1. 有一个数组 ROOT[n] ，数组的元素为Node，
     * 每个Node包含
     * 一个字段 index:用来表示自己所在ROOT位置标号；
     * 一个字段 next :用来表示他引用的下一级Node；
     * next 可能指向一个全新Node，也可能为 selfNode or preNode or OtherRoot 下的 Node，多级级联，
     * 这样整体可能形成一个网。请实现代码删除所有下面的 Node 没有被其他Root下的Node引用的Root节点
     * （可以用 ROOT[n] = null 设置为删除）
     */
    public void a(Node[] nodes) {
    }

    /**
     * 2. 假设有一个函数
     * bool testAndSet(int &value,int target, int before) (不需要自己实现)
     * 可以线程安全的比较 value值 是否为 before，如果是的话就设置为 target,
     * 同时返回 true ,否则不设置值并且返回 false
     * 请基于此函数实现一个长度不超过100的线程安全的 Queue
     * (包含 pop 和 push, 不能使用 synchonized /lock/mutex/atomic 等关键字/类，可以用 volatile)
     */
    public void b() {
    }

    /**
     * 3. 函数A会返回范围在 1-> INT_MAX的单个数字，返回的数字会大致随着调用次数的增加增大，
     * 不会重复返回相同的数字，虽然返回值不断增大，但是两次调用之间的返回值并不严格保证递增的顺序，
     * 会有一定概率变小。比如正常为 1，2，3，4，5，6，7，8，9 这样返回，
     * 但也有可能为 1，2，3，5，7，6，4，8，9 这样返回。
     * 写一个函数B，里面持续接收函数A的返回值，当接收到数字后，严格按顺序打印出未打印过的最小的值
     * 比如收到：1，2，5，6，4，8后，应该打印出 1，2，当后面再收到3后，就打印出 3，4，5，6
     * 然后当再收到7后，就打印出 7，8，总是打印最小的值
     */
    public void c() {
    }

    /**
     * 4. 一个数组，里面全是数字，从左至右的特征是：从小到大，然后从大到小，
     * 数组中可能会出现连续重复的数字。请写一段代码最快的找出数组中最大的数值（可能为 1到多个）
     * 比如数组 [1,3,3,3,4,5,6,7,8,8,8,8,8,9,10,10,11,11,12,23,33,33,10,2,2,2,2,2,1,1]
     */
    public int d(int[] arri) {
        return -1;
    }

    /**
     * 5. 有一个由 0-9 组成的十进制的数字，例如：28373288128383
     * 请写一段代码实现从数字转换成 A-Z a-z 52个字表达的 52 进制的字符串，
     * 其中A到Z 分别表示0到25，a到z 分别表示 26到51
     */
    public void e() {

    }

}
