package property.tenant.manegement.service.property.impl;

import org.springframework.stereotype.Service;
import property.tenant.manegement.domain.property.Property_Types;
import property.tenant.manegement.repository.property.PropertTypeRepository;
import property.tenant.manegement.repository.property.impl.PropertTypeRepositoryImpl;
import property.tenant.manegement.service.property.PropertyTypeService;

import java.util.Set;
@Service
public class PropertyTypeServiceImpl implements PropertyTypeService {

    private static PropertyTypeServiceImpl service = null;
    private PropertTypeRepository repository;

    private PropertyTypeServiceImpl() {
        this.repository = PropertTypeRepositoryImpl.getInstance();
    }

    public static PropertyTypeServiceImpl getService(){
        if (service == null) service = new PropertyTypeServiceImpl();
        return service;
    }

    @Override
    public Set<Property_Types> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Property_Types create(Property_Types property_types) {
        return this.repository.create(property_types);
    }

    @Override
    public Property_Types update(Property_Types property_types) {
        return this.repository.update(property_types);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public Property_Types read(String s) {
        return this.repository.read(s);
    }
}
