package com.ohgiraffers.io.note.run;

import com.ohgiraffers.io.note.view.NoteMenu;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        NoteMenu menu = new NoteMenu();
        menu.menu();
    }
}