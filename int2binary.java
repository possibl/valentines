package valentines;

class num2Binary {
    private static String digits = "%32s";

    public num2Binary() {}

    public num2Binary(String string) {
        digits = string;
    }

    private static String int2binary(int n) {
        return Integer.toBinaryString(n);
    }

    private static String addPadding(String lunchNumBinary){
        return String.format(digits, lunchNumBinary).replaceAll(" ", "0");
    }

    private static String addBlocks(String lunchNumBinary, String separator) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i< lunchNumBinary.length(); i++ ){
            sb.append(lunchNumBinary.charAt(i));
            if (i%4 == 3 && i != lunchNumBinary.length() - 1)
                sb.append(separator);
        }
        return sb.toString();
    }

    public static String[] convert2Binary(String[] peopleIntel) {
        String [] lunchNumBinary = new String[peopleIntel.length];
        for (int i = 0; i < peopleIntel.length; i++){
            lunchNumBinary[i] = int2binary(peopleIntel[i]);
            //lunchNumBinary[i] = addPadding(lunchNumBinary[i]);
            //lunchNumBinary[i] = addBlocks(lunchNumBinary[i], "_");  //This is helpful for debugging
            System.out.println(lunchNumBinary[i]);
        }
        return lunchNumBinary;      
    }


}
