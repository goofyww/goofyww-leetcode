package cn.goofyww.leetcode.findchilddept;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 查找子部门
 *
 * 问题描述：给出一组部门列表，部门之间通过 pid 作为 上下级的依赖关系，比如，pid 为 1的集合元素，全部都是归属于 id 为1 的子部分，
 * 现在写一个方法，指定一个部门id，返回该部门（包含自身）所有的子部门以及以下所有部门的列表，
 * eg1: 输入 2 ，main方法中的list集合，
 *      输出 包含如下的集合列表
 *          2 - 1
 *          5 - 2
 *          6 - 2
 *          7 - 2
 *          14 - 5
 *          15 - 5
 *          16 - 5
 *
 * eg2: 输入 3 ，main方法中的list集合，
 *      输出 包含如下的集合列表
 *          3 - 1
 *          8 - 3
 *          9 - 3
 *          10 - 3
 *          17 - 9
 *          18 - 9
 *          19 - 9
 *          20 - 18
 *          21 - 18
 *          22 - 18
 */
public class FindChildDept {

    public static void main(String[] args) {

        List<Dept> deptList = new ArrayList<>();
        deptList.add(new Dept(1, 0));

        deptList.add(new Dept(2, 1));
        deptList.add(new Dept(3, 1));
        deptList.add(new Dept(4, 1));

        deptList.add(new Dept(5, 2));
        deptList.add(new Dept(6, 2));
        deptList.add(new Dept(7, 2));

        deptList.add(new Dept(8, 3));
        deptList.add(new Dept(9, 3));
        deptList.add(new Dept(10, 3));

        deptList.add(new Dept(11, 4));
        deptList.add(new Dept(12, 4));
        deptList.add(new Dept(13, 4));

        deptList.add(new Dept(14, 5));
        deptList.add(new Dept(15, 5));
        deptList.add(new Dept(16, 5));

        deptList.add(new Dept(17, 9));
        deptList.add(new Dept(18, 9));
        deptList.add(new Dept(19, 9));

        deptList.add(new Dept(20, 18));
        deptList.add(new Dept(21, 18));
        deptList.add(new Dept(22, 18));

        getDeptListByVal(3, deptList).forEach(dept -> System.out.println(dept.toString()));

    }

    public static List<Dept> getDeptListByVal(int id, List<Dept> deptAll) {

        if (deptAll.isEmpty()){
            return deptAll;
        }

        if (id == 0){
            return deptAll;
        }

        // 判断要查询的部门是否是一级部门，如果是一级部门（pid==0，表示没有父部门），直接返回完整列表
        for (Dept dept : deptAll) {
            if (dept.getPid() == 0) {
                return deptAll;
            }
        }

        // 如果不是一级部门，则进行遍历查找
        List<Dept> deptTar = new ArrayList<>();
        deptTar = getDeptListByVal(id, deptAll, deptTar);
        return deptTar;
    }

    public static List<Dept> getDeptListByVal(int id, List<Dept> deptAll, List<Dept> deptTar) {

        for (int i = 0; i < deptAll.size(); i++) {
            Dept dept = deptAll.get(i);

            // 如果需要的 部门id 与当前遍历的 部门id 相同则 加入到 结果集合中，同时对原始部门集合进行瘦身
            if (id == dept.getId()) {
                deptTar.add(dept);

                // 同时对原始部门集合进行瘦身，一可以 防止重复加入，二可以 减少集合遍历的时间复杂度
                deptAll.remove(i);
                i--;

                // 跳过本次循环
                continue;
            }

            // 如果要查找的部门id 是当前遍历部门的父部门，，
            if (id == dept.getPid()) {
                // 加入到 结果集合中
                deptTar.add(dept);
                // 取出当前遍历的部门id，作为递归条件
                int idi = dept.getId();

                // 同时对原始部门集合进行瘦身，一可以 防止重复加入，二可以 减少集合遍历的时间复杂度
                deptAll.remove(i);
                i--;

                // 递归查找部门子部分
                deptTar = getDeptListByVal(idi, deptAll, deptTar);
            }
        }
        return deptTar;
    }

}

/**
 * 部门
 */
class Dept {

    private int id; // 当前部门id

    private int pid; // 父部门id

    private String name;

    public Dept() {
    }

    public Dept(int id, int pid) {
        this.id = id;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return id == dept.id &&
                pid == dept.pid &&
                Objects.equals(name, dept.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, name);
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }

}
