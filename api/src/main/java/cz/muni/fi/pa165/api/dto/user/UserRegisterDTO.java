package cz.muni.fi.pa165.api.dto.user;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class UserRegisterDTO {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRegisterDTO that = (UserRegisterDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, username, password);
    }
}
