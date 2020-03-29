package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;



}
