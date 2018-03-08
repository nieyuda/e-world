package com.seckill.exception;

import com.seckill.dto.SeckillExecution;

/**
 * @program: izhao
 * @description:重复秒杀异常
 * @author: Mr.Yooda
 * @create: 2018-03-08 15:11
 **/

public class RepeatKillException extends RuntimeException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
