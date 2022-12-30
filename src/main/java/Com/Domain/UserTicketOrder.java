package Com.Domain;

public class UserTicketOrder {
    private int OrderId;
    private int UserId;
    private int TicketId;

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }
    public void setTicketId(int ticketId) {
        TicketId = ticketId;
    }
    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getOrderId() {
        return OrderId;
    }
    public int getTicketId() {
        return TicketId;
    }
    public int getUserId() {
        return UserId;
    }
}
