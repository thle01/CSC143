package direction;

public class TravelClient {
	
	private static void travel(int endX, int endY, int currentX, int currentY, String path) {
		
		//base: if  I have a solution
		if (currentX == endX && currentY == endY) {
			System.out.println(path);
		
		} else if(currentX <= endX && currentY <= endY){
			travel(endX, endY, currentX, currentY + 1, path + " N");
			travel(endX, endY, currentX + 1, currentY, path + " E");
			travel(endX, endY, currentX + 1, currentY + 1, path + " NE");
		}
	}

	public static void travel(int endX, int endY) {
		travel(endX, endY, 0, 0, "moves:");
	}
	
	public static void main(String[] args) {
		travel(2,3);
	}

}

