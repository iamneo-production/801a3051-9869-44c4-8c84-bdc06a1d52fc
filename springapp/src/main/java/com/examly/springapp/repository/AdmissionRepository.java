import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.*;

@Repository
public interface AdmissionRepository extends JpaRepository<AdmissionModel, Integer> {

}