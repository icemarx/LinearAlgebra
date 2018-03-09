import java.lang.Math;

public class Point {
    private double[] coordinates;
    public Point(double... coordinates) {
        this.coordinates = coordinates;
    }

    public int getDimension() {
        return this.coordinates.length;
    }

    public double[] getAllCoordinates() {
        return this.coordinates;
    }

    public double getCoordinate(int i) {
        return this.coordinates[i];
    }

    public Vector fromTo(Point b) {
        if(this.getDimension() == b.getDimension()) {
            Vector vA = new Vector(this);
            Vector vB = new Vector(b);
            return vB.sub(vA);
        } else {
            // add custom error here
            System.out.println("Exception");
            return new Vector(new Point(-3));
        }
    }

    @Override
    public boolean equals(Object other) {
        if(other != null && other instanceof Point && getDimension() == ((Point)other).getDimension()) {
            for(int i = 0; i < getDimension(); i++)
                if(this.coordinates[i] != ((Point)other).getCoordinate(i));
            
            return true;
        }
        return false;
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
        System.out.println(point.fromTo(new Point(1, 1, 1, 1)));
        System.out.println(point.fromTo(new Point(1, 1, 1)));       // issue
        System.out.println(point.equals(new Point(1,2,3,4)));
        System.out.println(point.equals(new Point(1)));
    }
}