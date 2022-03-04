package io.github.nottoxicdev;

import ntd.java.utils.Menu;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static void app() throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please set your date in the 'yyyy-MM-dd HH:mm:ss' format.");
        String dateStr = sc.nextLine();
        Menu.constMenu("Type",
                "Short time - 1\nLong time - 2\nShort date - 3\nLong date - 4\nLong date w/ short time - 5\nLong date w/ day & short time - 6\nRelative - 7",
                null, null, true);
        int sel = sc.nextInt();

        Date date = parse(dateStr);
        long unix = date.getTime();
        String type = "";
        if (sel == 1)
            type = "t";
        else if (sel == 2)
            type = "T";
        else if (sel == 3)
            type = "d";
        else if (sel == 4)
            type = "D";
        else if (sel == 5)
            type = "f";
        else if (sel == 6)
            type = "F";
        else
            type = "R";

        String out = "<t:" + (unix / 1000) + ":" + type + ">";
        System.out.println(out);

        // from string to clipboard
        StringSelection selection = new StringSelection(out);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        System.out.println("Copied to Clipboard!");
    }

    public static Date parse(String dateStr) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        return date;
    }

    public static void main(String[] args) throws ParseException {
        app();
    }
}
