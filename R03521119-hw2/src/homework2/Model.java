package homework2;

public class Model {
    private String password = "123456";
    public Boolean checkPassword(String input) {
        Boolean isEqual = password.equals(input);
        return isEqual;
    }
}
