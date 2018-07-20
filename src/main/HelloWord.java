public class HelloWord {
    public static void main(String... args) throws Exception {
        int spaceCount = 8;
        System.out.printf(String.format("%%%ds", spaceCount), "Hello");
        System.out.printf("%" + spaceCount + "s", "Hello");
        System.out.format("%" + spaceCount + "s", "Hello");
        System.out.println();

        addNumToChar(2, 'B'); // D
        addNumToChar(2, 'b'); // d
        addNumToChar(261, 'B'); // C
        addNumToChar(261, 'b'); // c

        addNumToChar(-2, 'B'); // Z
        addNumToChar(-2, 'b'); // z

        addNumToChar(-261, 'B'); // A
        addNumToChar(-261, 'b'); // a
    }

    private static void addNumToChar(int a, char c0) {
        char c = 'a';
        if(Character.isUpperCase(c0)) {
            c = 'A';
        }
        while (a < 0) a += 26;
        char c1 = (char) (c + (c0 - c + a) % 26);
        System.out.println(c1);
    }

}
