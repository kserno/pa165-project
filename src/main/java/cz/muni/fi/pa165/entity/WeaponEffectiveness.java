package cz.muni.fi.pa165.entity;

import javax.persistence.*;

@Entity
public class WeaponEffectiveness {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User author;

    @ManyToOne
    private Weapon weapon;

    @ManyToOne
    private Creature creature;

}
