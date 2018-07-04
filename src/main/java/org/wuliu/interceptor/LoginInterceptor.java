package org.wuliu.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.wuliu.entity.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

   //首先进入的方法
        System.out.println("preHandle");
        System.out.println(request.getServletPath());
        HttpSession session = request.getSession();
        Customer customer= (Customer) session.getAttribute("customer");
        String url=request.getRequestURI();
        if(url.indexOf("/check")>=0)
        {
            return true;
        }
        if(url.indexOf("/index")>=0)
        {
            return true;
        }
        if(url.indexOf("/register")>=0)
        {
            return true;
        }
        if(url.indexOf("/insert")>=0)
        {
            return true;
        }
        if(url.indexOf("/check")>=0)
        {
            return true;
        }
        if(url.indexOf("/found")>=0)
        {
            return true;
        }
        if(url.indexOf("/foundPassword")>=0)
        {
            return true;
        }
        if(url.indexOf("/findpro")>=0)
        {
            return true;
        }
        if(url.indexOf("/changepassword")>=0)
        {
            return true;
        }
        if(url.indexOf("/logout")>=0)
        {
            return true;
        }
        if(customer!=null){
            return true;
        }else{
         //   request.getRequestDispatcher("/WEB-INF/views/html/login.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/index");  //未登录自动跳转界面
            return false;
        }

    }
    //返回modelAndView之前执行

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle");
    }
    //执行Handler完成执行此方法

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion");
    }
}