package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Effectiveness;

/**
 * Service for handling of {@link Effectiveness}
 *
 * @author Filip Solllar
 */
public interface EffectivenessService {
    void createEffectiveness(Effectiveness effectiveness);

    Effectiveness getEffectivenessById(Long id);
    void deleteEffectiveness(Effectiveness effectiveness);

}
