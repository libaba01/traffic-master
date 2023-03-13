package com.msb.system.service;

import com.libaba.api.commons.SystemUtils;
import com.msb.system.entity.UserEntity;
import com.msb.system.info.UserInfo;
import com.msb.system.repostitory.UserRepostitory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

   final int ZERO=0;
    final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepostitory userRespository;


    //添加用户
    @Override
    public boolean addUser(UserEntity userEntity) {
        UserEntity user=null;
        logger.info("system user service addUser start :"+userEntity);
        logger.info("system user service addUser userRepository save start ");

        try {
            user = userRespository.save(userEntity);   //获取数据,如果数据不存在则insert
            logger.info("system user service addUser userRepository save end ");
            logger.info("user:"+user);
        } catch (Exception e) {
            logger.error("system user service addUser fail"+e);
            return false;
        }


        if(!SystemUtils.isNull(user) && user.getUid()!=ZERO){
            logger.info("system user service addUser success");
            return true;
        }
        logger.info("system user service addUser fail");
        return false;

    }
}
