package com.seckill.dao;

import com.seckill.entity.SuccessKilled;

/**
 * @program: izhao
 * @description:
 * @author: Mr.Yooda
 * @create: 2018-03-06 20:59
 **/

public interface SuccessKilledDao {
    /** 
    * @Description: 插入购买明细，可以过滤重复
    * @Param: [seckillId, userPhone] 
    * @return: int 
    * @Author: Mr.Yooda 
    * @Date: 2018/3/6 
    */ 
    int insertSuccessKilled(long seckillId, long userPhone);
    /** 
    * @Description: 根据Id查询秒杀Successkilled明细，并且携带秒杀实体
    * @Param: [seckillId] 
    * @return: com.seckill.entity.SuccessKilled 
    * @Author: Mr.Yooda 
    * @Date: 2018/3/6 
    */ 
    SuccessKilled queryByIdWithSeckill(long seckillId);

    SuccessKilled queryByIdWithSeckill(long seckillId, long userPhone);
}
