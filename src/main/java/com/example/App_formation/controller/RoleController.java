package com.example.App_formation.controller;


import com.example.App_formation.entities.Role;
import com.example.App_formation.entities.User;
import com.example.App_formation.repository.RoleRepository;
import com.example.App_formation.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
    private static final Logger logger = LogManager.getLogger(RoleController.class);
    @Autowired
    RoleRepository roleRep;

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        List<Role> roless = roleRep.findAll();
        return roless;
    }

    @PostMapping("/addrole")
    public Role createUser(@Valid @RequestBody Role role) {
        return roleRep.save(role);
    }
    @DeleteMapping("/deleterole/{role_id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "role_id") Long roleid) {
        Role role = roleRep.findById(roleid).orElseThrow(null);
        roleRep.delete(role);
        return ResponseEntity.ok().build();
    }
}
