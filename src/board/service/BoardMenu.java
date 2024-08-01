package board.service;

import java.util.Scanner;

import member.bean.MemberDTO;

public class BoardMenu implements Board{

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.println("BoardMenu 실행");
			System.out.println("board memberDTO" + memberDTO);
			num = sc.nextInt();
			if(num == 3) break;
		}
	}

}
