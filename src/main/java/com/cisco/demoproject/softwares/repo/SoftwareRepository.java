package com.cisco.demoproject.softwares.repo;

import com.cisco.demoproject.softwares.pojo.Softwares;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SoftwareRepository extends MongoRepository<Softwares,String> {
    List<Softwares> findBySoftwareName(String softwareName);
    List<Softwares> findAll();
    Softwares findBySoftwareId(String softwareId);

}
