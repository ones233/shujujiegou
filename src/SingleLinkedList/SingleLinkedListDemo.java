package SingleLinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "李", "快乐");
        HeroNode hero2 = new HeroNode(2, "禅", "和尚");
        HeroNode hero3 = new HeroNode(3, "黑", "百合");
        HeroNode hero4 = new HeroNode(4, "麦", "克雷");

        //创建列表
        SingleLinkedlist singleLinkedlist = new SingleLinkedlist();
        //加入
        singleLinkedlist.add(hero1);
        singleLinkedlist.add(hero2);
        singleLinkedlist.add(hero3);
        singleLinkedlist.add(hero4);

        //显示
        singleLinkedlist.list();
    }
}


class SingleLinkedlist{
    //先初始化一个头节点（不能动）
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向列表
    //思路： 1，找到当前链表的最后节点
    //2。将最后的next节点next指向新的节点

    public void add(HeroNode heroNode){

        //因为head节点不能动，需要一个辅助的temp遍历
        HeroNode temp = head;
        //遍历数组找到最后
        while(true){
            //找到链表的最后
            if(temp.next ==null){
                break;
            }
            temp = temp.next;
        }
        //退出时。temp指向新的节点

        temp.next = heroNode;
    }

    //显示遍历链表

    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
        }

        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp =temp.next;
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
