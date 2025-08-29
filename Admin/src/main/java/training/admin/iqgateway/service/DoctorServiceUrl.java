package training.admin.iqgateway.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import training.admin.iqgateway.dto.DoctorDTO;
import training.admin.iqgateway.dto.DoctorDTO.ReviewDTO;

@Service
public class DoctorServiceUrl {
	
	@Value("${doctor.service.url}")
	private String doctorServiceUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	 // CREATE
    public DoctorDTO createDoctor(DoctorDTO doctor) {
        return restTemplate.postForObject(
            doctorServiceUrl, doctor, DoctorDTO.class
        );
    }

    // READ single
    public DoctorDTO getDoctorById(String id) {
        String url = doctorServiceUrl + "/" + id;
        return restTemplate.getForObject(url, DoctorDTO.class);
    }

    // READ all
    public List<DoctorDTO> getAllDoctors() {
        ResponseEntity<DoctorDTO[]> response = restTemplate.getForEntity(doctorServiceUrl, DoctorDTO[].class);
        return Arrays.asList(response.getBody());
    }

    // UPDATE
    public DoctorDTO updateDoctor(String id, DoctorDTO doctor) {
        String url = doctorServiceUrl + "/" + id;
        HttpEntity<DoctorDTO> requestUpdate = new HttpEntity<>(doctor);
        ResponseEntity<DoctorDTO> response =
            restTemplate.exchange(url, HttpMethod.PUT, requestUpdate, DoctorDTO.class);
        return response.getBody();
    }

    // DELETE
    public void deleteDoctor(String id) {
        String url = doctorServiceUrl + "/" + id;
        restTemplate.delete(url);
    }

    // Example: addReview (if exposed)
    public DoctorDTO addReview(String doctorId, ReviewDTO review) {
        String url = doctorServiceUrl + "/" + doctorId + "/reviews";
        // Assuming the Doctor microservice exposes POST doctor/{id}/reviews
        return restTemplate.postForObject(url, review, DoctorDTO.class);
    }

}
