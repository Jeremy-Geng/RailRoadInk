package comp1110.ass2;
// this class is to design three different kinds of dice, for convenience, we applied enum.
public class Dice {

    public enum A{
        A0,
        A1,
        A2,
        A3,
        A4,
        A5,
        A6;

        void rotate(){}

        void flip(){}
    }

    public enum B{
        B0,
        B1,
        B2;

        void rotate(){}

        void flip(){}
    }

    public enum S{
        S0,
        S1,
        S2,
        S3,
        S4,
        S5;

        void rotate(){};

        void filp(){};
    }


}
