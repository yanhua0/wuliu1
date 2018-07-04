package org.wuliu.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 廖师兄
 * 2017-01-21 13:59
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handle(Exception e, HttpServletResponse response, HttpServletRequest request) throws IOException {

            logger.error("【系统异常】{}", e);
            response.sendRedirect(request.getContextPath()+"/index");  //未登录自动跳转界面
            return "系统未知错误！";

    }
}
