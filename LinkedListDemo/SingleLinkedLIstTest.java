package LinkedListDemo;

public class SingleLinkedLIstTest {

    public static void main(String[] args) {
        Student student1 = new Student(1, "hu");
        Student student2 = new Student(2, "xin");
        Student student3 = new Student(3, "cheng");
        Student student4 = new Student(4, "lisa");
        Student student5 = new Student(5, "mike");

        SingleLinkedList list = new SingleLinkedList();

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);

        list.list();

        System.out.println("----------------------------------");
        Student student6 = new Student(2,"peng");
        list.update(student6);
        list.list();

        System.out.println("----------------------------------");
        list.delete(1);
        list.list();
        SingleLinkedLIstTest singleLinkedLIstTest=new SingleLinkedLIstTest();
        int length = singleLinkedLIstTest.getHeadLength(list.head);
        System.out.println(length);
    }

    //获取单链表中的节点格式
    public int getHeadLength(Student head){
        //判断是否为空链表
        if(head.next == null){
            return 0;
        }

        int length = 0 ;     //计数
        Student cur = head.next;   //辅助节点

        while (true){
            if(cur != null){
                length++;
                cur =cur.next;
            }
            else {
                break;
            }
        }
        return length;
    }


    //查询链表中倒数第k个节点
    //思路：先求出链表的长度size，再用（size - index)
    public Student getLastIndexStudent(Student head,int index){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
        }

        int size = 0; //求出链表的总长度
        int length = 0;
        //定义辅助节点
        Student cur = head.next;

        //遍历求出链表长度
        while (true){
            if(cur != null){
                size++;
                cur =cur.next;
            }
           else {
               break;
            }
        }
        //重新定位
        cur =head.next;
        while (true){
            if(length == size - index){
                break;
            }
            cur =cur.next;
            length++;
        }
        return cur;
    }

   //单链表反转
  public void reverseList(Student head){
        //判断输入链表的长度
      if(head.next == null || head.next.next==null){
          return;
      }

      //定义一个辅助节点
      Student temp = head.next;
      //定义一个指向下一个节点的指针
      Student next = null;
      Student reverseHead = new Student(0,"");
      while (temp != null){
          next = temp.next;
          temp.next = reverseHead.next;
          reverseHead.next = temp;
          temp =next;
      }
      head.next = reverseHead.next;
  }






}
class SingleLinkedList{

    //新建头结点
     Student head  =new Student(0,"胡心诚");

     public Student getHead(){
         return head;
     }


   //添加方法
    public void add(Student student){

        //头结点不能动，需要辅助节点
        Student temp  =head;

        while (true){
            if(temp.next == null){
                break;
            }
            temp =temp.next;
        }

        temp.next = student;

    }


    //修改操作
    public void update(Student student){

        //头结点不能动，需要辅助节点
        Student temp = head;
        //标识符，判断找到值,默认值为false
        Boolean flag = false;

        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        while (true){
            if(temp.number == student.number){
                flag = true;                      //找到该节点
                break;
            }
            temp = temp.next;
        }

        if(flag){

            temp.name = student.name;
        }

    }


    //删除操作
    public void delete(int number){

        //辅助节点
        Student temp = head;
        //判断是否找到该节点的标识
        Boolean flag = false;

        //判断链表为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.number == number){
                //这里需要遍历到该节点的上一个节点，因为删除时需要用该节点的上一个节点指向下一个节点
                flag = true;
                break;
            }
            temp =temp.next;
        }

        if(flag){
            temp.next =temp.next.next;
        }
        else {
            System.out.println("没有找到该节点");
        }
    }

    //遍历链表操作
 public void  list(){

        //头结点不能动
     Student temp = head.next;


     if(head.next == null){
         System.out.println("链表为空");
         return;
     }

     while (true){

         System.out.println(temp);

         temp =temp.next;

         if(temp == null){
             break;
         }

     }
 }

//插入操作
    public void insert(Student student){

         //获取辅助节点
        Student temp = head.next;
        //标识符
        Boolean flag = false ;      //是否找到该节点

        //判断是否为空链表
        if(head.next == null){
            System.out.println("链表为空");
        }

       while (true){
           if(temp == null){
               break;
           }
           if(temp.next.number == student.number){
               flag = true;
               System.out.println("已有编号");
               break;
           }
           if(temp.next.number > student.number){
               break;
           }
           temp = temp.next;
       }

       if(flag){
           System.out.println("已有编号");
       }else {
           student.next = temp.next;
           temp.next = student;
       }
    }
}


class  Student{

    int number;
    String  name;
    Student next;

    public  Student(int number,String name){

        this.number = number;
        this.name = name;


    }

    @Override
    public String toString() {
        return "student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}

