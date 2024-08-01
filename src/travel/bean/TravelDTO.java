package travel.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TravelDTO {

	private int travel_no, function_no, func_like, filter;
	private String name, content;
	
	
}
