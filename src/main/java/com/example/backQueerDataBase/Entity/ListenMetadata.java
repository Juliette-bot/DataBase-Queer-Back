package com.example.backQueerDataBase.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "listen_metadata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListenMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "resource_id", nullable = false, unique = true)
    private Resource resource;

    @Column(name = "creator")
    private String creator;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "platform")
    private String platform;

    @Column(name = "episode_number")
    private String episodeNumber;
}