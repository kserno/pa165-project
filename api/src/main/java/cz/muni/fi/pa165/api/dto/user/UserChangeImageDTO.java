package cz.muni.fi.pa165.api.dto.user;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class UserChangeImageDTO {
    private Long userId;
    private byte[] image;
    private String imageMimeType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        UserChangeImageDTO that = (UserChangeImageDTO) o;
        return Objects.equals(userId, that.userId) &&
                Arrays.equals(image, that.image) &&
                Objects.equals(imageMimeType, that.imageMimeType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, imageMimeType);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
