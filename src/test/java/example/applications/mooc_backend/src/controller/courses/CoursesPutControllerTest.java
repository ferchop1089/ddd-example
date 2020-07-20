
package example.applications.mooc_backend.src.controller.courses;

import org.junit.jupiter.api.Test;

import example.applications.ApplicationTestCase;

public final class CoursesPutControllerTest extends ApplicationTestCase {

    @Test
    public void test123() throws Exception {
        assertRequestWithBody("PUT", "/ddd-example/courses/id-123",
                "{\"name\":\"El mejor curso\", \"duration\":\"5 horas\"}", 201);
    }

}