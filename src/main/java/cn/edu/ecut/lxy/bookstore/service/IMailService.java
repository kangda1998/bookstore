package cn.edu.ecut.lxy.bookstore.service;

public interface IMailService {

    void sendSimpleMail(String to, String subject, String content) throws Exception;

    /**
     * 邮件发送，发送html形式，异步
     * @param to
     * @param subject
     * @param content
     * @throws Exception
     */
    void sendHtmlMail(String to, String subject, String content) throws Exception;
}
