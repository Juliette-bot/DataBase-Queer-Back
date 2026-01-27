package com.example.backQueerDataBase.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "play_metadata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creator")
    private String creator;

    @Column(name = "game_genre")
    private String gameGenre;

    @Column(name = "player_number")
    private Integer playerNumber;

    @OneToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;
}