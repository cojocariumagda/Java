package lab7;

public class Token {
    private int valueToken;

    public synchronized int getValueToken() {
        return valueToken;
    }

    public void setValueToken(int valueToken) {
        this.valueToken = valueToken;
    }

    public boolean isBlank()
    {
        return valueToken == 0;
    }

    @Override
    public String toString() {
        return "Token{" +
                "valueToken=" + valueToken +
                '}';
    }
}
