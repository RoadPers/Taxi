package taxi;
import java.time.LocalDate;

public class Tool {
	public static LocalDate getWriteOffDate(LocalDate BoughtDate, boolean ifRepair){
		LocalDate WriteOffDate = LocalDate.now();
		if(ifRepair){
			WriteOffDate = BoughtDate.plusDays(1095);
		}else{
			WriteOffDate = BoughtDate.plusDays(2190);
		}		
		return WriteOffDate;
	}
	
	public static LocalDate getPreMonth(LocalDate oneday){
		int year = oneday.getYear();
		int month = oneday.getMonthValue();
		
		if(month == 1){
			year--;
			month = 12;
		}else{
			month--;
		}
		LocalDate PreMonth = LocalDate.of(year, month, 1);
		return PreMonth;
	}
	
	public static boolean ifRemindWriteOff(Car car, LocalDate SubmitDate){
		LocalDate WriteOffDay = Tool.getWriteOffDate(car.BoughtDate, car.ifRepair);
		LocalDate PreMonth = Tool.getPreMonth(WriteOffDay);	//提醒日：报废前一月的第一天的日期
		if( SubmitDate.isAfter(WriteOffDay) ){ //若当前日期在报废日之后
			return false;
		}else if( !SubmitDate.isBefore(PreMonth) ){ //当前日不在提醒日之前
			return true;
		}else{
		return false;
		}
	}
	
	public static boolean ifRemindDistanceMain(Car car){
		int distance = car.mileage;
		if( distance % 10000 >= 9500 || distance % 10000 == 0 ){
			return true;
		}
		return false;
	}

	public static boolean ifInit(LocalDate BoughtDate, LocalDate SubmitDate, int T){
		int year = SubmitDate.getYear() - BoughtDate.getYear();
		int month = year * 12 + ( SubmitDate.getMonthValue() - BoughtDate.getMonthValue());
		
//		LocalDate deadline = LocalDate.of(BoughtDate.getYear(), BoughtDate.getMonthValue(), BoughtDate.getDayOfMonth());
//		LocalDate premonth = deadline.
		int tmp = month / T;
		if( month % T == 0 ){	
			LocalDate deadline = BoughtDate.plusMonths(month);
			if( !deadline.isBefore(SubmitDate)){
				return true;
			}else{
				return false;
			}
		}else{
			LocalDate deadline = BoughtDate.plusMonths( (tmp+1) * T );
			LocalDate premonth = deadline.plusMonths(-1);
			premonth = premonth.withDayOfMonth(1);
			if( !SubmitDate.isBefore(premonth) && !SubmitDate.isAfter(deadline)){
				return true;
			}else{
				return false;
		}
		}
		
		
		
	}
	
	public static boolean ifRemindTimeMain(Car car, LocalDate SubmitDate){	
		if( car.ifRepair ){
			return ifInit(car.BoughtDate, SubmitDate, 3);
		}else{
			int year = SubmitDate.getYear() - car.BoughtDate.getYear();
			if( year < 3 ) {
				return ifInit(car.BoughtDate, SubmitDate, 12);
			}
			else {
				return ifInit(car.BoughtDate, SubmitDate, 6);
			}
		}
			
	}
}

	