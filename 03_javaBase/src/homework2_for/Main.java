package homework2_for;

public class Main {
    public static void main(String[] args) {
        for (int i = 100; i >= 1; i--) {

            if (isQuadruple(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isQuadruple(int i) {
        return (i % 4) == 0 ? true : false;
    }

}
