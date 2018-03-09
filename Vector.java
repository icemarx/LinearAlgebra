import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Vector {
    private double[] components;
    public Vector(Point p) {
        this.components = p.getAllCoordinates();
    }
    public Vector(double... components) {
        this.components = components;
    }

    public int size() {
        // returns the number of components of Vector this
        return this.components.length;
    }
    public double getComponent(int i) {
        // returns the i-th component of Vector this
        return this.components[i];
    }

    public Vector zero() {
        // returns a zeroth vector, with the same length as the current vector
        // so that it can be used for addition, etc.s
        return new Vector(new Point(new double[this.components.length]));
    }

    public Vector sum(Vector a) {
        // adds the Vectors a and returns the Vector sum, if the ranks of Vectors are the same
        if(a.size() == size()) {
            double[] v = new double[size()];
            for(int i = 0; i < a.size(); i++) 
                v[i] = this.getComponent(i) + a.getComponent(i);
            return new Vector(new Point(v));
        } else {
            // will change this later to throw a custom exception
            System.out.println("Exception");
            return new Vector(new Point(-1));
        }
    }

    public Vector scal_mul(double s) {
        // scales Vector this and returns a new scaled Vector
        double[] v = new double[size()];
        for(int i = 0; i < v.length; i++)
            v[i] = s*this.components[i];
        return new Vector(new Point(v));
    }

    public Vector sub(Vector a) {
        // subtracts Vectors by adding Vector this and inverse of Vector a, and returns the resulting sum
        return this.sum(a.scal_mul(-1));
    }

    public Vector vect_mul(Vector a) {
        // multiplies two Vectors to create a new Vector
        // is only defined for 3D vectors
        if(this.size() == 3 && a.size() == 3) {
            double[] v = new double[3];
            for(int i = 0; i < 3; i++)
                v[i] = this.getComponent((i+1)%3)*a.getComponent((i+2)%3) - this.getComponent((i+2)%3)*a.getComponent((i+1)%3);
            return new Vector(new Point(v));
        } else {
            // will change this later to throw a custom exception
            System.out.println("Exception");
            return new Vector(new Point(-2));
        }
    }


    
    @Override
    public String toString() {
        String v = "[";
        for(int i = 0; i < this.components.length; i++) {
            if(!Double.isInfinite(this.components[i]) && this.components[i] == Math.floor(this.components[i]))
                v+=(int)this.components[i];
            else
                v+=this.components[i];

            if(i != this.components.length - 1)
                v+="\n";
        }
        v+="]";
        return v;
    }

    public static void main(String[] args) {
        // for testing purposes
        Vector a = new Vector(new Point(1, 2, 3));
        System.out.println(a);
        System.out.println(new Vector(new Point(1, 2.3232, -3.5)));
        System.out.println(a.sum(new Vector(new Point(-2, -4, -6))));
        System.out.println((new Vector(new Point(1)).sum(new Vector(new Point(1, 2)))));      // issue
        System.out.println(a.scal_mul(-1));
        System.out.println(a.scal_mul(0));
        System.out.println(a.sub(new Vector(new Point(3, 2, 1))));
        System.out.println(a.sub(a));
        System.out.println(a.vect_mul(a));
        System.out.println(a.vect_mul(new Vector(new Point(3, 2))));               // issue
        System.out.println(a.zero());
        System.out.println(new Vector(1, 2, 3));
    }
}