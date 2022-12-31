package Com.Service;

import Com.Domain.Authority;
import Com.Repository.AuthorityInterface;
import Com.Repository.AuthorityRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorityService implements AuthorityServInt {
    private AuthorityInterface authorityInterface;

    public AuthorityService(AuthorityInterface authorityInterface) {
        this.authorityInterface = authorityInterface;
    }

    @Transactional
    public Authority create(Authority authority) {
        return authorityInterface.create(authority);
    }

    @Transactional(readOnly = true)
    public Authority get(Long id) {
        return authorityInterface.get(id);
    }

    @Transactional(readOnly = true)
    public List<Authority> getAll() {
        return authorityInterface.getAll();
    }

    @Transactional
    public Authority update(Authority authority) {
        return authorityInterface.update(authority);
    }

    @Transactional
    public void delete(Long id) {
        authorityInterface.delete(id);
    }
}
