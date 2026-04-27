class StringIterator {
    private String s;
    private int i; // pointer in string
    private char currentChar;
    private int currentFreq;

    public StringIterator(String compressedString) {
        this.s = compressedString;
        this.i = 0;
        this.currentFreq = 0;
    }

    public char next() {
        if (!hasNext()) return ' ';

        // load next group if needed
        if (currentFreq == 0) {
            currentChar = s.charAt(i++);
            
            int num = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            currentFreq = num;
        }

        currentFreq--;
        return currentChar;
    }

    public boolean hasNext() {
        return currentFreq > 0 || i < s.length();
    }
}