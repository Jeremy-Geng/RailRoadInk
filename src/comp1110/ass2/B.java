package comp1110.ass2;

public class B extends Dice{
    B(int b){
        faceNumber = b;
        if(b == 0) setPassge('H','!','R','!');
        if(b == 1) setPassge('H','R','!','!');
        if(b == 2) setPassge('H','R','H','R');
    }


}
