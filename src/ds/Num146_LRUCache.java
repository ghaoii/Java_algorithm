package ds;

import java.util.*;

public class Num146_LRUCache {

}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

// 封装了各种API的
class DoubleLinkedList {
    Node head;// 虚拟头结点

    Node tail;// 虚拟尾结点

    private int size;

    public DoubleLinkedList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // 在链表末尾添加元素
    public void add(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        size++;
    }

    // 删除结点
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = node.next = null;
        size--;
    }

    // 删除链表中最旧的元素(头结点),因为LRU中没法得到链表中第一个元素，只能通过封装好的方法实现
    public void removeFirst() {
        // 如果链表中没有元素，直接返回
        if(head.next == tail) {
            return;
        }
        remove(head.next);
    }

    public int getSize() {
        return size;
    }
}

class LRUCache {

    private int capacity;

    private Map<Integer, Node> map = new HashMap<>();

    private DoubleLinkedList list = new DoubleLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        changeNew(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            changeNew(node);
            return;
        }

        if(list.getSize() == capacity) {
            Node node = list.head.next;
            list.removeFirst();
            map.remove(node.key);
        }
        addNew(key, value);
    }

    private void addNew(int key, int value) {
        Node node = new Node(key, value);
        list.add(node);
        map.put(key, node);
    }

    private void changeNew(Node node) {
        list.remove(node);
        list.add(node);
    }
}

// 自己写的
//class LRUCache {
//    private int capacity;
//
//    private int size;
//
//    private Map<Integer, Node> map;
//
//    private Node head;
//
//    private Node tail;
//
//    public LRUCache(int capacity) {
//        map = new HashMap<>();
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        // 如果不存在key值，则直接返回-1
//        if(!map.containsKey(key)) {
//            return -1;
//        }
//
//        Node node = map.get(key);
//        changeNew(node);// 更新结点的时序
//        return node.value;
//    }
//
//    public void put(int key, int value) {
//        // 如果已经存在key，则修改value，但是需要更新时序，移动到链表尾部
//        if(map.containsKey(key)) {
//            Node node = map.get(key);
//            node.value = value;
//            changeNew(node);
//            return;
//        }
//
//        // 如果缓存空间已满，则删除最旧的元素
//        if(size == capacity) {
//            // 删除map中的元素
//            map.remove(head.key);
//            // 删除链表中的元素
//            remove(head);
//        }else {
//            // 缓存空间未满
//            size++;
//        }
//
//        add(key, value);
//    }
//
//    // 在map和链表的尾部添加新结点
//    private void add(int key, int value) {
//        Node node = new Node(key, value);
//        if(head == null) {
//            head = node;
//        }else {
//            tail.next = node;
//            node.prev = tail;
//        }
//        tail = node;
//        map.put(key, node);
//    }
//
//    // 将结点从链表中删除
//    private void remove(Node node) {
//        if(node == head && node == tail) {
//            head = tail = null;
//        }else if(node == head) {
//            head = node.next;
//            head.prev = null;
//            node.next = null;
//        }else if(node == tail) {
//            tail = node.prev;
//            tail.next = null;
//            node.prev = null;
//        }else {
//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//            node.prev = node.next = null;
//        }
//    }
//
//    // 将node结点移动到链表尾部
//    private void changeNew(Node node) {
//        // 如果本来就在尾部，则不需要变更
//        if(node == tail) {
//            return;
//        }
//        // 删除链表中的结点
//        remove(node);
//        // 添加到链表尾部
//        tail.next = node;
//        node.prev = tail;
//        tail = node;
//    }
//}
