package robot;

public class Robot {

    static int x = 0;

    static int y = 0;

    static void calculatePath(String input) {
        char direction = 'n';
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'F' -> {
                    switch (direction) {
                        case 'n' -> y++;
                        case 's' -> y--;
                        case 'e' -> x++;
                        case 'w' -> x--;
                    }
                }
                case 'L' -> {
                    switch (direction) {
                        case 'n' -> direction = 'w';
                        case 's' -> direction = 'e';
                        case 'e' -> direction = 'n';
                        case 'w' -> direction = 's';
                    }
                }
                case 'R' -> {
                    switch (direction) {
                        case 'n' -> direction = 'e';
                        case 's' -> direction = 'w';
                        case 'e' -> direction = 's';
                        case 'w' -> direction = 'n';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        calculatePath("LFFFRFRLFR");
        System.out.println("Current position: [" + x + ", " + y +"]");
    }
}
