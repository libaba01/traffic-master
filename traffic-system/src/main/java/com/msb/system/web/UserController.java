package com.msb.system.web;

import com.libaba.api.code.SystemCode;
import com.libaba.api.commons.ResponseResult;
import com.libaba.api.commons.ResponseResultFactory;
import com.libaba.api.commons.SystemUtils;
import com.msb.system.entity.UserEntity;
import com.msb.system.info.UserInfo;
import com.msb.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.libaba.api.code.SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_RESULT_NULL;

@RestController   //是Controller和ResponseBody的合体
@RequestMapping("/user")
public class UserController {
    //在那个类里面打印日志
    Logger logger= LoggerFactory.getLogger(UserController.class);

    final static int NAME_LENGTH=3;
    final static int ACCOUNT_LENGTH=6;
    final static int PASS_LENGTH=6;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseResult addUser(UserEntity userEntity){
        //ResponseResult responseResult=new ResponseResult();

        logger.info("system user addUser start");
        //参数为空
        if(SystemUtils.isNull(userEntity)){
            logger.error("system user adduser uname is null");
            ResponseResult responseResult= ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PARAM_NULL);
            logger.info("system user addUser return msg:"+responseResult);
            return responseResult;
        }


        //用户名为空
        if(SystemUtils.isNullOrEmpty(userEntity.getUname())){
            logger.error("syastem user adduser uname is null");
            logger.info("param:"+userEntity);
            ResponseResult responseResult= ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_NAME_NULL);
            logger.info("system user addUser return msg:"+responseResult);
            return responseResult;
        }

        //账号为空
        if(SystemUtils.isNullOrEmpty(userEntity.getUaccount())){
            logger.error("syastem user adduser uaccount is null");
            logger.info("param:"+userEntity);
            ResponseResult responseResult= ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_ACCOUNT_NULL);
            logger.info("system user addUser return msg:"+responseResult);
            return responseResult;
        }

        //密码为空
        if(SystemUtils.isNullOrEmpty(userEntity.getUaccount())){
            logger.error("syastem user adduser upass is null");
            logger.info("param:"+userEntity);
            ResponseResult responseResult= ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PASS_NULL);
            logger.info("system user addUser return msg:"+responseResult);
            return responseResult;
        }
        //手机为空
        if(SystemUtils.isNullOrEmpty(userEntity.getUaccount())){
            logger.error("syastem user adduser uphone is null");
            logger.info("param:"+userEntity);
            ResponseResult responseResult= ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PHONE_NULL);

            logger.info("system user addUser return msg:"+responseResult);
            return responseResult;
        }
        //用户名小于三个长度
        if(userEntity.getUname().trim().length()<NAME_LENGTH){
            logger.error("syastem user adduser uname length<3");
            logger.info("param:"+userEntity);
            ResponseResult responseResult= ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_NAME_SIZE);
            logger.info("system user addUser return msg:"+responseResult);
            return responseResult;
        }

        //账号长度小于6
        if(userEntity.getUaccount().trim().length()<ACCOUNT_LENGTH){
            logger.error("syastem user adduser uaccount length<6");
            logger.info("param:"+userEntity);
            ResponseResult responseResult= ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_ACCOUNT_SIZE);
            logger.info("system user addUser return msg:"+responseResult);
            return responseResult;
        }

        //密码长度小于6
        if(userEntity.getUpass().trim().length()<PASS_LENGTH){
            logger.error("syastem user adduser upass length<6");
            logger.info("param:"+userEntity);
            ResponseResult responseResult= ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PASS_SIZE);
            logger.info("system user addUser return msg:"+responseResult);
            return responseResult;
        }


        //密码的加密操作
        logger.info("system user addUser pass digest");
        userEntity.setUpass(DigestUtils.md5DigestAsHex(userEntity.getUpass().getBytes()));


        //保存用户信息
        logger.info("system user addUser userService addUser start");
        boolean result=userService.addUser(userEntity);
        logger.info("system user addUser userService addUser end :"+result);

        //根据保存结果返回给前台信息
        ResponseResult responseResult;
        if(result){
            responseResult=ResponseResultFactory.buildResponseResult();
        }else {
            responseResult=ResponseResultFactory.buildResponseResult(SYSTEM_USER_ERROR_ADD_FAIL_RESULT_NULL);
        }

        logger.info("system user addUser end,return :"+responseResult);
        return responseResult;



    }

}
