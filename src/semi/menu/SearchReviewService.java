package semi.menu;

import java.util.ArrayList;
import java.util.Scanner;

import member.bean.MemberDTO;
import review.bean.ReviewDTO;
import review.dao.ReviewDAO;
import semi.main.Interfa;
import travel.bean.TravelDTO;
import travel.dao.TravelDAO;

public class SearchReviewService implements Interfa {

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		String some = "";
		int num = 0;
		while(true) {
			System.out.println("---------------------------------------여행지 메뉴-------------------------------------");
			System.out.print("  1.제목 검색|2.내용 검색|3.작성자 검색|0.이전메뉴 \n");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.print("선택 > ");
			num = sc.nextInt();
			sc.nextLine();
			if (num == 0) break;
			System.out.print("검색할 단어 >");
			some = sc.nextLine();
			System.out.println("검색결과 : ");
				 if (num == 1) Search("subject", some);
			else if (num == 2) Search("r.content", some);
			else if (num == 3) Search("name", some);
			else {
				System.out.println("1 ~ 3번을 입력해주세요");
				continue;
			}
		    System.out.println();
		}
	}
	
	public void Search(String type, String value) {
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		ArrayList<ReviewDTO> list = reviewDAO.viewSearchList(type, value);
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("  번호\t여행지명\t대륙명\t제목\t내용\t댓글\t평점\t작성자\t작성날짜");
		System.out.println("---------------------------------------------------------------------------------------");
		for (ReviewDTO reviewDTO : list) {
			System.out.println(reviewDTO.getReviewNo() + "\t"
							 + reviewDTO.getTravelName() + "\t" 
							 + reviewDTO.getContinent() + "\t"
							 + reviewDTO.getSubject() + "\t"
							 + reviewDTO.getContent() + "\t"
							 + reviewDTO.getLike() + "\t"
							 + reviewDTO.getMemberId() + "\t"
							 + reviewDTO.getDate());
		}
		System.out.println();
	}

}
