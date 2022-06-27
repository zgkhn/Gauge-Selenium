package driver;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;

public class connect {

    public static JsonObject baglanti() throws Exception {
        JsonObject fileObject = null;
        try {
            File input = new File("src/test/resources/package.json");
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));

            JsonArray element = fileObject.get("link").getAsJsonArray();
            List links = new ArrayList<>();

            for(JsonElement linkElement : element){

                JsonObject linkJson = linkElement.getAsJsonObject();

                String key = linkJson.get("key").getAsString();
                String value = linkJson.get("value").getAsString();
                String type = linkJson.get("type").getAsString();

                 link link = new link(key,value,type);
                links.add(link);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileObject;
    }





//    public static String veri(String veri) throws Exception {
//        String name = null;
//        try {
//            File input = new File("src/test/resources/package.json");
//            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
//            JsonObject fileObject = fileElement.getAsJsonObject();
//            name = fileObject.get(veri).getAsString();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return name;
//    }
//    public static String veri(String veri) throws Exception {
//        String name = null;
//        try {
//            baglanti().get(veri);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return name;
//    }
//    public static String veri(String veri) throws Exception {
//        String name = null;
//        try {
//            baglanti().get(veri);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return name;
//    }


}
