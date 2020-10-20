package auctioneer;

import java.util.*;
import java.util.logging.Logger;

public class Auctioneer implements Subject {
    static private final Logger logger = Logger.getLogger(Auctioneer.class.getName());
    private List<Observer> bidders;
    private double current_bid;
    private Observer observer;
    private String bidderName;


    public Auctioneer(double bidAmount){
        this.current_bid=bidAmount;
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
        for(var bidder : bidders) {
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
    public String getName() {
        return this.bidderName;
    }


    @Override
    public synchronized void setBidAmount(String bidderName,double newBidAmount) throws Exception{

        this.current_bid=newBidAmount;
        this.bidderName = this.observer.getName();
        notifyObservers();


    }
}
