package auctioneer;

import java.util.*;
import java.util.logging.Logger;

public class Bidder implements Observer {
    static private final Logger logger = Logger.getLogger(Bidder.class.getName());
    private double total;
    private double current_bid;
    private String bidderName;

    public Bidder(String bidderName) {
        this.bidderName = bidderName;
    }


    @Override
    public void update(Object data) { current_bid = (double)data;}

    @Override
    public String getName() { return bidderName;}


    public boolean bid() {

        return true;
    }
}
