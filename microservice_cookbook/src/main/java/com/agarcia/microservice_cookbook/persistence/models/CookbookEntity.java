package com.agarcia.microservice_cookbook.persistence.models;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.agarcia.commons_ingredients.persistence.models.IngredientsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cookbook")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CookbookEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String image;
    private String description;
    private String instructions;

    @OneToMany(fetch = FetchType.LAZY)
    private List<IngredientsEntity> ingredients;

    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public void addIngredient(IngredientsEntity ingredient) {
        this.ingredients.add(ingredient);
    }

    public boolean removeIngredient(IngredientsEntity ingredient) {
        if (this.ingredients == null || ingredient == null || ingredient.getId() == null) {
            return false;
        }
        
        // Buscar el ingrediente real en la lista por ID
        Optional<IngredientsEntity> ingredientToRemove = this.ingredients.stream()
            .filter(ing -> ingredient.getId().equals(ing.getId()))
            .findFirst();
        
        if (ingredientToRemove.isPresent()) {
            return this.ingredients.remove(ingredientToRemove.get());
        }
        
        return false;
    }

}