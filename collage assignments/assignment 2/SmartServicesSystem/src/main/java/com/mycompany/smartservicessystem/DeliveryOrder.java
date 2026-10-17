package com.mycompany.smartservicessystem;

public class DeliveryOrder {
    private final String orderId;
    private String customerName;
    private String deliveryAddress;
    private int itemCount;
    private double subTotal;
    private boolean paymentStatus;
    private boolean deliveryStatus;
    private String paymentMethod;
    private final DigitalWallet wallet;

    public DeliveryOrder(String orderId , String customerName , String deliveryAddress , int itemCount , double subtotal) {
        if(orderId == null || orderId.isBlank())
            throw new IllegalArgumentException("Invalid orderId");
        this.orderId = orderId;
        
        if(customerName == null || customerName.isBlank())
            throw new IllegalArgumentException("Invalid customerName");            
        this.customerName = customerName;
        
        if(deliveryAddress == null || deliveryAddress.isBlank())
            throw new IllegalArgumentException("Invalid deliveryAddress");            
        this.deliveryAddress = deliveryAddress;
        
        if(itemCount <= 0)
            throw new IllegalArgumentException("Invalid itemcount");
        this.itemCount = itemCount;
        
        if(subtotal < 0)
            throw new IllegalArgumentException("Invalid subtotal");
        this.subTotal = subtotal;
         
        paymentStatus = false;
        deliveryStatus = false;
        paymentMethod = "cash";
        this.wallet = null;
    }
    public DeliveryOrder(String orderId , String customerName , String deliveryAddress , int itemCount , double subtotal , DigitalWallet wallet) {
        if(orderId == null || orderId.isBlank())
            throw new IllegalArgumentException("Invalid orderId");
        this.orderId = orderId;
        
        if(customerName == null || customerName.isBlank())
            throw new IllegalArgumentException("Invalid customerName");            
        this.customerName = customerName;
        
        if(deliveryAddress == null || deliveryAddress.isBlank())
            throw new IllegalArgumentException("Invalid deliveryAddress");            
        this.deliveryAddress = deliveryAddress;
        
        if(itemCount <= 0)
            throw new IllegalArgumentException("Invalid itemcount");
        this.itemCount = itemCount;
        
        if(subtotal < 0)
            throw new IllegalArgumentException("Invalid subtotal");
        this.subTotal = subtotal;
         
        paymentStatus = false;
        deliveryStatus = false;
        paymentMethod = "wallet";
        if(wallet == null)
            throw new IllegalArgumentException("Invalid wallet");
        this.wallet = wallet;
    }
    
    // getter and setter
    public String getOrderId(){
        return orderId;
    }
    
    public String getCustomerName(){
        return customerName;
    }
    public boolean setCustomerName(String customerName){
        if(customerName == null || customerName.isBlank())
           return false;            
        this.customerName = customerName;
       return true;
    }
    
    public String getDeliveryAddress(){
        return deliveryAddress;
    }
    
    public boolean setDeliveryAddress(String deliveryAddress){
        if(deliveryAddress == null || deliveryAddress.isBlank())
           return false;            
        this.deliveryAddress = deliveryAddress;
       return true;
    }
    
    public int getItemCount(){
        return itemCount;
    }
    public boolean setItemCount(int itemCount){
        
        if(itemCount <= 0 || paymentStatus == true)
            return false;
        this.itemCount = itemCount;
        return true;
    }
    public double getSubTotal(){
        return subTotal;
    }
    public boolean setSubTotal(double subTotal){
        
        if(subTotal < 0 || paymentStatus == true)
            return false;
        this.subTotal = subTotal; 
        return true;
    }
    public String getPaymentMethod(){
        return paymentMethod;
    }
    private double calculateDeliveryCost(){
     if(subTotal < 500)
         return 50;
     else if(subTotal < 1000)
         return 30;
     else
         return 10;}
    
    public double calculateTotal(){
        return subTotal + calculateDeliveryCost();
    }
    public boolean payOrder(){
        if(paymentStatus == true)
            return false;
        if(wallet == null){
            paymentStatus = true;
            return true;
        }else if(wallet.withdraw(calculateTotal())){
                paymentStatus = true;
                return true;
            }else{
            return false;
            }
        }
    
    public boolean deliverOrder(){
     if(paymentStatus == false ||deliveryStatus == true)   
         return false;
     deliveryStatus = true;
     return true;
    }
    public boolean orderPaymentStatus(){
     return paymentStatus;
    }
    public boolean orderDeliveryStatus(){
     return deliveryStatus;
    }
    
}
