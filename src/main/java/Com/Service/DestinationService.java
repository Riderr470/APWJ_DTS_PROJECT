package Com.Service;

import Com.Domain.Destination;
import Com.Repository.DestinationRepo;
import Com.Repository.IRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DestinationService implements IRepo<Destination, Integer, Destination> {
    private DestinationRepo destinationRepo;


    public DestinationService(DestinationRepo destinationRepo) {
        this.destinationRepo = destinationRepo;
    }

    @Transactional
    public Destination create(Destination destination) {
        return destinationRepo.create(destination);
    }

    @Transactional(readOnly = true)
    public Destination get(Integer id) {
        return destinationRepo.get(id);
    }

    @Transactional(readOnly = true)
    public List<Destination> getAll() {
        return destinationRepo.getAll();
    }

    @Transactional
    public Destination update(Destination destination) {
        return destinationRepo.update(destination);
    }

    @Transactional
    public void delete(Integer id) {
        destinationRepo.delete(id);
    }
}
