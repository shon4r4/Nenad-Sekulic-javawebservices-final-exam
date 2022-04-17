package com.javawebservices.finalexam;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;

public class csvFileReader {

	

	
	
	public String readFile(String fileName) throws JsonProcessingException {
        List<String> csvRows = null;
        try(var reader = Files.lines(Paths.get("src/main/resources/"+fileName))){
            csvRows = reader.collect(Collectors.toList());
        }catch(Exception e){
            e.printStackTrace();
        }

        if(csvRows != null){
        	return csvToJson(csvRows);
        }
        return "";
    }
	
	
	
	public static String csvToJson(List<String> csv){

        csv.removeIf(e -> e.trim().isEmpty());

        if(csv.size() <= 1){
            return "[]";
        }

        String[] columns = csv.get(0).split(",");

        StringBuilder json = new StringBuilder("[\n");
        csv.subList(1, csv.size()) 
            .stream()
            .map(e -> e.split(","))
            .filter(e -> e.length == columns.length) 
            .forEach(row -> {

                json.append("\t{\n");

                    for(int i = 0; i < columns.length; i++){
                        json.append("\t\t\"")
                            .append(columns[i])
                            .append("\" : \"")
                            .append(row[i])
                            .append("\",\n");
                    }

                    json.replace(json.lastIndexOf(","), json.length(), "\n");

                json.append("\t},"); 

            });

        json.replace(json.lastIndexOf(","), json.length(), "");

        json.append("\n]");

        return json.toString();

    }
	
	
	
	
}
