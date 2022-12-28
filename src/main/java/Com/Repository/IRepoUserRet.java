package Com.Repository;

public interface IRepoUserRet<RET> {
    public RET getByUsername(String name);
}
