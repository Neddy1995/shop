package com.xc.shop.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.FilterMatchUtil;
import com.xc.shop.util.SessionKeyValue;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
public class ActionInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = Logger.getLogger(ActionInterceptor.class);

    private static final List<String> UN_NEED_LOGIN_ACTION = new ArrayList<String>();

//    添加不用过滤的请求
    static {
        UN_NEED_LOGIN_ACTION.add("login.do");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute(SessionKeyValue.USER_KEY);
        String url = request.getRequestURI();

        // 无需校验的请求，如：登录，注册，忘记密码等
        if (FilterMatchUtil.isEndWithListStr(url, UN_NEED_LOGIN_ACTION)) {
            return true;
        }

        // 未登录，直接返回：认证失败
        if (StringUtils.isEmpty(account)) {
            ControllerResult controllerResult = new ControllerResult();
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
            controllerResult.setMessage("未登陆！");
            returnError(response, JSONObject.toJSONString(controllerResult));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private void returnError(HttpServletResponse response, String errorMessage)
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            out.append(errorMessage);
        }
        catch (IOException e)
        {
            logger.error("ActionFilter response error:", e);
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
        }
    }
}
