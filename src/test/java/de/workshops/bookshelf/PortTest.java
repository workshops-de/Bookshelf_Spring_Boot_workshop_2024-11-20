package de.workshops.bookshelf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.EnabledIf;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("prod")
public class PortTest {

    @Value("${server.port:8080}")
    private int serverPort;

    @Test
    @EnabledIf(expression = "#{environment.acceptsProfiles('prod')}", loadContext = true)
    void testServerPort() {
        assertThat(serverPort).isEqualTo(8090);
    }


}
