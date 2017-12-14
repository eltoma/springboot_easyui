package com.lab.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.lab.constant.Constant.SESSIONKEY_USER_NAME;

/**
 * Created by elotoma on 2017/12/1.
 */
public class AuthorityInterceptor implements HandlerInterceptor{

    private final String REQ_START_TIME = "req_start_time";
    private final ArrayList<String> allowedUrls = new ArrayList<String>();

    {
        allowedUrls.add("/");
        allowedUrls.add("/login");
        // allowedUrls.add("/")
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {

        // 在Session中设置请求开始时间
        httpServletRequest.setAttribute(REQ_START_TIME, new Date());

        if(isAllowedUrl(httpServletRequest.getRequestURI())) {
            return true;
        } else {
            // @TODO 暂时屏蔽权限过滤功能
            return true;
            // return hasAuthority(httpServletRequest, httpServletResponse);
        }
    }

    /**
     * 检查是否拥有对所请求路径资源的访问权限
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    private boolean hasAuthority(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        HttpSession session = httpServletRequest.getSession();
        String userName = (String) session.getAttribute(SESSIONKEY_USER_NAME);
        String path = httpServletRequest.getRequestURI();

        // 根目录作为系统入口，不用登录即可访问
        if("/".equals(path)) {
            return true;
        }

        if(userName == null) {
            try {
                httpServletResponse.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        return true;
    }

    private boolean isAllowedUrl(String url) {
        return allowedUrls.contains(url);
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("请求被处理之后");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        StringBuilder sb = new StringBuilder();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        Date startTime = (Date)httpServletRequest.getAttribute(REQ_START_TIME);

        sb.append("\n======================================================");
        sb.append("\n-- 请求URL：" + httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());
        sb.append("\n-- 请求时间：" + df.format(startTime));
        sb.append("\n-- 持续时间：" + Long.valueOf(System.currentTimeMillis() - startTime.getTime()));
        if(e != null) {
            sb.append("\n-- 异常信息：" + e.getMessage());
        }
        sb.append("\n======================================================\n");

        System.out.println(sb.toString());
    }
}
