package com.liang.chapter2.service;

import com.liang.chapter2.helper.DatabaseHelper;
import com.liang.chapter2.model.Customer;
import com.liang.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by liangz on 2015/12/25.
 * 提供客户数据服务
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     *
     */
    public List<Customer> getCustomerList(){
        String sql = "select * from customer";
        LOGGER.info("Select Customer List Sql: " + sql);
        return DatabaseHelper.queryEntityList(Customer.class, sql);
        /**
         * Simple QueryRunner Query
         */
        /*
        Connection conn = DatabaseHelper.getConnection();
        try {
            String sql = "select * from customer";
            return DatabaseHelper.queryEntityList(conn, Customer.class, sql);
        } finally {
            DatabaseHelper.closeConnection();
        }
        */
        /**
         * JDBC
         */
        /*
        Connection conn = null;
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            String sql = "select * from customer";
            conn = DatabaseHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
            LOGGER.error("execute sql failure", e);
        } finally {
            DatabaseHelper.closeConnection(conn);
        }
        return customerList;
        */
    }

    /**
     * 获取客户列表
     *
     */
    public List<Customer> getCustomerList(String keyword){
        // TODO
        return null;
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id){
        String sql = "select * from customer where id=?";
        Object[] params = {id};
        return DatabaseHelper.queryEntity(Customer.class, sql, params);
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap){
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }

}
