package kz.bitlab.SpringTask.repositories;

import kz.bitlab.SpringTask.objects.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item,Long> {
 Item findAllById(Long id);
}
