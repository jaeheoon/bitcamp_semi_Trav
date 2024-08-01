package member.service.admin;

import java.util.ArrayList;
import java.util.Scanner;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import member.service.Member;

public class AdminMemberListService implements Member {
	
	@Override
	public void execute(MemberDTO memberDTO) {
		MemberDAO memberDAO = MemberDAO.getInstance();
		ArrayList<MemberDTO> list = memberDAO.viewList();
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("회원번호\t이름\t아이디\t번호\t주소");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println(list);
		for (MemberDTO memberDTO2 : list) {
			System.out.println(memberDTO2.getMemberNo() + "\t" 
							 + memberDTO2.getName() + "\t" 
							 + memberDTO2.getId() + "\t"
							 + memberDTO2.getPhone() + "\t"
							 + memberDTO2.getAddress());
		}
		while(true) {
			System.out.println("메뉴로 돌아가기 : 0");
			System.out.print("선택 > ");
			num = sc.nextInt();
			if (num == 0) break;
			else System.out.println("다른 번호를 선택하셨습니다");
		}
	}

}
