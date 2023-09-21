package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SalgradeVO2 {
    private int grade;    // 등급
    private int losal;    // 최소 급여
    private int hisal;    // 최대 급여
    private int cnt;
    private List<EmpVO> empList; // 등급별 직원 목록

    public SalgradeVO2() {}
    
    public SalgradeVO2(int grade, int losal, int hisal) {
        this.grade = grade;
        this.losal = losal;
        this.hisal = hisal;
        this.empList = new ArrayList<>();
    }

    // Getter와 Setter 메서드
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getLosal() {
        return losal;
    }

    public void setLosal(int losal) {
        this.losal = losal;
    }

    public int getHisal() {
        return hisal;
    }

    public void setHisal(int hisal) {
        this.hisal = hisal;
    }

	

    public List<EmpVO> getEmpList() {
        return empList;
    }

    public void setEmpList(List<EmpVO> empList) {
        this.empList = empList;
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
		SalgradeVO2 other = (SalgradeVO2) obj;
		return grade == other.grade && hisal == other.hisal && losal == other.losal;
	}

	
    
    
    
}