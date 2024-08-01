package board.service;

import java.util.Scanner;

import board.dao.BoardDAO;
import member.bean.MemberDTO;

public class BoardWrite implements Board {
	private String travelno,subject, content, memberno;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		BoardDAO boardDAO = BoardDAO.getInstance();
		boolean ck = false;
		
		System.out.println();
		System.out.print("여행지 입력 : ");
		travelno = sc.next();
		System.out.print("제목 입력 : ");
		subject = sc.next();
		System.out.print("내용 입력 : ");
		content = sc.nextLine();
		System.out.print("작성자 입력 : ");
		memberno = sc.next();
		
		ck = false;
		if(travelno != null && subject != null && content != null && memberno != null) {
			ck = boardDAO.write(travelno,subject, content, memberno);
			if(ck) {
				System.out.println("작성하신 글이 등록되었습니다.");
			}
			else System.out.println("글 등록에 실패하였습니다");
		}else System.out.println("여행지, 제목, 내용, 작성자에 빈탄이 있습니다. 다시 입력해주세요");
		
		

	}

}
