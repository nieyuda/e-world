package com.seckill.dao;

import com.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * @program: izhao
 * @description: 面向实体的接口基类，就是一个dao，可以进行对实体增删改查
 * @author: Mr.Yooda
 * @create: 2018-03-06 20:51
 **/

public interface SeckillDao {
    /**
    * @Description: 减库存的方法
    * @Param: [seckillId, killTime]
    * @return: int
    * @Author: Mr.Yooda
    * @Date: 2018/3/6
    */
    int reduceNumber(long seckillId, Date killTime);
    /**
     * @Description:  查询接口
    * @Param: [seckilled]
    * @return: com.seckill.entity.Seckill
    * @Author: Mr.Yooda
    * @Date: 2018/3/6
    */
    Seckill queryById(long seckilled);
    /** 
    * @Description: 根据偏移量查询 
    * @Param: [offet, limit] 
    * @return: java.util.List<com.seckill.entity.Seckill> 
    * @Author: Mr.Yooda 
    * @Date: 2018/3/6 
    */ 
    List<Seckill> queryAll(int offet, int limit);


}
