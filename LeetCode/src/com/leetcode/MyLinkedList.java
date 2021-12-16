package com.leetcode;

public class MyLinkedList {
    ListNode headNode;
    int length = 0;

    public MyLinkedList() {

    }

    /**
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= length) return -1;
        ListNode temp = headNode;
        int counter = 0;
        while (counter != index) {
            temp = temp.next;
            counter++;
        }
        return temp.value;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = headNode;
        headNode = node;
        length++;
    }

    public void addAtTail(int val) {
        if (length == 0) {
            headNode = new ListNode(val);
        } else {
            var temp = headNode;
            ListNode lastNode = null;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) return;
        if (index == 0) {
            addAtHead(val);
        } else {
            var tempHead = headNode;
            for (int i = 0; i < index - 1; i++) {
                tempHead = tempHead.next;
            }
            var tempNode = tempHead.next;
            ListNode node = new ListNode(val);
            tempHead.next = node;
            tempHead.next.next = tempNode;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) return;
        if (index == 0) {
            headNode = headNode.next;
        } else {
            var tempNode = headNode;
            ListNode prev = null;
            for (int i = 0; i < index; i++) {
                prev = tempNode;
                tempNode = tempNode.next;
            }
            prev.next = tempNode.next;
        }
        length--;
    }

    public void printLinkedList() {
        var tempNode = headNode;
        for (int i = 0; i < length; i++) {
            System.out.print(headNode.value + " --> ");
            headNode = headNode.next;
        }
        headNode = tempNode;
        System.out.println("Length is {" + length + "}");
    }

    public boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        ListNode temp = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) return true;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        boolean loopExists = false;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (fastPointer == slowPointer) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            slowPointer = head;
            while (slowPointer != fastPointer) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
            return fastPointer;
        }
        return null;
    }

    class ListNode {
        int value;
        ListNode next;

        ListNode(int val) {
            this.value = val;
        }
    }
}
