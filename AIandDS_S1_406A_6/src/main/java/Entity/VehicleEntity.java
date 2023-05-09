//package Entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class VehicleEntity {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int vehicleId;
//	private String brand;
//	private String model;
//	private double vehiclePrice;
//	@Override
//	public String toString() {
//		return "VehicleEntity [vehicleId=" + vehicleId + ", brand=" + brand + ", model=" + model + ", vehiclePrice="
//				+ vehiclePrice + ", vehicleStock=" + vehicleStock + "]";
//	}
//	private int vehicleStock;
//	public String getBrand() {
//		return brand;
//	}
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//	public String getModel() {
//		return model;
//	}
//	public void setModel(String model) {
//		this.model = model;
//	}
//	public int getVehicleId() {
//		return vehicleId;
//	}
//	//comment by nikhil
//	public void setVehicleId(int vehicleId) {
//		this.vehicleId = vehicleId;
//	}
//	public double getVehiclePrice() {
//		return vehiclePrice;
//	}
//	public void setVehiclePrice(double vehiclePrice) {
//		this.vehiclePrice = vehiclePrice;
//	}
//	public int getVehicleStock() {
//		return vehicleStock;
//	}
//	public void setVehicleStock(int vehicleStock) {
//		this.vehicleStock = vehicleStock;
//	}
//	
//}






package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;
    private String brand;
    private String model;
    private double vehiclePrice;
    private int vehicleStock;
    private String imageUrl;
    private String description;

    @Override
    public String toString() {
        return "VehicleEntity [vehicleId=" + vehicleId + ", brand=" + brand + ", model=" + model + ", vehiclePrice="
                + vehiclePrice + ", vehicleStock=" + vehicleStock + ", imageUrl=" + imageUrl + ", imageType="
                + "]";
    }
    
    public String dispString() {
    	return String.format("<h1>Brand</h1><p>%1$s</p>\n"
    			+ "<h1>Model : </h1><p>%2$s</p>\n"
    			+ "<h1>Price : </h1><p>%3$s</p>\n"
    			+ "<h1>Stock : </h1><p>%4$s</p>\n"
    			+ "<h1>Description : </h1><p>%5$s</p>\n", brand, model, vehiclePrice, vehicleStock, description);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public int getVehicleStock() {
        return vehicleStock;
    }

    public void setVehicleStock(int vehicleStock) {
        this.vehicleStock = vehicleStock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public void setDescription(String e) {
    	this.description=e;
    }
    
    public String getDescription() {
    	return this.description;
    }
}

