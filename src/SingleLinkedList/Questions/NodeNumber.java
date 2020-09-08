package SingleLinkedList.Questions;

public class NodeNumber {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1, "李", "快乐");
        HeroNode hero2 = new HeroNode(2, "禅", "和尚");
        HeroNode hero3 = new HeroNode(3, "黑", "百合");
        HeroNode hero4 = new HeroNode(4, "麦", "克雷");


        SingleLinkedlist singleLinkedlist = new SingleLinkedlist();

        singleLinkedlist.addByOrder(hero1);
        singleLinkedlist.addByOrder(hero4);
        singleLinkedlist.addByOrder(hero2);
        singleLinkedlist.addByOrder(hero3);


        int nodenumber = getLength(singleLinkedlist.getHead());
        System.out.println(nodenumber);


    }

    public static int getLength(HeroNode head){
        if(head.next == null){
            return  0;
        }
        int length =0;

        HeroNode tep = head.next;

        while(tep != null){
            length++;
            tep =tep.next;
        }
        return length;
    }
}




    //获取链表节点的个数(带头节点时，不计数头节点)

    class SingleLinkedlist{
        private HeroNode head = new HeroNode(0,"","");

        public HeroNode getHead(){
            return head;
        }



        public void addByOrder(HeroNode heroNode){
            HeroNode temp = head;
            boolean flag =false;
            while(true){
                if(temp.next == null){
                    break;
                }
                if(temp.next.no >heroNode.no){
                    break;
                }else if(temp.next.no ==heroNode.no){
                    flag = true;
                    break;
                }

                temp = temp.next;
            }

            if(flag){
                System.out.printf("插入的该英雄的编号%d已经存在，插入失败\n",heroNode.no);
            }else {
                heroNode.next = temp.next;
                temp.next = heroNode;
            }

        }



    }





class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


}
