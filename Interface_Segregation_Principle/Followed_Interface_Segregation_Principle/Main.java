interface TwoDimensionalShape{
    public void area();
}

interface ThreeDimensionalShape{
    public void area();
    public void volume();
}

class Square implements TwoDimensionalShape{
    private int var;

    public Square(int var) {
        this.var = var;
    }
    @Override
    public void area(){
        int a = var * var;
        System.out.println("area of square is " + a);
    }
}

class Rectangle implements TwoDimensionalShape{
    private int len;
    private int br;
    
    public Rectangle(int len, int br){
        this.len = len;
        this.br = br;
    }
    @Override
    public void area(){
        int a = len * br;
        System.out.println("area of rectangle is " + a);
    }
}

class Cube implements ThreeDimensionalShape{
    private int var;
    public Cube(int var){
        this.var = var;
    }

    @Override
    public void area(){
        int a = 6 * (var * var);
        System.out.println("area of cube is " + a);
    }

    @Override
    public void volume(){
        int v = var * var * var;
        System.out.println("volume of cube is " + v);
    }
}

class Main{
    public static void main(String[] args){
       TwoDimensionalShape square = new Square(5);
       square.area();                                                                                       
       TwoDimensionalShape rectangle = new Rectangle(4, 5);
       rectangle.area();
       ThreeDimensionalShape cube = new Cube(3);
       cube.area();
       cube.volume();
    }
}