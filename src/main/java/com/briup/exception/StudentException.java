package com.briup.exception;

/**
 * 用户自定义的异常类
 */
public class StudentException extends Exception{
    public StudentException(){

    }
    public StudentException(String msg){
        super(msg);
    }
}
