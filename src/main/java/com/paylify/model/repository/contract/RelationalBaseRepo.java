package com.paylify.model.repository.contract;

import com.paylify.web.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class RelationalBaseRepo<T extends BaseModel, R extends JpaRepository<T, Long>> implements IRepo<T> {
    private final R r;
    private final String name;

    public RelationalBaseRepo(R r, String name) {
        this.r = r;
        this.name = name;
    }

    @Override
    public T create(T t) {
        return r.save(t);
    }

    @Override
    public Page<T> getAll(int pageNum, int pageSize) {
        List<T> ts;

        if(pageNum > 0){
            return r.findAll(PageRequest.of(pageNum - 1, pageSize, Sort.by(new Sort.Order(Sort.Direction.DESC, "id"))));
        }else {
            ts = r.findAll(Sort.by(new Sort.Order(Sort.Direction.DESC, "ib")));
            return new PageImpl<>(ts);
        }
    }

    @Override
    public T getById(long id) {
        Optional<T> t = r.findById(id);

        if (t.isEmpty())
            throw new ResourceNotFoundException(name + " not found");

        return t.get();
    }

    @Override
    public T update(T t) {
        if(r.findById(t.getId()).isEmpty())
            throw new ResourceNotFoundException(name + " not found");
        return r.save(t);
    }

    @Override
    public void delete(long id) {
        if(r.findById(id).isPresent())
            throw new ResourceNotFoundException(name + "not found");

        r.deleteById(id);
    }
}
