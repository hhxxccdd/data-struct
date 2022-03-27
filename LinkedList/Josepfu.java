package LinkedList;

public class Josepfu {

    public static void main(String[] args) {

         //测试一把
        CircleSingleLinkedList list =new CircleSingleLinkedList();
        list.addBoy(5);
//        list.showBoy();

        //测试一把小孩出圈
        list.countBoy(1,2,5);

    }
}


//创建环形链表
class CircleSingleLinkedList{
      //创建一个first节点，当前没有值
    private boy first = new boy(-1);
    //添加小孩节点，构建成一个环形链表
    public void addBoy(int nums){
        //nums做数据效验
        if(nums < 1){
            System.out.println("输入的值不正确");
            return;
        }
        boy curBoy = null;   //辅助指针
        //使用for来创建链表
        for (int i =1 ;i <= nums ; i++){
           //根据编号，创建小孩节点
            boy boy =new boy(i);
           //如果是第一个小孩
            if(i ==1 ){
                first = boy;
                first.setNext(first);
                curBoy = first;  //让curBoy指向第一个小孩
            }
            else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }


    //遍历当前的环形链表
    public void showBoy(){
        //判断链表是否为空
        if(first == null){
            System.out.println("链表为空");
        }
        //头结点不能动，使用辅助指针。
        boy curBoy  = first;
        while (true){
            System.out.println(curBoy.getNo());
            if(curBoy.getNext() == first){   //说明遍历完毕
                break;
            }
            curBoy = curBoy.getNext();   //让curBoy后移
        }

    }

    //根据用户的输入，计算出出圈的一个顺序

    /**
     *
     * @param startNo //从第几个小孩开始数数
     * @param countNum  //数几下
     * @param nums     //小孩的个数
     */
    public void countBoy(int startNo, int countNum, int nums){
        //先对数据进行效验

        if(first == null || startNo <1 ||startNo >nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建辅助指针，完成小孩出圈
           boy helper = first ;
        //helper指针，应该指向环形链表的最后一个节点
           while (true){
               if(helper.getNext() == first){   //说明helper指向最后一个节点

                      break;
               }
               helper =helper.getNext();
           }
        //小孩报数之前，先让first和helper移动k-1次
        for(int j =0 ;j < startNo -1 ;j++){
            first =first.getNext();
            helper = helper.getNext();
        }
        //开始报数
        while (true){
            if(first == helper){
                break;
            }
            //让first和helper移动countNum -1 次
            for( int j = 0 ;j<countNum -1 ;j++){
                first =first.getNext();
                helper = helper.getNext();
            }
            //first出圈
            System.out.println(first.getNo());

              first  = first.getNext();
              helper.setNext(first);
        }
        System.out.println("最后留在圈中的%d"+first.getNo());

    }



//    public void addBoy2(boy boy){
//        //定义辅助节点
//        boy temp = first;
//        //遍历链表
//        while (true){
//            if(temp.getNext() == first){
//                break;
//            }
//
//            temp =temp.getNext();
//        }
//
//        temp.setNext(boy);
//        boy.setNext(first);
//
//
//    }
}







//创建一个boy节点
class boy{
    private  int  no;  //编号
    private  boy  next;//指向下一个节点

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public boy getNext() {
        return next;
    }

    public void setNext(boy next) {
        this.next = next;
    }

    public boy(int   no){
        this.no =no;
    }

    //重写toSTring

    @Override
    public String toString() {
        return "boy{" +
                "no=" + no +
                '}';
    }
}
