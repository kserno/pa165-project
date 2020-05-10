package cz.muni.fi.pa165.api.dto.creature;

import javax.validation.constraints.NotNull;

/**
 * @author Filip Sollar
 */
public class CreatureUpdateDTO {

    @NotNull
    private String name;

    private double weight;
    private double agility;
    private double height;

    private String image;

}
