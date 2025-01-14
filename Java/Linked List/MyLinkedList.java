
// singly Linked List---->
public class MyLinkedList {
    public static class Node {
        int data;
        // passing by refference-->
        Node next;

        // constructor-->
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // static variables-->
    public static Node head;
    public static Node tail;
    public static int size;

    // Add methods---->

    // Add at first-->
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add at last-->
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Add at given index-->
    public void addAtIdx(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }
    // remove methods--->

    // remove at First-->
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // remove at Last-->
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node pre = head;
        for (int i = 0; i < size - 2; i++) {
            pre = pre.next;
        }
        int val = pre.next.data;
        pre.next = null;
        tail = pre;
        size--;
        return val;
    }

    // iterative search approach--->
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // recursive search approach using helper function-->
    public int recSearch(int key) {
        return helper(head, key);
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    // reverse a linked list using iterative approach-->
    public Node reverse(Node head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // reverse a linked list using recursion approach-->
    public Node revRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = revRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // remove nth Node from end---->
    public void removeNthNodeFromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }

    // Check if LL is palindrome or not-->
    // <---find middle--->
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // <--find palindrome-->
    public boolean isPalindrome() {
        // base case
        if (head == null || head.next == null) {
            return true;
        }
        // find mid
        Node midNode = findMid(head);
        // reverse 2nd half
        Node pre = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        Node rightHead = pre;
        Node leftHead = head;
        // check left == right
        while (rightHead != null) {
            if (leftHead.data != rightHead.data) {
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }

    // print linked list-->
    public void print() {
        if (head == null) {
            System.out.println("LL is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // is cycle--->
    public static boolean isCycle() {// floyed's cycle finding algorithm
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    public static void main(String[] args) {
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        MyLinkedList ll = new MyLinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);

        // ll.addAtIdx(3, 4);
        // ll.print();
        // System.out.println(size);
        // ll.removeFirst();
        // ll.print();
        // System.out.println(size);
        // System.out.println(ll.recSearch(3));
        // ll.head = ll.reverse(head);
        // ll.head = ll.revRecursive(ll.head);
        // ll.removeNthNodeFromEnd(2);
        // ll.removeLast();
        ll.print();
        // System.out.println(ll.isPalindrome());
        
    }
}
