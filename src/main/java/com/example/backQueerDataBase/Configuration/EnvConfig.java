package com.example.backQueerDataBase.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {

    static {
        loadEnvironmentVariables();
    }

    public static void loadEnvironmentVariables() {
        try {
            Dotenv dotenv = Dotenv.configure()
                    .ignoreIfMissing()
                    .load();

            dotenv.entries().forEach(entry ->
                    System.setProperty(entry.getKey(), entry.getValue())
            );

            System.out.println("Variables d'environnement chargées depuis .env");

        } catch (Exception e) {
            System.out.println("Fichier .env non trouvé");
        }
    }
}