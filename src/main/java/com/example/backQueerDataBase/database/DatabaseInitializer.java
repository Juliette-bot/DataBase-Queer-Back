package com.example.backQueerDataBase.database;

import com.example.backQueerDataBase.Configuration.DatabaseConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DatabaseInitializer {

    @PostConstruct
    public void init() {
        System.out.println("\n🔧 === INITIALISATION DE LA BASE DE DONNÉES ===\n");
        createTables();
        insertTestData();
        System.out.println("\n✅ === INITIALISATION TERMINÉE ===\n");
    }

    public void createTables() {
        String createUsersTable = """
            CREATE TABLE IF NOT EXISTS users (
                id BIGSERIAL PRIMARY KEY,
                first_name VARCHAR(255),
                last_name VARCHAR(255),
                email VARCHAR(255) UNIQUE NOT NULL,
                password VARCHAR(255) NOT NULL,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
        """;

        String createMediaTable = """
            CREATE TABLE IF NOT EXISTS media (
                id BIGSERIAL PRIMARY KEY,
                type VARCHAR(50) NOT NULL UNIQUE
            )
        """;

        String createCategoriesTable = """
            CREATE TABLE IF NOT EXISTS categories (
                id BIGSERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                media_id BIGINT REFERENCES media(id) ON DELETE CASCADE
            )
        """;

        String createSubCategoriesTable = """
            CREATE TABLE IF NOT EXISTS sub_categories (
                id BIGSERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                category_id BIGINT REFERENCES categories(id) ON DELETE CASCADE
            )
        """;

        String createResourcesTable = """
            CREATE TABLE IF NOT EXISTS resources (
                id BIGSERIAL PRIMARY KEY,
                name VARCHAR(200) NOT NULL,
                description TEXT,
                sub_category_id BIGINT REFERENCES sub_categories(id) ON DELETE SET NULL,
                user_id BIGINT REFERENCES users(id) ON DELETE SET NULL,
                url VARCHAR(500),
                image_url VARCHAR(500),
                creator VARCHAR(200),
                release_year INTEGER,
                duration_minutes INTEGER,
                platform VARCHAR(100),
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            )
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            System.out.println("Création des tables...\n");

            stmt.execute(createUsersTable);
            System.out.println("Table 'users' créée");

            stmt.execute(createMediaTable);
            System.out.println("Table 'media' créée");

            stmt.execute(createCategoriesTable);
            System.out.println("Table 'categories' créée");

            stmt.execute(createSubCategoriesTable);
            System.out.println("Table 'sub_categories' créée");

            stmt.execute(createResourcesTable);
            System.out.println("Table 'resources' créée");

        } catch (SQLException e) {
            System.err.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertTestData() {
        String insertMedia = """
            INSERT INTO media (type) 
            VALUES ('listen'), ('watch'), ('read')
            ON CONFLICT (type) DO NOTHING
        """;

        String insertCategories = """
            INSERT INTO categories (name, media_id) 
            VALUES 
                ('Radio', 1), ('Podcast', 1), ('Music', 1),
                ('Content_creators', 2), ('Cinema', 2),
                ('Bd', 3), ('Roman', 3), ('Press', 3)
            ON CONFLICT DO NOTHING
        """;

        String insertSubCategories = """
            INSERT INTO sub_categories (name, category_id)
            VALUES 
                ('YouTube', 4), ('Twitch', 4), ('Porno', 4), ('Instagram', 4),
                ('Documentaire', 5), ('Film', 5), ('Serie', 5)
            ON CONFLICT DO NOTHING
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            System.out.println("\nInsertion des données...\n");

            stmt.execute(insertMedia);
            System.out.println("Media insérés");

            stmt.execute(insertCategories);
            System.out.println("Catégories insérées");

            stmt.execute(insertSubCategories);
            System.out.println("Sous-catégories insérées");

        } catch (SQLException e) {
            System.err.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}