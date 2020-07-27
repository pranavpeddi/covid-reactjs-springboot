package com.Pranav.Backend.Repository;

import com.Pranav.Backend.Model.StateData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StateDataRepository extends JpaRepository<StateData,Long> {
}
