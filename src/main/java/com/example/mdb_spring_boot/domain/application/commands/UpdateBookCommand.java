package com.example.mdb_spring_boot.domain.application.commands;

public record UpdateBookCommand(String id, String title, String authorName) {}
