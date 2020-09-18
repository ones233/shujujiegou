package digui;

public class InvertTree {
    public static void main(String[] args) {

        int arr[] ={1,2,3,4,5,6,7};


        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.left =node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right =node7;


        //反转前
        System.out.println("反转前的前序遍历树如下。。。。");
        root.preOrder();

        System.out.println("反转后的前序遍历树如下。。。。");
        TreeNode tree = invertTree(root);
        tree.preOrder();


    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
        //前序遍历
        public void preOrder(){
            System.out.println(this);
            if(this.left!= null){
                this.left.preOrder();
            }
            if(this.right!=null){
                this.right.preOrder();
            }
        }

        @Override
        public String toString(){
            return "TreeNode [val ="+ val +"]";
        }
    }

    public static TreeNode invertTree(TreeNode root){
        while( root == null){
            return null;
        }
        //反转左节点下的左右节点
        TreeNode left = invertTree( root.left);

        //反转右节点下的左右节点
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }

}



