package auctioneer;

public interface Observer {
    public void update(Object data);
    public String getName();
    public boolean bid(Auctioneer auctioneer) throws Exception;
}
