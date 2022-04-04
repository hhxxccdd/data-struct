package stack;

public class Calculator {


    public static void main(String[] args) {

        //根据前面老师的思路完成表达式的运算
        String expression = "70+2*3-2";
        //创建两个栈，数栈，和符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义相关的变量
        int index =0 ; // 用来扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res  = 0;
        char ch = ' '; //将每次扫描的char保存在ch中
        String KeepNum = "";  //用于拼接多位数
        //开始while循环的扫描expression
        while (true){
            //依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么，做相应的判断
            if(operStack.isOper(ch)){   //如果是运算符
               //判断当前符号栈是否为空
               if(!operStack.isEmpty()){
                   if(operStack.priority(ch) <= operStack.priority(operStack.peak())){
                           //从数栈中pop出两个数
                       num1 = numStack.pop();
                       num2 = numStack.pop();
                       oper = operStack.pop();
                       res= numStack.cal(num1,num2,oper);
                       numStack.push(res);
                       //当前符号入符号栈
                       operStack.push(ch);
                   }else {
                       //如果当前的操作符的优先级大于符号栈的符号，直接入栈
                       operStack.push(ch);
                   }
               }else {
                   //如果符号栈为空
                   operStack.push(ch);
               }
            }else {        //如果是数，则直接入数栈
//                numStack.push(ch - 48);
                //1.当处理多位数时，不能发现是一个数就立即入栈,可能是多位数
                //2.再处理数时，需要向expression的表达式的index后再看一会。
                //3.因此我们需要一个变量字符串，用于拼接
                    //处理多位数
                    KeepNum += ch;

                //如果ch是expression的最后一位，就直接入栈
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(KeepNum));
                }else {

                    //判断下一个字符是不是数字,如果是数字，继续扫描，如果是运算符，直接入栈
                    //注意是看后一位，不要index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {

                        //如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(KeepNum));
                        //重要的！！！，KeepNum清空
                        KeepNum = "";


                    }

                }

            }
            //让index+1，并判断是否扫描到expression的最后
            index++;
            if(index >= expression.length()){
                  break;
            }
        }
        //当前表达式扫描完毕，顺序从数栈和符号栈中pop出数和符号
        while (true){
            //如果符号栈为空，则计算到最后一个数据，数栈中只有一个数字
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res= numStack.cal(num1,num2,oper);
            numStack.push(res);

        }
        //将数栈最后一个数pop出
        System.out.println("表达式的值"+numStack.pop());
    }
}

//创建一个栈,需要扩展功能
class ArrayStack2{

    private  int maxSize; //栈的大小
    private  int[] stack;   //数组，数组模拟栈
    private  int top = -1;  //top表示栈顶，初始化-1


    public ArrayStack2(int maxSize){
        this.maxSize=maxSize;
        stack = new int[this.maxSize];

    }

    //增加一个方法，返回当前栈顶的值，但不是真正的top
    public int peak(){

        return stack[top];

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


    //返回运算符的优先级，优先级使用数字表示
    public int priority(int oper){
         if(oper == '*' || oper == '/'){
             return 1;
         }else if(oper == '+' || oper == '-'){
             return 0;
         }else {
             return -1;     // 假定目前的计算式只有+—*/
         }
    }


    //判断是不是一个运算符
    public boolean  isOper(char val){

        return val == '+'||val == '-'||val == '*'||val=='/';

    }


    //运算
    public int cal(int num1, int num2, int oper){
        int res = 0;   //用来存放数据
        if(oper == '+'){
            res = num1+num2;
        }
        if(oper == '-'){
            res = num2 - num1;  //注意顺序
        }
        if(oper == '*'){
            res = num1*num2;
        }
        if(oper == '/'){
            res = num2/num1;  //注意顺序
        }
        return res;
    }

}
