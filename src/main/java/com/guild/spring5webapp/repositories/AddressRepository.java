package com.guild.spring5webapp.repositories;

import com.guild.spring5webapp.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
