package stack;

public class LinkedStackDemo {


    public static void main(String[] args) {
         LinkedStack stack = new LinkedStack();
         Node node1= new Node(1);
         Node node5= new Node(5);
         Node node7= new Node(7);
         stack.push(node1);
         stack.push(node5);
         stack.push(node7);
         stack.list();
        var pop = stack.pop();
        var pop1 = stack.pop();
        var pop2 = stack.pop();
        var pop3 = stack.pop();
        System.out.println(pop);
        System.out.println(pop1);
        System.out.println(pop2);
        System.out.println(pop3);


    }








}

class
LinkedStack{

    //新建头结点
   private Node head =new Node();

    public Node getHead() {
        return head;
    }

   //判断是否栈空
    public boolean isEmpty(){


        if(head.next == null){
            return true;
        }
        else
            return false;

    }

    //进栈
    public void push(Node node){

        if(isEmpty()){          //如果是空栈
            head.next = node;
            return;
        }

            node.next = head.next;     //不是空栈的情况
            head.next = node;

    }


    //出栈
    public Node pop(){
        //头结点不能动
        Node temp = head.next;

        //判断是否为空栈
        if (isEmpty()){
//            System.out.println("空栈");
            return null;
        }

        if(head.next.next!= null){
            head.next = head.next.next;
            return temp;
        }
        else {
            head.next = null;
            return temp;
        }
    }


    //遍历栈
    public void list(){
        //头节点不能动，需要辅助节点
        Node temp = head.next;

        if(head.next == null){
            System.out.println("空栈");
        }

        while (true){
            if(temp== null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


}
//节点
class Node{
    public int number;
    public Node next; //遍历的节点

    public Node(int number){
        this.number = number;
    }

    public Node(){

    }

    @Override
    public String toString() {
        return "Node{" +
                "number=" + number +
                '}';
    }
}


