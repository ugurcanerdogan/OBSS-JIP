package tr.com.obss.ji.springdemo.cache;

import java.util.Map;

import tr.com.obss.ji.springdemo.model.dto.UserDTO;

public interface UserCache {

	void put(String username, UserDTO userDTO);

	Map<String, UserDTO> getMap();

}
