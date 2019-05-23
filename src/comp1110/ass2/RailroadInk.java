package comp1110.ass2;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class RailroadInk {
    private Dice a;

    /**
     * Determine whether a tile placement string is well-formed:
     * - it consists of exactly 5 characters;
     * - the first character represents a die A or B, or a special tile S
     * - the second character indicates which tile or face of the die (0-5 for die A and special tiles, or 0-2 for die B)
     * - the third character represents the placement row A-G
     * - the fourth character represents the placement column 0-6
     * - the fifth character represents the orientation 0-7
     *
     * @param tilePlacementString a candidate tile placement string
     * @return true if the tile placement is well formed
     */

//   @author Siqi Gu
    public static boolean isTilePlacementWellFormed(String tilePlacementString) {
 /*      int ascii = tilePlacementString.charAt(2);
        char[]chars = tilePlacementString.toCharArray();

        if (tilePlacementString.length()!=5){
            return false;
        }
        if ((chars[0] != 'A')
                && (chars[0]!= 'S')
                && (chars[0] != 'B')){
            return false;
        }
        if (chars[0]=='A'){
            if (Integer.parseInt(String.valueOf(tilePlacementString.charAt(1)))>5||Integer.parseInt(String.valueOf(tilePlacementString.charAt(1)))<0)
                return false;
        }
        if (chars[0]=='S'){
            if (Integer.parseInt(String.valueOf(tilePlacementString.charAt(1)))>5||Integer.parseInt(String.valueOf(tilePlacementString.charAt(1)))<0)
                return false;
        }
        if (chars[0]=='B'){
            if (Integer.parseInt(String.valueOf(tilePlacementString.charAt(1)))>2||Integer.parseInt(String.valueOf(tilePlacementString.charAt(1)))<0)
                return false;
        }
        if (ascii<65){
            return false;
        }
        if (ascii>71){
            return false;
        }
        if (Integer.parseInt(String.valueOf(tilePlacementString.charAt(3)))>6&&Integer.parseInt(String.valueOf(tilePlacementString.charAt(3)))<0){
            return false;
        }
        if (Integer.parseInt(String.valueOf(tilePlacementString.charAt(4)))>7&&Integer.parseInt(String.valueOf(tilePlacementString.charAt(4)))<0){
            return false;*/

        boolean test = true;

//        According to the documentation, there should be six conditions to test the tile Placement String

//        Condition 1:
        if(tilePlacementString.length() != 5) test = false;
        if(test) {
//        Condition 2:
            if (tilePlacementString.charAt(0) != 'A' && tilePlacementString.charAt(0) != 'B' && tilePlacementString.charAt(0) != 'S')
                test = false;

//        Condition 3:
            if (tilePlacementString.charAt(0) == 'A' || tilePlacementString.charAt(0) == 'S')
                if (tilePlacementString.charAt(1) - '0' > 5 || tilePlacementString.charAt(1) - '0' < 0) test = false;
            if (tilePlacementString.charAt(0) == 'B')
                if (tilePlacementString.charAt(1) - '0' > 2 || tilePlacementString.charAt(1) - '0' < 0) test = false;

//        Condition 4:
            if (tilePlacementString.charAt(2) - 'A' < 0 || tilePlacementString.charAt(2) - 'A' > 6) test = false;

//        Condition 5:
            if (tilePlacementString.charAt(3) - '0' < 0 || tilePlacementString.charAt(3) - '0' > 6) test = false;

//        Condtion 6:
            if (tilePlacementString.charAt(4) - '0' < 0 || tilePlacementString.charAt(4) - '0' > 7) test = false;
        }
        return test;
    }


    /**
     * Determine whether a board string is well-formed:
     * - it consists of exactly N five-character tile placements (where N = 1 .. 31);
     * - each piece placement is well-formed
     * - no more than three special tiles are included
     *
     * @param boardString a board string describing the placement of one or more pieces
     * @return true if the board string is well-formed
     */

    //   @author Siqi Gu
    public static boolean isBoardStringWellFormed(String boardString) {
        /*if (boardString==null){
            return false;        }
        Pattern pattern = Pattern.compile("S");
        Matcher matcher = pattern.matcher(boardString);
        int cont = 0;
        while(matcher.find()){
            cont++;
            {if (cont>3){
                return false;
            }
            }
        }
        int length = boardString.length();
        if (length==0){
            return false;
        }
        if (length%5!=0) {
            return false;
        }
        if (length>155){
            return false;
        }
        return true;*/

        boolean test = true;

//      To check whether Board String is an effective and meaningful one

        if(boardString == null)  return false;
        if(boardString.equals(""))   test = false;

//        According to the documentation, a well-formed Board String should satisfy 3 conditions

//        Condition 1
        if(boardString.length() % 5 != 0 || boardString.length() > 155) test = false;

        if(test) {
//        Condition 2
            int numberOfTiles = boardString.length() / 5;
            String[] arrayOfTiles = new String[numberOfTiles];

//        To spilt Board String into tile Placement string

            for (int i = 0; i < boardString.length(); i += 5) {
                arrayOfTiles[i / 5] = boardString.substring(i, i + 5);
            }
            for (int i = 0; i < arrayOfTiles.length; i++) {
                if (!isTilePlacementWellFormed(arrayOfTiles[i])) test = false;
            }

//        Condition 3
            int CountOfSpecialTile = 0;
            for (int i = 0; i < arrayOfTiles.length; i++) {
                if (arrayOfTiles[i].charAt(0) == 'S') CountOfSpecialTile++;
            }
            if (CountOfSpecialTile > 3) test = false;
        }
        return test;
    }


    /**
     * Determine whether the provided placements are neighbours connected by at least one validly connecting edge.
     * For example,
     * - areConnectedNeighbours("A3C10", "A3C23") would return true as these tiles are connected by a highway edge;
     * - areConnectedNeighbours("A3C23", "B1B20") would return false as these neighbouring tiles are disconnected;
     * - areConnectedNeighbours("A0B30", "A3B23") would return false as these neighbouring tiles have an
     * invalid connection between highway and railway; and
     * areConnectedNeighbours("A0B30", "A3C23") would return false as these tiles are not neighbours.
     *
     * @return true if the placements are connected neighbours
     */

//  @author Shuhao Geng
    public static boolean areConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
        boolean test = true;

        test = ifNeighbours(tilePlacementStringA,tilePlacementStringB);

        if(test) {
        Dice oneTile = null;
        Dice anotherTile = null;

            oneTile = diceCreator(tilePlacementStringA);
            anotherTile = diceCreator(tilePlacementStringB);

            oneTile = diceRotatorOrFliper(oneTile, tilePlacementStringA.charAt(4) - '0');
            anotherTile = diceRotatorOrFliper(anotherTile, tilePlacementStringB.charAt(4) - '0');

            if (tilePlacementStringA.charAt(2) == tilePlacementStringB.charAt(2)) {
                if (tilePlacementStringA.charAt(3) < tilePlacementStringB.charAt(3)) {
                    if (oneTile.getEastPassage() != anotherTile.getWestPassage() || oneTile.getEastPassage() == '!') test = false;
                } else {
                    if (oneTile.getWestPassage() != anotherTile.getEastPassage()|| oneTile.getWestPassage() == '!') test = false;
                }
            }

            if (tilePlacementStringA.charAt(3) == tilePlacementStringB.charAt(3)) {
                if (tilePlacementStringA.charAt(2) < tilePlacementStringB.charAt(2)) {
                    if (oneTile.getSouthPassage() != anotherTile.getNorthPassage() || oneTile.getSouthPassage() == '!')
                        test = false;
                } else {
                    if (oneTile.getNorthPassage() != anotherTile.getSouthPassage() || oneTile.getNorthPassage() == '!')
                        test = false;
                }
            }
        }
        return test;
    }

    //  @author Shuhao Geng
    public static boolean ifNeighbours(String a, String b){
        boolean test = true;
        if(a.charAt(2) == b.charAt(2)){
            if(Math.abs(a.charAt(3) - b.charAt(3)) != 1) test = false;
        }else if ( a.charAt(3) == b.charAt(3)) {
            if(Math.abs(a.charAt(2) - b.charAt(2)) != 1) test = false;
        }else{ test = false;}
        return test;
    }

    //  @author Shuhao Geng
    public static Dice diceCreator(String tilePlacementString){
        Dice a = null;
        if(tilePlacementString.charAt(0) == 'A'){
            a = new A(tilePlacementString.charAt(1) - '0');
        }else if(tilePlacementString.charAt(0) == 'B'){
            a = new B(tilePlacementString.charAt(1) - '0');
        }else if(tilePlacementString.charAt(0) == 'S'){
            a = new S(tilePlacementString.charAt(1) - '0');
        }
        a.setIdentityInfo(tilePlacementString);
        return  a;
    }
    public static boolean ifDiceCreate(String a){
        boolean test = true;
        if (a.charAt(1)>5){
            test = false;
        }
        return test;
    }

    //  @author Shuhao Geng
    public static Dice diceRotatorOrFliper(Dice a, int b){
        if(b <= 3){
            for(int i = 1; i<=b;i++){
                a.rotate90Degree();
            }
        }

        if(b > 3){
            a.flip();
            for(int i =1;i<=b-4; i++){
                a.rotate90Degree();
            }
        }
        return  a;
    }

    //  @author Shuhao Geng
    public static boolean ifDiceRight(Dice a, int b){
        boolean test = true;
        if (b<=3){
            a.flip();
            test = false;
        }
        if (b>3){
            a.rotate90Degree();
            test = false;
        }
        return test;
    }



    /**
     * Given a well-formed board string representing an ordered list of placements,
     * determine whether the board string is valid.
     * A board string is valid if each tile placement is legal with respect to all previous tile
     * placements in the string, according to the rules for legal placements:
     * - A tile must be placed such that at least one edge connects to either an exit or a pre-existing route.
     *   Such a connection is called a valid connection.
     * - Tiles may not be placed such that a highway edge connects to a railway edge;
     *   this is referred to as an invalid connection.
     *   Highways and railways may only join at station tiles.
     * - A tile may have one or more edges touching a blank edge of another tile;
 v     *
     * @param boardString a board string representing some placement sequence
     * @return true if placement sequence is valid
     */

    //  @author Shuhao Geng
    public static boolean isValidPlacementSequence(String boardString) {
        boolean test = true;
        Board grid = new Board();

        if(isBoardStringWellFormed(boardString)) {
            int numberOfTiles = boardString.length() / 5;
            Dice[] arrayOfDice = new Dice[numberOfTiles];
            String[] arrayOfPlacement = new String[numberOfTiles];

//        To spilt Board String into tile Placement string
            
            for (int i = 0; i < boardString.length(); i += 5) {
                arrayOfPlacement[i / 5] = boardString.substring(i, i + 5);
            }
            for (int i = 0; i < arrayOfDice.length; i++) {
                arrayOfDice[i] = diceCreator(arrayOfPlacement[i]);
                arrayOfDice[i] = diceRotatorOrFliper(arrayOfDice[i], arrayOfPlacement[i].charAt(4) - '0');
            }

            char gateFirst  = grid.board[arrayOfPlacement[0].charAt(2)-'A'][arrayOfPlacement[0].charAt(3) - '0'].getGate();
            if(gateFirst !='!'){
                if(!ifConnectedToGateCorrectly(arrayOfPlacement[0],arrayOfDice[0],gateFirst)) test = false;
                grid.board[arrayOfPlacement[0].charAt(2)-'A'][arrayOfPlacement[0].charAt(3) - '0'].setDice(arrayOfDice[0]);
                grid.board[arrayOfPlacement[0].charAt(2)-'A'][arrayOfPlacement[0].charAt(3) - '0'].ifFilled = true;
            }else{
                test = false;
                return  test;}

            for(int i = 1;i < arrayOfPlacement.length ;i++){
                if(grid.board[arrayOfPlacement[i].charAt(2)-'A'][arrayOfPlacement[i].charAt(3) - '0'].ifFilled) {
                    test = false;
                    return test;
                }
                boolean ifValid = false;
                char gateAccordingly = grid.board[arrayOfPlacement[i].charAt(2)-'A'][arrayOfPlacement[i].charAt(3) - '0'].getGate();
                if(gateAccordingly != '!'){
                    if(!ifConnectedToGateCorrectly(arrayOfPlacement[i],arrayOfDice[i],gateAccordingly)) test = false;
                    else{
                        grid.board[arrayOfPlacement[i].charAt(2)-'A'][arrayOfPlacement[i].charAt(3) - '0'].setDice(arrayOfDice[i]);
                        grid.board[arrayOfPlacement[i].charAt(2)-'A'][arrayOfPlacement[i].charAt(3) - '0'].ifFilled = true;
                    }
                }
                if(test && gateAccordingly == '!' ){
                    test = checkWhetherCanBeFilled(grid,ifValid,arrayOfPlacement[i].charAt(2)-'A',arrayOfPlacement[i].charAt(3) - '0',arrayOfPlacement[i],arrayOfDice[i]);
                    if(test){
                        grid.board[arrayOfPlacement[i].charAt(2)-'A'][arrayOfPlacement[i].charAt(3) - '0'].setDice(arrayOfDice[i]);
                        grid.board[arrayOfPlacement[i].charAt(2)-'A'][arrayOfPlacement[i].charAt(3) - '0'].ifFilled = true;
                    }
                }
                if(!test) break;
            }

        }
        return test;
    }

    //  @author Shuhao Geng
    //  THe method is for checking whether one tile is connected to gate correctly.
    public static boolean ifConnectedToGateCorrectly(String placementofDice,Dice dice,char gate){
        boolean test = true;
            if (placementofDice.charAt(2) == 'A') {
                if(dice.getNorthPassage() != '!'){
                    if (dice.getNorthPassage() != gate) test = false;
                }
            } else if (placementofDice.charAt(2) == 'B' || placementofDice.charAt(2) == 'D'|| placementofDice.charAt(2) == 'F' ) {
                if (placementofDice.charAt(3)  == '0') {
                    if(dice.getWestPassage() != '!'){
                        if (dice.getWestPassage() != gate) test = false;
                    }
                } else if (placementofDice.charAt(3) == '6') {
                    if(dice.getEastPassage() != '!'){
                        if (dice.getEastPassage() != gate) test = false;
                    }
                }
            } else if (placementofDice.charAt(2) == 'G') {
                if(dice.getSouthPassage() != '！'){
                    if (dice.getSouthPassage() != gate) test = false;
                }
            }
        return test;
    }

    /**
     * Generate a random dice roll as a string of eight characters.
     * Dice A should be rolled three times, dice B should be rolled once.
     * Die A has faces numbered 0-5.
     * Die B has faces numbered 0-2.
     * Each die roll is composed of a character 'A' or 'B' representing the dice,
     * followed by a digit character representing the face.
     *
     * @return a String representing the die roll e.g. A0A4A3B2
     */

    //  @author Siqi Gu
    public static String generateDiceRoll() {
        String randomdiceroll = "";
        Random rand = new Random();
        for(int i = 0;i<4;i++){
            int faceNumberOfA = rand.nextInt(6);
            int faceNUmberOfb = rand.nextInt(3);
            if(i<3){
                randomdiceroll = randomdiceroll + "A" + faceNumberOfA;
            }else{
                randomdiceroll = randomdiceroll + "B" + faceNUmberOfb;
            }
        }
        return randomdiceroll;
    }

    /**
     * Given the current state of a game board, output an integer representing the sum of all the following factors
     * that contribute to the player's final score.
     * <p>
     * * Number of exits mapped
     * * Number of centre tiles used
     * * Number of dead ends in the network
     *
     * @param boardString a board string representing a completed game
     * @return integer (positive or negative) for score *not* considering longest rail/highway
     */

    //  @author Shuhao Geng
    public static int getBasicScore(String boardString) {
        int basicScore = 0;
        if(isValidPlacementSequence(boardString)){
            Board grid = new Board();
            int numberOfTiles = boardString.length() / 5;
            Dice[] arrayOfDice = new Dice[numberOfTiles];
            String[] arrayOfPlacement = new String[numberOfTiles];

            for (int i = 0; i < boardString.length(); i += 5) {
                arrayOfPlacement[i / 5] = boardString.substring(i, i + 5);
            }

            for (int i = 0; i < arrayOfDice.length; i++) {
                arrayOfDice[i] = diceCreator(arrayOfPlacement[i]);
                arrayOfDice[i] = diceRotatorOrFliper(arrayOfDice[i], arrayOfPlacement[i].charAt(4) - '0');
            }

            for(int i = 0;i<arrayOfDice.length;i++){
                grid.board[arrayOfPlacement[i].charAt(2) - 'A'][arrayOfPlacement[i].charAt(3) - '0'].setDice(arrayOfDice[i]);
            }

            ArrayList<Tile> filledTiles = new ArrayList<Tile>();

            for(int i =0;i < grid.board.length;i++){
                for(int j = 0;j<grid.board[i].length;j++){
                    if(grid.board[i][j].ifFilled()) {
                        filledTiles.add(grid.board[i][j]);
                    }
                }
            }

            ArrayList<Tile> gatesFilled = new ArrayList<Tile>();
            for(int i = 0;i<arrayOfDice.length;i++){
                if(grid.board[arrayOfPlacement[i].charAt(2) - 'A'][arrayOfPlacement[i].charAt(3) - '0'].getGate() != '!'){
                    gatesFilled.add(grid.board[arrayOfPlacement[i].charAt(2) - 'A'][arrayOfPlacement[i].charAt(3) - '0']);
                }
            }
            int pointsPartOne = 0;
            for(int i = 0;i<gatesFilled.size();i++) {
                if (!gatesFilled.get(i).ifPassed()) {
                    int numberofGatesConnect = 0;
                    if (gatesFilled.get(i).ifOverpass()) {
                        if (gatesFilled.get(i).getDice().identityInfo.charAt(2) == 'A' || gatesFilled.get(i).getDice().identityInfo.charAt(2) == 'G') {
                            gatesFilled.get(i).ruleOverpass("column");
                        } else {
                            gatesFilled.get(i).ruleOverpass("row");
                        }
                    }
                    gatesFilled.get(i).travellerPasses(new Traveller());
                    ArrayList<Tile> eNeighbours = new ArrayList<Tile>();
                    eNeighbours.add(gatesFilled.get(i));
                    while (eNeighbours.size() != 0) {
                        ArrayList<Tile> newENeighbous = new ArrayList<Tile>();
                        for (int j = 0; j < eNeighbours.size(); j++) {
                            eNeighbours.get(j).travellerPasses(new Traveller());
                            if (eNeighbours.get(j).getGate() != '!') {
                                numberofGatesConnect++;
                            }
                            ArrayList<Tile> a = searchRoad(eNeighbours.get(j), filledTiles);
                            for (int n = 0; n < a.size(); n++) {
                                newENeighbous.add(a.get(n));
                            }
                        }
                        for(int m = 0; m < newENeighbous.size()-1;m++){
                            if(newENeighbous.get(m+1).getDice().identityInfo.equals(newENeighbous.get(m).getDice().identityInfo)){
                                newENeighbous.remove(m);
                            }
                        }
                        eNeighbours = newENeighbous;

                    }
                    pointsPartOne = pointsPartOne + pointsAwardedforGatesConnected(numberofGatesConnect);
                }
            }


            int pointsPartTwo = 0;
            for(int i = 0;i < grid.board.length;i++){
                for(int j = 0;j < grid.board[i].length;j++){
                    if(grid.board[i][j].getDice() != null){
                        if(i == 0 && j == 0){
                            if(grid.board[i][j].getDice().getEastPassage() != '!'){
                                if(grid.board[i][j+1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j+1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getSouthPassage() != '!'){
                                if(grid.board[i+1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i+1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }

                        }
                        else if(i == 0 && j ==6){
                            if(grid.board[i][j].getDice().getWestPassage() !='!'){
                                if(grid.board[i][j-1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j-1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getSouthPassage() != '!'){
                                if(grid.board[i+1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i+1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                        }
                        else if(i == 6 && j == 0){
                            if(grid.board[i][j].getDice().getEastPassage() !='!'){
                                if(grid.board[i][j+1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j+1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getNorthPassage() != '!'){
                                if(grid.board[i-1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i-1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }

                        }
                        else if(i == 6 && j == 6){
                            if(grid.board[i][j].getDice().getWestPassage() !='!'){
                                if(grid.board[i][j-1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j-1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getNorthPassage() != '!'){
                                if(grid.board[i-1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i-1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }

                        }
                        else if(i == 0 && j >= 1 && j <=5){
                            if(grid.board[i][j].getDice().getEastPassage() !='!'){
                                if(grid.board[i][j+1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j+1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getWestPassage() !='!'){
                                if(grid.board[i][j-1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j-1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getSouthPassage() != '!'){
                                if(grid.board[i+1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i+1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                        }
                        else if(i == 6 && j >= 1 && j <=5){
                            if(grid.board[i][j].getDice().getEastPassage() !='!'){
                                if(grid.board[i][j+1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j+1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getWestPassage() !='!'){
                                if(grid.board[i][j-1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j-1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getNorthPassage() != '!'){
                                if(grid.board[i-1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i-1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }

                        }
                        else if(j == 0 && i >= 1 && i <=5){
                            if(grid.board[i][j].getDice().getEastPassage() !='!'){
                                if(grid.board[i][j+1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j+1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getSouthPassage() !='!'){
                                if(grid.board[i+1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i+1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getNorthPassage() != '!'){
                                if(grid.board[i-1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i-1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                        }
                        else if(j == 6 && i >= 1 && i <=5){
                            if(grid.board[i][j].getDice().getWestPassage() !='!'){
                                if(grid.board[i][j-1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j-1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getSouthPassage() !='!'){
                                if(grid.board[i+1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i+1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getNorthPassage() != '!'){
                                if(grid.board[i-1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i-1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                        }else{
                            if(grid.board[i][j].getDice().getEastPassage() !='!'){
                                if(grid.board[i][j+1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j+1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getWestPassage() !='!'){
                                if(grid.board[i][j-1].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i][j-1].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getSouthPassage() !='!'){
                                if(grid.board[i+1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i+1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                            if(grid.board[i][j].getDice().getNorthPassage() != '!'){
                                if(grid.board[i-1][j].getDice() == null) pointsPartTwo++;
                                else{
                                    if(!areConnectedNeighbours(grid.board[i][j].getDice().identityInfo,grid.board[i-1][j].getDice().identityInfo)) pointsPartTwo++;
                                }
                            }
                        }
                    }
                }
            }


            int pointsPartThree = 0;
            for(int i = 2;i < 5;i++){
                for(int j = 2;j < 5;j++){
                    if(grid.board[i][j].getDice() != null) pointsPartThree++;
                }
            }

            basicScore = pointsPartOne + pointsPartThree - pointsPartTwo;
        }
        return basicScore;
    }

    //  @author Shuhao Geng
    public static ArrayList<Tile> searchRoad(Tile whereTravellerStays, ArrayList<Tile> filledTiles){
        ArrayList<Tile> effectiveNeighbours = new ArrayList<Tile>();
        for(int i = 0;i < filledTiles.size();i++){
            if(!filledTiles.get(i).ifPassed() || !filledTiles.get(i).ifRowOfOverpassPassed() ||!filledTiles.get(i).ifRowOfOverpassPassed()) {
                if (areConnectedNeighbours(whereTravellerStays.getDice().identityInfo, filledTiles.get(i).getDice().identityInfo)) {
                    if(whereTravellerStays.ifOverpass()){
                        if(whereTravellerStays.mark.equals("row")) {
                                if (whereTravellerStays.getDice().identityInfo.charAt(2) == filledTiles.get(i).getDice().identityInfo.charAt(2)) {
                                    if(filledTiles.get(i).ifOverpass()){
                                        if(!filledTiles.get(i).ifRowOfOverpassPassed()){
                                            effectiveNeighbours.add(filledTiles.get(i));
                                            whereTravellerStays.rowTravellerPasses(new Traveller());
                                            filledTiles.get(i).ruleOverpass(decomposeOverpass(whereTravellerStays.getDice(),filledTiles.get(i).getDice()));
                                        }
                                    }else{
                                    effectiveNeighbours.add(filledTiles.get(i));
                                    whereTravellerStays.rowTravellerPasses(new Traveller());
                                    }
                                }

                        }else if(whereTravellerStays.mark.equals("column")){
                            if(whereTravellerStays.getDice().identityInfo.charAt(3) == filledTiles.get(i).getDice().identityInfo.charAt(3)){
                                if(filledTiles.get(i).ifOverpass()){
                                    if(!filledTiles.get(i).ifColumnOfOverpassPassed()){
                                        effectiveNeighbours.add(filledTiles.get(i));
                                        whereTravellerStays.columnTravellerPasses(new Traveller());
                                        filledTiles.get(i).ruleOverpass(decomposeOverpass(whereTravellerStays.getDice(),filledTiles.get(i).getDice()));
                                    }

                                }else{
                                effectiveNeighbours.add(filledTiles.get(i));
                                whereTravellerStays.columnTravellerPasses(new Traveller());
                                }
                            }
                        }
                    }
                    else{
                    if(filledTiles.get(i).ifOverpass()){
                        if(decomposeOverpass(whereTravellerStays.getDice(),filledTiles.get(i).getDice()).equals("row")){
                            if(!filledTiles.get(i).ifRowOfOverpassPassed()){
                                effectiveNeighbours.add(filledTiles.get(i));
                                filledTiles.get(i).ruleOverpass(decomposeOverpass(whereTravellerStays.getDice(),filledTiles.get(i).getDice()));

                            }
                        }else if(decomposeOverpass(whereTravellerStays.getDice(),filledTiles.get(i).getDice()).equals("column")){
                            if(!filledTiles.get(i).ifColumnOfOverpassPassed()){
                                effectiveNeighbours.add(filledTiles.get(i));
                                filledTiles.get(i).ruleOverpass(decomposeOverpass(whereTravellerStays.getDice(),filledTiles.get(i).getDice()));
                            }
                        }
                    }else{
                        effectiveNeighbours.add(filledTiles.get(i));
                    }
                    }
                }
            }
        }
        return effectiveNeighbours;
     }

     public static String decomposeOverpass(Dice a, Dice overpass ){
           String direction = "";
           if(a.identityInfo.charAt(2) == overpass.identityInfo.charAt(2)){
               direction = "row";
           }else{
               direction = "column";
           }
           return  direction;
     }

     public static int pointsAwardedforGatesConnected(int numberofGatesConnect){
        int points = 0;
        if(numberofGatesConnect == 2){
            points = 4;
        }else if(numberofGatesConnect ==3 ){
            points = 8;
        }else if(numberofGatesConnect == 4){
            points = 12;
        }else if(numberofGatesConnect == 5){
            points = 16;
        }else if (numberofGatesConnect == 6){
            points = 20;
        }else if(numberofGatesConnect == 7){
            points = 24;
        }else if( numberofGatesConnect == 8){
            points = 28;
        }else if(numberofGatesConnect == 9){
            points = 32;
        }else if(numberofGatesConnect == 10){
            points = 36;
        }else if(numberofGatesConnect == 11){
            points = 40;
        }else if(numberofGatesConnect == 12){
            points = 45;
        }

        return points;
     }

    /**
     * Given a valid boardString and a dice roll for the round,
     * return a String representing an ordered sequence of valid piece placements for the round.
     * @param boardString a board string representing the current state of the game as at the start of the round
     * @param diceRoll a String representing a dice roll for the round
     * @return a String representing an ordered sequence of valid piece placements for the current round
     * @see RailroadInk#generateDiceRoll()
     */
    // @author  Kathia Anyosa
    public static String generateMove(String boardString, String diceRoll) {
<<<<<<< HEAD
        // FIXME Task 10: generate a valid move
        String[] available = availableLocations(tileLocations(splitIntoIndividualPlacementStrings(boardString)));
        String[] tls = tiles(diceRoll);
        String[] moves = possibleMoves(tls, available);
        String[] valid = validMoves(boardString, moves);
        //Play first move then remove tile from tles and remove position from available, and get new valid moves
        //play next move and repeat until all tiles are played, or there are no more valid moves
        return null;
=======
//        String[] available = availableLocations(tileLocations(splitIntoIndividualPlacementStrings(boardString)));
//        String[] tls = tiles(diceRoll);
//        String[] moves = possibleMoves(tls, available);
//        String[] valid = validMoves(boardString, moves);
//        for (int i = 0; i+1 < valid.length; i++){
//            String generatedMoves = valid[i]+valid[i+1];
//        }

        Board grid = new Board();
        for(int i = 0; i < grid.board.length; i++){
            for(int j = 0; j < grid.board[i].length;j++){
                char row = (char)('A'+ i);
                int col = j;
                grid.board[i][j].name = Character.toString(row) + Integer.toString(col);
            }
        }

        int numberOfTiles = boardString.length() / 5;
        Dice[] arrayOfDice = new Dice[numberOfTiles];
        String[] arrayOfPlacement = new String[numberOfTiles];

        for (int i = 0; i < boardString.length(); i += 5) {
            arrayOfPlacement[i / 5] = boardString.substring(i, i + 5);
        }

        for (int i = 0; i < arrayOfDice.length; i++) {
            arrayOfDice[i] = diceCreator(arrayOfPlacement[i]);
            arrayOfDice[i] = diceRotatorOrFliper(arrayOfDice[i], arrayOfPlacement[i].charAt(4) - '0');
        }

        for(int i = 0;i<arrayOfDice.length;i++){
            grid.board[arrayOfPlacement[i].charAt(2) - 'A'][arrayOfPlacement[i].charAt(3) - '0'].setDice(arrayOfDice[i]);
            grid.board[arrayOfPlacement[i].charAt(2) - 'A'][arrayOfPlacement[i].charAt(3) - '0'].ifFilled = true;
        }

        String os = "";

        ArrayList<String> validMoves = new ArrayList<>();
        ArrayList<String> a =validMoves(grid,boardString,diceRoll,validMoves);
        for(int i = 0; i < a.size();i++){
            os = os + a.get(i);
        }

        return os;
    }

    public static ArrayList<String> validMoves (Board grid,String boardString, String diceRoll,ArrayList<String> storage){
        if(diceRoll.length() == 0) return  null;

        ArrayList<Tile> blackTiles = new ArrayList<>();

        for(int i=0;i < grid.board.length;i++){
            for(int j = 0 ; j< grid.board[i].length;j++){
                if(!grid.board[i][j].ifFilled){
                    blackTiles.add(grid.board[i][j]);
                }
            }
        }
        String[] diceBuilers = new String[diceRoll.length()/2];
        String placeInfo = new String();


        for(int i = 0;i<diceBuilers.length;i++){
            diceBuilers[i]  = diceRoll.substring(i*2,i*2+2);
        }


        for(int i = 0;i < diceBuilers.length;i++){
            boolean ifValidPlaced = false;
            if(diceBuilers[i].charAt(0) == 'A'){
                for(int j = 0; j <=3 ;j++){
                    ifValidPlaced = false;
                    for(int k = 0;k < blackTiles.size();k++){
                                placeInfo = diceBuilers[i] +blackTiles.get(k).name + j;
                                Dice validDice = diceCreator(placeInfo);
                                validDice = diceRotatorOrFliper(validDice, placeInfo.charAt(4) - '0');
                                int m = blackTiles.get(k).name.charAt(0) - 'A';
                                int n = blackTiles.get(k).name.charAt(1) - '0';
                                ifValidPlaced = checkWhetherCanBeFilled(grid,ifValidPlaced,m,n,placeInfo,validDice);
                                if(ifValidPlaced){
                                    boardString = boardString + placeInfo;
//                                    orderedSequence  = orderedSequence +placeInfo;
                                    storage.add(placeInfo);
                                    grid.board[m][n].setDice(validDice);
                                    grid.board[m][n].ifFilled = true;
                                    blackTiles.remove(k);
                                    String newDiceroll = "";
                                    for(int q = 0; q <diceBuilers.length;q++){
                                        if(q!=i){
                                            newDiceroll = newDiceroll + diceBuilers[q];
                                        }
                                    }
//                                    System.out.println(orderedSequence);
                                    validMoves(grid,boardString,newDiceroll,storage);
                                    break;
                                }

                        if(ifValidPlaced) break;
                    }
                    if(ifValidPlaced) break;
                }
            }else if(diceBuilers[i].charAt(0) == 'B'){
                for(int j= 0; j <=7 ;j++){
                    for( int k = 0; k <blackTiles.size();k++){
                                placeInfo = diceBuilers[i] + blackTiles.get(k).name + j;
                                Dice validDice = diceCreator(placeInfo);
                                validDice = diceRotatorOrFliper(validDice, placeInfo.charAt(4) - '0');
                                int m = blackTiles.get(k).name.charAt(0) - 'A';
                                int n = blackTiles.get(k).name.charAt(1) - '0';
                                ifValidPlaced = checkWhetherCanBeFilled(grid,ifValidPlaced,m,n,placeInfo,validDice);
                                if(ifValidPlaced){
                                    boardString = boardString + placeInfo;
//                                    orderedSequence  = orderedSequence +placeInfo;
                                    storage.add(placeInfo);
                                    grid.board[m][n].setDice(validDice);
                                    grid.board[m][n].ifFilled = true;
                                    blackTiles.remove(k);
                                    String newDiceroll = "";
                                    for(int q = 0; q <diceBuilers.length;q++){
                                        if(q!=i){
                                            newDiceroll = newDiceroll + diceBuilers[q];
                                        }
                                    }
                                      validMoves(grid,boardString,newDiceroll,storage);

                                    break;
                                }


                        if(ifValidPlaced) break;
                    }
                   if(ifValidPlaced) break;
                }
            }
            if(ifValidPlaced) break;
        }

//        System.out.println(orderedSequence);
        return storage;
    }

    public static boolean checkWhetherCanBeFilled(Board grid, boolean ifValidPlaced, int m, int n,String placeInfo,Dice dice){
//  check gates
       if(m == 0 && (n == 1 || n == 3 || n == 5)){
           if(dice.getNorthPassage() == grid.board[m][n].getGate()) ifValidPlaced = true;
       }else if ( m == 6 &&( n == 1 || n == 3 || n == 5)){
           if(dice.getSouthPassage() == grid.board[m][n].getGate()) ifValidPlaced = true;
       }else if( n == 0 && ( m == 1 || m == 3|| m ==5)){
           if(dice.getWestPassage() == grid.board[m][n].getGate())  ifValidPlaced = true;
       }else if(n == 6 && ( m == 1 || m == 3|| m ==5)){
           if(dice.getEastPassage() == grid.board[m][n].getGate()) ifValidPlaced = true;
        }
//  check normal tiles
        if(m == 0 && n == 0){
            if(grid.board[0][1].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[0][1].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[1][0].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[1][0].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(dice.getSouthPassage() != '!'){
                if(grid.board[1][0].ifFilled && grid.board[1][0].getDice().getNorthPassage() != '!'){
                        if(dice.getSouthPassage() != grid.board[1][0].getDice().getNorthPassage()
                        )
                        ifValidPlaced = false;

                }
            }

            if(dice.getEastPassage() != '!'){
                if(grid.board[0][1].ifFilled && grid.board[0][1].getDice().getWestPassage() != '!'){
                    if(dice.getEastPassage() != grid.board[0][1].getDice().getWestPassage() ){
                        ifValidPlaced = false;
                    }
                }

            }


        }else if(m == 6 && n == 0){
            if(grid.board[6][1].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[6][1].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[5][0].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[5][0].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(dice.getNorthPassage() != '!'){
                if(grid.board[5][0].ifFilled && grid.board[5][0].getDice().getSouthPassage() != '!'){
                    if(dice.getNorthPassage() != grid.board[5][0].getDice().getSouthPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getEastPassage() != '!'){
                if(grid.board[6][1].ifFilled && grid.board[6][1].getDice().getWestPassage() != '!'){
                    if(dice.getEastPassage() != grid.board[6][1].getDice().getWestPassage()){
                        ifValidPlaced = false;
                    }
                }

            }



        }else if(m == 0 && n == 6){
            if(grid.board[0][5].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[0][5].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[1][6].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[1][6].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(dice.getWestPassage() != '!'){
                if(grid.board[0][5].ifFilled && grid.board[0][5].getDice().getEastPassage() != '!' ){
                    if(dice.getWestPassage() != grid.board[0][5].getDice().getEastPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getSouthPassage() != '!'){
                if(grid.board[1][6].ifFilled && grid.board[1][6].getDice().getNorthPassage() != '!'){
                    if(dice.getSouthPassage() != grid.board[1][6].getDice().getNorthPassage() ){
                        ifValidPlaced = false;
                    }
                }
            }


        }else if(m == 6 && n == 6 ){
            if(grid.board[5][6].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[5][6].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[6][5].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[6][5].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(dice.getNorthPassage() != '!'){
                if(grid.board[5][6].ifFilled && grid.board[5][6].getDice().getSouthPassage() != '!'){
                    if(dice.getNorthPassage() != grid.board[5][6].getDice().getSouthPassage() ){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getWestPassage() != '!'){
                if(grid.board[6][5].ifFilled && grid.board[6][5].getDice().getEastPassage() != '!'){
                    if(dice.getWestPassage() != grid.board[6][5].getDice().getEastPassage() ){
                        ifValidPlaced = false;
                    }
                }
            }

        }else if(m == 0 && n >0 && n <6){
            if(grid.board[m+1][n].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m+1][n].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m][n-1].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m][n-1].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m][n+1].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m][n+1].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }



            if(dice.getSouthPassage() != '!'){
                if(grid.board[m+1][n].ifFilled && grid.board[m+1][n].getDice().getNorthPassage() != '!'){
                    if(dice.getSouthPassage() != grid.board[m+1][n].getDice().getNorthPassage() ){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getWestPassage() != '!'){
                if(grid.board[m][n-1].ifFilled && grid.board[m][n-1].getDice().getEastPassage() != '!'){
                    if(dice.getWestPassage() != grid.board[m][n-1].getDice().getEastPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getEastPassage() != '!'){
                if(grid.board[m][n+1].ifFilled && grid.board[m][n+1].getDice().getWestPassage() != '!' ){
                    if(dice.getEastPassage() != grid.board[m][n+1].getDice().getWestPassage()){
                        ifValidPlaced = false;
                    }
                }

            }

        }else if(m == 6 && n >0 && n <6){
            if(grid.board[m-1][n].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m-1][n].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m][n-1].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m][n-1].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m][n+1].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m][n+1].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(dice.getNorthPassage() != '!'){
                if(grid.board[m-1][n].ifFilled && grid.board[m-1][n].getDice().getSouthPassage() != '!' ){
                    if(dice.getNorthPassage() != grid.board[m-1][n].getDice().getSouthPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getEastPassage() != '!'){
                if(grid.board[m][n+1].ifFilled && grid.board[m][n+1].getDice().getWestPassage() != '!' ){
                    if(dice.getEastPassage() != grid.board[m][n+1].getDice().getWestPassage()){
                        ifValidPlaced = false;
                    }
                }

            }

            if(dice.getWestPassage() != '!'){
                if(grid.board[m][n-1].ifFilled && grid.board[m][n-1].getDice().getEastPassage() != '!'){
                    if(dice.getWestPassage() != grid.board[m][n-1].getDice().getEastPassage()){
                        ifValidPlaced = false;
                    }
                }
            }



        }else if(n == 0 && m >0 && m <6){
            if(grid.board[m][n+1].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m][n+1].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m+1][n].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m+1][n].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m-1][n].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m-1][n].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(dice.getNorthPassage() != '!'){
                if(grid.board[m-1][n].ifFilled && grid.board[m-1][n].getDice().getSouthPassage() != '!' ){
                    if(dice.getNorthPassage() != grid.board[m-1][n].getDice().getSouthPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getEastPassage() != '!'){
                if(grid.board[m][n+1].ifFilled && grid.board[m][n+1].getDice().getWestPassage() != '!' ){
                    if(dice.getEastPassage() != grid.board[m][n+1].getDice().getWestPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getSouthPassage() != '!'){
                if(grid.board[m+1][n].ifFilled && grid.board[m+1][n].getDice().getNorthPassage() != '!'){
                    if(dice.getSouthPassage() != grid.board[m+1][n].getDice().getNorthPassage() ){
                        ifValidPlaced = false;
                    }
                }
            }

        }else if(n == 6 && m >0 && m <6){
            if(grid.board[m][n-1].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m][n-1].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m+1][n].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m+1][n].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m-1][n].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m-1][n].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(dice.getNorthPassage() != '!'){
                if(grid.board[m-1][n].ifFilled && grid.board[m-1][n].getDice().getSouthPassage() != '!' ){
                    if(dice.getNorthPassage() != grid.board[m-1][n].getDice().getSouthPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getSouthPassage() != '!'){
                if(grid.board[m+1][n].ifFilled && grid.board[m+1][n].getDice().getNorthPassage() != '!'){
                    if(dice.getSouthPassage() != grid.board[m+1][n].getDice().getNorthPassage() ){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getWestPassage() != '!'){
                if(grid.board[m][n-1].ifFilled && grid.board[m][n-1].getDice().getEastPassage() != '!'){
                    if(dice.getWestPassage() != grid.board[m][n-1].getDice().getEastPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

        }else if(m > 0 && m < 6 && n>0 && n <6){
            if(grid.board[m][n-1].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m][n-1].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m][n+1].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m][n+1].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m+1][n].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m+1][n].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(grid.board[m-1][n].ifFilled){
                if(areConnectedNeighbours(placeInfo,grid.board[m-1][n].getDice().identityInfo)){
                    ifValidPlaced = true;
                }
            }

            if(dice.getNorthPassage() != '!'){
                if(grid.board[m-1][n].ifFilled && grid.board[m-1][n].getDice().getSouthPassage() != '!' ){
                    if(dice.getNorthPassage() != grid.board[m-1][n].getDice().getSouthPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getSouthPassage() != '!'){
                if(grid.board[m+1][n].ifFilled && grid.board[m+1][n].getDice().getNorthPassage() != '!'){
                    if(dice.getSouthPassage() != grid.board[m+1][n].getDice().getNorthPassage() ){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getWestPassage() != '!'){
                if(grid.board[m][n-1].ifFilled && grid.board[m][n-1].getDice().getEastPassage() != '!'){
                    if(dice.getWestPassage() != grid.board[m][n-1].getDice().getEastPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

            if(dice.getEastPassage() != '!'){
                if(grid.board[m][n+1].ifFilled && grid.board[m][n+1].getDice().getWestPassage() != '!' ){
                    if(dice.getEastPassage() != grid.board[m][n+1].getDice().getWestPassage()){
                        ifValidPlaced = false;
                    }
                }
            }

        }
        return ifValidPlaced;
>>>>>>> 3624928942980b3f28a79ac4a63f0b716d4ff056
    }






    // @author  Kathia Anyosa
    //Filter out illegal moves and return list of valid moves
    public static String[] validMoves(String boardString, String[] possible){
        ArrayList<String> valid = new ArrayList<>();
        for (int i = 0; i < possible.length; i ++){
            String combination = boardString + possible[i];
            if (isValidPlacementSequence(combination)){
                valid.add(possible[i]);
            }
        }
        String[] validMoves = valid.toArray(new String[0]);
        return validMoves;
    }

    // @author  Kathia Anyosa
    //Generates all possible moves by mixing available locations and tiles
    public static String[] possibleMoves(String[] tiles, String[] availableLocations){
        ArrayList<String> moves = new ArrayList<>();
        for (int i = 0; i < availableLocations.length; i ++){
//            moves.add(tiles[0]+availableLocations[i]+"0");
//            moves.add(tiles[0]+availableLocations[i]+"1");
//            moves.add(tiles[0]+availableLocations[i]+"2");
//            moves.add(tiles[0]+availableLocations[i]+"3");
//            moves.add(tiles[0]+availableLocations[i]+"4");
//            moves.add(tiles[0]+availableLocations[i]+"5");
//            moves.add(tiles[0]+availableLocations[i]+"6");
//            moves.add(tiles[0]+availableLocations[i]+"7");
//
//            moves.add(tiles[1]+availableLocations[i]+"0");
//            moves.add(tiles[1]+availableLocations[i]+"1");
//            moves.add(tiles[1]+availableLocations[i]+"2");
//            moves.add(tiles[1]+availableLocations[i]+"3");
//            moves.add(tiles[1]+availableLocations[i]+"4");
//            moves.add(tiles[1]+availableLocations[i]+"5");
//            moves.add(tiles[1]+availableLocations[i]+"6");
//            moves.add(tiles[1]+availableLocations[i]+"7");

            for (int tile = 0; tile < 4; tile++){
                for (int rotation = 0; rotation < 8; rotation ++){
                    moves.add(tiles[tile]+availableLocations[i]+Integer.toString(rotation));
                }
            }
//
//            moves.add(tiles[2]+availableLocations[i]+"0");
//            moves.add(tiles[2]+availableLocations[i]+"1");
//            moves.add(tiles[2]+availableLocations[i]+"2");
//            moves.add(tiles[2]+availableLocations[i]+"3");
//            moves.add(tiles[2]+availableLocations[i]+"4");
//            moves.add(tiles[2]+availableLocations[i]+"5");
//            moves.add(tiles[2]+availableLocations[i]+"6");
//            moves.add(tiles[2]+availableLocations[i]+"7");
//
//            moves.add(tiles[3]+availableLocations[i]+"0");
//            moves.add(tiles[3]+availableLocations[i]+"1");
//            moves.add(tiles[3]+availableLocations[i]+"2");
//            moves.add(tiles[3]+availableLocations[i]+"3");
//            moves.add(tiles[3]+availableLocations[i]+"4");
//            moves.add(tiles[3]+availableLocations[i]+"5");
//            moves.add(tiles[3]+availableLocations[i]+"6");
//            moves.add(tiles[3]+availableLocations[i]+"7");
        }
        String[] possibleMoves = moves.toArray(new String[0]);
        return possibleMoves;
    }

    // @author  Kathia Anyosa
    //From diceRoll get available tiles in an array
    public  static String[] tiles(String diceRoll){
        List<String> tile = new ArrayList<>();
        //int length = diceRoll.length();
        for (int i = 0; i < diceRoll.length(); i += 2) {
            tile.add(diceRoll.substring(i, Math.min(diceRoll.length(), i + 2)));
        }
        String[] individualTiles = tile.toArray(new String[0]);
        return individualTiles;
    }

    // @author  Kathia Anyosa
    //From current state, get individual placement strings
    public static String[] splitIntoIndividualPlacementStrings(String boardString){
        List<String> piece = new ArrayList<>();
        //int length = boardString.length();
        for (int i = 0; i < boardString.length(); i += 5) {
            piece.add(boardString.substring(i, Math.min(boardString.length(), i + 5)));
        }
        String[] individualPlacements = piece.toArray(new String[0]);
        return individualPlacements;
    }

    // @author  Kathia Anyosa
    //Returns location of each piece in the board (index 2 and 3 of each placement string)
    public static String[] tileLocations(String [] placements){
        List<String> locations = new ArrayList<>();
        for (int i = 0; i < placements.length; i ++){
            String elem = placements[i];
            String location = elem.substring(2, 4);
            locations.add(location);
        }
        String [] takenLocations = locations.toArray(new String[0]);
        return takenLocations;
    }

    // @author  Kathia Anyosa
    //Establish available locations on board and eliminate elements in common between AllPositions and tileLocations
    public static String[] availableLocations(String[] takenLocations){
        ArrayList<String> AllPositions = new ArrayList<>(Arrays.asList("A0", "A1", "A2", "A3", "A4", "A5", "A6","B0", "B1", "B2", "B3", "B4", "B5", "B6","C0", "C1", "C2", "C3", "C4", "C5", "C6","D0", "D1", "D2", "D3", "D4", "D5", "D6","E0", "E1", "E2", "E3", "E4", "E5", "E6","F0", "F1", "F2", "F3", "F4", "F5", "F6","G0", "G1", "G2", "G3", "G4", "G5", "G6"));
        for (int i = 0; i < takenLocations.length; i ++){
            if (AllPositions.get(i).equals(takenLocations[i])){
                AllPositions.remove(takenLocations[i]);
            }
        }


        String[] availableLocations = AllPositions.toArray(new String[0]);
        return availableLocations;
    }

    /**
     * Given the current state of a game board, output an integer representing the sum of all the factors contributing
     * to `getBasicScore`, as well as those attributed to:
     * <p>
     * * Longest railroad
     * * Longest highway
     *
     * @param boardString a board string representing a completed game
     * @return integer (positive or negative) for final score (not counting expansion packs)
     */
    public static int getAdvancedScore(String boardString) {
        // FIXME Task 12: compute the total score including bonus points
        return -1;
    }

    public static void main(String[] args) {

    }
}