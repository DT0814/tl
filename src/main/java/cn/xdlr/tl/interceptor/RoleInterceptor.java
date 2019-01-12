package cn.xdlr.tl.interceptor;

import cn.xdlr.tl.pojo.ClientAcode;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.service.ClientAcodeService;
import cn.xdlr.tl.utils.JsonUtils;
import cn.xdlr.tl.utils.ResultCode;
import cn.xdlr.tl.utils.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class RoleInterceptor implements HandlerInterceptor {
    private ClientAcodeService service;

    public RoleInterceptor(ClientAcodeService service) {
        this.service = service;
    }

    PrintWriter writer = null;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request.getParameter("cid") == null) {
            return true;
        }
        Integer cid = Integer.valueOf(request.getParameter("cid"));
        String acode = request.getParameter("Acode");
        System.out.println(acode);
        ClientAcode byId = service.findById(cid);
        if (null == byId || StringUtil.isEmpty(byId.getAcode())) {
            try {
                writer = response.getWriter();
                writer.write(JsonUtils.objectToJson(SimpleResult.getInstance(ResultCode.ACODE_NO_EQUALS)));
                return false;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        }
        if (acode.equals(byId.getAcode())) {
            return true;
        } else {
            try {
                writer = response.getWriter();
                SimpleResult instance = SimpleResult.getInstance(ResultCode.ACODE_NO_EQUALS);
                writer.write(JsonUtils.objectToJson(instance));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
            return false;
        }
    }
}
