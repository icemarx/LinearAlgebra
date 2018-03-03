import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

class Vector {
    private double[] components;
    public Vector(double... components) {
        this.components = components;
    }

    public int rk() {     // rk stands for rank
        // returns the rank of the Vector this
        return this.components.length;
    }
    public double getComponent(int i) {
        // returns the i-th component of Vector this
        return this.components[i];

    }

    public Vector sum(Vector a) {
        // adds the Vectors a and returns the Vector sum, if the ranks of Vectors are the same
        if(a.rk() == this.components.length) {
            double[] v = new double[this.components.length];
            for(int i = 0; i < a.rk(); i++) 
                v[i] = this.getComponent(i) + a.getComponent(i);
            return new Vector(v);
        } else {
            // will change this later to throw a custom exception
            return new Vector(0,0,0);
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
        System.out.println(new Vector(1, 2, 3));
        System.out.println(new Vector(1, 2.3232, -3.5));
        System.out.println((new Vector(1, 2, 3)).sum(new Vector(-2, -4, -6)));
        System.out.println((new Vector(1)).sum(new Vector(1, 2)));      // issue
    }
}