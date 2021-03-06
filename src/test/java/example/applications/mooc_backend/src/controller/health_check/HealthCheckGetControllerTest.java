package example.applications.mooc_backend.src.controller.health_check;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import example.applications.ApplicationTestCase;

public final class HealthCheckGetControllerTest extends ApplicationTestCase {

    @Test
    public void successfulRequest() throws Exception {
        assertResponse(HttpMethod.GET, "/ddd-example/health-check/ping", "{\"status\":\"pong\"}", HttpStatus.OK);
    }

}