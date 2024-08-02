package travel.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class TravelDTO {
	@NonNull
	private String name;
	@NonNull
	private String content;
	@NonNull
	private String continent;
	private double like;
	
	@Override
	public String toString() {
		return "여행지명 : " + name + " 대륙 : " + continent + " 좋아요 : " + like + " 설명 : " + content;
	}
}
