package auctioneer;

import java.util.*;
import java.util.logging.Logger;

public class Auctioneer implements Subject {
    static private final Logger logger = Logger.getLogger(Auctioneer.class.getName());
    private List<Observer> bidders;
    private double current_bid;
    private Observer observer;


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

    public void getBid(double bid) {
        this.current_bid = bid;

        notifyObservers();
    }

    @Override
    public int getSize() {
        return bidders.size();
    }

    /*
    public void updateBid(double bid) {
        this.current_bid = bid;

        notifyObservers();
    }
    */


    @Override
    public void setBidAmount(Observer observer,double newBidAmount){
        if(this.current_bid < newBidAmount && this.observer.getName() != observer.getName()){
            this.observer=observer;
            this.current_bid=newBidAmount;
            notifyObservers();
        }
        else {
            logger.info("not setted");
        }

    }


}
