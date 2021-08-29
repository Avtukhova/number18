package ru.netology.domain;

import java.util.Objects;

public class Main extends Product {
    private String text;

    public Main(int id, String name, int price, String text) {
        super(id, name, price);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Main main = (Main) o;
        return Objects.equals(text, main.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), text);
    }
}
