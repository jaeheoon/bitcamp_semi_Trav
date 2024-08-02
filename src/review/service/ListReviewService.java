package review.service;

import java.util.ArrayList;

import member.bean.MemberDTO;
import review.bean.ReviewDTO;
import review.dao.ReviewDAO;
import semi.main.Interfa;

public class ListReviewService implements Interfa {

	@Override
	public void execute(MemberDTO memberDTO) {
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		ArrayList<ReviewDTO> list = reviewDAO.viewSearchList("t.travel_name", "");
		
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("  번호\t여행지명\t대륙명\t제목\t댓글\t평점\t작성자\t작성날짜");
		System.out.println("---------------------------------------------------------------------------------------");
		for (ReviewDTO reviewDTO : list) {
			System.out.println(reviewDTO.getReviewNo() + "\t"
							 + reviewDTO.getTravelName() + "\t" 
							 + reviewDTO.getContinent() + "\t"
							 + reviewDTO.getSubject() + "\t"
							 + reviewDTO.getLike() + "\t"
							 + reviewDTO.getMemberId() + "\t"
							 + reviewDTO.getDate());
		}
		System.out.println();
	}

}
