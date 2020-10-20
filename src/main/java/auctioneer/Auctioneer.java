package auctioneer;

import java.util.*;
import java.util.logging.Logger;

public class Auctioneer implements Subject {
    static private final Logger logger = Logger.getLogger(Auctioneer.class.getName());
    private List<Observer> bidders;
    private double current_bid;
    private String lastBidder;


    public Auctioneer(){
        this.current_bid = 0;
        this.lastBidder = "";
    }

    public Auctioneer(double bidAmount){
        this.current_bid = bidAmount;
        this.lastBidder = "";
    }

    @Override
    public void registerObserver(Observer o) {
        bidders.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        bidders.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer bidder : bidders) {
            bidder.update(this.current_bid);
        }
    }

    @Override
    public double getBid() {
        return this.current_bid;
    }

    @Override
    public int getSize() {
        return bidders.size();
    }
    @Override
    public String getLastBidder() {
        return this.lastBidder;
    }


    @Override
    public synchronized boolean setBidAmount(String bidderName,double newBidAmount){
        if (bidderName != lastBidder){
            this.current_bid=newBidAmount;
            this.lastBidder = bidderName;
            notifyObservers();
            return true;
        }
        return false;
    }
}
