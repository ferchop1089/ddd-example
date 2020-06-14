package example.src.mooc.video.application;

import example.src.mooc.shared.domain.exceptions.NotExistException;
import example.src.mooc.shared.domain.video.VideoId;
import example.src.mooc.video.domain.Video;
import example.src.mooc.video.domain.VideoRepository;

public final class VideoFinder {

	private static final String VIDEO_NOT_EXIST_MESSAGE = "the video with the id '%s' not exist";

	private final VideoRepository repository;

	public VideoFinder(final VideoRepository repository) {
		this.repository = repository;
	}

	public final Video find(final String videoId) {
		final Video video = repository.search(new VideoId(videoId));
		validate(videoId, video);

		return video;
	}

	private final void validate(final String videoId, final Video video) {
		if (video == null) {
			throw new NotExistException(String.format(VIDEO_NOT_EXIST_MESSAGE, videoId));
		}
	}

}
