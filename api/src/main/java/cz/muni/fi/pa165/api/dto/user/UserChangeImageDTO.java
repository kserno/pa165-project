package cz.muni.fi.pa165.api.dto.user;

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
}
