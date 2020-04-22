package ssm.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.io.IOException;

/**
 *  Spring Application Context 配置类
 *
 *  相当于原先的spring-mybatis.xml配置文件
 */
//表明此类是配置类
@Configuration
@ComponentScan(
        basePackages = {"ssm.config", "ssm.service"}, // 实例化DataSourceConfig, MybatisConfig和Service层的各对象
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class)
        }
)
@MapperScan("ssm.dao") // 对SqlSessionFactory的配置：setBasePackage, 扫描DAO层
@EnableTransactionManagement //开启事务管理
public class AppConfig {
    /**
     * 配置mybatis的SqlSessionFactoryBean
     *
     * @param dataSource
     * @param mybatisConfig
     * @return
     * @throws IOException
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory (DataSource dataSource, MybatisConfig mybatisConfig) throws IOException {
        // 定义 SQL Session Factory Bean
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 为 SQL Session Factory Bean 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 为 SQL Session Factory Bean 设置类型别名包
        sqlSessionFactoryBean.setTypeAliasesPackage(mybatisConfig.getMybatisTypeAliasPackage());

        // 为 SQL Session Factory Bean 设置映射
        // 获取mybatis-config.xml, 里面标注了resource[]字段
        PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(classPathResource.getResource(mybatisConfig.getMappingConfig()));

        return sqlSessionFactoryBean;
    }

    /**
     * 配置spring的声明式事务
     *
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }


//    @Bean(name = "SqlSessionFactory")
//    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, PropertyConfig propertyConfig) throws IOException {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        // 获取datasource字段
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        // 获取aliases字段
//        sqlSessionFactoryBean.setTypeAliasesPackage(propertyConfig.getMybatisTypeAliasPackage());
//
//        // 获取mybatis-config.xml, 里面标注了resource[]字段
//        PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setConfigLocation(classPathResource.getResource(propertyConfig.getMappingConfig()));
//
//        return sqlSessionFactoryBean;
//    }

    /**
     * 配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中
     *
     * @return
     */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        // 获取sqlSessionFactoryBean字段
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("SqlSessionFactory");
//        // 获取basePackage字段
//        mapperScannerConfigurer.setBasePackage("ssm.dao");
//
//        return mapperScannerConfigurer;
//    }


//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//        return propertySourcesPlaceholderConfigurer;
//    }
}
