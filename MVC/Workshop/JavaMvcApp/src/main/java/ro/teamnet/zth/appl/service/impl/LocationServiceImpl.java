package ro.teamnet.zth.appl.service.impl;

import ro.teamnet.zth.api.annotations.MyService;
import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Location;
import ro.teamnet.zth.appl.service.LocationService;

import java.util.List;

/**
 * Created by user on 7/15/2016.
 */
@MyService
public class LocationServiceImpl implements LocationService {
    public List<Location> findAllLocations() {
        LocationDao loc = new LocationDao();
        return loc.getAllLocations();
    }
}
