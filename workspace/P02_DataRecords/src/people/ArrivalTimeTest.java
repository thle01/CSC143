package people;

public class ArrivalTimeTest {
	public static void main(String[] args) {
		ArrivalTime arrivalTime = new ArrivalTime(10, 30, "AM");
		ArrivalTime arrivalTime1 = new ArrivalTime(10, 22, "PM");
		System.out.println(arrivalTime.compareTo(arrivalTime1));
		System.out.println(arrivalTime);
		System.out.println(arrivalTime.toFile());
		
	}
}
