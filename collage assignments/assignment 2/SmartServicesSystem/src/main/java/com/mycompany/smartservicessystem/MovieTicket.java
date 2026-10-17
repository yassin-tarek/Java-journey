package com.mycompany.smartservicessystem;

public class MovieTicket {
    private final String ticketId;
    private String movieName;
    private String customerName;
    private String seatNumber;
    private double price;
    private boolean booked;
    private double discount;
    private static final double BOOKING_FEE_PERCENT = 10;
    public MovieTicket(String ticketId , String movieName, String customerName,String seatNumber, double price){
        this.ticketId = ticketId;
        this.movieName = movieName;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
        
        if(!isPositive(price)){
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
        booked = false;
        discount = 0;
    }
    
    // helping methods
     static private boolean isPositive(double price){
        return price >= 0;
    }
    
    // getters and setters
    public String getTicketId(){
        return ticketId;
    }
    public String getMovieName(){
        return movieName;
    }
    public void setMovieName(String movieName){
        this.movieName = movieName;
    }     
    
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    
    public String getSeatNumber(){
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber){
        if(this.booked == true)
            throw new IllegalArgumentException("Invalid already booked ticket");
        this.seatNumber = seatNumber;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        if(!isPositive(price)){
        throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;}
    public boolean isBooked(){
        return booked;
    }
    public double getDiscountPercentage(){
        return discount;
    }
    public void bookTicket(){
        if(isBooked() || price == 0)
            throw new IllegalArgumentException("the ticket is already booked or zero price");
        booked = true;
    }
    
    public void cancelTicket(){
        if(!isBooked())
            throw new IllegalArgumentException("the ticket isn't booked");
        booked = false;
    }
    public void applyDiscount(double discount){
        if(discount > 100 || discount < 0)
            throw new IllegalArgumentException("the discount is not valid");
        this.discount = discount;
    }
    public double calculateFinalPrice(){
        double finalPrice = price;
        // add discount
        if(discount != 0){
            finalPrice -= finalPrice * discount/100;
        }
        // add fee
        if(isBooked())
            finalPrice += finalPrice * BOOKING_FEE_PERCENT / 100;
        return finalPrice;
    }
}
