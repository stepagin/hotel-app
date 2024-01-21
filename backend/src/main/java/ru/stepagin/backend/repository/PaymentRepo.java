package ru.stepagin.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import ru.stepagin.backend.entity.PaymentEntity;

import java.util.List;

public interface PaymentRepo extends JpaRepository<PaymentEntity, Long> {
    @Query("select p from PaymentEntity p where p.reservation.id = ?1")
    List<PaymentEntity> getAllReservationPayments(@NonNull Long id);

    @Query("select p from PaymentEntity p where p.reservation.person.id = ?1 order by p.creationDate asc ")
    List<PaymentEntity> getAllPersonPayments(@NonNull Long personId);


}
