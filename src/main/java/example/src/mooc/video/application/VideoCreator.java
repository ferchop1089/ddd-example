package example.src.mooc.video.application;

import example.src.mooc.shared.domain.video.VideoId;
import example.src.mooc.video.domain.Video;
import example.src.mooc.video.domain.VideoDescription;
import example.src.mooc.video.domain.VideoRepository;
import example.src.mooc.video.domain.VideoTitle;
import example.src.shared.domain.EventBus;

public final class VideoCreator {

	private final VideoRepository repository;
	private final EventBus bus;

	public VideoCreator(final VideoRepository repository, final EventBus bus) {
		this.repository = repository;
		this.bus = bus;
	}

	public void create(final String videoId, final String videoTitle, final String videoDescription) {
		final Video video = Video.create(new VideoId(videoId), new VideoTitle(videoTitle),
				new VideoDescription(videoDescription));

		repository.save(video);

		bus.publish(video.pullDomainEvents());
	}

}
