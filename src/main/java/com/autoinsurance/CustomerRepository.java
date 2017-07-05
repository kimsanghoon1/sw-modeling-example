package com.autoinsurance;

import org.metaworks.multitenancy.persistence.MultitenantRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by uengine on 2017. 7. 3..
 */
@RepositoryRestResource(collectionResourceRel = "customer", path="customer")
public interface CustomerRepository extends MultitenantRepository<Customer, Long> {
}
