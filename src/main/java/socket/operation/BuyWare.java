package socket.operation;

import dao.OfferDao;
import dao.StorageDao;
import socket.message.BuyRequestMessage;
import socket.message.BuyResponseMessage;

/**
 * Created by marcel on 16.11.17.
 */
public class BuyWare {

	private OfferDao offerDao;
	private StorageDao storageDao;

	public BuyWare() {
		offerDao = new OfferDao();
		storageDao = new StorageDao();

	}

}
