package valentines;

public class prefGroupSorter {
    
    int [][] peopleIntel;
    int [][] _group;
    int gender;
    int prefGender;


    public prefGroupSorter (int[][] _peopleIntel, int _gender, int _prefGender) {
        peopleIntel = _peopleIntel;
        gender = _gender;
        prefGender = _prefGender;
    }

    int [][] classifier () {

        int[][] group = new int[peopleIntel.length][peopleIntel[0].length];
        for (int i = 0; i<peopleIntel.length; i++){
            if (peopleIntel[i][2] == gender) { // gender
                if (peopleIntel[i][3] == prefGender){ //prefGender
                    for (int k = 0; k < group[i].length; k++){
                        group[i][k] = peopleIntel[i][k];
                    }
                    //System.out.println("mmGroup");
                }
            } 
        }
        _group = group;
        return group;
    }

    int [][] cleaner (int valueInRow, int columnNum) {
        boolean[] rowsToKeep = new boolean[_group.length];

        for (int i = 0; i<rowsToKeep.length; i++){
            boolean found = false;

            if (_group[i][columnNum] == valueInRow){
                found = true;
            }

            if (found == false){
                rowsToKeep[i] = true;
            }
        }

        int numTrueInRows = 0;

        for (int i = 0; i< rowsToKeep.length; i++){
            if (rowsToKeep[i] == true){
                numTrueInRows++;
            }
        }

        int[][] group = new int[numTrueInRows][_group[0].length]; 

        int j = 0;
        for (int i = 0; i <_group.length; i++){
            if (rowsToKeep[i] == true){
                for (int k = 0; k<_group[0].length;k++){
                    group [j][k] = _group[i][k];
                }
                j++;
            } 
        }

        //_group = group;
        return group;
    }

    

}
