package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;

import java.util.List;

/*
    业务接口：站在使用者角度设计接口
    1.方法定义的粒度
    2.参数，越简练，越直接越好
    3.返回类型
 */
public interface SeckillService {
    /**
     * 查询所秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开始时，输出秒杀接口地址
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);
    /**
    * @Description: 执行秒杀操作
    * @Param: [seckillId, userPhone, md5]
    * @return: void
    * @Author: Mr.Yooda
    * @Date: 2018/3/8
    */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
    throws RepeatKillException,SeckillCloseException,SeckillException;

}

