package com.xwtech.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class DemoFilter extends HttpServlet implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("==>DemoFilter启动");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将请求转换成HttpServletRequest 请求
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        String path = req.getContextPath();
//        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path;
//        HttpSession session = req.getSession(true);
//        String username = (String) session.getAttribute("username");
//        if (username == null || "".equals(username)) {
//            resp.setHeader("Cache-Control", "no-store");
//            resp.setDateHeader("Expires", 0);
//            resp.setHeader("Prama", "no-cache");
//            //此处设置了访问静态资源类
//            try {
//                resp.sendRedirect(basePath+"/index.html");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            // Filter 只是链式处理，请求依然转发到目的地址。
            log.info("过滤器启动");
            filterChain.doFilter(req, resp);
//        }
    }

    @Override
    public void destroy() {

    }
}
