package com.emcikem.mybatisstep04.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Emcikem
 * @create 2023/1/2
 * @desc 事务接口
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
