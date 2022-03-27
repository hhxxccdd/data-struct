package LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
         //test
        var node = new HeroNode(1, "宋江", "及时雨");
        var node1 = new HeroNode(2, "卢俊义", "玉麒麟");
        var node2 = new HeroNode(3, "误用", "智多星");
        var node3 = new HeroNode(4, "林冲", "豹子头");


        //创建链表
        SingleLinkedList singleLinkedList=new SingleLinkedList();

//        //加入
//        singleLinkedList.add(node);
//        singleLinkedList.add(node1);
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);

        //插入
        singleLinkedList.insert(node);
        singleLinkedList.insert(node3);
        singleLinkedList.insert(node2);
        singleLinkedList.insert(node1);

        //测试修改节点的代码
        var node4 = new HeroNode(2, "胡心诚", "彭于晏");
        singleLinkedList.update(node4);

        //测试删除
        singleLinkedList.delete(3);

        var length = SingleLinkedListDemo.getLength(singleLinkedList.getHead());
        System.out.println(length);

        //测试倒数k节点
        System.out.println(SingleLinkedListDemo.getLastIndexNode(singleLinkedList.getHead(),4)+"-------------codebyhhxxccdd");

//        //测试链表翻转
//        var reverse = SingleLinkedListDemo.reverse(singleLinkedList.getHead());
//        while (true){
//            if(reverse == null){
//                break;
//            }
//            else {
//                System.out.println(reverse);
//            }
//            reverse =reverse.next;
//        }




        //显示
        singleLinkedList.list();

        //测试链表反转
        SingleLinkedListDemo.reverseList(singleLinkedList.getHead());


        //再显示
        singleLinkedList.list();



    }
    //获取到单链表的节点的个数（如果有头结点，则去掉）

    /**
     *
     * @param head 链表的头结点
     * @return     链表的有效长度
     */
    public static int getLength(HeroNode head){
        if(head.next == null){  //空链表
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;      //过滤头结点
        while (true){
            if(cur != null){
                length++;
                cur=cur.next;
            }else {
                break;
            }
        }
        return length;
    }


    //查询单链表的倒数第k个结点
    //先把链表从头到尾遍历，等到总长度。再减去k，获得遍历的个数(size - index)个

    /**
     *
     * @param node 传入链表头结点
     * @param index  传入倒数第几个结点
     * @return     返货获取到的链表节点
     */
    public static HeroNode getLastIndexNode(HeroNode node,int index){
        //获取辅助变量
        HeroNode temp=node.next;
        //判断链表是否为空
        if (temp == null){
            return null;      //链表为空，没有找到
        }


        //定义int型数据记录链表长度
        int length = 0;
        int cur=0;
        //遍历链表
        while (temp != null){
            length++;
            temp=temp.next;
        }
        //给index作辅助效验
        if(index>length || index<0){
            return null;               //无法找到该节点
        }
        //给temp重新定位
        temp= node.next;
        while (true){
            if(cur == length-index){
               break;
            }
            temp=temp.next;
            cur++;
        }
        HeroNode heroNode = temp;
        return temp;
    }

    //单链表翻转

//    /**
//     *
//     * @param node
//     * @return
//     */
//    public static HeroNode reverse(HeroNode node){
//        HeroNode demo =new HeroNode(0,"","");
//
//        //定义辅助节点
//        HeroNode temp =node.next;
//
//        //循环
//        while (true){
//            if(temp==null){
//                break;
//            }
//            if(demo.next == null){
//                demo.next = temp;
//            }
//            else if(demo.next != null){
//                //定义一个辅助变量
//                HeroNode p;
//                p = demo.next;
//                demo.next = temp;
//                temp.next = p;
//            }
//            temp =temp.next;
//        }
//        node.next = demo;
//
//        return node;
//    }

    public static void reverseList(HeroNode head){
         //如果当前链表为空，或者只有一个节点，无需翻转
        if(head.next == null || head.next.next == null){
            return ;
        }

        //定义一个辅助的变量，帮助我们遍历原来的链表
         HeroNode cur = head.next;
        //定义指向当前节点的下一个节点
         HeroNode next = null;
         HeroNode reverseHead = new HeroNode(0,"","");
         //遍历原来的链表，每遍历一个节点，就放在reversHead的前端。
         while (cur != null){
             next = cur.next; //先暂时保存当前节点的下一个节点
             cur.next = reverseHead.next;  //将cur的下一个节点指向链表的最前端
             reverseHead.next = cur;
             cur = next;   // 让cur后移
         }
         //将head.next 指向 reverseHead.next;
        head.next = reverseHead.next;
    }

}

//定义SingleLinkedList
class SingleLinkedList{
    //初始化头结点,不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //添加方法
     public void  add(HeroNode heroNode){

         //应为head不能动，需要一个辅助遍历 temp
         HeroNode temp = head;
         //遍历列表，找到最后
         while (true){
             //找到链表的最后
             if(temp.next==null){
                 break;
             }
             //如果没找到，就将temp后移
             temp=temp.next;
         }
         //当退出循环后，temp指向链表的最后
         temp.next=heroNode;
     }

     //显示列表[遍历]
    public void list(){
         //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
        }

        //头结点不能动，需要一个辅助变量来遍历
        HeroNode temp = head.next;

        while (true){
            if(temp==null){
               break;
            }
            System.out.println(temp);
            //将next后移
            temp=temp.next;
        }
    }

    //插入
    public  void insert(HeroNode heroNode){

//         //头节点不能动
//        HeroNode temp = head.next;
//
//        while (true){
//            if(temp.no<heroNode.no&&temp.next.no>heroNode.no){
//                break;
//            }
//        }
//
//        //设置一个变量用作交换
//        HeroNode p= new HeroNode();
//
//        p=heroNode;
//        heroNode.next=temp.next;
//        temp.next=p;

        HeroNode temp = head;
        boolean flag= false;  //标志添加的符号是否存在 默认为false
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no){   //位置找到，就在temp的后面插入
                break;
            }
            else if(temp.next.no == heroNode.no){   //编号已经存在

                flag = true;  // 说明编号存在
                break;
            }
            temp = temp.next; // 后移
        }
        //判断flag的值
        if(flag){
            System.out.println("编号存在，插入失败");
        }else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next=heroNode;
        }

    }

    //修改节点的消息，根据no编号来改，no不能改
    public void update(HeroNode heroNode){
         if(head.next == null){
             System.out.println("链表为空");
             return;
         }
         //定义辅助节点
        HeroNode temp =head;
         boolean flag = false;    //表示是否找到该节点
        while (true){
            if(temp ==null){
               break; // 已经遍历玩列表
            }
            if(temp.no == heroNode.no){
                  flag = true;   // 已经找到
                  break;
            }
            temp=temp.next;
        }
        //根据flag判断是否找到
        if(flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }
        else {
            System.out.println("没有找到编号节点");
        }
    }

    //删除
    public void delete(int io){
         //获得头节点
        HeroNode temp = head;
        boolean flag = false;  //判断是否能够找到该节点的前一个节点
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == io){   //找到了待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){   //找到，可以删除

            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到要删除的节点");
        }
    }


}


//定义一个HeroNode.

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;  //指向下一个节点
    //构造器
    public HeroNode(int hNo, String hName ,String HNickname){
        this.no=hNo;
        this.name=hName;
        this.nickname=HNickname;
    }

    public HeroNode(){

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