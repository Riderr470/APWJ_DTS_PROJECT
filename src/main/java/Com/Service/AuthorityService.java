package Com.Service;

import Com.Domain.Authority;
import Com.Repository.AuthorityRepo;
import Com.Repository.IRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorityService implements IRepo<Authority, Integer, Authority> {
    private AuthorityRepo authorityRepo;

    public AuthorityService(AuthorityRepo authorityRepo) {
        this.authorityRepo = authorityRepo;
    }

    @Transactional
    public Authority create(Authority authority) {
        return authorityRepo.create(authority);
    }

    @Transactional(readOnly = true)
    public Authority get(Integer id) {
        return authorityRepo.get(id);
    }

    @Transactional(readOnly = true)
    public List<Authority> getAll() {
        return authorityRepo.getAll();
    }

    @Transactional
    public Authority update(Authority authority) {
        return authorityRepo.update(authority);
    }

    @Transactional
    public void delete(Integer id) {
        authorityRepo.delete(id);
    }
}
