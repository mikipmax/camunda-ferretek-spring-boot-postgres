package com.ferretek.delegates;

import org.apache.commons.mail.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.net.URL;

public class EnviarEmail implements JavaDelegate {
    static final String HOST = "smtp.gmail.com";
    static final String USER = "fredponce10@gmail.com";
    static final String PWD = "C@rrocasa";

    public void execute(DelegateExecution execution) {
        EmailAttachment attachment = new EmailAttachment();
        URL resource = getClass().getResource("/detalles.pdf");
        attachment.setPath(resource.getPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("detalles.pdf");
        attachment.setName("document");

        MultiPartEmail email = new MultiPartEmail();
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(USER, PWD));

        email.setHostName(HOST);


        try {
            email.getMailSession().getProperties().put("mail.smtps.auth", "true");
            email.getMailSession().getProperties().put("mail.debug", "true");
            email.getMailSession().getProperties().put("mail.smtps.port", "587");
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", "587");
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
            email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
            email.setFrom(USER);
            email.setSubject("Detalle de Venta");


            email.setMsg("Estimado: " + execution.getVariable("nombreCompleto") + " se le adjunta su detalle de Venta."
                    + "\nInformación del Correo: Mail generado automáticamente. Por favor no responda a este mensaje.");

            email.addTo(execution.getVariable("clienCorreo").toString());
            //email.setTLS(true);
            email.attach(attachment);
            email.send();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
