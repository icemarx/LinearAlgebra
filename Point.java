import java.lang.Math;

public class Point {
	private double[] coordinates;
	public Point(double... coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		String p = "(";
		for(int i = 0; i < this.coordinates.length; i++) {
			if(!Double.isInfinite(this.coordinates[i]) && this.coordinates[i] == Math.floor(this.coordinates[i]))
                p+=(int)this.coordinates[i];
            else
                p+=this.coordinates[i];

            if(i != this.coordinates.length - 1)
                p+=", ";
            else
            	p+=")";
		}
		return p;
	}



	public static void main(String[] args) {
		Point point = new Point(1, 2, 3, 4);
		System.out.println(point);
	}
}