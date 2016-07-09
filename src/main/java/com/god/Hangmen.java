package com.god;

/**
 * Created by feng on 2016/7/9.
 */
public class Hangmen {
    public int strLength;
    public int times;
    public String guessedStr;
    public String displayedStr;
    public String str;

    public Hangmen(String s) {
        str = s;
        strLength = str.length();
        times = strLength + 1;
        guessedStr = "iaoue";
        showTheGuessedStr();
    }

    private void showTheGuessedStr() {
        char st[] = str.toCharArray();
        displayedStr = "";
        for (int i = 0; i < strLength; i++)
            displayedStr += isContain(st[i]) ? st[i] : "_";
    }

    private boolean isContain(char c) {
        return (guessedStr.indexOf(c) == -1) ? false : true;
    }


    public void guessAChar(char c) {
        if (isContain(c))
            return;
        guessedStr += c;
        showTheGuessedStr();
        times--;
    }


    public boolean checkTimes() {
        return times > 0;
    }

    public boolean chenkAnswer() {
        return (checkTimes() && str.equals(displayedStr));
    }


}
