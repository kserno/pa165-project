package cz.muni.fi.pa165.service;

/**
 * Serving providing hashing functions
 *
 * @author Filip Sollar
 */
public interface HashingService {

    String createHash(String password);
    boolean validatePassword(String password, String correctHash);
}
