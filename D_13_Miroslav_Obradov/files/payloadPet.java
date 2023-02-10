package files;

public class payloadPet {

    public static String createPetBody() {
        return "{\n" +
                "    \"id\" : 15,\n" +
                "    \"category\" : {\n" +
                "        \"id\" : 10,\n" +
                "        \"name\" : \"Misko\"\n" +
                "    },\n" +
                "    \"name\" : \"Misa\",\n" +
                "    \"photoUrls\" : [\n" +
                "        \"string\"\n]," +
                "    \"tags\" : [{\n" +
                "        \"id\" : 0,\n" +
                "        \"name\" : \"string\"\n" +
                "    }]," +
                "    \"status\" : \"sold\"\n" +
                "}";

    }
    public static String createUpdatePetBody() {
        return "{\n" +
                "    \"id\" : 15,\n" +
                "    \"category\" : {\n" +
                "        \"id\" : 10,\n" +
                "        \"name\" : \"Hamster\"\n" +
                "    },\n" +
                "    \"name\" : \"Djole\",\n" +
                "    \"photoUrls\" : [\n" +
                "        \"string\"\n]," +
                "    \"tags\" : [{\n" +
                "        \"id\" : 0,\n" +
                "        \"name\" : \"string\"\n" +
                "    }]," +
                "    \"status\" : \"available\"\n" +
                "}";

    }
}
