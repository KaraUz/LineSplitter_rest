package lt.karauz.utilities;

public class StringUtilities {
    public final static String LINE_SEPARATOR = "\n";//use System.getProperty("line.separator") for system separator

    private StringUtilities() { }

    public static String splitIntoLines(String text, int lettersPerLine)throws IllegalArgumentException{
        if(text == null)
            throw new IllegalArgumentException("Text must be a non null String!");

        if(lettersPerLine < 1)
            throw new IllegalArgumentException("Letters per line must be greater than 0!");

        StringBuilder builder = new StringBuilder();
        boolean endOfText = false;
        int startIndex = 0;
        int endIndex;

        while (!endOfText) {
            int futureStartIndex = startIndex + lettersPerLine + 1;
            endOfText = text.length() < futureStartIndex;
            endIndex = !endOfText ? futureStartIndex : text.length();
            String substring = text.substring(startIndex, endIndex);

            if(startIndex > 0) builder.append(LINE_SEPARATOR);

            int indexOfCut = substring.lastIndexOf(' ');

            if(endOfText){
                builder.append(substring);
                startIndex += substring.length();
            }else if(indexOfCut < 0) {
                //There is no " " in the substring, must cut the word
                int secondToLast = substring.length() - 1;
                builder.append(substring.substring(0, secondToLast));
                startIndex += secondToLast;
            } else {
                builder.append(substring.substring(0, indexOfCut));
                startIndex += indexOfCut + 1;
            }
        }

        return builder.toString();
    }
}
