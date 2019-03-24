package comp1110.ass2;

//  This class is for calculating and recording scores of each player.
public class Scoring {
    //  THis field is to count the number of exit connected to the route.
    private int numberOfExits;

    //  This filed is to record points awarded.
    private int pointsAwarded;

    //According to instructions, we need one method to count loss of points.
    public void pointLoss(){}

    //According to instructions, we need one method to count gain of points.
    public void pointGain(){}

    // Dependent on hou many squares the finished route crossing central grid, bonus points should be considered.
    public void bonusGain(){}

    // This method is just to get the score.
    public int getScore(){
        return -1;
    }


}
