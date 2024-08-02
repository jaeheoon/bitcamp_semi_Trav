package semi.menu;

import java.util.Scanner;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import review.bean.ReviewDTO;
import review.dao.ReviewDAO;
import semi.main.Interfa;
import travel.dao.TravelDAO;

public class WriteReviewService implements Interfa {
	private String travel;
	private String continent;
	private String subject;
	private String content;
	private int like;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		TravelDAO travelDAO = TravelDAO.getInstance();
		boolean check = false;
		int su = 0;
		
		System.out.println();
		do {
			System.out.print("작성할 나라 입력 : ");
			travel = sc.nextLine();
			check = travelDAO.isExist("travel_name", travel);
			if (check) System.out.println("작성 가능한 나라입니다");
			System.out.print("대륙 입력 : ");
			continent = sc.nextLine();
			check = false;
			check = travelDAO.isExist("continent", continent);
			if (check) System.out.println("확인되었습니다");
		} while(!check);
		System.out.print("제목 입력 : ");
		subject = sc.nextLine();
		System.out.print("내용 입력 : ");
		content = sc.nextLine();
		System.out.print("평점 입력(1 ~ 10점) : ");
		like = sc.nextInt();
		sc.nextLine();
		ReviewDTO reviewDTO = new ReviewDTO(travel, continent, memberDTO.getId(), subject, content);
		
		reviewDAO.write(reviewDTO);
		
		if(su != 0) {
			System.out.println("회원가입 완료");
			System.out.println(memberDTO.toString());
		}
		else System.out.println("회원가입 실패");
	}

}
