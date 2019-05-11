package property.tenant.manegement.repository.property.impl;

import property.tenant.manegement.domain.property.PropertyRooms_Type;
import property.tenant.manegement.repository.property.PropertyRoomTypeRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PropertyRoomTypeRepositoryImpl implements PropertyRoomTypeRepository {

    private static PropertyRoomTypeRepositoryImpl repository = null;

    private Map<String, PropertyRooms_Type> propertyTypesMap;

    private PropertyRoomTypeRepositoryImpl() {
        propertyTypesMap = new HashMap<String, PropertyRooms_Type>();
    }

    public static PropertyRoomTypeRepositoryImpl  getInstance(){
        if(repository == null) repository = new PropertyRoomTypeRepositoryImpl();
        return repository;
    }


    @Override
    public Set<PropertyRooms_Type> getAll() {
        return null;
    }

    @Override
    public PropertyRooms_Type create(PropertyRooms_Type propertyRooms_type) {
        propertyTypesMap.put(propertyRooms_type.getUnit_type_name(),propertyRooms_type);
        PropertyRooms_Type savedA = propertyTypesMap.get(propertyRooms_type.getUnit_type_name());
        return savedA;
    }

    @Override
    public PropertyRooms_Type update(PropertyRooms_Type propertyRooms_type) {
        propertyTypesMap.put(propertyRooms_type.getUnit_type_name(),propertyRooms_type);
        PropertyRooms_Type savedA = propertyTypesMap.get(propertyRooms_type.getUnit_type_name());
        return savedA;
    }

    @Override
    public void delete(String s) {
        propertyTypesMap.remove(s);

    }

    @Override
    public PropertyRooms_Type read(String s) {
        PropertyRooms_Type savedA = propertyTypesMap.get(s);
        return savedA;
    }
}
