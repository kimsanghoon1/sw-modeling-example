package com.autoinsurance;

import org.metaworks.multitenancy.persistence.MultitenantRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by uengine on 2017. 7. 3..
 */
@RepositoryRestResource(collectionResourceRel = "vehicle", path="vehicle")
public interface VehicleRepository extends MultitenantRepository<Vehicle, Long>{
}
