package valentines;

public class csvGenerator {
    public static void main(String[] args){
        csvGenerator temp = new csvGenerator();
        temp.mymain();
    }

    private void mymain() {
        //all info. Should be in a seperate text file. This is for testing
        int[][] peopleIntel = new int [1000][6]; 

        //generating random info for testings
        for (int i = 0; i<peopleIntel.length; i++){
            peopleIntel[i][0] = i+1;
            peopleIntel[i][1] = 0;
            peopleIntel[i][2] = (int) Math.round(Math.random());
            peopleIntel[i][3] = (int) Math.round(Math.random());
            int gender = (int) Math.round(Math.random()*3);
            switch (gender) {
                case 0:
                    gender = 8;
                    break;
                case 1:
                    gender = 4;
                    break;
                case 2:
                    gender = 2;
                    break;
                case 3:
                    gender = 1;
                    break;
            }
            peopleIntel[i][4] = gender;
            peopleIntel[i][5] = (int) Math.round(Math.random()*15);
        }
        
        for (int i = 0; i<peopleIntel.length; i++){
            System.out.print(peopleIntel[i][0] + ",");
            for (int j = 1; j<peopleIntel[i].length-2; j++){
                System.out.print(peopleIntel[i][j] + ",");
            }
            num2Binary test1 = new num2Binary("%4s");
            num2Binary test2 = new num2Binary("%4s");
            System.out.print(test1.addPadding(peopleIntel[i][4])+ ",");
            System.out.println(test2.addPadding(peopleIntel[i][5]));
        }
    }
}
