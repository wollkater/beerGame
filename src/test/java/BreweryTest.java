import junit.framework.TestCase;

import java.util.HashMap;

import entitiy.Brewery;
import entitiy.Resource;
import entitiy.ResourceType;
import entitiy.Storage;

/**
 * Created by marcel on 13.10.17.
 */
public class BreweryTest extends TestCase {

	Brewery brewery = new Brewery();
	Storage storage = new Storage();
	Resource beer5 = new Resource(ResourceType.BEER, 5);
	Resource water5 = new Resource(ResourceType.WATER, 5);
	Resource hop5 = new Resource(ResourceType.HOPS, 5);

	public void setUp() throws Exception {
		super.setUp();

		brewery.setLager(storage);
		HashMap<Resource, Integer> resources = new HashMap<>();
		resources.put(beer5, 5);
		resources.put(water5, 5);
		resources.put(hop5, 5);
		storage.setResources(resources);

	}

	public void testBrew() throws Exception {
		brewery.brew();

		assertEquals((Integer)6, brewery.getLager().getResources().get(beer5));

	}

}

