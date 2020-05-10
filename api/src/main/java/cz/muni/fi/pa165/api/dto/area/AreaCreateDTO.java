package cz.muni.fi.pa165.api.dto.area;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Filip Sollar
 */
public class AreaCreateDTO {

    @NotNull
    private String name;

    @NotNull
    @Size(min = 10, max = 100)
    private String description;

    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
