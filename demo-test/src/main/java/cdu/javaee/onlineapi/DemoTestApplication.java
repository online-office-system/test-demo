package cdu.javaee.onlineapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 这里我加了 exclude = DataSourceAutoConfiguration.class 是为了在项目没配置数据库的时候排除检测数据库。有数据库时删掉这句话
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DemoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTestApplication.class, args);
    }

}
