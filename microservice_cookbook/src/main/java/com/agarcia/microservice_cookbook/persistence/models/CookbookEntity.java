package main.java.com.agarcia.microservice_cookbook.persistence.models;

@Entity
@Table(name = "cookbook")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CookbookEntity {

    private Long id;
    private String name;
    private String image;
    private String description;
    private String instructions;
    private int time_of_preparation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

}

// Enum de Dificultad
public enum Difficulty {
    BEGINNER("Principiante"),
    INTERMEDIATE("Intermedio"), 
    ADVANCED("Avanzado"),
    EXPERT("Experto");
    
    private final String displayName;
    
    Difficulty(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}