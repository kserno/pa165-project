package cz.muni.fi.pa165.api.dto.user;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class UserAuthenticateDTO {

    @NotNull
    private String email;

    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        UserAuthenticateDTO that = (UserAuthenticateDTO) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
