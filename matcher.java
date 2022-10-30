package valentines;

public class matcher {
    
    int[][] group1;
    int[][] group2;

    int[][] _outputGroup;

    public matcher (int[][] _group1, int[][] _group2) {
        group1 = _group1;
        group2 = _group2;
    }

    int [][] agePrefCouples () {

        int minLengthGroup = group1.length;

        if (group1.length > group2.length){
            minLengthGroup = group2.length;
        }

        int[][] _outputGroup = new int[minLengthGroup][2];

        boolean [] notAvaGroup2 = new boolean[group2.length];

        for (int i = 0; i < group1.length;i++){

            for (int k = 0; k < group2.length; k++){
                /* checking if two people have compatible ages */
                if (notAvaGroup2[k] == false){

                    if (checkAgeCompat(group1[i][4], group1[i][5], group2[i][4], group2[i][5]) == true & group1[i][0] != group2[k][0]){
                        _outputGroup[i][0] = group1[i][0];
                        _outputGroup[i][1] = group2[k][0];
                        notAvaGroup2[k] = true;
                        break;
                    }
                }
            }

        }

        return _outputGroup;
    }

    private static boolean checkAgeCompat (int p1grade, int p1pref, int p2grade, int p2pref) {
        boolean ageCompat = false;
        boolean ageCompat1 = false;
        boolean ageCompat2 = false;

        //System.out.println("p1 Grade: " + p1grade + " Their Pref: " + p1pref);
        //System.out.println("p2 Grade: " + p2grade + " Their Pref: " + p2pref);

        boolean[] _p1grade = toBinary(p1grade, 4);
        boolean[] _p1pref = toBinary(p1pref, 4);
        boolean[] _p2grade = toBinary(p2grade, 4);
        boolean[] _p2pref = toBinary(p2pref, 4);

        for (int i = 0; i < _p1grade.length; i++){
            if (_p1pref[i] == _p2grade[i]){
                ageCompat1 = true;
            }
            if (_p2pref[i] == _p1grade[i]){
                ageCompat2 = true;
            }
        }

        //System.out.println("thier age compat: " + ageCompat);

        if (ageCompat1 == ageCompat2 == true) {
            ageCompat = true;
        }
        return ageCompat;
    }

    private static boolean[] toBinary(int number, int base) {
        final boolean[] ret = new boolean[base];
        for (int i = 0; i < base; i++) {
            ret[base - 1 - i] = (1 << i & number) != 0;
        }
        return ret;
    }

}
