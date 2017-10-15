package taxi;
import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		LocalDate SubmitDate = LocalDate.of(2030, 9, 1);
		
		LocalDate BoughtDate = LocalDate.of(2030, 5, 1);
		int distance = 10000;
		Car car = new Car(BoughtDate, distance, false);
		
		if( Tool.ifRemindWriteOff(car, SubmitDate) ){
			
		}else{
			if( Tool.ifRemindDistanceMain(car) ){
				
			}else{
				if( Tool.ifRemindTimeMain(car, SubmitDate) ){
					
				}
					
			}
		}
		
	}
}
