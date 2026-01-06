package jdbc.business;

/*
Entidad Sale del sistema de tienda de videojuegos.
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class Sale {
    private Long saleId;
    private Customer customer;
    private ArrayList<VideoGame> videoGames;
    private LocalDate saleDate;

    public Sale(Customer customer, LocalDate saleDate) {
        this.customer = customer;
        this.saleDate = saleDate;
        this.videoGames = new ArrayList<>();
    }

    public void addVideoGame(VideoGame videoGame) {
        videoGames.add(videoGame);
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<VideoGame> getVideoGames() {
        return videoGames;
    }

    public void setVideoGames(ArrayList<VideoGame> videoGames) {
        this.videoGames = videoGames;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "customer=" + customer +
                ", videoGames=" + videoGames +
                ", saleDate=" + saleDate +
                '}';
    }
}
