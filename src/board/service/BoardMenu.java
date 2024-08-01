package board.service;

import java.util.Scanner;

import member.bean.MemberDTO;

public class BoardMenu implements Board{

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		Board board = null;
		
		if(memberDTO.getName() == null) {
			System.out.println();
			System.out.println("로그인 후 이용해주시기 바랍니다");
			System.out.println();
			return;
		}
		
		while(true) {
			System.out.println("BoardMenu 실행");
			System.out.println("board memberDTO" + memberDTO);
			
			System.out.println("------------게시판------------");
			System.out.println("----------------------------");
			System.out.println("     1. 후기 작성 ");
			System.out.println("     2. 후기 수정 ");
			System.out.println("     3. 별점 남기기");
			System.out.println("     4. 후기 삭제 ");
			System.out.println("     5. 후기 검색 ");
			System.out.println("     0. 이전 메뉴 ");
			System.out.println("----------------------------");
			System.out.print("   선택 > ");
			num = sc.nextInt();
			
			if(num == 0) break;
			if(num == 1) board = new BoardWrite();
			else if(num==2) board = new BoardUpdate();
			//else if(num==3) board = new BoardLike();	
			else if(num==4) board = new BoardDelete();
			else if(num==5) board = new BoardSearch();
			else {
				System.out.println("0 ~ 5를 입력해주세요");
				continue;
			}
		}
	}

}
