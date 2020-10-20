package auctioneer;

public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();

    public boolean setBidAmount(String bidderName, double newBidAmount);

    public int getSize();

    public String getLastBidder();
    public double getBid();
}