package member.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 24.07.30(화) Member DTO class
 * @author 홍재헌
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class MemberDTO {
	private int memberNo;
	@NonNull
	private String name;
	@NonNull
	private String id;
	@NonNull
	private String pwd;
	@NonNull
	private String phone;
	@NonNull
	private String address;
	private int admin;
	
	public void clear() {
		this.memberNo = 0;
		this.name = null;
		this.id = null;
		this.pwd = null;
		this.phone = null;
		this.address = null;
		this.admin = 0;
	}
	
	@Override
	public String toString() {
		return "회원 번호 : " + memberNo + " 이름 : " + name + " 아이디 : " + id + " 비밀번호 : " + pwd + " 핸드폰 : " + phone 
				+ " 주소 : " + address + " 관리자 : " + admin;
	}
	
	
}
