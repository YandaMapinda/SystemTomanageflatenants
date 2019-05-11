package property.tenant.manegement.service.property.impl;

import property.tenant.manegement.domain.property.PropertyRooms_Type;
import property.tenant.manegement.repository.property.PropertyRoomTypeRepository;
import property.tenant.manegement.repository.property.impl.PropertyRoomTypeRepositoryImpl;
import property.tenant.manegement.service.property.PropertyRoomTypeService;

import java.util.Set;

public class PropertyRoomTypeServiceImpl implements PropertyRoomTypeService {

    private static PropertyRoomTypeServiceImpl service = null;
    private PropertyRoomTypeRepository repository;

    private PropertyRoomTypeServiceImpl() {
        this.repository = PropertyRoomTypeRepositoryImpl.getInstance();
    }

    public static PropertyRoomTypeServiceImpl getService(){
        if (service == null) service = new PropertyRoomTypeServiceImpl();
        return service;
    }

    @Override
    public Set<PropertyRooms_Type> getAll() {
        return this.repository.getAll();
    }

    @Override
    public PropertyRooms_Type create(PropertyRooms_Type propertyRooms_type) {
        return this.repository.create(propertyRooms_type);
    }

    @Override
    public PropertyRooms_Type update(PropertyRooms_Type propertyRooms_type) {
        return this.repository.update(propertyRooms_type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public PropertyRooms_Type read(String s) {
        return this.repository.read(s);
    }
}
