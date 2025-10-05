package io.accelerate.solutions.CHK;

public class Price {
    int individualPrice;
    Offer offer;

    public Price(int individualPrice, Offer offer) {
        this.individualPrice = individualPrice;
        this.offer = offer;
    }

    public int getIndividualPrice() {
        return individualPrice;
    }

    public void setIndividualPrice(int individualPrice) {
        this.individualPrice = individualPrice;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
