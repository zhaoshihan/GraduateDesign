package ssm.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import ssm.util.TokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义token拦截器
 */
//@CrossOrigin(origins = "*")
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("enter interceptor");

        if (request.getMethod().equals("OPTIONS")){
            // 使用axios，每次前端发送请求，都会先发一次预请求，也就是RequestMethod为OPTIONS
            System.out.println("enter options for setting headers");
//            response.setHeader("Access-Control-Allow-Headers", "Auth_Token");
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("Authorization");
        if (token != null){
            boolean result = TokenUtil.verify(token);
            if(result){
                System.out.println("pass token interceptor");
                return true;
            }
        }
        System.out.println("fail to verify token by interceptor");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

}
