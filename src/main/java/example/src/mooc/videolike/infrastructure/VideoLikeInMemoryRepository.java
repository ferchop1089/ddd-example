package example.src.mooc.videolike.infrastructure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import example.src.mooc.videolike.domain.VideoLike;
import example.src.mooc.videolike.domain.VideoLikeRepository;

@Component
public final class VideoLikeInMemoryRepository implements VideoLikeRepository {

	private final Map<String, VideoLike> inMemory;

	public VideoLikeInMemoryRepository() {
		this.inMemory = new HashMap<String, VideoLike>();
	}

	@Override
	public void save(final VideoLike videoLike) {
		inMemory.put(videoLike.videoLikeId().value(), videoLike);
		System.out.println("Video like created.");
	}
}
