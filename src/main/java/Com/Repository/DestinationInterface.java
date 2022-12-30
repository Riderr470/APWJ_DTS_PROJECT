package Com.Repository;

import Com.Domain.Destination;

import java.util.List;

public interface DestinationInterface {
    public List<Destination> getAll();

    public Destination create(Destination destination);

    public Destination get(Long id);

    public Destination update(Destination destination);

    public void delete(Long id);
}
