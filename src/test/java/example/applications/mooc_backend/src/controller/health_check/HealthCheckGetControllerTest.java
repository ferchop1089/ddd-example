package example.applications.mooc_backend.src.controller.health_check;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import example.applications.ApplicationTestCase;

public final class HealthCheckGetControllerTest extends ApplicationTestCase {

    @Test
    public void successfulRequest() throws Exception {
        assertResponse(HttpMethod.GET, "/ddd-example/health-check/ping", 200, "{\"status\":\"pong\"}");
    }

}