package review.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ReviewDTO {
	private int reviewNo;
	@NonNull
	private String travelName;
	@NonNull
	private String continent;
	@NonNull
	private String memberId;
	@NonNull
	private String subject;
	@NonNull
	private String content;
	private String reviewComment;
	private String date;
	private double like;
	
	@Override
	public String toString() {
		return "리뷰 번호 : " + reviewNo + " 여행지명 : " + travelName + " 대륙 : " + continent + " 작성자 : " + memberId + " 제목 : " + subject + " 내용 : " + content
				+ "평점" + like + " 댓글 : " + reviewComment + " 작성 날짜 : " + date;
	}
}
