package ntd.java.utils;

public class Menu {
    public static void constMenu(String title, String content, String barLeft, String barRight, Boolean useSeparator) {
        /*
         * Snippet made by NotToxicDev
         * Makes a menu function that you can use for creating custom consoleapp menus
         * in java
         * Syntax: menu(title, content, barLeft, barRight, useSeparator);
         * Title - Title of the menu tex. "Action"
         * Content - Content of the menu tex. Make file - 1\nQuit - 2
         * barRight & Left - sets a custom bar to the menu, use "null" on:
         * 1 of them - Makes the variables the same tex. menu("title", "content", "---",
         * null, true)
         * 
         * useSeparator:
         * True output: ---- Title ----
         * False output: ----Title----
         */
        // main vars
        String separator = " ";
        String defBarL = "<========";
        String defBarR = "========>";
        Boolean useDefBar = false;
        if (barLeft == null) {
            if (barRight == null) {
                useDefBar = true;
            } else {
                barLeft = barRight;
            }
        }
        if (barRight == null) {
            barRight = barLeft;
        }
        if (!useSeparator) {
            separator = "";
        }
        // secondary vars
        String enclose = barLeft + separator + title + separator + barRight;
        if (useDefBar) {
            enclose = defBarL + separator + title + separator + defBarR;
        }
        System.out.println(enclose);
        System.out.println(content);
        System.out.println(enclose);

    }
}
