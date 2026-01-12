package com.example.backQueerDataBase.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {

    static {
        loadEnvironmentVariables();
    }

    public static void loadEnvironmentVariables() {
        try {
            System.out.println("Working directory: " + System.getProperty("user.dir"));

            Dotenv dotenv = Dotenv.configure()
                    .directory(".")
                    .ignoreIfMissing()
                    .load();

            dotenv.entries().forEach(entry ->
                    System.setProperty(entry.getKey(), entry.getValue())
            );

            System.out.println("Variables d'environnement chargées depuis .env");

        } catch (Exception e) {
            System.out.println("Fichier .env non trouvé: " + e.getMessage());
        }
    }
    }
