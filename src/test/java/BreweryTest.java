import org.junit.Before;
import org.junit.Test;


import java.util.HashMap;

import entitiy.Brewery;
import entitiy.Resource;
import entitiy.ResourceType;
import entitiy.Storage;

/**
 * Created by marcel on 13.10.17.
 */

public class BreweryTest {
	Brewery brewery = new Brewery();
	Storage storage = new Storage();
	Resource beer5 = new Resource(ResourceType.BEER, 5);
	Resource water5 = new Resource(ResourceType.WATER, 5);
	Resource hop5 = new Resource(ResourceType.HOPS, 5);

	@Before
	public void setUp() {
		brewery.setLager(storage);
		HashMap<Resource, Integer> resources = new HashMap<>();
		resources.put(beer5, 5);
		resources.put(water5, 5);
		resources.put(hop5, 5);
		storage.setResources(resources);

	}


	@Test
	public void brew() {
		brewery.brew();

		assertEquals((Integer) 6, brewery.getLager().getResources().get(beer5));

	}

}

