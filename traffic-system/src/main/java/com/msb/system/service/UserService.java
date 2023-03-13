package com.msb.system.service;

import com.libaba.api.commons.SystemUtils;
import com.msb.system.entity.UserEntity;
import com.msb.system.info.UserInfo;
import com.msb.system.repostitory.UserRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {

    //添加用户
    public boolean addUser(UserEntity userEntity);
}
