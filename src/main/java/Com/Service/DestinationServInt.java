package Com.Service;

import Com.Domain.Destination;

import java.util.List;

public interface DestinationServInt {
    public Destination create(Destination destination);

    public Destination get(Long id);

    public List<Destination> getAll();

    public Destination update(Destination destination);

    public void delete(Long id);
}
