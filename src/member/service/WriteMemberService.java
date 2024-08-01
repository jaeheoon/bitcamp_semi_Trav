package member.service;

import java.util.Scanner;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import semi.main.Interfa;

public class WriteMemberService implements Interfa {
	private String name;
	private String id;
	private String pwd;
	private String phone;
	private String address;

	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		MemberDAO memberDAO = MemberDAO.getInstance();
		boolean check = false;
		int su = 0;
		
		System.out.println();
		System.out.print("이름 입력 : ");
		name = sc.nextLine();
		
		do {
			System.out.print("아이디 입력 : ");
			id = sc.nextLine();
			check = memberDAO.isExist(id, "id");
			if (!check) {
				System.out.println("사용 가능한 아이디입니다");
				break;
			}
		} while(check);
		
		System.out.print("비밀번호 입력 : ");
		pwd = sc.nextLine();
		
		check = false;
		do {
			System.out.print("핸드폰 입력(010-xxxx-xxxx) : ");
			phone = sc.nextLine();
			check = memberDAO.isExist(phone, "phone");
			if (!check) {
				System.out.println("사용 가능한 번호입니다");
				break;
			}
		} while(check);
		
		System.out.print("주소 입력 : ");
		address = sc.nextLine();
		
		memberDTO = new MemberDTO(name, id, pwd, phone, address);
		
		su = memberDAO.write(memberDTO);
		if(su != 0) {
			System.out.println("회원가입 완료");
			System.out.println(memberDTO.toString());
		}
		else System.out.println("회원가입 실패");
	}
	
}
