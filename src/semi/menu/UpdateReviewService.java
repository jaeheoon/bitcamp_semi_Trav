package semi.menu;

import java.util.ArrayList;
import java.util.Scanner;

import member.bean.MemberDTO;
import review.bean.ReviewDTO;
import review.dao.ReviewDAO;
import semi.main.Interfa;

public class UpdateReviewService implements Interfa {
	private String id;
	private String pwd;
	private int like;
	private String type;
	private String value;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int selNo = 0;
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		System.out.println();
		System.out.print("비밀번호 확인 : ");
		pwd = sc.next();
		if (!pwd.equals(memberDTO.getPwd())) {
			System.out.println("비밀번호가 일치하지않습니다.");
			return;
		} 
		
		while(true) {
			ArrayList<ReviewDTO> list = reviewDAO.viewSearchList("member_id", memberDTO.getId());
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("  번호\t여행지명\t대륙명\t제목\t내용\t평점\t작성자\t작성날짜");
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
			
			System.out.print("변경할 게시판 번호 선택\n");
			System.out.print("선택>");
			selNo = sc.nextInt();
			sc.nextLine();
			System.out.print("1.여행지명|2.대륙명|3.제목|4.내용|5.평점|6.취소\n");
			System.out.print("선택>");
			num = sc.nextInt();
			sc.nextLine();
			if(num == 6) {
				System.out.println("취소되었습니다. 다시 시도해주세요");
				break;
			} else if(num == 1) {
				System.out.print("수정할 여행지명 : ");
				value = sc.nextLine();
				type = "travel_name";
			} else if(num == 2) {
				System.out.print("수정할 대륙명 : ");
				value = sc.nextLine();
				type = "continent";
			} else if(num == 3) {
				System.out.print("수정할 제목 : ");
				value = sc.nextLine();
				type = "subject";
			} else if(num == 4) {
				System.out.print("수정할 내용 : ");
				value = sc.nextLine();
				type = "content";
			} else if(num == 5) {
				System.out.print("수정할 평점 : ");
				like = sc.nextInt();
				boolean ck = reviewDAO.updateFunclike(selNo, like, id);
				if(ck) System.out.println("수정되었습니다");
				break;
			}
			boolean ck = reviewDAO.updateReview(selNo, type, value, id);
			if(ck) System.out.println("수정되었습니다");
		}
		
	}

}
