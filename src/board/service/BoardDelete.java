package board.service;

import java.util.Scanner;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class BoardDelete implements Board {

	@Override
	public void execute(MemberDTO memberDTO) {
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("회원 아이디 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pwd = sc.next();
		


	}

}
