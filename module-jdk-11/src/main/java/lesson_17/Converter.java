package lesson_17;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Converter {
    public static String jsonToYaml(String str_json){
        try {
            JsonNode jsonNodeTree = new ObjectMapper().readTree(str_json);
            return new YAMLMapper().writeValueAsString(jsonNodeTree);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new String();
    }
    public static String yamlToJson(String str_yaml){
        try {
            JsonNode jsonNodeTree = new YAMLMapper().readTree(str_yaml);
            return new ObjectMapper().writeValueAsString(jsonNodeTree);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new String();
    }
}
