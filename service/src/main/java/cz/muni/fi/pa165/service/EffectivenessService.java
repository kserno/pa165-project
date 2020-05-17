package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Effectiveness;
import org.springframework.stereotype.Service;

/**
 * Service for handling of {@link Effectiveness}
 *
 * @author Filip Solllar
 */
@Service
public interface EffectivenessService {
    void createEffectiveness(Effectiveness effectiveness);

    Effectiveness getEffectivenessById(Long id);
    void deleteEffectiveness(Effectiveness effectiveness);

}
