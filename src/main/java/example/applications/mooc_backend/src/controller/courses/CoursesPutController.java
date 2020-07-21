package example.applications.mooc_backend.src.controller.courses;

import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ddd-example/courses")
public final class CoursesPutController {

    @PutMapping(value = "/{courses_id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@PathVariable("courses_id") final String idCourse, @RequestBody final CourseRequest request) {
        System.out.println("id: " + idCourse + ", request: " + request);
    }

}