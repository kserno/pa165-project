package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Creature {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private double weight;
    private double agility;
    private double height;

    @OneToMany()
    private List<WeaponEffectiveness> weaponEffectivenesses = new ArrayList<WeaponEffectiveness>();

    @ManyToMany
    private List<Area> areas = new ArrayList<Area>();
}
