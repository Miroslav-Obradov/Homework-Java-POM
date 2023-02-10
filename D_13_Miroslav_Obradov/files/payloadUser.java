package files;

public class payloadUser {
    public static String createUserBody() {
        return "{\n" +
                "     \"id\": 100,\n" +
                "     \"username\": \"Peraperic\",\n" +
                "     \"firstName\": \"Pera\",\n" +
                "     \"lastName\": \"Peric\",\n" +
                "     \"email\": \"pera@gmail.com\",\n" +
                "     \"password\": \"bing\",\n" +
                "     \"phone\": \"12345679\",\n" +
                "     \"userStatus\": 1\n" +
                "}";
    }
    public static String createUpateUserBody() {
        return "{\n" +
                "     \"id\": 100,\n" +
                "     \"username\": \"Zikazikic\",\n" +
                "     \"firstName\": \"Zika\",\n" +
                "     \"lastName\": \"Zikic\",\n" +
                "     \"email\": \"zika@gmail.com\",\n" +
                "     \"password\": \"bing\",\n" +
                "     \"phone\": \"987654321\",\n" +
                "     \"userStatus\": 2\n" +
                "}";
    }
}
