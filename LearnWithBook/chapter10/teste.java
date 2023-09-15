package LearnWithBook.chapter10;

import LearnWithBook.chapter4.Sum;

public class teste {
    private static int size;

    public static void main(String[] args) {
        tt TT = new tt();
        System.out.println(TT.name);
        System.out.println(tt.names);
        System.out.println(tt.count*2);
        new tt("Felix");
        new tt(tt.count);

        System.out.println(tt.UseCount);
        size = 25;
        System.out.println("Size: " + getSize());
        setSize(99);
        System.out.println(size + " Size: " + getSize());
    }

    public static void setSize(int s) {
        size = s;
    }
    public static int getSize(){
        return size;
    }
}

class tt {
    static int UseCount;
    final String name = "Meow";
    static String names = "So much meow";
    final static int count = 9;
    public tt(){
        UseCount++;
        System.out.println("TT");
    }

    public tt(String PetName){
        UseCount++;
        System.out.println(PetName);
    }

    public tt(int x){
        UseCount++;
        System.out.println(x+1);
    }
}