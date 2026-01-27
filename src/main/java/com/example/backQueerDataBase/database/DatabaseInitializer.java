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
        System.out.println("\nStart initialisation bdd\n");
        createTables();
        insertTestData();
        System.out.println("\nInitialisation done\n");
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

        String createCategoryTable = """
            CREATE TABLE IF NOT EXISTS category (
                id BIGSERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                media_id BIGINT REFERENCES media(id) ON DELETE CASCADE,
                UNIQUE (name, media_id)
            )
        """;

        String createResourcesTable = """
            CREATE TABLE IF NOT EXISTS resources (
                id BIGSERIAL PRIMARY KEY,
                title VARCHAR(255) NOT NULL,
                description TEXT,
                url VARCHAR(500),
                tags TEXT[],
                language VARCHAR(50),
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                media_id BIGINT REFERENCES media(id) ON DELETE SET NULL,
                category_id BIGINT REFERENCES category(id) ON DELETE SET NULL,
                user_id BIGINT REFERENCES users(id) ON DELETE SET NULL
            )
        """;

        String createReadMetadataTable = """
            CREATE TABLE IF NOT EXISTS read_metadata (
                id BIGSERIAL PRIMARY KEY,
                resource_id BIGINT NOT NULL UNIQUE REFERENCES resources(id) ON DELETE CASCADE,
                author VARCHAR(255),
                publication_date DATE,
                page_count INTEGER,
                format VARCHAR(100)
            )
        """;

        String createListenMetadataTable = """
            CREATE TABLE IF NOT EXISTS listen_metadata (
                id BIGSERIAL PRIMARY KEY,
                resource_id BIGINT NOT NULL UNIQUE REFERENCES resources(id) ON DELETE CASCADE,
                creator VARCHAR(255),
                duration INTEGER,
                platform VARCHAR(100),
                episode_number VARCHAR(50)
            )
        """;

        String createWatchMetadataTable = """
            CREATE TABLE IF NOT EXISTS watch_metadata (
                id BIGSERIAL PRIMARY KEY,
                resource_id BIGINT NOT NULL UNIQUE REFERENCES resources(id) ON DELETE CASCADE,
                creator VARCHAR(255),
                duration INTEGER,
                platform VARCHAR(100),
                video_type VARCHAR(100)
            )
        """;

        String createPlayMetadataTable = """
            CREATE TABLE IF NOT EXISTS play_metadata (
                id BIGSERIAL PRIMARY KEY,
                resource_id BIGINT NOT NULL UNIQUE REFERENCES resources(id) ON DELETE CASCADE,
                creator VARCHAR(255),
                game_genre VARCHAR(255),
                player_number INTEGER
            )
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            System.out.println("Création des tables...\n");

            stmt.execute(createUsersTable);
            System.out.println("Table 'users' créée");

            stmt.execute(createMediaTable);
            System.out.println("Table 'media' créée");

            stmt.execute(createCategoryTable);
            System.out.println("Table 'category' créée");

            stmt.execute(createResourcesTable);
            System.out.println("Table 'resources' créée");

            stmt.execute(createReadMetadataTable);
            System.out.println("Table 'read_metadata' créée");

            stmt.execute(createListenMetadataTable);
            System.out.println("Table 'listen_metadata' créée");

            stmt.execute(createWatchMetadataTable);
            System.out.println("Table 'watch_metadata' créée");

            stmt.execute(createPlayMetadataTable);
            System.out.println("Table 'play_metadata' créée");

        } catch (SQLException e) {
            System.err.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertTestData() {
        String insertMedia = """
            INSERT INTO media (type) 
            VALUES ('Lire'), ('Écouter'), ('Regarder'), ('Jouer')
            ON CONFLICT (type) DO NOTHING
        """;

        String insertCategories = """
            INSERT INTO category (name, media_id) 
            VALUES 
                ('Podcast', 2), 
                ('Music', 2),
                ('Content_creators', 3), 
                ('Cinema', 3),
                ('Documentary', 3),
                ('Series', 3),
                ('BD', 1), 
                ('Roman', 1), 
                ('Press', 1),
                ('Article', 1),
                ('Board_game', 4),
                ('Video_game', 4) 
                
            ON CONFLICT (name, media_id) DO NOTHING
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            System.out.println("\nInsertion des données...\n");

            stmt.execute(insertMedia);
            System.out.println("Media insérés");

            stmt.execute(insertCategories);
            System.out.println("Catégories insérées");

        } catch (SQLException e) {
            System.err.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}