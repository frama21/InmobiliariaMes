
public class Circulo extends Figura{
      private int radio;
      public Circulo(int nx, int ny, int nr){
        super(nx,ny);
        radio=nr;
      }
      public double area(){
        return Math.PI*radio*radio;
      }
      public void ampliar(int n){
          radio+=n;
      }
      public int getRadio(){
          return radio;
      }
      public int getX(){
          return x;
      }
      public int getY(){
          return y;
      }
      
      public String toString(){
          return("Crculo:\n  PosX: "+ x + " PosY: " + y + " Radio: " + radio);
      }
}
