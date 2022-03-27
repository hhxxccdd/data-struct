package LinkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        var node = new HeroNode2(1, "宋江", "及时雨");
        var node1 = new HeroNode2(2, "卢俊义", "玉麒麟");
        var node2 = new HeroNode2(3, "误用", "智多星");
        var node3 = new HeroNode2(4, "林冲", "豹子头");

         DoubleLinkedList list =new DoubleLinkedList();
         //双向链表的添加操作
         list.add(node);
         list.add(node1);
         list.add(node2);
         list.add(node3);

         list.list();

         //修改双向链表中的节点
        HeroNode2 newHeroNode = new HeroNode2(4,"胡心诚","彭于晏");
        list.update(newHeroNode);
        System.out.println("--------------------------------------------");
        list.list();


        list.delete(3);
        System.out.println("--------------------------------------------");
        list.list();

        list.delete(4);
        System.out.println("---------------------------------------------");
        list.list();
    }

}

//创建一个双向链表的类

class  DoubleLinkedList{

    //初始化头结点,不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"","");

    //返回节点
    public HeroNode2 getHead(){
        return head;
    }

    //遍历双向链表
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

       //头结点不能动，添加辅助变量进行遍历
        HeroNode2 temp = head.next;

      while (true){
          if(temp == null){
              break;
          }
          System.out.println(temp);
          temp=temp.next;
      }
    }

      //双向链表的添加操作
    public void add(HeroNode2 node){

        //头结点不能动，需要辅助节点进行遍历
        HeroNode2 temp =head;

        //遍历到最后一个节点
        while (true){
            if(temp.next == null){
                break;
            }
            temp =temp.next;
        }

        temp.next = node;
        node.pre = temp;

    }

    //对双向链表的节点进行修改
    public void update(HeroNode2 node){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
        }

        boolean flag = false;       //判断是否找到了该节点

        //头结点不能动，需要辅助节点进行遍历
        HeroNode2 temp = head.next;

        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == node.no){
                flag = true;
                break;
            }

            temp =temp.next;
        }

        if(flag){
            temp.name = node.name;
            temp.nickname = node.nickname;
        }
        else {
            System.out.println("没找到");
        }
    }

     //从双向链表中删除一个节点
    public void delete(int no){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
        }

        boolean flag = false;       //判断是否找到该节点

        HeroNode2 temp = head.next;        //头结点不能动， 需要辅助节点遍历

        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){

//            temp.next = temp.next.next;
//            temp.next.next.pre = temp;
            temp.pre.next = temp.next;
            if(temp.next != null){

                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("找不到要删除的节点");
        }
    }
}


//定义一个HeroNode.

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;  //指向下一个节点
    public HeroNode2 pre; //指向前一个节点
    //构造器
    public HeroNode2(int hNo, String hName ,String HNickname){
        this.no=hNo;
        this.name=hName;
        this.nickname=HNickname;
    }

    public HeroNode2(){

    }
    //重写toString


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}