package Com.Domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    private Long Id;
    @Column(name = "user_id")
    private Long Userid;
    private String From;
    private String To;
    private float Distance;
    private LocalDate date;
    private double Price;
    private LocalDate Validity;


    public Long getId() {
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

    public Long getUserid() {
        return Userid;
    }

    public void setId(Long id) {
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

    public void setUserid(Long userid) {
        Userid = userid;
    }
}
