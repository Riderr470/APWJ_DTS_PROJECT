package Com.Repository;

import java.util.List;

public interface IRepo<CLASS, ID, RET> {
    public List<CLASS> getAll();

    public RET create(CLASS obj);

    public RET get(ID id);

    public RET update(CLASS obj);

    public void delete(ID id);

}
