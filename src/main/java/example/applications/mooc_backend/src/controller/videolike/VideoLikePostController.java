package example.applications.mooc_backend.src.controller.videolike;

import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import example.src.mooc.videolike.application.VideoLikeCreator;

@RestController
@RequestMapping("/ddd-example/videos/like")
public final class VideoLikePostController {

	private final VideoLikeCreator creator;

	public VideoLikePostController(final VideoLikeCreator creator) {
		this.creator = creator;
	}

	@PostMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody final VideoLikeCreateRequest videoLike) {
		creator.create(videoLike.getVideoLikeId(), videoLike.getVideoId(), videoLike.getStudentId());
	}

}
