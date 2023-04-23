package com.excel.easy.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置MybatisPlus分页插件
 * <p>
 * *@MapperScan注解的作用相当于在com.excel.easy.mapper下的所有类上面添加@Mapper注解
 *
 * @author 154594742@qq.com
 * @date: 2021/2/22 10:02:00
 */
@Configuration
@MapperScan("com.excel.easy.db.mapper")
public class MybatisPlusConfig {

    /**
     * Mybatis-plus3.4.0版本过后使用MybatisPlusInterceptor分页插件
     * 注意：DbType.MYSQL必须为自己使用的数据库类型，否则分页不生效
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 设置useDeprecatedExecutor = false 避免缓存出现问题
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }
}
