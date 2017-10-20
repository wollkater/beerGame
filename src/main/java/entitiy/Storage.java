package entitiy;

import java.util.HashMap;

/**
 * Created by marcel on 12.10.17.
 */
public class Storage {
	private HashMap<Resource, Integer> resources;

	public HashMap<Resource, Integer> getResources() {
		return resources;
	}

	public void setResources(HashMap<Resource, Integer> resources) {
		this.resources = resources;
	}
}
