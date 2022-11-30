import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("PUNTO 0: ");
        String text = "hola mundo";
        String textReversed = reverse(text);
        System.out.println(textReversed);

        String arrFruits[] = {"Apples", "Oranges", "Bananas"};
        System.out.println("PUNTO 1: ");
        for (String fruits : arrFruits) {
            System.out.println(fruits);
        }

        System.out.println("PUNTO 2: ");
        int arrBiNumbers[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int x = 0; x < arrBiNumbers.length; x++) {
            for (int y = 0; y < arrBiNumbers.length; y++) {
                System.out.println("(" + x + ", " + y + ") = " + arrBiNumbers[x][y]);
            }
        }

        System.out.println("PUNTO 3: ");
        Vector vector = new Vector<Integer>(5);
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.removeElementAt(1);
        vector.removeElementAt(2);
        System.out.println(vector);

        System.out.println("PUNTO 4: ");
        System.out.println("El problema de tener un vector con un tamaño muy grande por defecto, ejemplo 1000, es que si excedemos ese valor se va a crear un array subyacente el cual va a copiar los elementos del vector y va a producir una gran perdida de rendimiento. Por eso siempre es recomendable crear el vector con el tamaño máximo que uno cree que va a utilizar.");

        System.out.println("PUNTO 5: ");
        ArrayList<String> arrStrings = new ArrayList<>();
        arrStrings.add("Hello");
        arrStrings.add("World");
        arrStrings.add("Bye");
        arrStrings.add("Hi");

        LinkedList<String> list = new LinkedList<>();
        for (String str : arrStrings) {
            list.add(str);
        }

        System.out.println("ArrayList: ");
        for (String str : arrStrings) {
            System.out.println(str);
        }

        System.out.println("LinkedList: ");
        for (String str : list) {
            System.out.println(str);
        }

        System.out.println("PUNTO 6: ");
        ArrayList<Integer> arrInts = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            arrInts.add(i + 1);
        }
        // System.out.println(arrInts.toString());

        int i = 0;
        while (i < arrInts.size()) {
            if (arrInts.get(i) % 2 == 0) {
                arrInts.remove(i);
            }
            i++;
        }

        for (Integer value : arrInts) {
            System.out.println(value);
        }

        System.out.println("PUNTO 7: ");
        try {
            divideByCero(7);
            System.out.println("Demo de código.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("PUNTO 8: ");
        try {
            InputStream in = new FileInputStream("/home/alber/Documentos/Algunos apuntes");
            PrintStream out = new PrintStream("Algunos apuntes clonado.txt");
            copyFile(in, out);
            in.close();
            out.close();
            System.out.println("Archivo copiado.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("PUNTO 9: ");
        System.out.println("Program running...");
        try {
            HashMap<String, String> map = new HashMap<>();
            PrintStream out = new PrintStream("student.txt");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Hoy many categories will write?: ");
            Integer counter = scanner.nextInt();

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter categories: ");
            List<String> list2 = new ArrayList<>(counter);
            for (int j = 0; j < counter; j++) {
                list2.add(scanner2.nextLine());
            }

            Scanner scanner3 = new Scanner(System.in);
            for (int j = 0; j < list2.size(); j++) {
                System.out.println("Enter " + list2.get(j) + ": ");
                map.put(list2.get(j), scanner3.nextLine());
            }
            scanner.close();
            scanner2.close();
            scanner3.close();

            for(i = 0; i < map.size(); i++){
                System.out.println(map.get(list2.get(i)));
            }
            // String result = word.toString();

            byte[] data = map.toString().getBytes();
            out.write(data);
            System.out.println("Student written.");
            out.close();

            InputStream in = new FileInputStream("student.txt");
            data = in.readAllBytes();
            String str = new String(data);
            System.out.println(str);
            in.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static String reverse(String text) {
        StringBuilder builder = new StringBuilder(text);
        return builder.reverse().toString();
    }

    public static ArithmeticException divideByCero(Integer number) throws ArithmeticException {
        throw new ArithmeticException("Esto no puede hacerse.");
    }

    public static void copyFile(InputStream fileIn, PrintStream fileOut) throws IOException {
        byte[] data = fileIn.readAllBytes();
        fileOut.write(data);
    }
}
