package nascimento.patrick.devops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nascimento.patrick.devops.model.Bakery;
import nascimento.patrick.devops.service.BakeryService;

@RestController
public class PadariaController {

	@Autowired
	BakeryService padariaService;

	@GetMapping("/bakeries")
	public List<Bakery> getBakeries() {

		return padariaService.getAllBakeries();

	}

	@PostMapping("/insertbakery")
	public void insertBakery(@RequestBody Bakery bakery) {
		padariaService.insertBakery(bakery);
	}

}
