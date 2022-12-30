package Com.Repository;

import Com.Domain.Authority;

import java.util.List;

public interface AuthorityInterface {

    public List<Authority> getAll();

    public Authority create(Authority authority);

    public Authority get(Long id);

    public Authority update(Authority authority);

    public void delete(Long id);
}
