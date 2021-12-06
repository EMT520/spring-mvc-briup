package com.briup.exception;

public class TestException {
    public void method(){
        throw new RuntimeException("自定义运行时异常");
    }
    public static void main(String[] args) throws Exception {
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
        new TestException().method();
    }
}
