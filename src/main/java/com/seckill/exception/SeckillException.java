package com.seckill.exception;

/**
 * @program: izhao
 * @description: 所有秒杀相关异常
 * @author: Mr.Yooda
 * @create: 2018-03-08 15:15
 **/

public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
