package InterviewQuestions.BasicPrograms;

public class PackersAndMovers {
    private int invoiceNo;
    private String fromCity;
    private String toCity;
    private String orderDate;
    private String deliveryDate;
    private double price;

    public PackersAndMovers(int invoiceNo, String fromCity, String toCity, String orderDate, String deliveryDate, double price) {
        this.invoiceNo = invoiceNo;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.price = price;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PackersAndMovers{" +
                "invoiceNo=" + invoiceNo +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", price=" + price +
                '}';
    }
}
