package people;

public class ArrivalTime implements Comparable<ArrivalTime> {
	private int hour;
	private int minutes;
	private String meridiem;
	
	public ArrivalTime(int hour, int minutes, String meridiem) {
		this.hour = hour;
		this.minutes = minutes;
		this.meridiem = meridiem;
	}
	
	public int compareTo(ArrivalTime other) {
		if (meridiem.compareTo(other.meridiem) != 0)
			return (meridiem.compareTo(other.meridiem));
		if (hour != other.hour)
			return hour - other.hour;
		return minutes - other.minutes;
		
	}
	
	public boolean equals(Object other) {
		if (other instanceof ArrivalTime) {
			ArrivalTime object = (ArrivalTime) other;
			return (hour == object.hour 
		    		&& minutes == object.minutes 
		    		&& meridiem.equals(object.meridiem));
		}
		return false;
	}
	public String toFile() {
		String s = "";
		s += "Hour, " + hour;
		s += ", Minutes, " + minutes;
		s += ", Meridiem, " + meridiem;
		return s;
	}
	public String toString() {
		String s = "";
		s += "\nHour: \t\t" + hour;
		s += "\nMinutes: \t" + minutes;
		s += "\nMeridiem: \t" + meridiem;
		return s;
	}
	
}
