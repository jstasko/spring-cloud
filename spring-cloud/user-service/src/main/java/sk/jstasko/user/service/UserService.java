package sk.jstasko.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sk.jstasko.user.entity.User;
import sk.jstasko.user.repository.UserRepository;
import sk.jstasko.user.valueObjects.Department;
import sk.jstasko.user.valueObjects.ResponseTemplate;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return this.userRepository.save(user);
    }


    public ResponseTemplate getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplate responseTemplate = new ResponseTemplate();
        User user = this.userRepository.findUserByUserId(userId);
        Department department = this.restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
                Department.class
        );

        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);

        return responseTemplate;
    }
}
