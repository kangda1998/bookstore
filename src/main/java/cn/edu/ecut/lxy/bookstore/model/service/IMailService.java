package cn.edu.ecut.lxy.bookstore.model.service;

public interface IMailService {

    void sendSimpleMail(String to, String subject, String content) throws Exception;

    void sendHtmlMail(String to, String subject, String content) throws Exception;
}
