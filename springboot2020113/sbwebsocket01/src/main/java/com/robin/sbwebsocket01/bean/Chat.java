package com.robin.sbwebsocket01.bean;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/13 14:57
 */
public class Chat {
    private String from;
    private String content;
    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
