package com.seckill.service.impl;

import com.seckill.dao.SeckillDao;
import com.seckill.dao.SuccessKilledDao;
import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.entity.SuccessKilled;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import com.seckill.service.SeckillService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @program: izhao
 * @description: service的实现
 * @author: Mr.Yooda
 * @create: 2018-03-08 19:02
 **/
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    //注入service依赖
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKilledDao successKilledDao;
    //md5混淆
    private final String slat = "ysdfsadfdsdfasfd";

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,4);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if(seckill == null){
            return new Exposer(false,seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();

        if (nowTime.getTime() < startTime.getTime() ||nowTime.getTime() >endTime.getTime()){
            return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime()
            ,endTime.getTime());
        }
        String md5 = getMD5(seckillId);//to do md5的本质，是你给任意一个字符串，它可以转换为一个编码
        //MD5的一大特点就是不可逆
        return new Exposer(true,md5,seckillId) ;
    }

    private String getMD5(long seckillId){
        String base = seckillId+"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }//业务多处需要md5加密，所以抽象一个独立方法

    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws RepeatKillException, SeckillCloseException, SeckillException {
        try {
            if(md5==null||md5.equals(getMD5(seckillId))){
                throw new SeckillException("秒杀数据被重写");
            }
            Date nowTime = new Date();
            int updatCount = seckillDao.reduceNumber(seckillId,nowTime);
            if(updatCount<=0){
                throw new SeckillCloseException("Over");
            }else {
                //记录购买行为
                int insertCount = successKilledDao.insertSuccessKilled(seckillId,userPhone);
                if(insertCount<=0){
                    throw new RepeatKillException("Repeat Error");
                }else {
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId,userPhone);
                    return new SeckillExecution(seckillId,1,"秒杀成功",successKilled);
                }
            }

        }catch (Exception e){

            throw new SeckillException("seckill error"+e.getMessage());
        }

    }
}
