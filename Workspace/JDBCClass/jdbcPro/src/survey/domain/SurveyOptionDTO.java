package survey.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SurveyOptionDTO {

	private int surveyId;
	private int optionId;
	private int optionCnt;
	private String optionContent;
	
	
	
	
	
}
