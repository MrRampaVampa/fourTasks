package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task3 {
    public static void main(String[] args) throws ParseException {
        if (args.length != 3) {
            return;
        }
        
        String valuesFilePath = args[0];
        String testsFilePath = args[1];


        try {
            JSONParser parser = new JSONParser();
            JSONArray valuesArray = (JSONArray) parser.parse(new FileReader(valuesFilePath));
            JSONArray testsArray = (JSONArray) parser.parse(new FileReader(testsFilePath));

            for (Object testObject : testsArray) {
                JSONObject test = (JSONObject) testObject;
                int id = (int) test.get("id");

                for (Object valueObject : valuesArray) {
                    JSONObject value = (JSONObject) valueObject;
                    int valueId = (int) value.get("id");

                    if (valueId == id) {
                        test.put("value", value.get("value"));
                        break;
                    }
                }
            }

            FileWriter writer = new FileWriter("report.json");
            writer.write(testsArray.toJSONString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}