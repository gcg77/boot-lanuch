package com.boot.bootlanuch.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendPO {
    private String name;
    private Integer age;
}
