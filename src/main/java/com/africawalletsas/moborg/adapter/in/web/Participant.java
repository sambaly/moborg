package com.africawalletsas.moborg.adapter.in.web;

public record Participant(String fullName,
                          String gitHubUsername,
                          String email,
                          String DiscordUsername,
                          boolean newToMobbing) {
}
