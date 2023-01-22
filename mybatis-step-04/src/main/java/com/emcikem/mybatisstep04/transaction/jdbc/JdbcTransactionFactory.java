package com.emcikem.mybatisstep04.transaction.jdbc;

import com.emcikem.mybatisstep04.session.TransactionIsolationLevel;
import com.emcikem.mybatisstep04.transaction.Transaction;
import com.emcikem.mybatisstep04.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author Emcikem
 * @create 2023/1/2
 * @desc JdbcTransaction 工厂
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
