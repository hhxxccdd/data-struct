package stack;

import java.util.Scanner;

public class ArrayStackDemo {


    public static void main(String[] args) {
        //测试一下栈
        //先创建ArrayStack对象
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;   //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);


        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出栈");
            System.out.println("push:表示添加数据到栈");
            System.out.println("pop:表示从栈取出数据");
            System.out.println("请输入你的选择");
            key =scanner.next();
            if(key.equals("show")){

                arrayStack.list();

            }
            else if(key.equals("push")){

                int value = scanner.nextInt();
                arrayStack.push(value);

            }else if(key.equals("pop")){

              try{
                  int res =  arrayStack.pop();
                  System.out.println("出栈的数据"+res);
              }catch (Exception e){
                  System.out.println(e.getMessage());
              }

            }
            else if(key.equals("pop")){
                scanner.close();
                loop = false;

            }else if(key.equals("exit")){
                System.out.println("程序退出了");
            }

        }

    }



}


class ArrayStack{

   private  int maxSize; //栈的大小
   private  int[] stack;   //数组，数组模拟栈
   private  int top = -1;  //top表示栈顶，初始化-1


   public ArrayStack(int maxSize){
         this.maxSize=maxSize;
         stack = new int[this.maxSize];

   }

   //栈满
    public boolean isFull(){

          return top == maxSize-1;

    }

    //栈空
    public boolean isEmpty(){

         return top == -1;

    }

    //入栈
    public void push(int value){
       //先判断栈满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

    //出栈,将栈顶的数据返回
    public int pop(){
         //先判断是否栈空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }


    //遍历栈,遍历是需要从栈顶显示数据
    public void list(){
         if(isEmpty()){
             System.out.println("栈空，没有数据");
         }
         for (int i = top ;i >= 0; i--){
             System.out.println(stack[i]);
         }
    }



}