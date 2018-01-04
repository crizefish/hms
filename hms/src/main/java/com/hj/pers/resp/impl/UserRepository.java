package com.hj.pers.resp.impl;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.hj.pers.entites.impl.User;
import com.hj.pers.pojo.Common;
import com.hj.pers.resp.BaseRepository;

public interface UserRepository extends BaseRepository<User, Long> {

	User findByUserName(String userName);

	@Query(value = "select * from ("
			+ "(SELECT r.title ,r.id,r.create_date as date ,r.create_by as authorId,\"java类库\" as type  FROM resource r ORDER BY r.top_num limit 2)"
			+ "UNION All"
			+ "(SELECT b.title ,b.id,b.create_date as date ,b.create_by as authorId, \"技术博客\" as type FROM blogger b  ORDER BY b.top_num limit 2)"
			+ "UNION All"
			+ "(SELECT n.title ,n.id,n.create_date as date ,n.create_by as authorId, \"随谈杂记\" as type FROM note n  ORDER BY n.top_num limit 2)"
			+ ") as Common", nativeQuery = true)
	List<Common> topInfo();
	
	@Query(value = "select * from ("
			+ "(SELECT r.title ,r.id,r.create_date as date ,r.create_by as authorId,\"java类库\" as type  FROM resource r ORDER BY r.read_num limit 2)"
			+ "UNION All"
			+ "(SELECT b.title ,b.id,b.create_date as date ,b.create_by as authorId, \"技术博客\" as type FROM blogger b  ORDER BY b.read_num limit 2)"
			+ "UNION All"
			+ "(SELECT n.title ,n.id,n.create_date as date ,n.create_by as authorId, \"随谈杂记\" as type FROM note n  ORDER BY n.read_num limit 2)"
			+ ") as Common", nativeQuery = true)
	List<Common> hotInfo();
}
