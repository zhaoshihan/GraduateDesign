package ssm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ssm.config.base.PropertyConfig;
import ssm.controller.interceptor.TokenInterceptor;

import java.util.*;

/**
 *  对应于原先的spring-mvc.xml配置文件
 */
@Configuration
@ComponentScan(
        basePackages = {"ssm.config.base", "ssm.controller"}
) // 只扫描controller类
@EnableWebMvc
public class DispatcherConfig implements WebMvcConfigurer {

    @Autowired
    private PropertyConfig propertyConfig;

    /**
     * 配置jsp 显示ViewResolver
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix(propertyConfig.getWebViewPrefix());
        internalResourceViewResolver.setSuffix(propertyConfig.getWebViewSuffix());
        return internalResourceViewResolver;
    }

    /**
     * 设置统一错误处理要跳转的视图
     *
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.getProperty("java.lang.Exception", "error");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }

    /**
     * 添加静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(propertyConfig.getWebStaticHandler()).addResourceLocations(propertyConfig.getWebStaticResource()).setCachePeriod(propertyConfig.getWebStaticCachedPeriod());
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加TokenInterceptor拦截器
        // 设置除登陆页面外，其他的都要先执行拦截器
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/member/login");
    }

//    @Bean
//    public TokenInterceptor getTokenHeader(){
//        return new TokenInterceptor();
//    }


//    /**
//     * 相当于<mvc:annotation-driven/>的一部分，注册DefaultAnnotationHandlerMapping
//     * Spring MVC 3.1 以上改为RequestMappingHandlerMapping
//     *
//     * 解决@Controller使用的前提配置
//     *
//     * @return
//     */
//    @Bean
//    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
//        return requestMappingHandlerMapping;
//    }

//    /**
//     * 相当于<mvc:annotation-driven/>的一部分，用于进行json的网络格式传输转换
//     *
//     * @return
//     */
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//
//        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(
//                new ArrayList<>(Arrays.asList(
//                        MediaType.APPLICATION_JSON_UTF8,
//                        MediaType.TEXT_HTML
//                ))
//        );
//        return mappingJackson2HttpMessageConverter;
//    }

//    /**
//     * 相当于<mvc:annotation-driven/>的一部分，注册AnnotationMethodHandlerAdapter
//     * Spring MVC 3.1 以上改为RequestMappingHandlerAdapter
//     *
//     * 解决@Controller使用的前提配置
//     *
//     * @return
//     */
//    @Bean
//    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
//        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
//
//        requestMappingHandlerAdapter.getMessageConverters().add(mappingJackson2HttpMessageConverter);
//
//        return requestMappingHandlerAdapter;
//    }

//    /**
//     * 相当于<mvc:annotation-driven/>的一部分，注册AnnotationMethodHandlerExceptionResolver
//     * Spring MVC 3.1 以上改为 ExceptionHandlerExceptionResolver
//     *
//     * 解决@Controller使用的前提配置
//     *
//     * @return
//     */
//    @Bean
//    public ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver() {
//        ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver = new ExceptionHandlerExceptionResolver();
//        return exceptionHandlerExceptionResolver;
//    }


//    /**
//     * 相当于<mvc:default-servlet-handler/>的一部分
//     *
//     * @return
//     */
//    @Bean
//    public DefaultServletHttpRequestHandler defaultServletHttpRequestHandler() {
//        DefaultServletHttpRequestHandler defaultServletHttpRequestHandler = new DefaultServletHttpRequestHandler();
//        return defaultServletHttpRequestHandler;
//    }
//
//    /**
//     * 相当于<mvc:default-servlet-handler/>的一部分
//     *
//     * @return
//     */
//    @Bean
//    public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
//        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
//        return simpleUrlHandlerMapping;
//    }
//
//    /**
//     * 相当于<mvc:default-servlet-handler/>的一部分
//     *
//     * @return
//     */
//    @Bean
//    public HttpRequestHandlerAdapter httpRequestHandlerAdapter() {
//        HttpRequestHandlerAdapter httpRequestHandlerAdapter = new HttpRequestHandlerAdapter();
//        return httpRequestHandlerAdapter;
//    }
}
