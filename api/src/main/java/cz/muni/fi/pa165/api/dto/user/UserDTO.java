package cz.muni.fi.pa165.api.dto.user;

import cz.muni.fi.pa165.api.dto.effectiveness.EffectivenessDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class UserDTO {

    private Long id;

    private String name;
    private String username;
    private String email;

    private boolean isAdmin;

    private byte[] image;
    private String imageMimeType;


    private List<EffectivenessDTO> posts;

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

    public List<EffectivenessDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<EffectivenessDTO> posts) {
        this.posts = posts;
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
        UserDTO userDTO = (UserDTO) o;
        return isAdmin == userDTO.isAdmin &&
                Objects.equals(id, userDTO.id) &&
                Objects.equals(name, userDTO.name) &&
                Objects.equals(username, userDTO.username) &&
                Objects.equals(email, userDTO.email) &&
                Arrays.equals(image, userDTO.image) &&
                Objects.equals(imageMimeType, userDTO.imageMimeType) &&
                Objects.equals(posts, userDTO.posts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, username, email, isAdmin, imageMimeType, posts);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
