package com.hotstrip.code.design.chapter18.group;

import com.hotstrip.code.design.chapter18.base.Collection;
import com.hotstrip.code.design.chapter18.base.Iterator;
import jdk.nashorn.internal.ir.IfNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟实现组织的数据结构
 * @author Hotstrip
 */
public class GroupStructure implements Collection<Employee, Link> {
    // 组织 ID，也是一个组织链的头部
    private String groupId;
    // 组织名称
    private String groupName;
    // 雇员列表
    private Map<String, Employee> employeeMap = new ConcurrentHashMap<>();
    // 组织架构关系  ID -> list
    private Map<String, List<Link>> linkMap = new ConcurrentHashMap<>();
    // 反向关系链
    private Map<String, String> invertedMap = new ConcurrentHashMap<>();

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    /**
     * 添加雇员信息
     * @param employee
     * @return
     */
    @Override
    public boolean add(Employee employee) {
        return null != employeeMap.put(employee.getId(), employee);
    }

    /**
     * 删除雇员信息
     * @param employee
     * @return
     */
    @Override
    public boolean remove(Employee employee) {
        return null != employeeMap.remove(employee.getId());
    }

    /**
     * 添加组织架构关系
     * @param key
     * @param link
     * @return
     */
    @Override
    public boolean addLink(String key, Link link) {
        invertedMap.put(link.getToId(), link.getFromId());
        // 判断组织架构关系 map 是否已经存在
        if (linkMap.containsKey(key)) {
            return linkMap.get(key).add(link);
        }
        // 不存在就新增
        List<Link> links = new LinkedList<>();
        links.add(link);
        linkMap.put(key, links);
        return true;
    }

    /**
     * 删除 link
     * @param key
     * @return
     */
    @Override
    public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            HashMap<String, Integer> keyMap = new HashMap<>();
            int totalIndex = 0;
            private String fromId = groupId;
            private String toId = groupId;

            @Override
            public boolean hasNext() {
                return totalIndex < employeeMap.size();
            }

            @Override
            public Employee next() {
                List<Link> links = linkMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                // 同级节点扫描
                if (null == links) {
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }
                // 上级节点扫描
                while (cursorIdx > links.size() - 1) {
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                // 获取节点
                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIndex ++;

                // 返回结果
                return employeeMap.get(link.getToId());
            }

            /**
             * 给每个层级定义宽度，遍历进度
             * @param key
             * @return
             */
            public int getCursorIdx(String key) {
                int idx = 0;
                if (keyMap.containsKey(key)) {
                    idx = keyMap.get(key);
                    keyMap.put(key, ++idx);
                } else {
                    keyMap.put(key, idx);
                }
                return idx;
            }
        };
    }
}
