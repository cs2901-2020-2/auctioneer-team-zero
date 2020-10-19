package auctioneer;

import java.util.*;
import java.util.logging.Logger;

public class Bidder implements Observer {
    static private final Logger logger = Logger.getLogger(Bidder.class.getName());
    private double total;
    private double current_bid;

    @Override
    public void update(Object data) {
        current_bid = (double)data;
    }

    public boolean bid() {

        return true;
    }
}
