package property.tenant.manegement.repository.property.impl;

import property.tenant.manegement.domain.property.Property;
import property.tenant.manegement.repository.property.PropertyRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PropertyRepositoryImpl implements PropertyRepository {
    private static PropertyRepositoryImpl repository = null;

    private Map<String, Property> propertyMap;

    private PropertyRepositoryImpl() {
        propertyMap = new HashMap<String, Property>();
    }

    public static PropertyRepositoryImpl  getInstance(){
        if(repository == null) repository = new PropertyRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Property> getAll() {
        return null;
    }

    @Override
    public Property create(Property property) {
        propertyMap.put(property.getProperty_id(),property);
        Property savedP = propertyMap.get(property.getProperty_id());
        return savedP;
    }

    @Override
    public Property update(Property property) {
        propertyMap.put(property.getProperty_id(),property);
        Property savedP = propertyMap.get(property.getProperty_id());
        return savedP;
    }

    @Override
    public void delete(String s) {
        propertyMap.remove(s);
    }

    @Override
    public Property read(String s) {
        Property flat= propertyMap.get(s);
        return flat;
    }
}
