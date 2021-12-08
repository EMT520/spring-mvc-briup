package com.briup.exception;

public class TestException {
    public void method(){
        throw new RuntimeException("自定义运行时异常");
    }
    public static void main(String[] args)  {
        //方式1
        //System.out.println(1/0);
        //2.方式2：调用方法 需要显示处理异常信息
        //Class.forName("a.b.c");
        //3.方式3：
        /*int a = 1;
        int b = 1;
        if(a == b){
           throw new Exception("自定义的异常");
        }*/
        //new TestException().method();
//        String s = null;
//        int length = s.length();
//        System.out.println(length);
        int a = 1;
        int b = 1;
        if(a == b){
            //throw new StudentException("密码错误");//Exception
            //当异常类型为运行时异常(非检查异常) 不需要程序显式处理异常
            //当程序运行时进行异常处理
            throw  new RuntimeException("密码错误");
        }
    }
}
