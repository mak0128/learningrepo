package com.manojkk.learning.cardweb.jpa.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.manojkk.learning.cardweb.jpa.entity.UserCards;

public interface UserCardRepository extends JpaRepository<UserCards, Long> {
	@Query(value="select cd.card_no, cd.card_typ, cd.card_exp, cd.sec_cd from card_details as cd join user_card_details ucd on cd.card_no=ucd.card_no where ucd.username=?1", nativeQuery=true)
	public List<Object[]> findByUsername(String username);
}
