package member.service;

import member.bean.MemberDTO;

public class LogoutMemberService implements Member {

	@Override
	public void execute(MemberDTO memberDTO) {
		System.out.println("logout start " + memberDTO);
		System.out.println();
		if (memberDTO != null) {
			memberDTO.clear();
			System.out.println("로그아웃 되었습니다");
			System.out.println();
		} else {
			System.out.println("로그인 되어있지 않습니다");
			System.out.println();
		}
		System.out.println("logout end " + memberDTO);
	}

}
