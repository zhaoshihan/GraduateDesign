package ssm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class MybatisConfig {
    @Value("${mybatis.type.alias.package}")
    private String mybatisTypeAliasPackage;
    @Value("${mybatis.base.package}")
    private String mybatisBasePackage;
    @Value("${mybatis.mapping.config}")
    private String mappingConfig;

    public String getMybatisTypeAliasPackage() {
        return mybatisTypeAliasPackage;
    }

    public String getMybatisBasePackage() {
        return mybatisBasePackage;
    }

    public String getMappingConfig() {
        return mappingConfig;
    }

}
