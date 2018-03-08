package com.seckill.exception;

/**
 * @program: izhao
 * @description: 秒杀关闭异常
 * @author: Mr.Yooda
 * @create: 2018-03-08 15:13
 **/

public class SeckillCloseException extends RuntimeException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
