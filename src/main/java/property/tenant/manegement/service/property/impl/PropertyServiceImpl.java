package property.tenant.manegement.service.property.impl;

import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.repository.property.impl.PropertyRepositoryImpl;
import property.tenant.manegement.repository.property.PropertyRepository;
import property.tenant.manegement.service.property.PropertyService;

import java.util.Set;
@Service
public class PropertyServiceImpl implements PropertyService {

    private static PropertyServiceImpl service = null;
    private PropertyRepository repository;

    private PropertyServiceImpl() {
        this.repository = PropertyRepositoryImpl.getInstance();
    }

    public static PropertyServiceImpl getService(){
        if (service == null) service = new PropertyServiceImpl();
        return service;
    }

    @Override
    public Property retrieveByDesc(String addDesc) {
        return this.repository.retrieveByDesc(addDesc);
    }

    @Override
    public Set<Property> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Property create(Property property) {
        return this.repository.create(property);
    }

    @Override
    public Property update(Property property) {
        return this.repository.update(property);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Property read(String s) {
        return this.repository.read(s);
    }
}
