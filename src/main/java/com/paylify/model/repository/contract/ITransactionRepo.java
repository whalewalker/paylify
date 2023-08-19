package com.paylify.model.repository.contract;

import com.paylify.model.data.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepo extends JpaRepository<Transaction, Long> {
}
