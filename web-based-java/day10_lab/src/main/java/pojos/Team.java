package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

	@Column(name = "name", length = 20, unique = true)
	private String name;

	@Column(name = "abbreviation", length = 20, unique = true)
	private String abbreviation;

	@Column(name = "owner", length = 20)
	private String owner;

	@Column(name = "max_age", length = 20)
	private int maxAge;

	@Column(name = "min_batting_avg")
	private double minBattingAvg;

	@Column(name = "min_wickets_taken")
	private int minWicketsTaken;

	@OneToMany(mappedBy = "team", cascade = { CascadeType.ALL }, orphanRemoval = true/*, fetch = FetchType.EAGER*/)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE)
	private List<Player> playerList = new ArrayList<Player>();

	public Team() {
		System.out.println("in team default constructor ...!");
	}

	public Team(String name, String abbreviation, String owner, int maxAge, double minBattingAvg, int minWicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getMinBattingAvg() {
		return minBattingAvg;
	}

	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}

	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner + ", maxAge=" + maxAge
				+ ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken + "]";
	}

	public void addPlayer(Player p) {
		playerList.add(p);
		p.setTeam(this);
	}

	public void removePlayer(Player p) {
		playerList.remove(p);
		p.setTeam(null);
	}

}
