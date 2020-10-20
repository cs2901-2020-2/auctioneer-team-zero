package auctioneer;

import java.util.*;

public class Bidder implements Observer {
    private double currentBid;
    private String bidderName;

    public Bidder(String bidderName) {
        this.bidderName = bidderName;
    }

    @Override
    public boolean bid(Subject auctioneer, double bid) {
        if(bid > currentBid){
            return auctioneer.setBidAmount(bidderName, bid);
        } else{
            return false;
        }
    }

    @Override
    public void update(Object data) { currentBid = (double)data;}

    @Override
    public double getMaxBid() {return currentBid;}
}
