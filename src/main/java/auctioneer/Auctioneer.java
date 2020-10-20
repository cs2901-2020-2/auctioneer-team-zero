package auctioneer;

import java.util.*;


public class Auctioneer implements Subject {
    private List<Observer> bidders;
    private double currentBid;
    private String lastBidder;


    public Auctioneer(){
        this.currentBid = 0;
        this.lastBidder = "";
        this.bidders = new ArrayList<>();
    }

    public Auctioneer(double bidAmount){
        this.currentBid = bidAmount;
        this.lastBidder = "";
        this.bidders = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        bidders.add(o);
        o.update(this.currentBid);
    }

    @Override
    public void removeObserver(Observer o) {
        bidders.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer bidder : bidders) {
            bidder.update(this.currentBid);
        }
    }

    @Override
    public double getBid() {
        return this.currentBid;
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
        if (!bidderName.equals(lastBidder)){
            this.currentBid=newBidAmount;
            this.lastBidder = bidderName;
            notifyObservers();
            return true;
        }
        else
            return false;
    }
}
