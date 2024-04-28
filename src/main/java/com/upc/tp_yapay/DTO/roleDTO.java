package com.upc.tp_yapay.DTO;

import com.upc.tp_yapay.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class roleDTO {
    private Long id;

    private String rol;

    private User user;
}
