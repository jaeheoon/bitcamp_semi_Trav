package member.service;

import java.util.ArrayList;
import java.util.Scanner;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import semi.main.Interfa;

public class AdminMemberListService implements Interfa {
	
	@Override
	public void execute(MemberDTO memberDTO) {
		MemberDAO memberDAO = MemberDAO.getInstance();
		ArrayList<MemberDTO> list = memberDAO.viewList();
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("	회원번호\t이름\t아이디\t번호\t주소");
		System.out.println("---------------------------------------------------------------------------------");
		for (MemberDTO memberDTO2 : list) {
			System.out.println(memberDTO2.getMemberNo() + "\t" 
							 + memberDTO2.getName() + "\t" 
							 + memberDTO2.getId() + "\t"
							 + memberDTO2.getPhone() + "\t"
							 + memberDTO2.getAddress());
		}
	}

}
