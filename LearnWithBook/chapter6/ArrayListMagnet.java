import java.util.ArrayList;
public class ArrayListMagnet {
    public static void printAl(ArrayList<String> al){
        for ( String element : al){
            System.out.print(element + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        ArrayList <String> a = new ArrayList<String>();
        a.add(0, "Zero");
        a.add(1, "One");
        a.add(2, "Two");
        a.add(3, "Three");
        printAl(a);

        a.remove(2);
        if (a.contains("Two")){
            a.add("2.2");
        }
        if (a.contains("Three")){
            a.add("Four");
        }
        printAl(a);

        if (a.indexOf("Four") != 4){
            a.add(4, "4.2");
        }
        printAl(a);
        printAl(a);

        System.out.println(random());
    }

     private static int random(){
        int symbol = (int)((Math.random() * 2));    //рандомим
        System.out.println(symbol);
        if (symbol == 1){
            symbol = random();                               //если 1 то рандомим заново
        }

        return symbol;
    }
}
