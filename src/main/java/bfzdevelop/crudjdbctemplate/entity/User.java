package bfzdevelop.crudjdbctemplate.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    public int id;
    public String username;
    public String email;

}
