interface Shape{
    public void area();
    public void volume();
}

class Square implements Shape{
    private int var;
    
    public Square(int var) {
        this.var = var;
    }

    @Override
    public void area(){
        var =  var * var;
        System.out.println("area of square is"+var);
    }

    @Override
    public void volume(){
        System.out.println("volume of square is not defined");    //or we can throw an exception
    }
} 

class Rectangle implements Shape{
    private int len;
    private int br;

    public Rectangle(int len, int br){
        len = this.len;
        br=this.br;
    }

    @Override
    public void area(){
        int area = len * br;
        System.out.println("area of rectangle is"+area);
    }
    
    @Override
    public void volume(){
        System.out.println("volume of rectangle is not defined");
    }
}

class Cube implements Shape{
    private int var;

    public Cube(int var) {
        this.var = var;
    }

    @Override
    public void area(){
        int a = 6 * (var * var);
        System.out.println("area of cube is"+a);
    }

    @Override
    public void volume(){
        int b = var * var * var;
        System.out.println("volume of cube is"+b);
    }
}

class Main{
    public static void main(String[] args) {
        Shape s = new Square(5); 
        Shape r = new Rectangle(6,3);
        Shape c = new Cube(4);
        s.area();
        s.volume();
        r.area();
        r.volume();
        c.area(); 
        c.volume();
    }
}