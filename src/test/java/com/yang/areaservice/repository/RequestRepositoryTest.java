package com.yang.areaservice.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yang.areaservice.data.Request;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
@TestPropertySource(locations="classpath:application-test.properties")
class RequestRepositoryTest {

	@Autowired
	private RequestRepository repository;
	
	static final String FEATURE_ID = "WHSE_ADMIN_BOUNDARIES.BCHA_CMNTY_HEALTH_SERV_AREA_SP.120";
	final static String COORDINATE = "-123.3646335+48.4251378";
	
	@Test
	void test() {
		Date date = new Date();

 		Request request = new Request();
		request.setFeatureid(FEATURE_ID);
		request.setCoordinate(COORDINATE);
		request.setRequesttime(new Timestamp(date.getTime()));

		repository.save(request);
		Request saved = repository.findById(request.getId()).get();
		assertEquals(FEATURE_ID, saved.getFeatureid());
		
	}

}
