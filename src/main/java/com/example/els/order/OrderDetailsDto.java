package com.example.els.order;

public class OrderDetailsDto {
    private Long id;
    private String senderFirstName;
    private String senderLastName;
    private String receiverFirstName;
    private String receiverLastName;
    private String description;
    private Long packageCount;
    private Long shipmentsCount;

    public OrderDetailsDto() {
    }
    public OrderDetailsDto(String senderFirstName, String senderLastName, String receiverFirstName,
            String receiverLastName, String description, Long packageCount, Long shipmentsCount) {
        this.senderFirstName = senderFirstName;
        this.senderLastName = senderLastName;
        this.receiverFirstName = receiverFirstName;
        this.receiverLastName = receiverLastName;
        this.description = description;
        this.packageCount = packageCount;
        this.shipmentsCount = shipmentsCount;
    }
    public OrderDetailsDto(Long id, String senderFirstName, String senderLastName, String receiverFirstName,
            String receiverLastName, String description, Long packageCount, Long shipmentsCount) {
        this.id = id;
        this.senderFirstName = senderFirstName;
        this.senderLastName = senderLastName;
        this.receiverFirstName = receiverFirstName;
        this.receiverLastName = receiverLastName;
        this.description = description;
        this.packageCount = packageCount;
        this.shipmentsCount = shipmentsCount;
    }

    public OrderDetailsDto(Long id, String senderFirstName, String senderLastName, String receiverFirstName,
        String receiverLastName, String description) {
        this.id = id;
        this.senderFirstName = senderFirstName;
        this.senderLastName = senderLastName;
        this.receiverFirstName = receiverFirstName;
        this.receiverLastName = receiverLastName;
        this.description = description;
        this.packageCount = 0L;
        this.shipmentsCount = 0L;
    }

    public OrderDetailsDto(Long id, String senderFirstName, String senderLastName, String receiverFirstName,
        String receiverLastName, String description, Long packageCount) {
        this.id = id;
        this.senderFirstName = senderFirstName;
        this.senderLastName = senderLastName;
        this.receiverFirstName = receiverFirstName;
        this.receiverLastName = receiverLastName;
        this.description = description;
        this.packageCount = packageCount;
        this.shipmentsCount = 0L;
    }

    public OrderDetailsDto(Long id, Long packageCount) {
        this.id = id;
        this.senderFirstName = "";
        this.senderLastName = "";
        this.receiverFirstName = "receiverFirstName";
        this.receiverLastName = "receiverLastName";
        this.description = "description";
        this.packageCount = packageCount;
        this.shipmentsCount = 0L;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSenderFirstName() {
        return senderFirstName;
    }
    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }
    public String getSenderLastName() {
        return senderLastName;
    }
    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }
    public String getReceiverFirstName() {
        return receiverFirstName;
    }
    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }
    public String getReceiverLastName() {
        return receiverLastName;
    }
    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getPackageCount() {
        return packageCount;
    }
    public void setPackageCount(Long packageCount) {
        this.packageCount = packageCount;
    }
    public Long getShipmentsCount() {
        return shipmentsCount;
    }
    public void setShipmentsCount(Long shipmentsCount) {
        this.shipmentsCount = shipmentsCount;
    }


    

}
