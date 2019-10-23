package com.test;

import java.util.Objects;

public class Vertex {
    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", character=" + character +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id &&
                character == vertex.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, character);
    }

    public int getId() {
        return id;
    }

    public char getCharacter() {
        return character;
    }

    private int id;
    private char character;

    public Vertex(int id, char character) {
        this.character = character;
        this.id = id;
    }

}
