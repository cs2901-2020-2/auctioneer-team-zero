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
    public boolean bid(Subject auctioneer, double bid) {
        if(bid > current_bid){
            return auctioneer.setBidAmount(bidderName, bid);
        } else{
            return false;
        }
    }

    @Override
    public void update(Object data) { current_bid = (double)data;}

    @Override
    public double getMaxBid() {return current_bid;}
}
