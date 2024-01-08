package pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

	@Column(name = "first_name", length = 20)
	private String firstName;

	@Column(name = "last_name", length = 20)
	private String lastName;

	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "batting_avg")
	private double battingAvg;

	@Column(name = "wickets_taken")
	private int wicketsTaken;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;

	public Player() {
		System.out.println("in player default constructor ...!");
	}

	public Player(String firstName, String lastName, LocalDate dob, double battingAvg, int wicketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", battingAvg="
				+ battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
}
