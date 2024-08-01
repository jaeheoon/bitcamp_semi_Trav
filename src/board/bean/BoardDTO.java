package board.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BoardDTO {
	
	private int review_no,travel_no,member_no;
	private String comment, content, subject, date;
	
	
	
}
