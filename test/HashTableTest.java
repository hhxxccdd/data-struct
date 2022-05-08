package test;

import java.util.Scanner;

public class HashTableTest {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true){
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



//员工类
class Emp{

    int id;
    String name;
    Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

//链表
class  EmpLinkedList{

    //头结点，默认为空
    Emp head;

    //添加员工
    public void add(Emp emp) {

        if (head == null) {
            head = emp;
            return;
        }

        //辅助节点
        Emp curEmp = head;

        while (true) {

            if (curEmp.next == null) {
                break;
            }

            curEmp = curEmp.next;

        }

        curEmp.next = emp;

    }


    //遍历员工
    public void list() {

        if (head == null) {
            System.out.println("该链表为空");
            return;
        }

        //辅助节点
        Emp curEmp = head;

        while (true) {
            System.out.println(curEmp);

            if (curEmp.next == null) {

                break;

            }

            curEmp = curEmp.next;
        }


    }

    //查找
    public Emp find(int i) {

        if (head == null) {

            System.out.println("链表为空");

            return null;

        }


        //定义辅助节点
        Emp curEmp = head;


        while (true) {

            if (curEmp.id == i) {
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }

            curEmp = curEmp.next;


        }


        return curEmp;

    }


    //删除
    public void delete(int i){

       if (head == null){
           System.out.println("链表为空");
           return;
       }
       if(head.id == i){
           head = head.next;
           return;
       }

        Emp curEmp =head;
        boolean flag = false;

        while (true){
            if(curEmp.next == null){
                break;
            }
            if(curEmp.next.id == i){
                flag = true;
                break;
            }
            curEmp = curEmp.next;
        }

        if(flag){
            curEmp.next = curEmp.next.next;
        }else {
            System.out.println("没有找到该节点");
        }


    }
}

class HashTab{

    private EmpLinkedList[] empLinkedListArray;

    private int size;

    public HashTab(int size){

        empLinkedListArray = new EmpLinkedList[size];

        this.size = size;


        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }

    }

    public int HashFun(int i){

        return  i % size;

    }

    public void add(Emp emp){

        int empLinkedListNo = HashFun(emp.id);

        empLinkedListArray[empLinkedListNo].add(emp);

    }

    public void list(){

        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }

    }

    public void findEmpById(int i){
        int empLinkedListNo = HashFun(i);
        Emp emp = empLinkedListArray[empLinkedListNo].find(i);
        if(emp != null){
            System.out.println("找到该雇员");
        }else {
            System.out.println("在哈希表中，没有找到该雇员");
        }

    }

    public void delete(int id){
        //使用散列函数确定在那条列表中查找
        int empLinkedListNo = HashFun(id);
        empLinkedListArray[empLinkedListNo].delete(id);
    }

}