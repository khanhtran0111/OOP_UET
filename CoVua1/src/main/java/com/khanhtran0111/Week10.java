package com.khanhtran0111;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10 {

    private static final Pattern PACKAGE_PATTERN = Pattern.compile(
            "^package\\s+(.*);$",
            Pattern.MULTILINE
    );

    private static final Pattern IMPORT_PATTERN = Pattern.compile(
            "^import\\s+(?:static\\s+)?((?:\\w+\\.)+(\\w+));$",
            Pattern.MULTILINE
    );

    private static final Pattern CLASS_PATTERN = Pattern.compile(
            "^(?:\\s{2})*(?:(?:abstract|public|private|protected|static|final)\\s+)*"
                    + "(class|interface|enum)\\s+([^<\\s]+)([^{]+)?\\s*\\{",
            Pattern.MULTILINE
    );

    private static final Pattern STATIC_METHOD_PATTERN = Pattern.compile(
            "^(?<!\\s{0,20}/\\*\\n)" +
                    "(?:\\s{2})+(?:(?:public|private|protected)\\s+)*" +
                    "static\\s+(?:final\\s+)?[\\w<>,.?\\[\\]\\s]+\\s+(\\w+)" +
                    "\\s*\\(([\\w<>,.?\\[\\]\\s]*)\\)\\s*\\{",
            Pattern.MULTILINE
    );

    private static final Map<String, String> dataTypeMap = new HashMap<>();

    /**
     * Converts a basic data type string to its full type representation.
     * @param dataType the data type string to convert
     * @return the full type string
     */
    private static String toFullType(String dataType) {
        if (dataTypeMap.containsKey(dataType)) {
            return dataTypeMap.get(dataType);
        } else if (dataType.matches("[A-Z]\\w+")) {
            return "java.lang." + dataType;
        } else if (dataType.contains("<")) {
            String[] parts = dataType.split("<");
            parts[0] = toFullType(parts[0]);
            parts[1] = toFullType(parts[1].replace(">", ""));
            return String.format("%s<%s>", parts[0], parts[1]);
        } else {
            return dataType;
        }
    }

    /**
     * Retrieves all static method signatures from a Java program.
     * @param fileContent the content of the Java file
     * @return a list of static method signatures
     */
    public static List<String> getAllFunctions(String fileContent) {
        List<String> allMethods = new ArrayList<>();
        String packageName = "";

        Matcher matcher = PACKAGE_PATTERN.matcher(fileContent);
        if (matcher.find()) {
            packageName = matcher.group(1);
        }

        matcher = IMPORT_PATTERN.matcher(fileContent);
        while (matcher.find()) {
            String fullImport = matcher.group(1);
            String nameImport = matcher.group(2);
            dataTypeMap.put(nameImport, fullImport);
        }

        matcher = CLASS_PATTERN.matcher(fileContent);
        while (matcher.find()) {
            String className = matcher.group(2);
            dataTypeMap.put(className, packageName + "." + className);
        }

        matcher = STATIC_METHOD_PATTERN.matcher(fileContent);
        while (matcher.find()) {
            String methodName = matcher.group(1);
            String allParams = matcher.group(2);

            StringBuilder allTypes = new StringBuilder("(");
            if (!allParams.isEmpty()) {
                allParams = allParams.replaceAll("\\.{3}", "")
                        .replace("\n", "")
                        .trim();
                String[] params = allParams.split(", ");
                for (String param : params) {
                    allTypes.append(toFullType(param.split(" ")[0])).append(",");
                }
                allTypes.deleteCharAt(allTypes.length() - 1);  // Remove trailing comma
            }
            allTypes.append(")");
            allMethods.add(methodName + allTypes.toString());
        }

        return allMethods;
    }
}
