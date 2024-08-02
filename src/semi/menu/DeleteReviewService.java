package semi.menu;

import java.util.ArrayList;
import java.util.Scanner;

import member.bean.MemberDTO;
import review.bean.ReviewDTO;
import review.dao.ReviewDAO;
import semi.main.Interfa;
import travel.bean.TravelDTO;
import travel.dao.TravelDAO;

public class DeleteReviewService implements Interfa {

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		int no = 0;
		
		System.out.println("여행지명\t대륙명\t평점\t설명");
		ArrayList<ReviewDTO> list = reviewDAO.viewSearchList("member_id", memberDTO.getId());
		System.out.println();
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
		System.out.println();
		System.out.print("삭제할 게시물 번호 : ");
		no = sc.nextInt();
		
		while(true) {
			System.out.println("게시물를 정말 삭제 하시겠습니까?");
			System.out.println("Y/N");
			String chk = sc.next();
			if (chk.toLowerCase().equals("y")) {
				boolean ck = reviewDAO.deleteReview(no);
				if (ck) System.out.println("삭제 되었습니다");
				else System.out.println("실패 되었습니다");
				break;
			} else if (chk.toLowerCase().equals("n")) return;
			else System.out.println("Y or N 중 입력해주세요");
		}
	}

}
