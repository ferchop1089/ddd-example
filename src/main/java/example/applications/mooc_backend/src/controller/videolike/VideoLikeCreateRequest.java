package example.applications.mooc_backend.src.controller.videolike;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class VideoLikeCreateRequest {

	@JsonProperty("like_id")
	private String videoLikeId;

	@JsonProperty("video_id")
	private String videoId;

	@JsonProperty("student_id")
	private String studentId;

	public VideoLikeCreateRequest() {
	}

	public String getVideoLikeId() {
		return videoLikeId;
	}

	public String getVideoId() {
		return videoId;
	}

	public String getStudentId() {
		return studentId;
	}

}
