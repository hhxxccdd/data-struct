package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {


    public static void main(String[] args) {
        //先创建一个逆波兰表达式
        //说明：为了方便，逆波兰表达式的数字和符号使用空格表示
        String suffixExpression = "3 4 + 5 * 6 - ";

        //先将3 4 + 5 * 6 -方法哦ArrayLis中
        //配合栈进行计算


//        List<String> list = getListString(suffixExpression);
//        System.out.println(list);
//
//
//        int res =calculate(list);
//
//        System.out.println(res);


        //完成一个中缀表达式转后缀表达式功能
        //1.将字符串转成对应的list集合
        //2.将得到的中缀表达式对应的list转成一个后缀表达式对应的list

        String expression = "1+((2+3)*4)-5";

        var stringList = toInfixExpressionList(expression);
        System.out.println(stringList);


        var parseSuffixExpression = parseSuffixExpression(stringList);
        System.out.println(parseSuffixExpression);

        System.out.println(calculate(parseSuffixExpression));

    }

    //将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s){
        //先定义一个list，存放对应的字符串数据
        List<String> list = new ArrayList<>();

        int i = 0;  //相当于指针，用于遍历中缀表达式字符串

        String str;  // 对多位数的拼接

        char  c; // 遍历到一个字符，就放入到list
        do {
            //如果c是一个非数字，就需要加入到list
           if((c=s.charAt(i))<48 || (c=s.charAt(i))>57){

               list.add(String.valueOf(c));
               i++;   //i相当于指针，需要后移

           }else {  //如果是一个数，需要考虑多位数的问题

               str = "";  //先将string置空
               while (i < s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57){
                   str += c;   //拼接
                   i++;
               }
               list.add(str);
           }


        }while (i < s.length());

        return list;

    }


    //2.将得到的中缀表达式对应的list转成一个后缀表达式对应的list
    public static List<String> parseSuffixExpression(List<String> str){
        //定义两个栈
        Stack<String> stack = new Stack<>();   //符号栈

        //应为s2在这个转换的过程中没有pop的操作，后面还需逆序输出 , 直接使用List
//        Stack<String> stack2 = new Stack<>();   //储存中间结果的栈s2
        List<String> list = new  ArrayList<String>();


        //遍历str
        for (String item : str){
            //如果是有个数，入栈
            if(item.matches("\\d+")){
                list.add(item);
            }else if(item.equals("(")){
                stack.push(item);
            }else if(item.equals(")")){
                //如果是右括号“）”，则依次弹出s1栈顶的运算符，并压入s2，知道遇到左括号为止，将此对括号废弃
                while (!stack.peek().equals("(")){
                    list.add(stack.pop());
                }
                stack.pop();   //将左括号弹出(
            }else {
                   //当s1栈顶的运算符的优先级小于等于栈顶运算符的运算级
                while (stack.size() !=0 && Operation.getValue(stack.peek()) >= Operation.getValue(item)){

                    list.add(stack.pop());

                }
                //还需要将item压入栈
                stack.push(item);

            }
        }

        //将s1剩余的运算符依次弹出并压入s2
        while (stack.size()!=0){
            list.add(stack.pop());
        }


         return list;  //应为是存放到List,因此按顺序输出就是对应的后缀表达式

    }



    //将一个逆波兰表达式，依次将数据和运算符放到ArrayList中
    public static List<String> getListString(String suffixExpression){
           //将suffixExpression分割
        var split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele : split){
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的计算

    public static  int calculate(List<String> list){
        //创建栈
        Stack<String> stack = new Stack<String>();
        //遍历list
        for(String item : list){
            //使用正则表达式
            if(item.matches("\\d+")){   //匹配的是多位数
                //入栈
                stack.push(item);
            }else {
                //pop出两个数，并运算，再入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1+num2;
                }else if(item.equals("-")){
                    res = num2 - num1;   //注意顺序
                }else if(item.equals("*")){
                    res = num1*num2;
                }else if(item.equals("/")){
                    res =num2/num1;
                }else {
                    throw  new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(String.valueOf(res));
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }



}

//编写一个类Operation 可以返回一个运算符对应的优先级
class Operation{

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;



   //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
           int result = 0;
           if(operation.equals("+")){

               result= ADD;

           }else if(operation.equals("-")){

               result=SUB;

           }else if(operation.equals("*")){

               result=MUL;

           }else if(operation.equals("/")){

               result=DIV;

           }

           return result;
    }





}