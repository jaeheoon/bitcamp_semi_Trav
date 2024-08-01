package member.service;

import java.util.Scanner;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import semi.main.Interfa;

public class DeleteMemberService implements Interfa {
	private String id;
	private String pwd;
	
	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			if(memberDTO.getName() != null) {
				System.out.println(memberDTO.getName() + "님 정말 탈퇴 하시겠습니까?");
			} else break;
			System.out.println("Y/N");
			String chk = sc.next();
			if (chk.toLowerCase().equals("y")) {
				break;
			}
			else if (chk.toLowerCase().equals("n")) return;
			else System.out.println("Y or N 중 입력해주세요");
		}
		
		System.out.println();
		id = memberDTO.getId();
		System.out.print("비밀번호 확인 : ");
		pwd = sc.next();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		boolean check = memberDAO.isExistPwd(id, pwd);
		if(!check) {
			System.out.println("비밀번호가 틀립니다");
			return;
		}
		
		System.out.println("삭제하시겠습니까? Y: 예, N: 아니오");
		String chk = sc.next();
		if (chk.toLowerCase().equals("y")) {
			boolean ck = memberDAO.deleteMember(id);
			if (ck) System.out.println("삭제 되었습니다");
			else System.out.println("실패 되었습니다");
		} else if (chk.toLowerCase().equals("n")) {
			System.out.println("취소되었습니다");
			return;
		} else System.out.println("Y or N 중 입력해주세요");
	}

}
