import java.util.HashMap;

/**
 * Created by marcel on 12.10.17.
 */
public class Brewery extends Company {

	final static int NEEDED_WATER = 4;
	final static int NEEDED_HOP = 1;

	public Brewery() {
		super();
	}

	public void brew() {
		final Resource[] bestWater = {new Resource(ResourceType.WATER, 0)};
		final Resource[] bestHop = {new Resource(ResourceType.HOPS, 0)};
		final int[] hopAmount = {0};
		final int[] waterAmount = {0};
		HashMap<Resource, Integer> storage = getLager().getResources();


		storage.forEach((resource, integer) -> {
			if(resource.getType().equals(ResourceType.WATER) && integer >= NEEDED_WATER && resource.getQuality() > bestWater[0].getQuality()) {
				bestWater[0] = resource;
				waterAmount[0] = integer;

			}
			if(resource.getType().equals(ResourceType.HOPS) && integer >= NEEDED_HOP && resource.getQuality() > bestHop[0].getQuality()) {
				bestHop[0] = resource;
				hopAmount[0] = integer;
			}
		});

		if(waterAmount[0] >= NEEDED_WATER && hopAmount[0] >= NEEDED_HOP ) {
			int beerQuality = Math.round((bestHop[0].getQuality() + bestWater[0].getQuality())/2);
			Resource beer = new Resource(ResourceType.BEER, beerQuality);
			int waterLeftover = waterAmount[0] - NEEDED_WATER;
			int hopLeftover = hopAmount[0] - NEEDED_HOP;

			storage.put(bestHop[0], hopLeftover);
			storage.put(bestWater[0], waterLeftover);
			storage.put(beer, storage.getOrDefault(beer, 0) + 1);
			brew();
		}
	}
}
