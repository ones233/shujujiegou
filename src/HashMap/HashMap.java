package HashMap;

import java.util.Scanner;

public class HashMap {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true){

            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit: 退出系统");
            System.out.println("find: 查找雇员");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;


                case "list":
                    hashTab.list();
                    break;

                case "exit":
                    scanner.close();
                    System.exit(0);

                default:
                    break;
            }
        }
    }
}


class HashTab{
    EmpLinkedList[] empLinkedListArray;
    int size;//共有size条链表

    //构造器
    public HashTab(int size){
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i= 0;i<size;i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加
    public void add(Emp emp){
        //根据员工的序号判断加入哪条链表
        int empLinkedListNum = hashFun(emp.id);
        empLinkedListArray[empLinkedListNum].add(emp);
    }

    //遍历所有的链表
    public void list(){
        for (int i= 0;i<size;i++){
            empLinkedListArray[i].list(i);
        }
    }

    //散列函数
    public  int hashFun(int id){
        return id%size;
    }
}



class Emp{
    int id;
    String name;
    Emp next;
    Emp(int id,String name){
        this.id = id;
        this.name = name;
    }

}

class EmpLinkedList {
    Emp head ;//头指针默认为null


    //添加节点
    public void add(Emp emp){
        if(head ==null){
            head = emp;
        }
        Emp curEmp = head;
        //讲辅助指针排到最后一个
        while(true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //遍历
    public void list(int no){
        if(head == null){
            System.out.println("第"+no+"条链表为空");
            return;
        }
        System.out.printf("第"+no+"链表的信息为：");
        Emp curEmp = head;
        while(true){
            System.out.printf("   => id=%d,name=%s",curEmp.id,curEmp.name);
                break;

        }
        System.out.println();
    }

}
