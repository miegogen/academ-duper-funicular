package homework2_for;

public class Main {
    public static void main(String[] args) {
        for (int i = 100; i >= 1; i--) {

            if (fourMultiple(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean fourMultiple(int i) {
        if (i % 4 == 0) {
            return true;
        }
        return false;
    }

}
