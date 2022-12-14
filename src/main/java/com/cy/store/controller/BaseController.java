package com.cy.store.controller;

import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 控制层类的基类
 */
public class BaseController {
    public static final int OK=200;
    /**
     * 统一处理跑出的异常
     */
    @ExceptionHandler({ServiceException.class,FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result=new JsonResult<Void>(e);
        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        }else if(e instanceof ProductNotFoundException){
            result.setState(4006);
            result.setMessage("商品数据不存在");
        }else if(e instanceof UserNotFoundException){
            result.setState(5001);
            result.setMessage("用户数据不存在");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(5000);
            result.setMessage("用户密码错误");
        }
        else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        }else if (e instanceof UpdateException){
            result.setState(5001);
            result.setMessage("修改时产生异常");
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }else if (e instanceof AddressCountLimitException){
            result.setState(4003);
        }
        return result;
    }
    public final Integer getuidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
    public final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
