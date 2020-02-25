package com.cisco.demoproject.softwares.service;

import com.cisco.demoproject.softwares.pojo.Softwares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.cisco.demoproject.softwares.repo.SoftwareRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class SoftwareService {
//    @Autowired
//    private MongoTemplate mongoTemplate;

    @Autowired
    private SoftwareRepository swRepo;

    public List<Softwares> findByName(String softwareName){
//        return swRepo.findAll();
        return swRepo.findBySoftwareName(softwareName);
//        Query query = new Query();
//        query.addCriteria(Criteria.where("softwareName").is(softwareName));
//        return mongoTemplate.find(query, Software.class);
    }
    public List<Softwares> find(){
        System.out.println(swRepo.findAll());
        return swRepo.findAll();
    }

    public Softwares findObject(String softwareId){
        return swRepo.findBySoftwareId(softwareId);
    }

    public Softwares updateViews(String softwareId){
        Softwares sw = findObject(softwareId);
        System.out.println(sw);
        sw.setViews((int) (sw.getViews()+1));
        return swRepo.save(sw);
    }
}
