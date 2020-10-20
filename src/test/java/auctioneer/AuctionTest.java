package auctioneer;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class AuctionTest {

    public void registerTest(){
        Subject auctioneer = new Auctioneer();
        Observer bidder = new Bidder("Bidder1");
        auctioneer.registerObserver(bidder);
        Assert.assertEquals(auctioneer.getSize(), 1);
    }

    public void removeTest(){
        Subject auctioneer = new Auctioneer();
        Observer bidder = new Bidder("Bidder1");
        auctioneer.registerObserver(bidder);
        auctioneer.removeObserver(bidder);
        Assert.assertEquals(auctioneer.getSize(), 0);
    }

    public void notifyTest(){
        Subject auctioneer = new Auctioneer();
        Observer bidder = new Bidder("Bidder1");
        auctioneer.registerObserver(bidder);
        bidder.bid(auctioneer, 20);
        Assert.assertEquals(bidder.getMaxBid(), 20);
    }

    public void maxBidTest(){
        Subject auctioneer = new Auctioneer();
        Observer bidder1 = new Bidder("Bidder1");
        Observer bidder2 = new Bidder("Bidder2");
        auctioneer.registerObserver(bidder1);
        auctioneer.registerObserver(bidder2);
        bidder1.bid(auctioneer, 20);
        bidder2.bid(auctioneer, 30);
        Assert.assertEquals(auctioneer.getBid(), 30);
    }

    public void lastBidderTest(){
        Subject auctioneer = new Auctioneer();
        Observer bidder = new Bidder("Bidder1");
        auctioneer.registerObserver(bidder);
        bidder.bid(auctioneer, 20);
        Assert.assertEquals(auctioneer.getLastBidder(), "Bidder1");
    }

    public void invalidBidAmountTest(){
        Subject auctioneer = new Auctioneer(50);
        Observer bidder = new Bidder("Bidder1");
        auctioneer.registerObserver(bidder);
        Assert.assertEquals(bidder.bid(auctioneer, 20), false);
    }

    public void sameBiddertest(){
        Subject auctioneer = new Auctioneer();
        Observer bidder = new Bidder("Bidder1");
        auctioneer.registerObserver(bidder);
        bidder.bid(auctioneer, 10);
        Assert.assertEquals(bidder.bid(auctioneer, 20), false);
    }

}
