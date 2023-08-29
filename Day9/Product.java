package Day9;

import java.util.Calendar;
import java.util.Date;

public class Product {

    private String productId;
    private String productName;
    private String description;
    private String manufacturer;
    private Date warrantyDate;

    public Product(String productId, String productName, String description, String manufacturer, int warrantyMonths) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, warrantyMonths);
        this.warrantyDate = cal.getTime();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Date warrantyDate) {
        this.warrantyDate = warrantyDate;
    }

}
