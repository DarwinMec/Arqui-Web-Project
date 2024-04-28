package com.upc.tp_yapay.DTO;

import com.upc.tp_yapay.Entities.Customer;
import com.upc.tp_yapay.Entities.MicroEmployer;
import com.upc.tp_yapay.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOUser {
    private Long user_id;
    private String username;
    private String password;
    private Boolean enabled;

    private List<Role> roles;

}
