package Com.Domain;

import java.time.LocalDate;

public class Ticket {
    private int Id;
    private String From;
    private String To;
    private float Distance;
    private LocalDate date;
    private double Price;
    private LocalDate Validity;


    public int getId() {
        return Id;
    }
    public double getPrice() {
        return Price;
    }
    public float getDistance() {
        return Distance;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getFrom() {
        return From;
    }
    public String getTo() {
        return To;
    }
    public LocalDate getValidity() {
        return Validity;
    }

    public void setId(int id) {
        Id = id;
    }
    public void setFrom(String from) {
        From = from;
    }
    public void setTo(String to) {
        To = to;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDistance(float distance) {
        Distance = distance;
    }
    public void setPrice(double price) {
        Price = price;
    }
    public void setValidity(LocalDate validity) {
        Validity = validity;
    }
}
