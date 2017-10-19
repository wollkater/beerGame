package entitiy;

/**
 * Created by marcel on 19.10.17.
 */
public class Offer {
	Resource resource;
	Company trader;
	float price;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Company getTrader() {
		return trader;
	}

	public void setTrader(Company trader) {
		this.trader = trader;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
