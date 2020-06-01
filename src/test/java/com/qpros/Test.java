package com.qpros;

import com.qpros.common.Base;
import com.qpros.helpers.ReadWriteHelper;


public class Test extends Base {


    public static void main(String[] args){

        //Read from csv file
        String[][] a = ReadWriteHelper.readCSVFile( "test",2,2);
        System.out.println("Get record using csv reader: " + a[0][0]);

        //Read from xml file
        String username = ReadWriteHelper.readCredentialsXMLFile("applicantCredentials1","username");
        System.out.println("Get record using xml reader: " + username);


        //Read from xml file
        String program = ReadWriteHelper.readProgramsXMLFile("program15","title");
        System.out.println("Get record using xml reader: " + program);

    }



}
