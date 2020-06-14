package example.applications.mooc_backend.src.controller.video;

import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import example.src.mooc.video.application.VideoCreator;

@RestController
@RequestMapping("/ddd-example/videos")
public final class VideoPostController {

	private final VideoCreator creator;

	public VideoPostController(final VideoCreator creator) {
		this.creator = creator;
	}

	@PostMapping(value = "/{video_id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody final VideoCreateRequest video) {
		creator.create(video.getVideoId(), video.getTitle(), video.getDescription());
	}

}
