package com.Pranav.Backend.Repository;

import com.Pranav.Backend.Model.StateData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Repository
public interface StateDataRepository extends JpaRepository<StateData,Long> {

 LocalDate localdate=LocalDate.now();
    @Query(value = "select active,confirmed,recovered,deaths,name from state_data where local_date=?1",nativeQuery=true)
    List<Map<String,Object>> getData(LocalDate localdate);

}
