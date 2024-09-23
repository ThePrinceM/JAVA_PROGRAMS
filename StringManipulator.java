class StringManipulator {
        String s1;
        String s2;
        String s3;
        int n1;
    
    static String concS(String s1,String s2){
        String s4=s1.concat(s2);
        return s4;
    }

    static String concS(String s1,String s2,String s3){
        String s4=s1.concat(s2);
        String s5=s4.concat(s3);
        return s5;
    }
 
    public static void main(String[] args) {
        String s6=concS("Prince"," Jeetlal"," Maurya");
        System.out.println(s6);    
    }
   }
