import java.util.HashMap;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by marcel on 12.10.17.
 */
class BreweryTest {
	Brewery brewery = new Brewery();
	Storage storage = new Storage();
	Resource beer5 = new Resource(ResourceType.BEER, 5);
	Resource water5 = new Resource(ResourceType.WATER, 5);
	Resource hop5 = new Resource(ResourceType.HOPS, 5);

	@Before
	void setUp() {
		brewery.setLager(storage);
		HashMap<Resource, Integer> resources = new HashMap<>();
		resources.put(beer5, 5);
		resources.put(water5, 5);
		resources.put(hop5, 5);
		storage.setResources(resources);
	}

	@Test
	void brew() {
		brewery.brew();

		assertEquals((Integer)6, brewery.getLager().getResources().get(beer5));
	}

}
