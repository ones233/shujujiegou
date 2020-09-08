package BinaryTree01;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建节点
        HeroNode root = new HeroNode(1,"A");
        HeroNode node2 = new HeroNode(2,"B");
        HeroNode node3 = new HeroNode(3,"C");
        HeroNode node4 = new HeroNode(4,"D");
        HeroNode node5 = new HeroNode(5,"E");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

//        System.out.println("前序遍历");//1,2,3,4
//        binaryTree.preOrder();
//        System.out.println();
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();


        //删除测试
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();

    }
}


class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    public void delNode(int no){
        if(root!=null){
            //如果只有一个root，这里立即判断是不是要删除的结点
            if(root.getNo()==no){
                root = null;
            }else {
                root.delNode(no);
            }


        }else{
            System.out.println("这个树是空的,不能删除");
        }
    }

    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("此树为空");
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.root!= null){
            this.root.infixOrder();
        }else{
            System.out.println("此树为空");
        }
    }

    //后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("此树为空");
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private  HeroNode right;
    public HeroNode(int no,String name){
        this.no = no;
        this.name=name;
    }

    public void delNode(int no){
        //先判断左子树
        if(this.left!=null&&this.left.no == no){
            this.left =null;
            return;
        }

        //后判断右子树
        if(this.right!=null&&this.right.no ==no){
            this.right = null;
            return;
        }

        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }

    //编写前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!= null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    //编写中序遍历
    public void infixOrder(){
        if(this.left!= null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!= null){
            this.right.infixOrder();
        }
    }

    //编写后序遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    @Override
    public String toString(){
        return "HeroNode [no ="+ no +",name="+name+"]";
    }
}


