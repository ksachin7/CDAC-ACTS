package day18;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class MobilePhone implements Comparator<MobilePhone> {
    private long serialNo;
    private String brand;
    private String os;
    private String color;
    private double price;
    private String ram;
    
    static List<MobilePhone> phoneList = new ArrayList<>();

    public MobilePhone(long serialNo, String brand, String os, String color, double price, String ram) {
        this.serialNo = serialNo;
        this.brand = brand;
        this.os = os;
        this.color = color;
        this.price = price;
        this.ram = ram;
    }
    
    // for filter using predicate without stream
    public static List<MobilePhone> filterbyCriteria(List<MobilePhone> phoneList,Predicate<MobilePhone> predicate){
    	List<MobilePhone> filteredList =new ArrayList<>();
    	for(MobilePhone mp :phoneList) {
    		if(predicate.test(mp)) {
    			filteredList.add(mp);
    		}
    	}
    	return filteredList;
    }
    
    public static void addPhone(MobilePhone phone) {
        phoneList.add(phone);
        System.out.println("Phone added successfully!");
    }

    public static void displayAllPhones() {
        if (phoneList.isEmpty()) {
            System.out.println("No phones available in the list.");
            return;
        }
        System.out.println("\n--- All Mobile Phones ---");
        
        for (MobilePhone phone : phoneList) {
            System.out.println(phone);
        }
        System.out.println("-------------------------\n");
    }

    public MobilePhone() {
		super();
	}

	public long getSerialNo() {
        return serialNo;
    }

    public String getBrand() {
        return brand;
    }

    public String getOs() {
        return os;
    }

    public  String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return "Serial No: " + serialNo + ", Brand: " + brand + ", OS: " + os + ", Color: " + color + ", Price: " + price + ", RAM: " + ram;
    }

	@Override
	public int compare(MobilePhone o1, MobilePhone o2) {
		return o1.getColor().compareTo(o2.getColor());
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, color, os, price, ram, serialNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MobilePhone other = (MobilePhone) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(color, other.color) && Objects.equals(os, other.os)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(ram, other.ram) && serialNo == other.serialNo;
	}
}