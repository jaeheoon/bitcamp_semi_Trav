package board.service;

import java.util.Scanner;

import member.bean.MemberDTO;
import semi.main.Interfa;

public class BoardMenu implements Interfa{

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		if(memberDTO.getName() == null) {
			System.out.println();
			System.out.println("로그인 후 이용해주시기 바랍니다");
			System.out.println();
			return;
		}
		
		while(true) {
			System.out.println("BoardMenu 실행");
			System.out.println("board memberDTO" + memberDTO);
			num = sc.nextInt();
			if(num == 0) break;
		}
	}

}
