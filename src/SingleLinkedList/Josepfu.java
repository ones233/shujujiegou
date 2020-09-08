package SingleLinkedList;

public class Josepfu {
    public static void main(String[] args) {
            CircleSingleLinkedList josepfu = new CircleSingleLinkedList();
            josepfu.addBoy(5);
            josepfu.showBoy();
            josepfu.countBoy(1,2,5);//2->4->1->5->3
    }
}

class CircleSingleLinkedList{
    //创建一个节点
    Boy first = null;

    //添加节点
    public void addBoy(int nums){
        if(nums <2){
            System.out.println("nums的数字不正确");
            return ;
        }
        Boy curBoy = null;//辅助指针，用来创建方向（指向）
        //创建环形链表
        for (int i=1;i<=nums;i++){
            Boy boy = new Boy(i);
            if(i ==1){
                first = boy;
                boy.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历节点
    public void showBoy(){
        if(first == null){
            System.out.println("链表为空");
        }
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号%d \n",curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    public void countBoy(int startNo,int countNum,int nums){
        Boy helper = first;//辅助指针
        while (true){
            if(helper.getNext() == first){
                break;
            }
            helper=helper.getNext();

        }
        //让first指向第一个喊的位置
        for(int i= 0;i<startNo-1;i++){
            first =first.next;
            helper= helper.next;
        }
        while (true){
            if(helper == first){
                break;
            }
            for(int j=0;j<countNum-1;j++){
                first =first.next;
                helper= helper.next;
            }
            System.out.printf("这时出圈的小孩节点为%d\n",first.getNo());
            first =first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号：%d\n",first.getNo());


    }





}



class Boy{
    int no;//编号
    Boy next;
    public Boy(int no){
        this.no= no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
