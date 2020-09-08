package Queen;

public class Queen8 {
    int max = 8;//表示有几个棋子

    int array[] = new int[max];//存放皇后的位置的结果

    static int count = 0;//记录次数

    public static void main(String[] args) {
        Queen8 a = new Queen8();
        a.check(0);
        System.out.println(count);
    }

    //编写一个方法，放置第n个皇后
    private void check(int n){
        if( n == max ){
            print();
            return;
        }
        for(int i = 0;i<max;i++){
            array[n] = i;

            //判断该n个皇后是否冲突
            if(Judge(n)){//不冲突，将放置下一个皇后
                check(n+1);
            }

            //如果冲突就返回到array(即向棋盘的右边移动一个位置)
        }

    }

    //查看皇后放置的位置是否符合规则,去检测跟前面的皇后是否冲突
    //就是比较这个皇后和之前所有的皇后的列是否相同，对角线是否存在（行不用比较，因为每一行只存在一个皇后）
    private boolean Judge(int n){
        for (int i= 0;i<n;i++){
            if(array[i] == array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }



    //输出皇后的位置
    private void print(){
        count++;
        for(int i= 0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }


}


