package jdbc.business;

public class VideoGame {
    private String title;
    private String platform;
    private String genre;
    private double price;
    private int quantity;
    private Long id;

    public VideoGame(String title, String platform, String genre, double price, int stock, Long id) {
        this.title = title;
        this.platform = platform;
        this.genre = genre;
        this.price = price;
        this.quantity = stock;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int stock) {
        this.quantity = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "title='" + title + '\'' +
                ", platform='" + platform + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", stock=" + quantity +
                ", id=" + id +
                '}';
    }
}
