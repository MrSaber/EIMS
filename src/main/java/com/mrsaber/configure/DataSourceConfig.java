package com.mrsaber.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 【阿里巴巴数据源配置Bean】
 */
@Configuration
@PropertySource("classpath:prop.properties")
public class DataSourceConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.maxActive}")
    private int maxActive;
    @Value("${jdbc.maxIdel}")
    private int maxIdel;
    @Value("${jdbc.maxWait}")
    private long maxWait;

    @Bean
    public DataSource dataSource()
    {
        DruidDataSource dataSource= new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        dataSource.setInitialSize(5);
        return dataSource;
    }

    @Bean
    public ServletRegistrationBean druidServlet()
    {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("loginUsername", "admin");// 用户名
        initParameters.put("loginPassword", "123456");// 密码
        initParameters.put("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能
        initParameters.put("allow", ""); // IP白名单 (没有配置或者为空，则允许所有访问)
        //initParameters.put("deny", "192.168.20.38");// IP黑名单 (存在共同时，deny优先于allow)
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }
}
