
package example.applications.mooc_backend.src.controller.courses;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import example.applications.ApplicationTestCase;

public final class CoursesPutControllerTest extends ApplicationTestCase {

    @Test
    public void successfulRequest() throws Exception {
        assertRequestWithBody(HttpMethod.PUT, "/ddd-example/courses/id-123",
                "{\"name\":\"El mejor curso\", \"duration\":\"5 horas\"}", 201);
    }

}