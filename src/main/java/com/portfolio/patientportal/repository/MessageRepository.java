package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Doctor;
import com.portfolio.patientportal.model.Message;
import com.portfolio.patientportal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySender(Patient sender);

    List<Message> findByReceiver(Doctor sender);

    List<Message> findBySentDate(LocalDateTime sentDate);

    List<Message> findByUpdateDate(LocalDateTime updateDate);
}
