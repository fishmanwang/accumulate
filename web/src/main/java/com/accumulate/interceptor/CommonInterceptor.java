package com.accumulate.interceptor;

import com.accumulate.base.constant.CommonConstants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置访问NoCache，设置用户信息到Request
 *
 * Created by tjwang on 2016/9/12.
 */
public class CommonInterceptor implements HandlerInterceptor {


    /**
     * 在业务处理器处理请求之前被调用 如果返回false
     * 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链，同时需要通过response来产生响应；
     *
     * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
     * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            return true;
        }
        Session session = SecurityUtils.getSubject().getSession(false);
        if (session != null) {
            request.setAttribute(CommonConstants.CURRENT_USER, session.getAttribute(CommonConstants.CURRENT_USER));
            request.setAttribute(CommonConstants.USERNAME, session.getAttribute(CommonConstants.USERNAME));
            request.setAttribute(CommonConstants.EMAIL, session.getAttribute(CommonConstants.EMAIL));
        }

        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作(non-Javadoc)
     *
     * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse, java.lang.Object,
     *      org.springframework.web.servlet.ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }

}
