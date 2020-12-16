package com.boot.bootlanuch.model.vo;

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
public class FriendVO {
    private String name;
    private String age;
}
