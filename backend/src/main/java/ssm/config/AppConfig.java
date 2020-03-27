package ssm.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import ssm.config.base.PropertyConfig;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;

/**
 * 相当于原先的spring-mybatis.xml配置文件
 */
//表明此类是配置类
@Configuration
@ComponentScan(
        basePackages = {"ssm.config.base","ssm.service"}
)
@EnableTransactionManagement //开启事务管理
public class AppConfig {
    @Bean
    public DataSource dataSource(PropertyConfig propertyConfig) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(propertyConfig.getUser());
        dataSource.setPassword(propertyConfig.getPassword());
        dataSource.setJdbcUrl(propertyConfig.getUrl());
        dataSource.setDriverClass(propertyConfig.getDriver());
        return dataSource;
    }

    /**
     * 配置mybatis的SqlSessionFactoryBean
     *
     * @param dataSource
     * @param PropertyConfig
     *
     * @return
     */
    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, PropertyConfig propertyConfig) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 获取datasource字段
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 获取aliases字段
        sqlSessionFactoryBean.setTypeAliasesPackage(propertyConfig.getMybatisTypeAliasPackage());

        // 获取mybatis-config.xml, 里面标注了resource[]字段
        PathMatchingResourcePatternResolver classPathResource = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(classPathResource.getResource(propertyConfig.getMappingConfig()));

        return sqlSessionFactoryBean;
    }

    /**
     * 配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中
     *
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 获取sqlSessionFactoryBean字段
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("SqlSessionFactory");
        // 获取basePackage字段
        mapperScannerConfigurer.setBasePackage("ssm.dao");

        return mapperScannerConfigurer;
    }


    /**
     * 配置spring的声明式事务
     * @param DataSource
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;

    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
