package com.boot.bootlanuch.model.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class ReadInfo {
    private String name;
    private String age;

}
