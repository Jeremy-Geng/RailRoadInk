package comp1110.ass2;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class IfDiceIsCreatedCorrectlyTest {

    @Test
    public void DiceIsCreatedCorrectlyTest() {
        String test = "A6A12";
        boolean[] re = {true, false};
        assertTrue("Test fail",RailroadInk.ifDiceCreate(test)==re[1]);
        }
     @Test
     public void DiceIsInRightDirection() {
        Dice a = new Dice();
        int b=3;
        boolean[]res = {true,false};
        assertTrue("Wrong direction!",RailroadInk.ifDiceRight(a,b)==res[1]);

     }

    }

