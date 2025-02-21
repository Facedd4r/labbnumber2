package com.example.labbnumber2;

public class Message {
    private long count;
    private long add;

    // Конструктор, инициализирующий поля count и add
    public Message(long count, long add) {
        this.count = count;
        this.add = add;
    }

    // Геттер для поля count
    public long getCount() {
        return count;
    }

    // Геттер для поля add
    public long getAdd() {
        return add;
    }
}
