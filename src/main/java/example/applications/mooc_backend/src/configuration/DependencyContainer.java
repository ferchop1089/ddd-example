package example.applications.mooc_backend.src.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import example.src.mooc.student.application.StudentSignUpper;
import example.src.mooc.student.domain.StudentRepository;
import example.src.mooc.video.application.VideoCreator;
import example.src.mooc.video.application.VideoFinder;
import example.src.mooc.video.domain.VideoRepository;
import example.src.mooc.videolike.application.VideoLikeCreator;
import example.src.mooc.videolike.domain.VideoLikeRepository;
import example.src.shared.domain.EventBus;

@Configuration(value = "MoocDependencyContainer")
public class DependencyContainer {

    @Bean
    public StudentSignUpper injectStudentSignUpper(StudentRepository repository) {
        return new StudentSignUpper(repository);
    }

    @Bean
    public VideoFinder injectVideoFinder(VideoRepository repository) {
        return new VideoFinder(repository);
    }

    @Bean
    public VideoCreator injectVideoCreator(VideoRepository repository, EventBus bus) {
        return new VideoCreator(repository, bus);
    }

    @Bean
    public VideoLikeCreator injectVideoLikeCreator(VideoLikeRepository repository, EventBus bus) {
        return new VideoLikeCreator(repository, bus);
    }

}