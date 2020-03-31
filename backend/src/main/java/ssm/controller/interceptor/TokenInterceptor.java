package ssm.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import ssm.util.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义token拦截器
 */
@Component("TokenInterceptor")
@CrossOrigin(origins = "*")
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("进入拦截器");
        if (request.getMethod().equals("OPTIONS")){
            // 使用axios，每次前端发送请求，都会先发一次预请求，也就是RequestMethod为OPTIONS
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("auth_token");
        if (token != null){
            boolean result = TokenUtil.verify(token);
            if(result){
                System.out.println("通过拦截器");
                return true;
            }
        }
        System.out.println("拦截器认证失败");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

}
