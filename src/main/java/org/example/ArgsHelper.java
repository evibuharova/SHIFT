package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArgsHelper {

    public static String getStatisticType(List<String> argsList) {
        String statisticType = null;
        if (argsList.contains("-f")) {
            statisticType = "-f";
        } else if (argsList.contains("-s")) {
            statisticType = "-s";
        }
        return statisticType;
    }

    public static String getOutputPath(List<String> argsList) {
        String outputPath = "/Users/evi/Documents/SHIFTNEW/files/";
        int pathIndex = argsList.indexOf("-o");
        if (pathIndex != -1) {
            outputPath = argsList.get(pathIndex + 1);
        }
        return outputPath;
    }

    public static String getFilePrefix(List<String> argsList) {
        String prefix = "";
        int prefixIndex = argsList.indexOf("-p");
        if (prefixIndex != -1) {
            prefix = argsList.get(prefixIndex + 1);
        }
        return prefix;
    }

    public static List<String> getFiles(List<String> argsList) {

        return argsList.stream()
                .filter((String arg) -> arg.endsWith(".txt"))
                .collect(Collectors.toList());
    }
}
