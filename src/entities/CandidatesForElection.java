package entities;

import java.util.Objects;

public class CandidatesForElection {

	private String name;
	private Integer amountOfVotes;
	
	public CandidatesForElection() {
		
	}
	
	public CandidatesForElection(String name, Integer amountInteger) {
		this.name = name;
		this.amountOfVotes = amountInteger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmountOfVotes() {
		return amountOfVotes;
	}

	public void setAmountOfVotes(Integer amountOfVotes) {
		this.amountOfVotes = amountOfVotes;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amountOfVotes, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidatesForElection other = (CandidatesForElection) obj;
		return Objects.equals(amountOfVotes, other.amountOfVotes) && Objects.equals(name, other.name);
	}

	
	
	
	

	
}
