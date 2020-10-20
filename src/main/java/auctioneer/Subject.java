package auctioneer;

public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();

    public void setBidAmount(String bidderName, double newBidAmount) throws Exception;

    public int getSize();

    public String getName();
    public double getBid();
}