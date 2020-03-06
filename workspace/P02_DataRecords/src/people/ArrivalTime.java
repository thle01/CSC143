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
		if (meridiem == other.meridiem) {
			if (hour == other.hour) {
					if (minutes == other.minutes) {
						return 0;
					}
					else if (minutes > other.minutes) {
						return 1;
					}
					else {
						return -1;
					}
				}
			else if (hour > other.hour) {
				return 1;
				}
			else {
				return -1;
			}
			}
		else if (meridiem == "AM") {
			return 1;
		}
		return -1;
	}
	
	public boolean equals(Object other) {
	    if (this == other)
	        return true;
	    if (other == null)
	        return false;
	    if (getClass() != other.getClass())
	        return false;
	    ArrivalTime arrivalTime = (ArrivalTime) other;
	    return (hour == arrivalTime.hour && minutes == arrivalTime.minutes && meridiem.equals(arrivalTime.meridiem));
	}
	public String toFile() {
		return String.format("Hour, %d, Minutes, %d, Meridiem, %s", hour, minutes, meridiem);
	}
	public String toString() {
		return String.format("Hour:\t\t%d\nMinutes:\t%d\nMeridiem:\t%s", hour, minutes, meridiem);

	}
	
}
