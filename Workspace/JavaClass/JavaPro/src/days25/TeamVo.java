package days25;

import java.util.Objects;

public class TeamVo {

	private String name;
	private String leader;
	private int totalNumber;
	
	public TeamVo(String name, String leader, int totalNumber) {
		this.name = name;
		this.leader = leader;
		this.totalNumber = totalNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamVo other = (TeamVo) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		
		return String.format("[%s(%d명) - %s]"
				, this.name, this.totalNumber, this.leader.replace("(팀장)", "")); 
	}
	
	
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return this.name.hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		TeamVo vo = (TeamVo) obj;
//		return this.name.equals(vo.name);
//	}
	
	
	
}
