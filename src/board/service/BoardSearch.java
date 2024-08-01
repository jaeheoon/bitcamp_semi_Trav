package board.service;

import java.util.Scanner;

import board.dao.BoardDAO;
import member.bean.MemberDTO;

public class BoardSearch implements Board {

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		BoardDAO boardDAO = BoardDAO.getInstance();
		int num;
		
		System.out.println();
		while(true) {
			System.out.println();
			System.out.println("board memberDTO" + memberDTO);
			
			System.out.println("----------후기 검색----------");
			System.out.println("----------------------------");
			System.out.println("1.제목 검색|2.내용 검색|3.작성자 검색|0.이전 메뉴 ");
			System.out.println("----------------------------");
			System.out.print("   선택 > ");
			num = sc.nextInt();
			
			if(num == 0) break;
			if(num == 1) {
				
			}else if(num==2) {
				
			}else if(num==3) {
				
			}else {
				System.out.println("0 ~ 3을 입력해주세요");
				continue;
			}
			
		}

	}

}
