package comp1110.ass2;

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
    public static boolean areConnectedNeighbours(String tilePlacementStringA, String tilePlacementStringB) {
        boolean test = true;
//        Check whether these two tiles ar neighbours
//        if(tilePlacementStringA.charAt(2) == tilePlacementStringB.charAt(2)){
//             if(Math.abs(tilePlacementStringA.charAt(3) - tilePlacementStringB.charAt(3)) != 1) test = false;
//        }else if ( tilePlacementStringA.charAt(3) == tilePlacementStringB.charAt(3)) {
//            if(Math.abs(tilePlacementStringA.charAt(2) - tilePlacementStringB.charAt(2)) != 1) test = false;
//        }else{ test = false;}
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
                    if (oneTile.getEastPassage() != anotherTile.getWestPassage()) test = false;
                } else {
                    if (oneTile.getWestPassage() != anotherTile.getEastPassage()) test = false;
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

    public static boolean ifNeighbours(String a, String b){
        boolean test = true;
        if(a.charAt(2) == b.charAt(2)){
            if(Math.abs(a.charAt(3) - b.charAt(3)) != 1) test = false;
        }else if ( a.charAt(3) == b.charAt(3)) {
            if(Math.abs(a.charAt(2) - b.charAt(2)) != 1) test = false;
        }else{ test = false;}
        return test;
    }

    public static Dice diceCreator(String tilePlacementString){
        Dice a = null;
        if(tilePlacementString.charAt(0) == 'A'){
            a = new A(tilePlacementString.charAt(1) - '0');
        }else if(tilePlacementString.charAt(0) == 'B'){
            a = new B(tilePlacementString.charAt(1) - '0');
        }else if(tilePlacementString.charAt(0) == 'S'){
            a = new S(tilePlacementString.charAt(1) - '0');
        }
        return  a;
    }

    public static Dice diceRotatorOrFliper(Dice a, int b){
        if(b <= 3){
            for(int i = 1; i<=b;i++){
                a.rotete90Degree();
            }
        }

        if(b > 3){
            a.flip();
            for(int i =1;i<=b-4; i++){
                a.rotete90Degree();
            }
        }
        return  a;
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

            char a0 = grid.getTile(arrayOfPlacement[0].charAt(2) - 'A', arrayOfPlacement[0].charAt(3)-'0').getGate();
            if(a0 != '!'){
                if (!ifConnectedToGateCorrectly(arrayOfPlacement[0], arrayOfDice[0],a0)) test = false;
            }else{test = false;}

            if(test){
                for(int i = 1; i < arrayOfPlacement.length; i ++){
                    char gate = gate = grid.getTile(arrayOfPlacement[i].charAt(2) - 'A', arrayOfPlacement[i].charAt(3)-'0').getGate();
                    if(gate == '!'){
                        for (int j = 0; j < i; j++) {
                            test = areConnectedNeighbours(arrayOfPlacement[i],arrayOfPlacement[j]);
                            if(test) break;
                        }
                    }else{  test = ifConnectedToGateCorrectly(arrayOfPlacement[i],arrayOfDice[i],gate);
                            if(!test) break;
                    }
                    if(!test) break;
                }
            }
        }
        return test;
    }

    public static boolean ifConnectedToGateCorrectly(String placementofDice,Dice dice,char gate){
        boolean test = true;
        Board grid = new Board();
            if (placementofDice.charAt(2) == 'A') {
                if (dice.getNorthPassage() != gate) test = false;
            } else if (placementofDice.charAt(2) == 'B' || placementofDice.charAt(2) == 'D'|| placementofDice.charAt(2) == 'F' ) {
                if (placementofDice.charAt(3)  == '0') {
                    if (dice.getWestPassage() != gate) test = false;
                } else if (placementofDice.charAt(3) == '6') {
                    if (dice.getEastPassage() != gate) test = false;
                }
            } else if (placementofDice.charAt(2) == 'G') {
                if (dice.getSouthPassage() != gate) test = false;
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
    public static String generateDiceRoll() {
        // FIXME Task 7: generate a dice roll
        return "";
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
    public static int getBasicScore(String boardString) {
        // FIXME Task 8: compute the basic score
        return -1;
    }

    /**
     * Given a valid boardString and a dice roll for the round,
     * return a String representing an ordered sequence of valid piece placements for the round.
     * @param boardString a board string representing the current state of the game as at the start of the round
     * @param diceRoll a String representing a dice roll for the round
     * @return a String representing an ordered sequence of valid piece placements for the current round
     * @see RailroadInk#generateDiceRoll()
     */
    public static String generateMove(String boardString, String diceRoll) {
        // FIXME Task 10: generate a valid move
        return null;
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
        RailroadInk a = new RailroadInk();
        System.out.println(isValidPlacementSequence("S0D01"));


    }
}

