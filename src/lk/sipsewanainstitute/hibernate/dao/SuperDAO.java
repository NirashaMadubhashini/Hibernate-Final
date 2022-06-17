package lk.sipsewanainstitute.hibernate.dao;


import lk.sipsewanainstitute.hibernate.entity.Student;
import lk.sipsewanainstitute.hibernate.entity.SuperEntity;

import java.util.List;

public interface SuperDAO <T,ID>extends SuperEntity{
    public boolean add(T t)throws Exception;
    public boolean update(T t)throws Exception;
    public boolean delete(ID id)throws Exception;
    public T find(ID id)throws Exception;
    public List<T> findAll()throws Exception;

}
