package model;

public class Vector implements Cloneable {
    private double speed;
    private double degree;
    
    public Vector(double x, double y) {
        this.speed = Math.sqrt(x * x + y * y);
        this.degree = (Math.toDegrees(Math.atan(y / x)) + (x > 0 ? 0 : 180)) % 360;
        System.out.println(this.degree);
    }
    
    public double getY() {
        return Math.sin(Math.toRadians(degree)) * speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public double getX() {
        return Math.cos(Math.toRadians(degree)) * speed;
    }
    
    public void boostSpeed(double factor){
        speed *= factor ;
    }
    
    @Override
     public Object clone()throws CloneNotSupportedException{  
      return (Vector)super.clone();  
   }

}
