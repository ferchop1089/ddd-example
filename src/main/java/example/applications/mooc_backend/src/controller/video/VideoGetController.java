package example.applications.mooc_backend.src.controller.video;

import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import example.src.mooc.video.application.VideoFinder;
import example.src.mooc.video.domain.Video;

@RestController
@RequestMapping("/ddd-example/videos")
public final class VideoGetController {

	private final VideoFinder finder;

	public VideoGetController(final VideoFinder finder) {
		this.finder = finder;
	}

	@GetMapping(value = "/{video_id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public VideoFindResponse find(@PathVariable("video_id") final String videoId) {
		return mapper(finder.find(videoId));
	}

	private VideoFindResponse mapper(final Video result) {
		final VideoFindResponse response = new VideoFindResponse();
		response.setVideoId(result.id().value());
		response.setTitle(result.title().value());
		response.setDescription(result.description().value());

		return response;
	}

}
