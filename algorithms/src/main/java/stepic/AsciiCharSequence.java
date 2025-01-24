package stepic;

import java.lang.reflect.Array;

public class AsciiCharSequence implements CharSequence {
    private final byte[] chars;

    AsciiCharSequence(byte[] chars) {
        this.chars = chars;
    }

    @Override
    public char charAt(int index) {
        return (char)chars[index];
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if(end > chars.length || start > chars.length || start < 0 || end < 0 || start > end) {
            throw new IndexOutOfBoundsException();
        }

        byte[] bytes = new byte[end - start];
        System.arraycopy(chars, start, bytes, 0, end - start);
        return new AsciiCharSequence(bytes);
    }

    @Override
    public String toString() {
        return new String(chars);
    }

}
