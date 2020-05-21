package com.qpros.helpers;


import org.testng.Assert;

import java.io.*;
import java.util.Properties;

public class ReadWriteHelper {

    private static String Par = "";

    public static String ReadData(String par) {
        File file = new File("src/main/resources/config.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (Throwable e) {
            e.printStackTrace(System.out);
            Assert.fail("\nPlease check config file if exist\n");
        }
        Properties prop = new Properties();

        // load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace(System.out);
            Assert.fail("\nPlease check config file Inputs\n");
        }

        return Par = prop.getProperty(par);
    }

    public static String[][] readCSVFile(String path, int linesToRead, int columnsToRead) {
        //Possible future implementation: Make separators as input. However this looks better for reusability
        String line = "";
        String csvSplitBy = ",";
        String[][] finalResult = new String[linesToRead][columnsToRead];
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int j=0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] currentLine = line.split(csvSplitBy);
                for (int i=0; i<=columnsToRead; i++){
                    finalResult[j][i] = currentLine[i];
                }
                //System.out.println("Linex [first clmn= " + currentLine[0] + " , 2nd clmn=" + currentLine[1] + "]");
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalResult;
    }


}
