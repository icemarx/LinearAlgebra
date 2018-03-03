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
        if(a.rk() == rk()) {
            double[] v = new double[rk()];
            for(int i = 0; i < a.rk(); i++) 
                v[i] = this.getComponent(i) + a.getComponent(i);
            return new Vector(v);
        } else {
            // will change this later to throw a custom exception
            return new Vector(0,0,0);
        }
    }

    public Vector scal_mul(double s) {
        // scales Vector this and returns a new scaled Vector
        double[] v = new double[rk()];
        for(int i = 0; i < v.length; i++)
            v[i] = s*this.components[i];
        return new Vector(v);
    }

    public Vector sub(Vector a) {
        // subtracts Vectors by adding Vector this and inverse of Vector a, and returns the resulting sum
        return this.sum(a.scal_mul(-1));
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
        Vector a = new Vector(1, 2, 3);
        System.out.println(a);
        System.out.println(new Vector(1, 2.3232, -3.5));
        System.out.println(a.sum(new Vector(-2, -4, -6)));
        System.out.println((new Vector(1)).sum(new Vector(1, 2)));      // issue
        System.out.println(a.scal_mul(-1));
        System.out.println(a.scal_mul(0));
        System.out.println(a.sub(new Vector(3, 2, 1)));
        System.out.println(a.sub(a));
    }
}