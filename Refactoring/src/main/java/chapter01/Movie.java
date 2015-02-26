package chapter01;

public class Movie {

    private String title;
    private Price price;

    public Movie(String title, PriceCode priceCode) {
        setTitle(title);
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode().getCode();
    }

    public void setPriceCode(PriceCode code) {
        switch (code) {
        case REGULAR:
            setPrice(new RegularPrice());
            break;
        case NEW_RELEASE:
            setPrice(new NewReleasePrice());
            break;
        case CHILDRENS:
            setPrice(new ChilddrenPrice());
            break;
        }
    }

    public double getCharge(int daysRented) {
        return getPrice().getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return getPrice().getFrequentRenterPoints(daysRented);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setPrice(Price price) {
        this.price = price;
    }

    private Price getPrice() {
        return price;
    }

}
