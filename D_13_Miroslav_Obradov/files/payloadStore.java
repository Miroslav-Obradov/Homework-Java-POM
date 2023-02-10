package files;

public class payloadStore {
    public static String createOrderBody() {
        return "{\n" +
                "  \"id\": 10,\n" +
                "  \"petId\": 10,\n" +
                "  \"quantity\": 10,\n" +
                "  \"shipDate\": \"2023-01-28T19:43:15.415Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";

    }
}
