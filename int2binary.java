package valentines;

class num2Binary {
    private static String digits = "%32s";

    public num2Binary() {}

    public num2Binary(String string) {
        digits = string;
    }

    private static int int2binary(int num) {
        String num2 = Integer.toBinaryString(num); // Was relevant when using String output
        num = Integer.parseInt(num2);

        return num;
    }

    public static String addPadding(int idBinary){
        String temp = Integer.toBinaryString(idBinary);
        temp = String.format(digits, temp).replaceAll(" ", "0");
        //int temp2 = Integer.parseInt(temp);temp
        return temp;
    }
/* Was relevant when using String output 
    private static String addBlocks(String idBinary, String separator) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i< idBinary.length(); i++ ){
            sb.append(idBinary.charAt(i));
            if (i%4 == 3 && i != idBinary.length() - 1)
                sb.append(separator);
        }
        return sb.toString();
    }
*/
    public static int[] convert2Binary(int[] id) {
        int [] idBinary = new int[id.length];
        for (int i = 0; i < id.length; i++){
            idBinary[i] = int2binary(id[i]);
            //idBinary[i] = addPadding(idBinary[i]);
            //idBinary[i] = addBlocks(idBinary[i], "_");  //This is helpful for debugging
            System.out.println(idBinary[i]);
        }
        return idBinary;      
    }


}
