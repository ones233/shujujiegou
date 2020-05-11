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
//        singleLinkedlist.add(hero1);
//        singleLinkedlist.add(hero2);
//        singleLinkedlist.add(hero3);
//        singleLinkedlist.add(hero4);



        //有顺序的插入
        singleLinkedlist.addByOrder(hero1);
        singleLinkedlist.addByOrder(hero4);
        singleLinkedlist.addByOrder(hero2);
        singleLinkedlist.addByOrder(hero3);
//        singleLinkedlist.addByOrder(hero1);

        //修改名字
//        HeroNode newheroNode = new HeroNode(2, "卢", "西澳");
//        singleLinkedlist.update(newheroNode);

        //删除节点
        singleLinkedlist.del(3);

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

    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;//已经遍历结束了
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname =newHeroNode.nickname;
        }else {
            System.out.println("没有找到");
        }
    }

    //根据编号删除节点
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;

        while(true){
            if(temp.next == null){
                    break;
            }
            if(temp.next.no ==no){
                flag =true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            //删除
            temp.next =temp.next.next;
        }else {
            System.out.printf("要删除的节点不存在%d\n",no);
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
