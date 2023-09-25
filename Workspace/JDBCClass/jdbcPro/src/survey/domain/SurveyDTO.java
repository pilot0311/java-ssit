/**
 * 
 */
package survey.domain;

import java.sql.Date;

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
public class SurveyDTO {
	private int surveyId;
	private String userId;
	private Date startDate;
	private Date endDate;
	private String title;
	private int optionList;
	private int surveyAllCnt;

}
