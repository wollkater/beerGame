package entitiy;

/**
 * Created by marcel on 12.10.17.
 */
public abstract class Company {
	private User owner;
	private String name;
	private Storage lager;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Storage getLager() {
		return lager;
	}

	public void setLager(Storage lager) {
		this.lager = lager;
	}
}
