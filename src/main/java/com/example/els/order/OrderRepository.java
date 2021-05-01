package com.example.els.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


//     @Query("select new com.example.els.order.OrderDetailsDto(o.id, s.firstName, s.lastName, r.firstName, r.lastName, o.description, count(p.id), count(sh.id))"//, isnull(count(p.id), 0)
//     +"from Order o "
//        +"left join Customer s on o.sender.id = s.id " 
//        +"left join Customer r on o.receiver.id = r.id "
//        +"left join Package p on o.id = p.order.id "
//        +"left join o.shipments sh "
//        +"group by o.id ")
//    List<OrderDetailsDto> findAllOrderDetails();


@Query("select new com.example.els.order.OrderDetailsDto(o.id, s.firstName, s.lastName, r.firstName, r.lastName, o.description, count( DISTINCT p.id), count( DISTINCT sh.id))"//, isnull(count(p.id), 0)
+"from Order o "
   +"left join o.sender s " 
   +"left join o.receiver r "
   +"left join o.packages p "
   +"left join o.shipments sh "
 +"group by o.id ")
List<OrderDetailsDto> findAllOrderDetails();




}