package com.qpros.helpers;


import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class ReadWriteHelper {

    private static String Par = "";

    public static String ReadData(String par) {
        File file = new File( "src/main/resources/config.properties" );

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream( file );
        } catch (Throwable e) {
            e.printStackTrace( System.out );
            Assert.fail( "\nPlease check config file if exist\n" );
        }
        Properties prop = new Properties();

        // load properties file
        try {
            prop.load( fileInput );
        } catch (IOException e) {
            e.printStackTrace( System.out );
            Assert.fail( "\nPlease check config file Inputs\n" );
        }

        return Par = prop.getProperty( par );
    }

    public static String[][] readCSVFile(String fileName, int linesToRead, int columnsToRead) {
        //Possible future implementation: Make separators as input. However this looks better for reusability
        String line = "";
        String csvSplitBy = ",";
        String[] currentLine = null;
        String[][] finalResult = new String[linesToRead][columnsToRead];
        try (BufferedReader br = new BufferedReader( new FileReader( System.getProperty( "user.dir" ) +
                "/src/main/resources/DataProvider/"+fileName+".csv" ) )) {
            int j = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                 currentLine = line.split( csvSplitBy );
                for (int i = 0; i < currentLine.length; i++) {
                    finalResult[j][i] = currentLine[i];
                }
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalResult;
    }

    public static String readCredentialsXMLFile(String credentialsType, String tag) {

        String value = "";

        try {
            //creating a constructor of file class and parsing an XML file
            File file = new File( System.getProperty( "user.dir" ) +
                    "/src/main/resources/DataProvider/credentialsData.xml" );
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse( file );
            doc.getDocumentElement().normalize();
            //System.out.println( "Root element: " + doc.getDocumentElement().getNodeName() );
            NodeList nodeList = doc.getElementsByTagName( credentialsType );
            // nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item( itr );
                //System.out.println( "\nNode Name :" + node.getNodeName() );
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    switch (tag){
                        case "username":
                            value = eElement.getElementsByTagName( "username" ).item( 0 ).getTextContent();
                            break;
                        case "password":
                            value = eElement.getElementsByTagName( "password" ).item( 0 ).getTextContent();
                            break;
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public static String readProgramsXMLFile(String programNumber, String tag) {

        String value = "";

        try {
            //creating a constructor of file class and parsing an XML file
            File file = new File( System.getProperty( "user.dir" ) +
                    "/src/main/resources/DataProvider/programsData.xml" );
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse( file );
            doc.getDocumentElement().normalize();
            //System.out.println( "Root element: " + doc.getDocumentElement().getNodeName() );
            NodeList nodeList = doc.getElementsByTagName( programNumber );
            // nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item( itr );
                //System.out.println( "\nNode Name :" + node.getNodeName() );
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    switch (tag){
                        case "title":
                            value = eElement.getElementsByTagName( "title" ).item( 0 ).getTextContent();
                            break;
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }
    public static String readApplicationsXMLFile(String applicationId, String tag) {

        String value = "";

        try {
            //creating a constructor of file class and parsing an XML file
            File file = new File( System.getProperty( "user.dir" ) +
                    "/src/main/resources/DataProvider/applicationsData.xml" );
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse( file );
            doc.getDocumentElement().normalize();
            //System.out.println( "Root element: " + doc.getDocumentElement().getNodeName() );
            NodeList nodeList = doc.getElementsByTagName( applicationId );
            // nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item( itr );
                //System.out.println( "\nNode Name :" + node.getNodeName() );
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    switch (tag){
                        case "title":
                            value = eElement.getElementsByTagName( "title" ).item( 0 ).getTextContent();
                            break;
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

}
