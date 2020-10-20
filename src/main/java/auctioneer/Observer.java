package auctioneer;

public interface Observer {
    public void update(Object data);
    public boolean bid(Subject auctioneer, double bid);
    public double getMaxBid();
}
