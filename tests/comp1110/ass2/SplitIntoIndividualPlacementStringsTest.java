package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SplitIntoIndividualPlacementStringsTest {
    @Test
    public void testOne() {
        String boardString = "A4A12B2B16A1B01A1B23S1B32A1A32B1B44B2A44A4C16A3D15A4D01A5D23A4E20B1F24A2F17A1F01B0G16A5C34A4C43A5C53A3D50A4D61S4E50A0F51A1F67S2E46B1E31A1F30A2G36A1G41B1G52";
        String[] placements = {"A4A12", "B2B16", "A1B01", "A1B23", "S1B32", "A1A32", "B1B44", "B2A44", "A4C16", "A3D15", "A4D01", "A5D23", "A4E20", "B1F24", "A2F17", "A1F01", "B0G16", "A5C34", "A4C43", "A5C53", "A3D50", "A4D61", "S4E50", "A0F51", "A1F67", "S2E46", "B1E31", "A1F30", "A2G36", "A1G41", "B1G52"};

        testSplit(boardString, placements);
    }

    @Test
    public void testTwo() {
        String boardString = "A3D61A3D53B0C52A0B52A2B63A4D41B0E60A0F61A3D31A3D23A2G30B0F34A3E32A1B01B2B10A1B21A0A63A4D01A1G41B0G12S2D10A4C10B2A10A2B33A1A30S4E11A4E21A3C21A3C31S5F11";
        String [] placements = {"A3D61", "A3D53", "B0C52", "A0B52", "A2B63", "A4D41", "B0E60", "A0F61", "A3D31", "A3D23", "A2G30", "B0F34", "A3E32", "A1B01", "B2B10", "A1B21", "A0A63", "A4D01", "A1G41", "B0G12", "S2D10", "A4C10", "B2A10", "A2B33", "A1A30", "S4E11", "A4E21", "A3C21", "A3C31", "S5F11"};

        testSplit(boardString, placements);
    }

    public void testSplit(String boardString, String [] placements){
        String [] individualPlaces = RailroadInk.splitIntoIndividualPlacementStrings(boardString);
        assertTrue( "RailroadInk.splitIntoIndividualPlacementStrings(\"" + boardString + "\") returned invalid split: " + (individualPlaces), (individualPlaces.length == placements.length) & (((individualPlaces.length)*5) == boardString.length()) & (individualPlaces[0].length() == 5));
    }
}