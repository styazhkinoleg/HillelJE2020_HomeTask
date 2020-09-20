package lesson_17;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TestToLesson_17 {

    @Test
    void checkJsonToYaml() {
        String test = "{\n" +
                "  \"key\" : \"value\"\n" +
                "}";
        String result = "---\n" +
                "key: \"value\"\n";
        assumeTrue(Converter.jsonToYaml(test).equals(result));
        test = "{\n" +
                "  \"key\" : [\"value1\", \"value2\"]\n" +
                "}";
        result = "---\n" +
                "key:\n" +
                "- \"value1\"\n" +
                "- \"value2\"\n";
        assumeTrue(Converter.jsonToYaml(test).equals(result));
    }

    @Test
    void checkYamlToJson(){
        String test = "---\n" +
                "key: \"value\"\n";
        String result = "{\"key\":\"value\"}";
        assumeTrue(Converter.yamlToJson(test).equals(result));
        test = "---\n" +
                "key:\n" +
                "- \"value1\"\n" +
                "- \"value2\"\n";
        result = "{\"key\":[\"value1\",\"value2\"]}";
        assumeTrue(Converter.yamlToJson(test).equals(result));
    }

}
