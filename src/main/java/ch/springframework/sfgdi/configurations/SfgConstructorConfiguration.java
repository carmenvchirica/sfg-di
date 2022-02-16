package ch.springframework.sfgdi.configurations;


import com.sun.security.jgss.GSSUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("ch")
public class SfgConstructorConfiguration {

    private final String username;
    private final String password;
    private final String jdbcurl;

    public SfgConstructorConfiguration(String username, String password, String jdbcurl) {
        System.out.println("Creating SfgConstructorConfiguration!!! ");
        this.username = username;
        this.password = password;
        this.jdbcurl = jdbcurl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcurl() {
        return jdbcurl;
    }
}
