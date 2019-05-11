package property.tenant.manegement.repository.property.impl;

import property.tenant.manegement.domain.property.PropertyRooms;
import property.tenant.manegement.repository.property.PropertyRoomsRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PropertyRoomsRepositoryImpl implements PropertyRoomsRepository {

    private static PropertyRoomsRepositoryImpl repository = null;

    private Map<String, PropertyRooms> propertyTypesMap;

    private PropertyRoomsRepositoryImpl() {
        propertyTypesMap = new HashMap<String, PropertyRooms>();
    }

    public static PropertyRoomsRepositoryImpl  getInstance(){
        if(repository == null) repository = new PropertyRoomsRepositoryImpl();
        return repository;
    }

    @Override
    public Set<PropertyRooms> getAll() {
        return null;
    }

    @Override
    public PropertyRooms create(PropertyRooms propertyRooms) {
        propertyTypesMap.put(propertyRooms.getProperty_id(),propertyRooms);
        PropertyRooms savedA = propertyTypesMap.get(propertyRooms.getProperty_id());
        return savedA;
    }

    @Override
    public PropertyRooms update(PropertyRooms propertyRooms) {
        propertyTypesMap.put(propertyRooms.getProperty_id(),propertyRooms);
        PropertyRooms savedA = propertyTypesMap.get(propertyRooms.getProperty_id());
        return savedA;
    }

    @Override
    public void delete(String s) {
        propertyTypesMap.remove(s);

    }

    @Override
    public PropertyRooms read(String s) {
        PropertyRooms savedA = propertyTypesMap.get(s);
        return savedA;
    }
}
