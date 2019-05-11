package property.tenant.manegement.service.property.impl;

import property.tenant.manegement.domain.property.PropertyRooms;
import property.tenant.manegement.repository.property.PropertyRoomsRepository;
import property.tenant.manegement.repository.property.impl.PropertyRoomsRepositoryImpl;
import property.tenant.manegement.service.property.PropertyRoomsService;

import java.util.Set;

public class PropertyRoomsServiceImpl implements PropertyRoomsService {

    private static PropertyRoomsServiceImpl service = null;
    private PropertyRoomsRepository repository;

    private PropertyRoomsServiceImpl() {
        this.repository = PropertyRoomsRepositoryImpl.getInstance();
    }

    public static PropertyRoomsServiceImpl getService(){
        if (service == null) service = new PropertyRoomsServiceImpl();
        return service;
    }

    @Override
    public Set<PropertyRooms> getAll() {
        return this.repository.getAll();
    }

    @Override
    public PropertyRooms create(PropertyRooms propertyRooms) {
        return this.repository.create(propertyRooms);
    }

    @Override
    public PropertyRooms update(PropertyRooms propertyRooms) {
        return this.repository.update(propertyRooms);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);

    }

    @Override
    public PropertyRooms read(String s) {
        return this.repository.read(s);
    }
}
