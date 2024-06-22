import java.util.Arrays;
public class Studio {
    private boolean[][] seats;
    private String type;
    private Movie movie;
    private static final int IMAX_ROWS = 8;
    private static final int IMAX_COLS = 9;
    private static final int PREMIERE_ROWS = 6;
    private static final int PREMIERE_COLS = 4;
    private static final int REGULER_ROWS = 5;
    private static final int REGULER_COLS = 5;

    public Studio(String type) {
        this.type = type;
        setSeats();
    }

    public String getStudioInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movie: ").append(movie.getTitle()).append("\n");
        sb.append("Type: ").append(type).append("\n");
        sb.append("Price: ").append(getTicketPrice(type)).append("\n");
        sb.append("Genre: ").append(Arrays.toString(movie.getGenres())).append("\n");
        sb.append("Seats:").append("\n");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j]) {
                    sb.append("X ");
                } else {
                    sb.append("O ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean isBooked(char row, int col) {
        int rowNum = row - 'A';
        if (rowNum >= 0 && rowNum < seats.length && col >= 0 && col < seats[rowNum].length) {
            return seats[rowNum][col];
        }
        return false;
    }

    public boolean reserve(char row, int col) {
        int rowNum = row - 'A';
        if (rowNum >= 0 && rowNum < seats.length && col >= 0 && col < seats[rowNum].length) {
            if (!seats[rowNum][col]) {
                seats[rowNum][col] = true;
                return true;
            }
        }
        return false;
    }

    public String getType() {
        return type;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    private void setSeats() {
        switch (type) {
            case "Imax":
                seats = new boolean[IMAX_ROWS][IMAX_COLS];
                break;
            case "Premiere":
                seats = new boolean[PREMIERE_ROWS][PREMIERE_COLS];
                break;
            case "Reguler":
                seats = new boolean[REGULER_ROWS][REGULER_COLS];
                break;
        }
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