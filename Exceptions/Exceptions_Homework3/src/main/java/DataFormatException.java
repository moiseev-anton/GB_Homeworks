public class DataFormatException extends Exception{

    private String data;

    public DataFormatException(String message, String data){
        super(message);
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
