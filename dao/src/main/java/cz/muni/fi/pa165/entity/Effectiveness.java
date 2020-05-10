package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Entity representing effectiveness of {@link Weapon} on {@link Creature}, created by author {@link User}
 *
 * @author Filip Sollar
 */
@Entity
@Table(name = "weapon_effectiveness")
public class Effectiveness {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private User author;

    @NotNull
    @ManyToOne
    private Weapon weapon;

    @NotNull
    @ManyToOne
    private Creature creature;

    private double rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Effectiveness that = (Effectiveness) o;
        return Double.compare(that.rating, rating) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(author, that.author) &&
                Objects.equals(weapon, that.weapon) &&
                Objects.equals(creature, that.creature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, weapon, creature, rating);
    }
}
