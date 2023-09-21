package domain;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalgradeVO {
   private int grade;
   private int losal;
   private int hisal;
   private int cnt;
public SalgradeVO(int grade, int losal, int hisal) {
	this.grade = grade;
	this.losal = losal;
	this.hisal = hisal;
}
@Override
public int hashCode() {
	return Objects.hash(grade, hisal, losal);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	SalgradeVO other = (SalgradeVO) obj;
	return grade == other.grade && hisal == other.hisal && losal == other.losal;
}

   
   
}