package demo.dongguabai.tx.dongguabaidtx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author dongguabai
 * @date 2019-03-09 01:40
 */
@Configuration
public class JdbcConfig {

    /**
     * 配置 DataSource
     * @return
     */
    @Bean
    public DataSource dataSource1(){
        // JDBC模板依赖于连接池来获得数据的连接，所以必须先要构造数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.16.140.135:3306/Demo1");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    /**
     * 配置DataSource
     * @return
     */
    @Bean
    public DataSource dataSource2(){
        // JDBC模板依赖于连接池来获得数据的连接，所以必须先要构造数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.16.140.135:3306/Demo2");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    /**
     * 配置 JdbcTemplate
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource dataSource1) {
        return new JdbcTemplate(dataSource1);
    }

    /**
     * 配置 JdbcTemplate
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate2(DataSource dataSource2) {
        return new JdbcTemplate(dataSource2);
    }

    /**
     * 装配事务管理器
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager1(DataSource dataSource1) {
        return new DataSourceTransactionManager(dataSource1);
    }

    /**
     * 装配事务管理器
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager2(DataSource dataSource2) {
        return new DataSourceTransactionManager(dataSource2);
    }

}
