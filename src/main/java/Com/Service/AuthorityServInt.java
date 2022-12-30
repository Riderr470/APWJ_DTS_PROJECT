package Com.Service;

import Com.Domain.Authority;

import java.util.List;

public interface AuthorityServInt {
    public Authority create(Authority authority);

    public Authority get(Long id);

    public List<Authority> getAll();

    public Authority update(Authority authority);

    public void delete(Long id);
}
