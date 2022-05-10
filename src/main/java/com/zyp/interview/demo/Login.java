package com.zyp.interview.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/18 14:50
 */
@Table(name = "login")
@Data
@NoArgsConstructor
public class Login {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 统一社会信用代码
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 异议明细ID
     */
    @Column(name = "client_id")
    private Integer clientId;

    /**
     * 政策编号（区域编号_序号，340200_002）
     */
    @Column(name = "date")
    private Date date;


}
