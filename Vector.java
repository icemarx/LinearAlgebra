import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

class Vector {
    private double[] components;
    public Vector(double... components) {
        this.components = components;
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
        System.out.println(new Vector(1,2,3));
    }
}