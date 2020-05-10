package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.effectiveness.EffectivenessDao;
import cz.muni.fi.pa165.entity.Effectiveness;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Concrete implementation of {@link EffectivenessService}.
 *
 * @author Filip Sollar
 */
@Service
public class EffectivenessServiceImpl implements EffectivenessService {

    @Inject
    private EffectivenessDao effectivenessDao;

    @Override
    public void createEffectiveness(Effectiveness effectiveness) {
        effectivenessDao.create(effectiveness);
    }

    @Override
    public Effectiveness getEffectivenessById(Long id) {
        return effectivenessDao.retrieve(id);
    }

    @Override
    public void deleteEffectiveness(Effectiveness effectiveness) {
        effectivenessDao.delete(effectiveness);
    }
}
