/*
 * Classe responsavel pelo envio de emails
 */
package br.edu.unipampa.geketcc.model;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Douglas Giordano
 * @since 08/06/2014
 */
public class Email {

    private Properties props;
    private Message message;
    private Session session;

    private final String EMAIL = "unipamparpvi2014@gmail.com";
    private final String SENHA = "miguelito2014";
    private String destinatarios;
    private String assunto;
    private String mensagem;

    public Email(String assunto, String mensagem, String destinatarios) {
        configurar();
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.destinatarios = destinatarios;
    }

    /**
     * Parâmetros de conexão com servidor Gmail
     */
    private void configurar() {
        props = new Properties();
        props.put("mail.smtp.user", EMAIL);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.EnableSSL.enable", "true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL, SENHA);
                    }
                });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);
    }

    public boolean enviarEmail() {
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL)); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(destinatarios);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setContent(mensagem, "text/html; charset=utf-8");
            message.setSubject(assunto);//Assunto      
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
