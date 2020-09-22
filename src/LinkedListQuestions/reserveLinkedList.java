package LinkedListQuestions;

public class reserveLinkedList {
    public static void main(String[] args) {
        int arr[] ={1,2,3,4};
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("反转前的链表如下：");
        while(head != null){
            System.out.println(head);
            head =head.next;
        }

        System.out.println("反转后的链表如下：");

        Node head1 =  reversetList(node1);//非递归的方法
        //Node head1 =  reversetList2(node1);//递归的方法

        while(head1 != null ){
            System.out.println(head1);
            head1 = head1.next;
        }


    }
    //反转链表的解法一
    ///////////////////////////////////////////
////////////////////////////////////////////////////////////////
    public static Node reversetList(Node head){
        Node next =null;
        Node pre = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre= head;
            head = next;
        }
        return pre;
    }
    //////////////////////////////////////////////////////////////

    //反转链表的解法二（递归）
    ///////////////////////////////////////////
    public static Node reversetList2(Node head){
        if(head ==null ||head.next==null){
            return head;
        }
        //递归反转子链表
        Node newList = reversetList2(head.next);//该函数的功能是将链表反转

        head.next.next = head;
        head.next =null;

        return newList;

    }
}


class Node{
    public int value;
    public Node next;
    public Node(int data){
        this.value = data;
    }

    @Override
    public String toString(){
        return "Node ["+value+"]";
    }
}
