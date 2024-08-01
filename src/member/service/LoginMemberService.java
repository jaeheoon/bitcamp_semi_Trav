package member.service;

import java.util.Scanner;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginMemberService implements Member {
	private String id;
	private String pwd;
	
	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			if(memberDTO.getName() != null) {
				System.out.println("새로 로그인 하시겠습니까?");
			} else break;
			System.out.println("Y/N");
			String chk = sc.next();
			if (chk.toLowerCase().equals("y")) {
				memberDTO.clear();
				break;
			}
			else if (chk.toLowerCase().equals("n")) return;
			else System.out.println("Y or N 중 입력해주세요");
		}
		
		System.out.println();
		System.out.print("아이디 : ");
		id = sc.next();
		System.out.print("비밀번호 : ");
		pwd = sc.next();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDTO = memberDAO.loginInfo(id, pwd, memberDTO);
		if (memberDTO.getName() != null) {
			String name = memberDTO.getName();
			System.out.println(name + "님이 로그인하였습니다");
		} else {
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
		}
	}

}
