package auctioneer;

import org.testng.annotations.Test;

public class MultithreadAuctionTest {
    Subject auctioneer;
    int bidderNo;

    public MultithreadAuctionTest(){
        auctioneer = new Auctioneer();
        bidderNo = 0;
    }

    @Test (invocationCount = 50, threadPoolSize = 50)
    public void multiBidderTest(){
        String bidderName = Integer.toString(bidderNo);
        bidderNo++;
        Observer bidder = new Bidder(bidderName);
        auctioneer.registerObserver(bidder);
        bidder.bid(auctioneer, bidderNo);
    }
}
