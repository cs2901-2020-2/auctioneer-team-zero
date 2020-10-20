package auctioneer;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
    public void setBidAmount(Observer observer,double newBidAmount);
    public int getSize();
}
