package com.qpros.scholarship;

import com.qpros.helpers.EmailHelper;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class Test {


    public static void main(String[] args) throws GeneralSecurityException, MessagingException {

        EmailHelper email = new EmailHelper();
        email.sendMail("mohammedm@q-pros.net", "src\\main\\resources\\Reports\\QPros-Automation_Report-2020-08-25-1598338473644.html");

    }





}


