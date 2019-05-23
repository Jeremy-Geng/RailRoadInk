package comp1110.ass2;


//  @author Shuhao Geng
public class B extends Dice{
    public B(int b){
        faceNumber = b;
        if(b == 0) setPassge('H','!','R','!');
        if(b == 1) setPassge('H','R','!','!');
        if(b == 2) setPassge('H','R','H','R');
    }


}
