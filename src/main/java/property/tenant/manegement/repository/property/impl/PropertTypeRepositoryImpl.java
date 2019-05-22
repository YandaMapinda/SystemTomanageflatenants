package property.tenant.manegement.repository.property.impl;

import org.springframework.stereotype.Repository;
import property.tenant.manegement.domain.property.Property_Types;
import property.tenant.manegement.repository.property.PropertTypeRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository("InPropertTypeMemory")
public class PropertTypeRepositoryImpl implements PropertTypeRepository {

    private static PropertTypeRepositoryImpl repository = null;

    private Map<String, Property_Types> propertyTypesMap;

    private PropertTypeRepositoryImpl() {
        propertyTypesMap = new HashMap<String, Property_Types>();
    }

    public static PropertTypeRepositoryImpl  getInstance(){
        if(repository == null) repository = new PropertTypeRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Property_Types> getAll() {
        return null;
    }

    @Override
    public Property_Types create(Property_Types property_types) {
        propertyTypesMap.put(property_types.getProperty_type_name(),property_types);
        Property_Types savedA = propertyTypesMap.get(property_types.getProperty_type_name());
        return savedA;
    }

    @Override
    public Property_Types update(Property_Types property_types) {
        propertyTypesMap.put(property_types.getProperty_type_name(),property_types);
        Property_Types savedA = propertyTypesMap.get(property_types.getProperty_type_name());
        return savedA;
    }

    @Override
    public void delete(String s) {
        propertyTypesMap.remove(s);

    }

    @Override
    public Property_Types read(String s) {
        Property_Types savedA = propertyTypesMap.get(s);
        return savedA;
    }
}
