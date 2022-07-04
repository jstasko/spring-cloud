package sk.jstasko.user.valueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.jstasko.user.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {
    private User user;
    private Department department;
}
