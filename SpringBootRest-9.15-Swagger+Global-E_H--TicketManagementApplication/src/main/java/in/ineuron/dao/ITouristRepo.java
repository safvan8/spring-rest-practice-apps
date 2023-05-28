package in.ineuron.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.ineuron.model.Tourist;

public interface ITouristRepo extends PagingAndSortingRepository<Tourist, Integer> {

}
