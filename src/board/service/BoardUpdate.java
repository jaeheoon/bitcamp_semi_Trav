package board.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.bean.MemberDTO;

public class BoardUpdate implements Board {

	@Override
	public void execute(MemberDTO memberDTO) {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("회원번호 검색 : ");
		String member_no = scan.next();
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = boardDAO.getMember(member_no);
		
		if (boardDTO == null) {
			System.out.println("검색한 회원번호가 없습니다.");
			return;
		}
		
		System.out.println(boardDTO);
		
		System.out.print("수정할 여행지 입력 : ");
		String continent = scan.next();	
		System.out.print("수정할 제목 입력 : ");
	    String subject = scan.next();
		System.out.print("수정할 내용 입력 : ");
		String content = scan.next();	

	
		Map<String, String > map = new HashMap<>();
		map.put("continent",continent);
		map.put("subject", subject);
		map.put("content", content);
			
		int su = boardDAO.update(map);
		
		System.out.println(su+"개의 행을 수정하였습니다.");
		}

	}
	


