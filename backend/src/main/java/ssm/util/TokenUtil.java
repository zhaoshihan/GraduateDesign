package ssm.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    // 定义token的过期时间，单位是毫秒，15min
    private static final long EXPIRE_TIME = 15 * 60 * 1000;
    // 定义token的私钥密码
    private static final String TOKEN_SECRET = "TheFirstTokenKey";
    // 定义token pyload部分的声明
    private static final String ISSUER = "zsh_backend";


    /**
     * 生成签名，15min过期
     *
     * @param userId
     * @return
     */
    public static String sign(long userId) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            // 当前时间
            Date currentTime = new Date(currentTimeMillis);
            // 设置过期时间
            Date expireTime = new Date(currentTimeMillis + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT"); // typ属性表示令牌(token)的类型
            header.put("alg", "HS256"); // alg属性表示签名的算法 HS256是HMAC SHA256的简写
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("id", userId)
                    .withIssuer(ISSUER)
                    .withIssuedAt(currentTime)
                    .withExpiresAt(expireTime)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检查token是否正确，保证3点
     * 第一，token signature部分是正确的，表明header，payload部分没有被破坏
     * 第二，token payload部分Issuer字段是正确的，是本服务器签发的
     * 第三，token payload部分exp字段没有到期
     *
     * @param token
     * @return
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT
                    .require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            verifier.verify(token); // 这里的verify自动对'exp'字段进行验证
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 从token中获得用户名
     *
     * @param token
     * @return
     */
    public static long getUserId(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("id").asLong();
        } catch (JWTDecodeException e){
            e.printStackTrace();
            return -1;
        }
    }
}
