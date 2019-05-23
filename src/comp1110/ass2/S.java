package comp1110.ass2;
//  @author Shuhao Geng
public class S extends Dice{
    public S(int s){
        faceNumber = s;
        if(s == 0) setPassge('H','H','R','H');
        if(s == 1) setPassge('H','R','R','R');
        if(s == 2) setPassge('H','H','H','H');
        if(s == 3) setPassge('R','R','R','R');
        if(s == 4) setPassge('H','R','R','H');
        if(s == 5) setPassge('H','R','H','R');
    }
}
