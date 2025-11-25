package com.chat.chatendpoint;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    private final List<Chat> chats = new ArrayList<>();
    private long nextId = 1;

    @GetMapping
    public List<Chat> listarTodos() {
        return chats;
    }

    @GetMapping("/{id}")
    public Chat buscarPorId(@PathVariable Long id) {
        for (Chat c : chats) {
            if (c.getId() != null && c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping
    public Chat criarChat(@RequestBody Chat chat) {
        chat.setId(nextId++);
        if (chat.getLogMensagens() == null) chat.setLogMensagens(new HashMap<>());
        chats.add(chat);
        return chat;
    }

    @PutMapping("/{id}")
    public Chat atualizarChat(@PathVariable Long id, @RequestBody Chat atualizado) {
        Chat existente = buscarPorId(id);
        if (existente != null) {
            existente.setLogMensagens(atualizado.getLogMensagens());
        }
        return existente;
    }

    @DeleteMapping("/{id}")
    public void removerChat(@PathVariable Long id) {
        for (Iterator<Chat> it = chats.iterator(); it.hasNext(); ) {
            if (it.next().getId() != null && it.next().getId().equals(id)) {
                it.remove();
                break;
            }
        }
    }
}
