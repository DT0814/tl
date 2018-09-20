package cn.xdlr.tl.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class RoleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        System.out.println(null == session);
        Long acode = (Long) session.getAttribute("Acode");
        if (null == acode)
            session.setAttribute("Acode", System.currentTimeMillis());
        System.out.println("拦截成功" + acode + request.getParameter("Acode"));
        return true;
    }
}
