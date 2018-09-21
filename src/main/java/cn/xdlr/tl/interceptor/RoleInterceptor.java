package cn.xdlr.tl.interceptor;

import cn.xdlr.tl.pojo.ClientAcode;
import cn.xdlr.tl.service.ClientAcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class RoleInterceptor implements HandlerInterceptor {
    @Autowired
    private ClientAcodeService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        /*Integer cid = Integer.valueOf(request.getParameter("cid"));
        String acode = request.getParameter("Acode");
        ClientAcode byId = service.findById(cid);
        System.out.println(byId);
        System.out.println("拦截成功" + acode);*/
        return true;
    }
}
