package auctioneer;

import java.util.*;
import java.util.logging.Logger;

public class Bidder implements Observer {
    static private final Logger logger = Logger.getLogger(Bidder.class.getName());
    private double total;
    private double current_bid;
    private String bidderName;
    private boolean lastBid;

    public Bidder(String bidderName) {
        this.bidderName = bidderName;
        lastBid = false;
    }

    @Override
    public boolean bid(Auctioneer auctioneer) throws Exception {
        double bid = auctioneer.getBid();
        if( current_bid> bid &&  !lastBid){
            lastBid = true;
            auctioneer.setBidAmount(bidderName, current_bid);
        } else{
            lastBid = false;
        }
    }


    @Override
    public void update(Object data) { current_bid = (double)data;}

    @Override
    public String getName() { return bidderName;}
}
