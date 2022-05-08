package hashtable;

import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) {

        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单的菜单
        String key = "";
        var scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("delete:删除雇员");
            System.out.println("exit:退出");

            key  = scanner.next();

            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    var emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入id");
                    int id1 = scanner.nextInt();
                    hashTab.findEmpById(id1);
                    break;
                case "delete":
                    System.out.println("输入id");
                    int id2= scanner.nextInt();
                    hashTab.delete(id2);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
            }
        }

    }
}

//创建HashTab，管理多条链表
class HashTab {

    private EmpLinkedList[] empLinkedListArray;

    private int size; // 表示共有多少条

    public HashTab(int size) {

        this.size = size;
        //初始化empLinkedListArray

        empLinkedListArray = new EmpLinkedList[size];

        for (int i =0 ;i <size;i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }

    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id得到该员工应该加入到那条链表
        int empLinkedListNo = hashFun(emp.id);

        //将emp加入到对应的链表中

        empLinkedListArray[empLinkedListNo].add(emp);

    }

    //遍历所有的链表,遍历hash
    public void list(){


        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }


    //查找
   public void findEmpById(int id){
        //使用散列函数确定在那条列表中查找
       int empLinkedListNo = hashFun(id);
       Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
       if(emp != null){
           System.out.println("找到该雇员");
       }else {
           System.out.println("在哈希表中，没有找到该雇员");
       }
   }

   //删除
    public void delete(int id){
        //使用散列函数确定在那条列表中查找
        int empLinkedListNo = hashFun(id);
        empLinkedListArray[empLinkedListNo].delete(id);
    }


    //编写散列函数
    public int hashFun(int id){

        return id % size;
    }


}


//雇员
class Emp {
    int id;
    String name;
    Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Emp(){

    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

//创建EmpLinkedList , 表示链表
class EmpLinkedList{

    Emp head; //头结点，默认为空

    //默认id自增长，将新员工加到最后
    //添加员工
    public void add(Emp emp) {

        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }


    //遍历员工
    public  void list(int no){
        if(head == null){
            System.out.println("第"+no+"链表为空") ;
            return;
        }

        //定义辅助节点
        Emp curEmp = head;

        while (true){

            System.out.println(curEmp);

            if(curEmp.next == null){
                break;
            }

            curEmp = curEmp.next;
        }
    }


    public Emp findEmpById(int id){

        //判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return null;
        }

        //定义辅助指针
        Emp curEmp = head;

        while (true){
            if(curEmp.id == id){
                break;
            }
            if(curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }

        return curEmp;
    }

    //删除员工
    public void delete(int io){

        //判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return;
        }
        if(head.id == io){
            head = head.next;
            return;
        }

        //定义辅助节点
        Emp curEmp = head;
        boolean flag = false;

        //遍历节点

        while (true){
            if(curEmp.next == null){
                break;
            }
            if(curEmp.next.id == io){
                flag = true;
                break;
            }
            curEmp = curEmp.next;

        }

        if(flag){
            curEmp.next = curEmp.next.next;
        }else {
            System.out.println("没有找到要删除的节点");
        }

    }


}