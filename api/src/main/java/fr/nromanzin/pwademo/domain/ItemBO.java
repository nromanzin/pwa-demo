package fr.nromanzin.pwademo.domain;

import java.util.UUID;

public record ItemBO(UUID uuid, String name, int quantity) {}
