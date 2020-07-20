package example.applications.mooc_backend.src.controller.health_check;

import java.util.HashMap;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ddd-example/health-check")
public class HealthCheckGetController {

    @GetMapping(value = "/ping", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public HashMap<String, String> index() {
        final HashMap<String, String> status = new HashMap<>();
        status.put("status", "pong");

        return status;
    }

}