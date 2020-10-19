package auctioneer;

import java.util.*;
import java.util.logging.Logger;

public class Auctioneer implements Subject {
    static private final Logger logger = Logger.getLogger(Auctioneer.class.getName());
    private List<Observer> bidders;
    private double current_bid;

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

    public void updateBid(double bid) {
        this.current_bid = bid;

        notifyObservers();
    }
}
