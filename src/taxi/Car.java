package taxi;
import java.time.LocalDate;;

public class Car {
	String ID;
	String brand;
	int mileage;	//Àï³ÌÊý
	boolean ifRepair = false;
	
//	LocalDate SubmitDate;
	LocalDate BoughtDate;
	LocalDate WriteOffDate; 
	Car(int mileage){
		this.mileage = mileage;
	}
	Car(LocalDate BoughtDate, boolean ifRepair){
		this.BoughtDate = BoughtDate;
		this.ifRepair = ifRepair;
	}
	Car(LocalDate BoughtDate,  int mileage, boolean ifRepair){
		this.BoughtDate = BoughtDate;
		this.mileage = mileage;
		this.ifRepair = ifRepair;
	}
}
