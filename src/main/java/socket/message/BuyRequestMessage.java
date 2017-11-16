package socket.message;

import entitiy.Company;
import entitiy.Offer;

/**
 * Created by marcel on 16.11.17.
 */
public class BuyRequestMessage {
	private Company buyer;
	private Offer offer;
	private int amount;

	public BuyRequestMessage(Company buyer, Offer offer, int amount) {
		this.buyer = buyer;
		this.offer = offer;
		this.amount = amount;
	}

	public Company getBuyer() {
		return buyer;
	}

	public void setBuyer(Company buyer) {
		this.buyer = buyer;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
