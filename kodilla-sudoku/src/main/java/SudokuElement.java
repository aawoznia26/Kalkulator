import java.util.List;

public class SudokuElement {

    private int value;
    private List<Integer> fulfillmentOptions;
    public static int EMPTY = -1;

    public SudokuElement(int value, List<Integer> fulfillmentOptions) {
        this.value = value;
        this.fulfillmentOptions = fulfillmentOptions;
    }

    public int getValue() {
        return value;
    }


    public List<Integer> getFulfillmentOptions() {
        return fulfillmentOptions;
    }

    @Override
    public String toString() {
        String valueConvertedToString = Character.toString((char) (value + '0'));
        return valueConvertedToString;
    }


}