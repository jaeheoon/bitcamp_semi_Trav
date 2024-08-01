package member.service;

import java.util.Scanner;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class UpdateMemberService implements Member {
	private String id;
	private String pwd;
	private String type;
	private String value;
	
	@Override
	public void execute(MemberDTO memberDTO) {
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		System.out.println();
		System.out.print("아이디 : ");
		id = sc.next();
		System.out.print("비밀번호 : ");
		pwd = sc.next();
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDTO = memberDAO.loginInfo(id, pwd, memberDTO);
		if (memberDTO != null) {
			while(true) {
				System.out.println("이름\t아이디\t비밀번호\t휴대폰번호\t주소");
				System.out.print(memberDTO.getName() + "\t"
						+ memberDTO.getId() + "\t"
						+ memberDTO.getPwd() + "\t"
						+ memberDTO.getPhone() + "\t"
						+ memberDTO.getAddress());
				System.out.println();
				System.out.println();
				System.out.print("1.이름|2.아이디|3.비밀번호|4.휴대폰번호|5.주소|6.취소\n");
				num = sc.nextInt();
				sc.nextLine();
				if(num == 6) {
					System.out.println("취소되었습니다. 다시 시도해주세요");
					break;
				} else if(num == 1) {
					System.out.print("수정할 이름 : ");
					value = sc.nextLine();
					type = "name";
				} else if(num == 2) {
					System.out.print("수정할 아이디 : ");
					value = sc.nextLine();
					type = "id";
				} else if(num == 3) {
					System.out.print("수정할 비밀번호 : ");
					value = sc.nextLine();
					type = "pwd";
				} else if(num == 4) {
					System.out.print("수정할 전화번호 : ");
					value = sc.nextLine();
					type = "phone";
				} else if(num == 5) {
					System.out.print("수정할 주소 : ");
					value = sc.nextLine();
					type = "address";
				}
				boolean ck = memberDAO.updateMember(type, value, id, pwd);
				if(ck) System.out.println("수정되었습니다");
			}
		} else System.out.println("검색한 아이디가 없습니다");
	}

}
