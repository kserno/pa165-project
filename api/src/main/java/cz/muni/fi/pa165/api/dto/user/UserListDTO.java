package cz.muni.fi.pa165.api.dto.user;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class UserListDTO {

    private Long id;

    private String name;
    private String username;
    private String email;

    private boolean isAdmin;

    private byte[] image;
    private String imageMimeType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageMimeType() {
        return imageMimeType;
    }

    public void setImageMimeType(String imageMimeType) {
        this.imageMimeType = imageMimeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserListDTO that = (UserListDTO) o;
        return isAdmin == that.isAdmin &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(username, that.username) &&
                Objects.equals(email, that.email) &&
                Arrays.equals(image, that.image) &&
                Objects.equals(imageMimeType, that.imageMimeType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, username, email, isAdmin, imageMimeType);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
