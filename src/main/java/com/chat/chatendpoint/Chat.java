package com.chat.chatendpoint;

import java.util.HashMap;

public class Chat {
    private Long id;
    private HashMap<String, String> logMensagens = new HashMap<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HashMap<String, String> getLogMensagens() {
        return logMensagens;
    }

    public void setLogMensagens(HashMap<String, String> logMensagens) {
        this.logMensagens = logMensagens != null ? logMensagens : new HashMap<>();
    }

    public void putLogMensagem(String key, String value) {
        this.logMensagens.put(key, value);
    }
}
