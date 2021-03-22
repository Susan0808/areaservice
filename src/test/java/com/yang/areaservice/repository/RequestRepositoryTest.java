package com.yang.areaservice.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.yang.areaservice.data.Request;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RequestRepositoryTest {

	@Autowired
	MockMvc mvc;
	
	@Autowired 
	RequestRepository requestRepository;
	
	static final String FEATURE_ID = "WHSE_ADMIN_BOUNDARIES.BCHA_CMNTY_HEALTH_SERV_AREA_SP.120";
	final static String Coordinate = "-123.3646335+48.4251378";
	
	@Test
	void test() {
		Date date = new Date();
		
		Request request = new Request();
		request.setFeatureid(FEATURE_ID);
		request.setCoordinate(Coordinate);
		request.setRequesttime(new Timestamp(date.getTime()));
		
		requestRepository.save(request);

		assertNotNull(request.getId());
	}

}
