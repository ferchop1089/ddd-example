package example.applications.mooc_backend.src.controller.courses;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class CourseRequest {
    
    @JsonProperty("name")
    private String name;

    @JsonProperty("duration")
    private String duration;

    public CourseRequest() {
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setDuration(final String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("{").append("name: ").append(name).append(", duration: ").append(duration)
                .append("}").toString();
    }
}