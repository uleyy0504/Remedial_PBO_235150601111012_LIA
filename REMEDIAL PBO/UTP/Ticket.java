public class Ticket {
    private static final int String = 0;
    private Movie movie;
    private int studioNumber;
    private String seat;
    private int price;

    public Ticket(Movie movie, int studioNumber, String seat) {
        this.movie = movie;
        this.studioNumber = studioNumber;
        this.seat = seat;
        this.price = 120000;
        setPrice(movie.getTitle());
    }

    public String getTicketInfo() {
        return "Studio Number: " + studioNumber + "\n" +
                "Movie Name: " + movie.getTitle() + "\n" +
                "Price: " + price + "\n" +
                "Seat: " + seat;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getStudioNumber() {
        return studioNumber;
    }

    public void setPrice(String string) {
        this.price = String;
    }

    public int getPrice() {
        return price;
    }

    public String getSeat() {
        return seat;
    }

    public double getTicketPrice(String type) {
        switch (type) {
            case "Premiere":
                return 120000;
            case "Imax":
                return 100000;
            case "Reguler":
                return 50000;
            default:
                return 0;
        }
    }
}