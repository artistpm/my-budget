package hu.nemethi.mybudget;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class MyBudgetTest {

    protected static HttpEntity<String> AUTH_HEADER;

    @Autowired
    protected TestRestTemplate restClient;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @LocalServerPort
    protected int port;

    protected URL baseApiUrl;

    @BeforeEach
    public void setupAPIUrl() {
        try {
            this.baseApiUrl = new URL("http://localhost:" + port);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
