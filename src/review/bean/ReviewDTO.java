package review.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
	private String reviewNo;
	private String travelName;
	private String continent;
	private String memberId;
	private String subject;
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
