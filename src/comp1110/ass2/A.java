package comp1110.ass2;

public class A extends Dice{
    A(int a){
        faceNumber = a;
        if(a == 0) setPassge('R','!','!','R');
        if(a == 1) setPassge('R','!','R','!');
        if(a == 2) setPassge('R','R','R','!');
        if(a == 3) setPassge('H','H','H','!');
        if(a == 4) setPassge('H','！','H','!');
        if(a == 5) setPassge('H','！','！','H');
    }

}

